package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/12/2010 08:59:49
 * Last Modify Date 25/01/2016 10:51:44
 */

public class EstagiosAmostrasActionForm extends org.apache.struts.action.ActionForm
{
  public String estagio_cdgo;
  public String descricao;
  public String ordem;
  public String excluir;
  public String banco;
  public String alterado;
  public String pos;
  private boolean valida = false;
  public EstagiosAmostrasActionForm() {
  }
  /**
    * ESTAGIO_CDGO: M�todo Gets para este campo
    */
  public String getEstagio_cdgo() {
    return estagio_cdgo;
  }
  /**
    * ESTAGIO_CDGO: M�todo Sets p�ra este campo.
    */
  public void setEstagio_cdgo(String PARAM) {
    estagio_cdgo = PARAM;
  }
  /**
    * DESCRICAO: M�todo Gets para este campo
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: M�todo Sets p�ra este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * ORDEM: M�todo Gets para este campo
    */
  public String getOrdem() {
    return ordem;
  }
  /**
    * ORDEM: M�todo Sets p�ra este campo.
    */
  public void setOrdem(String PARAM) {
    ordem = PARAM;
  }
  /**
    * EXCLUIR: M�todo Gets para este campo
    */
  public String getExcluir() {
    return excluir;
  }
  /**
    * EXCLUIR: M�todo Sets p�ra este campo.
    */
  public void setExcluir(String PARAM) {
    excluir = PARAM;
  }
  /**
    * BANCO: M�todo Gets para este campo
    */
  public String getBanco() {
    return banco;
  }
  /**
    * BANCO: M�todo Sets p�ra este campo.
    */
  public void setBanco(String PARAM) {
    banco = PARAM;
  }
  /**
    * ALTERADO: M�todo Gets para este campo
    */
  public String getAlterado() {
    return alterado;
  }
  /**
    * ALTERADO: M�todo Sets p�ra este campo.
    */
  public void setAlterado(String PARAM) {
    alterado = PARAM;
  }
  /**
    * POS: M�todo Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: M�todo Sets p�ra este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    estagio_cdgo = null;
    descricao = null;
    ordem = null;
    excluir = null;
    banco = null;
    alterado = null;
    pos = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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
