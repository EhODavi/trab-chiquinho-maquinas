package br.com.davi.chiquinhomaquinas.entidade;

public class Saldo {

    private int CDSALDOTOTAL;
    private String DESCRICAO;
    private String SITUACAO;
    private String DATA;
    private String TIPO;
    private String VALOR;

    public int getCDSALDOTOTAL() {
        return CDSALDOTOTAL;
    }

    public void setCDSALDOTOTAL(int CDSALDOTOTAL) {
        this.CDSALDOTOTAL = CDSALDOTOTAL;
    }

    public String getDESCRICAO() {
        return DESCRICAO;
    }

    public void setDESCRICAO(String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    public String getSITUACAO() {
        return SITUACAO;
    }

    public void setSITUACAO(String SITUACAO) {
        this.SITUACAO = SITUACAO;
    }

    public String getDATA() {
        return DATA;
    }

    public void setDATA(String DATA) {
        this.DATA = DATA;
    }

    public String getTIPO() {
        return TIPO;
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getVALOR() {
        return VALOR;
    }

    public void setVALOR(String VALOR) {
        this.VALOR = VALOR;
    }

}
