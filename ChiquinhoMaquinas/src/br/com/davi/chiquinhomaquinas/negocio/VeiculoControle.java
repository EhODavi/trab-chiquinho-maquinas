package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.VeiculoDao;
import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Veiculo;

import java.util.List;

public class VeiculoControle {

    VeiculoDao vDao = new VeiculoDao();

    public int inserir(Veiculo v) throws DaoException {
        int k;
        k = vDao.inserir(v);
        return k;
    }

    public List<Veiculo> consultarTodos() throws DaoException {
        return vDao.consultarTodos();
    }

    public Veiculo consultarPorId(int id) throws DaoException {
        return vDao.consultarPorId(id);
    }

    public List<Veiculo> consultarPorNome(String nome) throws DaoException {
        return vDao.consultarPorNome(nome);
    }

    public void excluir(int id) throws DaoException {
        vDao.excluir(id);
    }

    public void alterar(Veiculo v) throws DaoException {
        vDao.alterar(v);
    }
    
    public List<Veiculo> consultarPorNomeOrdenado(String nome) throws DaoException {
        return vDao.consultarPorNomeOrdenado(nome);
    }
    
    public List<Veiculo> consultarPorNomeETipo(String nome, String tipo) throws DaoException {
        return vDao.consultarPorNomeETipo(nome, tipo);
    }
}
