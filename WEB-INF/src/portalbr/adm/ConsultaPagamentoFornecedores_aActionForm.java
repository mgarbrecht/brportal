package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/07/2018 14:57:02
 * Last Modify Date 27/07/2018 09:34:03
 */

public class ConsultaPagamentoFornecedores_aActionForm extends org.apache.struts.action.ActionForm
{
  public String nm_obri;
  public String cd_enti;
  public String codi_tipo_ender;
  public String cd_tipo;
  private boolean valida = false;
  public ConsultaPagamentoFornecedores_aActionForm() {
  }
  /**
    * NM_OBRI: Método Gets para este campo
    */
  public String getNm_obri() {
    return nm_obri;
  }
  /**
    * NM_OBRI: Método Sets pára este campo.
    */
  public void setNm_obri(String PARAM) {
    nm_obri = PARAM;
  }
  /**
    * CD_ENTI: Método Gets para este campo
    */
  public String getCd_enti() {
    return cd_enti;
  }
  /**
    * CD_ENTI: Método Sets pára este campo.
    */
  public void setCd_enti(String PARAM) {
    cd_enti = PARAM;
  }
  /**
    * CODI_TIPO_ENDER: Método Gets para este campo
    */
  public String getCodi_tipo_ender() {
    return codi_tipo_ender;
  }
  /**
    * CODI_TIPO_ENDER: Método Sets pára este campo.
    */
  public void setCodi_tipo_ender(String PARAM) {
    codi_tipo_ender = PARAM;
  }
  /**
    * CD_TIPO: Método Gets para este campo
    */
  public String getCd_tipo() {
    return cd_tipo;
  }
  /**
    * CD_TIPO: Método Sets pára este campo.
    */
  public void setCd_tipo(String PARAM) {
    cd_tipo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    nm_obri = null;
    cd_enti = null;
    codi_tipo_ender = null;
    cd_tipo = null;
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
