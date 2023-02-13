package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/03/2006 14:39:13
 * Last Modify Date 23/06/2015 09:02:12
 */

public class NormasVendaActionForm extends org.apache.struts.action.ActionForm
{
  public String colecao;
  private boolean valida = false;
  public NormasVendaActionForm() {
  }
  /**
    * COLECAO: Method to get the field value.
    */
  public String getColecao() {
    return colecao;
  }
  /**
    * COLECAO: Method to set the field value.
    */
  public void setColecao(String PARAM) {
    colecao = PARAM;
  }
  private Vector colecaoList = new Vector(10, 10);
  public void setColecaoList(java.util.Vector VECTOR) {
    colecaoList = VECTOR;
  }
  public java.util.Vector getColecaoList() {
    colecaoList = new Vector(10, 10);
    colecaoLabelList = new Vector(10, 10);
    colecaoList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    colecaoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Jw_normas_venda_marcas db_object = new Jw_normas_venda_marcas();
      String[][] select = {{"CODIGO_MARCA", null},{"DESCRICAO_MARCA", null}};
      Object[][] where = null;
      String[] order = {"DESCRICAO_MARCA"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Jw_normas_venda_marcas) results.elementAt(i);
        colecaoList.addElement(""+db_object.getCodigo_marca());
        colecaoLabelList.addElement(""+db_object.getDescricao_marca());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "NormasVenda.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return colecaoList;
  }
  private java.util.Vector colecaoLabelList = new Vector(10, 10);
  public void setColecaoLabelList(java.util.Vector VECTOR) {
    colecaoLabelList = VECTOR;
  }
  public java.util.Vector getColecaoLabelList() {
    return colecaoLabelList;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    colecao = null;
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
      if (com.egen.util.text.Validate.isNull(colecao)) {
        errors.add("colecao", new ActionMessage("error.validate.notnull",java.util.ResourceBundle.getBundle("ComercialResources").getString("NormasVenda.colecao"), "colecao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
