package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.ClienteJuridico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteJuridicoDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbclientejuridico (CDPESSOA, CNPJ, INSCRICAOESTADUAL) VALUES (?,?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT p.*, cj.CNPJ, cj.INSCRICAOESTADUAL FROM tbpessoa p, tbclientejuridico cj WHERE p.CDPESSOA = cj.CDPESSOA AND p.CDPESSOA = ? ";

    private String SQL_CONSULTAR_TODOS = " SELECT p.*, cj.CNPJ, cj.INSCRICAOESTADUAL FROM tbpessoa p, tbclientejuridico cj WHERE p.CDPESSOA = cj.CDPESSOA ";

    private String SQL_EXCLUIR = " DELETE FROM tbclientejuridico WHERE CDPESSOA = ? ";

    private String SQL_ALTERAR = " UPDATE tbclientejuridico SET CNPJ = ?, INSCRICAOESTADUAL = ? WHERE CDPESSOA = ? ";

    private String SQL_CONSULTAR_POR_NOME = " SELECT p.*, cj.CNPJ, cj.INSCRICAOESTADUAL FROM tbpessoa p, tbclientejuridico cj WHERE p.CDPESSOA = cj.CDPESSOA AND NOME LIKE ? ";

    private String SQL_CONSULTAR_POR_INADIMPLENCIA = " SELECT p.*, cj.CNPJ, cj.INSCRICAOESTADUAL, SUM(s.PRECOTOTAL) AS TOTAL FROM tbpessoa p, tbclientejuridico cj, tbservico s WHERE p.CDPESSOA = cj.CDPESSOA AND s.CDPESSOAFK = p.CDPESSOA AND s.SITUACAO = 'N' GROUP BY p.NOME ";

    public int inserir(ClienteJuridico cj) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cj.getCDPESSOA());
            ps.setString(2, cj.getCNPJ());
            ps.setString(3, cj.getINSCRICAOESTADUAL());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.inserir(" + cj.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
    }

    public ClienteJuridico consultarPorId(int id) throws DaoException {
        ClienteJuridico cjRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                cjRet = getClienteJuridicoFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.consultarPorId(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return cjRet;
    }

    private ClienteJuridico getClienteJuridicoFromRs(ResultSet rs) throws DaoException {
        ClienteJuridico cj = new ClienteJuridico();
        try {
            cj.setCDPESSOA(rs.getInt("CDPESSOA"));
            cj.setNOME(rs.getString("NOME"));
            cj.setENDERECO(rs.getString("ENDERECO"));
            cj.setTELEFONE(rs.getString("TELEFONE"));
            cj.setEMAIL(rs.getString("EMAIL"));
            cj.setCNPJ(rs.getString("CNPJ"));
            cj.setINSCRICAOESTADUAL(rs.getString("INSCRICAOESTADUAL"));
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.getClienteJuridicoFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return cj;
    }

    public List<ClienteJuridico> consultarTodos() throws DaoException {
        List<ClienteJuridico> cjList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteJuridico cj = getClienteJuridicoFromRs(rs);
                cjList.add(cj);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.consultarTodos - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return cjList;
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
            throw new DaoException("Erro ClienteJuridicoDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(ClienteJuridico cj) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, cj.getCNPJ());
            ps.setString(2, cj.getINSCRICAOESTADUAL());
            ps.setInt(3, cj.getCDPESSOA());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.alterar(" + cj.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public List<ClienteJuridico> consultarPorNome(String nome) throws DaoException {
        List<ClienteJuridico> cjList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteJuridico cj = getClienteJuridicoFromRs(rs);
                cjList.add(cj);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.consultarPorNome(" + nome + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return cjList;
    }

    private double getTotalFromRs(ResultSet rs) throws DaoException {
        double total = 0;
        try {
            total = rs.getDouble("TOTAL");
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.getTotalFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return total;
    }

    public String[][] consultarPorInadimplencia() throws DaoException {
        List<ClienteJuridico> cjList = new ArrayList();
        List<Double> totalList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_INADIMPLENCIA);
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteJuridico cj = getClienteJuridicoFromRs(rs);
                cjList.add(cj);
                double total = getTotalFromRs(rs);
                totalList.add(total);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ClienteJuridicoDao.consultarPorInadimplencia - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        String[][] strCFJMat = new String[cjList.size()][8];
        for (int i = 0; i < cjList.size(); i++) {
            ClienteJuridico cj = cjList.get(i);
            Double total = totalList.get(i);
            strCFJMat[i][0] = Integer.toString(cj.getCDPESSOA());
            strCFJMat[i][1] = cj.getNOME();
            strCFJMat[i][2] = cj.getENDERECO();
            strCFJMat[i][3] = cj.getTELEFONE();
            strCFJMat[i][4] = cj.getEMAIL();
            strCFJMat[i][5] = cj.getCNPJ();
            strCFJMat[i][6] = cj.getINSCRICAOESTADUAL();
            strCFJMat[i][7] = Double.toString(total.doubleValue());
        }
        return strCFJMat;
    }
}
