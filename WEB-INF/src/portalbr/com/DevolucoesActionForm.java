package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/12/2007 12:55:56
 * Last Modify Date 22/06/2015 13:34:40
 */

public class DevolucoesActionForm extends org.apache.struts.action.ActionForm
{
  public String marca;
  public String unn_codigo;
  public String rep_cdgo;
  public String rep_rzao;
  public String abre_automaticamente;
  public String mensagem;
  public String regional;
  private boolean valida = false;
  public DevolucoesActionForm() {
  }
  /**
    * MARCA: Method to get the field value.
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Method to set the field value.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  private Vector marcaList = new Vector(10, 10);
  public void setMarcaList(java.util.Vector VECTOR) {
    marcaList = VECTOR;
  }
  public java.util.Vector getMarcaList() {
    if (marcaList == null || marcaList.size() == 0) {
      marcaList = new Vector(10, 10);
      marcaLabelList = new Vector(10, 10);
      marcaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_marcas db_object = new Jw_marcas();
        String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
        Object[][] where = null;
        String[] order = {"descricao_marca"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_marcas) results.elementAt(i);
          marcaList.addElement(""+db_object.getCodigo_marca());
          marcaLabelList.addElement(""+db_object.getDescricao_marca());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Devolucoes.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return marcaList;
  }
  private java.util.Vector marcaLabelList = new Vector(10, 10);
  public void setMarcaLabelList(java.util.Vector VECTOR) {
    marcaLabelList = VECTOR;
  }
  public java.util.Vector getMarcaLabelList() {
    return marcaLabelList;
  }
  /**
    * UNN_CODIGO: Method to get the field value.
    */
  public String getUnn_codigo() {
    return unn_codigo;
  }
  /**
    * UNN_CODIGO: Method to set the field value.
    */
  public void setUnn_codigo(String PARAM) {
    unn_codigo = PARAM;
  }
  Vector unn_codigoList = new Vector(10, 1);
  public java.util.Vector getUnn_codigoList() {
    if (unn_codigoList == null || unn_codigoList.size() == 0) {
      unn_codigoList.addElement("");
      unn_codigoLabelList.addElement("TODAS");
      unn_codigoList.addElement("01");
      unn_codigoLabelList.addElement("MANUFATURADOS");
      unn_codigoList.addElement("02");
      unn_codigoLabelList.addElement("ASSANDALIADOS");
      unn_codigoList.addElement("03");
      unn_codigoLabelList.addElement("INJECAO DIRETA");
    }
    java.util.Vector list = unn_codigoList;
    return list;
  }
  java.util.Vector unn_codigoLabelList = new Vector(10, 1);
  public java.util.Vector getUnn_codigoLabelList() {
    java.util.Vector list = unn_codigoLabelList;
    return list;
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
    * REP_RZAO: Method to get the field value.
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = {{"rep_rzao",null}};
        Object[][] where = { {"rep_cdgo","like",rep_cdgo} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          rep_rzao = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        } else {
          rep_rzao = "";
        }
      }
    } catch (Exception e) {
      rep_rzao = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(DevolucoesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          list[0] = new String[]{"rep_rzao", (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":""};
        } else {
          list[0] = new String[]{"rep_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"rep_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to get the field value.
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to set the field value.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Method to get the field value.
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Method to set the field value.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    marca = null;
    unn_codigo = null;
    rep_cdgo = null;
    rep_rzao = null;
    abre_automaticamente = null;
    mensagem = null;
    regional = null;
  }
  /**
    * Validate fields and return errors.
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
