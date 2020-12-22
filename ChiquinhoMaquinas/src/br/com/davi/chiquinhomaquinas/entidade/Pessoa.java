package br.com.davi.chiquinhomaquinas.entidade;

public abstract class Pessoa {

    private int CDPESSOA;
    private String NOME;
    private String ENDERECO;
    private String TELEFONE;
    private String EMAIL;

    public int getCDPESSOA() {
        return CDPESSOA;
    }

    public void setCDPESSOA(int CDPESSOA) {
        this.CDPESSOA = CDPESSOA;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getENDERECO() {
        return ENDERECO;
    }

    public void setENDERECO(String ENDERECO) {
        this.ENDERECO = ENDERECO;
    }

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    @Override
    public String toString() {
        return this.NOME;
    }
}
