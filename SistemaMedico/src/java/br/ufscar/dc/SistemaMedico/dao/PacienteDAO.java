/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.SistemaMedico.dao;

import br.ufscar.dc.SitemaMedico.beans.Paciente;
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
public class PacienteDAO {
    private final static String CRIAR_PACIENTE_SQL = "insert into Paciente"
            + " (CPF, nome, senha, telefone, sexo, dataDeNascimento)"
            + " values (?,?,?,?,?,?)";


    private final static String BUSCAR_PACIENTE_SQL = "select"
            + " CPF, nome, senha, telefone, sexo, dataDeNascimento"
            + " from Paciente"
            + " where CPF=? and senha=?";
    
    DataSource dataSource;


    public PacienteDAO(DataSource dataSource) {
        this.dataSource = dataSource; //estudar
    }
    
    public Paciente gravarPaciente(Paciente u) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(CRIAR_PACIENTE_SQL);) {
            ps.setInt(1, u.getCPF());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getSenha());
            ps.setString(4, u.getTelefone());
            ps.setString(5, u.getSexo());
            ps.setDate(6, new java.sql.Date(u.getDataDeNascimento().getTime()));
            ps.execute();

        }
        return u;
    }


    public Paciente buscarPaciente(String _CPF, String senha) throws SQLException, NamingException {
        try (Connection con = dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(BUSCAR_PACIENTE_SQL)) {
            int CPF = Integer.parseInt(_CPF);
            ps.setInt(1, CPF);
            ps.setString(2, senha);
            

            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                Paciente u = new Paciente();
                u.setCPF(rs.getInt("CPF"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
                u.setTelefone(rs.getString("telefone"));
                u.setSexo(rs.getString("sexo"));
                u.setDataDeNascimento(new Date(rs.getDate("dataDeNascimento").getTime()));
                return u;
            }
        }
    }
}
