package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/09/2016 17:24:12
 * Last Modify Date 21/09/2016 13:04:34
 */

public class PrecoVendaPedidoActionForm extends org.apache.struts.action.ActionForm
{
  public String cli_cdgo;
  public String esc_seqn;
  public String cli_rzao;
  public String pedidos;
  public String ped_daem_inicial;
  public String ped_daem_final;
  public String ped_ped_cliente;
  public String rep_cdgo;
  public String codigo_regional;
  private boolean valida = false;
  public PrecoVendaPedidoActionForm() {
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * ESC_SEQN: Método Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Método Sets pára este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = { {"cli_rzao",null} };
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        } else {
          cli_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(PrecoVendaPedidoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=", PARAM.getCli_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * PEDIDOS: Método Gets para este campo
    */
  public String getPedidos() {
    return pedidos;
  }
  /**
    * PEDIDOS: Método Sets pára este campo.
    */
  public void setPedidos(String PARAM) {
    pedidos = PARAM;
  }
  /**
    * PED_DAEM_INICIAL: Método Gets para este campo
    */
  public String getPed_daem_inicial() {
    return ped_daem_inicial;
  }
  /**
    * PED_DAEM_INICIAL: Método Sets pára este campo.
    */
  public void setPed_daem_inicial(String PARAM) {
    ped_daem_inicial = PARAM;
  }
  /**
    * PED_DAEM_FINAL: Método Gets para este campo
    */
  public String getPed_daem_final() {
    return ped_daem_final;
  }
  /**
    * PED_DAEM_FINAL: Método Sets pára este campo.
    */
  public void setPed_daem_final(String PARAM) {
    ped_daem_final = PARAM;
  }
  /**
    * PED_PED_CLIENTE: Método Gets para este campo
    */
  public String getPed_ped_cliente() {
    return ped_ped_cliente;
  }
  /**
    * PED_PED_CLIENTE: Método Sets pára este campo.
    */
  public void setPed_ped_cliente(String PARAM) {
    ped_ped_cliente = PARAM;
  }
  /**
    * REP_CDGO: Método Gets para este campo
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Método Sets pára este campo.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Método Sets pára este campo.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cli_cdgo = null;
    esc_seqn = null;
    cli_rzao = null;
    pedidos = null;
    ped_daem_inicial = null;
    ped_daem_final = null;
    ped_ped_cliente = null;
    rep_cdgo = null;
    codigo_regional = null;
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
