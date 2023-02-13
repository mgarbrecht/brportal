package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/12/2011 09:30:10
 * Last Modify Date 21/08/2013 11:54:24
 */

public class ManterInfClientesActionForm extends org.apache.struts.action.ActionForm
{
  public String gre_grupo;
  public String gre_descricao;
  public String cli_cdgo;
  public String cli_rzao;
  public String esc_seqn;
  public String somente_etiqueta;
  public String cb_agrupar_grupo;
  private boolean valida = false;
  public ManterInfClientesActionForm() {
  }
  /**
    * GRE_GRUPO: Método Gets para este campo
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Método Sets pára este campo.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
  }
  /**
    * GRE_DESCRICAO: Método Gets para este campo
    */
  public String getGre_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (gre_grupo != null && gre_grupo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        String[][] select = { {"gre_descricao",null} };
        Object[][] where = { {"gre_grupo","=",com.egen.util.text.FormatNumber.toInt(gre_grupo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Grupo_economico) results.elementAt(0);
          gre_descricao = (db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":"";
        } else {
          gre_descricao = "";
        }
      }
    } catch (Exception e) {
      gre_descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return gre_descricao;
  }

  public String[][] getGre_descricao_Ajax(ManterInfClientesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGre_grupo() != null && PARAM.getGre_grupo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        Object[][] where = { {"gre_grupo","like",PARAM.getGre_grupo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Grupo_economico) results.elementAt(0);
          list[0] = new String[]{"gre_descricao", (db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":""};
        } else {
          list[0] = new String[]{"gre_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"gre_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * GRE_DESCRICAO: Método Sets pára este campo.
    */
  public void setGre_descricao(String PARAM) {
    gre_descricao = PARAM;
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = { {"cli_rzao",null} };
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        } else {
          cli_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(ManterInfClientesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=", PARAM.getCli_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * ESC_SEQN: Método Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Método Sets pára este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * SOMENTE_ETIQUETA: Método Gets para este campo
    */
  public String getSomente_etiqueta() {
    return somente_etiqueta;
  }
  /**
    * SOMENTE_ETIQUETA: Método Sets pára este campo.
    */
  public void setSomente_etiqueta(String PARAM) {
    somente_etiqueta = PARAM;
  }
  Vector somente_etiquetaList = new Vector(10, 1);
  public java.util.Vector getSomente_etiquetaList() {
    if (somente_etiquetaList == null || somente_etiquetaList.size() == 0) {
      somente_etiquetaList.addElement("");
      somente_etiquetaLabelList.addElement("Todos");
      somente_etiquetaList.addElement("Sim");
      somente_etiquetaLabelList.addElement("Sim");
      somente_etiquetaList.addElement("Não");
      somente_etiquetaLabelList.addElement("Não");
    }
    java.util.Vector list = somente_etiquetaList;
    return list;
  }
  java.util.Vector somente_etiquetaLabelList = new Vector(10, 1);
  public java.util.Vector getSomente_etiquetaLabelList() {
    java.util.Vector list = somente_etiquetaLabelList;
    return list;
  }
  /**
    * CB_AGRUPAR_GRUPO: Método Gets para este campo
    */
  public String getCb_agrupar_grupo() {
    return cb_agrupar_grupo;
  }
  /**
    * CB_AGRUPAR_GRUPO: Método Sets pára este campo.
    */
  public void setCb_agrupar_grupo(String PARAM) {
    cb_agrupar_grupo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gre_grupo = null;
    gre_descricao = null;
    cli_cdgo = null;
    cli_rzao = null;
    esc_seqn = null;
    somente_etiqueta = null;
    cb_agrupar_grupo = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
