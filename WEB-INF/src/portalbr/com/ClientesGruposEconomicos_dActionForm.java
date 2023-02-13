package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/08/2006 17:05:23
 * Last Modify Date 03/10/2019 09:10:05
 */

public class ClientesGruposEconomicos_dActionForm extends org.apache.struts.action.ActionForm
{
  public String cliente;
  public String cli_rzao;
  public String cli_nome;
  public String seg_desc;
  public String cgc;
  public String inscricao;
  public String contato;
  public String cli_situ;
  public String esc_situacao;
  public String cli_dtin;
  public String cli_exige_pc;
  public String cli_agrupa_notas;
  public String cli_aceita_antecipacao;
  public String ender;
  public String bairro_cidade;
  public String cid_uf;
  public String esc_seqn;
  public String cli_cdgo;
  private boolean valida = false;
  public ClientesGruposEconomicos_dActionForm() {
  }
  /**
    * CLIENTE: M�todo Gets para este campo
    */
  public String getCliente() {
    return cliente;
  }
  /**
    * CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setCliente(String PARAM) {
    cliente = PARAM;
  }
  /**
    * CLI_RZAO: M�todo Gets para este campo
    */
  public String getCli_rzao() {
    return cli_rzao;
  }
  /**
    * CLI_RZAO: M�todo Sets p�ra este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * CLI_NOME: M�todo Gets para este campo
    */
  public String getCli_nome() {
    return cli_nome;
  }
  /**
    * CLI_NOME: M�todo Sets p�ra este campo.
    */
  public void setCli_nome(String PARAM) {
    cli_nome = PARAM;
  }
  /**
    * SEG_DESC: M�todo Gets para este campo
    */
  public String getSeg_desc() {
    return seg_desc;
  }
  /**
    * SEG_DESC: M�todo Sets p�ra este campo.
    */
  public void setSeg_desc(String PARAM) {
    seg_desc = PARAM;
  }
  /**
    * CGC: M�todo Gets para este campo
    */
  public String getCgc() {
    return cgc;
  }
  /**
    * CGC: M�todo Sets p�ra este campo.
    */
  public void setCgc(String PARAM) {
    cgc = PARAM;
  }
  /**
    * INSCRICAO: M�todo Gets para este campo
    */
  public String getInscricao() {
    return inscricao;
  }
  /**
    * INSCRICAO: M�todo Sets p�ra este campo.
    */
  public void setInscricao(String PARAM) {
    inscricao = PARAM;
  }
  /**
    * CONTATO: M�todo Gets para este campo
    */
  public String getContato() {
    return contato;
  }
  /**
    * CONTATO: M�todo Sets p�ra este campo.
    */
  public void setContato(String PARAM) {
    contato = PARAM;
  }
  /**
    * CLI_SITU: M�todo Gets para este campo
    */
  public String getCli_situ() {
    return cli_situ;
  }
  /**
    * CLI_SITU: M�todo Sets p�ra este campo.
    */
  public void setCli_situ(String PARAM) {
    cli_situ = PARAM;
  }
  /**
    * ESC_SITUACAO: M�todo Gets para este campo
    */
  public String getEsc_situacao() {
    return esc_situacao;
  }
  /**
    * ESC_SITUACAO: M�todo Sets p�ra este campo.
    */
  public void setEsc_situacao(String PARAM) {
    esc_situacao = PARAM;
  }
  /**
    * CLI_DTIN: M�todo Gets para este campo
    */
  public String getCli_dtin() {
    return cli_dtin;
  }
  /**
    * CLI_DTIN: M�todo Sets p�ra este campo.
    */
  public void setCli_dtin(String PARAM) {
    cli_dtin = PARAM;
  }
  /**
    * CLI_EXIGE_PC: M�todo Gets para este campo
    */
  public String getCli_exige_pc() {
    return cli_exige_pc;
  }
  /**
    * CLI_EXIGE_PC: M�todo Sets p�ra este campo.
    */
  public void setCli_exige_pc(String PARAM) {
    cli_exige_pc = PARAM;
  }
  /**
    * CLI_AGRUPA_NOTAS: M�todo Gets para este campo
    */
  public String getCli_agrupa_notas() {
    return cli_agrupa_notas;
  }
  /**
    * CLI_AGRUPA_NOTAS: M�todo Sets p�ra este campo.
    */
  public void setCli_agrupa_notas(String PARAM) {
    cli_agrupa_notas = PARAM;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO: M�todo Gets para este campo
    */
  public String getCli_aceita_antecipacao() {
    return cli_aceita_antecipacao;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO: M�todo Sets p�ra este campo.
    */
  public void setCli_aceita_antecipacao(String PARAM) {
    cli_aceita_antecipacao = PARAM;
  }
  /**
    * ENDER: M�todo Gets para este campo
    */
  public String getEnder() {
    return ender;
  }
  /**
    * ENDER: M�todo Sets p�ra este campo.
    */
  public void setEnder(String PARAM) {
    ender = PARAM;
  }
  /**
    * BAIRRO_CIDADE: M�todo Gets para este campo
    */
  public String getBairro_cidade() {
    return bairro_cidade;
  }
  /**
    * BAIRRO_CIDADE: M�todo Sets p�ra este campo.
    */
  public void setBairro_cidade(String PARAM) {
    bairro_cidade = PARAM;
  }
  /**
    * CID_UF: M�todo Gets para este campo
    */
  public String getCid_uf() {
    return cid_uf;
  }
  /**
    * CID_UF: M�todo Sets p�ra este campo.
    */
  public void setCid_uf(String PARAM) {
    cid_uf = PARAM;
  }
  /**
    * ESC_SEQN: M�todo Gets para este campo
    */
  public String getEsc_seqn() {
    return esc_seqn;
  }
  /**
    * ESC_SEQN: M�todo Sets p�ra este campo.
    */
  public void setEsc_seqn(String PARAM) {
    esc_seqn = PARAM;
  }
  /**
    * CLI_CDGO: M�todo Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: M�todo Sets p�ra este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cliente = null;
    cli_rzao = null;
    cli_nome = null;
    seg_desc = null;
    cgc = null;
    inscricao = null;
    contato = null;
    cli_situ = null;
    esc_situacao = null;
    cli_dtin = null;
    cli_exige_pc = null;
    cli_agrupa_notas = null;
    cli_aceita_antecipacao = null;
    ender = null;
    bairro_cidade = null;
    cid_uf = null;
    esc_seqn = null;
    cli_cdgo = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
