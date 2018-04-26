package br.ufscar.dc.SistemaMedico.forms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NovoConsultaFormBean {

    private String CPF, CRM, dataExame;

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getDataExame() {
        return dataExame;
    }

    public void setDataExame(String dataExame) {
        this.dataExame = dataExame;
    }
    

  public List<String> validar() {
          List<String> mensagens = new ArrayList<String>();
          //if (CPF.trim().length() == 0) {
            //  mensagens.add("CPF não pode ser vazio!");
          //}
          if (CRM.trim().length() == 0) {
              mensagens.add("CRM não pode ser vazio!");
          }
          try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.parse(dataExame);
        } catch (ParseException pe) {
            mensagens.add("Data do exame deve estar no formato dd/mm/aaaa!");
        }
          return (mensagens.isEmpty() ? null : mensagens);
      }

}
