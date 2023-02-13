package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/04/2006 17:36:21
 * Last Modify Date 09/09/2022 11:42:50
 */

public class AdministradorPedidosActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  public String codigo_marca;
  public String descricao_marca;
  public String lin_cdgo;
  public String lin_nome;
  public String ref_cdgo;
  public String ref_desc;
  public String disponibilidade;
  public String somente_disponivel;
  public String dt_inicial;
  public String dt_final;
  private boolean valida = false;
  public AdministradorPedidosActionForm() {
  }
  /**
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("A");
      tipoLabelList.addElement("Analítico - Previsto / Capacidade");
      tipoList.addElement("S");
      tipoLabelList.addElement("Sintético - Datas de Disponibilidade");
    }
    java.util.Vector list = tipoList;
    return list;
  }
  java.util.Vector tipoLabelList = new Vector(10, 1);
  public java.util.Vector getTipoLabelList() {
    java.util.Vector list = tipoLabelList;
    return list;
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
  /**
    * DESCRICAO_MARCA: Method to get the field value.
    */
  public String getDescricao_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = {{"descricao_marca",null}};
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          descricao_marca = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
        } else {
          descricao_marca = "";
        }
      }
    } catch (Exception e) {
      descricao_marca = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(AdministradorPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"descricao_marca", (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":""};
        } else {
          list[0] = new String[]{"descricao_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_marca", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
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
        String[][] select = {{"lin_nome",null}};
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
        j = null;
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(AdministradorPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()} };
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
        j = null;
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
    * REF_CDGO: Method to get the field value.
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Method to set the field value.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * REF_DESC: Method to get the field value.
    */
  public String getRef_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0 && ref_cdgo != null && ref_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        String[][] select = {{"ref_desc",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(lin_cdgo)}, {"ref_cdgo","=",com.egen.util.text.FormatNumber.toInteger(ref_cdgo)} };
        java.util.Vector results = j.select(db_object, select, where, null, null, null);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          ref_desc = (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":"";
        } else {
          ref_desc = "";
        }
      }
    } catch (Exception e) {
      ref_desc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return ref_desc;
  }

  public String[][] getRef_desc_Ajax(AdministradorPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    try {
      util.consultas.Query query = new util.consultas.Query();
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0 && PARAM.getRef_cdgo() != null && PARAM.getRef_cdgo().length() > 0) {
        String desc = query.retorna("select ref_desc from ref where lin_cdgo="+PARAM.getLin_cdgo() + " and ref_cdgo="+PARAM.getRef_cdgo());
        if (!desc.equals("")) {
          list[0] = new String[]{"ref_desc", desc};
        } else {
          list[0] = new String[]{"ref_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"ref_desc", ""};
    } finally {
    }
    return list;
  }/**
    * REF_DESC: Method to set the field value.
    */

  public void setRef_desc(String PARAM) {
    ref_desc = PARAM;
  }
  /**
    * DISPONIBILIDADE: Method to get the field value.
    */
  public String getDisponibilidade() {
    return disponibilidade;
  }
  /**
    * DISPONIBILIDADE: Method to set the field value.
    */
  public void setDisponibilidade(String PARAM) {
    disponibilidade = PARAM;
  }
  Vector disponibilidadeList = new Vector(10, 1);
  public java.util.Vector getDisponibilidadeList() {
    if (disponibilidadeList == null || disponibilidadeList.size() == 0) {
      disponibilidadeList.addElement("g");
      disponibilidadeLabelList.addElement("Geral");
      disponibilidadeList.addElement("f");
      disponibilidadeLabelList.addElement("Fechadas");
      disponibilidadeList.addElement("s");
      disponibilidadeLabelList.addElement("Com Saldo");
    }
    java.util.Vector list = disponibilidadeList;
    return list;
  }
  java.util.Vector disponibilidadeLabelList = new Vector(10, 1);
  public java.util.Vector getDisponibilidadeLabelList() {
    java.util.Vector list = disponibilidadeLabelList;
    return list;
  }
  /**
    * SOMENTE_DISPONIVEL: Method to get the field value.
    */
  public String getSomente_disponivel() {
    return somente_disponivel;
  }
  /**
    * SOMENTE_DISPONIVEL: Method to set the field value.
    */
  public void setSomente_disponivel(String PARAM) {
    somente_disponivel = PARAM;
  }
  Vector somente_disponivelList = new Vector(10, 1);
  public java.util.Vector getSomente_disponivelList() {
    if (somente_disponivelList == null || somente_disponivelList.size() == 0) {
      somente_disponivelList.addElement("N");
      somente_disponivelLabelList.addElement("Não");
      somente_disponivelList.addElement("S");
      somente_disponivelLabelList.addElement("Sim");
    }
    java.util.Vector list = somente_disponivelList;
    return list;
  }
  java.util.Vector somente_disponivelLabelList = new Vector(10, 1);
  public java.util.Vector getSomente_disponivelLabelList() {
    java.util.Vector list = somente_disponivelLabelList;
    return list;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo = null;
    codigo_marca = null;
    descricao_marca = null;
    lin_cdgo = null;
    lin_nome = null;
    ref_cdgo = null;
    ref_desc = null;
    disponibilidade = null;
    somente_disponivel = null;
    dt_inicial = null;
    dt_final = null;
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
      if (!com.egen.util.text.Validate.isNumber(codigo_marca)) {
        errors.add("codigo_marca", new ActionMessage("error.validate.number","Marca","codigo_marca","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(lin_cdgo)) {
        errors.add("lin_cdgo", new ActionMessage("error.validate.number","Linha","lin_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(ref_cdgo)) {
        errors.add("ref_cdgo", new ActionMessage("error.validate.number","Referência","ref_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isMinlength(dt_inicial, 4)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.minlength","Inicial","dt_inicial","4","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(dt_inicial, "^[0-9]*$")) {
        errors.add("dt_inicial", new ActionMessage("error.validate.regex","Inicial","dt_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isMinlength(dt_final, 4)) {
        errors.add("dt_final", new ActionMessage("error.validate.minlength","Final","dt_final","4","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(dt_final, "^[0-9]*$")) {
        errors.add("dt_final", new ActionMessage("error.validate.regex","Final","dt_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
