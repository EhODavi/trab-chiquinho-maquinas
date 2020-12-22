package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.dao.UsuarioDao;
import br.com.davi.chiquinhomaquinas.entidade.Usuario;

public class UsuarioControle {
    UsuarioDao uDao = new UsuarioDao();
    
    public Usuario login(String login, String senha) throws DaoException {
        return uDao.login(login, senha);
    }
}
