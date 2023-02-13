package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/02/2006 08:34:20
 * Last Modify Date 04/04/2013 09:43:41
 */

public class AgendaVisitas_iActionForm extends org.apache.struts.action.ActionForm
{
  public String agvi_id;
  public String agvi_rep_cdgo;
  public String rep_rzao;
  public String agvi_dt_inicial;
  public String agvi_dt_final;
  public String agvi_dt_exclusao;
  public String codigo_representante;
  public String regional;
  public String dt_inicial;
  public String dt_final;
  public String rep_cdgo;
  private boolean valida = false;
  public AgendaVisitas_iActionForm() {
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
    * AGVI_DT_EXCLUSAO: Method to get the field value.
    */
  public String getAgvi_dt_exclusao() {
    return agvi_dt_exclusao;
  }
  /**
    * AGVI_DT_EXCLUSAO: Method to set the field value.
    */
  public void setAgvi_dt_exclusao(String PARAM) {
    agvi_dt_exclusao = PARAM;
  }
  /**
    * CODIGO_REPRESENTANTE: Method to get the field value.
    */
  public String getCodigo_representante() {
    return codigo_representante;
  }
  /**
    * CODIGO_REPRESENTANTE: Method to set the field value.
    */
  public void setCodigo_representante(String PARAM) {
    codigo_representante = PARAM;
  }
  /**
    * REGIONAL: Method to get the field value.
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Method to set the field value.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * DT_INICIAL: Method to get the field value.
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Method to set the field value.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Method to get the field value.
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Method to set the field value.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    agvi_id = null;
    agvi_rep_cdgo = null;
    rep_rzao = null;
    agvi_dt_inicial = null;
    agvi_dt_final = null;
    agvi_dt_exclusao = null;
    codigo_representante = null;
    regional = null;
    dt_inicial = null;
    dt_final = null;
    rep_cdgo = null;
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
      if (!com.egen.util.text.Validate.isNumber(agvi_rep_cdgo)) {
        errors.add("agvi_rep_cdgo", new ActionMessage("error.validate.number","Representante","agvi_rep_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isDate(agvi_dt_inicial)) {
        errors.add("agvi_dt_inicial", new ActionMessage("error.validate.date","Data Inicial","agvi_dt_inicial","0"));
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
