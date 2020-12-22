package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.ServicoDao;
import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.entidade.Servico;
import java.util.Date;
import java.util.List;

public class ServicoControle {

    ServicoDao sDao = new ServicoDao();

    public int inserir(Servico s) throws DaoException {
        int k;
        k = sDao.inserir(s);
        return k;
    }

    public List<Servico> consultarTodos() throws DaoException {
        return sDao.consultarTodos();
    }

    public Servico consultarPorId(int id) throws DaoException {
        return sDao.consultarPorId(id);
    }

    public List<Servico> consultarPorDescricao(String descricao) throws DaoException {
        return sDao.consultarPorDescricao(descricao);
    }

    public void excluir(int id) throws DaoException {
        sDao.excluir(id);
    }

    public void alterar(Servico s) throws DaoException {
        sDao.alterar(s);
    }

    public List<Servico> consultarPorPeriodo(Date DtInicio, Date DtFim) throws DaoException {
        return sDao.consultarPorPeriodo(DtInicio, DtFim);
    }
    
    public List<Servico> consultarPorPeriodoESituacao(Date DtInicio, Date DtFim, String situacao) throws DaoException {
        return sDao.consultarPorPeriodoESituacao(DtInicio, DtFim, situacao);
    }

}
