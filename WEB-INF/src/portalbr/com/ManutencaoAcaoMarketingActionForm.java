package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 24/05/2010 14:22:37
 * Last Modify Date 02/04/2013 15:33:10
 */

public class ManutencaoAcaoMarketingActionForm extends org.apache.struts.action.ActionForm
{
  public String data_entrega;
  public String acao;
  public String marca;
  public String codigo_material;
  public String descricao_material;
  public String situacao;
  public String cracha_usuario;
  private boolean valida = false;
  public ManutencaoAcaoMarketingActionForm() {
  }
  /**
    * DATA_ENTREGA: Method to get the field value.
    */
  public String getData_entrega() {
    return data_entrega;
  }
  /**
    * DATA_ENTREGA: Method to set the field value.
    */
  public void setData_entrega(String PARAM) {
    data_entrega = PARAM;
  }
  /**
    * ACAO: Method to get the field value.
    */
  public String getAcao() {
    return acao;
  }
  /**
    * ACAO: Method to set the field value.
    */
  public void setAcao(String PARAM) {
    acao = PARAM;
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
    marcaList = new Vector(10, 10);
    marcaLabelList = new Vector(10, 10);
    marcaList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    marcaLabelList.addElement("TODAS");
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Marcas_produtos_mkt_vw db_object = new Marcas_produtos_mkt_vw();
      String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
      Object[][] where = null;
      String[] order = {"descricao_marca"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Marcas_produtos_mkt_vw) results.elementAt(i);
        marcaList.addElement(""+db_object.getCodigo_marca());
        marcaLabelList.addElement(""+db_object.getDescricao_marca());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ManutencaoAcaoMarketing.", e);
    } finally {
      if (j != null) {
        j.close();
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
    * CODIGO_MATERIAL: Method to get the field value.
    */
  public String getCodigo_material() {
    return codigo_material;
  }
  /**
    * CODIGO_MATERIAL: Method to set the field value.
    */
  public void setCodigo_material(String PARAM) {
    codigo_material = PARAM;
  }
  /**
    * DESCRICAO_MATERIAL: Method to get the field value.
    */
  public String getDescricao_material() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_material != null && codigo_material.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipo_midia db_object = new Tipo_midia();
        String[][] select = { {"desc_tmidia",null} };
        Object[][] where = { {"cdgo_tmidia","=",com.egen.util.text.FormatNumber.toInteger(codigo_material)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipo_midia) results.elementAt(0);
          descricao_material = ((db_object.getDesc_tmidia() != null) ? db_object.getDesc_tmidia() + "":"");
        } else {
          descricao_material = "";
        }
      }
    } catch (Exception e) {
      descricao_material = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_material;
  }

  public String[][] getDescricao_material_Ajax(ManutencaoAcaoMarketingActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_material() != null && PARAM.getCodigo_material().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipo_midia db_object = new Tipo_midia();
        Object[][] where = { {"cdgo_tmidia","like",PARAM.getCodigo_material()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipo_midia) results.elementAt(0);
          list[0] = new String[]{"descricao_material", ((db_object.getDesc_tmidia() != null) ? db_object.getDesc_tmidia() + "":"")};
        } else {
          list[0] = new String[]{"descricao_material", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_material", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MATERIAL: Method to set the field value.
    */
  public void setDescricao_material(String PARAM) {
    descricao_material = PARAM;
  }
  /**
    * SITUACAO: Method to get the field value.
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Method to set the field value.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  private Vector situacaoList = new Vector(10, 10);
  public void setSituacaoList(java.util.Vector VECTOR) {
    situacaoList = VECTOR;
  }
  public java.util.Vector getSituacaoList() {
    situacaoList = new Vector(10, 10);
    situacaoLabelList = new Vector(10, 10);
    situacaoList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    situacaoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Acao_marketing_situacoes db_object = new Acao_marketing_situacoes();
      String[][] select = {{"codigo", null},{"descricao", null}};
      Object[][] where = {{"codigo","<>","9"}, {"codigo","<>","10"}};
      String[] order = {"descricao"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Acao_marketing_situacoes) results.elementAt(i);
        situacaoList.addElement(""+db_object.getCodigo());
        situacaoLabelList.addElement(""+db_object.getDescricao());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ManutencaoAcaoMarketing.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return situacaoList;
  }
  private java.util.Vector situacaoLabelList = new Vector(10, 10);
  public void setSituacaoLabelList(java.util.Vector VECTOR) {
    situacaoLabelList = VECTOR;
  }
  public java.util.Vector getSituacaoLabelList() {
    return situacaoLabelList;
  }
  /**
    * CRACHA_USUARIO: Method to get the field value.
    */
  public String getCracha_usuario() {
    return cracha_usuario;
  }
  /**
    * CRACHA_USUARIO: Method to set the field value.
    */
  public void setCracha_usuario(String PARAM) {
    cracha_usuario = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    data_entrega = null;
    acao = null;
    marca = null;
    codigo_material = null;
    descricao_material = null;
    situacao = null;
    cracha_usuario = null;
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
