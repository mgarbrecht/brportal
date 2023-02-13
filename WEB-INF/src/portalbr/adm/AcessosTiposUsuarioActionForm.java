package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/04/2010 11:31:17
 * Last Modify Date 07/04/2010 12:39:26
 */

public class AcessosTiposUsuarioActionForm extends org.apache.struts.action.ActionForm
{
  public String actu_id;
  public String actu_tius_tipo;
  public String actu_inte_id;
  public String inte_nome;
  private boolean valida = false;
  public AcessosTiposUsuarioActionForm() {
  }
  /**
    * ACTU_ID: Método Gets para este campo
    */
  public String getActu_id() {
    return actu_id;
  }
  /**
    * ACTU_ID: Método Sets pára este campo.
    */
  public void setActu_id(String PARAM) {
    actu_id = PARAM;
  }
  /**
    * ACTU_TIUS_TIPO: Método Gets para este campo
    */
  public String getActu_tius_tipo() {
    return actu_tius_tipo;
  }
  /**
    * ACTU_TIUS_TIPO: Método Sets pára este campo.
    */
  public void setActu_tius_tipo(String PARAM) {
    actu_tius_tipo = PARAM;
  }
  private Vector actu_tius_tipoList = new Vector(10, 10);
  public void setActu_tius_tipoList(java.util.Vector VECTOR) {
    actu_tius_tipoList = VECTOR;
  }
  public java.util.Vector getActu_tius_tipoList() {
    if (actu_tius_tipoList == null || actu_tius_tipoList.size() == 0) {
      actu_tius_tipoList = new Vector(10, 10);
      actu_tius_tipoLabelList = new Vector(10, 10);
      actu_tius_tipoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      actu_tius_tipoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_usuario_loja db_object = new Tipos_usuario_loja();
        String[][] select = {{"tius_tipo", null},{"tius_nome", null}};
        Object[][] where = null;
        String[] order = {"tius_nome"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Tipos_usuario_loja) results.elementAt(i);
          actu_tius_tipoList.addElement(""+db_object.getTius_tipo());
          actu_tius_tipoLabelList.addElement(""+db_object.getTius_nome());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "AcessosTiposUsuario.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return actu_tius_tipoList;
  }
  private java.util.Vector actu_tius_tipoLabelList = new Vector(10, 10);
  public void setActu_tius_tipoLabelList(java.util.Vector VECTOR) {
    actu_tius_tipoLabelList = VECTOR;
  }
  public java.util.Vector getActu_tius_tipoLabelList() {
    return actu_tius_tipoLabelList;
  }
  /**
    * ACTU_INTE_ID: Método Gets para este campo
    */
  public String getActu_inte_id() {
    return actu_inte_id;
  }
  /**
    * ACTU_INTE_ID: Método Sets pára este campo.
    */
  public void setActu_inte_id(String PARAM) {
    actu_inte_id = PARAM;
  }
  /**
    * INTE_NOME: Método Gets para este campo
    */
  public String getInte_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (actu_inte_id != null && actu_inte_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Interfaces_loja db_object = new Interfaces_loja();
        String[][] select = { {"inte_nome",null} };
        Object[][] where = { {"inte_id","=",actu_inte_id + ""}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Interfaces_loja) results.elementAt(0);
        } else {
        }
      }
    } catch (Exception e) {
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return inte_nome;
  }

  public String[][] getInte_nome_Ajax(AcessosTiposUsuarioActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getActu_inte_id() != null && PARAM.getActu_inte_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Interfaces_loja db_object = new Interfaces_loja();
        Object[][] where = { {"inte_id","=",PARAM.getActu_inte_id() + ""}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Interfaces_loja) results.elementAt(0);
        } else {
        }
      }
    } catch (Exception e) {
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * INTE_NOME: Método Sets pára este campo.
    */
  public void setInte_nome(String PARAM) {
    inte_nome = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    actu_id = null;
    actu_tius_tipo = null;
    actu_inte_id = null;
    inte_nome = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(actu_tius_tipo)) {
        errors.add("actu_tius_tipo", new ActionMessage("error.validate.notnull","Tipo Usuário","actu_tius_tipo","0"));
      }
      if (com.egen.util.text.Validate.isNull(actu_inte_id)) {
        errors.add("actu_inte_id", new ActionMessage("error.validate.notnull","Interface","actu_inte_id","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(actu_inte_id)) {
        errors.add("actu_inte_id", new ActionMessage("error.validate.number","Interface","actu_inte_id","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
