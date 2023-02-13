package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/12/2007 07:44:14
 * Last Modify Date 22/06/2015 13:33:56
 */

public class Dev0002ActionForm extends org.apache.struts.action.ActionForm
{
  public String situacao;
  public String marca;
  public String tipo_preco;
  public String nfs_nmro;
  public String fil_filial;
  public String fil_razsoc;
  public String livro_alternativo;
  public String atraso_fim;
  public String atraso;
  public String reg;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String unn_codigo;
  public String unn_descri;
  public String cli_cdgo;
  public String cli_rzao;
  public String gre_grupo;
  public String gre_descricao;
  public String exibe_cliente;
  public String exibe_rep;
  public String lin_cdgo;
  public String lin_nome;
  public String aberto_fechado;
  public String tra_cdgo;
  public String tra_nome;
  public String tipo_relatorio;
  public String cb_agrupado;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public Dev0002ActionForm() {
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
  private Vector situacaoList = new Vector(10, 10);
  public void setSituacaoList(java.util.Vector VECTOR) {
    situacaoList = VECTOR;
  }
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList = new Vector(10, 10);
      situacaoLabelList = new Vector(10, 10);
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Situacoes_devolucoes db_object = new portalbr.dbobj.table.Situacoes_devolucoes();
        String[][] select = {{"codigo", null},{"descricao", null}};
        Object[][] where = null;
        String[] order = {"descricao"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (portalbr.dbobj.table.Situacoes_devolucoes) results.elementAt(i);
          situacaoList.addElement(""+db_object.getCodigo());
          situacaoLabelList.addElement(""+db_object.getDescricao());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Dev0002.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return situacaoList;
  }
  private java.util.Vector situacaoLabelList = new Vector(10, 10);
  public void setSituacaoLabelList(java.util.Vector VECTOR) {
    situacaoLabelList = VECTOR;
  }
  public java.util.Vector getSituacaoLabelList() {
    return situacaoLabelList;
  }
  /**
    * MARCA: Method to get the field value.
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Method to set the field value.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  private Vector marcaList = new Vector(10, 10);
  public void setMarcaList(java.util.Vector VECTOR) {
    marcaList = VECTOR;
  }
  public java.util.Vector getMarcaList() {
    if (marcaList == null || marcaList.size() == 0) {
      marcaList = new Vector(10, 10);
      marcaLabelList = new Vector(10, 10);
      marcaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      marcaLabelList.addElement("Todas");
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
          marcaList.addElement(""+db_object.getCodigo_marca());
          marcaLabelList.addElement(""+db_object.getDescricao_marca());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Dev0002.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return marcaList;
  }
  private java.util.Vector marcaLabelList = new Vector(10, 10);
  public void setMarcaLabelList(java.util.Vector VECTOR) {
    marcaLabelList = VECTOR;
  }
  public java.util.Vector getMarcaLabelList() {
    return marcaLabelList;
  }
  /**
    * TIPO_PRECO: Method to get the field value.
    */
  public String getTipo_preco() {
    return tipo_preco;
  }
  /**
    * TIPO_PRECO: Method to set the field value.
    */
  public void setTipo_preco(String PARAM) {
    tipo_preco = PARAM;
  }
  private Vector tipo_precoList = new Vector(10, 10);
  public void setTipo_precoList(java.util.Vector VECTOR) {
    tipo_precoList = VECTOR;
  }
  public java.util.Vector getTipo_precoList() {
    if (tipo_precoList == null || tipo_precoList.size() == 0) {
      tipo_precoList = new Vector(10, 10);
      tipo_precoLabelList = new Vector(10, 10);
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Livro db_object = new portalbr.dbobj.table.Livro();
        String[][] select = {{"liv_codigo", null},{"liv_descri", null}};
        Object[][] where = null;
        String[] order = {"liv_descri"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        tipo_precoList.addElement("-2");
        tipo_precoLabelList.addElement("Preço da NF");
        tipo_precoList.addElement("-1");
        tipo_precoLabelList.addElement("Sem Preço");
        for (int i = 0; i < results.size(); i++) {
          db_object = (portalbr.dbobj.table.Livro) results.elementAt(i);
          tipo_precoList.addElement(""+db_object.getLiv_codigo());
          tipo_precoLabelList.addElement(""+db_object.getLiv_descri());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Dev0002.", e);
      } finally {
        if (j != null) {
          j.close();
          j = null;
        }
      }
    }
    return tipo_precoList;
  }
  private java.util.Vector tipo_precoLabelList = new Vector(10, 10);
  public void setTipo_precoLabelList(java.util.Vector VECTOR) {
    tipo_precoLabelList = VECTOR;
  }
  public java.util.Vector getTipo_precoLabelList() {
    return tipo_precoLabelList;
  }
  /**
    * NFS_NMRO: Method to get the field value.
    */
  public String getNfs_nmro() {
    return nfs_nmro;
  }
  /**
    * NFS_NMRO: Method to set the field value.
    */
  public void setNfs_nmro(String PARAM) {
    nfs_nmro = PARAM;
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

  public String[][] getFil_razsoc_Ajax(Dev0002ActionForm PARAM) {
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
    * LIVRO_ALTERNATIVO: Method to get the field value.
    */
  public String getLivro_alternativo() {
    return livro_alternativo;
  }
  /**
    * LIVRO_ALTERNATIVO: Method to set the field value.
    */
  public void setLivro_alternativo(String PARAM) {
    livro_alternativo = PARAM;
  }
  Vector livro_alternativoList = new Vector(10, 1);
  public java.util.Vector getLivro_alternativoList() {
    if (livro_alternativoList == null || livro_alternativoList.size() == 0) {
      livro_alternativoList.addElement("94");
      livro_alternativoLabelList.addElement("Sim");
      livro_alternativoList.addElement("0");
      livro_alternativoLabelList.addElement("Não");
    }
    java.util.Vector list = livro_alternativoList;
    return list;
  }
  java.util.Vector livro_alternativoLabelList = new Vector(10, 1);
  public java.util.Vector getLivro_alternativoLabelList() {
    java.util.Vector list = livro_alternativoLabelList;
    return list;
  }
  /**
    * ATRASO_FIM: Method to get the field value.
    */
  public String getAtraso_fim() {
    return atraso_fim;
  }
  /**
    * ATRASO_FIM: Method to set the field value.
    */
  public void setAtraso_fim(String PARAM) {
    atraso_fim = PARAM;
  }
  /**
    * ATRASO: Method to get the field value.
    */
  public String getAtraso() {
    return atraso;
  }
  /**
    * ATRASO: Method to set the field value.
    */
  public void setAtraso(String PARAM) {
    atraso = PARAM;
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
    * NOME_REGIONAL: Method to get the field value.
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (reg != null && reg.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = {{"nome_regional",null}};
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(reg)} };
        java.util.Vector results = j.select(db_object, select, where, null, null, null);
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

  public String[][] getNome_regional_Ajax(Dev0002ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getReg() != null && PARAM.getReg().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getReg()} };
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

  public String[][] getRep_rzao_Ajax(Dev0002ActionForm PARAM) {
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
    * UNN_CODIGO: Method to get the field value.
    */
  public String getUnn_codigo() {
    return unn_codigo;
  }
  /**
    * UNN_CODIGO: Method to set the field value.
    */
  public void setUnn_codigo(String PARAM) {
    unn_codigo = PARAM;
  }
  /**
    * UNN_DESCRI: Method to get the field value.
    */
  public String getUnn_descri() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (unn_codigo != null && unn_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Uni_negocio db_object = new Uni_negocio();
        String[][] select = {{"unn_descri",null}};
        Object[][] where = { {"unn_codigo","like",unn_codigo} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Uni_negocio) results.elementAt(0);
          unn_descri = (db_object.getUnn_descri() != null) ? db_object.getUnn_descri() + "":"";
        } else {
          unn_descri = "";
        }
      }
    } catch (Exception e) {
      unn_descri = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return unn_descri;
  }

  public String[][] getUnn_descri_Ajax(Dev0002ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getUnn_codigo() != null && PARAM.getUnn_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Uni_negocio db_object = new Uni_negocio();
        Object[][] where = { {"unn_codigo","like",PARAM.getUnn_codigo()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Uni_negocio) results.elementAt(0);
          list[0] = new String[]{"unn_descri", (db_object.getUnn_descri() != null) ? db_object.getUnn_descri() + "":""};
        } else {
          list[0] = new String[]{"unn_descri", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"unn_descri", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * UNN_DESCRI: Method to set the field value.
    */
  public void setUnn_descri(String PARAM) {
    unn_descri = PARAM;
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

  public String[][] getCli_rzao_Ajax(Dev0002ActionForm PARAM) {
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

  public String[][] getGre_descricao_Ajax(Dev0002ActionForm PARAM) {
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
    * EXIBE_CLIENTE: Method to get the field value.
    */
  public String getExibe_cliente() {
    return exibe_cliente;
  }
  /**
    * EXIBE_CLIENTE: Method to set the field value.
    */
  public void setExibe_cliente(String PARAM) {
    exibe_cliente = PARAM;
  }
  Vector exibe_clienteList = new Vector(10, 1);
  public java.util.Vector getExibe_clienteList() {
    if (exibe_clienteList == null || exibe_clienteList.size() == 0) {
      exibe_clienteList.addElement("S");
      exibe_clienteLabelList.addElement("Sim");
      exibe_clienteList.addElement("N");
      exibe_clienteLabelList.addElement("Não");
    }
    java.util.Vector list = exibe_clienteList;
    return list;
  }
  java.util.Vector exibe_clienteLabelList = new Vector(10, 1);
  public java.util.Vector getExibe_clienteLabelList() {
    java.util.Vector list = exibe_clienteLabelList;
    return list;
  }
  /**
    * EXIBE_REP: Method to get the field value.
    */
  public String getExibe_rep() {
    return exibe_rep;
  }
  /**
    * EXIBE_REP: Method to set the field value.
    */
  public void setExibe_rep(String PARAM) {
    exibe_rep = PARAM;
  }
  Vector exibe_repList = new Vector(10, 1);
  public java.util.Vector getExibe_repList() {
    if (exibe_repList == null || exibe_repList.size() == 0) {
      exibe_repList.addElement("S");
      exibe_repLabelList.addElement("Sim");
      exibe_repList.addElement("N");
      exibe_repLabelList.addElement("Não");
    }
    java.util.Vector list = exibe_repList;
    return list;
  }
  java.util.Vector exibe_repLabelList = new Vector(10, 1);
  public java.util.Vector getExibe_repLabelList() {
    java.util.Vector list = exibe_repLabelList;
    return list;
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

  public String[][] getLin_nome_Ajax(Dev0002ActionForm PARAM) {
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
    * ABERTO_FECHADO: Method to get the field value.
    */
  public String getAberto_fechado() {
    return aberto_fechado;
  }
  /**
    * ABERTO_FECHADO: Method to set the field value.
    */
  public void setAberto_fechado(String PARAM) {
    aberto_fechado = PARAM;
  }
  Vector aberto_fechadoList = new Vector(10, 1);
  public java.util.Vector getAberto_fechadoList() {
    if (aberto_fechadoList == null || aberto_fechadoList.size() == 0) {
      aberto_fechadoList.addElement("t");
      aberto_fechadoLabelList.addElement("Todos");
      aberto_fechadoList.addElement("a");
      aberto_fechadoLabelList.addElement("Aberto");
      aberto_fechadoList.addElement("f");
      aberto_fechadoLabelList.addElement("Fechado");
    }
    java.util.Vector list = aberto_fechadoList;
    return list;
  }
  java.util.Vector aberto_fechadoLabelList = new Vector(10, 1);
  public java.util.Vector getAberto_fechadoLabelList() {
    java.util.Vector list = aberto_fechadoLabelList;
    return list;
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

  public String[][] getTra_nome_Ajax(Dev0002ActionForm PARAM) {
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
    * TIPO_RELATORIO: Method to get the field value.
    */
  public String getTipo_relatorio() {
    return tipo_relatorio;
  }
  /**
    * TIPO_RELATORIO: Method to set the field value.
    */
  public void setTipo_relatorio(String PARAM) {
    tipo_relatorio = PARAM;
  }
  Vector tipo_relatorioList = new Vector(10, 1);
  public java.util.Vector getTipo_relatorioList() {
    if (tipo_relatorioList == null || tipo_relatorioList.size() == 0) {
      tipo_relatorioList.addElement("pdf");
      tipo_relatorioLabelList.addElement("PDF");
      tipo_relatorioList.addElement("excel");
      tipo_relatorioLabelList.addElement("EXCEL");
    }
    java.util.Vector list = tipo_relatorioList;
    return list;
  }
  java.util.Vector tipo_relatorioLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_relatorioLabelList() {
    java.util.Vector list = tipo_relatorioLabelList;
    return list;
  }
  /**
    * CB_AGRUPADO: Method to get the field value.
    */
  public String getCb_agrupado() {
    return cb_agrupado;
  }
  /**
    * CB_AGRUPADO: Method to set the field value.
    */
  public void setCb_agrupado(String PARAM) {
    cb_agrupado = PARAM;
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
    situacao = null;
    marca = null;
    tipo_preco = null;
    nfs_nmro = null;
    fil_filial = null;
    fil_razsoc = null;
    livro_alternativo = null;
    atraso_fim = null;
    atraso = null;
    reg = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    unn_codigo = null;
    unn_descri = null;
    cli_cdgo = null;
    cli_rzao = null;
    gre_grupo = null;
    gre_descricao = null;
    exibe_cliente = null;
    exibe_rep = null;
    lin_cdgo = null;
    lin_nome = null;
    aberto_fechado = null;
    tra_cdgo = null;
    tra_nome = null;
    tipo_relatorio = null;
    cb_agrupado = null;
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
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
