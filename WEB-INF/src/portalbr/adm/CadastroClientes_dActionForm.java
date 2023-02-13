package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/04/2006 16:45:36
 * Last Modify Date 27/11/2020 15:50:09
 */

public class CadastroClientes_dActionForm extends org.apache.struts.action.ActionForm
{
  public String cliente;
  public String cliente_desde;
  public String situacao_cliente;
  public String situacao_loja;
  public String codigo_motivo;
  public String descricao_motivo;
  public String cli_rzao;
  public String cli_nome;
  public String seg_desc;
  public String cgc;
  public String inscricao;
  public String endereco;
  public String bairro_cidade_uf;
  public String esc_email;
  public String transportadora;
  public String cli_cdgo;
  public String esc_seqn;
  public String protestar;
  public String nro_dias;
  public String grupo_economico;
  public String cli_aceita_antecipacao;
  public String cli_aceita_antecipacao_allegro;
  public String cli_aceita_antecipacao_riva;
  public String vendor;
  private boolean valida = false;
  public CadastroClientes_dActionForm() {
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
    * CLIENTE_DESDE: Method to get the field value.
    */
  public String getCliente_desde() {
    return cliente_desde;
  }
  /**
    * CLIENTE_DESDE: Method to set the field value.
    */
  public void setCliente_desde(String PARAM) {
    cliente_desde = PARAM;
  }
  /**
    * SITUACAO_CLIENTE: Method to get the field value.
    */
  public String getSituacao_cliente() {
    return situacao_cliente;
  }
  /**
    * SITUACAO_CLIENTE: Method to set the field value.
    */
  public void setSituacao_cliente(String PARAM) {
    situacao_cliente = PARAM;
  }
  /**
    * SITUACAO_LOJA: Method to get the field value.
    */
  public String getSituacao_loja() {
    return situacao_loja;
  }
  /**
    * SITUACAO_LOJA: Method to set the field value.
    */
  public void setSituacao_loja(String PARAM) {
    situacao_loja = PARAM;
  }
  /**
    * CODIGO_MOTIVO: Method to get the field value.
    */
  public String getCodigo_motivo() {
    return codigo_motivo;
  }
  /**
    * CODIGO_MOTIVO: Method to set the field value.
    */
  public void setCodigo_motivo(String PARAM) {
    codigo_motivo = PARAM;
  }
  /**
    * DESCRICAO_MOTIVO: Method to get the field value.
    */
  public String getDescricao_motivo() {
    return descricao_motivo;
  }
  /**
    * DESCRICAO_MOTIVO: Method to set the field value.
    */
  public void setDescricao_motivo(String PARAM) {
    descricao_motivo = PARAM;
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
    * CLI_NOME: Method to get the field value.
    */
  public String getCli_nome() {
    return cli_nome;
  }
  /**
    * CLI_NOME: Method to set the field value.
    */
  public void setCli_nome(String PARAM) {
    cli_nome = PARAM;
  }
  /**
    * SEG_DESC: Method to get the field value.
    */
  public String getSeg_desc() {
    return seg_desc;
  }
  /**
    * SEG_DESC: Method to set the field value.
    */
  public void setSeg_desc(String PARAM) {
    seg_desc = PARAM;
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
    * INSCRICAO: Method to get the field value.
    */
  public String getInscricao() {
    return inscricao;
  }
  /**
    * INSCRICAO: Method to set the field value.
    */
  public void setInscricao(String PARAM) {
    inscricao = PARAM;
  }
  /**
    * ENDERECO: Method to get the field value.
    */
  public String getEndereco() {
    return endereco;
  }
  /**
    * ENDERECO: Method to set the field value.
    */
  public void setEndereco(String PARAM) {
    endereco = PARAM;
  }
  /**
    * BAIRRO_CIDADE_UF: Method to get the field value.
    */
  public String getBairro_cidade_uf() {
    return bairro_cidade_uf;
  }
  /**
    * BAIRRO_CIDADE_UF: Method to set the field value.
    */
  public void setBairro_cidade_uf(String PARAM) {
    bairro_cidade_uf = PARAM;
  }
  /**
    * ESC_EMAIL: Method to get the field value.
    */
  public String getEsc_email() {
    return esc_email;
  }
  /**
    * ESC_EMAIL: Method to set the field value.
    */
  public void setEsc_email(String PARAM) {
    esc_email = PARAM;
  }
  /**
    * TRANSPORTADORA: Method to get the field value.
    */
  public String getTransportadora() {
    return transportadora;
  }
  /**
    * TRANSPORTADORA: Method to set the field value.
    */
  public void setTransportadora(String PARAM) {
    transportadora = PARAM;
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
    * PROTESTAR: Method to get the field value.
    */
  public String getProtestar() {
    return protestar;
  }
  /**
    * PROTESTAR: Method to set the field value.
    */
  public void setProtestar(String PARAM) {
    protestar = PARAM;
  }
  /**
    * NRO_DIAS: Method to get the field value.
    */
  public String getNro_dias() {
    return nro_dias;
  }
  /**
    * NRO_DIAS: Method to set the field value.
    */
  public void setNro_dias(String PARAM) {
    nro_dias = PARAM;
  }
  /**
    * GRUPO_ECONOMICO: Method to get the field value.
    */
  public String getGrupo_economico() {
    return grupo_economico;
  }
  /**
    * GRUPO_ECONOMICO: Method to set the field value.
    */
  public void setGrupo_economico(String PARAM) {
    grupo_economico = PARAM;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO: Method to get the field value.
    */
  public String getCli_aceita_antecipacao() {
    return cli_aceita_antecipacao;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO: Method to set the field value.
    */
  public void setCli_aceita_antecipacao(String PARAM) {
    cli_aceita_antecipacao = PARAM;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO_ALLEGRO: Method to get the field value.
    */
  public String getCli_aceita_antecipacao_allegro() {
    return cli_aceita_antecipacao_allegro;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO_ALLEGRO: Method to set the field value.
    */
  public void setCli_aceita_antecipacao_allegro(String PARAM) {
    cli_aceita_antecipacao_allegro = PARAM;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO_RIVA: Method to get the field value.
    */
  public String getCli_aceita_antecipacao_riva() {
    return cli_aceita_antecipacao_riva;
  }
  /**
    * CLI_ACEITA_ANTECIPACAO_RIVA: Method to set the field value.
    */
  public void setCli_aceita_antecipacao_riva(String PARAM) {
    cli_aceita_antecipacao_riva = PARAM;
  }
  /**
    * VENDOR: Method to get the field value.
    */
  public String getVendor() {
    return vendor;
  }
  /**
    * VENDOR: Method to set the field value.
    */
  public void setVendor(String PARAM) {
    vendor = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cliente = null;
    cliente_desde = null;
    situacao_cliente = null;
    situacao_loja = null;
    codigo_motivo = null;
    descricao_motivo = null;
    cli_rzao = null;
    cli_nome = null;
    seg_desc = null;
    cgc = null;
    inscricao = null;
    endereco = null;
    bairro_cidade_uf = null;
    esc_email = null;
    transportadora = null;
    cli_cdgo = null;
    esc_seqn = null;
    protestar = null;
    nro_dias = null;
    grupo_economico = null;
    cli_aceita_antecipacao = null;
    cli_aceita_antecipacao_allegro = null;
    cli_aceita_antecipacao_riva = null;
    vendor = null;
  }
  /**
    * Validate fields and return errors.
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
