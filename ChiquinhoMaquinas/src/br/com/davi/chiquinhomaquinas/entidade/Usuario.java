package br.com.davi.chiquinhomaquinas.entidade;

public class Usuario {

    private int CDUSUARIO;
    private String LOGIN;
    private String SENHA;

    public int getCDUSUARIO() {
        return CDUSUARIO;
    }

    public void setCDUSUARIO(int CDUSUARIO) {
        this.CDUSUARIO = CDUSUARIO;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    @Override
    public String toString() {
        return this.LOGIN;
    }
}
