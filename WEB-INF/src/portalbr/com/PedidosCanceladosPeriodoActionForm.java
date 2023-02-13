package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/10/2006 17:39:40
 * Last Modify Date 24/07/2021 09:49:13
 */

public class PedidosCanceladosPeriodoActionForm extends org.apache.struts.action.ActionForm
{
  public String reg;
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String especie;
  public String dt_entrega_inicio;
  public String dt_entrega_final;
  public String dt_cancelamento_inicio;
  public String dt_cancelamento_final;
  public String dt_digitacao_inicio;
  public String dt_digitacao_final;
  public String lin_cdgo;
  public String lin_nome;
  public String motivo_cancelamento;
  public String cli_cdgo;
  public String cli_rzao;
  public String fil_filial;
  public String fil_razsoc;
  public String desconsidera_recolocados;
  public String somente_programados;
  public String resumo_grupo_cliente;
  public String desconsiderar_amostra;
  public String tipo_pedido;
  public String tipo_mercado;
  public String origem_pedido;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public PedidosCanceladosPeriodoActionForm() {
  }
  /**
    * REG: Method to get the field value.
    */
  public String getReg() {
    return reg;
  }
  /**
    * REG: Method to set the field value.
    */
  public void setReg(String PARAM) {
    reg = PARAM;
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
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_regional != null && codigo_regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = {{"nome_regional",null}};
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(codigo_regional)} };
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
        j = null;
      }
    }
    return nome_regional;
  }

  public String[][] getNome_regional_Ajax(PedidosCanceladosPeriodoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_regional() != null && PARAM.getCodigo_regional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getCodigo_regional()} };
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
        j = null;
      }
    }
    return list;
  }
  /**
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * REP_RZAO: Method to get the field value.
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = {{"rep_rzao",null}};
        Object[][] where = { {"rep_cdgo","like",rep_cdgo} };
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
        j = null;
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(PedidosCanceladosPeriodoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()} };
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
        j = null;
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * ESPECIE: Method to get the field value.
    */
  public String getEspecie() {
    return especie;
  }
  /**
    * ESPECIE: Method to set the field value.
    */
  public void setEspecie(String PARAM) {
    especie = PARAM;
  }
  Vector especieList = new Vector(10, 1);
  public java.util.Vector getEspecieList() {
    if (especieList == null || especieList.size() == 0) {
      especieList.addElement("T");
      especieLabelList.addElement("Todos");
      especieList.addElement("N");
      especieLabelList.addElement("Normal");
      especieList.addElement("F");
      especieLabelList.addElement("Feira");
      especieList.addElement("A");
      especieLabelList.addElement("Amostra");
      especieList.addElement("E");
      especieLabelList.addElement("Pedidão");
      especieList.addElement("P");
      especieLabelList.addElement("Ponta Estoque");
      especieList.addElement("D");
      especieLabelList.addElement("Pedidão Estoque");
      especieList.addElement("L");
      especieLabelList.addElement("Loja");
      especieList.addElement("R");
      especieLabelList.addElement("Refaturado");
      especieList.addElement("C");
      especieLabelList.addElement("Recolocado");
      especieList.addElement("X");
      especieLabelList.addElement("Importação");
      especieList.addElement("O");
      especieLabelList.addElement("Reposição");
    }
    java.util.Vector list = especieList;
    return list;
  }
  java.util.Vector especieLabelList = new Vector(10, 1);
  public java.util.Vector getEspecieLabelList() {
    java.util.Vector list = especieLabelList;
    return list;
  }
  /**
    * DT_ENTREGA_INICIO: Method to get the field value.
    */
  public String getDt_entrega_inicio() {
    return dt_entrega_inicio;
  }
  /**
    * DT_ENTREGA_INICIO: Method to set the field value.
    */
  public void setDt_entrega_inicio(String PARAM) {
    dt_entrega_inicio = PARAM;
  }
  /**
    * DT_ENTREGA_FINAL: Method to get the field value.
    */
  public String getDt_entrega_final() {
    return dt_entrega_final;
  }
  /**
    * DT_ENTREGA_FINAL: Method to set the field value.
    */
  public void setDt_entrega_final(String PARAM) {
    dt_entrega_final = PARAM;
  }
  /**
    * DT_CANCELAMENTO_INICIO: Method to get the field value.
    */
  public String getDt_cancelamento_inicio() {
    return dt_cancelamento_inicio;
  }
  /**
    * DT_CANCELAMENTO_INICIO: Method to set the field value.
    */
  public void setDt_cancelamento_inicio(String PARAM) {
    dt_cancelamento_inicio = PARAM;
  }
  /**
    * DT_CANCELAMENTO_FINAL: Method to get the field value.
    */
  public String getDt_cancelamento_final() {
    return dt_cancelamento_final;
  }
  /**
    * DT_CANCELAMENTO_FINAL: Method to set the field value.
    */
  public void setDt_cancelamento_final(String PARAM) {
    dt_cancelamento_final = PARAM;
  }
  /**
    * DT_DIGITACAO_INICIO: Method to get the field value.
    */
  public String getDt_digitacao_inicio() {
    return dt_digitacao_inicio;
  }
  /**
    * DT_DIGITACAO_INICIO: Method to set the field value.
    */
  public void setDt_digitacao_inicio(String PARAM) {
    dt_digitacao_inicio = PARAM;
  }
  /**
    * DT_DIGITACAO_FINAL: Method to get the field value.
    */
  public String getDt_digitacao_final() {
    return dt_digitacao_final;
  }
  /**
    * DT_DIGITACAO_FINAL: Method to set the field value.
    */
  public void setDt_digitacao_final(String PARAM) {
    dt_digitacao_final = PARAM;
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
    * LIN_NOME: Method to get the field value.
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

  public String[][] getLin_nome_Ajax(PedidosCanceladosPeriodoActionForm PARAM) {
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
    * LIN_NOME: Method to set the field value.
    */
  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * MOTIVO_CANCELAMENTO: Method to get the field value.
    */
  public String getMotivo_cancelamento() {
    return motivo_cancelamento;
  }
  /**
    * MOTIVO_CANCELAMENTO: Method to set the field value.
    */
  public void setMotivo_cancelamento(String PARAM) {
    motivo_cancelamento = PARAM;
  }
  private Vector motivo_cancelamentoList = new Vector(10, 10);
  public void setMotivo_cancelamentoList(java.util.Vector VECTOR) {
    motivo_cancelamentoList = VECTOR;
  }
  public java.util.Vector getMotivo_cancelamentoList() {
    motivo_cancelamentoList = new Vector(10, 10);
    motivo_cancelamentoLabelList = new Vector(10, 10);
    motivo_cancelamentoList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    motivo_cancelamentoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Tipos_situacoes db_object = new Tipos_situacoes();
      String[][] select = {{"codigo_situacao", null},{"descricao_situacao", null}};
      Object[][] where = null;
      String[] order = {"codigo_situacao"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Tipos_situacoes) results.elementAt(i);
        motivo_cancelamentoList.addElement(""+db_object.getCodigo_situacao());
        motivo_cancelamentoLabelList.addElement(db_object.getCodigo_situacao() + " - "+db_object.getDescricao_situacao());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "PedidosCanceladosPeriodo.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return motivo_cancelamentoList;
  }
  private java.util.Vector motivo_cancelamentoLabelList = new Vector(10, 10);
  public void setMotivo_cancelamentoLabelList(java.util.Vector VECTOR) {
    motivo_cancelamentoLabelList = VECTOR;
  }
  public java.util.Vector getMotivo_cancelamentoLabelList() {
    return motivo_cancelamentoLabelList;
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
    * CLI_RZAO: Method to get the field value.
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

  public String[][] getCli_rzao_Ajax(PedidosCanceladosPeriodoActionForm PARAM) {
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
    * CLI_RZAO: Method to set the field value.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * FIL_FILIAL: Method to get the field value.
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Method to set the field value.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * FIL_RAZSOC: Method to get the field value.
    */
  public String getFil_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fil_filial != null && fil_filial.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = { {"fil_razsoc",null} };
        Object[][] where = { {"fil_filial","like",fil_filial}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          fil_razsoc = (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"";
        } else {
          fil_razsoc = "";
        }
      }
    } catch (Exception e) {
      fil_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fil_razsoc;
  }

  public String[][] getFil_razsoc_Ajax(PedidosCanceladosPeriodoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          list[0] = new String[]{"fil_razsoc", (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":""};
        } else {
          list[0] = new String[]{"fil_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fil_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FIL_RAZSOC: Method to set the field value.
    */
  public void setFil_razsoc(String PARAM) {
    fil_razsoc = PARAM;
  }
  /**
    * DESCONSIDERA_RECOLOCADOS: Method to get the field value.
    */
  public String getDesconsidera_recolocados() {
    return desconsidera_recolocados;
  }
  /**
    * DESCONSIDERA_RECOLOCADOS: Method to set the field value.
    */
  public void setDesconsidera_recolocados(String PARAM) {
    desconsidera_recolocados = PARAM;
  }
  Vector desconsidera_recolocadosList = new Vector(10, 1);
  public java.util.Vector getDesconsidera_recolocadosList() {
    if (desconsidera_recolocadosList == null || desconsidera_recolocadosList.size() == 0) {
      desconsidera_recolocadosList.addElement("N");
      desconsidera_recolocadosLabelList.addElement("Não");
      desconsidera_recolocadosList.addElement("S");
      desconsidera_recolocadosLabelList.addElement("Sim");
    }
    java.util.Vector list = desconsidera_recolocadosList;
    return list;
  }
  java.util.Vector desconsidera_recolocadosLabelList = new Vector(10, 1);
  public java.util.Vector getDesconsidera_recolocadosLabelList() {
    java.util.Vector list = desconsidera_recolocadosLabelList;
    return list;
  }
  /**
    * SOMENTE_PROGRAMADOS: Method to get the field value.
    */
  public String getSomente_programados() {
    return somente_programados;
  }
  /**
    * SOMENTE_PROGRAMADOS: Method to set the field value.
    */
  public void setSomente_programados(String PARAM) {
    somente_programados = PARAM;
  }
  Vector somente_programadosList = new Vector(10, 1);
  public java.util.Vector getSomente_programadosList() {
    if (somente_programadosList == null || somente_programadosList.size() == 0) {
      somente_programadosList.addElement("N");
      somente_programadosLabelList.addElement("Não");
      somente_programadosList.addElement("S");
      somente_programadosLabelList.addElement("Sim");
    }
    java.util.Vector list = somente_programadosList;
    return list;
  }
  java.util.Vector somente_programadosLabelList = new Vector(10, 1);
  public java.util.Vector getSomente_programadosLabelList() {
    java.util.Vector list = somente_programadosLabelList;
    return list;
  }
  /**
    * RESUMO_GRUPO_CLIENTE: Method to get the field value.
    */
  public String getResumo_grupo_cliente() {
    return resumo_grupo_cliente;
  }
  /**
    * RESUMO_GRUPO_CLIENTE: Method to set the field value.
    */
  public void setResumo_grupo_cliente(String PARAM) {
    resumo_grupo_cliente = PARAM;
  }
  Vector resumo_grupo_clienteList = new Vector(10, 1);
  public java.util.Vector getResumo_grupo_clienteList() {
    if (resumo_grupo_clienteList == null || resumo_grupo_clienteList.size() == 0) {
      resumo_grupo_clienteList.addElement("N");
      resumo_grupo_clienteLabelList.addElement("Não");
      resumo_grupo_clienteList.addElement("S");
      resumo_grupo_clienteLabelList.addElement("Sim");
    }
    java.util.Vector list = resumo_grupo_clienteList;
    return list;
  }
  java.util.Vector resumo_grupo_clienteLabelList = new Vector(10, 1);
  public java.util.Vector getResumo_grupo_clienteLabelList() {
    java.util.Vector list = resumo_grupo_clienteLabelList;
    return list;
  }
  /**
    * DESCONSIDERAR_AMOSTRA: Method to get the field value.
    */
  public String getDesconsiderar_amostra() {
    return desconsiderar_amostra;
  }
  /**
    * DESCONSIDERAR_AMOSTRA: Method to set the field value.
    */
  public void setDesconsiderar_amostra(String PARAM) {
    desconsiderar_amostra = PARAM;
  }
  Vector desconsiderar_amostraList = new Vector(10, 1);
  public java.util.Vector getDesconsiderar_amostraList() {
    if (desconsiderar_amostraList == null || desconsiderar_amostraList.size() == 0) {
      desconsiderar_amostraList.addElement("N");
      desconsiderar_amostraLabelList.addElement("Não");
      desconsiderar_amostraList.addElement("S");
      desconsiderar_amostraLabelList.addElement("Sim");
    }
    java.util.Vector list = desconsiderar_amostraList;
    return list;
  }
  java.util.Vector desconsiderar_amostraLabelList = new Vector(10, 1);
  public java.util.Vector getDesconsiderar_amostraLabelList() {
    java.util.Vector list = desconsiderar_amostraLabelList;
    return list;
  }
  /**
    * TIPO_PEDIDO: Method to get the field value.
    */
  public String getTipo_pedido() {
    return tipo_pedido;
  }
  /**
    * TIPO_PEDIDO: Method to set the field value.
    */
  public void setTipo_pedido(String PARAM) {
    tipo_pedido = PARAM;
  }
  Vector tipo_pedidoList = new Vector(10, 1);
  public java.util.Vector getTipo_pedidoList() {
    if (tipo_pedidoList == null || tipo_pedidoList.size() == 0) {
      tipo_pedidoList.addElement("TODOS");
      tipo_pedidoLabelList.addElement("Todos");
      tipo_pedidoList.addElement("PG");
      tipo_pedidoLabelList.addElement("PG");
      tipo_pedidoList.addElement("PP");
      tipo_pedidoLabelList.addElement("PP");
      tipo_pedidoList.addElement("EX");
      tipo_pedidoLabelList.addElement("EX");
      tipo_pedidoList.addElement("PE");
      tipo_pedidoLabelList.addElement("PE");
    }
    java.util.Vector list = tipo_pedidoList;
    return list;
  }
  java.util.Vector tipo_pedidoLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_pedidoLabelList() {
    java.util.Vector list = tipo_pedidoLabelList;
    return list;
  }
  /**
    * TIPO_MERCADO: Method to get the field value.
    */
  public String getTipo_mercado() {
    return tipo_mercado;
  }
  /**
    * TIPO_MERCADO: Method to set the field value.
    */
  public void setTipo_mercado(String PARAM) {
    tipo_mercado = PARAM;
  }
  Vector tipo_mercadoList = new Vector(10, 1);
  public java.util.Vector getTipo_mercadoList() {
    if (tipo_mercadoList == null || tipo_mercadoList.size() == 0) {
      tipo_mercadoList.addElement("TODOS");
      tipo_mercadoLabelList.addElement("Todos");
      tipo_mercadoList.addElement("MI");
      tipo_mercadoLabelList.addElement("MI");
      tipo_mercadoList.addElement("ME");
      tipo_mercadoLabelList.addElement("ME");
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
    * ORIGEM_PEDIDO: Method to get the field value.
    */
  public String getOrigem_pedido() {
    return origem_pedido;
  }
  /**
    * ORIGEM_PEDIDO: Method to set the field value.
    */
  public void setOrigem_pedido(String PARAM) {
    origem_pedido = PARAM;
  }
  Vector origem_pedidoList = new Vector(10, 1);
  public java.util.Vector getOrigem_pedidoList() {
    if (origem_pedidoList == null || origem_pedidoList.size() == 0) {
      origem_pedidoList.addElement("TODOS");
      origem_pedidoLabelList.addElement("Todos");
      origem_pedidoList.addElement("CATALOGO");
      origem_pedidoLabelList.addElement("Catálogo");
      origem_pedidoList.addElement("COMPRA RAPIDA");
      origem_pedidoLabelList.addElement("Compra Rápida");
      origem_pedidoList.addElement("ESTRATEGICO");
      origem_pedidoLabelList.addElement("Estratégico");
      origem_pedidoList.addElement("INTERNO");
      origem_pedidoLabelList.addElement("Interno");
      origem_pedidoList.addElement("LOTE ESTRATEGICO");
      origem_pedidoLabelList.addElement("Lote Estratégico");
    }
    java.util.Vector list = origem_pedidoList;
    return list;
  }
  java.util.Vector origem_pedidoLabelList = new Vector(10, 1);
  public java.util.Vector getOrigem_pedidoLabelList() {
    java.util.Vector list = origem_pedidoLabelList;
    return list;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to get the field value.
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to set the field value.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Method to get the field value.
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Method to set the field value.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    reg = null;
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    especie = null;
    dt_entrega_inicio = null;
    dt_entrega_final = null;
    dt_cancelamento_inicio = null;
    dt_cancelamento_final = null;
    dt_digitacao_inicio = null;
    dt_digitacao_final = null;
    lin_cdgo = null;
    lin_nome = null;
    motivo_cancelamento = null;
    cli_cdgo = null;
    cli_rzao = null;
    fil_filial = null;
    fil_razsoc = null;
    desconsidera_recolocados = null;
    somente_programados = null;
    resumo_grupo_cliente = null;
    desconsiderar_amostra = null;
    tipo_pedido = null;
    tipo_mercado = null;
    origem_pedido = null;
    abre_automaticamente = null;
    mensagem = null;
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
      if (!com.egen.util.text.Validate.isNumber(codigo_regional)) {
        errors.add("codigo_regional", new ActionMessage("error.validate.number","Regional","codigo_regional","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(rep_cdgo)) {
        errors.add("rep_cdgo", new ActionMessage("error.validate.number","Representante","rep_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_cancelamento_inicio)) {
        errors.add("dt_cancelamento_inicio", new ActionMessage("error.validate.date","Período de Cancelamento","dt_cancelamento_inicio","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_cancelamento_final)) {
        errors.add("dt_cancelamento_final", new ActionMessage("error.validate.date","a","dt_cancelamento_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
