package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/08/2006 09:57:01
 * Last Modify Date 21/08/2013 11:43:15
 */

public class ClientesGruposActionForm extends org.apache.struts.action.ActionForm
{
  public String gre_grupo;
  public String gre_descricao;
  public String cli_cdgo;
  public String cli_nome;
  public String cli_rzao;
  public String cli_situ;
  public String clientes;
  public boolean gridCheckField;
  public String pos;
  private boolean valida = false;
  public ClientesGruposActionForm() {
  }
  /**
    * GRE_GRUPO: Método Gets para este campo
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Método Sets pára este campo.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
  }
  /**
    * GRE_DESCRICAO: Método Gets para este campo
    */
  public String getGre_descricao() {
    return gre_descricao;
  }
  /**
    * GRE_DESCRICAO: Método Sets pára este campo.
    */
  public void setGre_descricao(String PARAM) {
    gre_descricao = PARAM;
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * CLI_NOME: Método Gets para este campo
    */
  public String getCli_nome() {
    return cli_nome;
  }
  /**
    * CLI_NOME: Método Sets pára este campo.
    */
  public void setCli_nome(String PARAM) {
    cli_nome = PARAM;
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
    * CLI_SITU: Método Gets para este campo
    */
  public String getCli_situ() {
    return cli_situ;
  }
  /**
    * CLI_SITU: Método Sets pára este campo.
    */
  public void setCli_situ(String PARAM) {
    cli_situ = PARAM;
  }
  /**
    * CLIENTES: Método Gets para este campo
    */
  public String getClientes() {
    return clientes;
  }
  /**
    * CLIENTES: Método Sets pára este campo.
    */
  public void setClientes(String PARAM) {
    clientes = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gre_grupo = null;
    gre_descricao = null;
    cli_cdgo = null;
    cli_nome = null;
    cli_rzao = null;
    cli_situ = null;
    clientes = null;
    gridCheckField = false;
    pos = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
