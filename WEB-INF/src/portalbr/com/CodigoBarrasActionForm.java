package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 06/06/2016 15:30:00
 * Last Modify Date 14/03/2023 11:27:46
 */

public class CodigoBarrasActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  public String codigo_marca;
  public String descricao_marca;
  public String lin_cdgo;
  public String lin_nome;
  public String cod_refer;
  public String ref_desc;
  public String cabedal;
  public String cab_desc;
  public String cor;
  public String cor_desc;
  public String cli_cdgo;
  public String cli_rzao;
  public String ean13;
  public String grade;
  public String status;
  public String ref_cdgo;
  public String ano_fatura_proforma;
  public String numero_fatura_proforma;
  public String trazer_pares;
  public String trazer_precos;
  public String ano_fatura_amostra;
  public String numero_fatura_amostra;
  public String pedido;
  public String lote;
  public String organizar_loja;
  public String organizar_produto_grade;
  public String gerarImagem;
  public String agrupar_modelo;
  private boolean valida = false;
  public CodigoBarrasActionForm() {
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
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("ean13");
      tipoLabelList.addElement("EAN13");
      tipoList.addElement("dun14");
      tipoLabelList.addElement("DUN14");
      tipoList.addElement("sscc");
      tipoLabelList.addElement("SSCC");
      tipoList.addElement("ambos");
      tipoLabelList.addElement("EAN13 + DUN14");
    }
    java.util.Vector list = tipoList;
    return list;
  }
  java.util.Vector tipoLabelList = new Vector(10, 1);
  public java.util.Vector getTipoLabelList() {
    java.util.Vector list = tipoLabelList;
    return list;
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
    * DESCRICAO_MARCA: Método Gets para este campo
    */
  public String getDescricao_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)}, };
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
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(CodigoBarrasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()}, };
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
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA: Método Sets pára este campo.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
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
        String[][] select = {{"lin_nome",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)}, };
        java.util.Vector results = j.select(db_object, select, where, null, null, null);
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
        j = null;
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(CodigoBarrasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()} };
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
        j = null;
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
    * COD_REFER: Método Gets para este campo
    */
  public String getCod_refer() {
    return cod_refer;
  }
  /**
    * COD_REFER: Método Sets pára este campo.
    */
  public void setCod_refer(String PARAM) {
    cod_refer = PARAM;
  }
  /**
    * REF_DESC: Método Gets para este campo
    */
  public String getRef_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0 && cod_refer != null && cod_refer.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        String[][] select = {{"ref_desc",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(lin_cdgo)}, {"ref_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cod_refer)}, };
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
        j = null;
      }
    }
    return ref_desc;
  }

  public String[][] getRef_desc_Ajax(CodigoBarrasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0 && PARAM.getCod_refer() != null && PARAM.getCod_refer().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        Object[][] where = { {"lin_cdgo","=",PARAM.getLin_cdgo()}, {"ref_cdgo","=",PARAM.getCod_refer()} };
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
        j = null;
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
    * CABEDAL: Método Gets para este campo
    */
  public String getCabedal() {
    return cabedal;
  }
  /**
    * CABEDAL: Método Sets pára este campo.
    */
  public void setCabedal(String PARAM) {
    cabedal = PARAM;
  }
  /**
    * CAB_DESC: Método Gets para este campo
    */
  public String getCab_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cabedal != null && cabedal.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        String[][] select = {{"cab_desc",null}};
        Object[][] where = { {"cab_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cabedal)}, };
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
        j = null;
      }
    }
    return cab_desc;
  }

  public String[][] getCab_desc_Ajax(CodigoBarrasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCabedal() != null && PARAM.getCabedal().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        Object[][] where = { {"cab_cdgo","=",PARAM.getCabedal()} };
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
        j = null;
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
    * COR: Método Gets para este campo
    */
  public String getCor() {
    return cor;
  }
  /**
    * COR: Método Sets pára este campo.
    */
  public void setCor(String PARAM) {
    cor = PARAM;
  }
  /**
    * COR_DESC: Método Gets para este campo
    */
  public String getCor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cor != null && cor.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        String[][] select = {{"cor_desc",null}};
        Object[][] where = { {"cor_cdgo","=",com.egen.util.text.FormatNumber.toInt(cor)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, null, null, null);
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
        j = null;
      }
    }

    return cor_desc;
  }


  public String[][] getCor_desc_Ajax(CodigoBarrasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCor() != null && PARAM.getCor().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        Object[][] where = { {"cor_cdgo","like",PARAM.getCor()}, };
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
        j = null;
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

  public String[][] getCli_rzao_Ajax(CodigoBarrasActionForm PARAM) {
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
    * EAN13: Método Gets para este campo
    */
  public String getEan13() {
    return ean13;
  }
  /**
    * EAN13: Método Sets pára este campo.
    */
  public void setEan13(String PARAM) {
    ean13 = PARAM;
  }
  /**
    * GRADE: Método Gets para este campo
    */
  public String getGrade() {
    return grade;
  }
  /**
    * GRADE: Método Sets pára este campo.
    */
  public void setGrade(String PARAM) {
    grade = PARAM;
  }
  /**
    * STATUS: Método Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Método Sets pára este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  Vector statusList = new Vector(10, 1);
  public java.util.Vector getStatusList() {
    if (statusList == null || statusList.size() == 0) {
      statusList.addElement("");
      statusLabelList.addElement("CodigoBarra.todas");
      statusList.addElement("A");
      statusLabelList.addElement("CodigoBarra.ativas");
      statusList.addElement("I");
      statusLabelList.addElement("CodigoBarra.inativas");
    }
    java.util.Vector list = statusList;
    return list;
  }
  java.util.Vector statusLabelList = new Vector(10, 1);
  public java.util.Vector getStatusLabelList() {
    java.util.Vector list = statusLabelList;
    return list;
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
    * ANO_FATURA_PROFORMA: Método Gets para este campo
    */
  public String getAno_fatura_proforma() {
    return ano_fatura_proforma;
  }
  /**
    * ANO_FATURA_PROFORMA: Método Sets pára este campo.
    */
  public void setAno_fatura_proforma(String PARAM) {
    ano_fatura_proforma = PARAM;
  }
  /**
    * NUMERO_FATURA_PROFORMA: Método Gets para este campo
    */
  public String getNumero_fatura_proforma() {
    return numero_fatura_proforma;
  }
  /**
    * NUMERO_FATURA_PROFORMA: Método Sets pára este campo.
    */
  public void setNumero_fatura_proforma(String PARAM) {
    numero_fatura_proforma = PARAM;
  }
  /**
    * TRAZER_PARES: Método Gets para este campo
    */
  public String getTrazer_pares() {
    return trazer_pares;
  }
  /**
    * TRAZER_PARES: Método Sets pára este campo.
    */
  public void setTrazer_pares(String PARAM) {
    trazer_pares = PARAM;
  }
  /**
    * TRAZER_PRECOS: Método Gets para este campo
    */
  public String getTrazer_precos() {
    return trazer_precos;
  }
  /**
    * TRAZER_PRECOS: Método Sets pára este campo.
    */
  public void setTrazer_precos(String PARAM) {
    trazer_precos = PARAM;
  }
  /**
    * ANO_FATURA_AMOSTRA: Método Gets para este campo
    */
  public String getAno_fatura_amostra() {
    return ano_fatura_amostra;
  }
  /**
    * ANO_FATURA_AMOSTRA: Método Sets pára este campo.
    */
  public void setAno_fatura_amostra(String PARAM) {
    ano_fatura_amostra = PARAM;
  }
  /**
    * NUMERO_FATURA_AMOSTRA: Método Gets para este campo
    */
  public String getNumero_fatura_amostra() {
    return numero_fatura_amostra;
  }
  /**
    * NUMERO_FATURA_AMOSTRA: Método Sets pára este campo.
    */
  public void setNumero_fatura_amostra(String PARAM) {
    numero_fatura_amostra = PARAM;
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
    * LOTE: Método Gets para este campo
    */
  public String getLote() {
    return lote;
  }
  /**
    * LOTE: Método Sets pára este campo.
    */
  public void setLote(String PARAM) {
    lote = PARAM;
  }
  /**
    * ORGANIZAR_LOJA: Método Gets para este campo
    */
  public String getOrganizar_loja() {
    return organizar_loja;
  }
  /**
    * ORGANIZAR_LOJA: Método Sets pára este campo.
    */
  public void setOrganizar_loja(String PARAM) {
    organizar_loja = PARAM;
  }
  Vector organizar_lojaList = new Vector(10, 1);
  public java.util.Vector getOrganizar_lojaList() {
    if (organizar_lojaList == null || organizar_lojaList.size() == 0) {
      organizar_lojaList.addElement("N");
      organizar_lojaLabelList.addElement("Não");
      organizar_lojaList.addElement("S");
      organizar_lojaLabelList.addElement("Sim");
    }
    java.util.Vector list = organizar_lojaList;
    return list;
  }
  java.util.Vector organizar_lojaLabelList = new Vector(10, 1);
  public java.util.Vector getOrganizar_lojaLabelList() {
    java.util.Vector list = organizar_lojaLabelList;
    return list;
  }
  /**
    * ORGANIZAR_PRODUTO_GRADE: Método Gets para este campo
    */
  public String getOrganizar_produto_grade() {
    return organizar_produto_grade;
  }
  /**
    * ORGANIZAR_PRODUTO_GRADE: Método Sets pára este campo.
    */
  public void setOrganizar_produto_grade(String PARAM) {
    organizar_produto_grade = PARAM;
  }
  Vector organizar_produto_gradeList = new Vector(10, 1);
  public java.util.Vector getOrganizar_produto_gradeList() {
    if (organizar_produto_gradeList == null || organizar_produto_gradeList.size() == 0) {
      organizar_produto_gradeList.addElement("N");
      organizar_produto_gradeLabelList.addElement("Não");
      organizar_produto_gradeList.addElement("S");
      organizar_produto_gradeLabelList.addElement("Sim");
    }
    java.util.Vector list = organizar_produto_gradeList;
    return list;
  }
  java.util.Vector organizar_produto_gradeLabelList = new Vector(10, 1);
  public java.util.Vector getOrganizar_produto_gradeLabelList() {
    java.util.Vector list = organizar_produto_gradeLabelList;
    return list;
  }
  /**
    * GERARIMAGEM: Método Gets para este campo
    */
  public String getGerarImagem() {
    return gerarImagem;
  }
  /**
    * GERARIMAGEM: Método Sets pára este campo.
    */
  public void setGerarImagem(String PARAM) {
    gerarImagem = PARAM;
  }
  /**
    * AGRUPAR_MODELO: Método Gets para este campo
    */
  public String getAgrupar_modelo() {
    return agrupar_modelo;
  }
  /**
    * AGRUPAR_MODELO: Método Sets pára este campo.
    */
  public void setAgrupar_modelo(String PARAM) {
    agrupar_modelo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo = null;
    codigo_marca = null;
    descricao_marca = null;
    lin_cdgo = null;
    lin_nome = null;
    cod_refer = null;
    ref_desc = null;
    cabedal = null;
    cab_desc = null;
    cor = null;
    cor_desc = null;
    cli_cdgo = null;
    cli_rzao = null;
    ean13 = null;
    grade = null;
    status = null;
    ref_cdgo = null;
    ano_fatura_proforma = null;
    numero_fatura_proforma = null;
    trazer_pares = null;
    trazer_precos = null;
    ano_fatura_amostra = null;
    numero_fatura_amostra = null;
    pedido = null;
    lote = null;
    organizar_loja = null;
    organizar_produto_grade = null;
    gerarImagem = null;
    agrupar_modelo = null;
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
      if (!com.egen.util.text.Validate.isNumber(cod_refer)) {
        errors.add("cod_refer", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarra.cod_refer"), "cod_refer","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(cabedal)) {
        errors.add("cabedal", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarra.cabedal"), "cabedal","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(cor)) {
        errors.add("cor", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarra.cor"), "cor","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
