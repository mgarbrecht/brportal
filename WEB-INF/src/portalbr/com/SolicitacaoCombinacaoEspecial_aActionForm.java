package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/02/2012 11:28:50
 * Last Modify Date 08/03/2023 14:52:29
 */

import org.apache.struts.upload.FormFile;

public class SolicitacaoCombinacaoEspecial_aActionForm extends org.apache.struts.action.ActionForm
{
  public String id_solicitacao;
  public String data_solicitacao;
  public String usuario_solicitacao;
  public String tipo_solicitacao;
  public String subtipo_solicitacao_comb_espec;
  public String codigo_marca;
  public String material;
  public String lin_cdgo;
  public String lin_nome;
  public String linha_mix;
  public String ref_cdgo;
  public String ref_desc;
  public String cab_cdgo;
  public String cab_desc;
  public String cor_cdgo;
  public String cor_desc;
  public String data_entrega_amostra;
  public String observacao;
  public String material_cor1;
  public String material_cor2;
  public String material_cor3;
  public String material_cor4;
  public String material_cor5;
  public String material_cor6;
  public String material_cor7;
  public String material_cor8;
  public String material_cor9;
  public String material_cor10;
  public String biqueira_debrum;
  public String capa_palmilha;
  public String taloneira;
  public String enfeite;
  public String metais;
  public String cepa;
  public String salto;
  public String sola;
  public String cacharel;
  public String forro;
  public String atacador;
  public String carimbo_etiqueta;
  public String cli_cdgo;
  public String cli_rzao;
  public String rep_cdgo;
  public String rep_rzao;
  public String codigo_regional;
  public String nome_regional;
  public String gre_grupo;
  public String gre_descricao;
  public String prs_negociacao;
  public String pares_linha;
  public String pares_alteracao;
  public String preco_liguido;
  public String ll_alteracao_solicitada;
  public String valor_fabricacao;
  public String preco_vendor;
  public FormFile arquivo;
  public String situacao_solicitacao;
  public String data_aceite;
  public String usuario_aceite;
  public String imagem_produto;
  public String pedido;
  public String item;
  public String item_desc;
  public String id_solicitacao_delete;
  public String data_aprovacao;
  public String ref_grupo_posicao_fab;
  private boolean valida = false;
  public SolicitacaoCombinacaoEspecial_aActionForm() {
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
  private Vector tipo_solicitacaoList = new Vector(10, 10);
  public void setTipo_solicitacaoList(java.util.Vector VECTOR) {
    tipo_solicitacaoList = VECTOR;
  }
  public java.util.Vector getTipo_solicitacaoList() {
    if (tipo_solicitacaoList == null || tipo_solicitacaoList.size() == 0) {
      tipo_solicitacaoList = new Vector(10, 10);
      tipo_solicitacaoLabelList = new Vector(10, 10);
      tipo_solicitacaoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      tipo_solicitacaoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
        Object[][] where = {{"rv_domain","=","TIPO_SOLICITACAO_COMB_ESPECIAL"}};
        String[] order = {"rv_meaning"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          tipo_solicitacaoList.addElement(""+db_object.getRv_low_value());
          tipo_solicitacaoLabelList.addElement(""+db_object.getRv_meaning());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "SolicitacaoCombinacaoEspecial_a.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return tipo_solicitacaoList;
  }
  private java.util.Vector tipo_solicitacaoLabelList = new Vector(10, 10);
  public void setTipo_solicitacaoLabelList(java.util.Vector VECTOR) {
    tipo_solicitacaoLabelList = VECTOR;
  }
  public java.util.Vector getTipo_solicitacaoLabelList() {
    return tipo_solicitacaoLabelList;
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
  private Vector subtipo_solicitacao_comb_especList = new Vector(10, 10);
  public void setSubtipo_solicitacao_comb_especList(java.util.Vector VECTOR) {
    subtipo_solicitacao_comb_especList = VECTOR;
  }
  public java.util.Vector getSubtipo_solicitacao_comb_especList() {
    subtipo_solicitacao_comb_especList = new Vector(10, 10);
    subtipo_solicitacao_comb_especLabelList = new Vector(10, 10);
    subtipo_solicitacao_comb_especList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    subtipo_solicitacao_comb_especLabelList.addElement(bundle.getString("jsp.pleaseselect"));
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Cg_ref_codes db_object = new Cg_ref_codes();
      String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
      Object[][] where = {{"rv_domain","=","SUBTIPO_SOLICITACAO_COMB_ESPEC"}, {"rv_high_value","in","'" + getTipo_solicitacao() + "'"} };
      String[] order = {"rv_meaning"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Cg_ref_codes) results.elementAt(i);
        subtipo_solicitacao_comb_especList.addElement(""+db_object.getRv_low_value());
        subtipo_solicitacao_comb_especLabelList.addElement(""+db_object.getRv_meaning());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "SolicitacaoCombinacaoEspecial_a.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return subtipo_solicitacao_comb_especList;
  }
  private java.util.Vector subtipo_solicitacao_comb_especLabelList = new Vector(10, 10);
  public void setSubtipo_solicitacao_comb_especLabelList(java.util.Vector VECTOR) {
    subtipo_solicitacao_comb_especLabelList = VECTOR;
  }
  public java.util.Vector getSubtipo_solicitacao_comb_especLabelList() {
    return subtipo_solicitacao_comb_especLabelList;
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "SolicitacaoCombinacaoEspecial_a.", e);
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
      materialLabelList.addElement("Selecionar");
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
        Jw_lin_mix db_object = new Jw_lin_mix();
        String[][] select = { {"lin_nome",null}, {"descricao_mix",null}, {"ref_grupo_posicao_fab",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(lin_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_lin_mix) results.elementAt(0);
          lin_nome = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
          linha_mix = ((db_object.getDescricao_mix() != null) ? db_object.getDescricao_mix() + "":"");
          ref_grupo_posicao_fab = (db_object.getRef_grupo_posicao_fab() != null) ? db_object.getRef_grupo_posicao_fab() + "":"";
        } else {
          lin_nome = "";
          linha_mix = "";
          ref_grupo_posicao_fab = "";
        }
      }
    } catch (Exception e) {
      lin_nome = "";
      linha_mix = "";
      ref_grupo_posicao_fab = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
    String[][] list = new String[3][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_lin_mix db_object = new Jw_lin_mix();
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(PARAM.getLin_cdgo())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_lin_mix) results.elementAt(0);
          list[0] = new String[]{"lin_nome", (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":""};
          list[1] = new String[]{"linha_mix", ((db_object.getDescricao_mix() != null) ? db_object.getDescricao_mix() + "":"")};
          list[2] = new String[]{"ref_grupo_posicao_fab", (db_object.getRef_grupo_posicao_fab() != null) ? db_object.getRef_grupo_posicao_fab() + "":""};
        } else {
          list[0] = new String[]{"lin_nome", ""};
          list[1] = new String[]{"linha_mix", ""};
          list[2] = new String[]{"ref_grupo_posicao_fab", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_nome", ""};
      list[1] = new String[]{"linha_mix", ""};
      list[2] = new String[]{"ref_grupo_posicao_fab", ""};
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
    * LINHA_MIX: Método Gets para este campo
    */
  public String getLinha_mix() {
    return linha_mix;
  }
  /**
    * LINHA_MIX: Método Sets pára este campo.
    */
  public void setLinha_mix(String PARAM) {
    linha_mix = PARAM;
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
        String[][] select = { {"ref_desc",null}, {"codigo_marca",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(lin_cdgo)}, {"ref_cdgo","=",com.egen.util.text.FormatNumber.toInteger(ref_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          ref_desc = (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":"";
          codigo_marca = (db_object.getCodigo_marca() != null) ? db_object.getCodigo_marca() + "":"";
        } else {
          ref_desc = "";
          codigo_marca = "";
        }
      }
    } catch (Exception e) {
      ref_desc = "";
      codigo_marca = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return ref_desc;
  }

  public String[][] getRef_desc_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
    String[][] list = new String[2][2];
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
          list[1] = new String[]{"codigo_marca", (db_object.getCodigo_marca() != null) ? db_object.getCodigo_marca() + "":""};
        } else {
          list[0] = new String[]{"ref_desc", ""};
          list[1] = new String[]{"codigo_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"ref_desc", ""};
      list[1] = new String[]{"codigo_marca", ""};
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

  public String[][] getCab_desc_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
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

  public String[][] getCor_desc_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
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
    * MATERIAL_COR4: Método Gets para este campo
    */
  public String getMaterial_cor4() {
    return material_cor4;
  }
  /**
    * MATERIAL_COR4: Método Sets pára este campo.
    */
  public void setMaterial_cor4(String PARAM) {
    material_cor4 = PARAM;
  }
  /**
    * MATERIAL_COR5: Método Gets para este campo
    */
  public String getMaterial_cor5() {
    return material_cor5;
  }
  /**
    * MATERIAL_COR5: Método Sets pára este campo.
    */
  public void setMaterial_cor5(String PARAM) {
    material_cor5 = PARAM;
  }
  /**
    * MATERIAL_COR6: Método Gets para este campo
    */
  public String getMaterial_cor6() {
    return material_cor6;
  }
  /**
    * MATERIAL_COR6: Método Sets pára este campo.
    */
  public void setMaterial_cor6(String PARAM) {
    material_cor6 = PARAM;
  }
  /**
    * MATERIAL_COR7: Método Gets para este campo
    */
  public String getMaterial_cor7() {
    return material_cor7;
  }
  /**
    * MATERIAL_COR7: Método Sets pára este campo.
    */
  public void setMaterial_cor7(String PARAM) {
    material_cor7 = PARAM;
  }
  /**
    * MATERIAL_COR8: Método Gets para este campo
    */
  public String getMaterial_cor8() {
    return material_cor8;
  }
  /**
    * MATERIAL_COR8: Método Sets pára este campo.
    */
  public void setMaterial_cor8(String PARAM) {
    material_cor8 = PARAM;
  }
  /**
    * MATERIAL_COR9: Método Gets para este campo
    */
  public String getMaterial_cor9() {
    return material_cor9;
  }
  /**
    * MATERIAL_COR9: Método Sets pára este campo.
    */
  public void setMaterial_cor9(String PARAM) {
    material_cor9 = PARAM;
  }
  /**
    * MATERIAL_COR10: Método Gets para este campo
    */
  public String getMaterial_cor10() {
    return material_cor10;
  }
  /**
    * MATERIAL_COR10: Método Sets pára este campo.
    */
  public void setMaterial_cor10(String PARAM) {
    material_cor10 = PARAM;
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
    * CEPA: Método Gets para este campo
    */
  public String getCepa() {
    return cepa;
  }
  /**
    * CEPA: Método Sets pára este campo.
    */
  public void setCepa(String PARAM) {
    cepa = PARAM;
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
    * SOLA: Método Gets para este campo
    */
  public String getSola() {
    return sola;
  }
  /**
    * SOLA: Método Sets pára este campo.
    */
  public void setSola(String PARAM) {
    sola = PARAM;
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
    * ATACADOR: Método Gets para este campo
    */
  public String getAtacador() {
    return atacador;
  }
  /**
    * ATACADOR: Método Sets pára este campo.
    */
  public void setAtacador(String PARAM) {
    atacador = PARAM;
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
      if (cli_cdgo != null && cli_cdgo.length() > 0 && codigo_marca != null && codigo_marca.length() > 0 && ref_grupo_posicao_fab != null && ref_grupo_posicao_fab.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_representante_cli_marca db_object = new Jw_representante_cli_marca();
        String[][] select = { {"cli_rzao",null}, {"rep_cdgo",null}, {"rep_rzao",null}, };
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)}, {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)}, {"ref_grupo_posicao_fab","=",com.egen.util.text.FormatNumber.toInt(ref_grupo_posicao_fab)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_representante_cli_marca) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
          rep_cdgo = (db_object.getRep_cdgo() != null) ? db_object.getRep_cdgo() + "":"";
          rep_rzao = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        } else {
          cli_rzao = "";
          rep_cdgo = "";
          rep_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
      rep_cdgo = "";
      rep_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
    String[][] list = new String[3][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0 && PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0 && PARAM.getRef_grupo_posicao_fab() != null && PARAM.getRef_grupo_posicao_fab().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_representante_cli_marca db_object = new Jw_representante_cli_marca();
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(PARAM.getCli_cdgo())}, {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(PARAM.getCodigo_marca())}, {"ref_grupo_posicao_fab","=",com.egen.util.text.FormatNumber.toInt(PARAM.getRef_grupo_posicao_fab())} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_representante_cli_marca) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
          list[1] = new String[]{"rep_cdgo", (db_object.getRep_cdgo() != null) ? db_object.getRep_cdgo() + "":""};
          list[2] = new String[]{"rep_rzao", (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
          list[1] = new String[]{"rep_cdgo", ""};
          list[2] = new String[]{"rep_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
      list[1] = new String[]{"rep_cdgo", ""};
      list[2] = new String[]{"rep_rzao", ""};
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

  public String[][] getRep_rzao_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
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
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"codigo_regional",null} };
        Object[][] where = { {"rep_cdgo","like",rep_cdgo}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          codigo_regional = db_object.getCodigo_regional() + "";
        } else {
          codigo_regional = "";
        }
      }
    } catch (Exception e) {
      codigo_regional = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return codigo_regional;
  }

  public String[][] getCodigo_regional_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
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
          list[0] = new String[]{"codigo_regional", db_object.getCodigo_regional() + ""};
        } else {
          list[0] = new String[]{"codigo_regional", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"codigo_regional", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
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

  public String[][] getNome_regional_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
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

  public String[][] getGre_descricao_Ajax(SolicitacaoCombinacaoEspecial_aActionForm PARAM) {
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
    * ARQUIVO: Método Gets para este campo
    */
  public FormFile getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Método Sets pára este campo.
    */
  public void setArquivo(FormFile PARAM) {
    arquivo = PARAM;
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
  private Vector situacao_solicitacaoList = new Vector(10, 10);
  public void setSituacao_solicitacaoList(java.util.Vector VECTOR) {
    situacao_solicitacaoList = VECTOR;
  }
  public java.util.Vector getSituacao_solicitacaoList() {
    if (situacao_solicitacaoList == null || situacao_solicitacaoList.size() == 0) {
      situacao_solicitacaoList = new Vector(10, 10);
      situacao_solicitacaoLabelList = new Vector(10, 10);
      situacao_solicitacaoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      situacao_solicitacaoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cg_ref_codes db_object = new Cg_ref_codes();
        String[][] select = {{"rv_low_value", null},{"rv_meaning", null}};
        Object[][] where = {{"rv_domain","=","SITUACAO_SOLICITACAO_COMB_ESPEC"}};
        String[] order = {"rv_high_value","rv_low_value"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Cg_ref_codes) results.elementAt(i);
          situacao_solicitacaoList.addElement(""+db_object.getRv_low_value());
          situacao_solicitacaoLabelList.addElement(""+db_object.getRv_meaning());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "SolicitacaoCombinacaoEspecial_a.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return situacao_solicitacaoList;
  }
  private java.util.Vector situacao_solicitacaoLabelList = new Vector(10, 10);
  public void setSituacao_solicitacaoLabelList(java.util.Vector VECTOR) {
    situacao_solicitacaoLabelList = VECTOR;
  }
  public java.util.Vector getSituacao_solicitacaoLabelList() {
    return situacao_solicitacaoLabelList;
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
    * PEDIDO: Método Gets para este campo
    */
  public String getPedido() {
    return pedido;
  }
  /**
    * PEDIDO: Método Sets pára este campo.
    */
  public void setPedido(String PARAM) {
    pedido = PARAM;
  }
  /**
    * ITEM: Método Gets para este campo
    */
  public String getItem() {
    return item;
  }
  /**
    * ITEM: Método Sets pára este campo.
    */
  public void setItem(String PARAM) {
    item = PARAM;
  }
  /**
    * ITEM_DESC: Método Gets para este campo
    */
  public String getItem_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (pedido != null && pedido.length() > 0 && item != null && item.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_item_pedido db_object = new Jw_item_pedido();
        String[][] select = { {"descricao_item",null} };
        Object[][] where = { {"ped_nmro","=",com.egen.util.text.FormatNumber.toInt(pedido)}, {"sequencial","=",com.egen.util.text.FormatNumber.toInt(item)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_item_pedido) results.elementAt(0);
          item_desc = ((db_object.getDescricao_item() != null) ? db_object.getDescricao_item() + "":"");
        } else {
          item_desc = "";
        }
      }
    } catch (Exception e) {
      item_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return item_desc;
  }
  /**
    * ITEM_DESC: Método Sets pára este campo.
    */
  public void setItem_desc(String PARAM) {
    item_desc = PARAM;
  }
  /**
    * ID_SOLICITACAO_DELETE: Método Gets para este campo
    */
  public String getId_solicitacao_delete() {
    return id_solicitacao_delete;
  }
  /**
    * ID_SOLICITACAO_DELETE: Método Sets pára este campo.
    */
  public void setId_solicitacao_delete(String PARAM) {
    id_solicitacao_delete = PARAM;
  }
  /**
    * DATA_APROVACAO: Método Gets para este campo
    */
  public String getData_aprovacao() {
    return data_aprovacao;
  }
  /**
    * DATA_APROVACAO: Método Sets pára este campo.
    */
  public void setData_aprovacao(String PARAM) {
    data_aprovacao = PARAM;
  }
  /**
    * REF_GRUPO_POSICAO_FAB: Método Gets para este campo
    */
  public String getRef_grupo_posicao_fab() {
    return ref_grupo_posicao_fab;
  }
  /**
    * REF_GRUPO_POSICAO_FAB: Método Sets pára este campo.
    */
  public void setRef_grupo_posicao_fab(String PARAM) {
    ref_grupo_posicao_fab = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_solicitacao = null;
    data_solicitacao = null;
    usuario_solicitacao = null;
    tipo_solicitacao = null;
    subtipo_solicitacao_comb_espec = null;
    codigo_marca = null;
    material = null;
    lin_cdgo = null;
    lin_nome = null;
    linha_mix = null;
    ref_cdgo = null;
    ref_desc = null;
    cab_cdgo = null;
    cab_desc = null;
    cor_cdgo = null;
    cor_desc = null;
    data_entrega_amostra = null;
    observacao = null;
    material_cor1 = null;
    material_cor2 = null;
    material_cor3 = null;
    material_cor4 = null;
    material_cor5 = null;
    material_cor6 = null;
    material_cor7 = null;
    material_cor8 = null;
    material_cor9 = null;
    material_cor10 = null;
    biqueira_debrum = null;
    capa_palmilha = null;
    taloneira = null;
    enfeite = null;
    metais = null;
    cepa = null;
    salto = null;
    sola = null;
    cacharel = null;
    forro = null;
    atacador = null;
    carimbo_etiqueta = null;
    cli_cdgo = null;
    cli_rzao = null;
    rep_cdgo = null;
    rep_rzao = null;
    codigo_regional = null;
    nome_regional = null;
    gre_grupo = null;
    gre_descricao = null;
    prs_negociacao = null;
    pares_linha = null;
    pares_alteracao = null;
    preco_liguido = null;
    ll_alteracao_solicitada = null;
    valor_fabricacao = null;
    preco_vendor = null;
    arquivo = null;
    situacao_solicitacao = null;
    data_aceite = null;
    usuario_aceite = null;
    imagem_produto = null;
    pedido = null;
    item = null;
    item_desc = null;
    id_solicitacao_delete = null;
    data_aprovacao = null;
    ref_grupo_posicao_fab = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
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
      if (!com.egen.util.text.Validate.isDate(data_entrega_amostra)) {
        errors.add("data_entrega_amostra", new ActionMessage("error.validate.date","Data Embarque Amostra","data_entrega_amostra","0"));
      }
      if (com.egen.util.text.Validate.isNull(sola)) {
        errors.add("sola", new ActionMessage("error.validate.notnull","Sola","sola","0"));
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
