package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/08/2011 13:50:53
 * Last Modify Date 22/06/2015 13:07:48
 */

public class FichaEmbalagemActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String lin_nome;
  public String ref_cdgo_inicial;
  public String ref_cdgo_final;
  public String codigo_corrugado;
  public String descricao_corrugado;
  public String mix;
  private boolean valida = false;
  public FichaEmbalagemActionForm() {
  }
  /**
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LIN_NOME: Método Gets para este campo
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

  public String[][] getLin_nome_Ajax(FichaEmbalagemActionForm PARAM) {
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
    * LIN_NOME: Método Sets pára este campo.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * REF_CDGO_INICIAL: Método Gets para este campo
    */
  public String getRef_cdgo_inicial() {
    return ref_cdgo_inicial;
  }
  /**
    * REF_CDGO_INICIAL: Método Sets pára este campo.
    */
  public void setRef_cdgo_inicial(String PARAM) {
    ref_cdgo_inicial = PARAM;
  }
  /**
    * REF_CDGO_FINAL: Método Gets para este campo
    */
  public String getRef_cdgo_final() {
    return ref_cdgo_final;
  }
  /**
    * REF_CDGO_FINAL: Método Sets pára este campo.
    */
  public void setRef_cdgo_final(String PARAM) {
    ref_cdgo_final = PARAM;
  }
  /**
    * CODIGO_CORRUGADO: Método Gets para este campo
    */
  public String getCodigo_corrugado() {
    return codigo_corrugado;
  }
  /**
    * CODIGO_CORRUGADO: Método Sets pára este campo.
    */
  public void setCodigo_corrugado(String PARAM) {
    codigo_corrugado = PARAM;
  }
  /**
    * DESCRICAO_CORRUGADO: Método Gets para este campo
    */
  public String getDescricao_corrugado() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_corrugado != null && codigo_corrugado.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Corrugados db_object = new Corrugados();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInteger(codigo_corrugado)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Corrugados) results.elementAt(0);
          descricao_corrugado = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          descricao_corrugado = "";
        }
      }
    } catch (Exception e) {
      descricao_corrugado = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_corrugado;
  }

  public String[][] getDescricao_corrugado_Ajax(FichaEmbalagemActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_corrugado() != null && PARAM.getCodigo_corrugado().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Corrugados db_object = new Corrugados();
        Object[][] where = { {"codigo","like",PARAM.getCodigo_corrugado()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Corrugados) results.elementAt(0);
          list[0] = new String[]{"descricao_corrugado", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"descricao_corrugado", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_corrugado", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_CORRUGADO: Método Sets pára este campo.
    */
  public void setDescricao_corrugado(String PARAM) {
    descricao_corrugado = PARAM;
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
      mixList.addElement("null");
      mixLabelList.addElement("Todos");
      mixList.addElement("'M'");
      mixLabelList.addElement("No Mix");
      mixList.addElement("'F'");
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    lin_nome = null;
    ref_cdgo_inicial = null;
    ref_cdgo_final = null;
    codigo_corrugado = null;
    descricao_corrugado = null;
    mix = null;
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
      if (com.egen.util.text.Validate.isNull(lin_cdgo)) {
        errors.add("lin_cdgo", new ActionMessage("error.validate.notnull","Linha","lin_cdgo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
