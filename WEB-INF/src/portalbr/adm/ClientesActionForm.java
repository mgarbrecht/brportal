package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/03/2006 09:57:01
 * Last Modify Date 05/10/2021 15:35:52
 */

public class ClientesActionForm extends org.apache.struts.action.ActionForm
{
  public String ecl_cdad;
  public String cli_nome;
  public String representante;
  public String regional;
  public String nome_regional;
  public String rep;
  public String reg;
  public String est_unifed;
  public String est_descri;
  public String gre_grupo;
  public String gre_descricao;
  public String tra_consig;
  public String tra_rzao;
  public String excluir_segmentos;
  public boolean mostrar_representantes;
  public String ordenacao;
  public String pagamento;
  public String situacao;
  public String situacao_cliente_representante;
  public String somente_email;
  public String tipo_arquivo;
  private boolean valida = false;
  public ClientesActionForm() {
  }
  /**
    * ECL_CDAD: Método Gets para este campo
    */
  public String getEcl_cdad() {
    return ecl_cdad;
  }
  /**
    * ECL_CDAD: Método Sets pára este campo.
    */
  public void setEcl_cdad(String PARAM) {
    ecl_cdad = PARAM;
  }
  /**
    * CLI_NOME: Método Gets para este campo
    */
  public String getCli_nome() {
    return cli_nome;
  }
  /**
    * CLI_NOME: Método Sets pára este campo.
    */
  public void setCli_nome(String PARAM) {
    cli_nome = PARAM;
  }
  /**
    * REPRESENTANTE: Método Gets para este campo
    */
  public String getRepresentante() {
    return representante;
  }
  /**
    * REPRESENTANTE: Método Sets pára este campo.
    */
  public void setRepresentante(String PARAM) {
    representante = PARAM;
  }
  /**
    * REGIONAL: Método Gets para este campo
    */
  public String getRegional() {
    return regional;
  }
  /**
    * REGIONAL: Método Sets pára este campo.
    */
  public void setRegional(String PARAM) {
    regional = PARAM;
  }
  /**
    * NOME_REGIONAL: Método Gets para este campo
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (regional != null && regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = {{"nome_regional",null}};
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(regional)} };
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

  public String[][] getNome_regional_Ajax(ClientesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRegional() != null && PARAM.getRegional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getRegional()} };
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
    * REP: Método Gets para este campo
    */
  public String getRep() {
    return rep;
  }
  /**
    * REP: Método Sets pára este campo.
    */
  public void setRep(String PARAM) {
    rep = PARAM;
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
    * EST_UNIFED: Método Gets para este campo
    */
  public String getEst_unifed() {
    return est_unifed;
  }
  /**
    * EST_UNIFED: Método Sets pára este campo.
    */
  public void setEst_unifed(String PARAM) {
    est_unifed = PARAM;
  }
  /**
    * EST_DESCRI: Método Gets para este campo
    */
  public String getEst_descri() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (est_unifed != null && est_unifed.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Estados db_object = new Estados();
        String[][] select = {{"est_descri",null}};
        Object[][] where = { {"est_unifed","like",est_unifed} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Estados) results.elementAt(0);
          est_descri = (db_object.getEst_descri() != null) ? db_object.getEst_descri() + "":"";
        } else {
          est_descri = "";
        }
      }
    } catch (Exception e) {
      est_descri = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return est_descri;
  }

  public String[][] getEst_descri_Ajax(ClientesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEst_unifed() != null && PARAM.getEst_unifed().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Estados db_object = new Estados();
        Object[][] where = { {"est_unifed","like",PARAM.getEst_unifed()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Estados) results.elementAt(0);
          list[0] = new String[]{"est_descri", (db_object.getEst_descri() != null) ? db_object.getEst_descri() + "":""};
        } else {
          list[0] = new String[]{"est_descri", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"est_descri", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * EST_DESCRI: Método Sets pára este campo.
    */
  public void setEst_descri(String PARAM) {
    est_descri = PARAM;
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
        String[][] select = {{"gre_descricao",null}};
        Object[][] where = { {"gre_grupo","=",com.egen.util.text.FormatNumber.toInt(gre_grupo)} };
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

  public String[][] getGre_descricao_Ajax(ClientesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getGre_grupo() != null && PARAM.getGre_grupo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Grupo_economico db_object = new Grupo_economico();
        Object[][] where = { {"gre_grupo","like",PARAM.getGre_grupo()} };
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
    * GRE_DESCRICAO: Método Sets pára este campo.
    */
  public void setGre_descricao(String PARAM) {
    gre_descricao = PARAM;
  }
  /**
    * TRA_CONSIG: Método Gets para este campo
    */
  public String getTra_consig() {
    return tra_consig;
  }
  /**
    * TRA_CONSIG: Método Sets pára este campo.
    */
  public void setTra_consig(String PARAM) {
    tra_consig = PARAM;
  }
  /**
    * TRA_RZAO: Método Gets para este campo
    */
  public String getTra_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tra_consig != null && tra_consig.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        String[][] select = { {"tra_rzao",null} };
        Object[][] where = { {"tra_cdgo","=",com.egen.util.text.FormatNumber.toInt(tra_consig)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          tra_rzao = (db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":"";
        } else {
          tra_rzao = "";
        }
      }
    } catch (Exception e) {
      tra_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return tra_rzao;
  }

  public String[][] getTra_rzao_Ajax(ClientesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getTra_consig() != null && PARAM.getTra_consig().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        Object[][] where = { {"tra_cdgo","like",PARAM.getTra_consig()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          list[0] = new String[]{"tra_rzao", (db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":""};
        } else {
          list[0] = new String[]{"tra_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"tra_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * TRA_RZAO: Método Sets pára este campo.
    */
  public void setTra_rzao(String PARAM) {
    tra_rzao = PARAM;
  }
  /**
    * EXCLUIR_SEGMENTOS: Método Gets para este campo
    */
  public String getExcluir_segmentos() {
    return excluir_segmentos;
  }
  /**
    * EXCLUIR_SEGMENTOS: Método Sets pára este campo.
    */
  public void setExcluir_segmentos(String PARAM) {
    excluir_segmentos = PARAM;
  }
  /**
    * MOSTRAR_REPRESENTANTES: Método Gets para este campo
    */
  public boolean getMostrar_representantes() {
    return mostrar_representantes;
  }
  /**
    * MOSTRAR_REPRESENTANTES: Método Sets pára este campo.
    */
  public void setMostrar_representantes(boolean PARAM) {
    mostrar_representantes = PARAM;
  }
  /**
    * ORDENACAO: Método Gets para este campo
    */
  public String getOrdenacao() {
    return ordenacao;
  }
  /**
    * ORDENACAO: Método Sets pára este campo.
    */
  public void setOrdenacao(String PARAM) {
    ordenacao = PARAM;
  }
  Vector ordenacaoList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoList() {
    if (ordenacaoList == null || ordenacaoList.size() == 0) {
      ordenacaoList.addElement("C");
      ordenacaoLabelList.addElement("Cidade");
      ordenacaoList.addElement("R");
      ordenacaoLabelList.addElement("Razão Social");
      ordenacaoList.addElement("E");
      ordenacaoLabelList.addElement("Estado/Cidade");
      ordenacaoList.addElement("G");
      ordenacaoLabelList.addElement("Grupo/Cidade");
    }
    java.util.Vector list = ordenacaoList;
    return list;
  }
  java.util.Vector ordenacaoLabelList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoLabelList() {
    java.util.Vector list = ordenacaoLabelList;
    return list;
  }
  /**
    * PAGAMENTO: Método Gets para este campo
    */
  public String getPagamento() {
    return pagamento;
  }
  /**
    * PAGAMENTO: Método Sets pára este campo.
    */
  public void setPagamento(String PARAM) {
    pagamento = PARAM;
  }
  Vector pagamentoList = new Vector(10, 1);
  public java.util.Vector getPagamentoList() {
    if (pagamentoList == null || pagamentoList.size() == 0) {
      pagamentoList.addElement("T");
      pagamentoLabelList.addElement("Todos");
      pagamentoList.addElement("N");
      pagamentoLabelList.addElement("Tabela Normal");
      pagamentoList.addElement("V");
      pagamentoLabelList.addElement("Tabela Vendor");
    }
    java.util.Vector list = pagamentoList;
    return list;
  }
  java.util.Vector pagamentoLabelList = new Vector(10, 1);
  public java.util.Vector getPagamentoLabelList() {
    java.util.Vector list = pagamentoLabelList;
    return list;
  }
  /**
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  Vector situacaoList = new Vector(10, 1);
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList.addElement("null");
      situacaoLabelList.addElement("Todos");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("Ativos");
      situacaoList.addElement("I");
      situacaoLabelList.addElement("Inativos");
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
    * SITUACAO_CLIENTE_REPRESENTANTE: Método Gets para este campo
    */
  public String getSituacao_cliente_representante() {
    return situacao_cliente_representante;
  }
  /**
    * SITUACAO_CLIENTE_REPRESENTANTE: Método Sets pára este campo.
    */
  public void setSituacao_cliente_representante(String PARAM) {
    situacao_cliente_representante = PARAM;
  }
  Vector situacao_cliente_representanteList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_representanteList() {
    if (situacao_cliente_representanteList == null || situacao_cliente_representanteList.size() == 0) {
      situacao_cliente_representanteList.addElement("null");
      situacao_cliente_representanteLabelList.addElement("   Todos   ");
      situacao_cliente_representanteList.addElement("A");
      situacao_cliente_representanteLabelList.addElement("Ativos");
      situacao_cliente_representanteList.addElement("I");
      situacao_cliente_representanteLabelList.addElement("Inativos");
    }
    java.util.Vector list = situacao_cliente_representanteList;
    return list;
  }
  java.util.Vector situacao_cliente_representanteLabelList = new Vector(10, 1);
  public java.util.Vector getSituacao_cliente_representanteLabelList() {
    java.util.Vector list = situacao_cliente_representanteLabelList;
    return list;
  }
  /**
    * SOMENTE_EMAIL: Método Gets para este campo
    */
  public String getSomente_email() {
    return somente_email;
  }
  /**
    * SOMENTE_EMAIL: Método Sets pára este campo.
    */
  public void setSomente_email(String PARAM) {
    somente_email = PARAM;
  }
  /**
    * TIPO_ARQUIVO: Método Gets para este campo
    */
  public String getTipo_arquivo() {
    return tipo_arquivo;
  }
  /**
    * TIPO_ARQUIVO: Método Sets pára este campo.
    */
  public void setTipo_arquivo(String PARAM) {
    tipo_arquivo = PARAM;
  }
  Vector tipo_arquivoList = new Vector(10, 1);
  public java.util.Vector getTipo_arquivoList() {
    if (tipo_arquivoList == null || tipo_arquivoList.size() == 0) {
      tipo_arquivoList.addElement("html");
      tipo_arquivoLabelList.addElement("HTML");
      tipo_arquivoList.addElement("pdf");
      tipo_arquivoLabelList.addElement("PDF");
      tipo_arquivoList.addElement("xls");
      tipo_arquivoLabelList.addElement("XLS");
    }
    java.util.Vector list = tipo_arquivoList;
    return list;
  }
  java.util.Vector tipo_arquivoLabelList = new Vector(10, 1);
  public java.util.Vector getTipo_arquivoLabelList() {
    java.util.Vector list = tipo_arquivoLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ecl_cdad = null;
    cli_nome = null;
    representante = null;
    regional = null;
    nome_regional = null;
    rep = null;
    reg = null;
    est_unifed = null;
    est_descri = null;
    gre_grupo = null;
    gre_descricao = null;
    tra_consig = null;
    tra_rzao = null;
    excluir_segmentos = null;
    mostrar_representantes = false;
    ordenacao = null;
    pagamento = null;
    situacao = null;
    situacao_cliente_representante = null;
    somente_email = null;
    tipo_arquivo = null;
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
      if (!com.egen.util.text.Validate.isNumber(regional)) {
        errors.add("regional", new ActionMessage("error.validate.number","Regional","regional","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(gre_grupo)) {
        errors.add("gre_grupo", new ActionMessage("error.validate.number","Grupo","gre_grupo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
