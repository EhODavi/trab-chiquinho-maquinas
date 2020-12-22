package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.ClienteFisico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteFisicoDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbclientefisico (CDPESSOA, CPF) VALUES (?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT p.*, cf.CPF FROM tbpessoa p, tbclientefisico cf WHERE p.CDPESSOA = cf.CDPESSOA AND p.CDPESSOA = ? ";

    private String SQL_CONSULTAR_TODOS = " SELECT p.*, cf.CPF FROM tbpessoa p, tbclientefisico cf WHERE p.CDPESSOA = cf.CDPESSOA ";

    private String SQL_EXCLUIR = " DELETE FROM tbclientefisico WHERE CDPESSOA = ? ";

    private String SQL_ALTERAR = " UPDATE tbclientefisico SET CPF = ? WHERE CDPESSOA = ? ";

    private String SQL_CONSULTAR_POR_NOME = " SELECT p.*, cf.CPF FROM tbpessoa p, tbclientefisico cf WHERE p.CDPESSOA = cf.CDPESSOA AND NOME LIKE ? ";

    private String SQL_CONSULTAR_POR_INADIMPLENCIA = " SELECT p.*, cf.CPF, SUM(s.PRECOTOTAL) AS TOTAL FROM tbpessoa p, tbclientefisico cf, tbservico s WHERE p.CDPESSOA = cf.CDPESSOA AND s.CDPESSOAFK = p.CDPESSOA AND s.SITUACAO = 'N' GROUP BY p.NOME ";

    public int inserir(ClienteFisico cf) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cf.getCDPESSOA());
            ps.setString(2, cf.getCPF());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.inserir(" + cf.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
    }

    public ClienteFisico consultarPorId(int id) throws DaoException {
        ClienteFisico cfRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                cfRet = getClienteFisicoFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.consultarPorId(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return cfRet;
    }

    private ClienteFisico getClienteFisicoFromRs(ResultSet rs) throws DaoException {
        ClienteFisico cf = new ClienteFisico();
        try {
            cf.setCDPESSOA(rs.getInt("CDPESSOA"));
            cf.setNOME(rs.getString("NOME"));
            cf.setENDERECO(rs.getString("ENDERECO"));
            cf.setTELEFONE(rs.getString("TELEFONE"));
            cf.setEMAIL(rs.getString("EMAIL"));
            cf.setCPF(rs.getString("CPF"));
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.getClienteFisicoFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return cf;
    }

    public List<ClienteFisico> consultarTodos() throws DaoException {
        List<ClienteFisico> cfList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteFisico cf = getClienteFisicoFromRs(rs);
                cfList.add(cf);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.consultarTodos - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return cfList;
    }

    public void excluir(int id) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, id);
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(ClienteFisico cf) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, cf.getCPF());
            ps.setInt(2, cf.getCDPESSOA());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.alterar(" + cf.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public List<ClienteFisico> consultarPorNome(String nome) throws DaoException {
        List<ClienteFisico> cfList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteFisico cf = getClienteFisicoFromRs(rs);
                cfList.add(cf);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.consultarPorNome(" + nome + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return cfList;
    }

    private double getTotalFromRs(ResultSet rs) throws DaoException {
        double total = 0;
        try {
            total = rs.getDouble("TOTAL");
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.getTotalFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return total;
    }

    public String[][] consultarPorInadimplencia() throws DaoException {
        List<ClienteFisico> cfList = new ArrayList();
        List<Double> totalList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_INADIMPLENCIA);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteFisico cf = getClienteFisicoFromRs(rs);
                cfList.add(cf);
                double total = getTotalFromRs(rs);
                totalList.add(total);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteFisicoDao.consultarPorInadimplencia - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        String[][] strCFTMat = new String[cfList.size()][7];
        for (int i = 0; i < cfList.size(); i++) {
            ClienteFisico cf = cfList.get(i);
            Double total = totalList.get(i);
            strCFTMat[i][0] = Integer.toString(cf.getCDPESSOA());
            strCFTMat[i][1] = cf.getNOME();
            strCFTMat[i][2] = cf.getENDERECO();
            strCFTMat[i][3] = cf.getTELEFONE();
            strCFTMat[i][4] = cf.getEMAIL();
            strCFTMat[i][5] = cf.getCPF();
            strCFTMat[i][6] = Double.toString(total.doubleValue());
        }
        return strCFTMat;
    }
}
