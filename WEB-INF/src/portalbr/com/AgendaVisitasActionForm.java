package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 15/02/2006 15:35:13
 * Last Modify Date 04/04/2013 09:44:27
 */

public class AgendaVisitasActionForm extends org.apache.struts.action.ActionForm
{
  public String agvi_rep_cdgo;
  public String rep_rzao;
  public String agvi_dt_inicial;
  public String agvi_dt_final;
  public String codigo_representante;
  public String regional;
  public String pos;
  public String agvi_id;
  public String dt_inicial;
  public String dt_final;
  private boolean valida = false;
  public AgendaVisitasActionForm() {
  }
  /**
    * AGVI_REP_CDGO: Método Gets para este campo
    */
  public String getAgvi_rep_cdgo() {
    return agvi_rep_cdgo;
  }
  /**
    * AGVI_REP_CDGO: Método Sets pára este campo.
    */
  public void setAgvi_rep_cdgo(String PARAM) {
    agvi_rep_cdgo = PARAM;
  }
  /**
    * REP_RZAO: Método Gets para este campo
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
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * AGVI_DT_INICIAL: Método Gets para este campo
    */
  public String getAgvi_dt_inicial() {
    return agvi_dt_inicial;
  }
  /**
    * AGVI_DT_INICIAL: Método Sets pára este campo.
    */
  public void setAgvi_dt_inicial(String PARAM) {
    agvi_dt_inicial = PARAM;
  }
  /**
    * AGVI_DT_FINAL: Método Gets para este campo
    */
  public String getAgvi_dt_final() {
    return agvi_dt_final;
  }
  /**
    * AGVI_DT_FINAL: Método Sets pára este campo.
    */
  public void setAgvi_dt_final(String PARAM) {
    agvi_dt_final = PARAM;
  }
  /**
    * CODIGO_REPRESENTANTE: Método Gets para este campo
    */
  public String getCodigo_representante() {
    return codigo_representante;
  }
  /**
    * CODIGO_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setCodigo_representante(String PARAM) {
    codigo_representante = PARAM;
  }
  /**
    * REGIONAL: Método Gets para este campo
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Método Sets pára este campo.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * POS: Método Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Método Sets pára este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * AGVI_ID: Método Gets para este campo
    */
  public String getAgvi_id() {
    return agvi_id;
  }
  /**
    * AGVI_ID: Método Sets pára este campo.
    */
  public void setAgvi_id(String PARAM) {
    agvi_id = PARAM;
  }
  /**
    * DT_INICIAL: Método Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Método Sets pára este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Método Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Método Sets pára este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    agvi_rep_cdgo = null;
    rep_rzao = null;
    agvi_dt_inicial = null;
    agvi_dt_final = null;
    codigo_representante = null;
    regional = null;
    pos = null;
    agvi_id = null;
    dt_inicial = null;
    dt_final = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,insert_action,", request)) {
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
