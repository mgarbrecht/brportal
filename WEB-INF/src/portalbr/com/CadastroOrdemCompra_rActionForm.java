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
    * OC1: Método Gets para este campo
    */
  public String getOc1() {
    return oc1;
  }
  /**
    * OC1: Método Sets pára este campo.
    */
  public void setOc1(String PARAM) {
    oc1 = PARAM;
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
    * NUMERO: Método Gets para este campo
    */
  public String getNumero() {
    return numero;
  }
  /**
    * NUMERO: Método Sets pára este campo.
    */
  public void setNumero(String PARAM) {
    numero = PARAM;
  }
  /**
    * CLIENTE: Método Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Método Sets pára este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * SEQUENCIAL: Método Gets para este campo
    */
  public String getSequencial() {
    return sequencial;
  }
  /**
    * SEQUENCIAL: Método Sets pára este campo.
    */
  public void setSequencial(String PARAM) {
    sequencial = PARAM;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * GRUPO: Método Gets para este campo
    */
  public String getGrupo() {
    return grupo;
  }
  /**
    * GRUPO: Método Sets pára este campo.
    */
  public void setGrupo(String PARAM) {
    grupo = PARAM;
  }
  /**
    * NOME_GRUPO: Método Gets para este campo
    */
  public String getNome_grupo() {
    return nome_grupo;
  }
  /**
    * NOME_GRUPO: Método Sets pára este campo.
    */
  public void setNome_grupo(String PARAM) {
    nome_grupo = PARAM;
  }
  /**
    * OC: Método Gets para este campo
    */
  public String getOc() {
    return oc;
  }
  /**
    * OC: Método Sets pára este campo.
    */
  public void setOc(String PARAM) {
    oc = PARAM;
  }
  /**
    * POS: Método Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Método Sets pára este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * OC_NOVA: Método Gets para este campo
    */
  public String getOc_nova() {
    return oc_nova;
  }
  /**
    * OC_NOVA: Método Sets pára este campo.
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
    * Validação dos campos, retornando um ActionErrors.
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
