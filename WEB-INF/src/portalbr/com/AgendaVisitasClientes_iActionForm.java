package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/02/2006 11:20:18
 * Last Modify Date 21/08/2013 12:13:26
 */

public class AgendaVisitasClientes_iActionForm extends org.apache.struts.action.ActionForm
{
  public String agvi_rep_cdgo;
  public String rep_rzao;
  public String agvi_dt_inicial;
  public String agvi_dt_final;
  public String agvc_id;
  public String agvc_agvi_id;
  public String agvc_cli_cdgo;
  public String cli_rzao;
  public String agvc_tipo;
  public String agvi_id;
  public String pos;
  private boolean valida = false;
  public AgendaVisitasClientes_iActionForm() {
  }
  /**
    * AGVI_REP_CDGO: Method to get the field value.
    */
  public String getAgvi_rep_cdgo() {
    return agvi_rep_cdgo;
  }
  /**
    * AGVI_REP_CDGO: Method to set the field value.
    */
  public void setAgvi_rep_cdgo(String PARAM) {
    agvi_rep_cdgo = PARAM;
  }
  /**
    * REP_RZAO: Method to get the field value.
    */
  public String getRep_rzao() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (agvi_rep_cdgo != null && agvi_rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Rep db_object = new portalbr.dbobj.table.Rep();
        Object[][] where = { {"rep_cdgo","like",agvi_rep_cdgo} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Rep) results.elementAt(0);
          fieldRelationValue = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    rep_rzao = fieldRelationValue;
    return rep_rzao;
  }
  /**
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * AGVI_DT_INICIAL: Method to get the field value.
    */
  public String getAgvi_dt_inicial() {
    return agvi_dt_inicial;
  }
  /**
    * AGVI_DT_INICIAL: Method to set the field value.
    */
  public void setAgvi_dt_inicial(String PARAM) {
    agvi_dt_inicial = PARAM;
  }
  /**
    * AGVI_DT_FINAL: Method to get the field value.
    */
  public String getAgvi_dt_final() {
    return agvi_dt_final;
  }
  /**
    * AGVI_DT_FINAL: Method to set the field value.
    */
  public void setAgvi_dt_final(String PARAM) {
    agvi_dt_final = PARAM;
  }
  /**
    * AGVC_ID: Method to get the field value.
    */
  public String getAgvc_id() {
    return agvc_id;
  }
  /**
    * AGVC_ID: Method to set the field value.
    */
  public void setAgvc_id(String PARAM) {
    agvc_id = PARAM;
  }
  /**
    * AGVC_AGVI_ID: Method to get the field value.
    */
  public String getAgvc_agvi_id() {
    return agvc_agvi_id;
  }
  /**
    * AGVC_AGVI_ID: Method to set the field value.
    */
  public void setAgvc_agvi_id(String PARAM) {
    agvc_agvi_id = PARAM;
  }
  /**
    * AGVC_CLI_CDGO: Method to get the field value.
    */
  public String getAgvc_cli_cdgo() {
    return agvc_cli_cdgo;
  }
  /**
    * AGVC_CLI_CDGO: Method to set the field value.
    */
  public void setAgvc_cli_cdgo(String PARAM) {
    agvc_cli_cdgo = PARAM;
  }
  /**
    * CLI_RZAO: Method to get the field value.
    */
  public String getCli_rzao() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (agvc_cli_cdgo != null && agvc_cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Cli db_object = new portalbr.dbobj.table.Cli();
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(agvc_cli_cdgo)} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Cli) results.elementAt(0);
          fieldRelationValue = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    cli_rzao = fieldRelationValue;
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Method to set the field value.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * AGVC_TIPO: Method to get the field value.
    */
  public String getAgvc_tipo() {
    return agvc_tipo;
  }
  /**
    * AGVC_TIPO: Method to set the field value.
    */
  public void setAgvc_tipo(String PARAM) {
    agvc_tipo = PARAM;
  }
  Vector agvc_tipoList = new Vector(10, 1);
  public java.util.Vector getAgvc_tipoList() {
    if (agvc_tipoList == null || agvc_tipoList.size() == 0) {
      agvc_tipoList.addElement("R");
      agvc_tipoLabelList.addElement("Reposição");
      agvc_tipoList.addElement("V");
      agvc_tipoLabelList.addElement("Venda");
      agvc_tipoList.addElement("A");
      agvc_tipoLabelList.addElement("Venda e Reposição");
    }
    java.util.Vector list = agvc_tipoList;
    return list;
  }
  java.util.Vector agvc_tipoLabelList = new Vector(10, 1);
  public java.util.Vector getAgvc_tipoLabelList() {
    java.util.Vector list = agvc_tipoLabelList;
    return list;
  }
  /**
    * AGVI_ID: Method to get the field value.
    */
  public String getAgvi_id() {
    return agvi_id;
  }
  /**
    * AGVI_ID: Method to set the field value.
    */
  public void setAgvi_id(String PARAM) {
    agvi_id = PARAM;
  }
  /**
    * POS: Method to get the field value.
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Method to set the field value.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    agvi_rep_cdgo = null;
    rep_rzao = null;
    agvi_dt_inicial = null;
    agvi_dt_final = null;
    agvc_id = null;
    agvc_agvi_id = null;
    agvc_cli_cdgo = null;
    cli_rzao = null;
    agvc_tipo = null;
    agvi_id = null;
    pos = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(agvc_tipo)) {
        errors.add("agvc_tipo", new ActionMessage("error.validate.notnull","Tipo","agvc_tipo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
