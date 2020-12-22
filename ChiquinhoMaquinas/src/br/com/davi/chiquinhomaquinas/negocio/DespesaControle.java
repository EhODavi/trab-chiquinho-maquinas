package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.DespesaDao;
import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Despesa;
import java.util.Date;

import java.util.List;

public class DespesaControle {

    DespesaDao dDao = new DespesaDao();

    public int inserir(Despesa d) throws DaoException {
        int k;
        k = dDao.inserir(d);
        return k;
    }

    public List<Despesa> consultarTodos() throws DaoException {
        return dDao.consultarTodos();
    }

    public Despesa consultarPorId(int id) throws DaoException {
        return dDao.consultarPorId(id);
    }

    public List<Despesa> consultarPorDescricao(String descricao) throws DaoException {
        return dDao.consultarPorDescricao(descricao);
    }

    public void excluir(int id) throws DaoException {
        dDao.excluir(id);
    }

    public void alterar(Despesa d) throws DaoException {
        dDao.alterar(d);
    }

    public List<Despesa> consultarPorPeriodo(Date DtInicio, Date DtFim) throws DaoException {
        return dDao.consultarPorPeriodo(DtInicio, DtFim);
    }
    
    public List<Despesa> consultarPorPeriodoESituacao(Date DtInicio, Date DtFim, String situacao) throws DaoException {
        return dDao.consultarPorPeriodoESituacao(DtInicio, DtFim, situacao);
    }
}
