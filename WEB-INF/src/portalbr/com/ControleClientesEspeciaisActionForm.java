package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/05/2011 11:44:52
 * Last Modify Date 20/03/2023 17:52:36
 */

public class ControleClientesEspeciaisActionForm extends org.apache.struts.action.ActionForm
{
  public String rep_cdgo;
  public String rep_rzao;
  public String codigo_regional;
  public String nome_regional;
  public String cli_cdgo;
  public String cli_rzao;
  public String esc_seqn;
  public String nro_normativa;
  public String descricao;
  public String gre_grupo;
  public String gre_descricao;
  public String ped_nmro;
  public String ano_fatura;
  public String numero_fatura;
  public String nf_numero;
  public String nf_serie;
  public String ped_ped_cliente;
  public String fil_filial;
  public String fil_razsoc;
  public String local_estoque;
  public String codigo_marca;
  public String especie;
  public String tipo_produto;
  public String tipo_pedido;
  public String ped_stat;
  public String tipo_mercado;
  public String dt_inicial;
  public String dt_final;
  public String dt_ent_inicial;
  public String dt_ent_final;
  public String ordem;
  public String cb_regional;
  public String cb_grupo_economico;
  public String cb_cliente;
  public String cb_representante;
  public String cb_pedido;
  public String cb_situacao;
  public String cb_tipo_pedido;
  public String cb_oc;
  public String cb_linha;
  public String cb_etiquetas;
  public String cb_obs;
  public String cb_pares;
  public String cb_rem;
  public String cb_fl_prod;
  public String cb_fl_fat;
  public String cb_digit;
  public String cb_fat_cli;
  public String cb_fat_br;
  public String cb_marca;
  public String cb_carimbo;
  public String cb_rotulos;
  public String cb_ped_amostra;
  public String cb_dt_envio;
  public String cb_agenda;
  public String cb_dezena;
  public String cb_dia;
  public String cb_dt_efetiva;
  public String cb_hora;
  public String cb_senha;
  public String cb_emissao;
  public String cb_filial;
  public String cb_nf;
  public String cb_volumes;
  public String cb_dt_inspecao;
  public String cb_dt_montagem;
  public String cb_dt_entrega_etiqueta;
  public String cb_especie;
  public String possui_dados;
  public String cb_possui_carimbo;
  public String cb_somente_etiqueta;
  public String cb_etiquetas_pendentes;
  public String cb_somente_amostra;
  public String dt_nf_inicial;
  public String dt_nf_final;
  public String cb_empenhado_completo;
  public String etiquetas;
  public String remessa;
  public String cb_portao_entrega;
  public String cb_cd_entrega;
  public String cb_dt_entrega;
  public String cb_amostra_brinde;
  public String cb_encarte;
  public String cb_prioridade_embarque;
  public String cb_dt_rec_etiqueta_filial;
  public String cb_cabide;
  public String cb_atacado;
  public String atacado;
  public String dt_agend_inicial;
  public String dt_agend_final;
  public String tra_cdgo;
  public String tra_nome;
  public String cb_etiquetas_pendentes_industrial;
  public String ite_situ;
  public String linha;
  public String cb_subtotal_grupo_economico;
  public String dt_emiss_ini;
  public String dt_emiss_fim;
  public String gerar_planilha;
  public String gerar_planilha_subtotal;
  public String dt_corte_inicial;
  public String dt_corte_final;
  public String somente_consulta;
  public String distribuicao;
  public String cb_desc_com;
  public String cb_desc_prom;
  public String cb_desc_pont;
  public String cb_cnd_cdgo;
  public String cb_invoice;
  public String cb_valor;
  public String cb_mini_fabrica;
  public String cb_portao_embarque;
  public String cb_dt_faturamento;
  public String cb_volumes1;
  public String cb_previsao;
  public String cb_dt_ultima_ocorrencia;
  public String cb_atacado1;
  public String cb_seq;
  public String cb_razao_social;
  public String cb_cidade;
  public String cb_loja;
  public String cb_obs_pedido;
  public String cb_data_bloqueio;
  public String cb_data_prevista_desbloqueio;
  public String cb_dt_solicitacao_alarme;
  public String cb_dt_recebimento_alarme;
  public String cb_dt_recebimento_alarme_filial;
  public String cb_nota_fiscal_alarme;
  public String cb_distribuicao;
  public String cb_normativa_cliente;
  public String cb_emiss;
  public String cb_bloqueio_49;
  public String cb_alerta_etiqueta;
  public String cb_livro;
  public String cb_tra_cdgo;
  public String cb_dt_corte;
  public String cb_bloqueado_credito;
  public String preco_pdv;
  public String cb_certificado_origem;
  public String referencia;
  public String cb_descricao_item;
  public String cb_bloqueio_uf;
  public String cb_tipo_estoque;
  public String cb_data_etiquetagem;
  public String cb_gerar_requisicao;
  public String cb_local_estoque;
  public String cb_descricao;
  public String descricao_embalagem;
  public String cb_descricao_embalagem;
  public String cb_cnpj;
  public String cb_romaneio;
  public String mostrar_filiais_producao;
  public String cb_grade_corrugado;
  private boolean valida = false;
  public ControleClientesEspeciaisActionForm() {
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

  public String[][] getRep_rzao_Ajax(ControleClientesEspeciaisActionForm PARAM) {
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
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
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

  public String[][] getNome_regional_Ajax(ControleClientesEspeciaisActionForm PARAM) {
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
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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

  public String[][] getCli_rzao_Ajax(ControleClientesEspeciaisActionForm PARAM) {
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
    * CLI_RZAO: Method to set the field value.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
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
    * NRO_NORMATIVA: Method to get the field value.
    */
  public String getNro_normativa() {
    return nro_normativa;
  }
  /**
    * NRO_NORMATIVA: Method to set the field value.
    */
  public void setNro_normativa(String PARAM) {
    nro_normativa = PARAM;
  }
  /**
    * DESCRICAO: Method to get the field value.
    */
  public String getDescricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (nro_normativa != null && nro_normativa.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Normativa db_object = new Normativa();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"nro_normativa","=",com.egen.util.text.FormatNumber.toInt(nro_normativa)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Normativa) results.elementAt(0);
          descricao = (db_object.getDescricao() != null) ? db_object.getDescricao() + "":"";
        } else {
          descricao = "";
        }
      }
    } catch (Exception e) {
      descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao;
  }

  public String[][] getDescricao_Ajax(ControleClientesEspeciaisActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getNro_normativa() != null && PARAM.getNro_normativa().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Normativa db_object = new Normativa();
        Object[][] where = { {"nro_normativa","like",PARAM.getNro_normativa()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Normativa) results.elementAt(0);
          list[0] = new String[]{"descricao", (db_object.getDescricao() != null) ? db_object.getDescricao() + "":""};
        } else {
          list[0] = new String[]{"descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO: Method to set the field value.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * GRE_GRUPO: Method to get the field value.
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Method to set the field value.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
  }
  /**
    * GRE_DESCRICAO: Method to get the field value.
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

  public String[][] getGre_descricao_Ajax(ControleClientesEspeciaisActionForm PARAM) {
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
    * GRE_DESCRICAO: Method to set the field value.
    */
  public void setGre_descricao(String PARAM) {
    gre_descricao = PARAM;
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
    * ANO_FATURA: Method to get the field value.
    */
  public String getAno_fatura() {
    return ano_fatura;
  }
  /**
    * ANO_FATURA: Method to set the field value.
    */
  public void setAno_fatura(String PARAM) {
    ano_fatura = PARAM;
  }
  /**
    * NUMERO_FATURA: Method to get the field value.
    */
  public String getNumero_fatura() {
    return numero_fatura;
  }
  /**
    * NUMERO_FATURA: Method to set the field value.
    */
  public void setNumero_fatura(String PARAM) {
    numero_fatura = PARAM;
  }
  /**
    * NF_NUMERO: Method to get the field value.
    */
  public String getNf_numero() {
    return nf_numero;
  }
  /**
    * NF_NUMERO: Method to set the field value.
    */
  public void setNf_numero(String PARAM) {
    nf_numero = PARAM;
  }
  /**
    * NF_SERIE: Method to get the field value.
    */
  public String getNf_serie() {
    return nf_serie;
  }
  /**
    * NF_SERIE: Method to set the field value.
    */
  public void setNf_serie(String PARAM) {
    nf_serie = PARAM;
  }
  /**
    * PED_PED_CLIENTE: Method to get the field value.
    */
  public String getPed_ped_cliente() {
    return ped_ped_cliente;
  }
  /**
    * PED_PED_CLIENTE: Method to set the field value.
    */
  public void setPed_ped_cliente(String PARAM) {
    ped_ped_cliente = PARAM;
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

  public String[][] getFil_razsoc_Ajax(ControleClientesEspeciaisActionForm PARAM) {
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
    * LOCAL_ESTOQUE: Method to get the field value.
    */
  public String getLocal_estoque() {
    return local_estoque;
  }
  /**
    * LOCAL_ESTOQUE: Method to set the field value.
    */
  public void setLocal_estoque(String PARAM) {
    local_estoque = PARAM;
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ControleClientesEspeciais.", e);
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
  /**
    * TIPO_PRODUTO: Method to get the field value.
    */
  public String getTipo_produto() {
    return tipo_produto;
  }
  /**
    * TIPO_PRODUTO: Method to set the field value.
    */
  public void setTipo_produto(String PARAM) {
    tipo_produto = PARAM;
  }
  private Vector tipo_produtoList = new Vector(10, 10);
  public void setTipo_produtoList(java.util.Vector VECTOR) {
    tipo_produtoList = VECTOR;
  }
  public java.util.Vector getTipo_produtoList() {
    if (tipo_produtoList == null || tipo_produtoList.size() == 0) {
      tipo_produtoList = new Vector(10, 10);
      tipo_produtoLabelList = new Vector(10, 10);
      tipo_produtoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      tipo_produtoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_posicao_fabrica db_object = new Grupo_posicao_fabrica();
        String[][] select = {{"codigo_grupo", null},{"descricao_grupo", null}};
        Object[][] where = null;
        String[] order = {"codigo_grupo"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Grupo_posicao_fabrica) results.elementAt(i);
          tipo_produtoList.addElement(""+db_object.getCodigo_grupo());
          tipo_produtoLabelList.addElement(""+db_object.getDescricao_grupo());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ControleClientesEspeciais.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return tipo_produtoList;
  }
  private java.util.Vector tipo_produtoLabelList = new Vector(10, 10);
  public void setTipo_produtoLabelList(java.util.Vector VECTOR) {
    tipo_produtoLabelList = VECTOR;
  }
  public java.util.Vector getTipo_produtoLabelList() {
    return tipo_produtoLabelList;
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
      tipo_pedidoList.addElement("PG");
      tipo_pedidoLabelList.addElement("Programado");
      tipo_pedidoList.addElement("PP");
      tipo_pedidoLabelList.addElement("Produto Pronto");
      tipo_pedidoList.addElement("EX");
      tipo_pedidoLabelList.addElement("Exportação");
      tipo_pedidoList.addElement("PE");
      tipo_pedidoLabelList.addElement("Pronta Entrega");
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
    * PED_STAT: Method to get the field value.
    */
  public String getPed_stat() {
    return ped_stat;
  }
  /**
    * PED_STAT: Method to set the field value.
    */
  public void setPed_stat(String PARAM) {
    ped_stat = PARAM;
  }
  Vector ped_statList = new Vector(10, 1);
  public java.util.Vector getPed_statList() {
    if (ped_statList == null || ped_statList.size() == 0) {
      ped_statList.addElement("");
      ped_statLabelList.addElement("Todas");
      ped_statList.addElement("A");
      ped_statLabelList.addElement("A-Aberto");
      ped_statList.addElement("B");
      ped_statLabelList.addElement("B-Bloqueado Vendas");
      ped_statList.addElement("C");
      ped_statLabelList.addElement("C-Cancelado");
      ped_statList.addElement("F");
      ped_statLabelList.addElement("F-Faturado");
      ped_statList.addElement("L");
      ped_statLabelList.addElement("L-Liberado");
      ped_statList.addElement("P");
      ped_statLabelList.addElement("P-Bloqueado Crédito");
      ped_statList.addElement("PF");
      ped_statLabelList.addElement("PF-Parcialmente Faturado");
      ped_statList.addElement("R");
      ped_statLabelList.addElement("R-Análise Comercial");
      ped_statList.addElement("T");
      ped_statLabelList.addElement("T-Trancado");
      ped_statList.addElement("X");
      ped_statLabelList.addElement("Todas menos C e F");
    }
    java.util.Vector list = ped_statList;
    return list;
  }
  java.util.Vector ped_statLabelList = new Vector(10, 1);
  public java.util.Vector getPed_statLabelList() {
    java.util.Vector list = ped_statLabelList;
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
  /**
    * DT_INICIAL: Method to get the field value.
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Method to set the field value.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Method to get the field value.
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Method to set the field value.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * DT_ENT_INICIAL: Method to get the field value.
    */
  public String getDt_ent_inicial() {
    return dt_ent_inicial;
  }
  /**
    * DT_ENT_INICIAL: Method to set the field value.
    */
  public void setDt_ent_inicial(String PARAM) {
    dt_ent_inicial = PARAM;
  }
  /**
    * DT_ENT_FINAL: Method to get the field value.
    */
  public String getDt_ent_final() {
    return dt_ent_final;
  }
  /**
    * DT_ENT_FINAL: Method to set the field value.
    */
  public void setDt_ent_final(String PARAM) {
    dt_ent_final = PARAM;
  }
  /**
    * ORDEM: Method to get the field value.
    */
  public String getOrdem() {
    return ordem;
  }
  /**
    * ORDEM: Method to set the field value.
    */
  public void setOrdem(String PARAM) {
    ordem = PARAM;
  }
  Vector ordemList = new Vector(10, 1);
  public java.util.Vector getOrdemList() {
    if (ordemList == null || ordemList.size() == 0) {
      ordemList.addElement("d");
      ordemLabelList.addElement("Data Faturamento");
      ordemList.addElement("f");
      ordemLabelList.addElement("Filial");
      ordemList.addElement("o");
      ordemLabelList.addElement("Ordem de Compra");
      ordemList.addElement("c");
      ordemLabelList.addElement("Cliente");
      ordemList.addElement("g");
      ordemLabelList.addElement("Grupo Econômico");
      ordemList.addElement("a");
      ordemLabelList.addElement("Data Agendamento");
    }
    java.util.Vector list = ordemList;
    return list;
  }
  java.util.Vector ordemLabelList = new Vector(10, 1);
  public java.util.Vector getOrdemLabelList() {
    java.util.Vector list = ordemLabelList;
    return list;
  }
  /**
    * CB_REGIONAL: Method to get the field value.
    */
  public String getCb_regional() {
    return cb_regional;
  }
  /**
    * CB_REGIONAL: Method to set the field value.
    */
  public void setCb_regional(String PARAM) {
    cb_regional = PARAM;
  }
  /**
    * CB_GRUPO_ECONOMICO: Method to get the field value.
    */
  public String getCb_grupo_economico() {
    return cb_grupo_economico;
  }
  /**
    * CB_GRUPO_ECONOMICO: Method to set the field value.
    */
  public void setCb_grupo_economico(String PARAM) {
    cb_grupo_economico = PARAM;
  }
  /**
    * CB_CLIENTE: Method to get the field value.
    */
  public String getCb_cliente() {
    return cb_cliente;
  }
  /**
    * CB_CLIENTE: Method to set the field value.
    */
  public void setCb_cliente(String PARAM) {
    cb_cliente = PARAM;
  }
  /**
    * CB_REPRESENTANTE: Method to get the field value.
    */
  public String getCb_representante() {
    return cb_representante;
  }
  /**
    * CB_REPRESENTANTE: Method to set the field value.
    */
  public void setCb_representante(String PARAM) {
    cb_representante = PARAM;
  }
  /**
    * CB_PEDIDO: Method to get the field value.
    */
  public String getCb_pedido() {
    return cb_pedido;
  }
  /**
    * CB_PEDIDO: Method to set the field value.
    */
  public void setCb_pedido(String PARAM) {
    cb_pedido = PARAM;
  }
  /**
    * CB_SITUACAO: Method to get the field value.
    */
  public String getCb_situacao() {
    return cb_situacao;
  }
  /**
    * CB_SITUACAO: Method to set the field value.
    */
  public void setCb_situacao(String PARAM) {
    cb_situacao = PARAM;
  }
  /**
    * CB_TIPO_PEDIDO: Method to get the field value.
    */
  public String getCb_tipo_pedido() {
    return cb_tipo_pedido;
  }
  /**
    * CB_TIPO_PEDIDO: Method to set the field value.
    */
  public void setCb_tipo_pedido(String PARAM) {
    cb_tipo_pedido = PARAM;
  }
  /**
    * CB_OC: Method to get the field value.
    */
  public String getCb_oc() {
    return cb_oc;
  }
  /**
    * CB_OC: Method to set the field value.
    */
  public void setCb_oc(String PARAM) {
    cb_oc = PARAM;
  }
  /**
    * CB_LINHA: Method to get the field value.
    */
  public String getCb_linha() {
    return cb_linha;
  }
  /**
    * CB_LINHA: Method to set the field value.
    */
  public void setCb_linha(String PARAM) {
    cb_linha = PARAM;
  }
  /**
    * CB_ETIQUETAS: Method to get the field value.
    */
  public String getCb_etiquetas() {
    return cb_etiquetas;
  }
  /**
    * CB_ETIQUETAS: Method to set the field value.
    */
  public void setCb_etiquetas(String PARAM) {
    cb_etiquetas = PARAM;
  }
  /**
    * CB_OBS: Method to get the field value.
    */
  public String getCb_obs() {
    return cb_obs;
  }
  /**
    * CB_OBS: Method to set the field value.
    */
  public void setCb_obs(String PARAM) {
    cb_obs = PARAM;
  }
  /**
    * CB_PARES: Method to get the field value.
    */
  public String getCb_pares() {
    return cb_pares;
  }
  /**
    * CB_PARES: Method to set the field value.
    */
  public void setCb_pares(String PARAM) {
    cb_pares = PARAM;
  }
  /**
    * CB_REM: Method to get the field value.
    */
  public String getCb_rem() {
    return cb_rem;
  }
  /**
    * CB_REM: Method to set the field value.
    */
  public void setCb_rem(String PARAM) {
    cb_rem = PARAM;
  }
  /**
    * CB_FL_PROD: Method to get the field value.
    */
  public String getCb_fl_prod() {
    return cb_fl_prod;
  }
  /**
    * CB_FL_PROD: Method to set the field value.
    */
  public void setCb_fl_prod(String PARAM) {
    cb_fl_prod = PARAM;
  }
  /**
    * CB_FL_FAT: Method to get the field value.
    */
  public String getCb_fl_fat() {
    return cb_fl_fat;
  }
  /**
    * CB_FL_FAT: Method to set the field value.
    */
  public void setCb_fl_fat(String PARAM) {
    cb_fl_fat = PARAM;
  }
  /**
    * CB_DIGIT: Method to get the field value.
    */
  public String getCb_digit() {
    return cb_digit;
  }
  /**
    * CB_DIGIT: Method to set the field value.
    */
  public void setCb_digit(String PARAM) {
    cb_digit = PARAM;
  }
  /**
    * CB_FAT_CLI: Method to get the field value.
    */
  public String getCb_fat_cli() {
    return cb_fat_cli;
  }
  /**
    * CB_FAT_CLI: Method to set the field value.
    */
  public void setCb_fat_cli(String PARAM) {
    cb_fat_cli = PARAM;
  }
  /**
    * CB_FAT_BR: Method to get the field value.
    */
  public String getCb_fat_br() {
    return cb_fat_br;
  }
  /**
    * CB_FAT_BR: Method to set the field value.
    */
  public void setCb_fat_br(String PARAM) {
    cb_fat_br = PARAM;
  }
  /**
    * CB_MARCA: Method to get the field value.
    */
  public String getCb_marca() {
    return cb_marca;
  }
  /**
    * CB_MARCA: Method to set the field value.
    */
  public void setCb_marca(String PARAM) {
    cb_marca = PARAM;
  }
  /**
    * CB_CARIMBO: Method to get the field value.
    */
  public String getCb_carimbo() {
    return cb_carimbo;
  }
  /**
    * CB_CARIMBO: Method to set the field value.
    */
  public void setCb_carimbo(String PARAM) {
    cb_carimbo = PARAM;
  }
  /**
    * CB_ROTULOS: Method to get the field value.
    */
  public String getCb_rotulos() {
    return cb_rotulos;
  }
  /**
    * CB_ROTULOS: Method to set the field value.
    */
  public void setCb_rotulos(String PARAM) {
    cb_rotulos = PARAM;
  }
  /**
    * CB_PED_AMOSTRA: Method to get the field value.
    */
  public String getCb_ped_amostra() {
    return cb_ped_amostra;
  }
  /**
    * CB_PED_AMOSTRA: Method to set the field value.
    */
  public void setCb_ped_amostra(String PARAM) {
    cb_ped_amostra = PARAM;
  }
  /**
    * CB_DT_ENVIO: Method to get the field value.
    */
  public String getCb_dt_envio() {
    return cb_dt_envio;
  }
  /**
    * CB_DT_ENVIO: Method to set the field value.
    */
  public void setCb_dt_envio(String PARAM) {
    cb_dt_envio = PARAM;
  }
  /**
    * CB_AGENDA: Method to get the field value.
    */
  public String getCb_agenda() {
    return cb_agenda;
  }
  /**
    * CB_AGENDA: Method to set the field value.
    */
  public void setCb_agenda(String PARAM) {
    cb_agenda = PARAM;
  }
  /**
    * CB_DEZENA: Method to get the field value.
    */
  public String getCb_dezena() {
    return cb_dezena;
  }
  /**
    * CB_DEZENA: Method to set the field value.
    */
  public void setCb_dezena(String PARAM) {
    cb_dezena = PARAM;
  }
  /**
    * CB_DIA: Method to get the field value.
    */
  public String getCb_dia() {
    return cb_dia;
  }
  /**
    * CB_DIA: Method to set the field value.
    */
  public void setCb_dia(String PARAM) {
    cb_dia = PARAM;
  }
  /**
    * CB_DT_EFETIVA: Method to get the field value.
    */
  public String getCb_dt_efetiva() {
    return cb_dt_efetiva;
  }
  /**
    * CB_DT_EFETIVA: Method to set the field value.
    */
  public void setCb_dt_efetiva(String PARAM) {
    cb_dt_efetiva = PARAM;
  }
  /**
    * CB_HORA: Method to get the field value.
    */
  public String getCb_hora() {
    return cb_hora;
  }
  /**
    * CB_HORA: Method to set the field value.
    */
  public void setCb_hora(String PARAM) {
    cb_hora = PARAM;
  }
  /**
    * CB_SENHA: Method to get the field value.
    */
  public String getCb_senha() {
    return cb_senha;
  }
  /**
    * CB_SENHA: Method to set the field value.
    */
  public void setCb_senha(String PARAM) {
    cb_senha = PARAM;
  }
  /**
    * CB_EMISSAO: Method to get the field value.
    */
  public String getCb_emissao() {
    return cb_emissao;
  }
  /**
    * CB_EMISSAO: Method to set the field value.
    */
  public void setCb_emissao(String PARAM) {
    cb_emissao = PARAM;
  }
  /**
    * CB_FILIAL: Method to get the field value.
    */
  public String getCb_filial() {
    return cb_filial;
  }
  /**
    * CB_FILIAL: Method to set the field value.
    */
  public void setCb_filial(String PARAM) {
    cb_filial = PARAM;
  }
  /**
    * CB_NF: Method to get the field value.
    */
  public String getCb_nf() {
    return cb_nf;
  }
  /**
    * CB_NF: Method to set the field value.
    */
  public void setCb_nf(String PARAM) {
    cb_nf = PARAM;
  }
  /**
    * CB_VOLUMES: Method to get the field value.
    */
  public String getCb_volumes() {
    return cb_volumes;
  }
  /**
    * CB_VOLUMES: Method to set the field value.
    */
  public void setCb_volumes(String PARAM) {
    cb_volumes = PARAM;
  }
  /**
    * CB_DT_INSPECAO: Method to get the field value.
    */
  public String getCb_dt_inspecao() {
    return cb_dt_inspecao;
  }
  /**
    * CB_DT_INSPECAO: Method to set the field value.
    */
  public void setCb_dt_inspecao(String PARAM) {
    cb_dt_inspecao = PARAM;
  }
  /**
    * CB_DT_MONTAGEM: Method to get the field value.
    */
  public String getCb_dt_montagem() {
    return cb_dt_montagem;
  }
  /**
    * CB_DT_MONTAGEM: Method to set the field value.
    */
  public void setCb_dt_montagem(String PARAM) {
    cb_dt_montagem = PARAM;
  }
  /**
    * CB_DT_ENTREGA_ETIQUETA: Method to get the field value.
    */
  public String getCb_dt_entrega_etiqueta() {
    return cb_dt_entrega_etiqueta;
  }
  /**
    * CB_DT_ENTREGA_ETIQUETA: Method to set the field value.
    */
  public void setCb_dt_entrega_etiqueta(String PARAM) {
    cb_dt_entrega_etiqueta = PARAM;
  }
  /**
    * CB_ESPECIE: Method to get the field value.
    */
  public String getCb_especie() {
    return cb_especie;
  }
  /**
    * CB_ESPECIE: Method to set the field value.
    */
  public void setCb_especie(String PARAM) {
    cb_especie = PARAM;
  }
  /**
    * POSSUI_DADOS: Method to get the field value.
    */
  public String getPossui_dados() {
    return possui_dados;
  }
  /**
    * POSSUI_DADOS: Method to set the field value.
    */
  public void setPossui_dados(String PARAM) {
    possui_dados = PARAM;
  }
  /**
    * CB_POSSUI_CARIMBO: Method to get the field value.
    */
  public String getCb_possui_carimbo() {
    return cb_possui_carimbo;
  }
  /**
    * CB_POSSUI_CARIMBO: Method to set the field value.
    */
  public void setCb_possui_carimbo(String PARAM) {
    cb_possui_carimbo = PARAM;
  }
  /**
    * CB_SOMENTE_ETIQUETA: Method to get the field value.
    */
  public String getCb_somente_etiqueta() {
    return cb_somente_etiqueta;
  }
  /**
    * CB_SOMENTE_ETIQUETA: Method to set the field value.
    */
  public void setCb_somente_etiqueta(String PARAM) {
    cb_somente_etiqueta = PARAM;
  }
  /**
    * CB_ETIQUETAS_PENDENTES: Method to get the field value.
    */
  public String getCb_etiquetas_pendentes() {
    return cb_etiquetas_pendentes;
  }
  /**
    * CB_ETIQUETAS_PENDENTES: Method to set the field value.
    */
  public void setCb_etiquetas_pendentes(String PARAM) {
    cb_etiquetas_pendentes = PARAM;
  }
  /**
    * CB_SOMENTE_AMOSTRA: Method to get the field value.
    */
  public String getCb_somente_amostra() {
    return cb_somente_amostra;
  }
  /**
    * CB_SOMENTE_AMOSTRA: Method to set the field value.
    */
  public void setCb_somente_amostra(String PARAM) {
    cb_somente_amostra = PARAM;
  }
  /**
    * DT_NF_INICIAL: Method to get the field value.
    */
  public String getDt_nf_inicial() {
    return dt_nf_inicial;
  }
  /**
    * DT_NF_INICIAL: Method to set the field value.
    */
  public void setDt_nf_inicial(String PARAM) {
    dt_nf_inicial = PARAM;
  }
  /**
    * DT_NF_FINAL: Method to get the field value.
    */
  public String getDt_nf_final() {
    return dt_nf_final;
  }
  /**
    * DT_NF_FINAL: Method to set the field value.
    */
  public void setDt_nf_final(String PARAM) {
    dt_nf_final = PARAM;
  }
  /**
    * CB_EMPENHADO_COMPLETO: Method to get the field value.
    */
  public String getCb_empenhado_completo() {
    return cb_empenhado_completo;
  }
  /**
    * CB_EMPENHADO_COMPLETO: Method to set the field value.
    */
  public void setCb_empenhado_completo(String PARAM) {
    cb_empenhado_completo = PARAM;
  }
  /**
    * ETIQUETAS: Method to get the field value.
    */
  public String getEtiquetas() {
    return etiquetas;
  }
  /**
    * ETIQUETAS: Method to set the field value.
    */
  public void setEtiquetas(String PARAM) {
    etiquetas = PARAM;
  }
  /**
    * REMESSA: Method to get the field value.
    */
  public String getRemessa() {
    return remessa;
  }
  /**
    * REMESSA: Method to set the field value.
    */
  public void setRemessa(String PARAM) {
    remessa = PARAM;
  }
  /**
    * CB_PORTAO_ENTREGA: Method to get the field value.
    */
  public String getCb_portao_entrega() {
    return cb_portao_entrega;
  }
  /**
    * CB_PORTAO_ENTREGA: Method to set the field value.
    */
  public void setCb_portao_entrega(String PARAM) {
    cb_portao_entrega = PARAM;
  }
  /**
    * CB_CD_ENTREGA: Method to get the field value.
    */
  public String getCb_cd_entrega() {
    return cb_cd_entrega;
  }
  /**
    * CB_CD_ENTREGA: Method to set the field value.
    */
  public void setCb_cd_entrega(String PARAM) {
    cb_cd_entrega = PARAM;
  }
  /**
    * CB_DT_ENTREGA: Method to get the field value.
    */
  public String getCb_dt_entrega() {
    return cb_dt_entrega;
  }
  /**
    * CB_DT_ENTREGA: Method to set the field value.
    */
  public void setCb_dt_entrega(String PARAM) {
    cb_dt_entrega = PARAM;
  }
  /**
    * CB_AMOSTRA_BRINDE: Method to get the field value.
    */
  public String getCb_amostra_brinde() {
    return cb_amostra_brinde;
  }
  /**
    * CB_AMOSTRA_BRINDE: Method to set the field value.
    */
  public void setCb_amostra_brinde(String PARAM) {
    cb_amostra_brinde = PARAM;
  }
  /**
    * CB_ENCARTE: Method to get the field value.
    */
  public String getCb_encarte() {
    return cb_encarte;
  }
  /**
    * CB_ENCARTE: Method to set the field value.
    */
  public void setCb_encarte(String PARAM) {
    cb_encarte = PARAM;
  }
  /**
    * CB_PRIORIDADE_EMBARQUE: Method to get the field value.
    */
  public String getCb_prioridade_embarque() {
    return cb_prioridade_embarque;
  }
  /**
    * CB_PRIORIDADE_EMBARQUE: Method to set the field value.
    */
  public void setCb_prioridade_embarque(String PARAM) {
    cb_prioridade_embarque = PARAM;
  }
  /**
    * CB_DT_REC_ETIQUETA_FILIAL: Method to get the field value.
    */
  public String getCb_dt_rec_etiqueta_filial() {
    return cb_dt_rec_etiqueta_filial;
  }
  /**
    * CB_DT_REC_ETIQUETA_FILIAL: Method to set the field value.
    */
  public void setCb_dt_rec_etiqueta_filial(String PARAM) {
    cb_dt_rec_etiqueta_filial = PARAM;
  }
  /**
    * CB_CABIDE: Method to get the field value.
    */
  public String getCb_cabide() {
    return cb_cabide;
  }
  /**
    * CB_CABIDE: Method to set the field value.
    */
  public void setCb_cabide(String PARAM) {
    cb_cabide = PARAM;
  }
  /**
    * CB_ATACADO: Method to get the field value.
    */
  public String getCb_atacado() {
    return cb_atacado;
  }
  /**
    * CB_ATACADO: Method to set the field value.
    */
  public void setCb_atacado(String PARAM) {
    cb_atacado = PARAM;
  }
  /**
    * ATACADO: Method to get the field value.
    */
  public String getAtacado() {
    return atacado;
  }
  /**
    * ATACADO: Method to set the field value.
    */
  public void setAtacado(String PARAM) {
    atacado = PARAM;
  }
  Vector atacadoList = new Vector(10, 1);
  public java.util.Vector getAtacadoList() {
    if (atacadoList == null || atacadoList.size() == 0) {
      atacadoList.addElement("T");
      atacadoLabelList.addElement("Todos");
      atacadoList.addElement("S");
      atacadoLabelList.addElement("Sim");
      atacadoList.addElement("N");
      atacadoLabelList.addElement("Não");
    }
    java.util.Vector list = atacadoList;
    return list;
  }
  java.util.Vector atacadoLabelList = new Vector(10, 1);
  public java.util.Vector getAtacadoLabelList() {
    java.util.Vector list = atacadoLabelList;
    return list;
  }
  /**
    * DT_AGEND_INICIAL: Method to get the field value.
    */
  public String getDt_agend_inicial() {
    return dt_agend_inicial;
  }
  /**
    * DT_AGEND_INICIAL: Method to set the field value.
    */
  public void setDt_agend_inicial(String PARAM) {
    dt_agend_inicial = PARAM;
  }
  /**
    * DT_AGEND_FINAL: Method to get the field value.
    */
  public String getDt_agend_final() {
    return dt_agend_final;
  }
  /**
    * DT_AGEND_FINAL: Method to set the field value.
    */
  public void setDt_agend_final(String PARAM) {
    dt_agend_final = PARAM;
  }
  /**
    * TRA_CDGO: Method to get the field value.
    */
  public String getTra_cdgo() {
    return tra_cdgo;
  }
  /**
    * TRA_CDGO: Method to set the field value.
    */
  public void setTra_cdgo(String PARAM) {
    tra_cdgo = PARAM;
  }
  /**
    * TRA_NOME: Method to get the field value.
    */
  public String getTra_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tra_cdgo != null && tra_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        String[][] select = { {"tra_nome",null} };
        Object[][] where = { {"tra_cdgo","=",com.egen.util.text.FormatNumber.toInt(tra_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          tra_nome = (db_object.getTra_nome() != null) ? db_object.getTra_nome() + "":"";
        } else {
          tra_nome = "";
        }
      }
    } catch (Exception e) {
      tra_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return tra_nome;
  }

  public String[][] getTra_nome_Ajax(ControleClientesEspeciaisActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getTra_cdgo() != null && PARAM.getTra_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        Object[][] where = { {"tra_cdgo","like",PARAM.getTra_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          list[0] = new String[]{"tra_nome", (db_object.getTra_nome() != null) ? db_object.getTra_nome() + "":""};
        } else {
          list[0] = new String[]{"tra_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"tra_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * TRA_NOME: Method to set the field value.
    */
  public void setTra_nome(String PARAM) {
    tra_nome = PARAM;
  }
  /**
    * CB_ETIQUETAS_PENDENTES_INDUSTRIAL: Method to get the field value.
    */
  public String getCb_etiquetas_pendentes_industrial() {
    return cb_etiquetas_pendentes_industrial;
  }
  /**
    * CB_ETIQUETAS_PENDENTES_INDUSTRIAL: Method to set the field value.
    */
  public void setCb_etiquetas_pendentes_industrial(String PARAM) {
    cb_etiquetas_pendentes_industrial = PARAM;
  }
  /**
    * ITE_SITU: Method to get the field value.
    */
  public String getIte_situ() {
    return ite_situ;
  }
  /**
    * ITE_SITU: Method to set the field value.
    */
  public void setIte_situ(String PARAM) {
    ite_situ = PARAM;
  }
  /**
    * LINHA: Method to get the field value.
    */
  public String getLinha() {
    return linha;
  }
  /**
    * LINHA: Method to set the field value.
    */
  public void setLinha(String PARAM) {
    linha = PARAM;
  }
  /**
    * CB_SUBTOTAL_GRUPO_ECONOMICO: Method to get the field value.
    */
  public String getCb_subtotal_grupo_economico() {
    return cb_subtotal_grupo_economico;
  }
  /**
    * CB_SUBTOTAL_GRUPO_ECONOMICO: Method to set the field value.
    */
  public void setCb_subtotal_grupo_economico(String PARAM) {
    cb_subtotal_grupo_economico = PARAM;
  }
  /**
    * DT_EMISS_INI: Method to get the field value.
    */
  public String getDt_emiss_ini() {
    return dt_emiss_ini;
  }
  /**
    * DT_EMISS_INI: Method to set the field value.
    */
  public void setDt_emiss_ini(String PARAM) {
    dt_emiss_ini = PARAM;
  }
  /**
    * DT_EMISS_FIM: Method to get the field value.
    */
  public String getDt_emiss_fim() {
    return dt_emiss_fim;
  }
  /**
    * DT_EMISS_FIM: Method to set the field value.
    */
  public void setDt_emiss_fim(String PARAM) {
    dt_emiss_fim = PARAM;
  }
  /**
    * GERAR_PLANILHA: Method to get the field value.
    */
  public String getGerar_planilha() {
    return gerar_planilha;
  }
  /**
    * GERAR_PLANILHA: Method to set the field value.
    */
  public void setGerar_planilha(String PARAM) {
    gerar_planilha = PARAM;
  }
  Vector gerar_planilhaList = new Vector(10, 1);
  public java.util.Vector getGerar_planilhaList() {
    if (gerar_planilhaList == null || gerar_planilhaList.size() == 0) {
      gerar_planilhaList.addElement("N");
      gerar_planilhaLabelList.addElement("Não");
      gerar_planilhaList.addElement("S");
      gerar_planilhaLabelList.addElement("Sim");
    }
    java.util.Vector list = gerar_planilhaList;
    return list;
  }
  java.util.Vector gerar_planilhaLabelList = new Vector(10, 1);
  public java.util.Vector getGerar_planilhaLabelList() {
    java.util.Vector list = gerar_planilhaLabelList;
    return list;
  }
  /**
    * GERAR_PLANILHA_SUBTOTAL: Method to get the field value.
    */
  public String getGerar_planilha_subtotal() {
    return gerar_planilha_subtotal;
  }
  /**
    * GERAR_PLANILHA_SUBTOTAL: Method to set the field value.
    */
  public void setGerar_planilha_subtotal(String PARAM) {
    gerar_planilha_subtotal = PARAM;
  }
  /**
    * DT_CORTE_INICIAL: Method to get the field value.
    */
  public String getDt_corte_inicial() {
    return dt_corte_inicial;
  }
  /**
    * DT_CORTE_INICIAL: Method to set the field value.
    */
  public void setDt_corte_inicial(String PARAM) {
    dt_corte_inicial = PARAM;
  }
  /**
    * DT_CORTE_FINAL: Method to get the field value.
    */
  public String getDt_corte_final() {
    return dt_corte_final;
  }
  /**
    * DT_CORTE_FINAL: Method to set the field value.
    */
  public void setDt_corte_final(String PARAM) {
    dt_corte_final = PARAM;
  }
  /**
    * SOMENTE_CONSULTA: Method to get the field value.
    */
  public String getSomente_consulta() {
    return somente_consulta;
  }
  /**
    * SOMENTE_CONSULTA: Method to set the field value.
    */
  public void setSomente_consulta(String PARAM) {
    somente_consulta = PARAM;
  }
  /**
    * DISTRIBUICAO: Method to get the field value.
    */
  public String getDistribuicao() {
    return distribuicao;
  }
  /**
    * DISTRIBUICAO: Method to set the field value.
    */
  public void setDistribuicao(String PARAM) {
    distribuicao = PARAM;
  }
  /**
    * CB_DESC_COM: Method to get the field value.
    */
  public String getCb_desc_com() {
    return cb_desc_com;
  }
  /**
    * CB_DESC_COM: Method to set the field value.
    */
  public void setCb_desc_com(String PARAM) {
    cb_desc_com = PARAM;
  }
  /**
    * CB_DESC_PROM: Method to get the field value.
    */
  public String getCb_desc_prom() {
    return cb_desc_prom;
  }
  /**
    * CB_DESC_PROM: Method to set the field value.
    */
  public void setCb_desc_prom(String PARAM) {
    cb_desc_prom = PARAM;
  }
  /**
    * CB_DESC_PONT: Method to get the field value.
    */
  public String getCb_desc_pont() {
    return cb_desc_pont;
  }
  /**
    * CB_DESC_PONT: Method to set the field value.
    */
  public void setCb_desc_pont(String PARAM) {
    cb_desc_pont = PARAM;
  }
  /**
    * CB_CND_CDGO: Method to get the field value.
    */
  public String getCb_cnd_cdgo() {
    return cb_cnd_cdgo;
  }
  /**
    * CB_CND_CDGO: Method to set the field value.
    */
  public void setCb_cnd_cdgo(String PARAM) {
    cb_cnd_cdgo = PARAM;
  }
  /**
    * CB_INVOICE: Method to get the field value.
    */
  public String getCb_invoice() {
    return cb_invoice;
  }
  /**
    * CB_INVOICE: Method to set the field value.
    */
  public void setCb_invoice(String PARAM) {
    cb_invoice = PARAM;
  }
  /**
    * CB_VALOR: Method to get the field value.
    */
  public String getCb_valor() {
    return cb_valor;
  }
  /**
    * CB_VALOR: Method to set the field value.
    */
  public void setCb_valor(String PARAM) {
    cb_valor = PARAM;
  }
  /**
    * CB_MINI_FABRICA: Method to get the field value.
    */
  public String getCb_mini_fabrica() {
    return cb_mini_fabrica;
  }
  /**
    * CB_MINI_FABRICA: Method to set the field value.
    */
  public void setCb_mini_fabrica(String PARAM) {
    cb_mini_fabrica = PARAM;
  }
  /**
    * CB_PORTAO_EMBARQUE: Method to get the field value.
    */
  public String getCb_portao_embarque() {
    return cb_portao_embarque;
  }
  /**
    * CB_PORTAO_EMBARQUE: Method to set the field value.
    */
  public void setCb_portao_embarque(String PARAM) {
    cb_portao_embarque = PARAM;
  }
  /**
    * CB_DT_FATURAMENTO: Method to get the field value.
    */
  public String getCb_dt_faturamento() {
    return cb_dt_faturamento;
  }
  /**
    * CB_DT_FATURAMENTO: Method to set the field value.
    */
  public void setCb_dt_faturamento(String PARAM) {
    cb_dt_faturamento = PARAM;
  }
  /**
    * CB_VOLUMES1: Method to get the field value.
    */
  public String getCb_volumes1() {
    return cb_volumes1;
  }
  /**
    * CB_VOLUMES1: Method to set the field value.
    */
  public void setCb_volumes1(String PARAM) {
    cb_volumes1 = PARAM;
  }
  /**
    * CB_PREVISAO: Method to get the field value.
    */
  public String getCb_previsao() {
    return cb_previsao;
  }
  /**
    * CB_PREVISAO: Method to set the field value.
    */
  public void setCb_previsao(String PARAM) {
    cb_previsao = PARAM;
  }
  /**
    * CB_DT_ULTIMA_OCORRENCIA: Method to get the field value.
    */
  public String getCb_dt_ultima_ocorrencia() {
    return cb_dt_ultima_ocorrencia;
  }
  /**
    * CB_DT_ULTIMA_OCORRENCIA: Method to set the field value.
    */
  public void setCb_dt_ultima_ocorrencia(String PARAM) {
    cb_dt_ultima_ocorrencia = PARAM;
  }
  /**
    * CB_ATACADO1: Method to get the field value.
    */
  public String getCb_atacado1() {
    return cb_atacado1;
  }
  /**
    * CB_ATACADO1: Method to set the field value.
    */
  public void setCb_atacado1(String PARAM) {
    cb_atacado1 = PARAM;
  }
  /**
    * CB_SEQ: Method to get the field value.
    */
  public String getCb_seq() {
    return cb_seq;
  }
  /**
    * CB_SEQ: Method to set the field value.
    */
  public void setCb_seq(String PARAM) {
    cb_seq = PARAM;
  }
  /**
    * CB_RAZAO_SOCIAL: Method to get the field value.
    */
  public String getCb_razao_social() {
    return cb_razao_social;
  }
  /**
    * CB_RAZAO_SOCIAL: Method to set the field value.
    */
  public void setCb_razao_social(String PARAM) {
    cb_razao_social = PARAM;
  }
  /**
    * CB_CIDADE: Method to get the field value.
    */
  public String getCb_cidade() {
    return cb_cidade;
  }
  /**
    * CB_CIDADE: Method to set the field value.
    */
  public void setCb_cidade(String PARAM) {
    cb_cidade = PARAM;
  }
  /**
    * CB_LOJA: Method to get the field value.
    */
  public String getCb_loja() {
    return cb_loja;
  }
  /**
    * CB_LOJA: Method to set the field value.
    */
  public void setCb_loja(String PARAM) {
    cb_loja = PARAM;
  }
  /**
    * CB_OBS_PEDIDO: Method to get the field value.
    */
  public String getCb_obs_pedido() {
    return cb_obs_pedido;
  }
  /**
    * CB_OBS_PEDIDO: Method to set the field value.
    */
  public void setCb_obs_pedido(String PARAM) {
    cb_obs_pedido = PARAM;
  }
  /**
    * CB_DATA_BLOQUEIO: Method to get the field value.
    */
  public String getCb_data_bloqueio() {
    return cb_data_bloqueio;
  }
  /**
    * CB_DATA_BLOQUEIO: Method to set the field value.
    */
  public void setCb_data_bloqueio(String PARAM) {
    cb_data_bloqueio = PARAM;
  }
  /**
    * CB_DATA_PREVISTA_DESBLOQUEIO: Method to get the field value.
    */
  public String getCb_data_prevista_desbloqueio() {
    return cb_data_prevista_desbloqueio;
  }
  /**
    * CB_DATA_PREVISTA_DESBLOQUEIO: Method to set the field value.
    */
  public void setCb_data_prevista_desbloqueio(String PARAM) {
    cb_data_prevista_desbloqueio = PARAM;
  }
  /**
    * CB_DT_SOLICITACAO_ALARME: Method to get the field value.
    */
  public String getCb_dt_solicitacao_alarme() {
    return cb_dt_solicitacao_alarme;
  }
  /**
    * CB_DT_SOLICITACAO_ALARME: Method to set the field value.
    */
  public void setCb_dt_solicitacao_alarme(String PARAM) {
    cb_dt_solicitacao_alarme = PARAM;
  }
  /**
    * CB_DT_RECEBIMENTO_ALARME: Method to get the field value.
    */
  public String getCb_dt_recebimento_alarme() {
    return cb_dt_recebimento_alarme;
  }
  /**
    * CB_DT_RECEBIMENTO_ALARME: Method to set the field value.
    */
  public void setCb_dt_recebimento_alarme(String PARAM) {
    cb_dt_recebimento_alarme = PARAM;
  }
  /**
    * CB_DT_RECEBIMENTO_ALARME_FILIAL: Method to get the field value.
    */
  public String getCb_dt_recebimento_alarme_filial() {
    return cb_dt_recebimento_alarme_filial;
  }
  /**
    * CB_DT_RECEBIMENTO_ALARME_FILIAL: Method to set the field value.
    */
  public void setCb_dt_recebimento_alarme_filial(String PARAM) {
    cb_dt_recebimento_alarme_filial = PARAM;
  }
  /**
    * CB_NOTA_FISCAL_ALARME: Method to get the field value.
    */
  public String getCb_nota_fiscal_alarme() {
    return cb_nota_fiscal_alarme;
  }
  /**
    * CB_NOTA_FISCAL_ALARME: Method to set the field value.
    */
  public void setCb_nota_fiscal_alarme(String PARAM) {
    cb_nota_fiscal_alarme = PARAM;
  }
  /**
    * CB_DISTRIBUICAO: Method to get the field value.
    */
  public String getCb_distribuicao() {
    return cb_distribuicao;
  }
  /**
    * CB_DISTRIBUICAO: Method to set the field value.
    */
  public void setCb_distribuicao(String PARAM) {
    cb_distribuicao = PARAM;
  }
  /**
    * CB_NORMATIVA_CLIENTE: Method to get the field value.
    */
  public String getCb_normativa_cliente() {
    return cb_normativa_cliente;
  }
  /**
    * CB_NORMATIVA_CLIENTE: Method to set the field value.
    */
  public void setCb_normativa_cliente(String PARAM) {
    cb_normativa_cliente = PARAM;
  }
  /**
    * CB_EMISS: Method to get the field value.
    */
  public String getCb_emiss() {
    return cb_emiss;
  }
  /**
    * CB_EMISS: Method to set the field value.
    */
  public void setCb_emiss(String PARAM) {
    cb_emiss = PARAM;
  }
  /**
    * CB_BLOQUEIO_49: Method to get the field value.
    */
  public String getCb_bloqueio_49() {
    return cb_bloqueio_49;
  }
  /**
    * CB_BLOQUEIO_49: Method to set the field value.
    */
  public void setCb_bloqueio_49(String PARAM) {
    cb_bloqueio_49 = PARAM;
  }
  /**
    * CB_ALERTA_ETIQUETA: Method to get the field value.
    */
  public String getCb_alerta_etiqueta() {
    return cb_alerta_etiqueta;
  }
  /**
    * CB_ALERTA_ETIQUETA: Method to set the field value.
    */
  public void setCb_alerta_etiqueta(String PARAM) {
    cb_alerta_etiqueta = PARAM;
  }
  /**
    * CB_LIVRO: Method to get the field value.
    */
  public String getCb_livro() {
    return cb_livro;
  }
  /**
    * CB_LIVRO: Method to set the field value.
    */
  public void setCb_livro(String PARAM) {
    cb_livro = PARAM;
  }
  /**
    * CB_TRA_CDGO: Method to get the field value.
    */
  public String getCb_tra_cdgo() {
    return cb_tra_cdgo;
  }
  /**
    * CB_TRA_CDGO: Method to set the field value.
    */
  public void setCb_tra_cdgo(String PARAM) {
    cb_tra_cdgo = PARAM;
  }
  /**
    * CB_DT_CORTE: Method to get the field value.
    */
  public String getCb_dt_corte() {
    return cb_dt_corte;
  }
  /**
    * CB_DT_CORTE: Method to set the field value.
    */
  public void setCb_dt_corte(String PARAM) {
    cb_dt_corte = PARAM;
  }
  /**
    * CB_BLOQUEADO_CREDITO: Method to get the field value.
    */
  public String getCb_bloqueado_credito() {
    return cb_bloqueado_credito;
  }
  /**
    * CB_BLOQUEADO_CREDITO: Method to set the field value.
    */
  public void setCb_bloqueado_credito(String PARAM) {
    cb_bloqueado_credito = PARAM;
  }
  /**
    * PRECO_PDV: Method to get the field value.
    */
  public String getPreco_pdv() {
    return preco_pdv;
  }
  /**
    * PRECO_PDV: Method to set the field value.
    */
  public void setPreco_pdv(String PARAM) {
    preco_pdv = PARAM;
  }
  /**
    * CB_CERTIFICADO_ORIGEM: Method to get the field value.
    */
  public String getCb_certificado_origem() {
    return cb_certificado_origem;
  }
  /**
    * CB_CERTIFICADO_ORIGEM: Method to set the field value.
    */
  public void setCb_certificado_origem(String PARAM) {
    cb_certificado_origem = PARAM;
  }
  /**
    * REFERENCIA: Method to get the field value.
    */
  public String getReferencia() {
    return referencia;
  }
  /**
    * REFERENCIA: Method to set the field value.
    */
  public void setReferencia(String PARAM) {
    referencia = PARAM;
  }
  /**
    * CB_DESCRICAO_ITEM: Method to get the field value.
    */
  public String getCb_descricao_item() {
    return cb_descricao_item;
  }
  /**
    * CB_DESCRICAO_ITEM: Method to set the field value.
    */
  public void setCb_descricao_item(String PARAM) {
    cb_descricao_item = PARAM;
  }
  /**
    * CB_BLOQUEIO_UF: Method to get the field value.
    */
  public String getCb_bloqueio_uf() {
    return cb_bloqueio_uf;
  }
  /**
    * CB_BLOQUEIO_UF: Method to set the field value.
    */
  public void setCb_bloqueio_uf(String PARAM) {
    cb_bloqueio_uf = PARAM;
  }
  /**
    * CB_TIPO_ESTOQUE: Method to get the field value.
    */
  public String getCb_tipo_estoque() {
    return cb_tipo_estoque;
  }
  /**
    * CB_TIPO_ESTOQUE: Method to set the field value.
    */
  public void setCb_tipo_estoque(String PARAM) {
    cb_tipo_estoque = PARAM;
  }
  /**
    * CB_DATA_ETIQUETAGEM: Method to get the field value.
    */
  public String getCb_data_etiquetagem() {
    return cb_data_etiquetagem;
  }
  /**
    * CB_DATA_ETIQUETAGEM: Method to set the field value.
    */
  public void setCb_data_etiquetagem(String PARAM) {
    cb_data_etiquetagem = PARAM;
  }
  /**
    * CB_GERAR_REQUISICAO: Method to get the field value.
    */
  public String getCb_gerar_requisicao() {
    return cb_gerar_requisicao;
  }
  /**
    * CB_GERAR_REQUISICAO: Method to set the field value.
    */
  public void setCb_gerar_requisicao(String PARAM) {
    cb_gerar_requisicao = PARAM;
  }
  /**
    * CB_LOCAL_ESTOQUE: Method to get the field value.
    */
  public String getCb_local_estoque() {
    return cb_local_estoque;
  }
  /**
    * CB_LOCAL_ESTOQUE: Method to set the field value.
    */
  public void setCb_local_estoque(String PARAM) {
    cb_local_estoque = PARAM;
  }
  /**
    * CB_DESCRICAO: Method to get the field value.
    */
  public String getCb_descricao() {
    return cb_descricao;
  }
  /**
    * CB_DESCRICAO: Method to set the field value.
    */
  public void setCb_descricao(String PARAM) {
    cb_descricao = PARAM;
  }
  /**
    * DESCRICAO_EMBALAGEM: Method to get the field value.
    */
  public String getDescricao_embalagem() {
    return descricao_embalagem;
  }
  /**
    * DESCRICAO_EMBALAGEM: Method to set the field value.
    */
  public void setDescricao_embalagem(String PARAM) {
    descricao_embalagem = PARAM;
  }
  /**
    * CB_DESCRICAO_EMBALAGEM: Method to get the field value.
    */
  public String getCb_descricao_embalagem() {
    return cb_descricao_embalagem;
  }
  /**
    * CB_DESCRICAO_EMBALAGEM: Method to set the field value.
    */
  public void setCb_descricao_embalagem(String PARAM) {
    cb_descricao_embalagem = PARAM;
  }
  /**
    * CB_CNPJ: Method to get the field value.
    */
  public String getCb_cnpj() {
    return cb_cnpj;
  }
  /**
    * CB_CNPJ: Method to set the field value.
    */
  public void setCb_cnpj(String PARAM) {
    cb_cnpj = PARAM;
  }
  /**
    * CB_ROMANEIO: Method to get the field value.
    */
  public String getCb_romaneio() {
    return cb_romaneio;
  }
  /**
    * CB_ROMANEIO: Method to set the field value.
    */
  public void setCb_romaneio(String PARAM) {
    cb_romaneio = PARAM;
  }
  /**
    * MOSTRAR_FILIAIS_PRODUCAO: Method to get the field value.
    */
  public String getMostrar_filiais_producao() {
    return mostrar_filiais_producao;
  }
  /**
    * MOSTRAR_FILIAIS_PRODUCAO: Method to set the field value.
    */
  public void setMostrar_filiais_producao(String PARAM) {
    mostrar_filiais_producao = PARAM;
  }
  /**
    * CB_GRADE_CORRUGADO: Method to get the field value.
    */
  public String getCb_grade_corrugado() {
    return cb_grade_corrugado;
  }
  /**
    * CB_GRADE_CORRUGADO: Method to set the field value.
    */
  public void setCb_grade_corrugado(String PARAM) {
    cb_grade_corrugado = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    rep_cdgo = null;
    rep_rzao = null;
    codigo_regional = null;
    nome_regional = null;
    cli_cdgo = null;
    cli_rzao = null;
    esc_seqn = null;
    nro_normativa = null;
    descricao = null;
    gre_grupo = null;
    gre_descricao = null;
    ped_nmro = null;
    ano_fatura = null;
    numero_fatura = null;
    nf_numero = null;
    nf_serie = null;
    ped_ped_cliente = null;
    fil_filial = null;
    fil_razsoc = null;
    local_estoque = null;
    codigo_marca = null;
    especie = null;
    tipo_produto = null;
    tipo_pedido = null;
    ped_stat = null;
    tipo_mercado = null;
    dt_inicial = null;
    dt_final = null;
    dt_ent_inicial = null;
    dt_ent_final = null;
    ordem = null;
    cb_regional = null;
    cb_grupo_economico = null;
    cb_cliente = null;
    cb_representante = null;
    cb_pedido = null;
    cb_situacao = null;
    cb_tipo_pedido = null;
    cb_oc = null;
    cb_linha = null;
    cb_etiquetas = null;
    cb_obs = null;
    cb_pares = null;
    cb_rem = null;
    cb_fl_prod = null;
    cb_fl_fat = null;
    cb_digit = null;
    cb_fat_cli = null;
    cb_fat_br = null;
    cb_marca = null;
    cb_carimbo = null;
    cb_rotulos = null;
    cb_ped_amostra = null;
    cb_dt_envio = null;
    cb_agenda = null;
    cb_dezena = null;
    cb_dia = null;
    cb_dt_efetiva = null;
    cb_hora = null;
    cb_senha = null;
    cb_emissao = null;
    cb_filial = null;
    cb_nf = null;
    cb_volumes = null;
    cb_dt_inspecao = null;
    cb_dt_montagem = null;
    cb_dt_entrega_etiqueta = null;
    cb_especie = null;
    possui_dados = null;
    cb_possui_carimbo = null;
    cb_somente_etiqueta = null;
    cb_etiquetas_pendentes = null;
    cb_somente_amostra = null;
    dt_nf_inicial = null;
    dt_nf_final = null;
    cb_empenhado_completo = null;
    etiquetas = null;
    remessa = null;
    cb_portao_entrega = null;
    cb_cd_entrega = null;
    cb_dt_entrega = null;
    cb_amostra_brinde = null;
    cb_encarte = null;
    cb_prioridade_embarque = null;
    cb_dt_rec_etiqueta_filial = null;
    cb_cabide = null;
    cb_atacado = null;
    atacado = null;
    dt_agend_inicial = null;
    dt_agend_final = null;
    tra_cdgo = null;
    tra_nome = null;
    cb_etiquetas_pendentes_industrial = null;
    ite_situ = null;
    linha = null;
    cb_subtotal_grupo_economico = null;
    dt_emiss_ini = null;
    dt_emiss_fim = null;
    gerar_planilha = null;
    gerar_planilha_subtotal = null;
    dt_corte_inicial = null;
    dt_corte_final = null;
    somente_consulta = null;
    distribuicao = null;
    cb_desc_com = null;
    cb_desc_prom = null;
    cb_desc_pont = null;
    cb_cnd_cdgo = null;
    cb_invoice = null;
    cb_valor = null;
    cb_mini_fabrica = null;
    cb_portao_embarque = null;
    cb_dt_faturamento = null;
    cb_volumes1 = null;
    cb_previsao = null;
    cb_dt_ultima_ocorrencia = null;
    cb_atacado1 = null;
    cb_seq = null;
    cb_razao_social = null;
    cb_cidade = null;
    cb_loja = null;
    cb_obs_pedido = null;
    cb_data_bloqueio = null;
    cb_data_prevista_desbloqueio = null;
    cb_dt_solicitacao_alarme = null;
    cb_dt_recebimento_alarme = null;
    cb_dt_recebimento_alarme_filial = null;
    cb_nota_fiscal_alarme = null;
    cb_distribuicao = null;
    cb_normativa_cliente = null;
    cb_emiss = null;
    cb_bloqueio_49 = null;
    cb_alerta_etiqueta = null;
    cb_livro = null;
    cb_tra_cdgo = null;
    cb_dt_corte = null;
    cb_bloqueado_credito = null;
    preco_pdv = null;
    cb_certificado_origem = null;
    referencia = null;
    cb_descricao_item = null;
    cb_bloqueio_uf = null;
    cb_tipo_estoque = null;
    cb_data_etiquetagem = null;
    cb_gerar_requisicao = null;
    cb_local_estoque = null;
    cb_descricao = null;
    descricao_embalagem = null;
    cb_descricao_embalagem = null;
    cb_cnpj = null;
    cb_romaneio = null;
    mostrar_filiais_producao = null;
    cb_grade_corrugado = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
