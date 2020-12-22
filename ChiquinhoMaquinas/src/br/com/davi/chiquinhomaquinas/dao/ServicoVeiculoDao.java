package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.ServicoVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicoVeiculoDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbservicoveiculo (CDSERVICOFK, CDVEICULOFK, NUMHORASVIAGENS, PRECO) VALUES (?,?,?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT * FROM tbservicoveiculo WHERE CDSERVICOFK = ? AND CDVEICULOFK = ? ";

    private String SQL_CONSULTAR_POR_SERVICO = " SELECT * FROM tbservicoveiculo WHERE CDSERVICOFK = ? ";

    private String SQL_EXCLUIR = " DELETE FROM tbservicoveiculo WHERE CDSERVICOFK = ? AND CDVEICULOFK = ? ";

    private String SQL_ALTERAR = " UPDATE tbservicoveiculo SET CDVEICULOFK = ?, NUMHORASVIAGENS = ?, PRECO = ? WHERE CDSERVICOFK = ? AND CDVEICULOFK = ? ";

    public void inserir(ServicoVeiculo sv) throws DaoException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, sv.getCDSERVICOFK());
            ps.setInt(2, sv.getCDVEICULOFK());
            ps.setDouble(3, sv.getNUMHORASVIAGENS());
            ps.setDouble(4, sv.getPRECO());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ServicoVeiculoDao.inserir(" + sv.getCDVEICULOFK() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
    }

    public ServicoVeiculo consultarPorId(int cdservicofk, int cdveiculofk) throws DaoException {
        ServicoVeiculo svRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, cdservicofk);
            ps.setInt(2, cdveiculofk);
            rs = ps.executeQuery();

            if (rs.next()) {
                svRet = getServicoVeiculoFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoVeiculoDao.consultarPorId(" + cdveiculofk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return svRet;
    }

    private ServicoVeiculo getServicoVeiculoFromRs(ResultSet rs) throws DaoException {
        ServicoVeiculo sv = new ServicoVeiculo();
        try {
            sv.setCDSERVICOFK(rs.getInt("CDSERVICOFK"));
            sv.setCDVEICULOFK(rs.getInt("CDVEICULOFK"));
            sv.setNUMHORASVIAGENS(rs.getDouble("NUMHORASVIAGENS"));
            sv.setPRECO(rs.getDouble("PRECO"));
        } catch (Exception e) {
            throw new DaoException("Erro ServicoVeiculoDao.getServicoVeiculoFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return sv;
    }

    public List<ServicoVeiculo> consultarPorServico(int cdservicofk) throws DaoException {
        List<ServicoVeiculo> svList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_SERVICO);
            ps.setInt(1, cdservicofk);
            rs = ps.executeQuery();
            while (rs.next()) {
                ServicoVeiculo sv = getServicoVeiculoFromRs(rs);
                svList.add(sv);
            }
        } catch (Exception e) {
            throw new DaoException("Erro ServicoVeiculoDao.consultarPorServico(" + cdservicofk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return svList;
    }

    public void excluir(int cdservicofk, int cdveiculofk) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_EXCLUIR);
            ps.setInt(1, cdservicofk);
            ps.setInt(2, cdveiculofk);
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ServicoVeiculoDao.excluir(" + cdveiculofk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(ServicoVeiculo sv, int cdveiculofk) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setInt(1, sv.getCDVEICULOFK());
            ps.setDouble(2, sv.getNUMHORASVIAGENS());
            ps.setDouble(3, sv.getPRECO());
            ps.setInt(4, sv.getCDSERVICOFK());
            ps.setInt(5, cdveiculofk);
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro ServicoVeiculoDao.alterar(" + cdveiculofk + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

}
