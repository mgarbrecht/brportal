package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 15/03/2011 11:09:56
 * Last Modify Date 29/07/2022 15:25:54
 */

public class PedidosIndenizadosDescontosActionForm extends org.apache.struts.action.ActionForm
{
  public boolean gridCheckField;
  public String alterado;
  public String banco;
  public String ped_nmro;
  public String tipo_desconto;
  public String ped_obse;
  public String valor_desconto;
  public String percentual_desc;
  public String prazo_adicional;
  public String cnd_cdgo;
  public String situacao;
  public String ped_afv;
  public String cliente;
  public String situacao_banco;
  public String status;
  public String valor_pedido;
  public String cnd_cdgo_ped;
  public String cnd_desc;
  public String ped_especie_pedido;
  public String cli_cdgo1;
  public String cli_cdgo;
  public String codigo_marca;
  public String esc_seqn;
  public String codigo_regional;
  public String nome_regional;
  public String ped_nmro1;
  private boolean valida = false;
  public PedidosIndenizadosDescontosActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Method to get the field value.
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Method to set the field value.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * ALTERADO: Method to get the field value.
    */
  public String getAlterado() {
    return alterado;
  }
  /**
    * ALTERADO: Method to set the field value.
    */
  public void setAlterado(String PARAM) {
    alterado = PARAM;
  }
  /**
    * BANCO: Method to get the field value.
    */
  public String getBanco() {
    return banco;
  }
  /**
    * BANCO: Method to set the field value.
    */
  public void setBanco(String PARAM) {
    banco = PARAM;
  }
  /**
    * PED_NMRO: Method to get the field value.
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Method to set the field value.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * TIPO_DESCONTO: Method to get the field value.
    */
  public String getTipo_desconto() {
    return tipo_desconto;
  }
  /**
    * TIPO_DESCONTO: Method to set the field value.
    */
  public void setTipo_desconto(String PARAM) {
    tipo_desconto = PARAM;
  }
  private Vector tipo_descontoList = new Vector(10, 10);
  public void setTipo_descontoList(java.util.Vector VECTOR) {
    tipo_descontoList = VECTOR;
  }
  public java.util.Vector getTipo_descontoList() {
    tipo_descontoList = new Vector(10, 10);
    tipo_descontoLabelList = new Vector(10, 10);
    //  tipo_descontoList.addElement("");
    //  java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    //  tipo_descontoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Ped_tipo_desconto db_object = new Ped_tipo_desconto();
      String[][] select = {{"tipo_cdgo", null},{"descr_tipo", null}};
      Object[][] where = {{"situacao","=","A"}};
      String[] order = {"tipo_cdgo"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Ped_tipo_desconto) results.elementAt(i);
        tipo_descontoList.addElement(""+db_object.getTipo_cdgo());
        tipo_descontoLabelList.addElement(""+db_object.getDescr_tipo());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "PedidosIndenizadosDescontos.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return tipo_descontoList;
  }
  private java.util.Vector tipo_descontoLabelList = new Vector(10, 10);
  public void setTipo_descontoLabelList(java.util.Vector VECTOR) {
    tipo_descontoLabelList = VECTOR;
  }
  public java.util.Vector getTipo_descontoLabelList() {
    return tipo_descontoLabelList;
  }
  /**
    * PED_OBSE: Method to get the field value.
    */
  public String getPed_obse() {
    return ped_obse;
  }
  /**
    * PED_OBSE: Method to set the field value.
    */
  public void setPed_obse(String PARAM) {
    ped_obse = PARAM;
  }
  /**
    * VALOR_DESCONTO: Method to get the field value.
    */
  public String getValor_desconto() {
    return valor_desconto;
  }
  /**
    * VALOR_DESCONTO: Method to set the field value.
    */
  public void setValor_desconto(String PARAM) {
    valor_desconto = PARAM;
  }
  /**
    * PERCENTUAL_DESC: Method to get the field value.
    */
  public String getPercentual_desc() {
    return percentual_desc;
  }
  /**
    * PERCENTUAL_DESC: Method to set the field value.
    */
  public void setPercentual_desc(String PARAM) {
    percentual_desc = PARAM;
  }
  /**
    * PRAZO_ADICIONAL: Method to get the field value.
    */
  public String getPrazo_adicional() {
    return prazo_adicional;
  }
  /**
    * PRAZO_ADICIONAL: Method to set the field value.
    */
  public void setPrazo_adicional(String PARAM) {
    prazo_adicional = PARAM;
  }
  /**
    * CND_CDGO: Method to get the field value.
    */
  public String getCnd_cdgo() {
    return cnd_cdgo;
  }
  /**
    * CND_CDGO: Method to set the field value.
    */
  public void setCnd_cdgo(String PARAM) {
    cnd_cdgo = PARAM;
  }
  private Vector cnd_cdgoList = new Vector(10, 10);
  public void setCnd_cdgoList(java.util.Vector VECTOR) {
    cnd_cdgoList = VECTOR;
  }
  public java.util.Vector getCnd_cdgoList() {
    if (cnd_cdgoList == null || cnd_cdgoList.size() == 0) {
      cnd_cdgoList = new Vector(10, 10);
      cnd_cdgoLabelList = new Vector(10, 10);
      cnd_cdgoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      cnd_cdgoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cnd_indenizacoes_vw db_object = new Cnd_indenizacoes_vw();
        String[][] select = {{"cnd_cdgo", null},{"cnd_desc", null}};
        Object[][] where = null;
        String[] order = {"cnd_desc"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cnd_indenizacoes_vw) results.elementAt(i);
          cnd_cdgoList.addElement(""+db_object.getCnd_cdgo());
          cnd_cdgoLabelList.addElement(""+db_object.getCnd_desc());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "PedidosIndenizadosDescontos.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return cnd_cdgoList;
  }
  private java.util.Vector cnd_cdgoLabelList = new Vector(10, 10);
  public void setCnd_cdgoLabelList(java.util.Vector VECTOR) {
    cnd_cdgoLabelList = VECTOR;
  }
  public java.util.Vector getCnd_cdgoLabelList() {
    return cnd_cdgoLabelList;
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
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * PED_AFV: Method to get the field value.
    */
  public String getPed_afv() {
    return ped_afv;
  }
  /**
    * PED_AFV: Method to set the field value.
    */
  public void setPed_afv(String PARAM) {
    ped_afv = PARAM;
  }
  /**
    * CLIENTE: Method to get the field value.
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Method to set the field value.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * SITUACAO_BANCO: Method to get the field value.
    */
  public String getSituacao_banco() {
    return situacao_banco;
  }
  /**
    * SITUACAO_BANCO: Method to set the field value.
    */
  public void setSituacao_banco(String PARAM) {
    situacao_banco = PARAM;
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
  /**
    * VALOR_PEDIDO: Method to get the field value.
    */
  public String getValor_pedido() {
    return valor_pedido;
  }
  /**
    * VALOR_PEDIDO: Method to set the field value.
    */
  public void setValor_pedido(String PARAM) {
    valor_pedido = PARAM;
  }
  /**
    * CND_CDGO_PED: Method to get the field value.
    */
  public String getCnd_cdgo_ped() {
    return cnd_cdgo_ped;
  }
  /**
    * CND_CDGO_PED: Method to set the field value.
    */
  public void setCnd_cdgo_ped(String PARAM) {
    cnd_cdgo_ped = PARAM;
  }
  /**
    * CND_DESC: Method to get the field value.
    */
  public String getCnd_desc() {
    return cnd_desc;
  }
  /**
    * CND_DESC: Method to set the field value.
    */
  public void setCnd_desc(String PARAM) {
    cnd_desc = PARAM;
  }
  /**
    * PED_ESPECIE_PEDIDO: Method to get the field value.
    */
  public String getPed_especie_pedido() {
    return ped_especie_pedido;
  }
  /**
    * PED_ESPECIE_PEDIDO: Method to set the field value.
    */
  public void setPed_especie_pedido(String PARAM) {
    ped_especie_pedido = PARAM;
  }
  /**
    * CLI_CDGO1: Method to get the field value.
    */
  public String getCli_cdgo1() {
    return cli_cdgo1;
  }
  /**
    * CLI_CDGO1: Method to set the field value.
    */
  public void setCli_cdgo1(String PARAM) {
    cli_cdgo1 = PARAM;
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
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * ESC_SEQN: Method to get the field value.
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Method to set the field value.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Method to get the field value.
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Method to set the field value.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * NOME_REGIONAL: Method to get the field value.
    */
  public String getNome_regional() {
    return nome_regional;
  }
  /**
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
  }
  /**
    * PED_NMRO1: Method to get the field value.
    */
  public String getPed_nmro1() {
    return ped_nmro1;
  }
  /**
    * PED_NMRO1: Method to set the field value.
    */
  public void setPed_nmro1(String PARAM) {
    ped_nmro1 = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = false;
    alterado = null;
    banco = null;
    ped_nmro = null;
    tipo_desconto = null;
    ped_obse = null;
    valor_desconto = null;
    percentual_desc = null;
    prazo_adicional = null;
    cnd_cdgo = null;
    situacao = null;
    ped_afv = null;
    cliente = null;
    situacao_banco = null;
    status = null;
    valor_pedido = null;
    cnd_cdgo_ped = null;
    cnd_desc = null;
    ped_especie_pedido = null;
    cli_cdgo1 = null;
    cli_cdgo = null;
    codigo_marca = null;
    esc_seqn = null;
    codigo_regional = null;
    nome_regional = null;
    ped_nmro1 = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,ajustar_pedidos_action,cancelar_action,", request)) {
    }
    if (com.egen.util.text.Validate.isValidate("update_pedido_action,update_pedido1_action,update_pedido2_action,", request)) {
      if (com.egen.util.text.Validate.isNull(ped_nmro1)) {
        errors.add("ped_nmro1", new ActionMessage("error.validate.notnull","Ped_nmro","ped_nmro1","1"));
      }
      if (!com.egen.util.text.Validate.isNumber(ped_nmro1)) {
        errors.add("ped_nmro1", new ActionMessage("error.validate.number","Ped_nmro","ped_nmro1","1"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
