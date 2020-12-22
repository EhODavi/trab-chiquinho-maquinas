package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.dao.TipoDespesaDao;
import br.com.davi.chiquinhomaquinas.entidade.TipoDespesa;

import java.util.List;

public class TipoDespesaControle {

    TipoDespesaDao tdDao = new TipoDespesaDao();

    public int inserir(TipoDespesa td) throws DaoException {
        int k;
        k = tdDao.inserir(td);
        return k;
    }

    public List<TipoDespesa> consultarTodos() throws DaoException {
        return tdDao.consultarTodos();
    }

    public TipoDespesa consultarPorId(int id) throws DaoException {
        return tdDao.consultarPorId(id);
    }

    public List<TipoDespesa> consultarPorNome(String nome) throws DaoException {
        return tdDao.consultarPorNome(nome);
    }

    public void excluir(int id) throws DaoException {
        tdDao.excluir(id);
    }

    public void alterar(TipoDespesa td) throws DaoException {
        tdDao.alterar(td);
    }
    
    public List<TipoDespesa> consultarPorNomeOrdenado(String nome) throws DaoException {
        return tdDao.consultarPorNomeOrdenado(nome);
    }
    
    public List<TipoDespesa> consultarPorNomeEDestino(String nome, String destino) throws DaoException {
        return tdDao.consultarPorNomeEDestino(nome, destino);
    }
}
