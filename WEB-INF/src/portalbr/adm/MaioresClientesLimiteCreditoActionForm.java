package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/08/2010 08:27:56
 * Last Modify Date 22/06/2015 14:31:11
 */

public class MaioresClientesLimiteCreditoActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String gre_grupo;
  public String gre_descricao;
  public String cli_cdgo;
  public String cli_rzao;
  public String descricao_cidade1;
  public String descricao_cidade2;
  public String descricao_cidade3;
  public String descricao_cidade4;
  public String descricao_cidade5;
  public String codigo_cidade1;
  public String codigo_cidade2;
  public String codigo_cidade3;
  public String codigo_cidade4;
  public String codigo_cidade5;
  public String tipo_mercado;
  public String quantidade;
  public String meses;
  public String ordenacao;
  private boolean valida = false;
  public MaioresClientesLimiteCreditoActionForm() {
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
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_regional != null && codigo_regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(codigo_regional)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          nome_regional = (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":"";
        } else {
          nome_regional = "";
        }
      }
    } catch (Exception e) {
      nome_regional = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return nome_regional;
  }

  public String[][] getNome_regional_Ajax(MaioresClientesLimiteCreditoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_regional() != null && PARAM.getCodigo_regional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getCodigo_regional()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Regionais_vendas) results.elementAt(0);
          list[0] = new String[]{"nome_regional", (db_object.getNome_regional() != null) ? db_object.getNome_regional() + "":""};
        } else {
          list[0] = new String[]{"nome_regional", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nome_regional", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * NOME_REGIONAL: Método Sets pára este campo.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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

  public String[][] getRep_rzao_Ajax(MaioresClientesLimiteCreditoActionForm PARAM) {
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

  public String[][] getGre_descricao_Ajax(MaioresClientesLimiteCreditoActionForm PARAM) {
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

  public String[][] getCli_rzao_Ajax(MaioresClientesLimiteCreditoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=",PARAM.getCli_cdgo()}, };
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
    * DESCRICAO_CIDADE1: Método Gets para este campo
    */
  public String getDescricao_cidade1() {
    return descricao_cidade1;
  }
  /**
    * DESCRICAO_CIDADE1: Método Sets pára este campo.
    */
  public void setDescricao_cidade1(String PARAM) {
    descricao_cidade1 = PARAM;
  }
  /**
    * DESCRICAO_CIDADE2: Método Gets para este campo
    */
  public String getDescricao_cidade2() {
    return descricao_cidade2;
  }
  /**
    * DESCRICAO_CIDADE2: Método Sets pára este campo.
    */
  public void setDescricao_cidade2(String PARAM) {
    descricao_cidade2 = PARAM;
  }
  /**
    * DESCRICAO_CIDADE3: Método Gets para este campo
    */
  public String getDescricao_cidade3() {
    return descricao_cidade3;
  }
  /**
    * DESCRICAO_CIDADE3: Método Sets pára este campo.
    */
  public void setDescricao_cidade3(String PARAM) {
    descricao_cidade3 = PARAM;
  }
  /**
    * DESCRICAO_CIDADE4: Método Gets para este campo
    */
  public String getDescricao_cidade4() {
    return descricao_cidade4;
  }
  /**
    * DESCRICAO_CIDADE4: Método Sets pára este campo.
    */
  public void setDescricao_cidade4(String PARAM) {
    descricao_cidade4 = PARAM;
  }
  /**
    * DESCRICAO_CIDADE5: Método Gets para este campo
    */
  public String getDescricao_cidade5() {
    return descricao_cidade5;
  }
  /**
    * DESCRICAO_CIDADE5: Método Sets pára este campo.
    */
  public void setDescricao_cidade5(String PARAM) {
    descricao_cidade5 = PARAM;
  }
  /**
    * CODIGO_CIDADE1: Método Gets para este campo
    */
  public String getCodigo_cidade1() {
    return codigo_cidade1;
  }
  /**
    * CODIGO_CIDADE1: Método Sets pára este campo.
    */
  public void setCodigo_cidade1(String PARAM) {
    codigo_cidade1 = PARAM;
  }
  /**
    * CODIGO_CIDADE2: Método Gets para este campo
    */
  public String getCodigo_cidade2() {
    return codigo_cidade2;
  }
  /**
    * CODIGO_CIDADE2: Método Sets pára este campo.
    */
  public void setCodigo_cidade2(String PARAM) {
    codigo_cidade2 = PARAM;
  }
  /**
    * CODIGO_CIDADE3: Método Gets para este campo
    */
  public String getCodigo_cidade3() {
    return codigo_cidade3;
  }
  /**
    * CODIGO_CIDADE3: Método Sets pára este campo.
    */
  public void setCodigo_cidade3(String PARAM) {
    codigo_cidade3 = PARAM;
  }
  /**
    * CODIGO_CIDADE4: Método Gets para este campo
    */
  public String getCodigo_cidade4() {
    return codigo_cidade4;
  }
  /**
    * CODIGO_CIDADE4: Método Sets pára este campo.
    */
  public void setCodigo_cidade4(String PARAM) {
    codigo_cidade4 = PARAM;
  }
  /**
    * CODIGO_CIDADE5: Método Gets para este campo
    */
  public String getCodigo_cidade5() {
    return codigo_cidade5;
  }
  /**
    * CODIGO_CIDADE5: Método Sets pára este campo.
    */
  public void setCodigo_cidade5(String PARAM) {
    codigo_cidade5 = PARAM;
  }
  /**
    * TIPO_MERCADO: Método Gets para este campo
    */
  public String getTipo_mercado() {
    return tipo_mercado;
  }
  /**
    * TIPO_MERCADO: Método Sets pára este campo.
    */
  public void setTipo_mercado(String PARAM) {
    tipo_mercado = PARAM;
  }
  Vector tipo_mercadoList = new Vector(10, 1);
  public java.util.Vector getTipo_mercadoList() {
    if (tipo_mercadoList == null || tipo_mercadoList.size() == 0) {
      tipo_mercadoList.addElement("null");
      tipo_mercadoLabelList.addElement("Todos");
      tipo_mercadoList.addElement("'MI'");
      tipo_mercadoLabelList.addElement("Mercado Interno");
      tipo_mercadoList.addElement("'EX'");
      tipo_mercadoLabelList.addElement("Mercado Externo");
    }
    java.util.Vector list = tipo_mercadoList;
    return list;
  }
  java.util.Vector tipo_mercadoLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_mercadoLabelList() {
    java.util.Vector list = tipo_mercadoLabelList;
    return list;
  }
  /**
    * QUANTIDADE: Método Gets para este campo
    */
  public String getQuantidade() {
    return quantidade;
  }
  /**
    * QUANTIDADE: Método Sets pára este campo.
    */
  public void setQuantidade(String PARAM) {
    quantidade = PARAM;
  }
  Vector quantidadeList = new Vector(10, 1);
  public java.util.Vector getQuantidadeList() {
    if (quantidadeList == null || quantidadeList.size() == 0) {
      quantidadeList.addElement("10");
      quantidadeLabelList.addElement("10");
      quantidadeList.addElement("50");
      quantidadeLabelList.addElement("50");
      quantidadeList.addElement("100");
      quantidadeLabelList.addElement("100");
    }
    java.util.Vector list = quantidadeList;
    return list;
  }
  java.util.Vector quantidadeLabelList = new Vector(10, 1);
  public java.util.Vector getQuantidadeLabelList() {
    java.util.Vector list = quantidadeLabelList;
    return list;
  }
  /**
    * MESES: Método Gets para este campo
    */
  public String getMeses() {
    return meses;
  }
  /**
    * MESES: Método Sets pára este campo.
    */
  public void setMeses(String PARAM) {
    meses = PARAM;
  }
  /**
    * ORDENACAO: Método Gets para este campo
    */
  public String getOrdenacao() {
    return ordenacao;
  }
  /**
    * ORDENACAO: Método Sets pára este campo.
    */
  public void setOrdenacao(String PARAM) {
    ordenacao = PARAM;
  }
  Vector ordenacaoList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoList() {
    if (ordenacaoList == null || ordenacaoList.size() == 0) {
      ordenacaoList.addElement("l");
      ordenacaoLabelList.addElement("Limite");
      ordenacaoList.addElement("s");
      ordenacaoLabelList.addElement("Saldo");
    }
    java.util.Vector list = ordenacaoList;
    return list;
  }
  java.util.Vector ordenacaoLabelList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoLabelList() {
    java.util.Vector list = ordenacaoLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    gre_grupo = null;
    gre_descricao = null;
    cli_cdgo = null;
    cli_rzao = null;
    descricao_cidade1 = null;
    descricao_cidade2 = null;
    descricao_cidade3 = null;
    descricao_cidade4 = null;
    descricao_cidade5 = null;
    codigo_cidade1 = null;
    codigo_cidade2 = null;
    codigo_cidade3 = null;
    codigo_cidade4 = null;
    codigo_cidade5 = null;
    tipo_mercado = null;
    quantidade = null;
    meses = null;
    ordenacao = null;
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
      if (com.egen.util.text.Validate.isNull(meses)) {
        errors.add("meses", new ActionMessage("error.validate.notnull","Meses atrás","meses","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
