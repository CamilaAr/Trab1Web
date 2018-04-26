/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.servlets;

import br.ufscar.dc.SistemaMedico.dao.ConsultaDAO;
import br.ufscar.dc.SitemaMedico.beans.Consulta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author Camila Araujo
 */
@WebServlet(name = "verConcultaServlet", urlPatterns = {"/verConsultaServlet"})
public class verConsultaServlet extends HttpServlet {
    
    @Resource(name = "jdbc/SistemaMedicoDBLocal")
    DataSource dataSource;


    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ConsultaDAO pdao = new ConsultaDAO(dataSource);
        
        String CPF = request.getParameter("CPF");
        String CRM = request.getParameter("CRM");
        
        List<Consulta>todosConsultas = null;
        try {
            if (CRM == null) {
                int i = Integer.parseInt(CPF);
                todosConsultas = pdao.listarTodasConsultasPorPaciente(i);
            } else {
                int j = Integer.parseInt(CRM);
                todosConsultas = pdao.listarTodasConsultasPorMedico(j);
            }
            request.setAttribute("listaConsulta", todosConsultas);
            request.getRequestDispatcher("listaConsulta.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getLocalizedMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
