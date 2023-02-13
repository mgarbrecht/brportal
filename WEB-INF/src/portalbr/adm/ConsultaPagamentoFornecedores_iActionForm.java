package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 12/03/2018 11:12:12
 * Last Modify Date 12/03/2018 12:15:20
 */

public class ConsultaPagamentoFornecedores_iActionForm extends org.apache.struts.action.ActionForm
{
  public String comunicado;
  public String mostrar;
  private boolean valida = false;
  public ConsultaPagamentoFornecedores_iActionForm() {
  }
  /**
    * COMUNICADO: Método Gets para este campo
    */
  public String getComunicado() {
    return comunicado;
  }
  /**
    * COMUNICADO: Método Sets pára este campo.
    */
  public void setComunicado(String PARAM) {
    comunicado = PARAM;
  }
  /**
    * MOSTRAR: Método Gets para este campo
    */
  public String getMostrar() {
    return mostrar;
  }
  /**
    * MOSTRAR: Método Sets pára este campo.
    */
  public void setMostrar(String PARAM) {
    mostrar = PARAM;
  }
  Vector mostrarList = new Vector(10, 1);
  public java.util.Vector getMostrarList() {
    if (mostrarList == null || mostrarList.size() == 0) {
      mostrarList.addElement("S");
      mostrarLabelList.addElement("Sim");
      mostrarList.addElement("N");
      mostrarLabelList.addElement("Não");
    }
    java.util.Vector list = mostrarList;
    return list;
  }
  java.util.Vector mostrarLabelList = new Vector(10, 1);
  public java.util.Vector getMostrarLabelList() {
    java.util.Vector list = mostrarLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    comunicado = null;
    mostrar = null;
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

    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      if (com.egen.util.text.Validate.isNull(comunicado)) {
        errors.add("comunicado", new ActionMessage("error.validate.notnull","Comunicado","comunicado","0"));
      }
      if (com.egen.util.text.Validate.isNull(mostrar)) {
        errors.add("mostrar", new ActionMessage("error.validate.notnull","Mostrar","mostrar","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
