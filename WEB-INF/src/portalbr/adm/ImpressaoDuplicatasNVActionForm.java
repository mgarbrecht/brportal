package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/03/2006 14:36:08
 * Last Modify Date 22/07/2020 13:40:09
 */

public class ImpressaoDuplicatasNVActionForm extends org.apache.struts.action.ActionForm
{
  public String banco;
  public String pesquisa_grupo;
  public String representante;
  public String regional;
  public String cli_rzao;
  public String cli_cdgo;
  public String esc_seqn;
  public String grupo;
  public String cgc;
  public String mostrar_grupo;
  public String cb_ordenar_data_vencimento;
  public String reunir;
  public String emp_empresa;
  public String emp_razsoc;
  public String dt_vencimento;
  public String data_vencimento_final;
  public String situacao;
  public String duplicatas;
  public String notas_fiscais;
  public String tit_codigo;
  public String codigo;
  public String nome;
  public String bairro;
  public String cidade_uf;
  public String cliente_mercado_externo;
  public boolean gridCheckField;
  public String cliente;
  public String razao;
  public String br;
  public String cid_est;
  public String esc_seqn1;
  public String cli_cdgo1;
  public String codigo_sucessor;
  public String sequencial_sucessor;
  public String razao_social_sucessor;
  public String cid_uf_sucessor;
  public String br_sucessor;
  public String esc_cgc;
  private boolean valida = false;
  public ImpressaoDuplicatasNVActionForm() {
  }
  /**
    * BANCO: Método Gets para este campo
    */
  public String getBanco() {
    return banco;
  }
  /**
    * BANCO: Método Sets pára este campo.
    */
  public void setBanco(String PARAM) {
    banco = PARAM;
  }
  Vector bancoList = new Vector(10, 1);
  public java.util.Vector getBancoList() {
    if (bancoList == null || bancoList.size() == 0) {
      bancoList.addElement("T");
      bancoLabelList.addElement("Todos");
      bancoList.addElement("001");
      bancoLabelList.addElement("Banco do Brasil");
      bancoList.addElement("033");
      bancoLabelList.addElement("Banco Santander");
      bancoList.addElement("237");
      bancoLabelList.addElement("Bradesco");
      bancoList.addElement("041");
      bancoLabelList.addElement("Banrisul");
      bancoList.addElement("104");
      bancoLabelList.addElement("Caixa Econômica Federal");
    }
    java.util.Vector list = bancoList;
    return list;
  }
  java.util.Vector bancoLabelList = new Vector(10, 1);
  public java.util.Vector getBancoLabelList() {
    java.util.Vector list = bancoLabelList;
    return list;
  }
  /**
    * PESQUISA_GRUPO: Método Gets para este campo
    */
  public String getPesquisa_grupo() {
    return pesquisa_grupo;
  }
  /**
    * PESQUISA_GRUPO: Método Sets pára este campo.
    */
  public void setPesquisa_grupo(String PARAM) {
    pesquisa_grupo = PARAM;
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
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
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
    * ESC_SEQN: Método Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: Método Sets pára este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * GRUPO: Método Gets para este campo
    */
  public String getGrupo() {
    return grupo;
  }
  /**
    * GRUPO: Método Sets pára este campo.
    */
  public void setGrupo(String PARAM) {
    grupo = PARAM;
  }
  /**
    * CGC: Método Gets para este campo
    */
  public String getCgc() {
    return cgc;
  }
  /**
    * CGC: Método Sets pára este campo.
    */
  public void setCgc(String PARAM) {
    cgc = PARAM;
  }
  /**
    * MOSTRAR_GRUPO: Método Gets para este campo
    */
  public String getMostrar_grupo() {
    return mostrar_grupo;
  }
  /**
    * MOSTRAR_GRUPO: Método Sets pára este campo.
    */
  public void setMostrar_grupo(String PARAM) {
    mostrar_grupo = PARAM;
  }
  /**
    * CB_ORDENAR_DATA_VENCIMENTO: Método Gets para este campo
    */
  public String getCb_ordenar_data_vencimento() {
    return cb_ordenar_data_vencimento;
  }
  /**
    * CB_ORDENAR_DATA_VENCIMENTO: Método Sets pára este campo.
    */
  public void setCb_ordenar_data_vencimento(String PARAM) {
    cb_ordenar_data_vencimento = PARAM;
  }
  /**
    * REUNIR: Método Gets para este campo
    */
  public String getReunir() {
    return reunir;
  }
  /**
    * REUNIR: Método Sets pára este campo.
    */
  public void setReunir(String PARAM) {
    reunir = PARAM;
  }
  /**
    * EMP_EMPRESA: Método Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Método Sets pára este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * EMP_RAZSOC: Método Gets para este campo
    */
  public String getEmp_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (emp_empresa != null && emp_empresa.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        String[][] select = { {"emp_razsoc",null} };
        Object[][] where = { {"emp_empresa","like",emp_empresa}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Empresa) results.elementAt(0);
          emp_razsoc = (db_object.getEmp_razsoc() != null) ? db_object.getEmp_razsoc() + "":"";
        } else {
          emp_razsoc = "";
        }
      }
    } catch (Exception e) {
      emp_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return emp_razsoc;
  }

  public String[][] getEmp_razsoc_Ajax(ImpressaoDuplicatasNVActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEmp_empresa() != null && PARAM.getEmp_empresa().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        Object[][] where = { {"emp_empresa","like",PARAM.getEmp_empresa()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Empresa) results.elementAt(0);
          list[0] = new String[]{"emp_razsoc", (db_object.getEmp_razsoc() != null) ? db_object.getEmp_razsoc() + "":""};
        } else {
          list[0] = new String[]{"emp_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"emp_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * EMP_RAZSOC: Método Sets pára este campo.
    */
  public void setEmp_razsoc(String PARAM) {
    emp_razsoc = PARAM;
  }
  /**
    * DT_VENCIMENTO: Método Gets para este campo
    */
  public String getDt_vencimento() {
    return dt_vencimento;
  }
  /**
    * DT_VENCIMENTO: Método Sets pára este campo.
    */
  public void setDt_vencimento(String PARAM) {
    dt_vencimento = PARAM;
  }
  /**
    * DATA_VENCIMENTO_FINAL: Método Gets para este campo
    */
  public String getData_vencimento_final() {
    return data_vencimento_final;
  }
  /**
    * DATA_VENCIMENTO_FINAL: Método Sets pára este campo.
    */
  public void setData_vencimento_final(String PARAM) {
    data_vencimento_final = PARAM;
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
  /**
    * DUPLICATAS: Método Gets para este campo
    */
  public String getDuplicatas() {
    return duplicatas;
  }
  /**
    * DUPLICATAS: Método Sets pára este campo.
    */
  public void setDuplicatas(String PARAM) {
    duplicatas = PARAM;
  }
  /**
    * NOTAS_FISCAIS: Método Gets para este campo
    */
  public String getNotas_fiscais() {
    return notas_fiscais;
  }
  /**
    * NOTAS_FISCAIS: Método Sets pára este campo.
    */
  public void setNotas_fiscais(String PARAM) {
    notas_fiscais = PARAM;
  }
  /**
    * TIT_CODIGO: Método Gets para este campo
    */
  public String getTit_codigo() {
    return tit_codigo;
  }
  /**
    * TIT_CODIGO: Método Sets pára este campo.
    */
  public void setTit_codigo(String PARAM) {
    tit_codigo = PARAM;
  }
  /**
    * CODIGO: Método Gets para este campo
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: Método Sets pára este campo.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * NOME: Método Gets para este campo
    */
  public String getNome() {
    return nome;
  }
  /**
    * NOME: Método Sets pára este campo.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * BAIRRO: Método Gets para este campo
    */
  public String getBairro() {
    return bairro;
  }
  /**
    * BAIRRO: Método Sets pára este campo.
    */
  public void setBairro(String PARAM) {
    bairro = PARAM;
  }
  /**
    * CIDADE_UF: Método Gets para este campo
    */
  public String getCidade_uf() {
    return cidade_uf;
  }
  /**
    * CIDADE_UF: Método Sets pára este campo.
    */
  public void setCidade_uf(String PARAM) {
    cidade_uf = PARAM;
  }
  /**
    * CLIENTE_MERCADO_EXTERNO: Método Gets para este campo
    */
  public String getCliente_mercado_externo() {
    return cliente_mercado_externo;
  }
  /**
    * CLIENTE_MERCADO_EXTERNO: Método Sets pára este campo.
    */
  public void setCliente_mercado_externo(String PARAM) {
    cliente_mercado_externo = PARAM;
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * CLIENTE: Método Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: Método Sets pára este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * RAZAO: Método Gets para este campo
    */
  public String getRazao() {
    return razao;
  }
  /**
    * RAZAO: Método Sets pára este campo.
    */
  public void setRazao(String PARAM) {
    razao = PARAM;
  }
  /**
    * BR: Método Gets para este campo
    */
  public String getBr() {
    return br;
  }
  /**
    * BR: Método Sets pára este campo.
    */
  public void setBr(String PARAM) {
    br = PARAM;
  }
  /**
    * CID_EST: Método Gets para este campo
    */
  public String getCid_est() {
    return cid_est;
  }
  /**
    * CID_EST: Método Sets pára este campo.
    */
  public void setCid_est(String PARAM) {
    cid_est = PARAM;
  }
  /**
    * ESC_SEQN1: Método Gets para este campo
    */
  public String getEsc_seqn1() {
    return esc_seqn1;
  }
  /**
    * ESC_SEQN1: Método Sets pára este campo.
    */
  public void setEsc_seqn1(String PARAM) {
    esc_seqn1 = PARAM;
  }
  /**
    * CLI_CDGO1: Método Gets para este campo
    */
  public String getCli_cdgo1() {
    return cli_cdgo1;
  }
  /**
    * CLI_CDGO1: Método Sets pára este campo.
    */
  public void setCli_cdgo1(String PARAM) {
    cli_cdgo1 = PARAM;
  }
  /**
    * CODIGO_SUCESSOR: Método Gets para este campo
    */
  public String getCodigo_sucessor() {
    return codigo_sucessor;
  }
  /**
    * CODIGO_SUCESSOR: Método Sets pára este campo.
    */
  public void setCodigo_sucessor(String PARAM) {
    codigo_sucessor = PARAM;
  }
  /**
    * SEQUENCIAL_SUCESSOR: Método Gets para este campo
    */
  public String getSequencial_sucessor() {
    return sequencial_sucessor;
  }
  /**
    * SEQUENCIAL_SUCESSOR: Método Sets pára este campo.
    */
  public void setSequencial_sucessor(String PARAM) {
    sequencial_sucessor = PARAM;
  }
  /**
    * RAZAO_SOCIAL_SUCESSOR: Método Gets para este campo
    */
  public String getRazao_social_sucessor() {
    return razao_social_sucessor;
  }
  /**
    * RAZAO_SOCIAL_SUCESSOR: Método Sets pára este campo.
    */
  public void setRazao_social_sucessor(String PARAM) {
    razao_social_sucessor = PARAM;
  }
  /**
    * CID_UF_SUCESSOR: Método Gets para este campo
    */
  public String getCid_uf_sucessor() {
    return cid_uf_sucessor;
  }
  /**
    * CID_UF_SUCESSOR: Método Sets pára este campo.
    */
  public void setCid_uf_sucessor(String PARAM) {
    cid_uf_sucessor = PARAM;
  }
  /**
    * BR_SUCESSOR: Método Gets para este campo
    */
  public String getBr_sucessor() {
    return br_sucessor;
  }
  /**
    * BR_SUCESSOR: Método Sets pára este campo.
    */
  public void setBr_sucessor(String PARAM) {
    br_sucessor = PARAM;
  }
  /**
    * ESC_CGC: Método Gets para este campo
    */
  public String getEsc_cgc() {
    return esc_cgc;
  }
  /**
    * ESC_CGC: Método Sets pára este campo.
    */
  public void setEsc_cgc(String PARAM) {
    esc_cgc = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    banco = null;
    pesquisa_grupo = null;
    representante = null;
    regional = null;
    cli_rzao = null;
    cli_cdgo = null;
    esc_seqn = null;
    grupo = null;
    cgc = null;
    mostrar_grupo = null;
    cb_ordenar_data_vencimento = null;
    reunir = null;
    emp_empresa = null;
    emp_razsoc = null;
    dt_vencimento = null;
    data_vencimento_final = null;
    situacao = null;
    duplicatas = null;
    notas_fiscais = null;
    tit_codigo = null;
    codigo = null;
    nome = null;
    bairro = null;
    cidade_uf = null;
    cliente_mercado_externo = null;
    gridCheckField = false;
    cliente = null;
    razao = null;
    br = null;
    cid_est = null;
    esc_seqn1 = null;
    cli_cdgo1 = null;
    codigo_sucessor = null;
    sequencial_sucessor = null;
    razao_social_sucessor = null;
    cid_uf_sucessor = null;
    br_sucessor = null;
    esc_cgc = null;
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
      if (!com.egen.util.text.Validate.isNumber(cli_cdgo)) {
        errors.add("cli_cdgo", new ActionMessage("error.validate.number","Código","cli_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(esc_seqn)) {
        errors.add("esc_seqn", new ActionMessage("error.validate.number","Seq.","esc_seqn","0"));
      }
    }
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
