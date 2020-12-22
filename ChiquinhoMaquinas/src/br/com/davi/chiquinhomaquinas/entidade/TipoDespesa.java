package br.com.davi.chiquinhomaquinas.entidade;

public class TipoDespesa {

    private int CDTIPODESPESA;
    private String NOME;
    private String TIPO;

    public int getCDTIPODESPESA() {
        return CDTIPODESPESA;
    }

    public void setCDTIPODESPESA(int CDTIPODESPESA) {
        this.CDTIPODESPESA = CDTIPODESPESA;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getTIPO() {
        return TIPO;
    }

    public String getTipoStr() {
        if (TIPO.equals("V")) {
            return "Veículo";
        } else if (TIPO.equals("F")) {
            return "Funcionário";
        }
        return "Casa";
    }

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    @Override
    public String toString() {
        return this.NOME;
    }

}
