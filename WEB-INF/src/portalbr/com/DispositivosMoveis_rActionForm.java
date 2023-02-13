package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 31/10/2011 11:09:37
 * Last Modify Date 31/10/2011 12:05:26
 */

public class DispositivosMoveis_rActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_usuario;
  public String nome_usuario;
  public String id_tablet;
  private boolean valida = false;
  public DispositivosMoveis_rActionForm() {
  }
  /**
    * CODIGO_USUARIO: Method to get the field value.
    */
  public String getCodigo_usuario() {
    return codigo_usuario;
  }
  /**
    * CODIGO_USUARIO: Method to set the field value.
    */
  public void setCodigo_usuario(String PARAM) {
    codigo_usuario = PARAM;
  }
  /**
    * NOME_USUARIO: Method to get the field value.
    */
  public String getNome_usuario() {
    return nome_usuario;
  }
  /**
    * NOME_USUARIO: Method to set the field value.
    */
  public void setNome_usuario(String PARAM) {
    nome_usuario = PARAM;
  }
  /**
    * ID_TABLET: Method to get the field value.
    */
  public String getId_tablet() {
    return id_tablet;
  }
  /**
    * ID_TABLET: Method to set the field value.
    */
  public void setId_tablet(String PARAM) {
    id_tablet = PARAM;
  }
  private Vector id_tabletList = new Vector(10, 10);
  public void setId_tabletList(java.util.Vector VECTOR) {
    id_tabletList = VECTOR;
  }
  public java.util.Vector getId_tabletList() {
    if (id_tabletList == null || id_tabletList.size() == 0) {
      id_tabletList = new Vector(10, 10);
      id_tabletLabelList = new Vector(10, 10);
      id_tabletList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      id_tabletLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Afv_tablet db_object = new Afv_tablet();
        String[][] select = {{"id", null},{"nome_equipamento", null}};
        Object[][] where = null;
        String[] order = {"nome_equipamento"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Afv_tablet) results.elementAt(i);
          id_tabletList.addElement(""+db_object.getId());
          id_tabletLabelList.addElement(""+db_object.getNome_equipamento());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "DispositivosMoveis_r.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return id_tabletList;
  }
  private java.util.Vector id_tabletLabelList = new Vector(10, 10);
  public void setId_tabletLabelList(java.util.Vector VECTOR) {
    id_tabletLabelList = VECTOR;
  }
  public java.util.Vector getId_tabletLabelList() {
    return id_tabletLabelList;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_usuario = null;
    nome_usuario = null;
    id_tablet = null;
  }
  /**
    * Validate fields and return errors.
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

    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
