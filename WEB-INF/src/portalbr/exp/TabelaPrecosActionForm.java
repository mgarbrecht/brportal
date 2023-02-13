package portalbr.exp;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/04/2012 10:12:41
 * Last Modify Date 13/10/2015 08:06:38
 */

public class TabelaPrecosActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_livro;
  public String versao;
  public String marca;
  public String tipo_linha;
  public String dt_inicial;
  public String dt_final;
  public String cliente;
  public String pais;
  public String mix;
  public String abrir_cabedal;
  private boolean valida = false;
  public TabelaPrecosActionForm() {
  }
  /**
    * CODIGO_LIVRO: Method to get the field value.
    */
  public String getCodigo_livro() {
    return codigo_livro;
  }
  /**
    * CODIGO_LIVRO: Method to set the field value.
    */
  public void setCodigo_livro(String PARAM) {
    codigo_livro = PARAM;
  }
  /**
    * VERSAO: Method to get the field value.
    */
  public String getVersao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_livro != null && codigo_livro.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_tabela_preco_mercado_externo db_object = new Jw_tabela_preco_mercado_externo();
        String[][] select = { {"versao_tabela",null} };
        Object[][] where = { {"codigo_livro","=",com.egen.util.text.FormatNumber.toInteger(codigo_livro)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_tabela_preco_mercado_externo) results.elementAt(0);
          versao = ((db_object.getVersao_tabela() != null) ? com.egen.util.text.FormatDate.format(db_object.getVersao_tabela(), "dd/MM/yyyy HH:mm:ss") + "":"");
        } else {
          versao = "";
        }
      }
    } catch (Exception e) {
      versao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return versao;
  }

  public String[][] getVersao_Ajax(TabelaPrecosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_livro() != null && PARAM.getCodigo_livro().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_tabela_preco_mercado_externo db_object = new Jw_tabela_preco_mercado_externo();
        Object[][] where = { {"codigo_livro","=", PARAM.getCodigo_livro()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_tabela_preco_mercado_externo) results.elementAt(0);
          list[0] = new String[]{"versao", ((db_object.getVersao_tabela() != null) ? com.egen.util.text.FormatDate.format(db_object.getVersao_tabela(), "dd/MM/yyyy HH:mm:ss") + "":"")};
        } else {
          list[0] = new String[]{"versao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"versao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * VERSAO: Method to set the field value.
    */
  public void setVersao(String PARAM) {
    versao = PARAM;
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "TabelaPrecos.", e);
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
    * TIPO_LINHA: Method to get the field value.
    */
  public String getTipo_linha() {
    return tipo_linha;
  }
  /**
    * TIPO_LINHA: Method to set the field value.
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "TabelaPrecos.", e);
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
    * DT_INICIAL: Method to get the field value.
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Method to set the field value.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Method to get the field value.
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Method to set the field value.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * CLIENTE: Method to get the field value.
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Method to set the field value.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * PAIS: Method to get the field value.
    */
  public String getPais() {
    return pais;
  }
  /**
    * PAIS: Method to set the field value.
    */
  public void setPais(String PARAM) {
    pais = PARAM;
  }
  /**
    * MIX: Method to get the field value.
    */
  public String getMix() {
    return mix;
  }
  /**
    * MIX: Method to set the field value.
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
    * ABRIR_CABEDAL: Method to get the field value.
    */
  public String getAbrir_cabedal() {
    return abrir_cabedal;
  }
  /**
    * ABRIR_CABEDAL: Method to set the field value.
    */
  public void setAbrir_cabedal(String PARAM) {
    abrir_cabedal = PARAM;
  }
  Vector abrir_cabedalList = new Vector(10, 1);
  public java.util.Vector getAbrir_cabedalList() {
    if (abrir_cabedalList == null || abrir_cabedalList.size() == 0) {
      abrir_cabedalList.addElement("N");
      abrir_cabedalLabelList.addElement("Não");
      abrir_cabedalList.addElement("S");
      abrir_cabedalLabelList.addElement("Sim");
    }
    java.util.Vector list = abrir_cabedalList;
    return list;
  }
  java.util.Vector abrir_cabedalLabelList = new Vector(10, 1);
  public java.util.Vector getAbrir_cabedalLabelList() {
    java.util.Vector list = abrir_cabedalLabelList;
    return list;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_livro = null;
    versao = null;
    marca = null;
    tipo_linha = null;
    dt_inicial = null;
    dt_final = null;
    cliente = null;
    pais = null;
    mix = null;
    abrir_cabedal = null;
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
      if (com.egen.util.text.Validate.isNull(codigo_livro)) {
        errors.add("codigo_livro", new ActionMessage("error.validate.notnull","Livro","codigo_livro","0"));
      }
      if (com.egen.util.text.Validate.isNull(versao)) {
        errors.add("versao", new ActionMessage("error.validate.notnull","Versão","versao","0"));
      }
      if (com.egen.util.text.Validate.isNull(cliente)) {
        errors.add("cliente", new ActionMessage("error.validate.notnull","Cliente","cliente","0"));
      }
      if (com.egen.util.text.Validate.isNull(pais)) {
        errors.add("pais", new ActionMessage("error.validate.notnull","País","pais","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
