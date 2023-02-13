package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/02/2012 10:45:13
 * Last Modify Date 09/10/2020 11:35:37
 */

public class SolicitacaoCombinacaoEspecialActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String data_solicitacao;
  public String data_solicitacao_final;
  public String data_inicial_aprovacao;
  public String data_final_aprovacao;
  public String data_entrega_amostra;
  public String data_entrega_amostra_fim;
  public String codigo_marca;
  public String marcas;
  public String material;
  public String lin_cdgo;
  public String lin_nome;
  public String situacao_solicitacao;
  public String cli_cdgo;
  public String cli_rzao;
  public String gre_grupo;
  public String gre_descricao;
  public String rep_cdgo;
  public String rep_rzao;
  public String regional;
  public String nome_regional;
  public String tipo_mercado;
  public String tipo_solicitacao;
  public String subtipo_solicitacao_comb_espec;
  public String somente_entrada;
  public String dt_entrada_inicial;
  public String dt_entrada_final;
  public String numero_ranking;
  public String imagem;
  private boolean valida = false;
  public SolicitacaoCombinacaoEspecialActionForm() {
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
    * DATA_INICIAL_APROVACAO: Método Gets para este campo
    */
  public String getData_inicial_aprovacao() {
    return data_inicial_aprovacao;
  }
  /**
    * DATA_INICIAL_APROVACAO: Método Sets pára este campo.
    */
  public void setData_inicial_aprovacao(String PARAM) {
    data_inicial_aprovacao = PARAM;
  }
  /**
    * DATA_FINAL_APROVACAO: Método Gets para este campo
    */
  public String getData_final_aprovacao() {
    return data_final_aprovacao;
  }
  /**
    * DATA_FINAL_APROVACAO: Método Sets pára este campo.
    */
  public void setData_final_aprovacao(String PARAM) {
    data_final_aprovacao = PARAM;
  }
  /**
    * DATA_ENTREGA_AMOSTRA: Método Gets para este campo
    */
  public String getData_entrega_amostra() {
    return data_entrega_amostra;
  }
  /**
    * DATA_ENTREGA_AMOSTRA: Método Sets pára este campo.
    */
  public void setData_entrega_amostra(String PARAM) {
    data_entrega_amostra = PARAM;
  }
  /**
    * DATA_ENTREGA_AMOSTRA_FIM: Método Gets para este campo
    */
  public String getData_entrega_amostra_fim() {
    return data_entrega_amostra_fim;
  }
  /**
    * DATA_ENTREGA_AMOSTRA_FIM: Método Sets pára este campo.
    */
  public void setData_entrega_amostra_fim(String PARAM) {
    data_entrega_amostra_fim = PARAM;
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
  /**
    * MARCAS: Método Gets para este campo
    */
  public String getMarcas() {
    return marcas;
  }
  /**
    * MARCAS: Método Sets pára este campo.
    */
  public void setMarcas(String PARAM) {
    marcas = PARAM;
  }
  /**
    * MATERIAL: Método Gets para este campo
    */
  public String getMaterial() {
    return material;
  }
  /**
    * MATERIAL: Método Sets pára este campo.
    */
  public void setMaterial(String PARAM) {
    material = PARAM;
  }
  Vector materialList = new Vector(10, 1);
  public java.util.Vector getMaterialList() {
    if (materialList == null || materialList.size() == 0) {
      materialList.addElement("");
      materialLabelList.addElement("Todos");
      materialList.addElement("M");
      materialLabelList.addElement("Mix");
      materialList.addElement("D");
      materialLabelList.addElement("Desenvolvimento");
    }
    java.util.Vector list = materialList;
    return list;
  }
  java.util.Vector materialLabelList = new Vector(10, 1);
  public java.util.Vector getMaterialLabelList() {
    java.util.Vector list = materialLabelList;
    return list;
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

  public String[][] getLin_nome_Ajax(SolicitacaoCombinacaoEspecialActionForm PARAM) {
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

  public String[][] getCli_rzao_Ajax(SolicitacaoCombinacaoEspecialActionForm PARAM) {
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

  public String[][] getGre_descricao_Ajax(SolicitacaoCombinacaoEspecialActionForm PARAM) {
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

  public String[][] getRep_rzao_Ajax(SolicitacaoCombinacaoEspecialActionForm PARAM) {
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
    * REGIONAL: Método Gets para este campo
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Método Sets pára este campo.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (regional != null && regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(regional)}, };
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

  public String[][] getNome_regional_Ajax(SolicitacaoCombinacaoEspecialActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRegional() != null && PARAM.getRegional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getRegional()}, };
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
      tipo_mercadoList.addElement("T");
      tipo_mercadoLabelList.addElement("Todos");
      tipo_mercadoList.addElement("MI");
      tipo_mercadoLabelList.addElement("Mercado Interno");
      tipo_mercadoList.addElement("EX");
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
    * SUBTIPO_SOLICITACAO_COMB_ESPEC: Método Gets para este campo
    */
  public String getSubtipo_solicitacao_comb_espec() {
    return subtipo_solicitacao_comb_espec;
  }
  /**
    * SUBTIPO_SOLICITACAO_COMB_ESPEC: Método Sets pára este campo.
    */
  public void setSubtipo_solicitacao_comb_espec(String PARAM) {
    subtipo_solicitacao_comb_espec = PARAM;
  }
  /**
    * SOMENTE_ENTRADA: Método Gets para este campo
    */
  public String getSomente_entrada() {
    return somente_entrada;
  }
  /**
    * SOMENTE_ENTRADA: Método Sets pára este campo.
    */
  public void setSomente_entrada(String PARAM) {
    somente_entrada = PARAM;
  }
  Vector somente_entradaList = new Vector(10, 1);
  public java.util.Vector getSomente_entradaList() {
    if (somente_entradaList == null || somente_entradaList.size() == 0) {
      somente_entradaList.addElement("N");
      somente_entradaLabelList.addElement("Não");
      somente_entradaList.addElement("S");
      somente_entradaLabelList.addElement("Sim");
    }
    java.util.Vector list = somente_entradaList;
    return list;
  }
  java.util.Vector somente_entradaLabelList = new Vector(10, 1);
  public java.util.Vector getSomente_entradaLabelList() {
    java.util.Vector list = somente_entradaLabelList;
    return list;
  }
  /**
    * DT_ENTRADA_INICIAL: Método Gets para este campo
    */
  public String getDt_entrada_inicial() {
    return dt_entrada_inicial;
  }
  /**
    * DT_ENTRADA_INICIAL: Método Sets pára este campo.
    */
  public void setDt_entrada_inicial(String PARAM) {
    dt_entrada_inicial = PARAM;
  }
  /**
    * DT_ENTRADA_FINAL: Método Gets para este campo
    */
  public String getDt_entrada_final() {
    return dt_entrada_final;
  }
  /**
    * DT_ENTRADA_FINAL: Método Sets pára este campo.
    */
  public void setDt_entrada_final(String PARAM) {
    dt_entrada_final = PARAM;
  }
  /**
    * NUMERO_RANKING: Método Gets para este campo
    */
  public String getNumero_ranking() {
    return numero_ranking;
  }
  /**
    * NUMERO_RANKING: Método Sets pára este campo.
    */
  public void setNumero_ranking(String PARAM) {
    numero_ranking = PARAM;
  }
  /**
    * IMAGEM: Método Gets para este campo
    */
  public String getImagem() {
    return "A";
  }
  /**
    * IMAGEM: Método Sets pára este campo.
    */
  public void setImagem(String PARAM) {
     imagem = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    data_solicitacao = null;
    data_solicitacao_final = null;
    data_inicial_aprovacao = null;
    data_final_aprovacao = null;
    data_entrega_amostra = null;
    data_entrega_amostra_fim = null;
    codigo_marca = null;
    marcas = null;
    material = null;
    lin_cdgo = null;
    lin_nome = null;
    situacao_solicitacao = null;
    cli_cdgo = null;
    cli_rzao = null;
    gre_grupo = null;
    gre_descricao = null;
    rep_cdgo = null;
    rep_rzao = null;
    regional = null;
    nome_regional = null;
    tipo_mercado = null;
    tipo_solicitacao = null;
    subtipo_solicitacao_comb_espec = null;
    somente_entrada = null;
    dt_entrada_inicial = null;
    dt_entrada_final = null;
    numero_ranking = null;
    imagem = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,insert_action,", request)) {
      if (!com.egen.util.text.Validate.isNumber(regional)) {
        errors.add("regional", new ActionMessage("error.validate.number","Regional","regional","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
