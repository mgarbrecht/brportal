package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/04/2012 13:09:11
 * Last Modify Date 24/08/2018 14:37:27
 */

public class CadastroOrdemCompraActionForm extends org.apache.struts.action.ActionForm
{
  public String ordem_compra;
  public String rep_cdgo;
  public String rep_rzao;
  public String cliente;
  public String sequencial;
  public String dsp_cliente;
  public String grupo_economico;
  public String dsp_grupo;
  public String lin_cdgo;
  public String pedido;
  private boolean valida = false;
  public CadastroOrdemCompraActionForm() {
  }
  /**
    * ORDEM_COMPRA: Método Gets para este campo
    */
  public String getOrdem_compra() {
    return ordem_compra;
  }
  /**
    * ORDEM_COMPRA: Método Sets pára este campo.
    */
  public void setOrdem_compra(String PARAM) {
    ordem_compra = PARAM;
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
    * REP_RZAO: Método Gets para este campo
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"rep_rzao",null} };
        Object[][] where = { {"rep_cdgo","like",rep_cdgo}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          rep_rzao = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        } else {
          rep_rzao = "";
        }
      }
    } catch (Exception e) {
      rep_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(CadastroOrdemCompraActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          list[0] = new String[]{"rep_rzao", (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":""};
        } else {
          list[0] = new String[]{"rep_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"rep_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * CLIENTE: Método Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Método Sets pára este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * SEQUENCIAL: Método Gets para este campo
    */
  public String getSequencial() {
    return sequencial;
  }
  /**
    * SEQUENCIAL: Método Sets pára este campo.
    */
  public void setSequencial(String PARAM) {
    sequencial = PARAM;
  }
  /**
    * DSP_CLIENTE: Método Gets para este campo
    */
  public String getDsp_cliente() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cliente != null && cliente.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = { {"cli_rzao",null} };
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cliente)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          dsp_cliente = ((db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"");
        } else {
          dsp_cliente = "";
        }
      }
    } catch (Exception e) {
      dsp_cliente = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return dsp_cliente;
  }

  public String[][] getDsp_cliente_Ajax(CadastroOrdemCompraActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCliente() != null && PARAM.getCliente().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=",PARAM.getCliente()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"dsp_cliente", ((db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"")};
        } else {
          list[0] = new String[]{"dsp_cliente", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"dsp_cliente", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DSP_CLIENTE: Método Sets pára este campo.
    */
  public void setDsp_cliente(String PARAM) {
    dsp_cliente = PARAM;
  }
  /**
    * GRUPO_ECONOMICO: Método Gets para este campo
    */
  public String getGrupo_economico() {
    return grupo_economico;
  }
  /**
    * GRUPO_ECONOMICO: Método Sets pára este campo.
    */
  public void setGrupo_economico(String PARAM) {
    grupo_economico = PARAM;
  }
  /**
    * DSP_GRUPO: Método Gets para este campo
    */
  public String getDsp_grupo() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (grupo_economico != null && grupo_economico.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        String[][] select = { {"gre_descricao",null} };
        Object[][] where = { {"gre_grupo","=",com.egen.util.text.FormatNumber.toInt(grupo_economico)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Grupo_economico) results.elementAt(0);
          dsp_grupo = ((db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":"");
        } else {
          dsp_grupo = "";
        }
      }
    } catch (Exception e) {
      dsp_grupo = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return dsp_grupo;
  }

  public String[][] getDsp_grupo_Ajax(CadastroOrdemCompraActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGrupo_economico() != null && PARAM.getGrupo_economico().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        Object[][] where = { {"gre_grupo","like",PARAM.getGrupo_economico()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Grupo_economico) results.elementAt(0);
          list[0] = new String[]{"dsp_grupo", ((db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":"")};
        } else {
          list[0] = new String[]{"dsp_grupo", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"dsp_grupo", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DSP_GRUPO: Método Sets pára este campo.
    */
  public void setDsp_grupo(String PARAM) {
    dsp_grupo = PARAM;
  }
  /**
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * PEDIDO: Método Gets para este campo
    */
  public String getPedido() {
    return pedido;
  }
  /**
    * PEDIDO: Método Sets pára este campo.
    */
  public void setPedido(String PARAM) {
    pedido = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ordem_compra = null;
    rep_cdgo = null;
    rep_rzao = null;
    cliente = null;
    sequencial = null;
    dsp_cliente = null;
    grupo_economico = null;
    dsp_grupo = null;
    lin_cdgo = null;
    pedido = null;
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
      if (!com.egen.util.text.Validate.isNull(rep_cdgo) || (valida)) {
        valida = true;
      }
      if (!com.egen.util.text.Validate.isNull(pedido) || (valida)) {
        valida = true;
      }
      if (!valida) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.group","","",""));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
