package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Creation Date 07/03/2006 15:03:23
 * Last Modify Date 09/06/2006 08:52:43
 */

public class ConsultaPedidosClientesActionForm extends org.apache.struts.action.ActionForm
{
  public String situacao;
  public String dt_entrega;
  public String cli_cdgo;
  public String cid_uf;
  public String razao_social;
  public String codigo;
  private boolean valida = false;
  public ConsultaPedidosClientesActionForm() {
  }
  /**
    * SITUACAO: Method to get the field value.
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Method to set the field value.
    */
  public void setSituacao(String SITUACAO) {
    situacao = SITUACAO;
  }
  Vector situacaoList = new Vector(10, 1);
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList.addElement("T");
      situacaoLabelList.addElement("Todas");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("Pedidos Abertos/Cancelados");
      situacaoList.addElement("F");
      situacaoLabelList.addElement("Pedidos Faturados");
    }
    java.util.Vector list = situacaoList;
    return list;
  }
  java.util.Vector situacaoLabelList = new Vector(10, 1);
  public java.util.Vector getSituacaoLabelList() {
    java.util.Vector list = situacaoLabelList;
    return list;
  }
  /**
    * DT_ENTREGA: Method to get the field value.
    */
  public String getDt_entrega() {
    return dt_entrega;
  }
  /**
    * DT_ENTREGA: Method to set the field value.
    */
  public void setDt_entrega(String DT_ENTREGA) {
    dt_entrega = DT_ENTREGA;
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
  public void setCli_cdgo(String CLI_CDGO) {
    cli_cdgo = CLI_CDGO;
  }
  /**
    * CID_UF: Method to get the field value.
    */
  public String getCid_uf() {
    return cid_uf;
  }
  /**
    * CID_UF: Method to set the field value.
    */
  public void setCid_uf(String CID_UF) {
    cid_uf = CID_UF;
  }
  /**
    * RAZAO_SOCIAL: Method to get the field value.
    */
  public String getRazao_social() {
    return razao_social;
  }
  /**
    * RAZAO_SOCIAL: Method to set the field value.
    */
  public void setRazao_social(String RAZAO_SOCIAL) {
    razao_social = RAZAO_SOCIAL;
  }
  /**
    * CODIGO: Method to get the field value.
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Method to set the field value.
    */
  public void setCodigo(String CODIGO) {
    codigo = CODIGO;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    situacao = null;
    dt_entrega = null;
    cli_cdgo = null;
    cid_uf = null;
    razao_social = null;
    codigo = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (!com.egen.util.text.Validate.isDate(dt_entrega)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_consulta_pedidos", new ActionMessage("error.validate.date","Data Entrega acima de","dt_entrega","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}