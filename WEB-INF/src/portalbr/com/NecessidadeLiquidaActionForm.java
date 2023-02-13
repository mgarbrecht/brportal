package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Creation Date 04/10/2005 13:34:42
 * Last Modify Date 07/07/2006 17:41:49
 */

public class NecessidadeLiquidaActionForm extends org.apache.struts.action.ActionForm
{
  public String fornecedor;
  public String for_codigo;
  public String for_razsoc;
  public String ies_codigo;
  public String cor_cdgo;
  public String necessidade;
  public String tipo;
  public String pedido_inicial;
  public String pedido_final;
  private boolean valida = false;
  public NecessidadeLiquidaActionForm() {
  }

  /**
    * FOR_CODIGO: Method to get the field value.
    */
  public String getFor_codigo() {
    return for_codigo;
  }
  /**
    * FOR_CODIGO: Method to set the field value.
    */
  public void setFor_codigo(String FOR_CODIGO) {
    for_codigo = FOR_CODIGO;
  }

  /**
    * FOR_RAZSOC: Method to get the field value.
    */
  public String getFor_razsoc() {
    return for_razsoc;
  }
  /**
    * FOR_RAZSOC: Method to set the field value.
    */
  public void setFor_razsoc(String FOR_RAZSOC) {
    for_razsoc = FOR_RAZSOC;
  }

  /**
    * TIPO: Método Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Método Sets pára este campo.
    */
  public void setTipo(String TIPO) {
    tipo = TIPO;
  }

  /**
    * FORNECEDOR: Method to get the field value.
    */
  public String getFornecedor() {
    return fornecedor;
  }
  /**
    * FORNECEDOR: Method to set the field value.
    */
  public void setFornecedor(String FORNECEDOR) {
    fornecedor = FORNECEDOR;
  }
  /**
    * IES_CODIGO: Method to get the field value.
    */
  public String getIes_codigo() {
    return ies_codigo;
  }
  /**
    * IES_CODIGO: Method to set the field value.
    */
  public void setIes_codigo(String IES_CODIGO) {
    ies_codigo = IES_CODIGO;
  }
  /**
    * COR_CDGO: Method to get the field value.
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Method to set the field value.
    */
  public void setCor_cdgo(String COR_CDGO) {
    cor_cdgo = COR_CDGO;
  }
  /**
    * NECESSIDADE: Method to get the field value.
    */
  public String getNecessidade() {
    return necessidade;
  }
  /**
    * NECESSIDADE: Method to set the field value.
    */
  public void setNecessidade(String NECESSIDADE) {
    necessidade = NECESSIDADE;
  }


  Vector necessidadeList = new Vector(10, 1);
  public java.util.Vector getNecessidadeList() {
    if (necessidadeList == null || necessidadeList.size() == 0) {
      necessidadeList.addElement("-999999999");
      necessidadeLabelList.addElement("Não");
      necessidadeList.addElement("0");
      necessidadeLabelList.addElement("Sim");
    }
    java.util.Vector list = necessidadeList;
    return list;
  }
  java.util.Vector necessidadeLabelList = new Vector(10, 1);
  public java.util.Vector getNecessidadeLabelList() {
    java.util.Vector list = necessidadeLabelList;
    return list;
  }
  /**
    * PEDIDO_INICIAL: Method to get the field value.
    */
  public String getPedido_inicial() {
    return pedido_inicial;
  }
  /**
    * PEDIDO_INICIAL: Method to set the field value.
    */
  public void setPedido_inicial(String PEDIDO_INICIAL) {
    pedido_inicial = PEDIDO_INICIAL;
  }
  /**
    * PEDIDO_FINAL: Method to get the field value.
    */
  public String getPedido_final() {
    return pedido_final;
  }
  /**
    * PEDIDO_FINAL: Method to set the field value.
    */
  public void setPedido_final(String PEDIDO_FINAL) {
    pedido_final = PEDIDO_FINAL;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fornecedor = null;
    ies_codigo = null;
    cor_cdgo = null;
    necessidade = null;
    pedido_inicial = null;
    pedido_final = null;
    for_codigo = null;
    for_razsoc = null;
    tipo = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (!com.egen.util.text.Validate.isNull(ies_codigo)) {
        if (!com.egen.util.text.Validate.isRegex(ies_codigo, "^[0-9]*$")) {
          errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.regex","Item","ies_codigo","0"));
        }
      }
      if (!com.egen.util.text.Validate.isNull(cor_cdgo)) {
        if (!com.egen.util.text.Validate.isRegex(cor_cdgo, "^[0-9]*$")) {
          errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.regex","Cor","cor_cdgo","0"));
        }
      }

      if (!com.egen.util.text.Validate.isNull(for_codigo)) {
        if (!com.egen.util.text.Validate.isRegex(for_codigo, "^[0-9]*$")) {
          errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.regex","Fornecedor","for_codigo","0"));
        }
      }

      if (com.egen.util.text.Validate.isNull(pedido_inicial)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.notnull","Entrada de Pedido Inicial","pedido_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(pedido_inicial)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.date","Entrada de Pedido Inicial","pedido_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(pedido_final)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.notnull","Entrada de Pedido Final","pedido_final","0"));
      }
      if (!com.egen.util.text.Validate.isDate(pedido_final)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.date","Entrada de Pedido Final","pedido_final","0"));
      }
//-----------------
     String chave2="";
     String tipo2="";
     acesso.Usuario u2 = new acesso.Usuario();
     u2 = (acesso.Usuario)session.getAttribute("User");
     acesso.EntidadeNegocio ent2 = new acesso.EntidadeNegocio();
     acesso.TipoEntidadeNegocio tipoent2 = new acesso.TipoEntidadeNegocio();

     if(!(u2.getEntidadeNegocio()==null)){
          ent2 = (acesso.EntidadeNegocio) u2.getEntidadeNegocio();
          tipoent2 = (acesso.TipoEntidadeNegocio) ent2.getTipoEntidadeNegocio();
          tipo2 = tipoent2.getTipo()+"";
          if(tipo2.equals("FORNECEDOR")){
            chave2 = ent2.getChave()+"";
          }

     }
     if(chave2.equals("")){
        if (com.egen.util.text.Validate.isNull(for_codigo)) {
           errors.add("ActionErrors.GLOBAL_ERROR_bl_form_NecessidadeLiquida", new ActionMessage("error.validate.notnull","Fornecedor","for_codigo","0"));
        }
     }

//-----------------

    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
