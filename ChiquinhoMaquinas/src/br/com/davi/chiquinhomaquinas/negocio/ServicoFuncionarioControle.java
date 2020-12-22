package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.dao.ServicoFuncionarioDao;
import br.com.davi.chiquinhomaquinas.entidade.ServicoFuncionario;
import java.util.List;

public class ServicoFuncionarioControle {

    ServicoFuncionarioDao sfDao = new ServicoFuncionarioDao();

    public void inserir(ServicoFuncionario sf) throws DaoException {
        sfDao.inserir(sf);
    }

    public ServicoFuncionario consultarPorId(int cdservicofk, int cdpessoafk) throws DaoException {
        return sfDao.consultarPorId(cdservicofk, cdpessoafk);
    }

    public List<ServicoFuncionario> consultarPorServico(int cdservicofk) throws DaoException {
        return sfDao.consultarPorServico(cdservicofk);
    }

    public void excluir(int cdservicofk, int cdpessoafk) throws DaoException {
        sfDao.excluir(cdservicofk, cdpessoafk);
    }

    public void alterar(ServicoFuncionario sf, int cdpessoafk) throws DaoException {
        sfDao.alterar(sf, cdpessoafk);
    }
}
