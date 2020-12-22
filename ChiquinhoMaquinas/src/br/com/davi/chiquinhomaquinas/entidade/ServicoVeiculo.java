package br.com.davi.chiquinhomaquinas.entidade;

public class ServicoVeiculo {

    private int CDSERVICOFK;
    private int CDVEICULOFK;
    private double NUMHORASVIAGENS;
    private double PRECO;

    public int getCDSERVICOFK() {
        return CDSERVICOFK;
    }

    public void setCDSERVICOFK(int CDSERVICOFK) {
        this.CDSERVICOFK = CDSERVICOFK;
    }

    public int getCDVEICULOFK() {
        return CDVEICULOFK;
    }

    public void setCDVEICULOFK(int CDVEICULOFK) {
        this.CDVEICULOFK = CDVEICULOFK;
    }

    public double getNUMHORASVIAGENS() {
        return NUMHORASVIAGENS;
    }

    public void setNUMHORASVIAGENS(double NUMHORASVIAGENS) {
        this.NUMHORASVIAGENS = NUMHORASVIAGENS;
    }

    public double getPRECO() {
        return PRECO;
    }

    public void setPRECO(double PRECO) {
        this.PRECO = PRECO;
    }

}
