package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 26/04/2006 17:29:53
 * Last Modify Date 22/06/2015 14:17:19
 */

public class PlusClientesActionForm extends org.apache.struts.action.ActionForm
{
  public String cli_cdgo;
  public String cli_rzao;
  public String esc_seqn;
  public String cgc;
  public String reg;
  public String rep;
  public String cli;
  public String seq;
  private boolean valida = false;
  public PlusClientesActionForm() {
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = {{"cli_rzao",null}};
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        } else {
          cli_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(PlusClientesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=",PARAM.getCli_cdgo()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * ESC_SEQN: Método Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Método Sets pára este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * CGC: Método Gets para este campo
    */
  public String getCgc() {
    return cgc;
  }
  /**
    * CGC: Método Sets pára este campo.
    */
  public void setCgc(String PARAM) {
    cgc = PARAM;
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
    * CLI: Método Gets para este campo
    */
  public String getCli() {
    return cli;
  }
  /**
    * CLI: Método Sets pára este campo.
    */
  public void setCli(String PARAM) {
    cli = PARAM;
  }
  /**
    * SEQ: Método Gets para este campo
    */
  public String getSeq() {
    return seq;
  }
  /**
    * SEQ: Método Sets pára este campo.
    */
  public void setSeq(String PARAM) {
    seq = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cli_cdgo = null;
    cli_rzao = null;
    esc_seqn = null;
    cgc = null;
    reg = null;
    rep = null;
    cli = null;
    seq = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,select2_action,", request)) {
      if (!com.egen.util.text.Validate.isNumber(cli_cdgo)) {
        errors.add("cli_cdgo", new ActionMessage("error.validate.number","Cliente","cli_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(esc_seqn)) {
        errors.add("esc_seqn", new ActionMessage("error.validate.number","Seq.","esc_seqn","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(cgc)) {
        errors.add("cgc", new ActionMessage("error.validate.number","CGC","cgc","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
