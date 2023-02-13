package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/06/2010 14:04:05
 * Last Modify Date 07/06/2010 14:24:16
 */

public class PedidosClienteActionForm extends org.apache.struts.action.ActionForm
{
  public String status;
  public String data_inicial;
  public String data_final;
  private boolean valida = false;
  public PedidosClienteActionForm() {
  }
  /**
    * STATUS: Método Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Método Sets pára este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  private Vector statusList = new Vector(10, 10);
  public void setStatusList(java.util.Vector VECTOR) {
    statusList = VECTOR;
  }
  public java.util.Vector getStatusList() {
    if (statusList == null || statusList.size() == 0) {
      statusList = new Vector(10, 10);
      statusLabelList = new Vector(10, 10);
      statusList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      statusLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_abbreviation", null}};
        Object[][] where = {{"rv_domain","=","STATUS_PEDIDO_LOJA"}};
        String[] order = {"rv_abbreviation"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          statusList.addElement(""+db_object.getRv_low_value());
          statusLabelList.addElement(""+db_object.getRv_abbreviation());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "PedidosCliente.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return statusList;
  }
  private java.util.Vector statusLabelList = new Vector(10, 10);
  public void setStatusLabelList(java.util.Vector VECTOR) {
    statusLabelList = VECTOR;
  }
  public java.util.Vector getStatusLabelList() {
    return statusLabelList;
  }
  /**
    * DATA_INICIAL: Método Gets para este campo
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Método Sets pára este campo.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Método Gets para este campo
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Método Sets pára este campo.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    status = null;
    data_inicial = null;
    data_final = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(status)) {
        errors.add("status", new ActionMessage("error.validate.notnull","Status","status","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_inicial)) {
        errors.add("data_inicial", new ActionMessage("error.validate.notnull","Data Inicial","data_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_final)) {
        errors.add("data_final", new ActionMessage("error.validate.notnull","Data Final","data_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
