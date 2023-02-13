package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/03/2006 15:41:20
 * Last Modify Date 30/01/2023 16:23:13
 */

public class PoiAbertoRepEntradaPedidosActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_regional;
  public String nome_regional;
  public String rep_cdgo;
  public String rep_rzao;
  public String codigo_marca;
  public String descricao_marca;
  public String segmento;
  public String abrir_segmento;
  public String unidade_negocio;
  public String unn_descri;
  public String mes;
  public String ano;
  public String mes_final;
  public String ano_final;
  public String tipo_relatorio;
  public String cb_representante_marca;
  public String f_regional;
  public String f_representante;
  public String reg;
  private boolean valida = false;
  public PoiAbertoRepEntradaPedidosActionForm() {
  }
  /**
    * CODIGO_REGIONAL: Método Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
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

  public String[][] getNome_regional_Ajax(PoiAbertoRepresentanteActionForm PARAM) {
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
    * NOME_REGIONAL: Método Sets pára este campo.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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

  public String[][] getRep_rzao_Ajax(PoiAbertoRepresentanteActionForm PARAM) {
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
    * REP_RZAO: Método Sets pára este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
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

  public String[][] getDescricao_marca_Ajax(PoiAbertoRepEntradaPedidosActionForm PARAM) {
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
    * SEGMENTO: Método Gets para este campo
    */
  public String getSegmento() {
    return segmento;
  }
  /**
    * SEGMENTO: Método Sets pára este campo.
    */
  public void setSegmento(String PARAM) {
    segmento = PARAM;
  }
  Vector segmentoList = new Vector(10, 1);
  public java.util.Vector getSegmentoList() {
    if (segmentoList == null || segmentoList.size() == 0) {
      segmentoList.addElement("T");
      segmentoLabelList.addElement("Todos");
      segmentoList.addElement("C");
      segmentoLabelList.addElement("Calçados");
      segmentoList.addElement("B");
      segmentoLabelList.addElement("Bolsas");
      segmentoList.addElement("M");
      segmentoLabelList.addElement("Meias");
      segmentoList.addElement("O");
      segmentoLabelList.addElement("Óculos");
      segmentoList.addElement("V");
      segmentoLabelList.addElement("Vestuário");
    }
    java.util.Vector list = segmentoList;
    return list;
  }
  java.util.Vector segmentoLabelList = new Vector(10, 1);
  public java.util.Vector getSegmentoLabelList() {
    java.util.Vector list = segmentoLabelList;
    return list;
  }
  /**
    * ABRIR_SEGMENTO: Método Gets para este campo
    */
  public String getAbrir_segmento() {
    return abrir_segmento;
  }
  /**
    * ABRIR_SEGMENTO: Método Sets pára este campo.
    */
  public void setAbrir_segmento(String PARAM) {
    abrir_segmento = PARAM;
  }
  Vector abrir_segmentoList = new Vector(10, 1);
  public java.util.Vector getAbrir_segmentoList() {
    if (abrir_segmentoList == null || abrir_segmentoList.size() == 0) {
      abrir_segmentoList.addElement("N");
      abrir_segmentoLabelList.addElement("Não");
      abrir_segmentoList.addElement("S");
      abrir_segmentoLabelList.addElement("Sim");
    }
    java.util.Vector list = abrir_segmentoList;
    return list;
  }
  java.util.Vector abrir_segmentoLabelList = new Vector(10, 1);
  public java.util.Vector getAbrir_segmentoLabelList() {
    java.util.Vector list = abrir_segmentoLabelList;
    return list;
  }
  /**
    * UNIDADE_NEGOCIO: Método Gets para este campo
    */
  public String getUnidade_negocio() {
    return unidade_negocio;
  }
  /**
    * UNIDADE_NEGOCIO: Método Sets pára este campo.
    */
  public void setUnidade_negocio(String PARAM) {
    unidade_negocio = PARAM;
  }
  /**
    * UNN_DESCRI: Método Gets para este campo
    */
  public String getUnn_descri() {
    return unn_descri;
  }
  /**
    * UNN_DESCRI: Método Sets pára este campo.
    */
  public void setUnn_descri(String PARAM) {
    unn_descri = PARAM;
  }
  /**
    * MES: Método Gets para este campo
    */
  public String getMes() {
    return mes;
  }
  /**
    * MES: Método Sets pára este campo.
    */
  public void setMes(String PARAM) {
    mes = PARAM;
  }
  /**
    * ANO: Método Gets para este campo
    */
  public String getAno() {
    return ano;
  }
  /**
    * ANO: Método Sets pára este campo.
    */
  public void setAno(String PARAM) {
    ano = PARAM;
  }
  /**
    * MES_FINAL: Método Gets para este campo
    */
  public String getMes_final() {
    return mes_final;
  }
  /**
    * MES_FINAL: Método Sets pára este campo.
    */
  public void setMes_final(String PARAM) {
    mes_final = PARAM;
  }
  /**
    * ANO_FINAL: Método Gets para este campo
    */
  public String getAno_final() {
    return ano_final;
  }
  /**
    * ANO_FINAL: Método Sets pára este campo.
    */
  public void setAno_final(String PARAM) {
    ano_final = PARAM;
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
      tipo_relatorioList.addElement("N");
      tipo_relatorioLabelList.addElement("Representante");
      tipo_relatorioList.addElement("R");
      tipo_relatorioLabelList.addElement("Marca");
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
    * CB_REPRESENTANTE_MARCA: Método Gets para este campo
    */
  public String getCb_representante_marca() {
    return cb_representante_marca;
  }
  /**
    * CB_REPRESENTANTE_MARCA: Método Sets pára este campo.
    */
  public void setCb_representante_marca(String PARAM) {
    cb_representante_marca = PARAM;
  }
  /**
    * F_REGIONAL: Método Gets para este campo
    */
  public String getF_regional() {
    return f_regional;
  }
  /**
    * F_REGIONAL: Método Sets pára este campo.
    */
  public void setF_regional(String PARAM) {
    f_regional = PARAM;
  }
  /**
    * F_REPRESENTANTE: Método Gets para este campo
    */
  public String getF_representante() {
    return f_representante;
  }
  /**
    * F_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setF_representante(String PARAM) {
    f_representante = PARAM;
  }
  /**
    * REG: Método Gets para este campo
    */
  public String getReg() {
    return reg;
  }
  /**
    * REG: Método Sets pára este campo.
    */
  public void setReg(String PARAM) {
    reg = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    codigo_marca = null;
    descricao_marca = null;
    segmento = null;
    abrir_segmento = null;
    unidade_negocio = null;
    unn_descri = null;
    mes = null;
    ano = null;
    mes_final = null;
    ano_final = null;
    tipo_relatorio = null;
    cb_representante_marca = null;
    f_regional = null;
    f_representante = null;
    reg = null;
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
      if (!com.egen.util.text.Validate.isNumber(codigo_regional)) {
        errors.add("codigo_regional", new ActionMessage("error.validate.number","Regional","codigo_regional","0"));
      }
      if (com.egen.util.text.Validate.isNull(mes)) {
        errors.add("mes", new ActionMessage("error.validate.notnull","Mês/Ano Inicial","mes","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(mes, "^[0-9]*$")) {
        errors.add("mes", new ActionMessage("error.validate.regex","Mês/Ano Inicial","mes","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano)) {
        errors.add("ano", new ActionMessage("error.validate.notnull","ANO","ano","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ano, "^[0-9]*$")) {
        errors.add("ano", new ActionMessage("error.validate.regex","ANO","ano","0"));
      }
      if (com.egen.util.text.Validate.isNull(mes_final)) {
        errors.add("mes_final", new ActionMessage("error.validate.notnull","Mês/Ano Final","mes_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(mes_final, "^[0-9]*$")) {
        errors.add("mes_final", new ActionMessage("error.validate.regex","Mês/Ano Final","mes_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano_final)) {
        errors.add("ano_final", new ActionMessage("error.validate.notnull","/","ano_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ano_final, "^[0-9]*$")) {
        errors.add("ano_final", new ActionMessage("error.validate.regex","/","ano_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
