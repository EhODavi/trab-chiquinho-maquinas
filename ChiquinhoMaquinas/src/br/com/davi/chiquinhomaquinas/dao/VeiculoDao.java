package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbveiculo (TIPO, TIPOCOBRANCA, PLACA, NOME, PRECO) VALUES (?,?,?,?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT * FROM tbveiculo WHERE CDVEICULO = ? ";

    private String SQL_CONSULTAR_POR_NOME = " SELECT * FROM tbveiculo WHERE NOME LIKE ? ";

    private String SQL_CONSULTAR_TODOS = " SELECT * FROM tbveiculo ";

    private String SQL_EXCLUIR = " DELETE FROM tbveiculo WHERE CDVEICULO = ? ";

    private String SQL_ALTERAR = " UPDATE tbveiculo SET TIPO = ?, TIPOCOBRANCA = ?, PLACA = ?, NOME = ?, PRECO = ? WHERE CDVEICULO = ? ";

    private String SQL_CONSULTAR_POR_NOME_ORDENADO = " SELECT * FROM tbveiculo WHERE NOME LIKE ? ORDER BY TIPO";

    private String SQL_CONSULTAR_POR_NOME_E_TIPO = " SELECT * FROM tbveiculo WHERE NOME LIKE ? AND TIPO = ? ";

    public int inserir(Veiculo v) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, v.getTIPO());
            ps.setString(2, v.getTIPOCOBRANCA());
            ps.setString(3, v.getPLACA());
            ps.setString(4, v.getNOME());
            ps.setDouble(5, v.getPRECO());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.inserir(" + v.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
    }

    public Veiculo consultarPorId(int id) throws DaoException {
        Veiculo vRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                vRet = getVeiculoFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.consultarPorId(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return vRet;
    }

    private Veiculo getVeiculoFromRs(ResultSet rs) throws DaoException {
        Veiculo v = new Veiculo();
        try {
            v.setCDVEICULO(rs.getInt("CDVEICULO"));
            v.setTIPO(rs.getString("TIPO"));
            v.setTIPOCOBRANCA(rs.getString("TIPOCOBRANCA"));
            v.setPLACA(rs.getString("PLACA"));
            v.setNOME(rs.getString("NOME"));
            v.setPRECO(rs.getDouble("PRECO"));
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.getVeiculoFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return v;
    }

    public List<Veiculo> consultarPorNome(String nome) throws DaoException {
        List<Veiculo> vList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Veiculo v = getVeiculoFromRs(rs);
                vList.add(v);
            }
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.consultarPorNome(" + nome + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return vList;
    }

    public List<Veiculo> consultarTodos() throws DaoException {
        List<Veiculo> vList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Veiculo v = getVeiculoFromRs(rs);
                vList.add(v);
            }
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.consultarTodos - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return vList;
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
            throw new DaoException("Erro VeiculoDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(Veiculo v) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, v.getTIPO());
            ps.setString(2, v.getTIPOCOBRANCA());
            ps.setString(3, v.getPLACA());
            ps.setString(4, v.getNOME());
            ps.setDouble(5, v.getPRECO());
            ps.setInt(6, v.getCDVEICULO());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.alterar(" + v.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public List<Veiculo> consultarPorNomeOrdenado(String nome) throws DaoException {
        List<Veiculo> vList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME_ORDENADO);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Veiculo v = getVeiculoFromRs(rs);
                vList.add(v);
            }
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.consultarPorNomeOrdenado(" + nome + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return vList;
    }

    public List<Veiculo> consultarPorNomeETipo(String nome, String tipo) throws DaoException {
        List<Veiculo> vList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME_E_TIPO);
            ps.setString(1, nome + "%");
            ps.setString(2, tipo);
            rs = ps.executeQuery();
            while (rs.next()) {
                Veiculo v = getVeiculoFromRs(rs);
                vList.add(v);
            }
        } catch (Exception e) {
            throw new DaoException("Erro VeiculoDao.consultarPorNomeETipo(" + nome + " - " + tipo + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return vList;
    }
}
