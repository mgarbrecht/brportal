package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/05/2011 14:08:30
 * Last Modify Date 02/07/2015 10:21:02
 */

public class ControleClientesEspeciaisAmostra_mActionForm extends org.apache.struts.action.ActionForm
{
  public String gridCheckField;
  public String banco;
  public String alterado;
  public String ped_nmro;
  public String oc;
  public String modelos;
  public String etiquetas;
  public String dt_entrega_etiqueta;
  public String obse_adicionais;
  public String prs;
  public String remessa;
  public String filial_prd;
  public String fil_filial_fat;
  public String dt_digit;
  public String dt_fatur;
  public String dt_fatur_filial;
  public String marca;
  public String carimbo;
  public String rotulos;
  public String ped_amostra;
  public String dt_envio_amostras;
  public String agendamento_cdgo;
  public String dezena;
  public String dia;
  public String data_efetiva;
  public String codigo_regional;
  public String rep_cdgo;
  public String cli_cdgo;
  public String codigo_marca;
  public String ped_stat;
  public String bloqueia_navegador;
  public String hora;
  public String senha;
  public String dt_emissao;
  public String filial;
  public String notafiscal;
  public String volumes;
  public String dt_inspecao;
  public String dt_montagem;
  public String grupo_economico;
  public String cli_rzao;
  public String situacao;
  public String cabide;
  public String amostra;
  public String tipo_amostra;
  public String pedido_prod;
  public String encarte;
  public String dt_ent_amostra_comercial;
  public String dt_ent_amostra_pcp;
  public String ped_amostra_brinde;
  public String valor_pedido;
  public String ped_obse;
  public String ped_tipo;
  public String dt_rec_etiqueta_filial;
  public String encarte1;
  public String dt_emiss;
  private boolean valida = false;
  public ControleClientesEspeciaisAmostra_mActionForm() {
  }
  /**
    * GRIDCHECKFIELD: Método Gets para este campo
    */
  public String getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Método Sets pára este campo.
    */
  public void setGridCheckField(String PARAM) {
    gridCheckField = PARAM;
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
  /**
    * ALTERADO: Método Gets para este campo
    */
  public String getAlterado() {
    return alterado;
  }
  /**
    * ALTERADO: Método Sets pára este campo.
    */
  public void setAlterado(String PARAM) {
    alterado = PARAM;
  }
  /**
    * PED_NMRO: Método Gets para este campo
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Método Sets pára este campo.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * OC: Método Gets para este campo
    */
  public String getOc() {
    return oc;
  }
  /**
    * OC: Método Sets pára este campo.
    */
  public void setOc(String PARAM) {
    oc = PARAM;
  }
  /**
    * MODELOS: Método Gets para este campo
    */
  public String getModelos() {
    return modelos;
  }
  /**
    * MODELOS: Método Sets pára este campo.
    */
  public void setModelos(String PARAM) {
    modelos = PARAM;
  }
  /**
    * ETIQUETAS: Método Gets para este campo
    */
  public String getEtiquetas() {
    return etiquetas;
  }
  /**
    * ETIQUETAS: Método Sets pára este campo.
    */
  public void setEtiquetas(String PARAM) {
    etiquetas = PARAM;
  }
  /**
    * DT_ENTREGA_ETIQUETA: Método Gets para este campo
    */
  public String getDt_entrega_etiqueta() {
    return dt_entrega_etiqueta;
  }
  /**
    * DT_ENTREGA_ETIQUETA: Método Sets pára este campo.
    */
  public void setDt_entrega_etiqueta(String PARAM) {
    dt_entrega_etiqueta = PARAM;
  }
  /**
    * OBSE_ADICIONAIS: Método Gets para este campo
    */
  public String getObse_adicionais() {
    return obse_adicionais;
  }
  /**
    * OBSE_ADICIONAIS: Método Sets pára este campo.
    */
  public void setObse_adicionais(String PARAM) {
    obse_adicionais = PARAM;
  }
  /**
    * PRS: Método Gets para este campo
    */
  public String getPrs() {
    return prs;
  }
  /**
    * PRS: Método Sets pára este campo.
    */
  public void setPrs(String PARAM) {
    prs = PARAM;
  }
  /**
    * REMESSA: Método Gets para este campo
    */
  public String getRemessa() {
    return remessa;
  }
  /**
    * REMESSA: Método Sets pára este campo.
    */
  public void setRemessa(String PARAM) {
    remessa = PARAM;
  }
  /**
    * FILIAL_PRD: Método Gets para este campo
    */
  public String getFilial_prd() {
    return filial_prd;
  }
  /**
    * FILIAL_PRD: Método Sets pára este campo.
    */
  public void setFilial_prd(String PARAM) {
    filial_prd = PARAM;
  }
  /**
    * FIL_FILIAL_FAT: Método Gets para este campo
    */
  public String getFil_filial_fat() {
    return fil_filial_fat;
  }
  /**
    * FIL_FILIAL_FAT: Método Sets pára este campo.
    */
  public void setFil_filial_fat(String PARAM) {
    fil_filial_fat = PARAM;
  }
  /**
    * DT_DIGIT: Método Gets para este campo
    */
  public String getDt_digit() {
    return dt_digit;
  }
  /**
    * DT_DIGIT: Método Sets pára este campo.
    */
  public void setDt_digit(String PARAM) {
    dt_digit = PARAM;
  }
  /**
    * DT_FATUR: Método Gets para este campo
    */
  public String getDt_fatur() {
    return dt_fatur;
  }
  /**
    * DT_FATUR: Método Sets pára este campo.
    */
  public void setDt_fatur(String PARAM) {
    dt_fatur = PARAM;
  }
  /**
    * DT_FATUR_FILIAL: Método Gets para este campo
    */
  public String getDt_fatur_filial() {
    return dt_fatur_filial;
  }
  /**
    * DT_FATUR_FILIAL: Método Sets pára este campo.
    */
  public void setDt_fatur_filial(String PARAM) {
    dt_fatur_filial = PARAM;
  }
  /**
    * MARCA: Método Gets para este campo
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: Método Sets pára este campo.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  /**
    * CARIMBO: Método Gets para este campo
    */
  public String getCarimbo() {
    return carimbo;
  }
  /**
    * CARIMBO: Método Sets pára este campo.
    */
  public void setCarimbo(String PARAM) {
    carimbo = PARAM;
  }
  /**
    * ROTULOS: Método Gets para este campo
    */
  public String getRotulos() {
    return rotulos;
  }
  /**
    * ROTULOS: Método Sets pára este campo.
    */
  public void setRotulos(String PARAM) {
    rotulos = PARAM;
  }
  /**
    * PED_AMOSTRA: Método Gets para este campo
    */
  public String getPed_amostra() {
    return ped_amostra;
  }
  /**
    * PED_AMOSTRA: Método Sets pára este campo.
    */
  public void setPed_amostra(String PARAM) {
    ped_amostra = PARAM;
  }
  /**
    * DT_ENVIO_AMOSTRAS: Método Gets para este campo
    */
  public String getDt_envio_amostras() {
    return dt_envio_amostras;
  }
  /**
    * DT_ENVIO_AMOSTRAS: Método Sets pára este campo.
    */
  public void setDt_envio_amostras(String PARAM) {
    dt_envio_amostras = PARAM;
  }
  /**
    * AGENDAMENTO_CDGO: Método Gets para este campo
    */
  public String getAgendamento_cdgo() {
    return agendamento_cdgo;
  }
  /**
    * AGENDAMENTO_CDGO: Método Sets pára este campo.
    */
  public void setAgendamento_cdgo(String PARAM) {
    agendamento_cdgo = PARAM;
  }
  /**
    * DEZENA: Método Gets para este campo
    */
  public String getDezena() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (agendamento_cdgo != null && agendamento_cdgo.length() > 0 && cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Agendamento_clientes db_object = new Agendamento_clientes();
        String[][] select = { {"nro_semana",null}, {"dt_inicial",null}, {"dt_final",null} };
        Object[][] where = { {"id_agendamento","=",com.egen.util.text.FormatNumber.toInteger(agendamento_cdgo)}, {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cli_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Agendamento_clientes) results.elementAt(0);
          dezena = ((db_object.getNro_semana() != null) ? db_object.getNro_semana() + "":"");

          dia = ((db_object.getDt_inicial() != null) ? com.egen.util.text.FormatDate.format(db_object.getDt_inicial(), "dd/MM/yyyy") + " a " + com.egen.util.text.FormatDate.format(db_object.getDt_final(), "dd/MM/yyyy") + "":"");
        } else {
          dezena = "";
          dia = "";
        }
      }
    } catch (Exception e) {
      dezena = "";
      dia = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return dezena;
  }

  public String[][] getDezena_Ajax(ControleClientesEspeciaisAmostra_mActionForm PARAM) {
    String[][] list = new String[2][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getAgendamento_cdgo() != null && PARAM.getAgendamento_cdgo().length() > 0 && PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Agendamento_clientes db_object = new Agendamento_clientes();
        Object[][] where = { {"id_agendamento","=",PARAM.getAgendamento_cdgo()}, {"cli_cdgo","=",PARAM.getCli_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Agendamento_clientes) results.elementAt(0);
          list[0] = new String[]{"dezena", ((db_object.getNro_semana() != null) ? db_object.getNro_semana() + "":"")};
          list[1] = new String[]{"dia", ((db_object.getDt_inicial() != null) ? com.egen.util.text.FormatDate.format(db_object.getDt_inicial(), "dd/MM/yyyy") + " a " + com.egen.util.text.FormatDate.format(db_object.getDt_final(), "dd/MM/yyyy") + "":"")};
        } else {
          list[0] = new String[]{"dezena", ""};
          list[1] = new String[]{"dia", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"dezena", ""};
      list[1] = new String[]{"dia", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DEZENA: Método Sets pára este campo.
    */
  public void setDezena(String PARAM) {
    dezena = PARAM;
  }
  /**
    * DIA: Método Gets para este campo
    */
  public String getDia() {
    return dia;
  }
  /**
    * DIA: Método Sets pára este campo.
    */
  public void setDia(String PARAM) {
    dia = PARAM;
  }
  /**
    * DATA_EFETIVA: Método Gets para este campo
    */
  public String getData_efetiva() {
    return data_efetiva;
  }
  /**
    * DATA_EFETIVA: Método Sets pára este campo.
    */
  public void setData_efetiva(String PARAM) {
    data_efetiva = PARAM;
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
    * PED_STAT: Método Gets para este campo
    */
  public String getPed_stat() {
    return ped_stat;
  }
  /**
    * PED_STAT: Método Sets pára este campo.
    */
  public void setPed_stat(String PARAM) {
    ped_stat = PARAM;
  }
  /**
    * BLOQUEIA_NAVEGADOR: Método Gets para este campo
    */
  public String getBloqueia_navegador() {
    return bloqueia_navegador;
  }
  /**
    * BLOQUEIA_NAVEGADOR: Método Sets pára este campo.
    */
  public void setBloqueia_navegador(String PARAM) {
    bloqueia_navegador = PARAM;
  }
  /**
    * HORA: Método Gets para este campo
    */
  public String getHora() {
    return hora;
  }
  /**
    * HORA: Método Sets pára este campo.
    */
  public void setHora(String PARAM) {
    hora = PARAM;
  }
  /**
    * SENHA: Método Gets para este campo
    */
  public String getSenha() {
    return senha;
  }
  /**
    * SENHA: Método Sets pára este campo.
    */
  public void setSenha(String PARAM) {
    senha = PARAM;
  }
  /**
    * DT_EMISSAO: Método Gets para este campo
    */
  public String getDt_emissao() {
    return dt_emissao;
  }
  /**
    * DT_EMISSAO: Método Sets pára este campo.
    */
  public void setDt_emissao(String PARAM) {
    dt_emissao = PARAM;
  }
  /**
    * FILIAL: Método Gets para este campo
    */
  public String getFilial() {
    return filial;
  }
  /**
    * FILIAL: Método Sets pára este campo.
    */
  public void setFilial(String PARAM) {
    filial = PARAM;
  }
  /**
    * NOTAFISCAL: Método Gets para este campo
    */
  public String getNotafiscal() {
    return notafiscal;
  }
  /**
    * NOTAFISCAL: Método Sets pára este campo.
    */
  public void setNotafiscal(String PARAM) {
    notafiscal = PARAM;
  }
  /**
    * VOLUMES: Método Gets para este campo
    */
  public String getVolumes() {
    return volumes;
  }
  /**
    * VOLUMES: Método Sets pára este campo.
    */
  public void setVolumes(String PARAM) {
    volumes = PARAM;
  }
  /**
    * DT_INSPECAO: Método Gets para este campo
    */
  public String getDt_inspecao() {
    return dt_inspecao;
  }
  /**
    * DT_INSPECAO: Método Sets pára este campo.
    */
  public void setDt_inspecao(String PARAM) {
    dt_inspecao = PARAM;
  }
  /**
    * DT_MONTAGEM: Método Gets para este campo
    */
  public String getDt_montagem() {
    return dt_montagem;
  }
  /**
    * DT_MONTAGEM: Método Sets pára este campo.
    */
  public void setDt_montagem(String PARAM) {
    dt_montagem = PARAM;
  }
  /**
    * GRUPO_ECONOMICO: Método Gets para este campo
    */
  public String getGrupo_economico() {
    return grupo_economico;
  }
  /**
    * GRUPO_ECONOMICO: Método Sets pára este campo.
    */
  public void setGrupo_economico(String PARAM) {
    grupo_economico = PARAM;
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
    * CABIDE: Método Gets para este campo
    */
  public String getCabide() {
    return cabide;
  }
  /**
    * CABIDE: Método Sets pára este campo.
    */
  public void setCabide(String PARAM) {
    cabide = PARAM;
  }
  /**
    * AMOSTRA: Método Gets para este campo
    */
  public String getAmostra() {
    return amostra;
  }
  /**
    * AMOSTRA: Método Sets pára este campo.
    */
  public void setAmostra(String PARAM) {
    amostra = PARAM;
  }
  /**
    * TIPO_AMOSTRA: Método Gets para este campo
    */
  public String getTipo_amostra() {
    return tipo_amostra;
  }
  /**
    * TIPO_AMOSTRA: Método Sets pára este campo.
    */
  public void setTipo_amostra(String PARAM) {
    tipo_amostra = PARAM;
  }
  /**
    * PEDIDO_PROD: Método Gets para este campo
    */
  public String getPedido_prod() {
    return pedido_prod;
  }
  /**
    * PEDIDO_PROD: Método Sets pára este campo.
    */
  public void setPedido_prod(String PARAM) {
    pedido_prod = PARAM;
  }
  /**
    * ENCARTE: Método Gets para este campo
    */
  public String getEncarte() {
    return encarte;
  }
  /**
    * ENCARTE: Método Sets pára este campo.
    */
  public void setEncarte(String PARAM) {
    encarte = PARAM;
  }
  /**
    * DT_ENT_AMOSTRA_COMERCIAL: Método Gets para este campo
    */
  public String getDt_ent_amostra_comercial() {
    return dt_ent_amostra_comercial;
  }
  /**
    * DT_ENT_AMOSTRA_COMERCIAL: Método Sets pára este campo.
    */
  public void setDt_ent_amostra_comercial(String PARAM) {
    dt_ent_amostra_comercial = PARAM;
  }
  /**
    * DT_ENT_AMOSTRA_PCP: Método Gets para este campo
    */
  public String getDt_ent_amostra_pcp() {
    return dt_ent_amostra_pcp;
  }
  /**
    * DT_ENT_AMOSTRA_PCP: Método Sets pára este campo.
    */
  public void setDt_ent_amostra_pcp(String PARAM) {
    dt_ent_amostra_pcp = PARAM;
  }
  /**
    * PED_AMOSTRA_BRINDE: Método Gets para este campo
    */
  public String getPed_amostra_brinde() {
    return ped_amostra_brinde;
  }
  /**
    * PED_AMOSTRA_BRINDE: Método Sets pára este campo.
    */
  public void setPed_amostra_brinde(String PARAM) {
    ped_amostra_brinde = PARAM;
  }
  /**
    * VALOR_PEDIDO: Método Gets para este campo
    */
  public String getValor_pedido() {
    return valor_pedido;
  }
  /**
    * VALOR_PEDIDO: Método Sets pára este campo.
    */
  public void setValor_pedido(String PARAM) {
    valor_pedido = PARAM;
  }
  /**
    * PED_OBSE: Método Gets para este campo
    */
  public String getPed_obse() {
    return ped_obse;
  }
  /**
    * PED_OBSE: Método Sets pára este campo.
    */
  public void setPed_obse(String PARAM) {
    ped_obse = PARAM;
  }
  /**
    * PED_TIPO: Método Gets para este campo
    */
  public String getPed_tipo() {
    return ped_tipo;
  }
  /**
    * PED_TIPO: Método Sets pára este campo.
    */
  public void setPed_tipo(String PARAM) {
    ped_tipo = PARAM;
  }
  /**
    * DT_REC_ETIQUETA_FILIAL: Método Gets para este campo
    */
  public String getDt_rec_etiqueta_filial() {
    return dt_rec_etiqueta_filial;
  }
  /**
    * DT_REC_ETIQUETA_FILIAL: Método Sets pára este campo.
    */
  public void setDt_rec_etiqueta_filial(String PARAM) {
    dt_rec_etiqueta_filial = PARAM;
  }
  /**
    * ENCARTE1: Método Gets para este campo
    */
  public String getEncarte1() {
    return encarte1;
  }
  /**
    * ENCARTE1: Método Sets pára este campo.
    */
  public void setEncarte1(String PARAM) {
    encarte1 = PARAM;
  }
  /**
    * DT_EMISS: Método Gets para este campo
    */
  public String getDt_emiss() {
    return dt_emiss;
  }
  /**
    * DT_EMISS: Método Sets pára este campo.
    */
  public void setDt_emiss(String PARAM) {
    dt_emiss = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = null;
    banco = null;
    alterado = null;
    ped_nmro = null;
    oc = null;
    modelos = null;
    etiquetas = null;
    dt_entrega_etiqueta = null;
    obse_adicionais = null;
    prs = null;
    remessa = null;
    filial_prd = null;
    fil_filial_fat = null;
    dt_digit = null;
    dt_fatur = null;
    dt_fatur_filial = null;
    marca = null;
    carimbo = null;
    rotulos = null;
    ped_amostra = null;
    dt_envio_amostras = null;
    agendamento_cdgo = null;
    dezena = null;
    dia = null;
    data_efetiva = null;
    codigo_regional = null;
    rep_cdgo = null;
    cli_cdgo = null;
    codigo_marca = null;
    ped_stat = null;
    bloqueia_navegador = null;
    hora = null;
    senha = null;
    dt_emissao = null;
    filial = null;
    notafiscal = null;
    volumes = null;
    dt_inspecao = null;
    dt_montagem = null;
    grupo_economico = null;
    cli_rzao = null;
    situacao = null;
    cabide = null;
    amostra = null;
    tipo_amostra = null;
    pedido_prod = null;
    encarte = null;
    dt_ent_amostra_comercial = null;
    dt_ent_amostra_pcp = null;
    ped_amostra_brinde = null;
    valor_pedido = null;
    ped_obse = null;
    ped_tipo = null;
    dt_rec_etiqueta_filial = null;
    encarte1 = null;
    dt_emiss = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
      if (!com.egen.util.text.Validate.isDate(dt_entrega_etiqueta)) {
        errors.add("dt_entrega_etiqueta", new ActionMessage("error.validate.date","Dt_entrega_etiqueta","dt_entrega_etiqueta","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_digit)) {
        errors.add("dt_digit", new ActionMessage("error.validate.date","Digit.","dt_digit","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_fatur_filial)) {
        errors.add("dt_fatur_filial", new ActionMessage("error.validate.date","Fat. BR.","dt_fatur_filial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_envio_amostras)) {
        errors.add("dt_envio_amostras", new ActionMessage("error.validate.date","Dt. Envio","dt_envio_amostras","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_efetiva)) {
        errors.add("data_efetiva", new ActionMessage("error.validate.date","Dt. Efetiva","data_efetiva","0"));
      }
      if (com.egen.util.text.Validate.isNull(rep_cdgo)) {
        errors.add("rep_cdgo", new ActionMessage("error.validate.notnull","Rep_cdgo","rep_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_emissao)) {
        errors.add("dt_emissao", new ActionMessage("error.validate.date","Emissão","dt_emissao","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_inspecao)) {
        errors.add("dt_inspecao", new ActionMessage("error.validate.date","Dt_inspecao","dt_inspecao","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_montagem)) {
        errors.add("dt_montagem", new ActionMessage("error.validate.date","Dt_montagem","dt_montagem","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_ent_amostra_comercial)) {
        errors.add("dt_ent_amostra_comercial", new ActionMessage("error.validate.date","Dt_ent_amostra_comercial","dt_ent_amostra_comercial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_ent_amostra_pcp)) {
        errors.add("dt_ent_amostra_pcp", new ActionMessage("error.validate.date","Dt_ent_amostra_pcp","dt_ent_amostra_pcp","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(valor_pedido)) {
        errors.add("valor_pedido", new ActionMessage("error.validate.number","double","valor_pedido","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_rec_etiqueta_filial)) {
        errors.add("dt_rec_etiqueta_filial", new ActionMessage("error.validate.date","Dt_rec_etiqueta_filial","dt_rec_etiqueta_filial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_emiss)) {
        errors.add("dt_emiss", new ActionMessage("error.validate.date","Dt_emiss","dt_emiss","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
