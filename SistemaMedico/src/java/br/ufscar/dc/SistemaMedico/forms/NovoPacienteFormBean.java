package br.ufscar.dc.SistemaMedico.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class NovoPacienteFormBean {

  
  private String  CPF, nome, senha, telefone, sexo, dataDeNascimento;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

   
  

  public List<String> validar() {
          List<String> mensagens = new ArrayList<String>();
          if (CPF.trim().length() == 0) {
            mensagens.add("CPF não pode ser vazio!");
          }
          if (nome.trim().length() == 0) {
              mensagens.add("Nome não pode ser vazio!");
          }
          if (senha.trim().length() == 0) {
              mensagens.add("Senha não pode ser vazio!");
          }
          if (sexo.trim().length() == 0) {
              mensagens.add("Sexo possui somente a primeira letra!");
          }
          if (telefone.trim().length() == 0) {
              mensagens.add("Telefone não pode ser vazio!");
          }
          try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(dataDeNascimento);
        } catch (ParseException pe) {
            mensagens.add("Data de nascimento deve estar no formato dd/mm/aaaa!");
        }
          return (mensagens.isEmpty() ? null : mensagens);
      }

}
