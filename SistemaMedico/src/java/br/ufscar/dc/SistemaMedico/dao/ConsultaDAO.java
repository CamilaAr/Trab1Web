/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.dao;
import br.ufscar.dc.SitemaMedico.beans.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import javax.annotation.Resource;


/**
 *
 * @author Camila Araujo
 */
public class ConsultaDAO {
    private final static String CRIAR_CONSULTA_SQL = "insert into CONSULTA"
            + " (CPF, CRM, dataExame)"
            + " values (?,?,?)";


    private final static String BUSCAR_CONSULTA_SQL = "select"
            + " CPF, CRM, dataExame"
            + " from Consulta"
            + " where CPF=? and CRM=? and dataExame=?";
    
   private final static String LISTAR_CONSULTA_POR_PACIENTE_SQL = "select"
            + " CPF, CRM, dataExame"
            + " from Consulta"
            + " where CPF = ?";

   private final static String LISTAR_CONSULTA_POR_MEDICO_SQL = "select"
            + " CRM, CPF, dataExame"
            + " from Consulta"
            + " where CRM = ?";
   
   private final static String VALIDAR_CONSULTACPF_SQL = "select"
            + " CPF, CRM, dataExame"
            + " from Consulta"
            + " where dataExame=? and CPF=?";
   
   private final static String VALIDAR_CONSULTACRM_SQL = "select"
            + " CPF, CRM, dataExame"
            + " from Consulta"
            + " where dataExame=? and CRM=?";

    
    DataSource dataSource;


    public ConsultaDAO(DataSource dataSource) {
        this.dataSource = dataSource; //estudar
    }
    
    public Consulta gravarConsulta(Consulta u) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
            PreparedStatement ps = con.prepareStatement(CRIAR_CONSULTA_SQL);) {
            ps.setInt(1, u.getCPF());
            ps.setInt(2, u.getCRM());
            ps.setDate(3, new java.sql.Date(u.getDataExame().getTime()));
            
            ps.execute();

        }
        return u;
    }


    public Consulta validarConsultaCPF(String _CPF, String _dataExame) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(VALIDAR_CONSULTACPF_SQL)) {
         
                int CPF = Integer.parseInt(_CPF);
               

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataExame = null;
            try {
                dataExame = sdf.parse(_dataExame);
            } catch (ParseException ex) {
                Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                ps.setInt(2, CPF);
                
                ps.setDate(1, new java.sql.Date(dataExame.getTime()));
  
                 //ps.setDate(4, new java.sql.Date(_dataExame.getTime()));
            
            


            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                Consulta u = new Consulta();
                u.setCPF(rs.getInt("CPF"));
                u.setDataExame(new Date(rs.getDate("dataExame").getTime()));
                return u;
            }
        }
    }
    
    
    
     public List<Consulta> listarTodasConsultasPorPaciente(int CPF) throws SQLException {
        List<Consulta> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_CONSULTA_POR_PACIENTE_SQL)) {
            ps.setInt(1, CPF);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Consulta p = new Consulta();
                    p.setCPF(rs.getInt("CPF"));
                    p.setCRM(rs.getInt("CRM"));
                    p.setDataExame(new Date(rs.getDate("dataExame").getTime()));
                    ret.add(p);                
                }
            }
        }
        return ret;
    }
     public List<Consulta> listarTodasConsultasPorMedico(int CRM) throws SQLException {
        List<Consulta> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_CONSULTA_POR_MEDICO_SQL)) {
            ps.setInt(1, CRM);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Consulta p = new Consulta();
                    p.setCPF(rs.getInt("CPF"));
                    p.setCRM(rs.getInt("CRM"));
                    p.setDataExame(new Date(rs.getDate("dataExame").getTime()));
                    ret.add(p);                
                }
            }
        }
        return ret;
    }
}