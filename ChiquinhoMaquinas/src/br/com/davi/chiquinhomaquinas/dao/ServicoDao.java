package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.Servico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicoDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbservico (ENDERECO, DESCRICAO, DATAINICIO, DATAFIM, PRECOTOTAL, FORMAPAG, SITUACAO, NUMPARCELAS, DATAPAGAMENTO, CDPESSOAFK) VALUES (?,?,?,?,?,?,?,?,?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT * FROM tbservico WHERE CDSERVICO = ? ";

    private String SQL_CONSULTAR_POR_DESCRICAO = " SELECT * FROM tbservico WHERE DESCRICAO LIKE ? ";

    private String SQL_CONSULTAR_TODOS = " SELECT * FROM tbservico ";

    private String SQL_EXCLUIR = " DELETE FROM tbservico WHERE CDSERVICO = ? ";

    private String SQL_ALTERAR = " UPDATE tbservico SET ENDERECO = ?, DESCRICAO = ?, DATAINICIO = ?, DATAFIM = ?, PRECOTOTAL = ?, FORMAPAG = ?, SITUACAO = ?, NUMPARCELAS = ?, DATAPAGAMENTO = ?, CDPESSOAFK = ? WHERE CDSERVICO = ? ";

    private String SQL_CONSULTAR_POR_PERIODO = " SELECT * FROM tbservico WHERE DATAPAGAMENTO BETWEEN ? AND ? ";
    
    private String SQL_CONSULTAR_POR_PERIODO_E_SITUACAO = " SELECT * FROM tbservico WHERE DATAPAGAMENTO BETWEEN ? AND ? AND SITUACAO = ?";

    public int inserir(Servico s) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, s.getENDERECO());
            ps.setString(2, s.getDESCRICAO());
            ps.setTimestamp(3, new java.sql.Timestamp(s.getDATAINICIO().getTime()));
            ps.setTimestamp(4, new java.sql.Timestamp(s.getDATAFIM().getTime()));
            ps.setDouble(5, s.getPRECOTOTAL());
            ps.setString(6, s.getFORMAPAG());
            ps.setString(7, s.getSITUACAO());
            ps.setInt(8, s.getNUMPARCELAS());
            ps.setTimestamp(9, new java.sql.Timestamp(s.getDATAPAGAMENTO().getTime()));
            ps.setInt(10, s.getCDPESSOAFK());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.inserir(" + s.getCDSERVICO() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
    }

    public Servico consultarPorId(int id) throws DaoException {
        Servico sRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                sRet = getServicoFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.consultarPorId(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return sRet;
    }

    private Servico getServicoFromRs(ResultSet rs) throws DaoException {
        Servico s = new Servico();
        try {
            s.setCDSERVICO(rs.getInt("CDSERVICO"));
            s.setENDERECO(rs.getString("ENDERECO"));
            s.setDESCRICAO(rs.getString("DESCRICAO"));
            s.setDATAINICIO(rs.getTimestamp("DATAINICIO"));
            s.setDATAFIM(rs.getTimestamp("DATAFIM"));
            s.setPRECOTOTAL(rs.getDouble("PRECOTOTAL"));
            s.setFORMAPAG(rs.getString("FORMAPAG"));
            s.setSITUACAO(rs.getString("SITUACAO"));
            s.setNUMPARCELAS(rs.getInt("NUMPARCELAS"));
            s.setDATAPAGAMENTO(rs.getTimestamp("DATAPAGAMENTO"));
            s.setCDPESSOAFK(rs.getInt("CDPESSOAFK"));

        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.getServicoFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return s;
    }

    public List<Servico> consultarPorDescricao(String descricao) throws DaoException {
        List<Servico> sList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_DESCRICAO);
            ps.setString(1, descricao + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Servico s = getServicoFromRs(rs);
                sList.add(s);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.consultarPorDescricao(" + descricao + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return sList;
    }

    public List<Servico> consultarTodos() throws DaoException {
        List<Servico> sList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servico s = getServicoFromRs(rs);
                sList.add(s);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.consultarTodos - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return sList;
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
            throw new DaoException("Erro ServicoDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(Servico s) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, s.getENDERECO());
            ps.setString(2, s.getDESCRICAO());
            ps.setTimestamp(3, new java.sql.Timestamp(s.getDATAINICIO().getTime()));
            ps.setTimestamp(4, new java.sql.Timestamp(s.getDATAFIM().getTime()));
            ps.setDouble(5, s.getPRECOTOTAL());
            ps.setString(6, s.getFORMAPAG());
            ps.setString(7, s.getSITUACAO());
            ps.setInt(8, s.getNUMPARCELAS());
            ps.setTimestamp(9, new java.sql.Timestamp(s.getDATAPAGAMENTO().getTime()));
            ps.setInt(10, s.getCDPESSOAFK());
            ps.setInt(11, s.getCDSERVICO());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.alterar(" + s.getCDSERVICO() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public List<Servico> consultarPorPeriodo(Date DtInicio, Date DtFim) throws DaoException {
        List<Servico> sList = new ArrayList();

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
                Servico s = getServicoFromRs(rs);
                sList.add(s);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.consultarPorPeriodo(" + DtInicio + " - " + DtFim + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return sList;
    }

    public List<Servico> consultarPorPeriodoESituacao(Date DtInicio, Date DtFim, String situacao) throws DaoException {
        List<Servico> sList = new ArrayList();

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
                Servico s = getServicoFromRs(rs);
                sList.add(s);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoDao.consultarPorPeriodoESituacao(" + DtInicio + " - " + DtFim + " - " + situacao + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return sList;
    }
}
