package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/03/2006 14:36:08
 * Last Modify Date 14/10/2019 16:47:01
 */

public class TitulosActionForm extends org.apache.struts.action.ActionForm
{
  public String representante;
  public String regional;
  public String cli_rzao;
  public String cli_cdgo;
  public String esc_seqn;
  public String cgc;
  public String reunir;
  public String emp_empresa;
  public String dt_vencimento;
  public String situacao;
  public String tit_codigo;
  public String codigo;
  public String nome;
  public String bairro;
  public String cidade_uf;
  public String cliente_mercado_externo;
  private boolean valida = false;
  public TitulosActionForm() {
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
    * CLI_RZAO: Method to get the field value.
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Method to set the field value.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
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
    * CGC: Method to get the field value.
    */
  public String getCgc() {
    return cgc;
  }
  /**
    * CGC: Method to set the field value.
    */
  public void setCgc(String PARAM) {
    cgc = PARAM;
  }
  /**
    * REUNIR: Method to get the field value.
    */
  public String getReunir() {
    return reunir;
  }
  /**
    * REUNIR: Method to set the field value.
    */
  public void setReunir(String PARAM) {
    reunir = PARAM;
  }
  /**
    * EMP_EMPRESA: Method to get the field value.
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Method to set the field value.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  private Vector emp_empresaList = new Vector(10, 10);
  public void setEmp_empresaList(java.util.Vector VECTOR) {
    emp_empresaList = VECTOR;
  }
  public java.util.Vector getEmp_empresaList() {
    emp_empresaList = new Vector(10, 10);
    emp_empresaLabelList = new Vector(10, 10);
    emp_empresaList.addElement("");
    java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
    emp_empresaLabelList.addElement("Todas");
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      Empresa db_object = new Empresa();
      String[][] select = {{"emp_empresa", null},{"emp_razsoc", null}};
      Object[][] where = {{"emp_empresa","<>","3"}};
      String[] order = {"emp_razsoc"};
      String[] groupby = null;
      String[] having = null;
      Vector results = j.select(db_object, select, where, groupby, having, order);
      for (int i = 0; i < results.size(); i++) {
        db_object = (Empresa) results.elementAt(i);
        emp_empresaList.addElement(""+db_object.getEmp_empresa());
        emp_empresaLabelList.addElement(db_object.getEmp_empresa() + " - "+db_object.getEmp_razsoc());
      }
    } catch (Exception e) {
      com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Titulos.", e);
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return emp_empresaList;
  }
  private java.util.Vector emp_empresaLabelList = new Vector(10, 10);
  public void setEmp_empresaLabelList(java.util.Vector VECTOR) {
    emp_empresaLabelList = VECTOR;
  }
  public java.util.Vector getEmp_empresaLabelList() {
    return emp_empresaLabelList;
  }/**
    * DT_VENCIMENTO: Method to get the field value.
    */

  public String getDt_vencimento() {
    return dt_vencimento;
  }
  /**
    * DT_VENCIMENTO: Method to set the field value.
    */
  public void setDt_vencimento(String PARAM) {
    dt_vencimento = PARAM;
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
      situacaoList.addElement("T");
      situacaoLabelList.addElement("Todos");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("Abertos");
      situacaoList.addElement("L");
      situacaoLabelList.addElement("Liquidados");
      situacaoList.addElement("C");
      situacaoLabelList.addElement("Cancelados");
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
    * TIT_CODIGO: Method to get the field value.
    */
  public String getTit_codigo() {
    return tit_codigo;
  }
  /**
    * TIT_CODIGO: Method to set the field value.
    */
  public void setTit_codigo(String PARAM) {
    tit_codigo = PARAM;
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
    * NOME: Method to get the field value.
    */
  public String getNome() {
    return nome;
  }
  /**
    * NOME: Method to set the field value.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * BAIRRO: Method to get the field value.
    */
  public String getBairro() {
    return bairro;
  }
  /**
    * BAIRRO: Method to set the field value.
    */
  public void setBairro(String PARAM) {
    bairro = PARAM;
  }
  /**
    * CIDADE_UF: Method to get the field value.
    */
  public String getCidade_uf() {
    return cidade_uf;
  }
  /**
    * CIDADE_UF: Method to set the field value.
    */
  public void setCidade_uf(String PARAM) {
    cidade_uf = PARAM;
  }
  /**
    * CLIENTE_MERCADO_EXTERNO: Method to get the field value.
    */
  public String getCliente_mercado_externo() {
    return cliente_mercado_externo;
  }
  /**
    * CLIENTE_MERCADO_EXTERNO: Method to set the field value.
    */
  public void setCliente_mercado_externo(String PARAM) {
    cliente_mercado_externo = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    representante = null;
    regional = null;
    cli_rzao = null;
    cli_cdgo = null;
    esc_seqn = null;
    cgc = null;
    reunir = null;
    emp_empresa = null;
    dt_vencimento = null;
    situacao = null;
    tit_codigo = null;
    codigo = null;
    nome = null;
    bairro = null;
    cidade_uf = null;
    cliente_mercado_externo = null;
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
        errors.add("cli_cdgo", new ActionMessage("error.validate.number","Código","cli_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(esc_seqn)) {
        errors.add("esc_seqn", new ActionMessage("error.validate.number","Seq.","esc_seqn","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_vencimento)) {
        errors.add("dt_vencimento", new ActionMessage("error.validate.date","Data Vencimento","dt_vencimento","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
