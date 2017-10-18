package com.emporios.jasper;

import java.io.IOException;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class JasperVendaSemanalFactory
{
    private static JasperReport sRelacaoVendaSemanal;

    public static JasperReport getRelacaoVendaSemanal() throws JRException {
        if (sRelacaoVendaSemanal == null) {
            try {
                // Abrindo o arquivo JRXML
                InputStream tArqEntrada = JasperVendaSemanalFactory.class.getResourceAsStream("qtVensaSemanal.jrxml");

                // Compilando o arquivo JRXML
                sRelacaoVendaSemanal = JasperCompileManager.compileReport(tArqEntrada);

                // Fechando o arquivo JRXML
                tArqEntrada.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        // Retornando o relatório compilado
        return sRelacaoVendaSemanal;
    }
}
