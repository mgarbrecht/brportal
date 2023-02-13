package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/05/2014 10:16:38
 * Last Modify Date 26/02/2018 09:24:54
 */

public class ApontamentoProducaoActionForm extends org.apache.struts.action.ActionForm
{
  public String setor;
  public String p_codigo_barra;
  public String p_rem_nro;
  public String p_set_cdgo;
  public String p_tal_nro;
  public String p_app_seq;
  public String p_mini_fab;
  public String p_mensagem;
  public String lido;
  public String p_rem_nro_apagar;
  public String p_tal_nro_apagar;
  public String p_set_cdgo_apagar;
  public String p_app_seq_apagar;
  public String p_app_observ1_apagar;
  public String index;
  private boolean valida = false;
  public ApontamentoProducaoActionForm() {
  }
  /**
    * SETOR: Method to get the field value.
    */
  public String getSetor() {
    return setor;
  }
  /**
    * SETOR: Method to set the field value.
    */
  public void setSetor(String PARAM) {
    setor = PARAM;
  }
  private Vector setorList = new Vector(10, 10);
  public void setSetorList(java.util.Vector VECTOR) {
    setorList = VECTOR;
  }
  public java.util.Vector getSetorList() {
    if (setorList == null || setorList.size() == 0) {
      setorList = new Vector(10, 10);
      setorLabelList = new Vector(10, 10);
      setorList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      setorLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Setor db_object = new Setor();
        String[][] select = {{"set_cdgo", null},{"set_nome", null}};
        Object[][] where = null;
        String[] order = {"set_cdgo"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Setor) results.elementAt(i);
          setorList.addElement(""+db_object.getSet_cdgo());
          setorLabelList.addElement(""+db_object.getSet_cdgo() + " - " + db_object.getSet_nome());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ApontamentoProducao.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return setorList;
  }
  private java.util.Vector setorLabelList = new Vector(10, 10);
  public void setSetorLabelList(java.util.Vector VECTOR) {
    setorLabelList = VECTOR;
  }
  public java.util.Vector getSetorLabelList() {
    return setorLabelList;
  }
  /**
    * P_CODIGO_BARRA: Method to get the field value.
    */
  public String getP_codigo_barra() {
    return p_codigo_barra;
  }
  /**
    * P_CODIGO_BARRA: Method to set the field value.
    */
  public void setP_codigo_barra(String PARAM) {
    p_codigo_barra = PARAM;
  }
  /**
    * P_REM_NRO: Method to get the field value.
    */
  public String getP_rem_nro() {
    return p_rem_nro;
  }
  /**
    * P_REM_NRO: Method to set the field value.
    */
  public void setP_rem_nro(String PARAM) {
    p_rem_nro = PARAM;
  }
  /**
    * P_SET_CDGO: Method to get the field value.
    */
  public String getP_set_cdgo() {
    return p_set_cdgo;
  }
  /**
    * P_SET_CDGO: Method to set the field value.
    */
  public void setP_set_cdgo(String PARAM) {
    p_set_cdgo = PARAM;
  }
  /**
    * P_TAL_NRO: Method to get the field value.
    */
  public String getP_tal_nro() {
    return p_tal_nro;
  }
  /**
    * P_TAL_NRO: Method to set the field value.
    */
  public void setP_tal_nro(String PARAM) {
    p_tal_nro = PARAM;
  }
  /**
    * P_APP_SEQ: Method to get the field value.
    */
  public String getP_app_seq() {
    return p_app_seq;
  }
  /**
    * P_APP_SEQ: Method to set the field value.
    */
  public void setP_app_seq(String PARAM) {
    p_app_seq = PARAM;
  }
  /**
    * P_MINI_FAB: Method to get the field value.
    */
  public String getP_mini_fab() {
    return p_mini_fab;
  }
  /**
    * P_MINI_FAB: Method to set the field value.
    */
  public void setP_mini_fab(String PARAM) {
    p_mini_fab = PARAM;
  }
  /**
    * P_MENSAGEM: Method to get the field value.
    */
  public String getP_mensagem() {
    return p_mensagem;
  }
  /**
    * P_MENSAGEM: Method to set the field value.
    */
  public void setP_mensagem(String PARAM) {
    p_mensagem = PARAM;
  }
  /**
    * LIDO: Method to get the field value.
    */
  public String getLido() {
    return lido;
  }
  /**
    * LIDO: Method to set the field value.
    */
  public void setLido(String PARAM) {
    lido = PARAM;
  }
  /**
    * P_REM_NRO_APAGAR: Method to get the field value.
    */
  public String getP_rem_nro_apagar() {
    return p_rem_nro_apagar;
  }
  /**
    * P_REM_NRO_APAGAR: Method to set the field value.
    */
  public void setP_rem_nro_apagar(String PARAM) {
    p_rem_nro_apagar = PARAM;
  }
  /**
    * P_TAL_NRO_APAGAR: Method to get the field value.
    */
  public String getP_tal_nro_apagar() {
    return p_tal_nro_apagar;
  }
  /**
    * P_TAL_NRO_APAGAR: Method to set the field value.
    */
  public void setP_tal_nro_apagar(String PARAM) {
    p_tal_nro_apagar = PARAM;
  }
  /**
    * P_SET_CDGO_APAGAR: Method to get the field value.
    */
  public String getP_set_cdgo_apagar() {
    return p_set_cdgo_apagar;
  }
  /**
    * P_SET_CDGO_APAGAR: Method to set the field value.
    */
  public void setP_set_cdgo_apagar(String PARAM) {
    p_set_cdgo_apagar = PARAM;
  }
  /**
    * P_APP_SEQ_APAGAR: Method to get the field value.
    */
  public String getP_app_seq_apagar() {
    return p_app_seq_apagar;
  }
  /**
    * P_APP_SEQ_APAGAR: Method to set the field value.
    */
  public void setP_app_seq_apagar(String PARAM) {
    p_app_seq_apagar = PARAM;
  }
  /**
    * P_APP_OBSERV1_APAGAR: Method to get the field value.
    */
  public String getP_app_observ1_apagar() {
    return p_app_observ1_apagar;
  }
  /**
    * P_APP_OBSERV1_APAGAR: Method to set the field value.
    */
  public void setP_app_observ1_apagar(String PARAM) {
    p_app_observ1_apagar = PARAM;
  }
  /**
    * INDEX: Method to get the field value.
    */
  public String getIndex() {
    return index;
  }
  /**
    * INDEX: Method to set the field value.
    */
  public void setIndex(String PARAM) {
    index = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    setor = null;
    p_codigo_barra = null;
    p_rem_nro = null;
    p_set_cdgo = null;
    p_tal_nro = null;
    p_app_seq = null;
    p_mini_fab = null;
    p_mensagem = null;
    lido = null;
    p_rem_nro_apagar = null;
    p_tal_nro_apagar = null;
    p_set_cdgo_apagar = null;
    p_app_seq_apagar = null;
    p_app_observ1_apagar = null;
    index = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("execute_action,", request)) {
      if (com.egen.util.text.Validate.isNull(p_codigo_barra)) {
        errors.add("p_codigo_barra", new ActionMessage("error.validate.notnull","Código de Barras","p_codigo_barra","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
