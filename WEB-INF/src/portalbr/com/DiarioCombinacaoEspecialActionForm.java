package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2015 16:03:13
 * Last Modify Date 22/06/2015 13:35:10
 */

public class DiarioCombinacaoEspecialActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String data_solicitacao;
  public String data_solicitacao_final;
  public String codigo_marca;
  public String lin_cdgo;
  public String lin_nome;
  public String situacao_solicitacao;
  public String cli_cdgo;
  public String cli_rzao;
  public String gre_grupo;
  public String gre_descricao;
  public String tipo_solicitacao;
  private boolean valida = false;
  public DiarioCombinacaoEspecialActionForm() {
  }
  /**
    * ID_SOLICITACAO: Método Gets para este campo
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Método Sets pára este campo.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * DATA_SOLICITACAO: Método Gets para este campo
    */
  public String getData_solicitacao() {
    return data_solicitacao;
  }
  /**
    * DATA_SOLICITACAO: Método Sets pára este campo.
    */
  public void setData_solicitacao(String PARAM) {
    data_solicitacao = PARAM;
  }
  /**
    * DATA_SOLICITACAO_FINAL: Método Gets para este campo
    */
  public String getData_solicitacao_final() {
    return data_solicitacao_final;
  }
  /**
    * DATA_SOLICITACAO_FINAL: Método Sets pára este campo.
    */
  public void setData_solicitacao_final(String PARAM) {
    data_solicitacao_final = PARAM;
  }
  /**
    * CODIGO_MARCA: Método Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Método Sets pára este campo.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  private Vector codigo_marcaList = new Vector(10, 10);
  public void setCodigo_marcaList(java.util.Vector VECTOR) {
    codigo_marcaList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaList() {
    if (codigo_marcaList == null || codigo_marcaList.size() == 0) {
      codigo_marcaList = new Vector(10, 10);
      codigo_marcaLabelList = new Vector(10, 10);
      codigo_marcaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      codigo_marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_marcas db_object = new Jw_marcas();
        String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
        Object[][] where = null;
        String[] order = {"descricao_marca"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_marcas) results.elementAt(i);
          codigo_marcaList.addElement(""+db_object.getCodigo_marca());
          codigo_marcaLabelList.addElement(""+db_object.getDescricao_marca());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "DiarioCombinacaoEspecial.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return codigo_marcaList;
  }
  private java.util.Vector codigo_marcaLabelList = new Vector(10, 10);
  public void setCodigo_marcaLabelList(java.util.Vector VECTOR) {
    codigo_marcaLabelList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaLabelList() {
    return codigo_marcaLabelList;
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
    * LIN_NOME: Método Gets para este campo
    */
  public String getLin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        String[][] select = { {"lin_nome",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          lin_nome = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
        } else {
          lin_nome = "";
        }
      }
    } catch (Exception e) {
      lin_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(DiarioCombinacaoEspecialActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          list[0] = new String[]{"lin_nome", (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":""};
        } else {
          list[0] = new String[]{"lin_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIN_NOME: Método Sets pára este campo.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * SITUACAO_SOLICITACAO: Método Gets para este campo
    */
  public String getSituacao_solicitacao() {
    return situacao_solicitacao;
  }
  /**
    * SITUACAO_SOLICITACAO: Método Sets pára este campo.
    */
  public void setSituacao_solicitacao(String PARAM) {
    situacao_solicitacao = PARAM;
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

  public String[][] getCli_rzao_Ajax(DiarioCombinacaoEspecialActionForm PARAM) {
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
        String[][] select = { {"gre_descricao",null} };
        Object[][] where = { {"gre_grupo","=",com.egen.util.text.FormatNumber.toInt(gre_grupo)}, };
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
      }
    }
    return gre_descricao;
  }

  public String[][] getGre_descricao_Ajax(DiarioCombinacaoEspecialActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGre_grupo() != null && PARAM.getGre_grupo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        Object[][] where = { {"gre_grupo","like",PARAM.getGre_grupo()}, };
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
    * TIPO_SOLICITACAO: Método Gets para este campo
    */
  public String getTipo_solicitacao() {
    return tipo_solicitacao;
  }
  /**
    * TIPO_SOLICITACAO: Método Sets pára este campo.
    */
  public void setTipo_solicitacao(String PARAM) {
    tipo_solicitacao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    data_solicitacao = null;
    data_solicitacao_final = null;
    codigo_marca = null;
    lin_cdgo = null;
    lin_nome = null;
    situacao_solicitacao = null;
    cli_cdgo = null;
    cli_rzao = null;
    gre_grupo = null;
    gre_descricao = null;
    tipo_solicitacao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
