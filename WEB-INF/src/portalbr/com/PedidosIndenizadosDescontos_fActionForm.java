package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 01/04/2011 09:52:19
 * Last Modify Date 10/01/2020 11:08:21
 */

public class PedidosIndenizadosDescontos_fActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String cli_cdgo;
  public String cli_rzao;
  public String gre_grupo;
  public String gre_descricao;
  public String lin_cdgo;
  public String lin_descricao;
  public String ref_cdgo;
  public String ref_descricao;
  public String cab_cdgo;
  public String cab_descricao;
  public String data_inicial;
  public String data_final;
  public String marcas;
  public String situacao;
  public String status;
  public String cb_faturados;
  public String ped_nmro;
  private boolean valida = false;
  public PedidosIndenizadosDescontos_fActionForm() {
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

  public String[][] getNome_regional_Ajax(PedidosIndenizadosDescontos_fActionForm PARAM) {
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

  public String[][] getRep_rzao_Ajax(PedidosIndenizadosDescontos_fActionForm PARAM) {
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

  public String[][] getCli_rzao_Ajax(PedidosIndenizadosDescontos_fActionForm PARAM) {
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

  public String[][] getGre_descricao_Ajax(PedidosIndenizadosDescontos_fActionForm PARAM) {
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
    * LIN_DESCRICAO: Method to get the field value.
    */
  public String getLin_descricao() {
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
          lin_descricao = ((db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"");
        } else {
          lin_descricao = "";
        }
      }
    } catch (Exception e) {
      lin_descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lin_descricao;
  }

  public String[][] getLin_descricao_Ajax(PedidosIndenizadosDescontos_fActionForm PARAM) {
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
          list[0] = new String[]{"lin_descricao", ((db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"")};
        } else {
          list[0] = new String[]{"lin_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIN_DESCRICAO: Method to set the field value.
    */
  public void setLin_descricao(String PARAM) {
    lin_descricao = PARAM;
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
    * REF_DESCRICAO: Method to get the field value.
    */
  public String getRef_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (ref_cdgo != null && ref_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        String[][] select = { {"ref_desc",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(lin_cdgo)}, {"ref_cdgo","=",com.egen.util.text.FormatNumber.toInteger(ref_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          ref_descricao = ((db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":"");
        } else {
          ref_descricao = "";
        }
      }
    } catch (Exception e) {
      ref_descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return ref_descricao;
  }

  public String[][] getRef_descricao_Ajax(PedidosIndenizadosDescontos_fActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRef_cdgo() != null && PARAM.getRef_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        Object[][] where = { {"lin_cdgo","=",PARAM.getLin_cdgo()}, {"ref_cdgo","=",PARAM.getRef_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          list[0] = new String[]{"ref_descricao", ((db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":"")};
        } else {
          list[0] = new String[]{"ref_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"ref_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REF_DESCRICAO: Method to set the field value.
    */
  public void setRef_descricao(String PARAM) {
    ref_descricao = PARAM;
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
    * CAB_DESCRICAO: Method to get the field value.
    */
  public String getCab_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cab_cdgo != null && cab_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        String[][] select = { {"cab_desc",null} };
        Object[][] where = { {"cab_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cab_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cabedal) results.elementAt(0);
          cab_descricao = ((db_object.getCab_desc() != null) ? db_object.getCab_desc() + "":"");
        } else {
          cab_descricao = "";
        }
      }
    } catch (Exception e) {
      cab_descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cab_descricao;
  }

  public String[][] getCab_descricao_Ajax(PedidosIndenizadosDescontos_fActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCab_cdgo() != null && PARAM.getCab_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        Object[][] where = { {"cab_cdgo","=",com.egen.util.text.FormatDate.parseTimestamp(PARAM.getCab_cdgo(), "dd/MM/yyyy")}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cabedal) results.elementAt(0);
          list[0] = new String[]{"cab_descricao", ((db_object.getCab_desc() != null) ? db_object.getCab_desc() + "":"")};
        } else {
          list[0] = new String[]{"cab_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cab_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CAB_DESCRICAO: Method to set the field value.
    */
  public void setCab_descricao(String PARAM) {
    cab_descricao = PARAM;
  }
  /**
    * DATA_INICIAL: Method to get the field value.
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Method to set the field value.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Method to get the field value.
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Method to set the field value.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * MARCAS: Method to get the field value.
    */
  public String getMarcas() {
    return marcas;
  }
  /**
    * MARCAS: Method to set the field value.
    */
  public void setMarcas(String PARAM) {
    marcas = PARAM;
  }
  private Vector marcasList = new Vector(10, 10);
  public void setMarcasList(java.util.Vector VECTOR) {
    marcasList = VECTOR;
  }
  public java.util.Vector getMarcasList() {
    if (marcasList == null || marcasList.size() == 0) {
      marcasList = new Vector(10, 10);
      marcasLabelList = new Vector(10, 10);
      marcasList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      marcasLabelList.addElement(bundle.getString("jsp.pleaseselect"));
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
          marcasList.addElement(""+db_object.getCodigo_marca());
          marcasLabelList.addElement(""+db_object.getDescricao_marca());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "PedidosIndenizadosDescontos_f.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return marcasList;
  }
  private java.util.Vector marcasLabelList = new Vector(10, 10);
  public void setMarcasLabelList(java.util.Vector VECTOR) {
    marcasLabelList = VECTOR;
  }
  public java.util.Vector getMarcasLabelList() {
    return marcasLabelList;
  }
  /**
    * SITUACAO: Method to get the field value.
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Method to set the field value.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  Vector situacaoList = new Vector(10, 1);
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList.addElement("N");
      situacaoLabelList.addElement("Não Indenizados");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("Indenizados");
      situacaoList.addElement("F");
      situacaoLabelList.addElement("Confirmado");
      situacaoList.addElement("C");
      situacaoLabelList.addElement("Cancelado");
    }
    java.util.Vector list = situacaoList;
    return list;
  }
  java.util.Vector situacaoLabelList = new Vector(10, 1);
  public java.util.Vector getSituacaoLabelList() {
    java.util.Vector list = situacaoLabelList;
    return list;
  }
  /**
    * STATUS: Method to get the field value.
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Method to set the field value.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  private Vector statusList = new Vector(10, 10);
  public void setStatusList(java.util.Vector VECTOR) {
    statusList = VECTOR;
  }
  public java.util.Vector getStatusList() {
    if (statusList == null || statusList.size() == 0) {
      statusList = new Vector(10, 10);
      statusLabelList = new Vector(10, 10);
      statusList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      statusLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
        Object[][] where = {{"rv_domain","=","PED_STAT"}};
        String[] order = {"rv_meaning"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          statusList.addElement(""+db_object.getRv_low_value());
          statusLabelList.addElement(""+db_object.getRv_meaning());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "PedidosIndenizadosDescontos_f.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return statusList;
  }
  private java.util.Vector statusLabelList = new Vector(10, 10);
  public void setStatusLabelList(java.util.Vector VECTOR) {
    statusLabelList = VECTOR;
  }
  public java.util.Vector getStatusLabelList() {
    return statusLabelList;
  }
  /**
    * CB_FATURADOS: Method to get the field value.
    */
  public String getCb_faturados() {
    return cb_faturados;
  }
  /**
    * CB_FATURADOS: Method to set the field value.
    */
  public void setCb_faturados(String PARAM) {
    cb_faturados = PARAM;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    cli_cdgo = null;
    cli_rzao = null;
    gre_grupo = null;
    gre_descricao = null;
    lin_cdgo = null;
    lin_descricao = null;
    ref_cdgo = null;
    ref_descricao = null;
    cab_cdgo = null;
    cab_descricao = null;
    data_inicial = null;
    data_final = null;
    marcas = null;
    situacao = null;
    status = null;
    cb_faturados = null;
    ped_nmro = null;
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
      if (com.egen.util.text.Validate.isNull(data_inicial)) {
        errors.add("data_inicial", new ActionMessage("error.validate.notnull","Dt. Digitação Inicial","data_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_final)) {
        errors.add("data_final", new ActionMessage("error.validate.notnull","Dt. Digitação Final","data_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(situacao)) {
        errors.add("situacao", new ActionMessage("error.validate.notnull","Situação","situacao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
