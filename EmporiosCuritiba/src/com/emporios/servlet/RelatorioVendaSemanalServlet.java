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

import com.emporios.controller.ProdutoFornecedorController;
import com.emporios.dto.ProdutoFornecedorDTO;
import com.emporios.jasper.JasperVendaSemanalFactory;
import com.emporios.model.ProdutoFornecedor;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@WebServlet("/RelatorioVendaSemanal")
public class RelatorioVendaSemanalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RelatorioVendaSemanalServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try
        {
            JasperReport jasperReport = JasperVendaSemanalFactory.getRelacaoVendaSemanal();

            OutputStream tSaida = response.getOutputStream();
            response.setContentType("application/pdf");
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("NIVEL", "EmporiosCuritiba");
            ProdutoFornecedorDTO tDto = ProdutoFornecedorController.pesquisaVendaSemanal();
            if (tDto.isOk()){
                List<ProdutoFornecedor> tLista = tDto.getLista();
                JRDataSource dataSource = new JRBeanCollectionDataSource(tLista);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
