package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoDespesaDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbtipodespesa (NOME, TIPO) VALUES (?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT * FROM tbtipodespesa WHERE CDTIPODESPESA = ? ";

    private String SQL_CONSULTAR_POR_NOME = " SELECT * FROM tbtipodespesa WHERE NOME LIKE ? ";

    private String SQL_CONSULTAR_TODOS = " SELECT * FROM tbtipodespesa ";

    private String SQL_EXCLUIR = " DELETE FROM tbtipodespesa WHERE CDTIPODESPESA = ? ";

    private String SQL_ALTERAR = " UPDATE tbtipodespesa SET NOME = ?, TIPO = ? WHERE CDTIPODESPESA = ? ";

    private String SQL_CONSULTAR_POR_NOME_ORDENADO = " SELECT * FROM tbtipodespesa WHERE NOME LIKE ? ORDER BY TIPO";

    private String SQL_CONSULTAR_POR_NOME_E_DESTINO = " SELECT * FROM tbtipodespesa WHERE NOME LIKE ? AND TIPO = ? ";

    public int inserir(TipoDespesa td) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, td.getNOME());
            ps.setString(2, td.getTIPO());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.inserir(" + td.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
    }

    public TipoDespesa consultarPorId(int id) throws DaoException {
        TipoDespesa tdRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                tdRet = getTipoDespesaFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.consultarPorId(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return tdRet;
    }

    private TipoDespesa getTipoDespesaFromRs(ResultSet rs) throws DaoException {
        TipoDespesa td = new TipoDespesa();
        try {
            td.setCDTIPODESPESA(rs.getInt("CDTIPODESPESA"));
            td.setNOME(rs.getString("NOME"));
            td.setTIPO(rs.getString("TIPO"));
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.getTipoDespesaFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return td;
    }

    public List<TipoDespesa> consultarPorNome(String nome) throws DaoException {
        List<TipoDespesa> tdList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDespesa td = getTipoDespesaFromRs(rs);
                tdList.add(td);
            }
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.consultarPorNome(" + nome + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return tdList;
    }

    public List<TipoDespesa> consultarTodos() throws DaoException {
        List<TipoDespesa> tdList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDespesa td = getTipoDespesaFromRs(rs);
                tdList.add(td);
            }
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.consultarTodos - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return tdList;
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
            throw new DaoException("Erro TipoDespesaDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(TipoDespesa td) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, td.getNOME());
            ps.setString(2, td.getTIPO());
            ps.setInt(3, td.getCDTIPODESPESA());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.alterar(" + td.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public List<TipoDespesa> consultarPorNomeOrdenado(String nome) throws DaoException {
        List<TipoDespesa> tdList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME_ORDENADO);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDespesa td = getTipoDespesaFromRs(rs);
                tdList.add(td);
            }
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.consultarPorNomeOrdenado(" + nome + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return tdList;
    }

    public List<TipoDespesa> consultarPorNomeEDestino(String nome, String destino) throws DaoException {
        List<TipoDespesa> tdList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME_E_DESTINO);
            ps.setString(1, nome + "%");
            ps.setString(2, destino);
            rs = ps.executeQuery();
            while (rs.next()) {
                TipoDespesa td = getTipoDespesaFromRs(rs);
                tdList.add(td);
            }
        } catch (Exception e) {
            throw new DaoException("Erro TipoDespesaDao.consultarPorNomeEDestino(" + nome + " - " + destino + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return tdList;
    }
}
