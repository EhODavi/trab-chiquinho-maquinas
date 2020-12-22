package br.com.davi.chiquinhomaquinas.negocio;

import br.com.davi.chiquinhomaquinas.dao.ClienteJuridicoDao;
import br.com.davi.chiquinhomaquinas.dao.DaoException;
import br.com.davi.chiquinhomaquinas.dao.PessoaDao;
import br.com.davi.chiquinhomaquinas.entidade.ClienteJuridico;
import br.gov.sintegra.ie.InscricaoEstadual;
import br.gov.sintegra.ie.InscricaoEstadualFactory;
import java.util.InputMismatchException;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClienteJuridicoControle {

    ClienteJuridicoDao cjDao = new ClienteJuridicoDao();
    PessoaDao pDao = new PessoaDao();
    InscricaoEstadual ie = InscricaoEstadualFactory.getInstance("MG");

    public boolean isCNPJ(String CNPJ) {
// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111")
                || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333")
                || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
                || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777")
                || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999")
                || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

// "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
// converte o i-ésimo caractere do CNPJ em um número:
// por exemplo, transforma o caractere '0' no inteiro 0
// (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

// Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

// Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    public boolean validarEmail(String email) {
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public int inserir(ClienteJuridico cj) throws DaoException {
        int k;
        k = pDao.inserir(cj);
        cj.setCDPESSOA(k);
        k = cjDao.inserir(cj);
        return k;
    }

    public ClienteJuridico consultarPorId(int id) throws DaoException {
        return cjDao.consultarPorId(id);
    }

    public List<ClienteJuridico> consultarPorNome(String nome) throws DaoException {
        return cjDao.consultarPorNome(nome);
    }

    public List<ClienteJuridico> consultarTodos() throws DaoException {
        return cjDao.consultarTodos();
    }

    public void excluir(int id) throws DaoException {
        pDao.excluir(id);
    }

    public void alterar(ClienteJuridico cj) throws DaoException {
        pDao.alterar(cj);
        cjDao.alterar(cj);
    }

    public String[][] consultarPorInadimplencia() throws DaoException {
        return cjDao.consultarPorInadimplencia();
    }
}
