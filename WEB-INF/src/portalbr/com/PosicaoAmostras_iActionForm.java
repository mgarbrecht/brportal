package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 31/01/2011 07:55:53
 * Last Modify Date 16/07/2019 09:26:56
 */

public class PosicaoAmostras_iActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_nmro;
  public String id_situacao;
  public String observacao;
  public String posicao;
  private boolean valida = false;
  public PosicaoAmostras_iActionForm() {
  }
  /**
    * PED_NMRO: Método Gets para este campo
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Método Sets pára este campo.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * ID_SITUACAO: Método Gets para este campo
    */
  public String getId_situacao() {
    return id_situacao;
  }
  /**
    * ID_SITUACAO: Método Sets pára este campo.
    */
  public void setId_situacao(String PARAM) {
    id_situacao = PARAM;
  }
  /**
    * OBSERVACAO: Método Gets para este campo
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Método Sets pára este campo.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * POSICAO: Método Gets para este campo
    */
  public String getPosicao() {
    return posicao;
  }
  /**
    * POSICAO: Método Sets pára este campo.
    */
  public void setPosicao(String PARAM) {
    posicao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_nmro = null;
    id_situacao = null;
    observacao = null;
    posicao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (!com.egen.util.text.Validate.isNumber(ped_nmro)) {
        errors.add("ped_nmro", new ActionMessage("error.validate.number","Ped_nmro","ped_nmro","0"));
      }
      if (com.egen.util.text.Validate.isNull(observacao)) {
        errors.add("observacao", new ActionMessage("error.validate.notnull","Observação","observacao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
