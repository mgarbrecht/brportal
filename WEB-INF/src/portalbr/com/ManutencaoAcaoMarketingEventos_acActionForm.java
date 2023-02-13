package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/07/2010 10:07:17
 * Last Modify Date 16/07/2010 12:10:57
 */

public class ManutencaoAcaoMarketingEventos_acActionForm extends org.apache.struts.action.ActionForm
{
  public String cracha;
  public String nome;
  private boolean valida = false;
  public ManutencaoAcaoMarketingEventos_acActionForm() {
  }
  /**
    * CRACHA: Method to get the field value.
    */
  public String getCracha() {
    return cracha;
  }
  /**
    * CRACHA: Method to set the field value.
    */
  public void setCracha(String PARAM) {
    cracha = PARAM;
  }
  /**
    * NOME: Method to get the field value.
    */
  public String getNome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cracha != null && cracha.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_acao_marketing_usuarios db_object = new Jw_acao_marketing_usuarios();
        String[][] select = { {"nome",null} };
        Object[][] where = { {"cracha","like",cracha}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_acao_marketing_usuarios) results.elementAt(0);
          nome = (db_object.getNome() != null) ? db_object.getNome() + "":"";
        } else {
          nome = "";
        }
      }
    } catch (Exception e) {
      nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return nome;
  }

  public String[][] getNome_Ajax(ManutencaoAcaoMarketingEventos_acActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCracha() != null && PARAM.getCracha().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_acao_marketing_usuarios db_object = new Jw_acao_marketing_usuarios();
        Object[][] where = { {"cracha","like",PARAM.getCracha()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_acao_marketing_usuarios) results.elementAt(0);
          list[0] = new String[]{"nome", (db_object.getNome() != null) ? db_object.getNome() + "":""};
        } else {
          list[0] = new String[]{"nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * NOME: Method to set the field value.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cracha = null;
    nome = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
