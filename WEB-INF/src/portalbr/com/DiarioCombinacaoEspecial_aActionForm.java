package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 08/06/2015 15:55:50
 * Last Modify Date 19/06/2015 10:02:42
 */

public class DiarioCombinacaoEspecial_aActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String data_solicitacao;
  public String usuario_solicitacao;
  public String tipo_solicitacao;
  public String codigo_marca;
  public String lin_cdgo;
  public String lin_nome;
  public String ref_cdgo;
  public String ref_desc;
  public String cab_cdgo;
  public String cab_desc;
  public String cor_cdgo;
  public String cor_desc;
  public String descricao;
  public String observacao;
  public String material_cor1;
  public String material_cor2;
  public String material_cor3;
  public String biqueira_debrum;
  public String capa_palmilha;
  public String cacharel;
  public String forro;
  public String metais;
  public String taloneira;
  public String salto;
  public String enfeite;
  public String carimbo_etiqueta;
  public String cli_cdgo;
  public String cli_rzao;
  public String rep_cdgo;
  public String rep_rzao;
  public String gre_grupo;
  public String gre_descricao;
  public String prs_negociacao;
  public String pares_linha;
  public String valor_pdv;
  public String preco_vendor;
  public String pares_alteracao;
  public String preco_liguido;
  public String ll_alteracao_solicitada;
  public String valor_fabricacao;
  public String arquivo;
  public String data_aceite;
  public String usuario_aceite;
  public String imagem_produto;
  public String id_imagem;
  public String ll_0;
  public String ll_1;
  public String ll_2;
  public String ll_3;
  private boolean valida = false;
  public DiarioCombinacaoEspecial_aActionForm() {
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
    * USUARIO_SOLICITACAO: Método Gets para este campo
    */
  public String getUsuario_solicitacao() {
    return usuario_solicitacao;
  }
  /**
    * USUARIO_SOLICITACAO: Método Sets pára este campo.
    */
  public void setUsuario_solicitacao(String PARAM) {
    usuario_solicitacao = PARAM;
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "DiarioCombinacaoEspecial_a.", e);
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

  public String[][] getLin_nome_Ajax(DiarioCombinacaoEspecial_aActionForm PARAM) {
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

  public String[][] getRef_desc_Ajax(DiarioCombinacaoEspecial_aActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0 && PARAM.getRef_cdgo() != null && PARAM.getRef_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        Object[][] where = { {"lin_cdgo","=", PARAM.getLin_cdgo()}, {"ref_cdgo","=", PARAM.getRef_cdgo()}, };
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

  public String[][] getCab_desc_Ajax(DiarioCombinacaoEspecial_aActionForm PARAM) {
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

  public String[][] getCor_desc_Ajax(DiarioCombinacaoEspecial_aActionForm PARAM) {
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
    * DESCRICAO: Método Gets para este campo
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: Método Sets pára este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * OBSERVACAO: Método Gets para este campo
    */
  public String getObservacao() {
    return observacao;
  }
  /**
    * OBSERVACAO: Método Sets pára este campo.
    */
  public void setObservacao(String PARAM) {
    observacao = PARAM;
  }
  /**
    * MATERIAL_COR1: Método Gets para este campo
    */
  public String getMaterial_cor1() {
    return material_cor1;
  }
  /**
    * MATERIAL_COR1: Método Sets pára este campo.
    */
  public void setMaterial_cor1(String PARAM) {
    material_cor1 = PARAM;
  }
  /**
    * MATERIAL_COR2: Método Gets para este campo
    */
  public String getMaterial_cor2() {
    return material_cor2;
  }
  /**
    * MATERIAL_COR2: Método Sets pára este campo.
    */
  public void setMaterial_cor2(String PARAM) {
    material_cor2 = PARAM;
  }
  /**
    * MATERIAL_COR3: Método Gets para este campo
    */
  public String getMaterial_cor3() {
    return material_cor3;
  }
  /**
    * MATERIAL_COR3: Método Sets pára este campo.
    */
  public void setMaterial_cor3(String PARAM) {
    material_cor3 = PARAM;
  }
  /**
    * BIQUEIRA_DEBRUM: Método Gets para este campo
    */
  public String getBiqueira_debrum() {
    return biqueira_debrum;
  }
  /**
    * BIQUEIRA_DEBRUM: Método Sets pára este campo.
    */
  public void setBiqueira_debrum(String PARAM) {
    biqueira_debrum = PARAM;
  }
  /**
    * CAPA_PALMILHA: Método Gets para este campo
    */
  public String getCapa_palmilha() {
    return capa_palmilha;
  }
  /**
    * CAPA_PALMILHA: Método Sets pára este campo.
    */
  public void setCapa_palmilha(String PARAM) {
    capa_palmilha = PARAM;
  }
  /**
    * CACHAREL: Método Gets para este campo
    */
  public String getCacharel() {
    return cacharel;
  }
  /**
    * CACHAREL: Método Sets pára este campo.
    */
  public void setCacharel(String PARAM) {
    cacharel = PARAM;
  }
  /**
    * FORRO: Método Gets para este campo
    */
  public String getForro() {
    return forro;
  }
  /**
    * FORRO: Método Sets pára este campo.
    */
  public void setForro(String PARAM) {
    forro = PARAM;
  }
  /**
    * METAIS: Método Gets para este campo
    */
  public String getMetais() {
    return metais;
  }
  /**
    * METAIS: Método Sets pára este campo.
    */
  public void setMetais(String PARAM) {
    metais = PARAM;
  }
  /**
    * TALONEIRA: Método Gets para este campo
    */
  public String getTaloneira() {
    return taloneira;
  }
  /**
    * TALONEIRA: Método Sets pára este campo.
    */
  public void setTaloneira(String PARAM) {
    taloneira = PARAM;
  }
  /**
    * SALTO: Método Gets para este campo
    */
  public String getSalto() {
    return salto;
  }
  /**
    * SALTO: Método Sets pára este campo.
    */
  public void setSalto(String PARAM) {
    salto = PARAM;
  }
  /**
    * ENFEITE: Método Gets para este campo
    */
  public String getEnfeite() {
    return enfeite;
  }
  /**
    * ENFEITE: Método Sets pára este campo.
    */
  public void setEnfeite(String PARAM) {
    enfeite = PARAM;
  }
  /**
    * CARIMBO_ETIQUETA: Método Gets para este campo
    */
  public String getCarimbo_etiqueta() {
    return carimbo_etiqueta;
  }
  /**
    * CARIMBO_ETIQUETA: Método Sets pára este campo.
    */
  public void setCarimbo_etiqueta(String PARAM) {
    carimbo_etiqueta = PARAM;
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

  public String[][] getCli_rzao_Ajax(DiarioCombinacaoEspecial_aActionForm PARAM) {
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

  public String[][] getRep_rzao_Ajax(DiarioCombinacaoEspecial_aActionForm PARAM) {
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

  public String[][] getGre_descricao_Ajax(DiarioCombinacaoEspecial_aActionForm PARAM) {
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
    * PRS_NEGOCIACAO: Método Gets para este campo
    */
  public String getPrs_negociacao() {
    return prs_negociacao;
  }
  /**
    * PRS_NEGOCIACAO: Método Sets pára este campo.
    */
  public void setPrs_negociacao(String PARAM) {
    prs_negociacao = PARAM;
  }
  /**
    * PARES_LINHA: Método Gets para este campo
    */
  public String getPares_linha() {
    return pares_linha;
  }
  /**
    * PARES_LINHA: Método Sets pára este campo.
    */
  public void setPares_linha(String PARAM) {
    pares_linha = PARAM;
  }
  /**
    * VALOR_PDV: Método Gets para este campo
    */
  public String getValor_pdv() {
    return valor_pdv;
  }
  /**
    * VALOR_PDV: Método Sets pára este campo.
    */
  public void setValor_pdv(String PARAM) {
    valor_pdv = PARAM;
  }
  /**
    * PRECO_VENDOR: Método Gets para este campo
    */
  public String getPreco_vendor() {
    return preco_vendor;
  }
  /**
    * PRECO_VENDOR: Método Sets pára este campo.
    */
  public void setPreco_vendor(String PARAM) {
    preco_vendor = PARAM;
  }
  /**
    * PARES_ALTERACAO: Método Gets para este campo
    */
  public String getPares_alteracao() {
    return pares_alteracao;
  }
  /**
    * PARES_ALTERACAO: Método Sets pára este campo.
    */
  public void setPares_alteracao(String PARAM) {
    pares_alteracao = PARAM;
  }
  /**
    * PRECO_LIGUIDO: Método Gets para este campo
    */
  public String getPreco_liguido() {
    return preco_liguido;
  }
  /**
    * PRECO_LIGUIDO: Método Sets pára este campo.
    */
  public void setPreco_liguido(String PARAM) {
    preco_liguido = PARAM;
  }
  /**
    * LL_ALTERACAO_SOLICITADA: Método Gets para este campo
    */
  public String getLl_alteracao_solicitada() {
    return ll_alteracao_solicitada;
  }
  /**
    * LL_ALTERACAO_SOLICITADA: Método Sets pára este campo.
    */
  public void setLl_alteracao_solicitada(String PARAM) {
    ll_alteracao_solicitada = PARAM;
  }
  /**
    * VALOR_FABRICACAO: Método Gets para este campo
    */
  public String getValor_fabricacao() {
    return valor_fabricacao;
  }
  /**
    * VALOR_FABRICACAO: Método Sets pára este campo.
    */
  public void setValor_fabricacao(String PARAM) {
    valor_fabricacao = PARAM;
  }
  /**
    * ARQUIVO: Método Gets para este campo
    */
  public String getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Método Sets pára este campo.
    */
  public void setArquivo(String PARAM) {
    arquivo = PARAM;
  }
  /**
    * DATA_ACEITE: Método Gets para este campo
    */
  public String getData_aceite() {
    return data_aceite;
  }
  /**
    * DATA_ACEITE: Método Sets pára este campo.
    */
  public void setData_aceite(String PARAM) {
    data_aceite = PARAM;
  }
  /**
    * USUARIO_ACEITE: Método Gets para este campo
    */
  public String getUsuario_aceite() {
    return usuario_aceite;
  }
  /**
    * USUARIO_ACEITE: Método Sets pára este campo.
    */
  public void setUsuario_aceite(String PARAM) {
    usuario_aceite = PARAM;
  }
  /**
    * IMAGEM_PRODUTO: Método Gets para este campo
    */
  public String getImagem_produto() {
    return imagem_produto;
  }
  /**
    * IMAGEM_PRODUTO: Método Sets pára este campo.
    */
  public void setImagem_produto(String PARAM) {
    imagem_produto = PARAM;
  }
  /**
    * ID_IMAGEM: Método Gets para este campo
    */
  public String getId_imagem() {
    return id_imagem;
  }
  /**
    * ID_IMAGEM: Método Sets pára este campo.
    */
  public void setId_imagem(String PARAM) {
    id_imagem = PARAM;
  }
  /**
    * LL_0: Método Gets para este campo
    */
  public String getLl_0() {
    return ll_0;
  }
  /**
    * LL_0: Método Sets pára este campo.
    */
  public void setLl_0(String PARAM) {
    ll_0 = PARAM;
  }
  /**
    * LL_1: Método Gets para este campo
    */
  public String getLl_1() {
    return ll_1;
  }
  /**
    * LL_1: Método Sets pára este campo.
    */
  public void setLl_1(String PARAM) {
    ll_1 = PARAM;
  }
  /**
    * LL_2: Método Gets para este campo
    */
  public String getLl_2() {
    return ll_2;
  }
  /**
    * LL_2: Método Sets pára este campo.
    */
  public void setLl_2(String PARAM) {
    ll_2 = PARAM;
  }
  /**
    * LL_3: Método Gets para este campo
    */
  public String getLl_3() {
    return ll_3;
  }
  /**
    * LL_3: Método Sets pára este campo.
    */
  public void setLl_3(String PARAM) {
    ll_3 = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    data_solicitacao = null;
    usuario_solicitacao = null;
    tipo_solicitacao = null;
    codigo_marca = null;
    lin_cdgo = null;
    lin_nome = null;
    ref_cdgo = null;
    ref_desc = null;
    cab_cdgo = null;
    cab_desc = null;
    cor_cdgo = null;
    cor_desc = null;
    descricao = null;
    observacao = null;
    material_cor1 = null;
    material_cor2 = null;
    material_cor3 = null;
    biqueira_debrum = null;
    capa_palmilha = null;
    cacharel = null;
    forro = null;
    metais = null;
    taloneira = null;
    salto = null;
    enfeite = null;
    carimbo_etiqueta = null;
    cli_cdgo = null;
    cli_rzao = null;
    rep_cdgo = null;
    rep_rzao = null;
    gre_grupo = null;
    gre_descricao = null;
    prs_negociacao = null;
    pares_linha = null;
    valor_pdv = null;
    preco_vendor = null;
    pares_alteracao = null;
    preco_liguido = null;
    ll_alteracao_solicitada = null;
    valor_fabricacao = null;
    arquivo = null;
    data_aceite = null;
    usuario_aceite = null;
    imagem_produto = null;
    id_imagem = null;
    ll_0 = null;
    ll_1 = null;
    ll_2 = null;
    ll_3 = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,delete_action,delete_grade_action,", request)) {
      if (com.egen.util.text.Validate.isNull(id_solicitacao)) {
        errors.add("id_solicitacao", new ActionMessage("error.validate.notnull","ID","id_solicitacao","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_solicitacao)) {
        errors.add("data_solicitacao", new ActionMessage("error.validate.notnull","Data","data_solicitacao","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_solicitacao)) {
        errors.add("data_solicitacao", new ActionMessage("error.validate.date","Data","data_solicitacao","0"));
      }
      if (com.egen.util.text.Validate.isNull(usuario_solicitacao)) {
        errors.add("usuario_solicitacao", new ActionMessage("error.validate.notnull","Usuário","usuario_solicitacao","0"));
      }
      if (com.egen.util.text.Validate.isNull(tipo_solicitacao)) {
        errors.add("tipo_solicitacao", new ActionMessage("error.validate.notnull","Tipo de solicitação","tipo_solicitacao","0"));
      }
      if (com.egen.util.text.Validate.isNull(lin_cdgo)) {
        errors.add("lin_cdgo", new ActionMessage("error.validate.notnull","Linha","lin_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_aceite)) {
        errors.add("data_aceite", new ActionMessage("error.validate.date","Data_aceite","data_aceite","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
