package br.com.davi.chiquinhomaquinas.dao;

import br.com.davi.chiquinhomaquinas.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao extends Dao {

    private String SQL_LOGIN = " SELECT * FROM tbusuario WHERE LOGIN = ? AND SENHA = ? ";

    public Usuario login(String login, String senha) throws DaoException {
        Usuario sRet = null;

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            ps = conn.prepareStatement(SQL_LOGIN);
            ps.setString(1, login);
            ps.setString(2, senha);

            rs = ps.executeQuery();

            if (rs.next()) {
                sRet = getUsuarioFromRs(rs);
            }
        } catch (Exception e) {
            throw new DaoException("Erro UsuarioDao.login(" + login + "): - " + e.getClass().getName() + " - " + e.getMessage(), e);
        } finally {
            close(conn, ps, rs);
        }
        return sRet;
    }

    private Usuario getUsuarioFromRs(ResultSet rs) throws DaoException {
        Usuario u = new Usuario();
        try {
            u.setCDUSUARIO(rs.getInt("CDUSUARIO"));
            u.setLOGIN(rs.getString("LOGIN"));
            u.setSENHA(rs.getString("SENHA"));
        } catch (Exception e) {
            throw new DaoException("Erro UsuarioDao.getUsuarioFromRs - " + e.getClass().getName() + " - " + e.getMessage(), e);
        }
        return u;
    }
}
