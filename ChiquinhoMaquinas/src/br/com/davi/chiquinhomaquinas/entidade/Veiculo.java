package br.com.davi.chiquinhomaquinas.entidade;

public class Veiculo {

    private int CDVEICULO;
    private String TIPO;
    private String TIPOCOBRANCA;
    private String PLACA;
    private String NOME;
    private double PRECO;

    public int getCDVEICULO() {
        return CDVEICULO;
    }

    public void setCDVEICULO(int CDVEICULO) {
        this.CDVEICULO = CDVEICULO;
    }

    public String getTIPO() {
        return TIPO;
    }

    public String getTipoStr() {
        if (TIPO.equals("P")) {
            return "Pá Carregadeira";
        } else if (TIPO.equals("R")) {
            return "Retroescavadeira";
        }
        return "Caminhão";
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public String getTIPOCOBRANCA() {
        return TIPOCOBRANCA;
    }

    public String getTipoCobrancaStr() {
        if (TIPOCOBRANCA.equals("H")) {
            return "Por Hora";
        }
        return "Por Viagem";
    }

    public void setTIPOCOBRANCA(String TIPOCOBRANCA) {
        this.TIPOCOBRANCA = TIPOCOBRANCA;
    }

    public String getPLACA() {
        return PLACA;
    }

    public String getPlacaStr() {
        return PLACA.substring(0, 3) + "-" + PLACA.substring(4, 7);
    }

    public void setPLACA(String PLACA) {
        this.PLACA = PLACA;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public double getPRECO() {
        return PRECO;
    }

    public String getPrecoStr() {
        return "R$" + Double.toString(PRECO);
    }

    public void setPRECO(double PRECO) {
        this.PRECO = PRECO;
    }

    @Override
    public String toString() {
        return this.NOME;
    }

}
