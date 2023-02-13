package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/12/2019 09:46:11
 * Last Modify Date 09/01/2020 09:08:47
 */

public class LvPedidosIndenizadosDescontosActionForm extends org.apache.struts.action.ActionForm
{
  public String return0;
  public String ped_nmro1;
  public String nota_fiscal;
  public String serie;
  public String cli_cdgo;
  public String esc_seqn;
  public String pedido;
  public String erros;
  public boolean gridCheckField;
  public String ped_nmro;
  public String lin_cdgo;
  public String ref_cdgo;
  public String cab_cdgo;
  public String cab_desc;
  public String cor_cdgo;
  public String cor_desc;
  public String quantidade;
  public String codigo_motivo_troca;
  public String observacao;
  public String ite_seqn;
  public String ite_prco;
  public String desconto_comercial;
  public String desconto_promocional;
  public String ite_prco_descontos;
  private boolean valida = false;
  public LvPedidosIndenizadosDescontosActionForm() {
  }
  /**
    * RETURN0: Method to get the field value.
    */
  public String getReturn0() {
    return return0;
  }
  /**
    * RETURN0: Method to set the field value.
    */
  public void setReturn0(String PARAM) {
    return0 = PARAM;
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
    * NOTA_FISCAL: Method to get the field value.
    */
  public String getNota_fiscal() {
    return nota_fiscal;
  }
  /**
    * NOTA_FISCAL: Method to set the field value.
    */
  public void setNota_fiscal(String PARAM) {
    nota_fiscal = PARAM;
  }
  /**
    * SERIE: Method to get the field value.
    */
  public String getSerie() {
    return serie;
  }
  /**
    * SERIE: Method to set the field value.
    */
  public void setSerie(String PARAM) {
    serie = PARAM;
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
    * PEDIDO: Method to get the field value.
    */
  public String getPedido() {
    return pedido;
  }
  /**
    * PEDIDO: Method to set the field value.
    */
  public void setPedido(String PARAM) {
    pedido = PARAM;
  }
  /**
    * ERROS: Method to get the field value.
    */
  public String getErros() {
    return erros;
  }
  /**
    * ERROS: Method to set the field value.
    */
  public void setErros(String PARAM) {
    erros = PARAM;
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
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * REF_CDGO: Method to get the field value.
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Method to set the field value.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * CAB_CDGO: Method to get the field value.
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Method to set the field value.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  /**
    * CAB_DESC: Method to get the field value.
    */
  public String getCab_desc() {
    return cab_desc;
  }
  /**
    * CAB_DESC: Method to set the field value.
    */
  public void setCab_desc(String PARAM) {
    cab_desc = PARAM;
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
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * COR_DESC: Method to get the field value.
    */
  public String getCor_desc() {
    return cor_desc;
  }
  /**
    * COR_DESC: Method to set the field value.
    */
  public void setCor_desc(String PARAM) {
    cor_desc = PARAM;
  }
  /**
    * QUANTIDADE: Method to get the field value.
    */
  public String getQuantidade() {
    return quantidade;
  }
  /**
    * QUANTIDADE: Method to set the field value.
    */
  public void setQuantidade(String PARAM) {
    quantidade = PARAM;
  }
  /**
    * CODIGO_MOTIVO_TROCA: Method to get the field value.
    */
  public String getCodigo_motivo_troca() {
    return codigo_motivo_troca;
  }
  /**
    * CODIGO_MOTIVO_TROCA: Method to set the field value.
    */
  public void setCodigo_motivo_troca(String PARAM) {
    codigo_motivo_troca = PARAM;
  }
  private Vector codigo_motivo_trocaList = new Vector(10, 10);
  public void setCodigo_motivo_trocaList(java.util.Vector VECTOR) {
    codigo_motivo_trocaList = VECTOR;
  }
  public java.util.Vector getCodigo_motivo_trocaList() {
    if (codigo_motivo_trocaList == null || codigo_motivo_trocaList.size() == 0) {
      codigo_motivo_trocaList = new Vector(10, 10);
      codigo_motivo_trocaLabelList = new Vector(10, 10);
      codigo_motivo_trocaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      codigo_motivo_trocaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Sac_motivo_troca db_object = new Sac_motivo_troca();
        String[][] select = {{"codigo", null},{"descricao", null}};
        Object[][] where = null;
        String[] order = {"descricao"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Sac_motivo_troca) results.elementAt(i);
          codigo_motivo_trocaList.addElement(""+db_object.getCodigo());
          if (db_object.getCodigo() != 23) {
            codigo_motivo_trocaLabelList.addElement(""+db_object.getDescricao());
          } else {
            codigo_motivo_trocaLabelList.addElement("MONT. MAL FEITA/DIF ALT LAT BICO,TRAS:TORTO/DEFORM.");
          }
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "LvPedidosIndenizadosDescontos.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return codigo_motivo_trocaList;
  }
  private java.util.Vector codigo_motivo_trocaLabelList = new Vector(10, 10);
  public void setCodigo_motivo_trocaLabelList(java.util.Vector VECTOR) {
    codigo_motivo_trocaLabelList = VECTOR;
  }
  public java.util.Vector getCodigo_motivo_trocaLabelList() {
    return codigo_motivo_trocaLabelList;
  }
  /**
    * OBSERVACAO: Method to get the field value.
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Method to set the field value.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * ITE_SEQN: Method to get the field value.
    */
  public String getIte_seqn() {
    return ite_seqn;
  }
  /**
    * ITE_SEQN: Method to set the field value.
    */
  public void setIte_seqn(String PARAM) {
    ite_seqn = PARAM;
  }
  /**
    * ITE_PRCO: Method to get the field value.
    */
  public String getIte_prco() {
    return ite_prco;
  }
  /**
    * ITE_PRCO: Method to set the field value.
    */
  public void setIte_prco(String PARAM) {
    ite_prco = PARAM;
  }
  /**
    * DESCONTO_COMERCIAL: Method to get the field value.
    */
  public String getDesconto_comercial() {
    return desconto_comercial;
  }
  /**
    * DESCONTO_COMERCIAL: Method to set the field value.
    */
  public void setDesconto_comercial(String PARAM) {
    desconto_comercial = PARAM;
  }
  /**
    * DESCONTO_PROMOCIONAL: Method to get the field value.
    */
  public String getDesconto_promocional() {
    return desconto_promocional;
  }
  /**
    * DESCONTO_PROMOCIONAL: Method to set the field value.
    */
  public void setDesconto_promocional(String PARAM) {
    desconto_promocional = PARAM;
  }
  /**
    * ITE_PRCO_DESCONTOS: Method to get the field value.
    */
  public String getIte_prco_descontos() {
    return ite_prco_descontos;
  }
  /**
    * ITE_PRCO_DESCONTOS: Method to set the field value.
    */
  public void setIte_prco_descontos(String PARAM) {
    ite_prco_descontos = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    return0 = null;
    ped_nmro1 = null;
    nota_fiscal = null;
    serie = null;
    cli_cdgo = null;
    esc_seqn = null;
    pedido = null;
    erros = null;
    gridCheckField = false;
    ped_nmro = null;
    lin_cdgo = null;
    ref_cdgo = null;
    cab_cdgo = null;
    cab_desc = null;
    cor_cdgo = null;
    cor_desc = null;
    quantidade = null;
    codigo_motivo_troca = null;
    observacao = null;
    ite_seqn = null;
    ite_prco = null;
    desconto_comercial = null;
    desconto_promocional = null;
    ite_prco_descontos = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
