package br.com.davi.chiquinhomaquinas.entidade;

public class ClienteInadimplente {

    private int CDCLIENTEINADIMPLENTE;
    private String NOME;
    private String ENDERECO;
    private String TELEFONE;
    private String EMAIL;
    private double VALOR;

    public int getCDCLIENTEINADIMPLENTE() {
        return this.CDCLIENTEINADIMPLENTE;
    }

    public void setCDCLIENTEINADIMPLENTE(int CDCLIENTEINADIMPLENTE) {
        this.CDCLIENTEINADIMPLENTE = CDCLIENTEINADIMPLENTE;
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

    public String getTelefoneStr() {
        if (this.TELEFONE.length() == 8) {
            return "(31)" + this.TELEFONE.substring(0, 4) + "-" + this.TELEFONE.substring(4, 8);
        }
        return "(31)" + this.TELEFONE.substring(0, 5) + "-" + this.TELEFONE.substring(5, 9);
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

    public double getVALOR() {
        return VALOR;
    }

    public String getValorStr() {
        return "R$" + Double.toString(VALOR);
    }

    public void setVALOR(double VALOR) {
        this.VALOR = VALOR;
    }
    
}
