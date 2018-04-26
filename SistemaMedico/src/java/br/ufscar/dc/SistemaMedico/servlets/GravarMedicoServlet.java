/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.servlets;

import br.ufscar.dc.SistemaMedico.dao.MedicoDAO;
import br.ufscar.dc.SistemaMedico.forms.NovoMedicoFormBean;
import br.ufscar.dc.SitemaMedico.beans.Medico;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "GravarMedicoServlet", urlPatterns = {"/GravarMedicoServlet"})
public class GravarMedicoServlet extends HttpServlet {

    @Resource(name="jdbc/SistemaMedicoDBLocal")
    DataSource dataSource;


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NovoMedicoFormBean npfb = (NovoMedicoFormBean) request.getSession().getAttribute("novoMedico");
        request.getSession().removeAttribute("novoMedico");
        MedicoDAO mdao = new MedicoDAO(dataSource);

        try {
            Medico m = new Medico();
            int i = Integer.parseInt(npfb.getCRM());
            m.setCRM(i);
            m.setNome(npfb.getNome());
            m.setEspecialidade(npfb.getEspecialidade());
            m.setSenha(npfb.getSenha());
            m = mdao.gravarMedico(m);
            request.setAttribute("mensagem", "Medico registrado com sucesso!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
