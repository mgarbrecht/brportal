package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/07/2010 09:48:08
 * Last Modify Date 23/06/2015 09:01:28
 */

public class NormasVendasActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_marca;
  public String modare;
  public String lin_cdgo;
  public String lin_nome;
  public String publicadas;
  public String resumo_linhas;
  public String mix_exportacao;
  private boolean valida = false;
  public NormasVendasActionForm() {
  }
  /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  private Vector codigo_marcaList = new Vector(10, 10);
  public void setCodigo_marcaList(java.util.Vector VECTOR) {
    codigo_marcaList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaList() {
    codigo_marcaList = new Vector(10, 10);
    codigo_marcaLabelList = new Vector(10, 10);
    codigo_marcaList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    codigo_marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Jw_marcas db_object = new Jw_marcas();
      String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
      Object[][] where = {{"codigo_marca","<>","9"}, {"codigo_marca","<>","18"}};
      String[] order = {"descricao_marca"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Jw_marcas) results.elementAt(i);
        codigo_marcaList.addElement(""+db_object.getCodigo_marca());
        codigo_marcaLabelList.addElement(""+db_object.getDescricao_marca());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "NormasVendas.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return codigo_marcaList;
  }
  private java.util.Vector codigo_marcaLabelList = new Vector(10, 10);
  public void setCodigo_marcaLabelList(java.util.Vector VECTOR) {
    codigo_marcaLabelList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaLabelList() {
    return codigo_marcaLabelList;
  }
  /**
    * MODARE: Method to get the field value.
    */
  public String getModare() {
    return modare;
  }
  /**
    * MODARE: Method to set the field value.
    */
  public void setModare(String PARAM) {
    modare = PARAM;
  }
  private Vector modareList = new Vector(10, 10);
  public void setModareList(java.util.Vector VECTOR) {
    modareList = VECTOR;
  }
  public java.util.Vector getModareList() {
    modareList = new Vector(10, 10);
    modareLabelList = new Vector(10, 10);
    modareList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    modareLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Jw_marcas db_object = new Jw_marcas();
      String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
      Object[][] where = {{"codigo_marca","<>","18"} };
      String[] order = {"descricao_marca"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Jw_marcas) results.elementAt(i);
        modareList.addElement(""+db_object.getCodigo_marca());
        modareLabelList.addElement(""+db_object.getDescricao_marca());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "NormasVendas.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return modareList;
  }
  private java.util.Vector modareLabelList = new Vector(10, 10);
  public void setModareLabelList(java.util.Vector VECTOR) {
    modareLabelList = VECTOR;
  }
  public java.util.Vector getModareLabelList() {
    return modareLabelList;
  }
  /**
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LIN_NOME: Method to get the field value.
    */
  public String getLin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        String[][] select = { {"lin_nome",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          lin_nome = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
        } else {
          lin_nome = "";
        }
      }
    } catch (Exception e) {
      lin_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(NormasVendasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          list[0] = new String[]{"lin_nome", (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":""};
        } else {
          list[0] = new String[]{"lin_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIN_NOME: Method to set the field value.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * PUBLICADAS: Method to get the field value.
    */
  public String getPublicadas() {
    return publicadas;
  }
  /**
    * PUBLICADAS: Method to set the field value.
    */
  public void setPublicadas(String PARAM) {
    publicadas = PARAM;
  }
  Vector publicadasList = new Vector(10, 1);
  public java.util.Vector getPublicadasList() {
    if (publicadasList == null || publicadasList.size() == 0) {
      publicadasList.addElement("S");
      publicadasLabelList.addElement("<bean:message bundle='ComercialResources' key='default.value.sim'/>");
      publicadasList.addElement("N");
      publicadasLabelList.addElement("<bean:message bundle='ComercialResources' key='default.value.nao'/>");
    }
    java.util.Vector list = publicadasList;
    return list;
  }
  java.util.Vector publicadasLabelList = new Vector(10, 1);
  public java.util.Vector getPublicadasLabelList() {
    java.util.Vector list = publicadasLabelList;
    return list;
  }
  /**
    * RESUMO_LINHAS: Method to get the field value.
    */
  public String getResumo_linhas() {
    return resumo_linhas;
  }
  /**
    * RESUMO_LINHAS: Method to set the field value.
    */
  public void setResumo_linhas(String PARAM) {
    resumo_linhas = PARAM;
  }
  Vector resumo_linhasList = new Vector(10, 1);
  public java.util.Vector getResumo_linhasList() {
    if (resumo_linhasList == null || resumo_linhasList.size() == 0) {
      resumo_linhasList.addElement("N");
      resumo_linhasLabelList.addElement("<bean:message bundle='ComercialResources' key='default.value.nao'/>");
      resumo_linhasList.addElement("S");
      resumo_linhasLabelList.addElement("<bean:message bundle='ComercialResources' key='default.value.sim'/>");
    }
    java.util.Vector list = resumo_linhasList;
    return list;
  }
  java.util.Vector resumo_linhasLabelList = new Vector(10, 1);
  public java.util.Vector getResumo_linhasLabelList() {
    java.util.Vector list = resumo_linhasLabelList;
    return list;
  }
  /**
    * MIX_EXPORTACAO: Method to get the field value.
    */
  public String getMix_exportacao() {
    return mix_exportacao;
  }
  /**
    * MIX_EXPORTACAO: Method to set the field value.
    */
  public void setMix_exportacao(String PARAM) {
    mix_exportacao = PARAM;
  }
  Vector mix_exportacaoList = new Vector(10, 1);
  public java.util.Vector getMix_exportacaoList() {
    if (mix_exportacaoList == null || mix_exportacaoList.size() == 0) {
      mix_exportacaoList.addElement("T");
      mix_exportacaoLabelList.addElement("Todos");
      mix_exportacaoList.addElement("S");
      mix_exportacaoLabelList.addElement("Sim");
      mix_exportacaoList.addElement("N");
      mix_exportacaoLabelList.addElement("Não");
    }
    java.util.Vector list = mix_exportacaoList;
    return list;
  }
  java.util.Vector mix_exportacaoLabelList = new Vector(10, 1);
  public java.util.Vector getMix_exportacaoLabelList() {
    java.util.Vector list = mix_exportacaoLabelList;
    return list;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_marca = null;
    modare = null;
    lin_cdgo = null;
    lin_nome = null;
    publicadas = null;
    resumo_linhas = null;
    mix_exportacao = null;
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
