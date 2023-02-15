package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/04/2007 12:28:57
 * Last Modify Date 15/02/2023 11:32:30
 */

public class ConsultaRomaneiosEmbarqueEDIActionForm extends org.apache.struts.action.ActionForm
{
  public String tra_cdgo;
  public String tra_nome;
  public String fil_filial;
  public String fil_razsoc;
  public String data_emissao;
  public String data_emissao_final;
  public String romaneio;
  public String nfs_nmro;
  public String f_tra;
  private boolean valida = false;
  public ConsultaRomaneiosEmbarqueEDIActionForm() {
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
        String[][] select = {{"tra_nome",null}};
        Object[][] where = { {"tra_cdgo","=",com.egen.util.text.FormatNumber.toInt(tra_cdgo)} };
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
        j = null;
      }
    }
    return tra_nome;
  }

  public String[][] getTra_nome_Ajax(ConsultaRomaneiosEmbarqueEDIActionForm PARAM) {
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
        j = null;
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
    * FIL_RAZSOC: Method to get the field value.
    */
  public String getFil_razsoc() {
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
          fil_razsoc = (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"";
        } else {
          fil_razsoc = "";
        }
      }
    } catch (Exception e) {
      fil_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fil_razsoc;
  }

  public String[][] getFil_razsoc_Ajax(ConsultaRomaneiosEmbarqueEDIActionForm PARAM) {
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
          list[0] = new String[]{"fil_razsoc", (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":""};
        } else {
          list[0] = new String[]{"fil_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fil_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FIL_RAZSOC: Method to set the field value.
    */
  public void setFil_razsoc(String PARAM) {
    fil_razsoc = PARAM;
  }
  /**
    * DATA_EMISSAO: Method to get the field value.
    */
  public String getData_emissao() {
    return data_emissao;
  }
  /**
    * DATA_EMISSAO: Method to set the field value.
    */
  public void setData_emissao(String PARAM) {
    data_emissao = PARAM;
  }
  /**
    * DATA_EMISSAO_FINAL: Method to get the field value.
    */
  public String getData_emissao_final() {
    return data_emissao_final;
  }
  /**
    * DATA_EMISSAO_FINAL: Method to set the field value.
    */
  public void setData_emissao_final(String PARAM) {
    data_emissao_final = PARAM;
  }
  /**
    * ROMANEIO: Method to get the field value.
    */
  public String getRomaneio() {
    return romaneio;
  }
  /**
    * ROMANEIO: Method to set the field value.
    */
  public void setRomaneio(String PARAM) {
    romaneio = PARAM;
  }
  /**
    * NFS_NMRO: Method to get the field value.
    */
  public String getNfs_nmro() {
    return nfs_nmro;
  }
  /**
    * NFS_NMRO: Method to set the field value.
    */
  public void setNfs_nmro(String PARAM) {
    nfs_nmro = PARAM;
  }
  /**
    * F_TRA: Method to get the field value.
    */
  public String getF_tra() {
    return f_tra;
  }
  /**
    * F_TRA: Method to set the field value.
    */
  public void setF_tra(String PARAM) {
    f_tra = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tra_cdgo = null;
    tra_nome = null;
    fil_filial = null;
    fil_razsoc = null;
    data_emissao = null;
    data_emissao_final = null;
    romaneio = null;
    nfs_nmro = null;
    f_tra = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (!com.egen.util.text.Validate.isDate(data_emissao)) {
        errors.add("data_emissao", new ActionMessage("error.validate.date","Dt. Romaneio","data_emissao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
