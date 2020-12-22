package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.ServicoFuncionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicoFuncionarioDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbservicofuncionario (CDSERVICOFK, CDPESSOAFK, NUMHORAS, VALORHORA) VALUES (?,?,?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT * FROM tbservicofuncionario WHERE CDSERVICOFK = ? AND CDPESSOAFK = ? ";

    private String SQL_CONSULTAR_POR_SERVICO = " SELECT * FROM tbservicofuncionario WHERE CDSERVICOFK = ? ";

    private String SQL_EXCLUIR = " DELETE FROM tbservicofuncionario WHERE CDSERVICOFK = ? AND CDPESSOAFK = ? ";

    private String SQL_ALTERAR = " UPDATE tbservicofuncionario SET CDPESSOAFK = ?, NUMHORAS = ?, VALORHORA = ? WHERE CDSERVICOFK = ? AND CDPESSOAFK = ? ";

    public void inserir(ServicoFuncionario sf) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sf.getCDSERVICOFK());
            ps.setInt(2, sf.getCDPESSOAFK());
            ps.setDouble(3, sf.getNUMHORAS());
            ps.setDouble(4, sf.getVALORHORA());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ServicoFuncionarioDao.inserir(" + sf.getCDPESSOAFK() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
    }

    public ServicoFuncionario consultarPorId(int cdservicofk, int cdpessoafk) throws DaoException {
        ServicoFuncionario sfRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, cdservicofk);
            ps.setInt(2, cdpessoafk);
            rs = ps.executeQuery();

            if (rs.next()) {
                sfRet = getServicoFuncionarioFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoFuncionarioDao.consultarPorId(" + cdpessoafk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return sfRet;
    }

    private ServicoFuncionario getServicoFuncionarioFromRs(ResultSet rs) throws DaoException {
        ServicoFuncionario sf = new ServicoFuncionario();
        try {
            sf.setCDSERVICOFK(rs.getInt("CDSERVICOFK"));
            sf.setCDPESSOAFK(rs.getInt("CDPESSOAFK"));
            sf.setNUMHORAS(rs.getDouble("NUMHORAS"));
            sf.setVALORHORA(rs.getDouble("VALORHORA"));
        } catch (Exception e) {
            throw new DaoException("Erro ServicoFuncionarioDao.getServicoFuncionarioFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return sf;
    }

    public List<ServicoFuncionario> consultarPorServico(int cdservicofk) throws DaoException {
        List<ServicoFuncionario> sfList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_SERVICO);
            ps.setInt(1, cdservicofk);
            rs = ps.executeQuery();
            while (rs.next()) {
                ServicoFuncionario sf = getServicoFuncionarioFromRs(rs);
                sfList.add(sf);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoFuncionarioDao.consultarPorServico(" + cdservicofk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return sfList;
    }

    public void excluir(int cdservicofk, int cdpessoafk) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cdservicofk);
            ps.setInt(2, cdpessoafk);
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ServicoFuncionarioDao.excluir(" + cdpessoafk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(ServicoFuncionario sf, int cdpessoafk) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setInt(1, sf.getCDPESSOAFK());
            ps.setDouble(2, sf.getNUMHORAS());
            ps.setDouble(3, sf.getVALORHORA());
            ps.setInt(4, sf.getCDSERVICOFK());
            ps.setInt(5, cdpessoafk);
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ServicoFuncionarioDao.alterar(" + cdpessoafk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

}
