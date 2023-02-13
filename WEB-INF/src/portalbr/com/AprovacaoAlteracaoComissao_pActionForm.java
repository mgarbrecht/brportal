package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/01/2012 16:11:55
 * Last Modify Date 02/04/2013 13:50:15
 */

public class AprovacaoAlteracaoComissao_pActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String id_lancamento;
  public String valor_lancamento;
  public String data_lancamento;
  public String usuario_lancamento;
  public String motivo;
  private boolean valida = false;
  public AprovacaoAlteracaoComissao_pActionForm() {
  }
  /**
    * ID_SOLICITACAO: M�todo Gets para este campo
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: M�todo Sets p�ra este campo.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * ID_LANCAMENTO: M�todo Gets para este campo
    */
  public String getId_lancamento() {
    return id_lancamento;
  }
  /**
    * ID_LANCAMENTO: M�todo Sets p�ra este campo.
    */
  public void setId_lancamento(String PARAM) {
    id_lancamento = PARAM;
  }
  /**
    * VALOR_LANCAMENTO: M�todo Gets para este campo
    */
  public String getValor_lancamento() {
    return valor_lancamento;
  }
  /**
    * VALOR_LANCAMENTO: M�todo Sets p�ra este campo.
    */
  public void setValor_lancamento(String PARAM) {
    valor_lancamento = PARAM;
  }
  /**
    * DATA_LANCAMENTO: M�todo Gets para este campo
    */
  public String getData_lancamento() {
    return data_lancamento;
  }
  /**
    * DATA_LANCAMENTO: M�todo Sets p�ra este campo.
    */
  public void setData_lancamento(String PARAM) {
    data_lancamento = PARAM;
  }
  /**
    * USUARIO_LANCAMENTO: M�todo Gets para este campo
    */
  public String getUsuario_lancamento() {
    return usuario_lancamento;
  }
  /**
    * USUARIO_LANCAMENTO: M�todo Sets p�ra este campo.
    */
  public void setUsuario_lancamento(String PARAM) {
    usuario_lancamento = PARAM;
  }
  /**
    * MOTIVO: M�todo Gets para este campo
    */
  public String getMotivo() {
    return motivo;
  }
  /**
    * MOTIVO: M�todo Sets p�ra este campo.
    */
  public void setMotivo(String PARAM) {
    motivo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    id_lancamento = null;
    valor_lancamento = null;
    data_lancamento = null;
    usuario_lancamento = null;
    motivo = null;
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

    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(valor_lancamento)) {
        errors.add("valor_lancamento", new ActionMessage("error.validate.notnull","Valor","valor_lancamento","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
