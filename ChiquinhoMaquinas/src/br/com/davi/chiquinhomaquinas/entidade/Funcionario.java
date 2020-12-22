package br.com.davi.chiquinhomaquinas.entidade;

public class Funcionario extends Pessoa {

    private String CPF;
    private double VALORHORA;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public double getVALORHORA() {
        return VALORHORA;
    }

    public void setVALORHORA(double VALORHORA) {
        this.VALORHORA = VALORHORA;
    }

}
