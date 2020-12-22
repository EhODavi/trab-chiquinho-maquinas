package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PessoaDao extends Dao {

    private String SQL_INSERT = " INSERT INTO tbpessoa (NOME, ENDERECO, TELEFONE, EMAIL) VALUES (?,?,?,?) ";

    private String SQL_EXCLUIR = " DELETE FROM tbpessoa WHERE CDPESSOA = ? ";

    private String SQL_ALTERAR = " UPDATE tbpessoa SET NOME = ?, ENDERECO = ?, TELEFONE = ?, EMAIL = ? WHERE CDPESSOA = ? ";

    public int inserir(Pessoa p) throws DaoException {
        int autoNum = -1;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getNOME());
            ps.setString(2, p.getENDERECO());
            ps.setString(3, p.getTELEFONE());
            ps.setString(4, p.getEMAIL());
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                autoNum = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new DaoException("Erro PessoaDao.inserir(" + p.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return autoNum;
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
            throw new DaoException("Erro PessoaDao.excluir(" + id + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

    public void alterar(Pessoa p) throws DaoException {

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_ALTERAR);
            ps.setString(1, p.getNOME());
            ps.setString(2, p.getENDERECO());
            ps.setString(3, p.getTELEFONE());
            ps.setString(4, p.getEMAIL());
            ps.setInt(5, p.getCDPESSOA());
            ps.execute();
        } catch (Exception e) {
            throw new DaoException("Erro PessoaDao.alterar(" + p.getNOME() + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps);
        }
    }

}
