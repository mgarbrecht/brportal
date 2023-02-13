package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/03/2006 10:11:03
 * Last Modify Date 18/12/2014 08:46:50
 */

public class FotosLinhaClienteActionForm extends org.apache.struts.action.ActionForm
{
  public String linha;
  private boolean valida = false;
  public FotosLinhaClienteActionForm() {
  }
  /**
    * LINHA: Método Gets para este campo
    */
  public String getLinha() {
    return linha;
  }
  /**
    * LINHA: Método Sets pára este campo.
    */
  public void setLinha(String PARAM) {
    linha = PARAM;
  }
  private Vector < String > linhaList = new Vector < String > (10, 10);
  public void setLinhaList(java.util.Vector < String > VECTOR) {
    linhaList = VECTOR;
  }
  public java.util.Vector < String > getLinhaList() {
    linhaList = new Vector < String > (10, 10);
    linhaLabelList = new Vector < String > (10, 10);
    linhaList.addElement("");
    linhaLabelList.addElement(java.util.ResourceBundle.getBundle("ApplicationResources").getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      portalbr.dbobj.view.Jw_fotos_linhas_cliente db_object = new portalbr.dbobj.view.Jw_fotos_linhas_cliente();
      String[][] select = null;
      Object[][] where = null;
      String[] order = null;
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (portalbr.dbobj.view.Jw_fotos_linhas_cliente) results.elementAt(i);
        linhaList.addElement(""+db_object.getLin_cdgo());
        linhaLabelList.addElement(""+db_object.getLin_nome());
      }
    } catch (Exception e) {
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return linhaList;
  }
  private java.util.Vector < String > linhaLabelList = new Vector < String > (10, 10);
  public void setLinhaLabelList(java.util.Vector < String > VECTOR) {
    linhaLabelList = VECTOR;
  }
  public java.util.Vector < String > getLinhaLabelList() {
    return linhaLabelList;
  }

  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    linha = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
