package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/03/2006 15:41:20
 * Last Modify Date 26/02/2008 14:08:05
 */

public class PoiRepresentanteMarcasActionForm extends org.apache.struts.action.ActionForm
{
  public String rep_cdgo;
  public String rep_rzao;
  public String unidade_negocio;
  public String unn_descri;
  public String mes;
  public String ano;
  public String mes_final;
  public String ano_final;
  public String situacao_gerente;
  public String f_regional;
  public String f_representante;
  public String reg;
  private boolean valida = false;
  public PoiRepresentanteMarcasActionForm() {
  }
  /**
    * REP_CDGO: Método Gets para este campo
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Método Sets pára este campo.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * REP_RZAO: Método Gets para este campo
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"rep_rzao",null} };
        Object[][] where = { {"rep_cdgo","like",rep_cdgo}, };
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
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(PoiRepresentanteMarcasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()}, };
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
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * UNIDADE_NEGOCIO: Método Gets para este campo
    */
  public String getUnidade_negocio() {
    return unidade_negocio;
  }
  /**
    * UNIDADE_NEGOCIO: Método Sets pára este campo.
    */
  public void setUnidade_negocio(String PARAM) {
    unidade_negocio = PARAM;
  }
  /**
    * UNN_DESCRI: Método Gets para este campo
    */
  public String getUnn_descri() {
    return unn_descri;
  }
  /**
    * UNN_DESCRI: Método Sets pára este campo.
    */
  public void setUnn_descri(String PARAM) {
    unn_descri = PARAM;
  }
  /**
    * MES: Método Gets para este campo
    */
  public String getMes() {
    return mes;
  }
  /**
    * MES: Método Sets pára este campo.
    */
  public void setMes(String PARAM) {
    mes = PARAM;
  }
  /**
    * ANO: Método Gets para este campo
    */
  public String getAno() {
    return ano;
  }
  /**
    * ANO: Método Sets pára este campo.
    */
  public void setAno(String PARAM) {
    ano = PARAM;
  }
  /**
    * MES_FINAL: Método Gets para este campo
    */
  public String getMes_final() {
    return mes_final;
  }
  /**
    * MES_FINAL: Método Sets pára este campo.
    */
  public void setMes_final(String PARAM) {
    mes_final = PARAM;
  }
  /**
    * ANO_FINAL: Método Gets para este campo
    */
  public String getAno_final() {
    return ano_final;
  }
  /**
    * ANO_FINAL: Método Sets pára este campo.
    */
  public void setAno_final(String PARAM) {
    ano_final = PARAM;
  }
  /**
    * SITUACAO_GERENTE: Método Gets para este campo
    */
  public String getSituacao_gerente() {
    return situacao_gerente;
  }
  /**
    * SITUACAO_GERENTE: Método Sets pára este campo.
    */
  public void setSituacao_gerente(String PARAM) {
    situacao_gerente = PARAM;
  }
  Vector situacao_gerenteList = new Vector(10, 1);
  public java.util.Vector getSituacao_gerenteList() {
    if (situacao_gerenteList == null || situacao_gerenteList.size() == 0) {
      situacao_gerenteList.addElement("T");
      situacao_gerenteLabelList.addElement("Todos");
      situacao_gerenteList.addElement("A");
      situacao_gerenteLabelList.addElement("Ativo");
      situacao_gerenteList.addElement("I");
      situacao_gerenteLabelList.addElement("Inativo");
    }
    java.util.Vector list = situacao_gerenteList;
    return list;
  }
  java.util.Vector situacao_gerenteLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_gerenteLabelList() {
    java.util.Vector list = situacao_gerenteLabelList;
    return list;
  }
  /**
    * F_REGIONAL: Método Gets para este campo
    */
  public String getF_regional() {
    return f_regional;
  }
  /**
    * F_REGIONAL: Método Sets pára este campo.
    */
  public void setF_regional(String PARAM) {
    f_regional = PARAM;
  }
  /**
    * F_REPRESENTANTE: Método Gets para este campo
    */
  public String getF_representante() {
    return f_representante;
  }
  /**
    * F_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setF_representante(String PARAM) {
    f_representante = PARAM;
  }
  /**
    * REG: Método Gets para este campo
    */
  public String getReg() {
    return reg;
  }
  /**
    * REG: Método Sets pára este campo.
    */
  public void setReg(String PARAM) {
    reg = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    rep_cdgo = null;
    rep_rzao = null;
    unidade_negocio = null;
    unn_descri = null;
    mes = null;
    ano = null;
    mes_final = null;
    ano_final = null;
    situacao_gerente = null;
    f_regional = null;
    f_representante = null;
    reg = null;
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
      if(f_representante==""){
      if (com.egen.util.text.Validate.isNull(rep_cdgo)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Representante","rep_cdgo","0"));
      }
      }
      if (!com.egen.util.text.Validate.isNumber(rep_cdgo)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.number","Representante","rep_cdgo","0"));
      }
      if (com.egen.util.text.Validate.isNull(mes)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Mês Inicial","mes","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(mes, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Mês Inicial","mes","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Ano Inicial","ano","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ano, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Ano Inicial","ano","0"));
      }
      if (com.egen.util.text.Validate.isNull(mes_final)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Mês Final","mes_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(mes_final, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Mês Final","mes_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano_final)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Ano Final","ano_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ano_final, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Ano Final","ano_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
