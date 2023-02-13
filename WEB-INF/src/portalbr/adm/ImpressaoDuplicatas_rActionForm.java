package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/03/2006 08:52:01
 * Last Modify Date 07/07/2014 14:21:12
 */

public class ImpressaoDuplicatas_rActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String nome;
  public String bairro;
  public String cidade_uf;
  public String emp_empresa;
  public boolean gridCheckField;
  public String tit_codigo1;
  public String tit_status;
  public String nota;
  public String serie;
  public String desc_sit;
  public String tip_codigo1;
  public String tit_datvenc1;
  public String tit_valor;
  public String tit_vlrec;
  public String prt_descri;
  public String tit_numbco;
  public String tit_datrec;
  public String tit_datemi;
  public String tit_dspont;
  public String tit_dsante;
  public String prt_codigo1;
  public String emp_empresa2;
  public String fil_filial1;
  public String ncc;
  public String taxa_juro;
  public String trn_codigo;
  public String mov_data;
  public String datvenc;
  public String cobjur;
  public String tit_abatim;
  public String vnc_cartor;
  public String dif;
  public String condes;
  public String rep_codigo;
  public String data_atual;
  public String ped_nmro;
  public String w_liq1;
  public String w_saldo_tot1;
  public String w_valor_tot1;
  public String pedido;
  public String vendor;
  public String tit_datven3;
  public String cnpj;
  public String cnpj_sem_formato;
  public String esc_seqn;
  public String situacao;
  public String dt_venc;
  public String cli_cdgo;
  public String w_liq;
  public String w_saldo_tot;
  public String w_valor_tot;
  public String emp_empresa1;
  public String fil_filial;
  public String tip_codigo;
  public String tit_codigo;
  public String valor;
  public String prt_codigo;
  public String tit_datvenc;
  private boolean valida = false;
  public ImpressaoDuplicatas_rActionForm() {
  }
  /**
    * CODIGO: M�todo Gets para este campo
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: M�todo Sets p�ra este campo.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * NOME: M�todo Gets para este campo
    */
  public String getNome() {
    return nome;
  }
  /**
    * NOME: M�todo Sets p�ra este campo.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * BAIRRO: M�todo Gets para este campo
    */
  public String getBairro() {
    return bairro;
  }
  /**
    * BAIRRO: M�todo Sets p�ra este campo.
    */
  public void setBairro(String PARAM) {
    bairro = PARAM;
  }
  /**
    * CIDADE_UF: M�todo Gets para este campo
    */
  public String getCidade_uf() {
    return cidade_uf;
  }
  /**
    * CIDADE_UF: M�todo Sets p�ra este campo.
    */
  public void setCidade_uf(String PARAM) {
    cidade_uf = PARAM;
  }
  /**
    * EMP_EMPRESA: M�todo Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: M�todo Sets p�ra este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * GRIDCHECKFIELD: M�todo Gets para este campo
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: M�todo Sets p�ra este campo.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * TIT_CODIGO1: M�todo Gets para este campo
    */
  public String getTit_codigo1() {
    return tit_codigo1;
  }
  /**
    * TIT_CODIGO1: M�todo Sets p�ra este campo.
    */
  public void setTit_codigo1(String PARAM) {
    tit_codigo1 = PARAM;
  }
  /**
    * TIT_STATUS: M�todo Gets para este campo
    */
  public String getTit_status() {
    return tit_status;
  }
  /**
    * TIT_STATUS: M�todo Sets p�ra este campo.
    */
  public void setTit_status(String PARAM) {
    tit_status = PARAM;
  }
  /**
    * NOTA: M�todo Gets para este campo
    */
  public String getNota() {
    return nota;
  }
  /**
    * NOTA: M�todo Sets p�ra este campo.
    */
  public void setNota(String PARAM) {
    nota = PARAM;
  }
  /**
    * SERIE: M�todo Gets para este campo
    */
  public String getSerie() {
    return serie;
  }
  /**
    * SERIE: M�todo Sets p�ra este campo.
    */
  public void setSerie(String PARAM) {
    serie = PARAM;
  }
  /**
    * DESC_SIT: M�todo Gets para este campo
    */
  public String getDesc_sit() {
    return desc_sit;
  }
  /**
    * DESC_SIT: M�todo Sets p�ra este campo.
    */
  public void setDesc_sit(String PARAM) {
    desc_sit = PARAM;
  }
  /**
    * TIP_CODIGO1: M�todo Gets para este campo
    */
  public String getTip_codigo1() {
    return tip_codigo1;
  }
  /**
    * TIP_CODIGO1: M�todo Sets p�ra este campo.
    */
  public void setTip_codigo1(String PARAM) {
    tip_codigo1 = PARAM;
  }
  /**
    * TIT_DATVENC1: M�todo Gets para este campo
    */
  public String getTit_datvenc1() {
    return tit_datvenc1;
  }
  /**
    * TIT_DATVENC1: M�todo Sets p�ra este campo.
    */
  public void setTit_datvenc1(String PARAM) {
    tit_datvenc1 = PARAM;
  }
  /**
    * TIT_VALOR: M�todo Gets para este campo
    */
  public String getTit_valor() {
    return tit_valor;
  }
  /**
    * TIT_VALOR: M�todo Sets p�ra este campo.
    */
  public void setTit_valor(String PARAM) {
    tit_valor = PARAM;
  }
  /**
    * TIT_VLREC: M�todo Gets para este campo
    */
  public String getTit_vlrec() {
    return tit_vlrec;
  }
  /**
    * TIT_VLREC: M�todo Sets p�ra este campo.
    */
  public void setTit_vlrec(String PARAM) {
    tit_vlrec = PARAM;
  }
  /**
    * PRT_DESCRI: M�todo Gets para este campo
    */
  public String getPrt_descri() {
    return prt_descri;
  }
  /**
    * PRT_DESCRI: M�todo Sets p�ra este campo.
    */
  public void setPrt_descri(String PARAM) {
    prt_descri = PARAM;
  }
  /**
    * TIT_NUMBCO: M�todo Gets para este campo
    */
  public String getTit_numbco() {
    return tit_numbco;
  }
  /**
    * TIT_NUMBCO: M�todo Sets p�ra este campo.
    */
  public void setTit_numbco(String PARAM) {
    tit_numbco = PARAM;
  }
  /**
    * TIT_DATREC: M�todo Gets para este campo
    */
  public String getTit_datrec() {
    return tit_datrec;
  }
  /**
    * TIT_DATREC: M�todo Sets p�ra este campo.
    */
  public void setTit_datrec(String PARAM) {
    tit_datrec = PARAM;
  }
  /**
    * TIT_DATEMI: M�todo Gets para este campo
    */
  public String getTit_datemi() {
    return tit_datemi;
  }
  /**
    * TIT_DATEMI: M�todo Sets p�ra este campo.
    */
  public void setTit_datemi(String PARAM) {
    tit_datemi = PARAM;
  }
  /**
    * TIT_DSPONT: M�todo Gets para este campo
    */
  public String getTit_dspont() {
    return tit_dspont;
  }
  /**
    * TIT_DSPONT: M�todo Sets p�ra este campo.
    */
  public void setTit_dspont(String PARAM) {
    tit_dspont = PARAM;
  }
  /**
    * TIT_DSANTE: M�todo Gets para este campo
    */
  public String getTit_dsante() {
    return tit_dsante;
  }
  /**
    * TIT_DSANTE: M�todo Sets p�ra este campo.
    */
  public void setTit_dsante(String PARAM) {
    tit_dsante = PARAM;
  }
  /**
    * PRT_CODIGO1: M�todo Gets para este campo
    */
  public String getPrt_codigo1() {
    return prt_codigo1;
  }
  /**
    * PRT_CODIGO1: M�todo Sets p�ra este campo.
    */
  public void setPrt_codigo1(String PARAM) {
    prt_codigo1 = PARAM;
  }
  /**
    * EMP_EMPRESA2: M�todo Gets para este campo
    */
  public String getEmp_empresa2() {
    return emp_empresa2;
  }
  /**
    * EMP_EMPRESA2: M�todo Sets p�ra este campo.
    */
  public void setEmp_empresa2(String PARAM) {
    emp_empresa2 = PARAM;
  }
  /**
    * FIL_FILIAL1: M�todo Gets para este campo
    */
  public String getFil_filial1() {
    return fil_filial1;
  }
  /**
    * FIL_FILIAL1: M�todo Sets p�ra este campo.
    */
  public void setFil_filial1(String PARAM) {
    fil_filial1 = PARAM;
  }
  /**
    * NCC: M�todo Gets para este campo
    */
  public String getNcc() {
    return ncc;
  }
  /**
    * NCC: M�todo Sets p�ra este campo.
    */
  public void setNcc(String PARAM) {
    ncc = PARAM;
  }
  /**
    * TAXA_JURO: M�todo Gets para este campo
    */
  public String getTaxa_juro() {
    return taxa_juro;
  }
  /**
    * TAXA_JURO: M�todo Sets p�ra este campo.
    */
  public void setTaxa_juro(String PARAM) {
    taxa_juro = PARAM;
  }
  /**
    * TRN_CODIGO: M�todo Gets para este campo
    */
  public String getTrn_codigo() {
    return trn_codigo;
  }
  /**
    * TRN_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setTrn_codigo(String PARAM) {
    trn_codigo = PARAM;
  }
  /**
    * MOV_DATA: M�todo Gets para este campo
    */
  public String getMov_data() {
    return mov_data;
  }
  /**
    * MOV_DATA: M�todo Sets p�ra este campo.
    */
  public void setMov_data(String PARAM) {
    mov_data = PARAM;
  }
  /**
    * DATVENC: M�todo Gets para este campo
    */
  public String getDatvenc() {
    return datvenc;
  }
  /**
    * DATVENC: M�todo Sets p�ra este campo.
    */
  public void setDatvenc(String PARAM) {
    datvenc = PARAM;
  }
  /**
    * COBJUR: M�todo Gets para este campo
    */
  public String getCobjur() {
    return cobjur;
  }
  /**
    * COBJUR: M�todo Sets p�ra este campo.
    */
  public void setCobjur(String PARAM) {
    cobjur = PARAM;
  }
  /**
    * TIT_ABATIM: M�todo Gets para este campo
    */
  public String getTit_abatim() {
    return tit_abatim;
  }
  /**
    * TIT_ABATIM: M�todo Sets p�ra este campo.
    */
  public void setTit_abatim(String PARAM) {
    tit_abatim = PARAM;
  }
  /**
    * VNC_CARTOR: M�todo Gets para este campo
    */
  public String getVnc_cartor() {
    return vnc_cartor;
  }
  /**
    * VNC_CARTOR: M�todo Sets p�ra este campo.
    */
  public void setVnc_cartor(String PARAM) {
    vnc_cartor = PARAM;
  }
  /**
    * DIF: M�todo Gets para este campo
    */
  public String getDif() {
    return dif;
  }
  /**
    * DIF: M�todo Sets p�ra este campo.
    */
  public void setDif(String PARAM) {
    dif = PARAM;
  }
  /**
    * CONDES: M�todo Gets para este campo
    */
  public String getCondes() {
    return condes;
  }
  /**
    * CONDES: M�todo Sets p�ra este campo.
    */
  public void setCondes(String PARAM) {
    condes = PARAM;
  }
  /**
    * REP_CODIGO: M�todo Gets para este campo
    */
  public String getRep_codigo() {
    return rep_codigo;
  }
  /**
    * REP_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setRep_codigo(String PARAM) {
    rep_codigo = PARAM;
  }
  /**
    * DATA_ATUAL: M�todo Gets para este campo
    */
  public String getData_atual() {
    return data_atual;
  }
  /**
    * DATA_ATUAL: M�todo Sets p�ra este campo.
    */
  public void setData_atual(String PARAM) {
    data_atual = PARAM;
  }
  /**
    * PED_NMRO: M�todo Gets para este campo
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: M�todo Sets p�ra este campo.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * W_LIQ1: M�todo Gets para este campo
    */
  public String getW_liq1() {
    return w_liq1;
  }
  /**
    * W_LIQ1: M�todo Sets p�ra este campo.
    */
  public void setW_liq1(String PARAM) {
    w_liq1 = PARAM;
  }
  /**
    * W_SALDO_TOT1: M�todo Gets para este campo
    */
  public String getW_saldo_tot1() {
    return w_saldo_tot1;
  }
  /**
    * W_SALDO_TOT1: M�todo Sets p�ra este campo.
    */
  public void setW_saldo_tot1(String PARAM) {
    w_saldo_tot1 = PARAM;
  }
  /**
    * W_VALOR_TOT1: M�todo Gets para este campo
    */
  public String getW_valor_tot1() {
    return w_valor_tot1;
  }
  /**
    * W_VALOR_TOT1: M�todo Sets p�ra este campo.
    */
  public void setW_valor_tot1(String PARAM) {
    w_valor_tot1 = PARAM;
  }
  /**
    * PEDIDO: M�todo Gets para este campo
    */
  public String getPedido() {
    return pedido;
  }
  /**
    * PEDIDO: M�todo Sets p�ra este campo.
    */
  public void setPedido(String PARAM) {
    pedido = PARAM;
  }
  /**
    * VENDOR: M�todo Gets para este campo
    */
  public String getVendor() {
    return vendor;
  }
  /**
    * VENDOR: M�todo Sets p�ra este campo.
    */
  public void setVendor(String PARAM) {
    vendor = PARAM;
  }
  /**
    * TIT_DATVEN3: M�todo Gets para este campo
    */
  public String getTit_datven3() {
    return tit_datven3;
  }
  /**
    * TIT_DATVEN3: M�todo Sets p�ra este campo.
    */
  public void setTit_datven3(String PARAM) {
    tit_datven3 = PARAM;
  }
  /**
    * CNPJ: M�todo Gets para este campo
    */
  public String getCnpj() {
    return cnpj;
  }
  /**
    * CNPJ: M�todo Sets p�ra este campo.
    */
  public void setCnpj(String PARAM) {
    cnpj = PARAM;
  }
  /**
    * CNPJ_SEM_FORMATO: M�todo Gets para este campo
    */
  public String getCnpj_sem_formato() {
    return cnpj_sem_formato;
  }
  /**
    * CNPJ_SEM_FORMATO: M�todo Sets p�ra este campo.
    */
  public void setCnpj_sem_formato(String PARAM) {
    cnpj_sem_formato = PARAM;
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
    * SITUACAO: M�todo Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: M�todo Sets p�ra este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * DT_VENC: M�todo Gets para este campo
    */
  public String getDt_venc() {
    return dt_venc;
  }
  /**
    * DT_VENC: M�todo Sets p�ra este campo.
    */
  public void setDt_venc(String PARAM) {
    dt_venc = PARAM;
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
    * W_LIQ: M�todo Gets para este campo
    */
  public String getW_liq() {
    return w_liq;
  }
  /**
    * W_LIQ: M�todo Sets p�ra este campo.
    */
  public void setW_liq(String PARAM) {
    w_liq = PARAM;
  }
  /**
    * W_SALDO_TOT: M�todo Gets para este campo
    */
  public String getW_saldo_tot() {
    return w_saldo_tot;
  }
  /**
    * W_SALDO_TOT: M�todo Sets p�ra este campo.
    */
  public void setW_saldo_tot(String PARAM) {
    w_saldo_tot = PARAM;
  }
  /**
    * W_VALOR_TOT: M�todo Gets para este campo
    */
  public String getW_valor_tot() {
    return w_valor_tot;
  }
  /**
    * W_VALOR_TOT: M�todo Sets p�ra este campo.
    */
  public void setW_valor_tot(String PARAM) {
    w_valor_tot = PARAM;
  }
  /**
    * EMP_EMPRESA1: M�todo Gets para este campo
    */
  public String getEmp_empresa1() {
    return emp_empresa1;
  }
  /**
    * EMP_EMPRESA1: M�todo Sets p�ra este campo.
    */
  public void setEmp_empresa1(String PARAM) {
    emp_empresa1 = PARAM;
  }
  /**
    * FIL_FILIAL: M�todo Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: M�todo Sets p�ra este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * TIP_CODIGO: M�todo Gets para este campo
    */
  public String getTip_codigo() {
    return tip_codigo;
  }
  /**
    * TIP_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setTip_codigo(String PARAM) {
    tip_codigo = PARAM;
  }
  /**
    * TIT_CODIGO: M�todo Gets para este campo
    */
  public String getTit_codigo() {
    return tit_codigo;
  }
  /**
    * TIT_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setTit_codigo(String PARAM) {
    tit_codigo = PARAM;
  }
  /**
    * VALOR: M�todo Gets para este campo
    */
  public String getValor() {
    return valor;
  }
  /**
    * VALOR: M�todo Sets p�ra este campo.
    */
  public void setValor(String PARAM) {
    valor = PARAM;
  }
  /**
    * PRT_CODIGO: M�todo Gets para este campo
    */
  public String getPrt_codigo() {
    return prt_codigo;
  }
  /**
    * PRT_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setPrt_codigo(String PARAM) {
    prt_codigo = PARAM;
  }
  /**
    * TIT_DATVENC: M�todo Gets para este campo
    */
  public String getTit_datvenc() {
    return tit_datvenc;
  }
  /**
    * TIT_DATVENC: M�todo Sets p�ra este campo.
    */
  public void setTit_datvenc(String PARAM) {
    tit_datvenc = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    nome = null;
    bairro = null;
    cidade_uf = null;
    emp_empresa = null;
    gridCheckField = false;
    tit_codigo1 = null;
    tit_status = null;
    nota = null;
    serie = null;
    desc_sit = null;
    tip_codigo1 = null;
    tit_datvenc1 = null;
    tit_valor = null;
    tit_vlrec = null;
    prt_descri = null;
    tit_numbco = null;
    tit_datrec = null;
    tit_datemi = null;
    tit_dspont = null;
    tit_dsante = null;
    prt_codigo1 = null;
    emp_empresa2 = null;
    fil_filial1 = null;
    ncc = null;
    taxa_juro = null;
    trn_codigo = null;
    mov_data = null;
    datvenc = null;
    cobjur = null;
    tit_abatim = null;
    vnc_cartor = null;
    dif = null;
    condes = null;
    rep_codigo = null;
    data_atual = null;
    ped_nmro = null;
    w_liq1 = null;
    w_saldo_tot1 = null;
    w_valor_tot1 = null;
    pedido = null;
    vendor = null;
    tit_datven3 = null;
    cnpj = null;
    cnpj_sem_formato = null;
    esc_seqn = null;
    situacao = null;
    dt_venc = null;
    cli_cdgo = null;
    w_liq = null;
    w_saldo_tot = null;
    w_valor_tot = null;
    emp_empresa1 = null;
    fil_filial = null;
    tip_codigo = null;
    tit_codigo = null;
    valor = null;
    prt_codigo = null;
    tit_datvenc = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
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
