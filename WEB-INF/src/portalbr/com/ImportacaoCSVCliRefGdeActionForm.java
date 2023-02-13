package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 11/05/2015 11:06:01
 * Last Modify Date 23/06/2015 10:40:58
 */

import org.apache.struts.upload.FormFile;

public class ImportacaoCSVCliRefGdeActionForm extends org.apache.struts.action.ActionForm
{
  public FormFile arquivo;
  public String filialFat;
  public String ordemCompra;
  private boolean valida = false;
  public ImportacaoCSVCliRefGdeActionForm() {
  }
  /**
    * ARQUIVO: Method to get the field value.
    */
  public FormFile getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Method to set the field value.
    */
  public void setArquivo(FormFile PARAM) {
    arquivo = PARAM;
  }
  /**
    * FILIALFAT: Method to get the field value.
    */
  public String getFilialFat() {
    return filialFat;
  }
  /**
    * FILIALFAT: Method to set the field value.
    */
  public void setFilialFat(String PARAM) {
    filialFat = PARAM;
  }
  /**
    * ORDEMCOMPRA: Method to get the field value.
    */
  public String getOrdemCompra() {
    return ordemCompra;
  }
  /**
    * ORDEMCOMPRA: Method to set the field value.
    */
  public void setOrdemCompra(String PARAM) {
    ordemCompra = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    arquivo = null;
    filialFat = null;
    ordemCompra = null;
  }
  /**
    * Validate fields and return errors.
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
