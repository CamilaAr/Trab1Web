/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.servlets;


import br.ufscar.dc.SistemaMedico.dao.ConsultaDAO;
import br.ufscar.dc.SitemaMedico.beans.Consulta;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "NovoVerificaConsultaServlet", urlPatterns = {"/NovoVerificaConsultaServlet"})
public class NovoVerificaConsultaServlet extends HttpServlet {
    
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
        
        String CRM = request.getParameter("CRM");
        String CPF = request.getParameter("CPF");
        String dataExame = request.getParameter("dataExame");
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //Date dataExame = null;
       // try {
         //   dataExame = sdf.parse(exame);
        //} catch (ParseException e) {
            //Logger.getLogger(NovoVerificaConsultaServlet.class.getName()).log(Level.SEVERE, null, ex);
           // e.printStackTrace();
          //  request.setAttribute("mensagem", e.getLocalizedMessage());
            //request.getRequestDispatcher("erro.jsp").forward(request, response);
        //}
        Consulta p = null;
        try {
                p = pdao.validarConsultaCPF(CPF, dataExame);
             if(p == null){
                request.getRequestDispatcher("ConfirmarAgendamento.jsp").forward(request, response); 
             }
             else{
                request.getRequestDispatcher("index.jsp").forward(request, response);  
                
             }
           
        } catch (Exception e) {
            //Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, e);
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
