package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/02/2014 13:12:02
 * Last Modify Date 27/05/2014 15:03:18
 */

public class UploadArquivosActionForm extends org.apache.struts.action.ActionForm
{
  public String lidi_titulo;
  public String lidi_descricao;
  public String lidi_tien_id;
  private boolean valida = false;
  public UploadArquivosActionForm() {
  }
  /**
    * LIDI_TITULO: Método Gets para este campo
    */
  public String getLidi_titulo() {
    return lidi_titulo;
  }
  /**
    * LIDI_TITULO: Método Sets pára este campo.
    */
  public void setLidi_titulo(String PARAM) {
    lidi_titulo = PARAM;
  }
  /**
    * LIDI_DESCRICAO: Método Gets para este campo
    */
  public String getLidi_descricao() {
    return lidi_descricao;
  }
  /**
    * LIDI_DESCRICAO: Método Sets pára este campo.
    */
  public void setLidi_descricao(String PARAM) {
    lidi_descricao = PARAM;
  }
  /**
    * LIDI_TIEN_ID: Método Gets para este campo
    */
  public String getLidi_tien_id() {
    return lidi_tien_id;
  }
  /**
    * LIDI_TIEN_ID: Método Sets pára este campo.
    */
  public void setLidi_tien_id(String PARAM) {
    lidi_tien_id = PARAM;
  }
  private Vector lidi_tien_idList = new Vector(10, 10);
  public void setLidi_tien_idList(java.util.Vector VECTOR) {
    lidi_tien_idList = VECTOR;
  }
  public java.util.Vector getLidi_tien_idList() {
    lidi_tien_idList = new Vector(10, 10);
    lidi_tien_idLabelList = new Vector(10, 10);
    lidi_tien_idList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    lidi_tien_idLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Jw_tipos_usuarios db_object = new Jw_tipos_usuarios();
      String[][] select = {{"codigo", null},{"descricao", null}};
      Object[][] where = null;
      String[] order = {"tipo"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Jw_tipos_usuarios) results.elementAt(i);
        lidi_tien_idList.addElement(""+db_object.getCodigo());
        lidi_tien_idLabelList.addElement(""+db_object.getDescricao());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "UploadArquivos.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lidi_tien_idList;
  }
  private java.util.Vector lidi_tien_idLabelList = new Vector(10, 10);
  public void setLidi_tien_idLabelList(java.util.Vector VECTOR) {
    lidi_tien_idLabelList = VECTOR;
  }
  public java.util.Vector getLidi_tien_idLabelList() {
    return lidi_tien_idLabelList;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lidi_titulo = null;
    lidi_descricao = null;
    lidi_tien_id = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
