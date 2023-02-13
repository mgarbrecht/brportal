package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/01/2014 11:37:25
 * Last Modify Date 02/09/2015 16:18:01
 */

public class ArquivosFornecedoresOc_rActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String interface_arq_compra_id;
  public String forn_codigo;
  public String nome_arquivo;
  public String situacao;
  public String descricao_situacao;
  private boolean valida = false;
  public ArquivosFornecedoresOc_rActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Método Gets para este campo
    */
  public String getInterface_arq_compra_id() {
    return interface_arq_compra_id;
  }
  /**
    * INTERFACE_ARQ_COMPRA_ID: Método Sets pára este campo.
    */
  public void setInterface_arq_compra_id(String PARAM) {
    interface_arq_compra_id = PARAM;
  }
  /**
    * FORN_CODIGO: Método Gets para este campo
    */
  public String getForn_codigo() {
    return forn_codigo;
  }
  /**
    * FORN_CODIGO: Método Sets pára este campo.
    */
  public void setForn_codigo(String PARAM) {
    forn_codigo = PARAM;
  }
  /**
    * NOME_ARQUIVO: Método Gets para este campo
    */
  public String getNome_arquivo() {
    return nome_arquivo;
  }
  /**
    * NOME_ARQUIVO: Método Sets pára este campo.
    */
  public void setNome_arquivo(String PARAM) {
    nome_arquivo = PARAM;
  }
  /**
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * DESCRICAO_SITUACAO: Método Gets para este campo
    */
  public String getDescricao_situacao() {
    return descricao_situacao;
  }
  /**
    * DESCRICAO_SITUACAO: Método Sets pára este campo.
    */
  public void setDescricao_situacao(String PARAM) {
    descricao_situacao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    interface_arq_compra_id = null;
    forn_codigo = null;
    nome_arquivo = null;
    situacao = null;
    descricao_situacao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("update_action,update1_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
