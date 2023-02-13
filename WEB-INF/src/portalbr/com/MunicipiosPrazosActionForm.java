package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 29/10/2013 14:49:10
 * Last Modify Date 08/01/2015 08:48:37
 */

public class MunicipiosPrazosActionForm extends org.apache.struts.action.ActionForm
{
  public String est_unifed;
  public String codigo;
  public String descricao_municipio;
  public String descricao;
  public String distrito;
  public String codigo_ibge;
  public String cep_inicial;
  public String cep_final;
  private boolean valida = false;
  public MunicipiosPrazosActionForm() {
  }
  /**
    * EST_UNIFED: Método Gets para este campo
    */
  public String getEst_unifed() {
    return est_unifed;
  }
  /**
    * EST_UNIFED: Método Sets pára este campo.
    */
  public void setEst_unifed(String PARAM) {
    est_unifed = PARAM;
  }
  private Vector est_unifedList = new Vector(10, 10);
  public void setEst_unifedList(java.util.Vector VECTOR) {
    est_unifedList = VECTOR;
  }
  public java.util.Vector getEst_unifedList() {
    est_unifedList = new Vector(10, 10);
    est_unifedLabelList = new Vector(10, 10);
    est_unifedList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    est_unifedLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Estados db_object = new Estados();
      String[][] select = {{"est_unifed", null},{"est_descri", null}};
      Object[][] where = {{"pais_codigo", "=", "55"},{"est_exportador","=","N"}};
      String[] order = {"est_unifed"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Estados) results.elementAt(i);
        est_unifedList.addElement(""+db_object.getEst_unifed());
        est_unifedLabelList.addElement(db_object.getEst_unifed() + " - "+db_object.getEst_descri());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "MunicipiosPrazos.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return est_unifedList;
  }
  private java.util.Vector est_unifedLabelList = new Vector(10, 10);
  public void setEst_unifedLabelList(java.util.Vector VECTOR) {
    est_unifedLabelList = VECTOR;
  }
  public java.util.Vector getEst_unifedLabelList() {
    return est_unifedLabelList;
  }/**
    * CODIGO: Método Gets para este campo
    */

  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Método Sets pára este campo.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * DESCRICAO_MUNICIPIO: Método Gets para este campo
    */
  public String getDescricao_municipio() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo != null && codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_municipios db_object = new Jw_municipios();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInteger(codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_municipios) results.elementAt(0);
          descricao_municipio = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          descricao_municipio = "";
        }
      }
    } catch (Exception e) {
      descricao_municipio = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_municipio;
  }

  public String[][] getDescricao_municipio_Ajax(MunicipiosPrazosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo() != null && PARAM.getCodigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_municipios db_object = new Jw_municipios();
        Object[][] where = { {"codigo","like",PARAM.getCodigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_municipios) results.elementAt(0);
          list[0] = new String[]{"descricao_municipio", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"descricao_municipio", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_municipio", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MUNICIPIO: Método Sets pára este campo.
    */
  public void setDescricao_municipio(String PARAM) {
    descricao_municipio = PARAM;
  }
  /**
    * DESCRICAO: Método Gets para este campo
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: Método Sets pára este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * DISTRITO: Método Gets para este campo
    */
  public String getDistrito() {
    return distrito;
  }
  /**
    * DISTRITO: Método Sets pára este campo.
    */
  public void setDistrito(String PARAM) {
    distrito = PARAM;
  }
  /**
    * CODIGO_IBGE: Método Gets para este campo
    */
  public String getCodigo_ibge() {
    return codigo_ibge;
  }
  /**
    * CODIGO_IBGE: Método Sets pára este campo.
    */
  public void setCodigo_ibge(String PARAM) {
    codigo_ibge = PARAM;
  }
  /**
    * CEP_INICIAL: Método Gets para este campo
    */
  public String getCep_inicial() {
    return cep_inicial;
  }
  /**
    * CEP_INICIAL: Método Sets pára este campo.
    */
  public void setCep_inicial(String PARAM) {
    cep_inicial = PARAM;
  }
  /**
    * CEP_FINAL: Método Gets para este campo
    */
  public String getCep_final() {
    return cep_final;
  }
  /**
    * CEP_FINAL: Método Sets pára este campo.
    */
  public void setCep_final(String PARAM) {
    cep_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    est_unifed = null;
    codigo = null;
    descricao_municipio = null;
    descricao = null;
    distrito = null;
    codigo_ibge = null;
    cep_inicial = null;
    cep_final = null;
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
