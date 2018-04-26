package br.ufscar.dc.SistemaMedico.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovoMedicoFormBean {
      private String CRM, nome, senha, especialidade;

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
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

      public String getEspecialidade() {
      return especialidade;
      }

      public void setEspecialidade(String especialidade) {
      this.especialidade = especialidade;
      }

      public List<String> validar() {
              List<String> mensagens = new ArrayList<String>();
              if (CRM.trim().length() == 0) {
                  mensagens.add("CRM não pode ser vazio!");
              }
              if (nome.trim().length() == 0) {
                  mensagens.add("Nome não pode ser vazio!");
              }
              if (especialidade.trim().length() == 0) {
                  mensagens.add("Especialidade não pode ser vazio!");
              }
              if (senha.trim().length() == 0) {
                  mensagens.add("Senha não pode ser vazio!");
              }
              return (mensagens.isEmpty() ? null : mensagens);
      }





}
