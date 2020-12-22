package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbfuncionario (CDPESSOA, CPF, VALORHORA) VALUES (?,?,?) ";

    private String SQL_CONSULTAR_POR_ID = " SELECT p.*, f.CPF, f.VALORHORA FROM tbpessoa p, tbfuncionario f WHERE p.CDPESSOA = f.CDPESSOA AND p.CDPESSOA = ? ";

    private String SQL_CONSULTAR_TODOS = " SELECT p.*, f.CPF, f.VALORHORA FROM tbpessoa p, tbfuncionario f WHERE p.CDPESSOA = f.CDPESSOA ";

    private String SQL_EXCLUIR = " DELETE FROM tbfuncionario WHERE CDPESSOA = ? ";

    private String SQL_ALTERAR = " UPDATE tbfuncionario SET CPF = ?, VALORHORA = ? WHERE CDPESSOA = ? ";

    private String SQL_CONSULTAR_POR_NOME = " SELECT p.*, f.CPF, f.VALORHORA FROM tbpessoa p, tbfuncionario f WHERE p.CDPESSOA = f.CDPESSOA AND NOME LIKE ? ";

    public int inserir(Funcionario f) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, f.getCDPESSOA());
            ps.setString(2, f.getCPF());
            ps.setDouble(3, f.getVALORHORA());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro FuncionarioDao.inserir(" + f.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
    }

    public Funcionario consultarPorId(int id) throws DaoException {
        Funcionario fRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_ID);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                fRet = getFuncionarioFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro FuncionarioDao.consultarPorId(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return fRet;
    }

    private Funcionario getFuncionarioFromRs(ResultSet rs) throws DaoException {
        Funcionario f = new Funcionario();
        try {
            f.setCDPESSOA(rs.getInt("CDPESSOA"));
            f.setNOME(rs.getString("NOME"));
            f.setENDERECO(rs.getString("ENDERECO"));
            f.setTELEFONE(rs.getString("TELEFONE"));
            f.setEMAIL(rs.getString("EMAIL"));
            f.setCPF(rs.getString("CPF"));
            f.setVALORHORA(rs.getDouble("VALORHORA"));
        } catch (Exception e) {
            throw new DaoException("Erro FuncionarioDao.getFuncionarioFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return f;
    }

    public List<Funcionario> consultarTodos() throws DaoException {
        List<Funcionario> fList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_TODOS);
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario f = getFuncionarioFromRs(rs);
                fList.add(f);
            }
        } catch (Exception e) {
            throw new DaoException("Erro FuncionarioDao.consultarTodos - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return fList;
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
            throw new DaoException("Erro FuncionarioDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(Funcionario f) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, f.getCPF());
            ps.setDouble(2, f.getVALORHORA());
            ps.setInt(3, f.getCDPESSOA());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro FuncionarioDao.alterar(" + f.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public List<Funcionario> consultarPorNome(String nome) throws DaoException {
        List<Funcionario> fList = new ArrayList();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_CONSULTAR_POR_NOME);
            ps.setString(1, nome + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Funcionario f = getFuncionarioFromRs(rs);
                fList.add(f);
            }
        } catch (Exception e) {
            throw new DaoException("Erro FuncionarioDao.consultarPorNome(" + nome + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }

        return fList;
    }

}
