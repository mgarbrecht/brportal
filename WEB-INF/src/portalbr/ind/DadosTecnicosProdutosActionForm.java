package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/05/2012 14:54:32
 * Last Modify Date 03/08/2022 10:27:20
 */

public class DadosTecnicosProdutosActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo_relatorio;
  public String gre_grupo;
  public String gre_descricao;
  public String cli_cdgo;
  public String cli_rzao;
  public String lin_cdgo;
  public String lin_nome;
  public String ref_cdgo;
  public String ref_desc;
  public String cab_cdgo;
  public String cab_desc;
  public String cor_cdgo;
  public String cor_desc;
  public String mix_produtos;
  public String marca;
  public String tipo;
  public String ped_dadg_inicial;
  public String ped_dadg_final;
  public String ano_fatura;
  public String numero_fatura;
  public String pedidos;
  public String ocs;
  public String cb_tamanhos_pedidos;
  public String gerar_planilha;
  private boolean valida = false;
  public DadosTecnicosProdutosActionForm() {
  }
  /**
    * TIPO_RELATORIO: Método Gets para este campo
    */
  public String getTipo_relatorio() {
    return tipo_relatorio;
  }
  /**
    * TIPO_RELATORIO: Método Sets pára este campo.
    */
  public void setTipo_relatorio(String PARAM) {
    tipo_relatorio = PARAM;
  }
  Vector tipo_relatorioList = new Vector(10, 1);
  public java.util.Vector getTipo_relatorioList() {
    if (tipo_relatorioList == null || tipo_relatorioList.size() == 0) {
      tipo_relatorioList.addElement("produto");
      tipo_relatorioLabelList.addElement("Por Produto");
      tipo_relatorioList.addElement("pedido");
      tipo_relatorioLabelList.addElement("Por Pedido");
      tipo_relatorioList.addElement("catalogo");
      tipo_relatorioLabelList.addElement("Por Catálogo");
      tipo_relatorioList.addElement("fatura");
      tipo_relatorioLabelList.addElement("Por Fatura");
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

  public String[][] getGre_descricao_Ajax(DadosTecnicosProdutosActionForm PARAM) {
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

  public String[][] getCli_rzao_Ajax(DadosTecnicosProdutosActionForm PARAM) {
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

  public String[][] getLin_nome_Ajax(DadosTecnicosProdutosActionForm PARAM) {
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
    * REF_CDGO: Método Gets para este campo
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Método Sets pára este campo.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * REF_DESC: Método Gets para este campo
    */
  public String getRef_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0 && ref_cdgo != null && ref_cdgo.length() > 0) {
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
          ref_desc = (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":"";
        } else {
          ref_desc = "";
        }
      }
    } catch (Exception e) {
      ref_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return ref_desc;
  }

  public String[][] getRef_desc_Ajax(DadosTecnicosProdutosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0 && PARAM.getRef_cdgo() != null && PARAM.getRef_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        Object[][] where = { {"lin_cdgo","=",PARAM.getLin_cdgo()}, {"ref_cdgo","=",PARAM.getRef_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          list[0] = new String[]{"ref_desc", (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":""};
        } else {
          list[0] = new String[]{"ref_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"ref_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REF_DESC: Método Sets pára este campo.
    */
  public void setRef_desc(String PARAM) {
    ref_desc = PARAM;
  }
  /**
    * CAB_CDGO: Método Gets para este campo
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Método Sets pára este campo.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  /**
    * CAB_DESC: Método Gets para este campo
    */
  public String getCab_desc() {
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
          cab_desc = (db_object.getCab_desc() != null) ? db_object.getCab_desc() + "":"";
        } else {
          cab_desc = "";
        }
      }
    } catch (Exception e) {
      cab_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cab_desc;
  }

  public String[][] getCab_desc_Ajax(DadosTecnicosProdutosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCab_cdgo() != null && PARAM.getCab_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        Object[][] where = { {"cab_cdgo","=", PARAM.getCab_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cabedal) results.elementAt(0);
          list[0] = new String[]{"cab_desc", (db_object.getCab_desc() != null) ? db_object.getCab_desc() + "":""};
        } else {
          list[0] = new String[]{"cab_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cab_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CAB_DESC: Método Sets pára este campo.
    */
  public void setCab_desc(String PARAM) {
    cab_desc = PARAM;
  }
  /**
    * COR_CDGO: Método Gets para este campo
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Método Sets pára este campo.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * COR_DESC: Método Gets para este campo
    */
  public String getCor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cor_cdgo != null && cor_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        String[][] select = { {"cor_desc",null} };
        Object[][] where = { {"cor_cdgo","=",com.egen.util.text.FormatNumber.toInt(cor_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cor) results.elementAt(0);
          cor_desc = (db_object.getCor_desc() != null) ? db_object.getCor_desc() + "":"";
        } else {
          cor_desc = "";
        }
      }
    } catch (Exception e) {
      cor_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cor_desc;
  }

  public String[][] getCor_desc_Ajax(DadosTecnicosProdutosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCor_cdgo() != null && PARAM.getCor_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        Object[][] where = { {"cor_cdgo","like",PARAM.getCor_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cor) results.elementAt(0);
          list[0] = new String[]{"cor_desc", (db_object.getCor_desc() != null) ? db_object.getCor_desc() + "":""};
        } else {
          list[0] = new String[]{"cor_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cor_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * COR_DESC: Método Sets pára este campo.
    */
  public void setCor_desc(String PARAM) {
    cor_desc = PARAM;
  }
  /**
    * MIX_PRODUTOS: Método Gets para este campo
    */
  public String getMix_produtos() {
    return mix_produtos;
  }
  /**
    * MIX_PRODUTOS: Método Sets pára este campo.
    */
  public void setMix_produtos(String PARAM) {
    mix_produtos = PARAM;
  }
  Vector mix_produtosList = new Vector(10, 1);
  public java.util.Vector getMix_produtosList() {
    if (mix_produtosList == null || mix_produtosList.size() == 0) {
      mix_produtosList.addElement("T");
      mix_produtosLabelList.addElement("Todos");
      mix_produtosList.addElement("M");
      mix_produtosLabelList.addElement("Sim");
      mix_produtosList.addElement("F");
      mix_produtosLabelList.addElement("Não");
    }
    java.util.Vector list = mix_produtosList;
    return list;
  }
  java.util.Vector mix_produtosLabelList = new Vector(10, 1);
  public java.util.Vector getMix_produtosLabelList() {
    java.util.Vector list = mix_produtosLabelList;
    return list;
  }
  /**
    * MARCA: Método Gets para este campo
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Método Sets pára este campo.
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
      marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "DadosTecnicosProdutos.", e);
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
  private Vector tipoList = new Vector(10, 10);
  public void setTipoList(java.util.Vector VECTOR) {
    tipoList = VECTOR;
  }
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList = new Vector(10, 10);
      tipoLabelList = new Vector(10, 10);
      tipoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      tipoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_posicao_fabrica db_object = new Grupo_posicao_fabrica();
        String[][] select = {{"codigo_grupo", null},{"descricao_grupo", null}};
        Object[][] where = null;
        String[] order = {"descricao_grupo"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Grupo_posicao_fabrica) results.elementAt(i);
          tipoList.addElement(""+db_object.getCodigo_grupo());
          tipoLabelList.addElement(""+db_object.getDescricao_grupo());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "DadosTecnicosProdutos.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return tipoList;
  }
  private java.util.Vector tipoLabelList = new Vector(10, 10);
  public void setTipoLabelList(java.util.Vector VECTOR) {
    tipoLabelList = VECTOR;
  }
  public java.util.Vector getTipoLabelList() {
    return tipoLabelList;
  }
  /**
    * PED_DADG_INICIAL: Método Gets para este campo
    */
  public String getPed_dadg_inicial() {
    return ped_dadg_inicial;
  }
  /**
    * PED_DADG_INICIAL: Método Sets pára este campo.
    */
  public void setPed_dadg_inicial(String PARAM) {
    ped_dadg_inicial = PARAM;
  }
  /**
    * PED_DADG_FINAL: Método Gets para este campo
    */
  public String getPed_dadg_final() {
    return ped_dadg_final;
  }
  /**
    * PED_DADG_FINAL: Método Sets pára este campo.
    */
  public void setPed_dadg_final(String PARAM) {
    ped_dadg_final = PARAM;
  }
  /**
    * ANO_FATURA: Método Gets para este campo
    */
  public String getAno_fatura() {
    return ano_fatura;
  }
  /**
    * ANO_FATURA: Método Sets pára este campo.
    */
  public void setAno_fatura(String PARAM) {
    ano_fatura = PARAM;
  }
  /**
    * NUMERO_FATURA: Método Gets para este campo
    */
  public String getNumero_fatura() {
    return numero_fatura;
  }
  /**
    * NUMERO_FATURA: Método Sets pára este campo.
    */
  public void setNumero_fatura(String PARAM) {
    numero_fatura = PARAM;
  }
  /**
    * PEDIDOS: Método Gets para este campo
    */
  public String getPedidos() {
    return pedidos;
  }
  /**
    * PEDIDOS: Método Sets pára este campo.
    */
  public void setPedidos(String PARAM) {
    pedidos = PARAM;
  }
  /**
    * OCS: Método Gets para este campo
    */
  public String getOcs() {
    return ocs;
  }
  /**
    * OCS: Método Sets pára este campo.
    */
  public void setOcs(String PARAM) {
    ocs = PARAM;
  }
  /**
    * CB_TAMANHOS_PEDIDOS: Método Gets para este campo
    */
  public String getCb_tamanhos_pedidos() {
    return cb_tamanhos_pedidos;
  }
  /**
    * CB_TAMANHOS_PEDIDOS: Método Sets pára este campo.
    */
  public void setCb_tamanhos_pedidos(String PARAM) {
    cb_tamanhos_pedidos = PARAM;
  }
  /**
    * GERAR_PLANILHA: Método Gets para este campo
    */
  public String getGerar_planilha() {
    return gerar_planilha;
  }
  /**
    * GERAR_PLANILHA: Método Sets pára este campo.
    */
  public void setGerar_planilha(String PARAM) {
    gerar_planilha = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo_relatorio = null;
    gre_grupo = null;
    gre_descricao = null;
    cli_cdgo = null;
    cli_rzao = null;
    lin_cdgo = null;
    lin_nome = null;
    ref_cdgo = null;
    ref_desc = null;
    cab_cdgo = null;
    cab_desc = null;
    cor_cdgo = null;
    cor_desc = null;
    mix_produtos = null;
    marca = null;
    tipo = null;
    ped_dadg_inicial = null;
    ped_dadg_final = null;
    ano_fatura = null;
    numero_fatura = null;
    pedidos = null;
    ocs = null;
    cb_tamanhos_pedidos = null;
    gerar_planilha = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
