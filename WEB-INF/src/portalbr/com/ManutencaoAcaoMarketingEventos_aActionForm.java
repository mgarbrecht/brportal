package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/06/2010 14:08:26
 * Last Modify Date 09/06/2010 07:11:06
 */

public class ManutencaoAcaoMarketingEventos_aActionForm extends org.apache.struts.action.ActionForm
{
  public String situacao;
  private boolean valida = false;
  public ManutencaoAcaoMarketingEventos_aActionForm() {
  }
  /**
    * SITUACAO: Method to get the field value.
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Method to set the field value.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  private Vector situacaoList = new Vector(10, 10);
  public void setSituacaoList(java.util.Vector VECTOR) {
    situacaoList = VECTOR;
  }
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList = new Vector(10, 10);
      situacaoLabelList = new Vector(10, 10);
      situacaoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      situacaoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Acao_marketing_situacoes db_object = new Acao_marketing_situacoes();
        String[][] select = {{"codigo", null},{"descricao", null}};
        Object[][] where = null;
        String[] order = {"descricao"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Acao_marketing_situacoes) results.elementAt(i);
          situacaoList.addElement(""+db_object.getCodigo());
          situacaoLabelList.addElement(""+db_object.getDescricao());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ManutencaoAcaoMarketingEventos_a.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return situacaoList;
  }
  private java.util.Vector situacaoLabelList = new Vector(10, 10);
  public void setSituacaoLabelList(java.util.Vector VECTOR) {
    situacaoLabelList = VECTOR;
  }
  public java.util.Vector getSituacaoLabelList() {
    return situacaoLabelList;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    situacao = null;
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
