package br.com.davi.chiquinhomaquinas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class Dao {

    protected final Connection getConnection() throws DaoException {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/chiquinhomaquinas",
                    "root", "");
        } catch (ClassNotFoundException e) {
            throw new DaoException("Biblioteca de acesso a dados não encontrada." + e.getClass().getName() + "-" + e.getMessage(), e);
        } catch (SQLException e) {
            throw new DaoException("Não foi possível se conectar ao banco de dados." + e.getClass().getName() + "-" + e.getMessage(), e);
        } catch (Exception e) {
            throw new DaoException("Erro geral getConnection()." + e.getClass().getName() + "-" + e.getMessage(), e);
        }
        return conn;
    }

    protected void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn, ps);
    }

    protected void close(Connection conn, PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
        close(conn);
    }

    protected void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                //nenhum tratamento a ser feito
            }
        }
    }
}
