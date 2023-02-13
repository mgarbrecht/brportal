package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 07/03/2006 15:03:23
 * Last Modify Date 17/10/2022 13:49:28
 */

public class ConsultaPedidosActionForm extends org.apache.struts.action.ActionForm
{
  public String no_cliente;
  public String cli_cdgo;
  public String seq;
  public String esc_cgc;
  public String rep_cdgo1;
  public String rep_rzao1;
  public String agrupar_clientes;
  public String situacao;
  public String situacao_ped;
  public String tipo_pedido;
  public String cnd_cdgo;
  public String cnd_desc;
  public String codigo_marca;
  public String descricao_marca;
  public String lin_cdgo;
  public String lin_nome;
  public String ref_cdgo;
  public String ref_desc;
  public String cab_cdgo;
  public String cab_desc;
  public String cor_cdgo;
  public String cor_desc;
  public String tipo_produto;
  public String grup_economico;
  public String gre_descricao;
  public String dt_entrega;
  public String dt_entrega_fim1;
  public String dt_entrada_ini;
  public String dt_entrada_fim;
  public String dt_emissao_ini1;
  public String dt_emissao_fim1;
  public String dt_faturamento_ini;
  public String dt_faturamento_fim;
  public String representante;
  public String regional;
  public String codigo;
  public String razao_social;
  public String cid_uf;
  public String mostrar_imagem;
  public String reg;
  public String invoice;
  public String cb_somente_entrada;
  public String cb_fora_normas;
  public String cb_nao_imprimir_linhas;
  public String cb_somente_indenizados;
  public String ordenacao;
  public String mix;
  public String nr_pedido1;
  public String pedido_afv1;
  public String ped_ped_cliente;
  public String pedido_sites;
  public String pedido_catalogo;
  public String ordenacao1;
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String dt_entrega_ini;
  public String dt_entrega_fim;
  public String dt_emissao_ini;
  public String dt_emissao_fim;
  public String nr_pedido;
  public String pedido_afv;
  public String cliente;
  public String cli_seq;
  public String situacao1;
  public String tp_pedido;
  public String abre_automaticamente;
  public String mensagem;
  public String pedido_sites1;
  public String pedido_catalogo1;
  public String cod_representante;
  public String nr_pedido_rep1;
  private boolean valida = false;
  public ConsultaPedidosActionForm() {
  }
  /**
    * NO_CLIENTE: Method to get the field value.
    */
  public String getNo_cliente() {
    return no_cliente;
  }
  /**
    * NO_CLIENTE: Method to set the field value.
    */
  public void setNo_cliente(String PARAM) {
    no_cliente = PARAM;
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
    * SEQ: Method to get the field value.
    */
  public String getSeq() {
    return seq;
  }
  /**
    * SEQ: Method to set the field value.
    */
  public void setSeq(String PARAM) {
    seq = PARAM;
  }
  /**
    * ESC_CGC: Method to get the field value.
    */
  public String getEsc_cgc() {
    return esc_cgc;
  }
  /**
    * ESC_CGC: Method to set the field value.
    */
  public void setEsc_cgc(String PARAM) {
    esc_cgc = PARAM;
  }
  /**
    * REP_CDGO1: Method to get the field value.
    */
  public String getRep_cdgo1() {
    return rep_cdgo1;
  }
  /**
    * REP_CDGO1: Method to set the field value.
    */
  public void setRep_cdgo1(String PARAM) {
    rep_cdgo1 = PARAM;
  }
  /**
    * REP_RZAO1: Method to get the field value.
    */
  public String getRep_rzao1() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo1 != null && rep_cdgo1.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"rep_rzao",null} };
        Object[][] where = { {"rep_cdgo","like",rep_cdgo1}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          rep_rzao1 = ((db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"");
        } else {
          rep_rzao1 = "";
        }
      }
    } catch (Exception e) {
      rep_rzao1 = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return rep_rzao1;
  }

  public String[][] getRep_rzao1_Ajax(ConsultaPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo1() != null && PARAM.getRep_cdgo1().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo1()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          list[0] = new String[]{"rep_rzao1", ((db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"")};
        } else {
          list[0] = new String[]{"rep_rzao1", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"rep_rzao1", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REP_RZAO1: Method to set the field value.
    */
  public void setRep_rzao1(String PARAM) {
    rep_rzao1 = PARAM;
  }
  /**
    * AGRUPAR_CLIENTES: Method to get the field value.
    */
  public String getAgrupar_clientes() {
    return agrupar_clientes;
  }
  /**
    * AGRUPAR_CLIENTES: Method to set the field value.
    */
  public void setAgrupar_clientes(String PARAM) {
    agrupar_clientes = PARAM;
  }
  Vector agrupar_clientesList = new Vector(10, 1);
  public java.util.Vector getAgrupar_clientesList() {
    if (agrupar_clientesList == null || agrupar_clientesList.size() == 0) {
      agrupar_clientesList.addElement("N");
      agrupar_clientesLabelList.addElement("Não");
      agrupar_clientesList.addElement("S");
      agrupar_clientesLabelList.addElement("Sim");
    }
    java.util.Vector list = agrupar_clientesList;
    return list;
  }
  java.util.Vector agrupar_clientesLabelList = new Vector(10, 1);
  public java.util.Vector getAgrupar_clientesLabelList() {
    java.util.Vector list = agrupar_clientesLabelList;
    return list;
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
      situacaoList.addElement("X");
      situacaoLabelList.addElement("");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("Pedidos Abertos");
      situacaoList.addElement("B");
      situacaoLabelList.addElement("Bloqueados na Digitação");
      situacaoList.addElement("P");
      situacaoLabelList.addElement("Bloqueados no Crédito");
      situacaoList.addElement("T");
      situacaoLabelList.addElement("Bloqueados no Comercial");
      situacaoList.addElement("L");
      situacaoLabelList.addElement("Liberados");
      situacaoList.addElement("F");
      situacaoLabelList.addElement("Pedidos Faturados");
      situacaoList.addElement("C");
      situacaoLabelList.addElement("Pedidos Cancelados");
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
    * SITUACAO_PED: Method to get the field value.
    */
  public String getSituacao_ped() {
    return situacao_ped;
  }
  /**
    * SITUACAO_PED: Method to set the field value.
    */
  public void setSituacao_ped(String PARAM) {
    situacao_ped = PARAM;
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
      tipo_pedidoList.addElement("null");
      tipo_pedidoLabelList.addElement("Todos");
      tipo_pedidoList.addElement("'EX'");
      tipo_pedidoLabelList.addElement("EX");
      tipo_pedidoList.addElement("'PG'");
      tipo_pedidoLabelList.addElement("PG");
      tipo_pedidoList.addElement("'PP'");
      tipo_pedidoLabelList.addElement("PP");
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
    * CND_CDGO: Method to get the field value.
    */
  public String getCnd_cdgo() {
    return cnd_cdgo;
  }
  /**
    * CND_CDGO: Method to set the field value.
    */
  public void setCnd_cdgo(String PARAM) {
    cnd_cdgo = PARAM;
  }
  /**
    * CND_DESC: Method to get the field value.
    */
  public String getCnd_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cnd_cdgo != null && cnd_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cnd db_object = new Cnd();
        String[][] select = { {"cnd_desc",null} };
        Object[][] where = { {"cnd_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cnd_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cnd) results.elementAt(0);
          cnd_desc = (db_object.getCnd_desc() != null) ? db_object.getCnd_desc() + "":"";
        } else {
          cnd_desc = "";
        }
      }
    } catch (Exception e) {
      cnd_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cnd_desc;
  }

  public String[][] getCnd_desc_Ajax(ConsultaPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCnd_cdgo() != null && PARAM.getCnd_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cnd db_object = new Cnd();
        Object[][] where = { {"cnd_cdgo","like",PARAM.getCnd_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cnd) results.elementAt(0);
          list[0] = new String[]{"cnd_desc", (db_object.getCnd_desc() != null) ? db_object.getCnd_desc() + "":""};
        } else {
          list[0] = new String[]{"cnd_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cnd_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CND_DESC: Method to set the field value.
    */
  public void setCnd_desc(String PARAM) {
    cnd_desc = PARAM;
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
  /**
    * DESCRICAO_MARCA: Method to get the field value.
    */
  public String getDescricao_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = {{"descricao_marca",null}};
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          descricao_marca = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
        } else {
          descricao_marca = "";
        }
      }
    } catch (Exception e) {
      descricao_marca = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(ConsultaPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"descricao_marca", (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":""};
        } else {
          list[0] = new String[]{"descricao_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_marca", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
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

  public String[][] getLin_nome_Ajax(ConsultaPedidosActionForm PARAM) {
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
    * REF_DESC: Method to get the field value.
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

  public String[][] getRef_desc_Ajax(ConsultaPedidosActionForm PARAM) {
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
    * REF_DESC: Method to set the field value.
    */
  public void setRef_desc(String PARAM) {
    ref_desc = PARAM;
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
    * CAB_DESC: Method to get the field value.
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

  public String[][] getCab_desc_Ajax(ConsultaPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCab_cdgo() != null && PARAM.getCab_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        Object[][] where = { {"cab_cdgo","=",PARAM.getCab_cdgo()}, };
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
    * CAB_DESC: Method to set the field value.
    */
  public void setCab_desc(String PARAM) {
    cab_desc = PARAM;
  }
  /**
    * COR_CDGO: Method to get the field value.
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Method to set the field value.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * COR_DESC: Method to get the field value.
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

  public String[][] getCor_desc_Ajax(ConsultaPedidosActionForm PARAM) {
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
    * COR_DESC: Method to set the field value.
    */
  public void setCor_desc(String PARAM) {
    cor_desc = PARAM;
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
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "ConsultaPedidos.", e);
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
    * GRUP_ECONOMICO: Method to get the field value.
    */
  public String getGrup_economico() {
    return grup_economico;
  }
  /**
    * GRUP_ECONOMICO: Method to set the field value.
    */
  public void setGrup_economico(String PARAM) {
    grup_economico = PARAM;
  }
  /**
    * GRE_DESCRICAO: Method to get the field value.
    */
  public String getGre_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (grup_economico != null && grup_economico.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        String[][] select = {{"gre_descricao",null}};
        Object[][] where = { {"gre_grupo","=",com.egen.util.text.FormatNumber.toInt(grup_economico)} };
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
        j = null;
      }
    }
    return gre_descricao;
  }

  public String[][] getGre_descricao_Ajax(ConsultaPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGrup_economico() != null && PARAM.getGrup_economico().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        Object[][] where = { {"gre_grupo","like",PARAM.getGrup_economico()} };
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
        j = null;
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
    * DT_ENTREGA: Method to get the field value.
    */
  public String getDt_entrega() {
    return dt_entrega;
  }
  /**
    * DT_ENTREGA: Method to set the field value.
    */
  public void setDt_entrega(String PARAM) {
    dt_entrega = PARAM;
  }
  /**
    * DT_ENTREGA_FIM1: Method to get the field value.
    */
  public String getDt_entrega_fim1() {
    return dt_entrega_fim1;
  }
  /**
    * DT_ENTREGA_FIM1: Method to set the field value.
    */
  public void setDt_entrega_fim1(String PARAM) {
    dt_entrega_fim1 = PARAM;
  }
  /**
    * DT_ENTRADA_INI: Method to get the field value.
    */
  public String getDt_entrada_ini() {
    return dt_entrada_ini;
  }
  /**
    * DT_ENTRADA_INI: Method to set the field value.
    */
  public void setDt_entrada_ini(String PARAM) {
    dt_entrada_ini = PARAM;
  }
  /**
    * DT_ENTRADA_FIM: Method to get the field value.
    */
  public String getDt_entrada_fim() {
    return dt_entrada_fim;
  }
  /**
    * DT_ENTRADA_FIM: Method to set the field value.
    */
  public void setDt_entrada_fim(String PARAM) {
    dt_entrada_fim = PARAM;
  }
  /**
    * DT_EMISSAO_INI1: Method to get the field value.
    */
  public String getDt_emissao_ini1() {
    return dt_emissao_ini1;
  }
  /**
    * DT_EMISSAO_INI1: Method to set the field value.
    */
  public void setDt_emissao_ini1(String PARAM) {
    dt_emissao_ini1 = PARAM;
  }
  /**
    * DT_EMISSAO_FIM1: Method to get the field value.
    */
  public String getDt_emissao_fim1() {
    return dt_emissao_fim1;
  }
  /**
    * DT_EMISSAO_FIM1: Method to set the field value.
    */
  public void setDt_emissao_fim1(String PARAM) {
    dt_emissao_fim1 = PARAM;
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
    * REPRESENTANTE: Method to get the field value.
    */
  public String getRepresentante() {
    return representante;
  }
  /**
    * REPRESENTANTE: Method to set the field value.
    */
  public void setRepresentante(String PARAM) {
    representante = PARAM;
  }
  /**
    * REGIONAL: Method to get the field value.
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Method to set the field value.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * CODIGO: Method to get the field value.
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Method to set the field value.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * RAZAO_SOCIAL: Method to get the field value.
    */
  public String getRazao_social() {
    return razao_social;
  }
  /**
    * RAZAO_SOCIAL: Method to set the field value.
    */
  public void setRazao_social(String PARAM) {
    razao_social = PARAM;
  }
  /**
    * CID_UF: Method to get the field value.
    */
  public String getCid_uf() {
    return cid_uf;
  }
  /**
    * CID_UF: Method to set the field value.
    */
  public void setCid_uf(String PARAM) {
    cid_uf = PARAM;
  }
  /**
    * MOSTRAR_IMAGEM: Method to get the field value.
    */
  public String getMostrar_imagem() {
    return mostrar_imagem;
  }
  /**
    * MOSTRAR_IMAGEM: Method to set the field value.
    */
  public void setMostrar_imagem(String PARAM) {
    mostrar_imagem = PARAM;
  }
  Vector mostrar_imagemList = new Vector(10, 1);
  public java.util.Vector getMostrar_imagemList() {
    if (mostrar_imagemList == null || mostrar_imagemList.size() == 0) {
      mostrar_imagemList.addElement("S");
      mostrar_imagemLabelList.addElement("Sim");
      mostrar_imagemList.addElement("N");
      mostrar_imagemLabelList.addElement("Não");
    }
    java.util.Vector list = mostrar_imagemList;
    return list;
  }
  java.util.Vector mostrar_imagemLabelList = new Vector(10, 1);
  public java.util.Vector getMostrar_imagemLabelList() {
    java.util.Vector list = mostrar_imagemLabelList;
    return list;
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
    * INVOICE: Method to get the field value.
    */
  public String getInvoice() {
    return invoice;
  }
  /**
    * INVOICE: Method to set the field value.
    */
  public void setInvoice(String PARAM) {
    invoice = PARAM;
  }
  /**
    * CB_SOMENTE_ENTRADA: Method to get the field value.
    */
  public String getCb_somente_entrada() {
    return cb_somente_entrada;
  }
  /**
    * CB_SOMENTE_ENTRADA: Method to set the field value.
    */
  public void setCb_somente_entrada(String PARAM) {
    cb_somente_entrada = PARAM;
  }
  /**
    * CB_FORA_NORMAS: Method to get the field value.
    */
  public String getCb_fora_normas() {
    return cb_fora_normas;
  }
  /**
    * CB_FORA_NORMAS: Method to set the field value.
    */
  public void setCb_fora_normas(String PARAM) {
    cb_fora_normas = PARAM;
  }
  /**
    * CB_NAO_IMPRIMIR_LINHAS: Method to get the field value.
    */
  public String getCb_nao_imprimir_linhas() {
    return cb_nao_imprimir_linhas;
  }
  /**
    * CB_NAO_IMPRIMIR_LINHAS: Method to set the field value.
    */
  public void setCb_nao_imprimir_linhas(String PARAM) {
    cb_nao_imprimir_linhas = PARAM;
  }
  /**
    * CB_SOMENTE_INDENIZADOS: Method to get the field value.
    */
  public String getCb_somente_indenizados() {
    return cb_somente_indenizados;
  }
  /**
    * CB_SOMENTE_INDENIZADOS: Method to set the field value.
    */
  public void setCb_somente_indenizados(String PARAM) {
    cb_somente_indenizados = PARAM;
  }
  /**
    * ORDENACAO: Method to get the field value.
    */
  public String getOrdenacao() {
    return ordenacao;
  }
  /**
    * ORDENACAO: Method to set the field value.
    */
  public void setOrdenacao(String PARAM) {
    ordenacao = PARAM;
  }
  /**
    * MIX: Method to get the field value.
    */
  public String getMix() {
    return mix;
  }
  /**
    * MIX: Method to set the field value.
    */
  public void setMix(String PARAM) {
    mix = PARAM;
  }
  Vector mixList = new Vector(10, 1);
  public java.util.Vector getMixList() {
    if (mixList == null || mixList.size() == 0) {
      mixList.addElement("T");
      mixLabelList.addElement("Todos");
      mixList.addElement("M");
      mixLabelList.addElement("Mix");
      mixList.addElement("F");
      mixLabelList.addElement("Fora Mix");
    }
    java.util.Vector list = mixList;
    return list;
  }
  java.util.Vector mixLabelList = new Vector(10, 1);
  public java.util.Vector getMixLabelList() {
    java.util.Vector list = mixLabelList;
    return list;
  }
  /**
    * NR_PEDIDO1: Method to get the field value.
    */
  public String getNr_pedido1() {
    return nr_pedido1;
  }
  /**
    * NR_PEDIDO1: Method to set the field value.
    */
  public void setNr_pedido1(String PARAM) {
    nr_pedido1 = PARAM;
  }
  /**
    * PEDIDO_AFV1: Method to get the field value.
    */
  public String getPedido_afv1() {
    return pedido_afv1;
  }
  /**
    * PEDIDO_AFV1: Method to set the field value.
    */
  public void setPedido_afv1(String PARAM) {
    pedido_afv1 = PARAM;
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
    * PEDIDO_SITES: Method to get the field value.
    */
  public String getPedido_sites() {
    return pedido_sites;
  }
  /**
    * PEDIDO_SITES: Method to set the field value.
    */
  public void setPedido_sites(String PARAM) {
    pedido_sites = PARAM;
  }
  /**
    * PEDIDO_CATALOGO: Method to get the field value.
    */
  public String getPedido_catalogo() {
    return pedido_catalogo;
  }
  /**
    * PEDIDO_CATALOGO: Method to set the field value.
    */
  public void setPedido_catalogo(String PARAM) {
    pedido_catalogo = PARAM;
  }
  /**
    * ORDENACAO1: Method to get the field value.
    */
  public String getOrdenacao1() {
    return ordenacao1;
  }
  /**
    * ORDENACAO1: Method to set the field value.
    */
  public void setOrdenacao1(String PARAM) {
    ordenacao1 = PARAM;
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

  public String[][] getNome_regional_Ajax(ConsultaPedidosActionForm PARAM) {
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

  public String[][] getRep_rzao_Ajax(ConsultaPedidosActionForm PARAM) {
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
    * DT_ENTREGA_INI: Method to get the field value.
    */
  public String getDt_entrega_ini() {
    return dt_entrega_ini;
  }
  /**
    * DT_ENTREGA_INI: Method to set the field value.
    */
  public void setDt_entrega_ini(String PARAM) {
    dt_entrega_ini = PARAM;
  }
  /**
    * DT_ENTREGA_FIM: Method to get the field value.
    */
  public String getDt_entrega_fim() {
    return dt_entrega_fim;
  }
  /**
    * DT_ENTREGA_FIM: Method to set the field value.
    */
  public void setDt_entrega_fim(String PARAM) {
    dt_entrega_fim = PARAM;
  }
  /**
    * DT_EMISSAO_INI: Method to get the field value.
    */
  public String getDt_emissao_ini() {
    return dt_emissao_ini;
  }
  /**
    * DT_EMISSAO_INI: Method to set the field value.
    */
  public void setDt_emissao_ini(String PARAM) {
    dt_emissao_ini = PARAM;
  }
  /**
    * DT_EMISSAO_FIM: Method to get the field value.
    */
  public String getDt_emissao_fim() {
    return dt_emissao_fim;
  }
  /**
    * DT_EMISSAO_FIM: Method to set the field value.
    */
  public void setDt_emissao_fim(String PARAM) {
    dt_emissao_fim = PARAM;
  }
  /**
    * NR_PEDIDO: Method to get the field value.
    */
  public String getNr_pedido() {
    return nr_pedido;
  }
  /**
    * NR_PEDIDO: Method to set the field value.
    */
  public void setNr_pedido(String PARAM) {
    nr_pedido = PARAM;
  }
  /**
    * PEDIDO_AFV: Method to get the field value.
    */
  public String getPedido_afv() {
    return pedido_afv;
  }
  /**
    * PEDIDO_AFV: Method to set the field value.
    */
  public void setPedido_afv(String PARAM) {
    pedido_afv = PARAM;
  }
  /**
    * CLIENTE: Method to get the field value.
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Method to set the field value.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * CLI_SEQ: Method to get the field value.
    */
  public String getCli_seq() {
    return cli_seq;
  }
  /**
    * CLI_SEQ: Method to set the field value.
    */
  public void setCli_seq(String PARAM) {
    cli_seq = PARAM;
  }
  /**
    * SITUACAO1: Method to get the field value.
    */
  public String getSituacao1() {
    return situacao1;
  }
  /**
    * SITUACAO1: Method to set the field value.
    */
  public void setSituacao1(String PARAM) {
    situacao1 = PARAM;
  }
  Vector situacao1List = new Vector(10, 1);
  public java.util.Vector getSituacao1List() {
    if (situacao1List == null || situacao1List.size() == 0) {
      situacao1List.addElement("A");
      situacao1LabelList.addElement("Aberto");
      situacao1List.addElement("B");
      situacao1LabelList.addElement("Bloqueado venda");
      situacao1List.addElement("C");
      situacao1LabelList.addElement("Cancelado");
      situacao1List.addElement("L");
      situacao1LabelList.addElement("Liberado");
      situacao1List.addElement("P");
      situacao1LabelList.addElement("Bloqueado crédito");
      situacao1List.addElement("PF");
      situacao1LabelList.addElement("Parcialmente faturado");
      situacao1List.addElement("R");
      situacao1LabelList.addElement("Reanálise");
      situacao1List.addElement("T");
      situacao1LabelList.addElement("Bloqueado comercial");
      situacao1List.addElement("F");
      situacao1LabelList.addElement("Faturado");
      situacao1List.addElement("");
      situacao1LabelList.addElement("Todos");
    }
    java.util.Vector list = situacao1List;
    return list;
  }
  java.util.Vector situacao1LabelList = new Vector(10, 1);
  public java.util.Vector getSituacao1LabelList() {
    java.util.Vector list = situacao1LabelList;
    return list;
  }
  /**
    * TP_PEDIDO: Method to get the field value.
    */
  public String getTp_pedido() {
    return tp_pedido;
  }
  /**
    * TP_PEDIDO: Method to set the field value.
    */
  public void setTp_pedido(String PARAM) {
    tp_pedido = PARAM;
  }
  Vector tp_pedidoList = new Vector(10, 1);
  public java.util.Vector getTp_pedidoList() {
    if (tp_pedidoList == null || tp_pedidoList.size() == 0) {
      tp_pedidoList.addElement("");
      tp_pedidoLabelList.addElement("Todos");
      tp_pedidoList.addElement("'EX'");
      tp_pedidoLabelList.addElement("EX");
      tp_pedidoList.addElement("'PE'");
      tp_pedidoLabelList.addElement("PE");
      tp_pedidoList.addElement("'PG'");
      tp_pedidoLabelList.addElement("PG");
      tp_pedidoList.addElement("'PP'");
      tp_pedidoLabelList.addElement("PP");
    }
    java.util.Vector list = tp_pedidoList;
    return list;
  }
  java.util.Vector tp_pedidoLabelList = new Vector(10, 1);
  public java.util.Vector getTp_pedidoLabelList() {
    java.util.Vector list = tp_pedidoLabelList;
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
    * PEDIDO_SITES1: Method to get the field value.
    */
  public String getPedido_sites1() {
    return pedido_sites1;
  }
  /**
    * PEDIDO_SITES1: Method to set the field value.
    */
  public void setPedido_sites1(String PARAM) {
    pedido_sites1 = PARAM;
  }
  /**
    * PEDIDO_CATALOGO1: Method to get the field value.
    */
  public String getPedido_catalogo1() {
    return pedido_catalogo1;
  }
  /**
    * PEDIDO_CATALOGO1: Method to set the field value.
    */
  public void setPedido_catalogo1(String PARAM) {
    pedido_catalogo1 = PARAM;
  }
  /**
    * COD_REPRESENTANTE: Method to get the field value.
    */
  public String getCod_representante() {
    return cod_representante;
  }
  /**
    * COD_REPRESENTANTE: Method to set the field value.
    */
  public void setCod_representante(String PARAM) {
    cod_representante = PARAM;
  }
  /**
    * NR_PEDIDO_REP1: Method to get the field value.
    */
  public String getNr_pedido_rep1() {
    return nr_pedido_rep1;
  }
  /**
    * NR_PEDIDO_REP1: Method to set the field value.
    */
  public void setNr_pedido_rep1(String PARAM) {
    nr_pedido_rep1 = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    no_cliente = null;
    cli_cdgo = null;
    seq = null;
    esc_cgc = null;
    rep_cdgo1 = null;
    rep_rzao1 = null;
    agrupar_clientes = null;
    situacao = null;
    situacao_ped = null;
    tipo_pedido = null;
    cnd_cdgo = null;
    cnd_desc = null;
    codigo_marca = null;
    descricao_marca = null;
    lin_cdgo = null;
    lin_nome = null;
    ref_cdgo = null;
    ref_desc = null;
    cab_cdgo = null;
    cab_desc = null;
    cor_cdgo = null;
    cor_desc = null;
    tipo_produto = null;
    grup_economico = null;
    gre_descricao = null;
    dt_entrega = null;
    dt_entrega_fim1 = null;
    dt_entrada_ini = null;
    dt_entrada_fim = null;
    dt_emissao_ini1 = null;
    dt_emissao_fim1 = null;
    dt_faturamento_ini = null;
    dt_faturamento_fim = null;
    representante = null;
    regional = null;
    codigo = null;
    razao_social = null;
    cid_uf = null;
    mostrar_imagem = null;
    reg = null;
    invoice = null;
    cb_somente_entrada = null;
    cb_fora_normas = null;
    cb_nao_imprimir_linhas = null;
    cb_somente_indenizados = null;
    ordenacao = null;
    mix = null;
    nr_pedido1 = null;
    pedido_afv1 = null;
    ped_ped_cliente = null;
    pedido_sites = null;
    pedido_catalogo = null;
    ordenacao1 = null;
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    dt_entrega_ini = null;
    dt_entrega_fim = null;
    dt_emissao_ini = null;
    dt_emissao_fim = null;
    nr_pedido = null;
    pedido_afv = null;
    cliente = null;
    cli_seq = null;
    situacao1 = null;
    tp_pedido = null;
    abre_automaticamente = null;
    mensagem = null;
    pedido_sites1 = null;
    pedido_catalogo1 = null;
    cod_representante = null;
    nr_pedido_rep1 = null;
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
      if (!com.egen.util.text.Validate.isNumber(cli_cdgo)) {
        errors.add("cli_cdgo", new ActionMessage("error.validate.number","Código Cliente","cli_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(seq)) {
        errors.add("seq", new ActionMessage("error.validate.number","Seq.","seq","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(esc_cgc)) {
        errors.add("esc_cgc", new ActionMessage("error.validate.number","CNPJ do Cliente","esc_cgc","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(codigo_marca)) {
        errors.add("codigo_marca", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("ConsultaPedidos.codigo_marca"), "codigo_marca","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(grup_economico)) {
        errors.add("grup_economico", new ActionMessage("error.validate.number","Grupo Econômico","grup_economico","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_entrega)) {
        errors.add("dt_entrega", new ActionMessage("error.validate.date","Data Entrega de","dt_entrega","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
