package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.Despesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DespesaDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbdespesa (DESCRICAO, VALOR, DATA, SITUACAO, CDTIPODESPESAFK) VALUES (?,?,?,?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT * FROM tbdespesa WHERE CDDESPESA = ? ";

    private String SQL_CONSULTAR_POR_DESCRICAO = " SELECT * FROM tbdespesa WHERE DESCRICAO LIKE ? ";

    private String SQL_CONSULTAR_TODOS = " SELECT * FROM tbdespesa ";

    private String SQL_EXCLUIR = " DELETE FROM tbdespesa WHERE CDDESPESA = ? ";

    private String SQL_ALTERAR = " UPDATE tbdespesa SET DESCRICAO = ?, VALOR = ?, DATA = ?, SITUACAO = ?, CDTIPODESPESAFK = ? WHERE CDDESPESA = ? ";

    private String SQL_CONSULTAR_POR_PERIODO = " SELECT * FROM tbdespesa WHERE DATA BETWEEN ? AND ? ";
    
    private String SQL_CONSULTAR_POR_PERIODO_E_SITUACAO = " SELECT * FROM tbdespesa WHERE DATA BETWEEN ? AND ? AND SITUACAO = ?";

    public int inserir(Despesa d) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, d.getDESCRICAO());
            ps.setDouble(2, d.getVALOR());
            ps.setTimestamp(3, new java.sql.Timestamp(d.getDATA().getTime()));
            ps.setString(4, d.getSITUACAO());
            ps.setInt(5, d.getCDTIPODESPESAFK());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.inserir(" + d.getDESCRICAO() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
    }

    public Despesa consultarPorId(int id) throws DaoException {
        Despesa dRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                dRet = getDespesaFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.consultarPorId(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return dRet;
    }

    private Despesa getDespesaFromRs(ResultSet rs) throws DaoException {
        Despesa d = new Despesa();
        try {
            d.setCDDESPESA(rs.getInt("CDDESPESA"));
            d.setDESCRICAO(rs.getString("DESCRICAO"));
            d.setVALOR(rs.getDouble("VALOR"));
            d.setDATA(rs.getTimestamp("DATA"));
            d.setSITUACAO(rs.getString("SITUACAO"));
            d.setCDTIPODESPESAFK(rs.getInt("CDTIPODESPESAFK"));

        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.getDespesaFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return d;
    }

    public List<Despesa> consultarPorDescricao(String descricao) throws DaoException {
        List<Despesa> dList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_DESCRICAO);
            ps.setString(1, descricao + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Despesa d = getDespesaFromRs(rs);
                dList.add(d);
            }
        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.consultarPorDescricao(" + descricao + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return dList;
    }

    public List<Despesa> consultarTodos() throws DaoException {
        List<Despesa> dList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Despesa d = getDespesaFromRs(rs);
                dList.add(d);
            }
        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.consultarTodos - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return dList;
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
            throw new DaoException("Erro DespesaDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(Despesa d) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, d.getDESCRICAO());
            ps.setDouble(2, d.getVALOR());
            ps.setTimestamp(3, new java.sql.Timestamp(d.getDATA().getTime()));
            ps.setString(4, d.getSITUACAO());
            ps.setInt(5, d.getCDTIPODESPESAFK());
            ps.setInt(6, d.getCDDESPESA());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.alterar(" + d.getDESCRICAO() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public List<Despesa> consultarPorPeriodo(Date DtInicio, Date DtFim) throws DaoException {
        List<Despesa> dList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_PERIODO);
            ps.setTimestamp(1, new java.sql.Timestamp(DtInicio.getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(DtFim.getTime()));
            rs = ps.executeQuery();
            while (rs.next()) {
                Despesa d = getDespesaFromRs(rs);
                dList.add(d);
            }
        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.consultarPorPeriodo(" + DtInicio + " - " + DtFim + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return dList;
    }
    
    public List<Despesa> consultarPorPeriodoESituacao(Date DtInicio, Date DtFim, String situacao) throws DaoException {
        List<Despesa> dList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_PERIODO_E_SITUACAO);
            ps.setTimestamp(1, new java.sql.Timestamp(DtInicio.getTime()));
            ps.setTimestamp(2, new java.sql.Timestamp(DtFim.getTime()));
            ps.setString(3, situacao);
            rs = ps.executeQuery();
            while (rs.next()) {
                Despesa d = getDespesaFromRs(rs);
                dList.add(d);
            }
        } catch (Exception e) {
            throw new DaoException("Erro DespesaDao.consultarPorPeriodoESituacao(" + DtInicio + " - " + DtFim + " - " + situacao + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return dList;
    }

}
