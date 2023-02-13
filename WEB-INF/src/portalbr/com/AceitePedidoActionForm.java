package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/03/2011 10:33:30
 * Last Modify Date 22/06/2015 13:14:25
 */

public class AceitePedidoActionForm extends org.apache.struts.action.ActionForm
{
  public String empresa_fatura;
  public String cli_cdgo;
  public String ano_fatura;
  public String nr_pedido;
  public String status;
  private boolean valida = false;
  public AceitePedidoActionForm() {
  }
  /**
    * EMPRESA_FATURA: Method to get the field value.
    */
  public String getEmpresa_fatura() {
    return empresa_fatura;
  }
  /**
    * EMPRESA_FATURA: Method to set the field value.
    */
  public void setEmpresa_fatura(String PARAM) {
    empresa_fatura = PARAM;
  }
  /**
    * CLI_CDGO: Method to get the field value.
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Method to set the field value.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * ANO_FATURA: Method to get the field value.
    */
  public String getAno_fatura() {
    return ano_fatura;
  }
  /**
    * ANO_FATURA: Method to set the field value.
    */
  public void setAno_fatura(String PARAM) {
    ano_fatura = PARAM;
  }
  /**
    * NR_PEDIDO: Method to get the field value.
    */
  public String getNr_pedido() {
    return nr_pedido;
  }
  /**
    * NR_PEDIDO: Method to set the field value.
    */
  public void setNr_pedido(String PARAM) {
    nr_pedido = PARAM;
  }
  /**
    * STATUS: Method to get the field value.
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Method to set the field value.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  Vector statusList = new Vector(10, 1);
  public java.util.Vector getStatusList() {
    if (statusList == null || statusList.size() == 0) {
      statusList.addElement("C");
      statusLabelList.addElement("Atual da fatura");
      statusList.addElement("A");
      statusLabelList.addElement("Aceite");
      statusList.addElement("N");
      statusLabelList.addElement("Negociação");
    }
    java.util.Vector list = statusList;
    return list;
  }
  java.util.Vector statusLabelList = new Vector(10, 1);
  public java.util.Vector getStatusLabelList() {
    java.util.Vector list = statusLabelList;
    return list;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    empresa_fatura = null;
    cli_cdgo = null;
    ano_fatura = null;
    nr_pedido = null;
    status = null;
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

    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(ano_fatura)) {
        errors.add("ano_fatura", new ActionMessage("error.validate.notnull","Ano do Pedido","ano_fatura","0"));
      }
      if (com.egen.util.text.Validate.isNull(nr_pedido)) {
        errors.add("nr_pedido", new ActionMessage("error.validate.notnull","Número do Pedido","nr_pedido","0"));
      }
      if (com.egen.util.text.Validate.isNull(status)) {
        errors.add("status", new ActionMessage("error.validate.notnull","Status","status","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
