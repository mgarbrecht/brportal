package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/08/2006 15:03:12
 * Last Modify Date 31/10/2019 16:45:50
 */

public class ClientesGruposEconomicosActionForm extends org.apache.struts.action.ActionForm
{
  public String gre_grupo;
  public String gre_descricao;
  public String cli_cdgo;
  public String cli_rzao;
  public String cli_nome;
  public String razao_social;
  public String descricao_grupo;
  public String situacao_cliente;
  public String situacao_cliente_grupo;
  public String situacao_cliente_representante;
  public String tipo;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public ClientesGruposEconomicosActionForm() {
  }
  /**
    * GRE_GRUPO: Método Gets para este campo
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Método Sets pára este campo.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
  }
  /**
    * GRE_DESCRICAO: Método Gets para este campo
    */
  public String getGre_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (gre_grupo != null && gre_grupo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        String[][] select = {{"gre_descricao",null}};
        Object[][] where = { {"gre_grupo","=",com.egen.util.text.FormatNumber.toInt(gre_grupo)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Grupo_economico) results.elementAt(0);
          gre_descricao = (db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":"";
        } else {
          gre_descricao = "";
        }
      }
    } catch (Exception e) {
      gre_descricao = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return gre_descricao;
  }

  public String[][] getGre_descricao_Ajax(ClientesGruposEconomicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGre_grupo() != null && PARAM.getGre_grupo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        Object[][] where = { {"gre_grupo","like",PARAM.getGre_grupo()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Grupo_economico) results.elementAt(0);
          list[0] = new String[]{"gre_descricao", (db_object.getGre_descricao() != null) ? db_object.getGre_descricao() + "":""};
        } else {
          list[0] = new String[]{"gre_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"gre_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * GRE_DESCRICAO: Método Sets pára este campo.
    */
  public void setGre_descricao(String PARAM) {
    gre_descricao = PARAM;
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
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = {{"cli_rzao",null}};
        Object[][] where = {{"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)}};
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
        j = null;
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(ClientesGruposEconomicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = {{"cli_cdgo","=",PARAM.getCli_cdgo()}};
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
        j = null;
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
    * CLI_NOME: Método Gets para este campo
    */
  public String getCli_nome() {
    return cli_nome;
  }
  /**
    * CLI_NOME: Método Sets pára este campo.
    */
  public void setCli_nome(String PARAM) {
    cli_nome = PARAM;
  }
  /**
    * RAZAO_SOCIAL: Método Gets para este campo
    */
  public String getRazao_social() {
    return razao_social;
  }
  /**
    * RAZAO_SOCIAL: Método Sets pára este campo.
    */
  public void setRazao_social(String PARAM) {
    razao_social = PARAM;
  }
  /**
    * DESCRICAO_GRUPO: Método Gets para este campo
    */
  public String getDescricao_grupo() {
    return descricao_grupo;
  }
  /**
    * DESCRICAO_GRUPO: Método Sets pára este campo.
    */
  public void setDescricao_grupo(String PARAM) {
    descricao_grupo = PARAM;
  }
  /**
    * SITUACAO_CLIENTE: Método Gets para este campo
    */
  public String getSituacao_cliente() {
    return situacao_cliente;
  }
  /**
    * SITUACAO_CLIENTE: Método Sets pára este campo.
    */
  public void setSituacao_cliente(String PARAM) {
    situacao_cliente = PARAM;
  }
  Vector situacao_clienteList = new Vector(10, 1);
  public java.util.Vector getSituacao_clienteList() {
    if (situacao_clienteList == null || situacao_clienteList.size() == 0) {
      situacao_clienteList.addElement("");
      situacao_clienteLabelList.addElement("Todos");
      situacao_clienteList.addElement("A");
      situacao_clienteLabelList.addElement("Ativos");
      situacao_clienteList.addElement("I");
      situacao_clienteLabelList.addElement("Inativos");
    }
    java.util.Vector list = situacao_clienteList;
    return list;
  }
  java.util.Vector situacao_clienteLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_clienteLabelList() {
    java.util.Vector list = situacao_clienteLabelList;
    return list;
  }
  /**
    * SITUACAO_CLIENTE_GRUPO: Método Gets para este campo
    */
  public String getSituacao_cliente_grupo() {
    return situacao_cliente_grupo;
  }
  /**
    * SITUACAO_CLIENTE_GRUPO: Método Sets pára este campo.
    */
  public void setSituacao_cliente_grupo(String PARAM) {
    situacao_cliente_grupo = PARAM;
  }
  Vector situacao_cliente_grupoList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_grupoList() {
    if (situacao_cliente_grupoList == null || situacao_cliente_grupoList.size() == 0) {
      situacao_cliente_grupoList.addElement("");
      situacao_cliente_grupoLabelList.addElement("Todos");
      situacao_cliente_grupoList.addElement("A");
      situacao_cliente_grupoLabelList.addElement("Ativos");
      situacao_cliente_grupoList.addElement("I");
      situacao_cliente_grupoLabelList.addElement("Inativos");
    }
    java.util.Vector list = situacao_cliente_grupoList;
    return list;
  }
  java.util.Vector situacao_cliente_grupoLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_grupoLabelList() {
    java.util.Vector list = situacao_cliente_grupoLabelList;
    return list;
  }
  /**
    * SITUACAO_CLIENTE_REPRESENTANTE: Método Gets para este campo
    */
  public String getSituacao_cliente_representante() {
    return situacao_cliente_representante;
  }
  /**
    * SITUACAO_CLIENTE_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setSituacao_cliente_representante(String PARAM) {
    situacao_cliente_representante = PARAM;
  }
  Vector situacao_cliente_representanteList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_representanteList() {
    if (situacao_cliente_representanteList == null || situacao_cliente_representanteList.size() == 0) {
      situacao_cliente_representanteList.addElement("");
      situacao_cliente_representanteLabelList.addElement("Todos");
      situacao_cliente_representanteList.addElement("A");
      situacao_cliente_representanteLabelList.addElement("Ativos");
      situacao_cliente_representanteList.addElement("I");
      situacao_cliente_representanteLabelList.addElement("Inativos");
    }
    java.util.Vector list = situacao_cliente_representanteList;
    return list;
  }
  java.util.Vector situacao_cliente_representanteLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_representanteLabelList() {
    java.util.Vector list = situacao_cliente_representanteLabelList;
    return list;
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
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Método Gets para este campo
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Método Sets pára este campo.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Método Gets para este campo
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Método Sets pára este campo.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gre_grupo = null;
    gre_descricao = null;
    cli_cdgo = null;
    cli_rzao = null;
    cli_nome = null;
    razao_social = null;
    descricao_grupo = null;
    situacao_cliente = null;
    situacao_cliente_grupo = null;
    situacao_cliente_representante = null;
    tipo = null;
    abre_automaticamente = null;
    mensagem = null;
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
      if (!com.egen.util.text.Validate.isNumber(gre_grupo)) {
        errors.add("gre_grupo", new ActionMessage("error.validate.number","Grupo","gre_grupo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(cli_cdgo)) {
        errors.add("cli_cdgo", new ActionMessage("error.validate.number","Cliente","cli_cdgo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
