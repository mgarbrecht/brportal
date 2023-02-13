package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 15/02/2006 16:15:24
 * Last Modify Date 27/08/2009 16:48:33
 */

public class AgendaVisitasClientesActionForm extends org.apache.struts.action.ActionForm
{
  public String agvi_rep_cdgo;
  public String rep_rzao;
  public String agvc_id;
  public String agvi_dt_inicial;
  public String agvi_dt_final;
  public String agvi_id;
  public String agvc_agvi_id;
  public String pos;
  public String agvc_dt_exclusao;
  private boolean valida = false;
  public AgendaVisitasClientesActionForm() {
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
    * AGVC_DT_EXCLUSAO: Method to get the field value.
    */
  public String getAgvc_dt_exclusao() {
    return agvc_dt_exclusao;
  }
  /**
    * AGVC_DT_EXCLUSAO: Method to set the field value.
    */
  public void setAgvc_dt_exclusao(String PARAM) {
    agvc_dt_exclusao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    agvi_rep_cdgo = null;
    rep_rzao = null;
    agvc_id = null;
    agvi_dt_inicial = null;
    agvi_dt_final = null;
    agvi_id = null;
    agvc_agvi_id = null;
    pos = null;
    agvc_dt_exclusao = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      if (com.egen.util.text.Validate.isNull(agvi_dt_inicial)) {
        errors.add("agvi_dt_inicial", new ActionMessage("error.validate.notnull","Data Inicial","agvi_dt_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(agvi_dt_inicial)) {
        errors.add("agvi_dt_inicial", new ActionMessage("error.validate.date","Data Inicial","agvi_dt_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(agvi_dt_final)) {
        errors.add("agvi_dt_final", new ActionMessage("error.validate.notnull","Data Final","agvi_dt_final","0"));
      }
      if (!com.egen.util.text.Validate.isDate(agvi_dt_final)) {
        errors.add("agvi_dt_final", new ActionMessage("error.validate.date","Data Final","agvi_dt_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
