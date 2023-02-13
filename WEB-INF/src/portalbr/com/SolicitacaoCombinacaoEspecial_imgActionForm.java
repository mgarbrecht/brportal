package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/06/2015 12:51:14
 * Last Modify Date 05/11/2020 12:19:19
 */

public class SolicitacaoCombinacaoEspecial_imgActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String id_imagem;
  public String imagem;
  public String descricao_imagem;
  private boolean valida = false;
  public SolicitacaoCombinacaoEspecial_imgActionForm() {
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
    * ID_IMAGEM: M�todo Gets para este campo
    */
  public String getId_imagem() {
    return id_imagem;
  }
  /**
    * ID_IMAGEM: M�todo Sets p�ra este campo.
    */
  public void setId_imagem(String PARAM) {
    id_imagem = PARAM;
  }
  /**
    * IMAGEM: M�todo Gets para este campo
    */
  public String getImagem() {
    return imagem;
  }
  /**
    * IMAGEM: M�todo Sets p�ra este campo.
    */
  public void setImagem(String PARAM) {
    imagem = PARAM;
  }
  /**
    * DESCRICAO_IMAGEM: M�todo Gets para este campo
    */
  public String getDescricao_imagem() {
    return descricao_imagem;
  }
  /**
    * DESCRICAO_IMAGEM: M�todo Sets p�ra este campo.
    */
  public void setDescricao_imagem(String PARAM) {
    descricao_imagem = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    id_imagem = null;
    imagem = null;
    descricao_imagem = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
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
