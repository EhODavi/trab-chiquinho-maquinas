package br.com.davi.chiquinhomaquinas.entidade;

public class ClienteJuridico extends Pessoa {

    private String CNPJ;
    private String INSCRICAOESTADUAL;

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getINSCRICAOESTADUAL() {
        return INSCRICAOESTADUAL;
    }

    public void setINSCRICAOESTADUAL(String INSCRICAOESTADUAL) {
        this.INSCRICAOESTADUAL = INSCRICAOESTADUAL;
    }

}
