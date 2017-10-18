package com.emporios.jasper;

import java.io.IOException;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class JasperFactoryProdutosPorFornecedor
{
    private static JasperReport sRelacaoProdutoPorFornecedor;

    public static JasperReport getRelacaoProdutoPorFornecedor() throws JRException
    {
        if (sRelacaoProdutoPorFornecedor == null)
        {
            try
            {
                // Abrindo o arquivo JRXML
                InputStream tArqEntrada = JasperFactoryProdutosPorFornecedor.class.getResourceAsStream("precoPordutoFornecedor.jrxml");

                // Compilando o arquivo JRXML
                sRelacaoProdutoPorFornecedor = JasperCompileManager.compileReport(tArqEntrada);

                // Fechando o arquivo JRXML
                tArqEntrada.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        // Retornando o relatório compilado
        return sRelacaoProdutoPorFornecedor;
    }
}
