package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/12/2011 10:52:54
 * Last Modify Date 14/12/2011 11:14:51
 */

public class ManterInfClientes_aActionForm extends org.apache.struts.action.ActionForm
{
  public String cli_cdgo;
  public String cli_rzao;
  public String esc_seqn;
  public String somente_etiqueta;
  private boolean valida = false;
  public ManterInfClientes_aActionForm() {
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

  public String[][] getCli_rzao_Ajax(ManterInfClientes_aActionForm PARAM) {
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
      somente_etiquetaList.addElement("S");
      somente_etiquetaLabelList.addElement("Sim");
      somente_etiquetaList.addElement("N");
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cli_cdgo = null;
    cli_rzao = null;
    esc_seqn = null;
    somente_etiqueta = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (com.egen.util.text.Validate.isValidate("update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(cli_cdgo)) {
        errors.add("cli_cdgo", new ActionMessage("error.validate.notnull","Cliente","cli_cdgo","0"));
      }
      if (com.egen.util.text.Validate.isNull(esc_seqn)) {
        errors.add("esc_seqn", new ActionMessage("error.validate.notnull","Seq.","esc_seqn","0"));
      }
      if (com.egen.util.text.Validate.isNull(somente_etiqueta)) {
        errors.add("somente_etiqueta", new ActionMessage("error.validate.notnull","Obriga Etiqueta","somente_etiqueta","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
