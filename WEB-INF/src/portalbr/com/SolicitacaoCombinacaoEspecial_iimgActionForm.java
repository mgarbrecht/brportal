package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/06/2015 08:28:50
 * Last Modify Date 05/11/2020 12:19:23
 */

import org.apache.struts.upload.FormFile;

public class SolicitacaoCombinacaoEspecial_iimgActionForm extends org.apache.struts.action.ActionForm
{
  public FormFile imagem;
  public String id_solicitacao;
  public String id_imagem;
  public String descricao;
  private boolean valida = false;
  public SolicitacaoCombinacaoEspecial_iimgActionForm() {
  }
  /**
    * IMAGEM: Método Gets para este campo
    */
  public FormFile getImagem() {
    return imagem;
  }
  /**
    * IMAGEM: Método Sets pára este campo.
    */
  public void setImagem(FormFile PARAM) {
    imagem = PARAM;
  }
  /**
    * ID_SOLICITACAO: Método Gets para este campo
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Método Sets pára este campo.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * ID_IMAGEM: Método Gets para este campo
    */
  public String getId_imagem() {
    return id_imagem;
  }
  /**
    * ID_IMAGEM: Método Sets pára este campo.
    */
  public void setId_imagem(String PARAM) {
    id_imagem = PARAM;
  }
  /**
    * DESCRICAO: Método Gets para este campo
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: Método Sets pára este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    imagem = null;
    id_solicitacao = null;
    id_imagem = null;
    descricao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("upload_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
