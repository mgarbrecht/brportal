package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/02/2012 14:00:00
 * Last Modify Date 04/07/2012 12:18:31
 */

public class EmbarqueAmostrasActionForm extends org.apache.struts.action.ActionForm
{
  public String marca;
  public String tipo_linha;
  public String fil_filial;
  public String dt_inicial;
  public String dt_final;
  public String mix;
  public String fator;
  public String liv_cdgo;
  public String liv_descri;
  private boolean valida = false;
  public EmbarqueAmostrasActionForm() {
  }
  /**
    * MARCA: Método Gets para este campo
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Método Sets pára este campo.
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "EmbarqueAmostras.", e);
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
    * TIPO_LINHA: Método Gets para este campo
    */
  public String getTipo_linha() {
    return tipo_linha;
  }
  /**
    * TIPO_LINHA: Método Sets pára este campo.
    */
  public void setTipo_linha(String PARAM) {
    tipo_linha = PARAM;
  }
  private Vector tipo_linhaList = new Vector(10, 10);
  public void setTipo_linhaList(java.util.Vector VECTOR) {
    tipo_linhaList = VECTOR;
  }
  public java.util.Vector getTipo_linhaList() {
    if (tipo_linhaList == null || tipo_linhaList.size() == 0) {
      tipo_linhaList = new Vector(10, 10);
      tipo_linhaLabelList = new Vector(10, 10);
      tipo_linhaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      tipo_linhaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
        Object[][] where = {{"RV_DOMAIN","=","IND_ABERTO_FECHADO"}};
        String[] order = {"rv_meaning"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          tipo_linhaList.addElement(""+db_object.getRv_low_value());
          tipo_linhaLabelList.addElement(""+db_object.getRv_meaning());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "EmbarqueAmostras.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return tipo_linhaList;
  }
  private java.util.Vector tipo_linhaLabelList = new Vector(10, 10);
  public void setTipo_linhaLabelList(java.util.Vector VECTOR) {
    tipo_linhaLabelList = VECTOR;
  }
  public java.util.Vector getTipo_linhaLabelList() {
    return tipo_linhaLabelList;
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  private Vector fil_filialList = new Vector(10, 10);
  public void setFil_filialList(java.util.Vector VECTOR) {
    fil_filialList = VECTOR;
  }
  public java.util.Vector getFil_filialList() {
    if (fil_filialList == null || fil_filialList.size() == 0) {
      fil_filialList = new Vector(10, 10);
      fil_filialLabelList = new Vector(10, 10);
      fil_filialList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      fil_filialLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = {{"fil_filial", null},{"fil_razsoc", null}};
        Object[][] where = null;
        String[] order = {"fil_razsoc"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Filial) results.elementAt(i);
          fil_filialList.addElement(""+db_object.getFil_filial());
          fil_filialLabelList.addElement(""+db_object.getFil_razsoc());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "EmbarqueAmostras.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return fil_filialList;
  }
  private java.util.Vector fil_filialLabelList = new Vector(10, 10);
  public void setFil_filialLabelList(java.util.Vector VECTOR) {
    fil_filialLabelList = VECTOR;
  }
  public java.util.Vector getFil_filialLabelList() {
    return fil_filialLabelList;
  }
  /**
    * DT_INICIAL: Método Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Método Sets pára este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Método Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Método Sets pára este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * MIX: Método Gets para este campo
    */
  public String getMix() {
    return mix;
  }
  /**
    * MIX: Método Sets pára este campo.
    */
  public void setMix(String PARAM) {
    mix = PARAM;
  }
  Vector mixList = new Vector(10, 1);
  public java.util.Vector getMixList() {
    if (mixList == null || mixList.size() == 0) {
      mixList.addElement("T");
      mixLabelList.addElement("Todos");
      mixList.addElement("M");
      mixLabelList.addElement("No Mix");
      mixList.addElement("F");
      mixLabelList.addElement("Fora Mix");
    }
    java.util.Vector list = mixList;
    return list;
  }
  java.util.Vector mixLabelList = new Vector(10, 1);
  public java.util.Vector getMixLabelList() {
    java.util.Vector list = mixLabelList;
    return list;
  }
  /**
    * FATOR: Método Gets para este campo
    */
  public String getFator() {
    return fator;
  }
  /**
    * FATOR: Método Sets pára este campo.
    */
  public void setFator(String PARAM) {
    fator = PARAM;
  }
  /**
    * LIV_CDGO: Método Gets para este campo
    */
  public String getLiv_cdgo() {
    return liv_cdgo;
  }
  /**
    * LIV_CDGO: Método Sets pára este campo.
    */
  public void setLiv_cdgo(String PARAM) {
    liv_cdgo = PARAM;
  }
  /**
    * LIV_DESCRI: Método Gets para este campo
    */
  public String getLiv_descri() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (liv_cdgo != null && liv_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Livro db_object = new Livro();
        String[][] select = { {"liv_descri",null} };
        Object[][] where = { {"liv_codigo","=",com.egen.util.text.FormatNumber.toInt(liv_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Livro) results.elementAt(0);
          liv_descri = (db_object.getLiv_descri() != null) ? db_object.getLiv_descri() + "":"";
        } else {
          liv_descri = "";
        }
      }
    } catch (Exception e) {
      liv_descri = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return liv_descri;
  }

  public String[][] getLiv_descri_Ajax(EmbarqueAmostrasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLiv_cdgo() != null && PARAM.getLiv_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Livro db_object = new Livro();
        Object[][] where = { {"liv_codigo","like",PARAM.getLiv_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Livro) results.elementAt(0);
          list[0] = new String[]{"liv_descri", (db_object.getLiv_descri() != null) ? db_object.getLiv_descri() + "":""};
        } else {
          list[0] = new String[]{"liv_descri", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"liv_descri", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIV_DESCRI: Método Sets pára este campo.
    */
  public void setLiv_descri(String PARAM) {
    liv_descri = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    marca = null;
    tipo_linha = null;
    fil_filial = null;
    dt_inicial = null;
    dt_final = null;
    mix = null;
    fator = null;
    liv_cdgo = null;
    liv_descri = null;
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
