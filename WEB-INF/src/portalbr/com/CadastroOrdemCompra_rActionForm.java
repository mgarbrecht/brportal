package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/04/2012 16:42:28
 * Last Modify Date 15/05/2018 12:07:33
 */

public class CadastroOrdemCompra_rActionForm extends org.apache.struts.action.ActionForm
{
  public String oc1;
  public boolean gridCheckField;
  public String numero;
  public String cliente;
  public String sequencial;
  public String cli_rzao;
  public String grupo;
  public String nome_grupo;
  public String oc;
  public String pos;
  public String oc_nova;
  private boolean valida = false;
  public CadastroOrdemCompra_rActionForm() {
  }
  /**
    * OC1: M�todo Gets para este campo
    */
  public String getOc1() {
    return oc1;
  }
  /**
    * OC1: M�todo Sets p�ra este campo.
    */
  public void setOc1(String PARAM) {
    oc1 = PARAM;
  }
  /**
    * GRIDCHECKFIELD: M�todo Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: M�todo Sets p�ra este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * NUMERO: M�todo Gets para este campo
    */
  public String getNumero() {
    return numero;
  }
  /**
    * NUMERO: M�todo Sets p�ra este campo.
    */
  public void setNumero(String PARAM) {
    numero = PARAM;
  }
  /**
    * CLIENTE: M�todo Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * SEQUENCIAL: M�todo Gets para este campo
    */
  public String getSequencial() {
    return sequencial;
  }
  /**
    * SEQUENCIAL: M�todo Sets p�ra este campo.
    */
  public void setSequencial(String PARAM) {
    sequencial = PARAM;
  }
  /**
    * CLI_RZAO: M�todo Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: M�todo Sets p�ra este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * GRUPO: M�todo Gets para este campo
    */
  public String getGrupo() {
    return grupo;
  }
  /**
    * GRUPO: M�todo Sets p�ra este campo.
    */
  public void setGrupo(String PARAM) {
    grupo = PARAM;
  }
  /**
    * NOME_GRUPO: M�todo Gets para este campo
    */
  public String getNome_grupo() {
    return nome_grupo;
  }
  /**
    * NOME_GRUPO: M�todo Sets p�ra este campo.
    */
  public void setNome_grupo(String PARAM) {
    nome_grupo = PARAM;
  }
  /**
    * OC: M�todo Gets para este campo
    */
  public String getOc() {
    return oc;
  }
  /**
    * OC: M�todo Sets p�ra este campo.
    */
  public void setOc(String PARAM) {
    oc = PARAM;
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
    * OC_NOVA: M�todo Gets para este campo
    */
  public String getOc_nova() {
    return oc_nova;
  }
  /**
    * OC_NOVA: M�todo Sets p�ra este campo.
    */
  public void setOc_nova(String PARAM) {
    oc_nova = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    oc1 = null;
    gridCheckField = false;
    numero = null;
    cliente = null;
    sequencial = null;
    cli_rzao = null;
    grupo = null;
    nome_grupo = null;
    oc = null;
    pos = null;
    oc_nova = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
