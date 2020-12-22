package br.com.davi.chiquinhomaquinas.entidade;

import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.negocio.ClienteFisicoControle;
import br.com.davi.chiquinhomaquinas.negocio.ClienteJuridicoControle;
import java.util.Date;

public class Servico {

    private int CDSERVICO; 
    private String ENDERECO; 
    private String DESCRICAO; 
    private Date DATAINICIO;
    private Date DATAFIM;
    private double PRECOTOTAL;
    private String FORMAPAG;
    private String SITUACAO; 
    private int NUMPARCELAS;
    private Date DATAPAGAMENTO;
    private int CDPESSOAFK;

    public int getCDSERVICO() {
        return CDSERVICO;
    }

    public void setCDSERVICO(int CDSERVICO) {
        this.CDSERVICO = CDSERVICO;
    }

    public String getENDERECO() {
        return ENDERECO;
    }

    public void setENDERECO(String ENDERECO) {
        this.ENDERECO = ENDERECO;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public Date getDATAINICIO() {
        return DATAINICIO;
    }

    public void setDATAINICIO(Date DATAINICIO) {
        this.DATAINICIO = DATAINICIO;
    }

    public Date getDATAFIM() {
        return DATAFIM;
    }

    public void setDATAFIM(Date DATAFIM) {
        this.DATAFIM = DATAFIM;
    }

    public double getPRECOTOTAL() {
        return PRECOTOTAL;
    }
    
    public String getPrecoTotalStr() {
        return "R$" + Double.toString(PRECOTOTAL);
    }

    public void setPRECOTOTAL(double PRECOTOTAL) {
        this.PRECOTOTAL = PRECOTOTAL;
    }

    public String getFORMAPAG() {
        return FORMAPAG;
    }

    public void setFORMAPAG(String FORMAPAG) {
        this.FORMAPAG = FORMAPAG;
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

    public int getNUMPARCELAS() {
        return NUMPARCELAS;
    }

    public void setNUMPARCELAS(int NUMPARCELAS) {
        this.NUMPARCELAS = NUMPARCELAS;
    }

    public Date getDATAPAGAMENTO() {
        return DATAPAGAMENTO;
    }
    
    public String getDataPagStr() {
        return DateParse.dateToString(DATAPAGAMENTO);
    }

    public void setDATAPAGAMENTO(Date DATAPAGAMENTO) {
        this.DATAPAGAMENTO = DATAPAGAMENTO;
    }

    public int getCDPESSOAFK() {
        return CDPESSOAFK;
    }

    public void setCDPESSOAFK(int CDPESSOAFK) {
        this.CDPESSOAFK = CDPESSOAFK;
    }
    
    public String getCdPessoaFKStr() {
        ClienteFisicoControle cfc = new ClienteFisicoControle();
        ClienteJuridicoControle cjc = new ClienteJuridicoControle();
        try {
            if(cfc.consultarPorId(CDPESSOAFK) != null) {
                return cfc.consultarPorId(CDPESSOAFK).getNOME();
            }
            return cjc.consultarPorId(CDPESSOAFK).getNOME();
        } catch (DaoException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
