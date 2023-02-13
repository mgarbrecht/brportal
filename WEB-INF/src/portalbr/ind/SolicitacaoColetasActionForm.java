package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/03/2019 09:32:04
 * Last Modify Date 07/06/2019 15:00:50
 */

public class SolicitacaoColetasActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao_coleta;
  public String tra_cdgo;
  public String tra_nome;
  public String fil_filial;
  public String fil_filial_descricao;
  public String data_solicitacao;
  public String hora_inicial;
  public String data_solicitacao_final;
  public String hora_final;
  private boolean valida = false;
  public SolicitacaoColetasActionForm() {
  }
  /**
    * ID_SOLICITACAO_COLETA: Method to get the field value.
    */
  public String getId_solicitacao_coleta() {
    return id_solicitacao_coleta;
  }
  /**
    * ID_SOLICITACAO_COLETA: Method to set the field value.
    */
  public void setId_solicitacao_coleta(String PARAM) {
    id_solicitacao_coleta = PARAM;
  }
  /**
    * TRA_CDGO: Method to get the field value.
    */
  public String getTra_cdgo() {
    return tra_cdgo;
  }
  /**
    * TRA_CDGO: Method to set the field value.
    */
  public void setTra_cdgo(String PARAM) {
    tra_cdgo = PARAM;
  }
  /**
    * TRA_NOME: Method to get the field value.
    */
  public String getTra_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tra_cdgo != null && tra_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        String[][] select = { {"tra_nome",null} };
        Object[][] where = { {"tra_cdgo","=",com.egen.util.text.FormatNumber.toInt(tra_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          tra_nome = (db_object.getTra_nome() != null) ? db_object.getTra_nome() + "":"";
        } else {
          tra_nome = "";
        }
      }
    } catch (Exception e) {
      tra_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return tra_nome;
  }

  public String[][] getTra_nome_Ajax(SolicitacaoColetasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getTra_cdgo() != null && PARAM.getTra_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        Object[][] where = { {"tra_cdgo","like",PARAM.getTra_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          list[0] = new String[]{"tra_nome", (db_object.getTra_nome() != null) ? db_object.getTra_nome() + "":""};
        } else {
          list[0] = new String[]{"tra_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"tra_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * TRA_NOME: Method to set the field value.
    */
  public void setTra_nome(String PARAM) {
    tra_nome = PARAM;
  }
  /**
    * FIL_FILIAL: Method to get the field value.
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Method to set the field value.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * FIL_FILIAL_DESCRICAO: Method to get the field value.
    */
  public String getFil_filial_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fil_filial != null && fil_filial.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = { {"fil_razsoc",null} };
        Object[][] where = { {"fil_filial","like",fil_filial}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          fil_filial_descricao = ((db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"");
        } else {
          fil_filial_descricao = "";
        }
      }
    } catch (Exception e) {
      fil_filial_descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fil_filial_descricao;
  }

  public String[][] getFil_filial_descricao_Ajax(SolicitacaoColetasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          list[0] = new String[]{"fil_filial_descricao", ((db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fil_filial_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fil_filial_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FIL_FILIAL_DESCRICAO: Method to set the field value.
    */
  public void setFil_filial_descricao(String PARAM) {
    fil_filial_descricao = PARAM;
  }
  /**
    * DATA_SOLICITACAO: Method to get the field value.
    */
  public String getData_solicitacao() {
    return data_solicitacao;
  }
  /**
    * DATA_SOLICITACAO: Method to set the field value.
    */
  public void setData_solicitacao(String PARAM) {
    data_solicitacao = PARAM;
  }
  /**
    * HORA_INICIAL: Method to get the field value.
    */
  public String getHora_inicial() {
    return hora_inicial;
  }
  /**
    * HORA_INICIAL: Method to set the field value.
    */
  public void setHora_inicial(String PARAM) {
    hora_inicial = PARAM;
  }
  /**
    * DATA_SOLICITACAO_FINAL: Method to get the field value.
    */
  public String getData_solicitacao_final() {
    return data_solicitacao_final;
  }
  /**
    * DATA_SOLICITACAO_FINAL: Method to set the field value.
    */
  public void setData_solicitacao_final(String PARAM) {
    data_solicitacao_final = PARAM;
  }
  /**
    * HORA_FINAL: Method to get the field value.
    */
  public String getHora_final() {
    return hora_final;
  }
  /**
    * HORA_FINAL: Method to set the field value.
    */
  public void setHora_final(String PARAM) {
    hora_final = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao_coleta = null;
    tra_cdgo = null;
    tra_nome = null;
    fil_filial = null;
    fil_filial_descricao = null;
    data_solicitacao = null;
    hora_inicial = null;
    data_solicitacao_final = null;
    hora_final = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
