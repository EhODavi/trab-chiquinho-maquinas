package br.com.davi.chiquinhomaquinas.relatorios;

import br.com.davi.chiquinhomaquinas.dao.Dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioDespesa extends Dao {

    public void emitirRelatorio(List<?> pList) {

        String reportSource = "./DespesaRelatorio.jasper";

        Map<String, Object> params = new HashMap<String, Object>();

        try {
            JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(pList);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportSource, params, jrBean);

            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
}
