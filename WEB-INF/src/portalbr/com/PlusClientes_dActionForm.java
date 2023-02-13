package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 27/04/2006 08:57:12
 * Last Modify Date 06/03/2018 10:40:41
 */

public class PlusClientes_dActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String cli_cdgo;
  public String esc_seqn;
  public String cli_rzao;
  public String cli_nome;
  public String seg_desc;
  public String cgc;
  public String inscricao;
  public String bairro_cidade;
  public String ender;
  public String cli_situ;
  public String esc_situacao;
  public String cli_dtin;
  public String cli_exige_pc;
  public String cli_agrupa_notas;
  public String cli_aceita_antecipacao;
  public String situacao;
  public String dt_entrega;
  public String cid_uf;
  private boolean valida = false;
  public PlusClientes_dActionForm() {
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
    * SEG_DESC: Método Gets para este campo
    */
  public String getSeg_desc() {
    return seg_desc;
  }
  /**
    * SEG_DESC: Método Sets pára este campo.
    */
  public void setSeg_desc(String PARAM) {
    seg_desc = PARAM;
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
    * INSCRICAO: Método Gets para este campo
    */
  public String getInscricao() {
    return inscricao;
  }
  /**
    * INSCRICAO: Método Sets pára este campo.
    */
  public void setInscricao(String PARAM) {
    inscricao = PARAM;
  }
  /**
    * BAIRRO_CIDADE: Método Gets para este campo
    */
  public String getBairro_cidade() {
    return bairro_cidade;
  }
  /**
    * BAIRRO_CIDADE: Método Sets pára este campo.
    */
  public void setBairro_cidade(String PARAM) {
    bairro_cidade = PARAM;
  }
  /**
    * ENDER: Método Gets para este campo
    */
  public String getEnder() {
    return ender;
  }
  /**
    * ENDER: Método Sets pára este campo.
    */
  public void setEnder(String PARAM) {
    ender = PARAM;
  }
  /**
    * CLI_SITU: Método Gets para este campo
    */
  public String getCli_situ() {
    return cli_situ;
  }
  /**
    * CLI_SITU: Método Sets pára este campo.
    */
  public void setCli_situ(String PARAM) {
    cli_situ = PARAM;
  }
  /**
    * ESC_SITUACAO: Método Gets para este campo
    */
  public String getEsc_situacao() {
    return esc_situacao;
  }
  /**
    * ESC_SITUACAO: Método Sets pára este campo.
    */
  public void setEsc_situacao(String PARAM) {
    esc_situacao = PARAM;
  }
  /**
    * CLI_DTIN: Método Gets para este campo
    */
  public String getCli_dtin() {
    return cli_dtin;
  }
  /**
    * CLI_DTIN: Método Sets pára este campo.
    */
  public void setCli_dtin(String PARAM) {
    cli_dtin = PARAM;
  }
  /**
    * CLI_EXIGE_PC: Método Gets para este campo
    */
  public String getCli_exige_pc() {
    return cli_exige_pc;
  }
  /**
    * CLI_EXIGE_PC: Método Sets pára este campo.
    */
  public void setCli_exige_pc(String PARAM) {
    cli_exige_pc = PARAM;
  }
  /**
    * CLI_AGRUPA_NOTAS: Método Gets para este campo
    */
  public String getCli_agrupa_notas() {
    return cli_agrupa_notas;
  }
  /**
    * CLI_AGRUPA_NOTAS: Método Sets pára este campo.
    */
  public void setCli_agrupa_notas(String PARAM) {
    cli_agrupa_notas = PARAM;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO: Método Gets para este campo
    */
  public String getCli_aceita_antecipacao() {
    return cli_aceita_antecipacao;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO: Método Sets pára este campo.
    */
  public void setCli_aceita_antecipacao(String PARAM) {
    cli_aceita_antecipacao = PARAM;
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
      situacaoList.addElement("T");
      situacaoLabelList.addElement("Todas as Situações ");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("Pedidos Abertos/Cancelados");
      situacaoList.addElement("F");
      situacaoLabelList.addElement("Pedidos Faturados");
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
    * DT_ENTREGA: Método Gets para este campo
    */
  public String getDt_entrega() {
    return dt_entrega;
  }
  /**
    * DT_ENTREGA: Método Sets pára este campo.
    */
  public void setDt_entrega(String PARAM) {
    dt_entrega = PARAM;
  }
  /**
    * CID_UF: Método Gets para este campo
    */
  public String getCid_uf() {
    return cid_uf;
  }
  /**
    * CID_UF: Método Sets pára este campo.
    */
  public void setCid_uf(String PARAM) {
    cid_uf = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    cli_cdgo = null;
    esc_seqn = null;
    cli_rzao = null;
    cli_nome = null;
    seg_desc = null;
    cgc = null;
    inscricao = null;
    bairro_cidade = null;
    ender = null;
    cli_situ = null;
    esc_situacao = null;
    cli_dtin = null;
    cli_exige_pc = null;
    cli_agrupa_notas = null;
    cli_aceita_antecipacao = null;
    situacao = null;
    dt_entrega = null;
    cid_uf = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("consultar_pedidos_action,", request)) {
      if (com.egen.util.text.Validate.isNull(dt_entrega)) {
        errors.add("dt_entrega", new ActionMessage("error.validate.notnull","Data de Entrega","dt_entrega","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_entrega)) {
        errors.add("dt_entrega", new ActionMessage("error.validate.date","Data de Entrega","dt_entrega","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
