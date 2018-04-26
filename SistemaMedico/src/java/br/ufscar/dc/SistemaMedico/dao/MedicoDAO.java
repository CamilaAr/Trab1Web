/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.dao;

import br.ufscar.dc.SitemaMedico.beans.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import javax.naming.NamingException;

/**
 *
 * @author Camila Araujo
 */
public class MedicoDAO {
    private final static String CRIAR_MEDICO_SQL = "insert into Medico"
            + " (CRM, nome, senha, especialidade)"
            + " values (?,?,?,?)";


    private final static String BUSCAR_MEDICO_SQL = "select"
            + " CRM, nome, senha, especialidade"
            + " from Medico"
            + " where CRM=? and senha=?";
    
     private final static String LISTAR_MEDICO_SQL = "select"
            + " CRM, nome, especialidade"
            + " from Medico";
     
     private final static String LISTAR_MEDICO_ESPECIALIDADE_SQL = "select"
            + " CRM, nome, especialidade"
            + " from Medico"
            + " where especialidade=?";
    
    DataSource dataSource;
    
    


    public MedicoDAO(DataSource dataSource) {
        this.dataSource = dataSource; //estudar
    }
    
    public Medico gravarMedico(Medico u) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_MEDICO_SQL);) {
            ps.setInt(1, u.getCRM());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getEspecialidade());
            ps.execute();

        }
        return u;
    }


    public Medico buscarMedico(String _CRM, String senha) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_MEDICO_SQL)) {
            int CRM = Integer.parseInt(_CRM);
            ps.setInt(1, CRM);
            ps.setString(2, senha);


            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                Medico u = new Medico();
                u.setCRM(rs.getInt("CRM"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setEspecialidade(rs.getString("especialidade"));
                return u;
            }
        }
    }
    
     public List<Medico> listarTodosMedicos() throws SQLException, NamingException {
        List<Medico> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_MEDICO_SQL)) {


            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medico p = new Medico();
                    p.setCRM(rs.getInt("CRM"));
                    p.setNome(rs.getString("nome"));
                    //p.setSenha(rs.getString("senha"));
                    p.setEspecialidade(rs.getString("especialidade"));
                    ret.add(p);
                }
            }
        }
        return ret;
    }
      public List<Medico> listarMedicosPorEspecialidade(String especialidade) throws SQLException {
        List<Medico> ret = new ArrayList<>();
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(LISTAR_MEDICO_ESPECIALIDADE_SQL)) {
            ps.setString(1, especialidade);
           
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Medico p = new Medico();
                    p.setCRM(rs.getInt("CRM"));
                    p.setNome(rs.getString("nome"));
                    p.setEspecialidade(rs.getString("especialidade"));
                    ret.add(p);               
                }
            }
        }
        return ret;
    }
}