package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/12/2008 04:57:31
 * Last Modify Date 07/01/2015 10:40:37
 */

public class PendenciasRegionaisActionForm extends org.apache.struts.action.ActionForm
{
  public String reg;
  public String nome_regional;
  public String rep;
  public String rep_nome;
  public String situacao_rep;
  public boolean cb_clientes;
  private boolean valida = false;
  public PendenciasRegionaisActionForm() {
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

  public String[][] getNome_regional_Ajax(PendenciasRegionaisActionForm PARAM) {
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
    * REP: Método Gets para este campo
    */
  public String getRep() {
    return rep;
  }
  /**
    * REP: Método Sets pára este campo.
    */
  public void setRep(String PARAM) {
    rep = PARAM;
  }
  /**
    * REP_NOME: Método Gets para este campo
    */
  public String getRep_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep != null && rep.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"rep_rzao",null} };
        Object[][] where = { {"rep_cdgo","like",rep}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          rep_nome = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        } else {
          rep_nome = "";
        }
      }
    } catch (Exception e) {
      rep_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return rep_nome;
  }

  public String[][] getRep_nome_Ajax(PendenciasRegionaisActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep() != null && PARAM.getRep().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          list[0] = new String[]{"rep_nome", (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":""};
        } else {
          list[0] = new String[]{"rep_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"rep_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REP_NOME: Método Sets pára este campo.
    */
  public void setRep_nome(String PARAM) {
    rep_nome = PARAM;
  }
  /**
    * SITUACAO_REP: Método Gets para este campo
    */
  public String getSituacao_rep() {
    return situacao_rep;
  }
  /**
    * SITUACAO_REP: Método Sets pára este campo.
    */
  public void setSituacao_rep(String PARAM) {
    situacao_rep = PARAM;
  }
  Vector situacao_repList = new Vector(10, 1);
  public java.util.Vector getSituacao_repList() {
    if (situacao_repList == null || situacao_repList.size() == 0) {
      situacao_repList.addElement("");
      situacao_repLabelList.addElement("Todos");
      situacao_repList.addElement("A");
      situacao_repLabelList.addElement("Ativos");
      situacao_repList.addElement("I");
      situacao_repLabelList.addElement("Inativos");
    }
    java.util.Vector list = situacao_repList;
    return list;
  }
  java.util.Vector situacao_repLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_repLabelList() {
    java.util.Vector list = situacao_repLabelList;
    return list;
  }
  /**
    * CB_CLIENTES: Método Gets para este campo
    */
  public boolean getCb_clientes() {
    return cb_clientes;
  }
  /**
    * CB_CLIENTES: Método Sets pára este campo.
    */
  public void setCb_clientes(boolean PARAM) {
    cb_clientes = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    reg = null;
    nome_regional = null;
    rep = null;
    rep_nome = null;
    situacao_rep = null;
    cb_clientes = false;
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
