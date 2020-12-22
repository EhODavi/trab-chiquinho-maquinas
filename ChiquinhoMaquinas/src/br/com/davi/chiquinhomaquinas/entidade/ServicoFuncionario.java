package br.com.davi.chiquinhomaquinas.entidade;

public class ServicoFuncionario {

    private int CDSERVICOFK;
    private int CDPESSOAFK;
    private double NUMHORAS;
    private double VALORHORA;

    public int getCDPESSOAFK() {
        return CDPESSOAFK;
    }

    public void setCDPESSOAFK(int CDPESSOAFK) {
        this.CDPESSOAFK = CDPESSOAFK;
    }

    public int getCDSERVICOFK() {
        return CDSERVICOFK;
    }

    public void setCDSERVICOFK(int CDSERVICOFK) {
        this.CDSERVICOFK = CDSERVICOFK;
    }

    public double getNUMHORAS() {
        return NUMHORAS;
    }

    public void setNUMHORAS(double NUMHORAS) {
        this.NUMHORAS = NUMHORAS;
    }

    public double getVALORHORA() {
        return VALORHORA;
    }

    public void setVALORHORA(double VALORHORA) {
        this.VALORHORA = VALORHORA;
    }

}
