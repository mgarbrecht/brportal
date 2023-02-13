package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 05/04/2006 10:25:38
 * Last Modify Date 25/02/2008 07:52:25
 */

public class LimiteCreditoDisponivelActionForm extends org.apache.struts.action.ActionForm
{
  public String reg;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String quantidade;
  public String codigo_regional;
  public String codigo_representante;
  public String limite_inicial;
  public String limite_final;
  public String cb_totalizar_grupo_economico;
  private boolean valida = false;
  public LimiteCreditoDisponivelActionForm() {
  }



  public String getCb_totalizar_grupo_economico() {
    return cb_totalizar_grupo_economico;
  }

  public void setCb_totalizar_grupo_economico(String PARAM) {
    cb_totalizar_grupo_economico = PARAM;
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
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (reg != null && reg.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(reg)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          nome_regional = (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"";
        } else {
          nome_regional = "";
        }
      }
    } catch (Exception e) {
      nome_regional = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return nome_regional;
  }

  public String[][] getNome_regional_Ajax(LimiteCreditoDisponivelActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getReg() != null && PARAM.getReg().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getReg()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          list[0] = new String[]{"nome_regional", (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":""};
        } else {
          list[0] = new String[]{"nome_regional", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nome_regional", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * NOME_REGIONAL: Método Sets pára este campo.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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

  public String[][] getRep_rzao_Ajax(LimiteCreditoDisponivelActionForm PARAM) {
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
    * QUANTIDADE: Método Gets para este campo
    */
  public String getQuantidade() {
    return quantidade;
  }
  /**
    * QUANTIDADE: Método Sets pára este campo.
    */
  public void setQuantidade(String PARAM) {
    quantidade = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Método Sets pára este campo.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * CODIGO_REPRESENTANTE: Método Gets para este campo
    */
  public String getCodigo_representante() {
    return codigo_representante;
  }
  /**
    * CODIGO_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setCodigo_representante(String PARAM) {
    codigo_representante = PARAM;
  }
 /**
    * LIMITE_INICIAL: Método Gets para este campo
    */
  public String getLimite_inicial() {
    return limite_inicial;
  }
  /**
    * LIMITE_INICIAL: Método Sets pára este campo.
    */
  public void setLimite_inicial(String PARAM) {
    limite_inicial = PARAM;
  }
  /**
    * LIMITE_FINAL: Método Gets para este campo
    */
  public String getLimite_final() {
    return limite_final;
  }
  /**
    * LIMITE_FINAL: Método Sets pára este campo.
    */
  public void setLimite_final(String PARAM) {
    limite_final = PARAM;
  }

  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    reg = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    quantidade = null;
    codigo_regional = null;
    codigo_representante = null;
    limite_inicial = null;
    limite_final = null;
    cb_totalizar_grupo_economico = null;
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

      if(reg!=null){
         if (!com.egen.util.text.Validate.isRegex(reg, "^[0-9]*$")) {
           errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito_disponivel", new ActionMessage("error.validate.regex","Regional","reg","0"));
         }
      }
      if(rep_cdgo!=null){
         if (!com.egen.util.text.Validate.isRegex(rep_cdgo, "^[0-9]*$")) {
           errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito_disponivel", new ActionMessage("error.validate.regex","Representante","rep_cdgo","0"));
         }
      }

      if (!com.egen.util.text.Validate.isRegex(quantidade, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_limite_credito_disponivel", new ActionMessage("error.validate.regex","Quantidade","quantidade","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(limite_inicial)) {
        errors.add("limite_inicial", new ActionMessage("error.validate.number","Limite Inicial","limite_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(limite_final)) {
        errors.add("limite_final", new ActionMessage("error.validate.number","Limite Final","limite_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
