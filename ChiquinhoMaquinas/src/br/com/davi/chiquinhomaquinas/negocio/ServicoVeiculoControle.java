package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.dao.ServicoDao;
import br.com.davi.chiquinhomaquinas.dao.ServicoVeiculoDao;
import br.com.davi.chiquinhomaquinas.entidade.Servico;
import br.com.davi.chiquinhomaquinas.entidade.ServicoVeiculo;
import java.util.List;

public class ServicoVeiculoControle {

    ServicoVeiculoDao svDao = new ServicoVeiculoDao();
    ServicoDao sDao = new ServicoDao();

    public void inserir(ServicoVeiculo sv) throws DaoException {
        svDao.inserir(sv);
        Servico s = sDao.consultarPorId(sv.getCDSERVICOFK());
        s.setPRECOTOTAL(s.getPRECOTOTAL() + sv.getPRECO() * sv.getNUMHORASVIAGENS());
        sDao.alterar(s);
    }

    public ServicoVeiculo consultarPorId(int cdservicofk, int cdveiculofk) throws DaoException {
        return svDao.consultarPorId(cdservicofk, cdveiculofk);
    }

    public List<ServicoVeiculo> consultarPorServico(int cdservicofk) throws DaoException {
        return svDao.consultarPorServico(cdservicofk);
    }

    public void excluir(int cdservicofk, int cdveiculofk) throws DaoException {
        ServicoVeiculo sv = svDao.consultarPorId(cdservicofk, cdveiculofk);
        Servico s = sDao.consultarPorId(sv.getCDSERVICOFK());
        s.setPRECOTOTAL(s.getPRECOTOTAL() - sv.getPRECO() * sv.getNUMHORASVIAGENS());
        sDao.alterar(s);
        svDao.excluir(cdservicofk, cdveiculofk);
    }

    public void alterar(ServicoVeiculo sv, int cdveiculofk) throws DaoException {
        ServicoVeiculo svAnterior = svDao.consultarPorId(sv.getCDSERVICOFK(), cdveiculofk);
        double diferenca = (sv.getNUMHORASVIAGENS() * sv.getPRECO()) - (svAnterior.getNUMHORASVIAGENS() * svAnterior.getPRECO());
        svDao.alterar(sv, cdveiculofk);
        Servico s = sDao.consultarPorId(sv.getCDSERVICOFK());
        s.setPRECOTOTAL(s.getPRECOTOTAL() + diferenca);
        sDao.alterar(s);
    }
}
