package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/04/2006 10:39:36
 * Last Modify Date 07/01/2015 11:10:44
 */

public class PlusProdutosActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String lin_nome;
  public String ref_cdgo;
  public String ref_desc;
  public String status;
  private boolean valida = false;
  public PlusProdutosActionForm() {
  }
  /**
    * LIN_CDGO: M�todo Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: M�todo Sets p�ra este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LIN_NOME: M�todo Gets para este campo
    */
  public String getLin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        String[][] select = {{"lin_nome",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          lin_nome = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
        } else {
          lin_nome = "";
        }
      }
    } catch (Exception e) {
      lin_nome = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(PlusProdutosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          list[0] = new String[]{"lin_nome", (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":""};
        } else {
          list[0] = new String[]{"lin_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_nome", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * LIN_NOME: M�todo Sets p�ra este campo.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * REF_CDGO: M�todo Gets para este campo
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: M�todo Sets p�ra este campo.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * REF_DESC: M�todo Gets para este campo
    */
  public String getRef_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0 && ref_cdgo != null && ref_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        String[][] select = {{"ref_desc",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(lin_cdgo)}, {"ref_cdgo","=",com.egen.util.text.FormatNumber.toInteger(ref_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          ref_desc = (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":"";
        } else {
          ref_desc = "";
        }
      }
    } catch (Exception e) {
      ref_desc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return ref_desc;
  }

  public String[][] getRef_desc_Ajax(PlusProdutosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0 && PARAM.getRef_cdgo() != null && PARAM.getRef_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        Object[][] where = { {"lin_cdgo","=",PARAM.getLin_cdgo()}, {"ref_cdgo","=",PARAM.getRef_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          list[0] = new String[]{"ref_desc", (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":""};
        } else {
          list[0] = new String[]{"ref_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"ref_desc", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * REF_DESC: M�todo Sets p�ra este campo.
    */
  public void setRef_desc(String PARAM) {
    ref_desc = PARAM;
  }
  /**
    * STATUS: M�todo Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: M�todo Sets p�ra este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  Vector statusList = new Vector(10, 1);
  public java.util.Vector getStatusList() {
    if (statusList == null || statusList.size() == 0) {
      statusList.addElement("Ativo");
      statusLabelList.addElement("Ativas");
      statusList.addElement("Inativo");
      statusLabelList.addElement("Inativas");
      statusList.addElement("");
      statusLabelList.addElement("Todas");
    }
    java.util.Vector list = statusList;
    return list;
  }
  java.util.Vector statusLabelList = new Vector(10, 1);
  public java.util.Vector getStatusLabelList() {
    java.util.Vector list = statusLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    lin_nome = null;
    ref_cdgo = null;
    ref_desc = null;
    status = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (!com.egen.util.text.Validate.isRegex(lin_cdgo, "^[0-9]*$")) {
        errors.add("lin_cdgo", new ActionMessage("error.validate.regex","Linha","lin_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ref_cdgo, "^[0-9]*$")) {
        errors.add("ref_cdgo", new ActionMessage("error.validate.regex","Refer�ncia","ref_cdgo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
