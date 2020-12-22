package br.com.davi.chiquinhomaquinas.relatorios;

import br.com.davi.chiquinhomaquinas.dao.Dao;
import br.com.davi.chiquinhomaquinas.dao.DaoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class DespesaRelatorio extends Dao {

    public void processar() throws JRException, ClassNotFoundException, SQLException, DaoException {
        String reportSrcFile = "./DespesaRelatorio.jrxml";

        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

        Connection conn = getConnection();

        Map<String, Object> parameters = new HashMap<String, Object>();

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conn);

        JasperViewer.viewReport(print, false);

        System.out.println("Done!");

    }

    public static void main(String[] args) throws JRException, ClassNotFoundException, SQLException, DaoException {
        DespesaRelatorio pfxf = new DespesaRelatorio();
        pfxf.processar();
    }
}
