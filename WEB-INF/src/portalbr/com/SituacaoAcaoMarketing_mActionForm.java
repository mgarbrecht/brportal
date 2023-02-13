package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/12/2010 05:51:52
 * Last Modify Date 03/04/2013 13:09:55
 */

public class SituacaoAcaoMarketing_mActionForm extends org.apache.struts.action.ActionForm
{
  public String excluir;
  public String estagio_cdgo;
  public String descricao;
  public String ordem;
  public String banco;
  public String alterado;
  public String pos;
  private boolean valida = false;
  public SituacaoAcaoMarketing_mActionForm() {
  }
  /**
    * EXCLUIR: Method to get the field value.
    */
  public String getExcluir() {
    return excluir;
  }
  /**
    * EXCLUIR: Method to set the field value.
    */
  public void setExcluir(String PARAM) {
    excluir = PARAM;
  }
  /**
    * ESTAGIO_CDGO: Method to get the field value.
    */
  public String getEstagio_cdgo() {
    return estagio_cdgo;
  }
  /**
    * ESTAGIO_CDGO: Method to set the field value.
    */
  public void setEstagio_cdgo(String PARAM) {
    estagio_cdgo = PARAM;
  }
  /**
    * DESCRICAO: Method to get the field value.
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: Method to set the field value.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * ORDEM: Method to get the field value.
    */
  public String getOrdem() {
    return ordem;
  }
  /**
    * ORDEM: Method to set the field value.
    */
  public void setOrdem(String PARAM) {
    ordem = PARAM;
  }
  /**
    * BANCO: Method to get the field value.
    */
  public String getBanco() {
    return banco;
  }
  /**
    * BANCO: Method to set the field value.
    */
  public void setBanco(String PARAM) {
    banco = PARAM;
  }
  /**
    * ALTERADO: Method to get the field value.
    */
  public String getAlterado() {
    return alterado;
  }
  /**
    * ALTERADO: Method to set the field value.
    */
  public void setAlterado(String PARAM) {
    alterado = PARAM;
  }
  /**
    * POS: Method to get the field value.
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Method to set the field value.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    excluir = null;
    estagio_cdgo = null;
    descricao = null;
    ordem = null;
    banco = null;
    alterado = null;
    pos = null;
  }
  /**
    * Validate fields and return errors.
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
