package br.com.davi.chiquinhomaquinas.entidade;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.negocio.TipoDespesaControle;
import java.util.Date;

public class Despesa {

    private int CDDESPESA;
    private String DESCRICAO;
    private double VALOR;
    private Date DATA;
    private String SITUACAO;
    private int CDTIPODESPESAFK;

    public int getCDDESPESA() {
        return CDDESPESA;
    }

    public void setCDDESPESA(int CDDESPESA) {
        this.CDDESPESA = CDDESPESA;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public double getVALOR() {
        return VALOR;
    }
    
    public String getValorStr() {
        return "R$" + Double.toString(VALOR);
    }

    public void setVALOR(double VALOR) {
        this.VALOR = VALOR;
    }

    public Date getDATA() {
        return DATA;
    }

    public String getDataStr() {
        return DateParse.dateToString(DATA);
    }

    public void setDATA(Date DATA) {
        this.DATA = DATA;
    }

    public String getSITUACAO() {
        return SITUACAO;
    }

    public String getSituacaoStr() {
        if (SITUACAO.equals("P")) {
            return "Paga";
        }
        return "Não Paga";
    }

    public void setSITUACAO(String SITUACAO) {
        this.SITUACAO = SITUACAO;
    }

    public int getCDTIPODESPESAFK() {
        return CDTIPODESPESAFK;
    }
    
    public String getCdTipoDespesaFKStr() {
        TipoDespesaControle tdc = new TipoDespesaControle();
        try {
            return tdc.consultarPorId(CDTIPODESPESAFK).getNOME();
        } catch (DaoException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void setCDTIPODESPESAFK(int CDTIPODESPESAFK) {
        this.CDTIPODESPESAFK = CDTIPODESPESAFK;
    }

}
