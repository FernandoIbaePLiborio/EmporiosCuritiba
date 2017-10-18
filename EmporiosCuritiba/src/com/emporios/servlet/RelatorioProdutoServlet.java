package com.emporios.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.emporios.controller.ProdutoController;
import com.emporios.dto.ProdutoDTO;
import com.emporios.jasper.JasperFactoryProdutos;
import com.emporios.model.Produto;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@WebServlet("/RelatorioProdutos")
public class RelatorioProdutoServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioProdutoServlet()
    {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try
        {
            JasperReport jasperReport = JasperFactoryProdutos.getRelacaoProdutos();

            OutputStream tSaida = response.getOutputStream();

            //response.setHeader("Content-Disposition", "inline, filename=RelatorioUsuarios.pdf");
            response.setContentType("application/pdf");

            // Parâmetros para o relatório
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("Produto", "EmporiosCuritiba");

            // Obtendo a lista de alunos
            ProdutoDTO tDto = ProdutoController.pesquisar();
            if (tDto.isOk())
            {
                List<Produto> tLista = tDto.getLista();

                // DataSource
                JRDataSource dataSource = new JRBeanCollectionDataSource(tLista);

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

                // Gerando o relatório para envio
                JasperExportManager.exportReportToPdfStream(jasperPrint,tSaida);

                System.out.println("Done!");
            }
        }
        catch (JRException tExcept)
        {
            throw new ServletException("Problemas na geração do relatórios geral dos usuarios", tExcept);
        }
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

}
