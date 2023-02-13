package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/02/2014 15:25:48
 * Last Modify Date 06/02/2014 15:39:15
 */

public class DownloadArquivosActionForm extends org.apache.struts.action.ActionForm
{
  public String lidi_tien_id;
  public String tien_tipo;
  public String lidi_id;
  public String lidi_titulo;
  public String lidi_descricao;
  public String lidi_caminho;
  public String lidi_marca;
  public String lidi_tipo;
  private boolean valida = false;
  public DownloadArquivosActionForm() {
  }
  /**
    * LIDI_TIEN_ID: Método Gets para este campo
    */
  public String getLidi_tien_id() {
    return lidi_tien_id;
  }
  /**
    * LIDI_TIEN_ID: Método Sets pára este campo.
    */
  public void setLidi_tien_id(String PARAM) {
    lidi_tien_id = PARAM;
  }
  /**
    * TIEN_TIPO: Método Gets para este campo
    */
  public String getTien_tipo() {
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: Método Sets pára este campo.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * LIDI_ID: Método Gets para este campo
    */
  public String getLidi_id() {
    return lidi_id;
  }
  /**
    * LIDI_ID: Método Sets pára este campo.
    */
  public void setLidi_id(String PARAM) {
    lidi_id = PARAM;
  }
  /**
    * LIDI_TITULO: Método Gets para este campo
    */
  public String getLidi_titulo() {
    return lidi_titulo;
  }
  /**
    * LIDI_TITULO: Método Sets pára este campo.
    */
  public void setLidi_titulo(String PARAM) {
    lidi_titulo = PARAM;
  }
  /**
    * LIDI_DESCRICAO: Método Gets para este campo
    */
  public String getLidi_descricao() {
    return lidi_descricao;
  }
  /**
    * LIDI_DESCRICAO: Método Sets pára este campo.
    */
  public void setLidi_descricao(String PARAM) {
    lidi_descricao = PARAM;
  }
  /**
    * LIDI_CAMINHO: Método Gets para este campo
    */
  public String getLidi_caminho() {
    return lidi_caminho;
  }
  /**
    * LIDI_CAMINHO: Método Sets pára este campo.
    */
  public void setLidi_caminho(String PARAM) {
    lidi_caminho = PARAM;
  }
  /**
    * LIDI_MARCA: Método Gets para este campo
    */
  public String getLidi_marca() {
    return lidi_marca;
  }
  /**
    * LIDI_MARCA: Método Sets pára este campo.
    */
  public void setLidi_marca(String PARAM) {
    lidi_marca = PARAM;
  }
  /**
    * LIDI_TIPO: Método Gets para este campo
    */
  public String getLidi_tipo() {
    return lidi_tipo;
  }
  /**
    * LIDI_TIPO: Método Sets pára este campo.
    */
  public void setLidi_tipo(String PARAM) {
    lidi_tipo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lidi_tien_id = null;
    tien_tipo = null;
    lidi_id = null;
    lidi_titulo = null;
    lidi_descricao = null;
    lidi_caminho = null;
    lidi_marca = null;
    lidi_tipo = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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

    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
