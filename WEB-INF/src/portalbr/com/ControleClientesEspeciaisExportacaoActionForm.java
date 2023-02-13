package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/02/2016 15:11:00
 * Last Modify Date 10/01/2018 13:35:45
 */

public class ControleClientesEspeciaisExportacaoActionForm extends org.apache.struts.action.ActionForm
{
  public String numero_fatura;
  public String ano_fatura;
  public String empresa_fatura;
  public String cli_cdgo;
  public String cli_rzao;
  public String esc_seqn;
  public String rep_cdgo;
  public String rep_rzao;
  public String codigo_regional;
  public String nome_regional;
  public String fil_filial;
  public String fil_razsoc;
  public String tra_cdgo;
  public String tra_nome;
  public String linha;
  public String codigo_marca;
  public String especie_fatura;
  public String ped_stat;
  public String dt_entrada_fatura_ini;
  public String dt_entrada_fatura_fim;
  public String dt_previsao_fat_ini;
  public String dt_previsao_fat_fim;
  public String dt_faturamento_ini;
  public String dt_faturamento_fim;
  public String dt_previsao_emb_ini;
  public String dt_previsao_emb_fim;
  public String dt_embarque_ini;
  public String dt_embarque_fim;
  public String dt_entrada_deposito_ini;
  public String dt_entrada_deposito_fim;
  public String cb_somente_deposito;
  public String cb_somente_embarcadas;
  public String cb_regional;
  public String cb_representante;
  public String cb_transportadora;
  public String cb_pais;
  public String cb_pares;
  public String cb_valor;
  public String cb_data_entrada_fatura;
  public String cb_dt_prev_fat;
  public String cb_dt_prev_emb;
  public String cb_dt_entrada_deposito;
  public String cb_data_embarque;
  public String cb_dias_deposito;
  public String cb_etiquetas;
  public String cb_dt_entrega_etiqueta;
  public String cb_dt_rec_etiqueta_fil;
  public String cb_dt_inspecao;
  public String cb_dt_emb_cargovision;
  public String cb_obs_fatura;
  public String cb_data_entrega_fatura;
  public String cb_numero_fatura_proforma;
  public String cb_especie_fatura;
  public String cb_status_fatura;
  public String cb_cliente;
  private boolean valida = false;
  public ControleClientesEspeciaisExportacaoActionForm() {
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
    * EMPRESA_FATURA: Method to get the field value.
    */
  public String getEmpresa_fatura() {
    return empresa_fatura;
  }
  /**
    * EMPRESA_FATURA: Method to set the field value.
    */
  public void setEmpresa_fatura(String PARAM) {
    empresa_fatura = PARAM;
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

  public String[][] getCli_rzao_Ajax(ControleClientesEspeciaisExportacaoActionForm PARAM) {
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

  public String[][] getRep_rzao_Ajax(ControleClientesEspeciaisExportacaoActionForm PARAM) {
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

  public String[][] getNome_regional_Ajax(ControleClientesEspeciaisExportacaoActionForm PARAM) {
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

  public String[][] getFil_razsoc_Ajax(ControleClientesEspeciaisExportacaoActionForm PARAM) {
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

  public String[][] getTra_nome_Ajax(ControleClientesEspeciaisExportacaoActionForm PARAM) {
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ControleClientesEspeciaisExportacao.", e);
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
    * ESPECIE_FATURA: Method to get the field value.
    */
  public String getEspecie_fatura() {
    return especie_fatura;
  }
  /**
    * ESPECIE_FATURA: Method to set the field value.
    */
  public void setEspecie_fatura(String PARAM) {
    especie_fatura = PARAM;
  }
  private Vector especie_faturaList = new Vector(10, 10);
  public void setEspecie_faturaList(java.util.Vector VECTOR) {
    especie_faturaList = VECTOR;
  }
  public java.util.Vector getEspecie_faturaList() {
    if (especie_faturaList == null || especie_faturaList.size() == 0) {
      especie_faturaList = new Vector(10, 10);
      especie_faturaLabelList = new Vector(10, 10);
      especie_faturaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      especie_faturaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
        Object[][] where = {{"rv_domain","=","ESPECIE_DM"}};
        String[] order = {"rv_low_value"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          especie_faturaList.addElement(""+db_object.getRv_low_value());
          especie_faturaLabelList.addElement(""+db_object.getRv_meaning());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ControleClientesEspeciaisExportacao.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return especie_faturaList;
  }
  private java.util.Vector especie_faturaLabelList = new Vector(10, 10);
  public void setEspecie_faturaLabelList(java.util.Vector VECTOR) {
    especie_faturaLabelList = VECTOR;
  }
  public java.util.Vector getEspecie_faturaLabelList() {
    return especie_faturaLabelList;
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
      ped_statLabelList.addElement("Selecionar");
      ped_statList.addElement("B");
      ped_statLabelList.addElement("B-Bloqueado");
      ped_statList.addElement("A");
      ped_statLabelList.addElement("A-Liberado para Produzir");
      ped_statList.addElement("P");
      ped_statLabelList.addElement("P-Em Produção");
      ped_statList.addElement("E");
      ped_statLabelList.addElement("E-Produzido");
      ped_statList.addElement("L");
      ped_statLabelList.addElement("L-Liberado para Faturar");
      ped_statList.addElement("F");
      ped_statLabelList.addElement("F-Faturado");
      ped_statList.addElement("T");
      ped_statLabelList.addElement("T-Transferência");
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
    * DT_ENTRADA_FATURA_INI: Method to get the field value.
    */
  public String getDt_entrada_fatura_ini() {
    return dt_entrada_fatura_ini;
  }
  /**
    * DT_ENTRADA_FATURA_INI: Method to set the field value.
    */
  public void setDt_entrada_fatura_ini(String PARAM) {
    dt_entrada_fatura_ini = PARAM;
  }
  /**
    * DT_ENTRADA_FATURA_FIM: Method to get the field value.
    */
  public String getDt_entrada_fatura_fim() {
    return dt_entrada_fatura_fim;
  }
  /**
    * DT_ENTRADA_FATURA_FIM: Method to set the field value.
    */
  public void setDt_entrada_fatura_fim(String PARAM) {
    dt_entrada_fatura_fim = PARAM;
  }
  /**
    * DT_PREVISAO_FAT_INI: Method to get the field value.
    */
  public String getDt_previsao_fat_ini() {
    return dt_previsao_fat_ini;
  }
  /**
    * DT_PREVISAO_FAT_INI: Method to set the field value.
    */
  public void setDt_previsao_fat_ini(String PARAM) {
    dt_previsao_fat_ini = PARAM;
  }
  /**
    * DT_PREVISAO_FAT_FIM: Method to get the field value.
    */
  public String getDt_previsao_fat_fim() {
    return dt_previsao_fat_fim;
  }
  /**
    * DT_PREVISAO_FAT_FIM: Method to set the field value.
    */
  public void setDt_previsao_fat_fim(String PARAM) {
    dt_previsao_fat_fim = PARAM;
  }
  /**
    * DT_FATURAMENTO_INI: Method to get the field value.
    */
  public String getDt_faturamento_ini() {
    return dt_faturamento_ini;
  }
  /**
    * DT_FATURAMENTO_INI: Method to set the field value.
    */
  public void setDt_faturamento_ini(String PARAM) {
    dt_faturamento_ini = PARAM;
  }
  /**
    * DT_FATURAMENTO_FIM: Method to get the field value.
    */
  public String getDt_faturamento_fim() {
    return dt_faturamento_fim;
  }
  /**
    * DT_FATURAMENTO_FIM: Method to set the field value.
    */
  public void setDt_faturamento_fim(String PARAM) {
    dt_faturamento_fim = PARAM;
  }
  /**
    * DT_PREVISAO_EMB_INI: Method to get the field value.
    */
  public String getDt_previsao_emb_ini() {
    return dt_previsao_emb_ini;
  }
  /**
    * DT_PREVISAO_EMB_INI: Method to set the field value.
    */
  public void setDt_previsao_emb_ini(String PARAM) {
    dt_previsao_emb_ini = PARAM;
  }
  /**
    * DT_PREVISAO_EMB_FIM: Method to get the field value.
    */
  public String getDt_previsao_emb_fim() {
    return dt_previsao_emb_fim;
  }
  /**
    * DT_PREVISAO_EMB_FIM: Method to set the field value.
    */
  public void setDt_previsao_emb_fim(String PARAM) {
    dt_previsao_emb_fim = PARAM;
  }
  /**
    * DT_EMBARQUE_INI: Method to get the field value.
    */
  public String getDt_embarque_ini() {
    return dt_embarque_ini;
  }
  /**
    * DT_EMBARQUE_INI: Method to set the field value.
    */
  public void setDt_embarque_ini(String PARAM) {
    dt_embarque_ini = PARAM;
  }
  /**
    * DT_EMBARQUE_FIM: Method to get the field value.
    */
  public String getDt_embarque_fim() {
    return dt_embarque_fim;
  }
  /**
    * DT_EMBARQUE_FIM: Method to set the field value.
    */
  public void setDt_embarque_fim(String PARAM) {
    dt_embarque_fim = PARAM;
  }
  /**
    * DT_ENTRADA_DEPOSITO_INI: Method to get the field value.
    */
  public String getDt_entrada_deposito_ini() {
    return dt_entrada_deposito_ini;
  }
  /**
    * DT_ENTRADA_DEPOSITO_INI: Method to set the field value.
    */
  public void setDt_entrada_deposito_ini(String PARAM) {
    dt_entrada_deposito_ini = PARAM;
  }
  /**
    * DT_ENTRADA_DEPOSITO_FIM: Method to get the field value.
    */
  public String getDt_entrada_deposito_fim() {
    return dt_entrada_deposito_fim;
  }
  /**
    * DT_ENTRADA_DEPOSITO_FIM: Method to set the field value.
    */
  public void setDt_entrada_deposito_fim(String PARAM) {
    dt_entrada_deposito_fim = PARAM;
  }
  /**
    * CB_SOMENTE_DEPOSITO: Method to get the field value.
    */
  public String getCb_somente_deposito() {
    return cb_somente_deposito;
  }
  /**
    * CB_SOMENTE_DEPOSITO: Method to set the field value.
    */
  public void setCb_somente_deposito(String PARAM) {
    cb_somente_deposito = PARAM;
  }
  /**
    * CB_SOMENTE_EMBARCADAS: Method to get the field value.
    */
  public String getCb_somente_embarcadas() {
    return cb_somente_embarcadas;
  }
  /**
    * CB_SOMENTE_EMBARCADAS: Method to set the field value.
    */
  public void setCb_somente_embarcadas(String PARAM) {
    cb_somente_embarcadas = PARAM;
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
    * CB_TRANSPORTADORA: Method to get the field value.
    */
  public String getCb_transportadora() {
    return cb_transportadora;
  }
  /**
    * CB_TRANSPORTADORA: Method to set the field value.
    */
  public void setCb_transportadora(String PARAM) {
    cb_transportadora = PARAM;
  }
  /**
    * CB_PAIS: Method to get the field value.
    */
  public String getCb_pais() {
    return cb_pais;
  }
  /**
    * CB_PAIS: Method to set the field value.
    */
  public void setCb_pais(String PARAM) {
    cb_pais = PARAM;
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
    * CB_DATA_ENTRADA_FATURA: Method to get the field value.
    */
  public String getCb_data_entrada_fatura() {
    return cb_data_entrada_fatura;
  }
  /**
    * CB_DATA_ENTRADA_FATURA: Method to set the field value.
    */
  public void setCb_data_entrada_fatura(String PARAM) {
    cb_data_entrada_fatura = PARAM;
  }
  /**
    * CB_DT_PREV_FAT: Method to get the field value.
    */
  public String getCb_dt_prev_fat() {
    return cb_dt_prev_fat;
  }
  /**
    * CB_DT_PREV_FAT: Method to set the field value.
    */
  public void setCb_dt_prev_fat(String PARAM) {
    cb_dt_prev_fat = PARAM;
  }
  /**
    * CB_DT_PREV_EMB: Method to get the field value.
    */
  public String getCb_dt_prev_emb() {
    return cb_dt_prev_emb;
  }
  /**
    * CB_DT_PREV_EMB: Method to set the field value.
    */
  public void setCb_dt_prev_emb(String PARAM) {
    cb_dt_prev_emb = PARAM;
  }
  /**
    * CB_DT_ENTRADA_DEPOSITO: Method to get the field value.
    */
  public String getCb_dt_entrada_deposito() {
    return cb_dt_entrada_deposito;
  }
  /**
    * CB_DT_ENTRADA_DEPOSITO: Method to set the field value.
    */
  public void setCb_dt_entrada_deposito(String PARAM) {
    cb_dt_entrada_deposito = PARAM;
  }
  /**
    * CB_DATA_EMBARQUE: Method to get the field value.
    */
  public String getCb_data_embarque() {
    return cb_data_embarque;
  }
  /**
    * CB_DATA_EMBARQUE: Method to set the field value.
    */
  public void setCb_data_embarque(String PARAM) {
    cb_data_embarque = PARAM;
  }
  /**
    * CB_DIAS_DEPOSITO: Method to get the field value.
    */
  public String getCb_dias_deposito() {
    return cb_dias_deposito;
  }
  /**
    * CB_DIAS_DEPOSITO: Method to set the field value.
    */
  public void setCb_dias_deposito(String PARAM) {
    cb_dias_deposito = PARAM;
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
    * CB_DT_REC_ETIQUETA_FIL: Method to get the field value.
    */
  public String getCb_dt_rec_etiqueta_fil() {
    return cb_dt_rec_etiqueta_fil;
  }
  /**
    * CB_DT_REC_ETIQUETA_FIL: Method to set the field value.
    */
  public void setCb_dt_rec_etiqueta_fil(String PARAM) {
    cb_dt_rec_etiqueta_fil = PARAM;
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
    * CB_DT_EMB_CARGOVISION: Method to get the field value.
    */
  public String getCb_dt_emb_cargovision() {
    return cb_dt_emb_cargovision;
  }
  /**
    * CB_DT_EMB_CARGOVISION: Method to set the field value.
    */
  public void setCb_dt_emb_cargovision(String PARAM) {
    cb_dt_emb_cargovision = PARAM;
  }
  /**
    * CB_OBS_FATURA: Method to get the field value.
    */
  public String getCb_obs_fatura() {
    return cb_obs_fatura;
  }
  /**
    * CB_OBS_FATURA: Method to set the field value.
    */
  public void setCb_obs_fatura(String PARAM) {
    cb_obs_fatura = PARAM;
  }
  /**
    * CB_DATA_ENTREGA_FATURA: Method to get the field value.
    */
  public String getCb_data_entrega_fatura() {
    return cb_data_entrega_fatura;
  }
  /**
    * CB_DATA_ENTREGA_FATURA: Method to set the field value.
    */
  public void setCb_data_entrega_fatura(String PARAM) {
    cb_data_entrega_fatura = PARAM;
  }
  /**
    * CB_NUMERO_FATURA_PROFORMA: Method to get the field value.
    */
  public String getCb_numero_fatura_proforma() {
    return cb_numero_fatura_proforma;
  }
  /**
    * CB_NUMERO_FATURA_PROFORMA: Method to set the field value.
    */
  public void setCb_numero_fatura_proforma(String PARAM) {
    cb_numero_fatura_proforma = PARAM;
  }
  /**
    * CB_ESPECIE_FATURA: Method to get the field value.
    */
  public String getCb_especie_fatura() {
    return cb_especie_fatura;
  }
  /**
    * CB_ESPECIE_FATURA: Method to set the field value.
    */
  public void setCb_especie_fatura(String PARAM) {
    cb_especie_fatura = PARAM;
  }
  /**
    * CB_STATUS_FATURA: Method to get the field value.
    */
  public String getCb_status_fatura() {
    return cb_status_fatura;
  }
  /**
    * CB_STATUS_FATURA: Method to set the field value.
    */
  public void setCb_status_fatura(String PARAM) {
    cb_status_fatura = PARAM;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    numero_fatura = null;
    ano_fatura = null;
    empresa_fatura = null;
    cli_cdgo = null;
    cli_rzao = null;
    esc_seqn = null;
    rep_cdgo = null;
    rep_rzao = null;
    codigo_regional = null;
    nome_regional = null;
    fil_filial = null;
    fil_razsoc = null;
    tra_cdgo = null;
    tra_nome = null;
    linha = null;
    codigo_marca = null;
    especie_fatura = null;
    ped_stat = null;
    dt_entrada_fatura_ini = null;
    dt_entrada_fatura_fim = null;
    dt_previsao_fat_ini = null;
    dt_previsao_fat_fim = null;
    dt_faturamento_ini = null;
    dt_faturamento_fim = null;
    dt_previsao_emb_ini = null;
    dt_previsao_emb_fim = null;
    dt_embarque_ini = null;
    dt_embarque_fim = null;
    dt_entrada_deposito_ini = null;
    dt_entrada_deposito_fim = null;
    cb_somente_deposito = null;
    cb_somente_embarcadas = null;
    cb_regional = null;
    cb_representante = null;
    cb_transportadora = null;
    cb_pais = null;
    cb_pares = null;
    cb_valor = null;
    cb_data_entrada_fatura = null;
    cb_dt_prev_fat = null;
    cb_dt_prev_emb = null;
    cb_dt_entrada_deposito = null;
    cb_data_embarque = null;
    cb_dias_deposito = null;
    cb_etiquetas = null;
    cb_dt_entrega_etiqueta = null;
    cb_dt_rec_etiqueta_fil = null;
    cb_dt_inspecao = null;
    cb_dt_emb_cargovision = null;
    cb_obs_fatura = null;
    cb_data_entrega_fatura = null;
    cb_numero_fatura_proforma = null;
    cb_especie_fatura = null;
    cb_status_fatura = null;
    cb_cliente = null;
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
