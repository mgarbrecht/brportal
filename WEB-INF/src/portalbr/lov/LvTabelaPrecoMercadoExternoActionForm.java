package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/04/2012 14:02:05
 * Last Modify Date 09/10/2015 10:14:27
 */

public class LvTabelaPrecoMercadoExternoActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String codigo_livro;
  public String versao_tabela;
  private boolean valida = false;
  public LvTabelaPrecoMercadoExternoActionForm() {
  }
  /**
    * RETURN0: Método Gets para este campo
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Método Sets pára este campo.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
  }
  /**
    * CODIGO_LIVRO: Método Gets para este campo
    */
  public String getCodigo_livro() {
    return codigo_livro;
  }
  /**
    * CODIGO_LIVRO: Método Sets pára este campo.
    */
  public void setCodigo_livro(String PARAM) {
    codigo_livro = PARAM;
  }
  /**
    * VERSAO_TABELA: Método Gets para este campo
    */
  public String getVersao_tabela() {
    return versao_tabela;
  }
  /**
    * VERSAO_TABELA: Método Sets pára este campo.
    */
  public void setVersao_tabela(String PARAM) {
    versao_tabela = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    codigo_livro = null;
    versao_tabela = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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
