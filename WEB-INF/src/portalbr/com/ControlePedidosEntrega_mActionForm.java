package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/05/2011 14:08:30
 * Last Modify Date 20/08/2013 10:39:52
 */

public class ControlePedidosEntrega_mActionForm extends org.apache.struts.action.ActionForm
{
  public String gridCheckField;
  public String banco;
  public String alterado;
  public String ped_nmro;
  public String oc;
  public String modelos;
  public String etiquetas;
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
  public String cli_rzao;
  public String valor_pedido;
  public String esc_seqn;
  public String rep_rzao;
  public String cliente;
  public String ped_amostra_brinde;
  public String data_entrega_cliente;
  private boolean valida = false;
  public ControlePedidosEntrega_mActionForm() {
  }
  /**
    * GRIDCHECKFIELD: M�todo Gets para este campo
    */
  public String getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: M�todo Sets p�ra este campo.
    */
  public void setGridCheckField(String PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * BANCO: M�todo Gets para este campo
    */
  public String getBanco() {
    return banco;
  }
  /**
    * BANCO: M�todo Sets p�ra este campo.
    */
  public void setBanco(String PARAM) {
    banco = PARAM;
  }
  /**
    * ALTERADO: M�todo Gets para este campo
    */
  public String getAlterado() {
    return alterado;
  }
  /**
    * ALTERADO: M�todo Sets p�ra este campo.
    */
  public void setAlterado(String PARAM) {
    alterado = PARAM;
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
    * OC: M�todo Gets para este campo
    */
  public String getOc() {
    return oc;
  }
  /**
    * OC: M�todo Sets p�ra este campo.
    */
  public void setOc(String PARAM) {
    oc = PARAM;
  }
  /**
    * MODELOS: M�todo Gets para este campo
    */
  public String getModelos() {
    return modelos;
  }
  /**
    * MODELOS: M�todo Sets p�ra este campo.
    */
  public void setModelos(String PARAM) {
    modelos = PARAM;
  }
  /**
    * ETIQUETAS: M�todo Gets para este campo
    */
  public String getEtiquetas() {
    return etiquetas;
  }
  /**
    * ETIQUETAS: M�todo Sets p�ra este campo.
    */
  public void setEtiquetas(String PARAM) {
    etiquetas = PARAM;
  }
  /**
    * OBSE_ADICIONAIS: M�todo Gets para este campo
    */
  public String getObse_adicionais() {
    return obse_adicionais;
  }
  /**
    * OBSE_ADICIONAIS: M�todo Sets p�ra este campo.
    */
  public void setObse_adicionais(String PARAM) {
    obse_adicionais = PARAM;
  }
  /**
    * PRS: M�todo Gets para este campo
    */
  public String getPrs() {
    return prs;
  }
  /**
    * PRS: M�todo Sets p�ra este campo.
    */
  public void setPrs(String PARAM) {
    prs = PARAM;
  }
  /**
    * REMESSA: M�todo Gets para este campo
    */
  public String getRemessa() {
    return remessa;
  }
  /**
    * REMESSA: M�todo Sets p�ra este campo.
    */
  public void setRemessa(String PARAM) {
    remessa = PARAM;
  }
  /**
    * FILIAL_PRD: M�todo Gets para este campo
    */
  public String getFilial_prd() {
    return filial_prd;
  }
  /**
    * FILIAL_PRD: M�todo Sets p�ra este campo.
    */
  public void setFilial_prd(String PARAM) {
    filial_prd = PARAM;
  }
  /**
    * FIL_FILIAL_FAT: M�todo Gets para este campo
    */
  public String getFil_filial_fat() {
    return fil_filial_fat;
  }
  /**
    * FIL_FILIAL_FAT: M�todo Sets p�ra este campo.
    */
  public void setFil_filial_fat(String PARAM) {
    fil_filial_fat = PARAM;
  }
  /**
    * DT_DIGIT: M�todo Gets para este campo
    */
  public String getDt_digit() {
    return dt_digit;
  }
  /**
    * DT_DIGIT: M�todo Sets p�ra este campo.
    */
  public void setDt_digit(String PARAM) {
    dt_digit = PARAM;
  }
  /**
    * DT_FATUR: M�todo Gets para este campo
    */
  public String getDt_fatur() {
    return dt_fatur;
  }
  /**
    * DT_FATUR: M�todo Sets p�ra este campo.
    */
  public void setDt_fatur(String PARAM) {
    dt_fatur = PARAM;
  }
  /**
    * DT_FATUR_FILIAL: M�todo Gets para este campo
    */
  public String getDt_fatur_filial() {
    return dt_fatur_filial;
  }
  /**
    * DT_FATUR_FILIAL: M�todo Sets p�ra este campo.
    */
  public void setDt_fatur_filial(String PARAM) {
    dt_fatur_filial = PARAM;
  }
  /**
    * MARCA: M�todo Gets para este campo
    */
  public String getMarca() {
    return marca;
  }
  /**
    * MARCA: M�todo Sets p�ra este campo.
    */
  public void setMarca(String PARAM) {
    marca = PARAM;
  }
  /**
    * CARIMBO: M�todo Gets para este campo
    */
  public String getCarimbo() {
    return carimbo;
  }
  /**
    * CARIMBO: M�todo Sets p�ra este campo.
    */
  public void setCarimbo(String PARAM) {
    carimbo = PARAM;
  }
  /**
    * ROTULOS: M�todo Gets para este campo
    */
  public String getRotulos() {
    return rotulos;
  }
  /**
    * ROTULOS: M�todo Sets p�ra este campo.
    */
  public void setRotulos(String PARAM) {
    rotulos = PARAM;
  }
  /**
    * PED_AMOSTRA: M�todo Gets para este campo
    */
  public String getPed_amostra() {
    return ped_amostra;
  }
  /**
    * PED_AMOSTRA: M�todo Sets p�ra este campo.
    */
  public void setPed_amostra(String PARAM) {
    ped_amostra = PARAM;
  }
  /**
    * DT_ENVIO_AMOSTRAS: M�todo Gets para este campo
    */
  public String getDt_envio_amostras() {
    return dt_envio_amostras;
  }
  /**
    * DT_ENVIO_AMOSTRAS: M�todo Sets p�ra este campo.
    */
  public void setDt_envio_amostras(String PARAM) {
    dt_envio_amostras = PARAM;
  }
  /**
    * AGENDAMENTO_CDGO: M�todo Gets para este campo
    */
  public String getAgendamento_cdgo() {
    return agendamento_cdgo;
  }
  /**
    * AGENDAMENTO_CDGO: M�todo Sets p�ra este campo.
    */
  public void setAgendamento_cdgo(String PARAM) {
    agendamento_cdgo = PARAM;
  }
  /**
    * DEZENA: M�todo Gets para este campo
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

  public String[][] getDezena_Ajax(ControlePedidosEntrega_mActionForm PARAM) {
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
    * DEZENA: M�todo Sets p�ra este campo.
    */
  public void setDezena(String PARAM) {
    dezena = PARAM;
  }
  /**
    * DIA: M�todo Gets para este campo
    */
  public String getDia() {
    return dia;
  }
  /**
    * DIA: M�todo Sets p�ra este campo.
    */
  public void setDia(String PARAM) {
    dia = PARAM;
  }
  /**
    * DATA_EFETIVA: M�todo Gets para este campo
    */
  public String getData_efetiva() {
    return data_efetiva;
  }
  /**
    * DATA_EFETIVA: M�todo Sets p�ra este campo.
    */
  public void setData_efetiva(String PARAM) {
    data_efetiva = PARAM;
  }
  /**
    * CODIGO_REGIONAL: M�todo Gets para este campo
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: M�todo Sets p�ra este campo.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * REP_CDGO: M�todo Gets para este campo
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: M�todo Sets p�ra este campo.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
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
    * CODIGO_MARCA: M�todo Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: M�todo Sets p�ra este campo.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * PED_STAT: M�todo Gets para este campo
    */
  public String getPed_stat() {
    return ped_stat;
  }
  /**
    * PED_STAT: M�todo Sets p�ra este campo.
    */
  public void setPed_stat(String PARAM) {
    ped_stat = PARAM;
  }
  /**
    * BLOQUEIA_NAVEGADOR: M�todo Gets para este campo
    */
  public String getBloqueia_navegador() {
    return bloqueia_navegador;
  }
  /**
    * BLOQUEIA_NAVEGADOR: M�todo Sets p�ra este campo.
    */
  public void setBloqueia_navegador(String PARAM) {
    bloqueia_navegador = PARAM;
  }
  /**
    * HORA: M�todo Gets para este campo
    */
  public String getHora() {
    return hora;
  }
  /**
    * HORA: M�todo Sets p�ra este campo.
    */
  public void setHora(String PARAM) {
    hora = PARAM;
  }
  /**
    * SENHA: M�todo Gets para este campo
    */
  public String getSenha() {
    return senha;
  }
  /**
    * SENHA: M�todo Sets p�ra este campo.
    */
  public void setSenha(String PARAM) {
    senha = PARAM;
  }
  /**
    * DT_EMISSAO: M�todo Gets para este campo
    */
  public String getDt_emissao() {
    return dt_emissao;
  }
  /**
    * DT_EMISSAO: M�todo Sets p�ra este campo.
    */
  public void setDt_emissao(String PARAM) {
    dt_emissao = PARAM;
  }
  /**
    * FILIAL: M�todo Gets para este campo
    */
  public String getFilial() {
    return filial;
  }
  /**
    * FILIAL: M�todo Sets p�ra este campo.
    */
  public void setFilial(String PARAM) {
    filial = PARAM;
  }
  /**
    * NOTAFISCAL: M�todo Gets para este campo
    */
  public String getNotafiscal() {
    return notafiscal;
  }
  /**
    * NOTAFISCAL: M�todo Sets p�ra este campo.
    */
  public void setNotafiscal(String PARAM) {
    notafiscal = PARAM;
  }
  /**
    * VOLUMES: M�todo Gets para este campo
    */
  public String getVolumes() {
    return volumes;
  }
  /**
    * VOLUMES: M�todo Sets p�ra este campo.
    */
  public void setVolumes(String PARAM) {
    volumes = PARAM;
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
    * VALOR_PEDIDO: M�todo Gets para este campo
    */
  public String getValor_pedido() {
    return valor_pedido;
  }
  /**
    * VALOR_PEDIDO: M�todo Sets p�ra este campo.
    */
  public void setValor_pedido(String PARAM) {
    valor_pedido = PARAM;
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
    * REP_RZAO: M�todo Gets para este campo
    */
  public String getRep_rzao() {
    return rep_rzao;
  }
  /**
    * REP_RZAO: M�todo Sets p�ra este campo.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
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
    * PED_AMOSTRA_BRINDE: M�todo Gets para este campo
    */
  public String getPed_amostra_brinde() {
    return ped_amostra_brinde;
  }
  /**
    * PED_AMOSTRA_BRINDE: M�todo Sets p�ra este campo.
    */
  public void setPed_amostra_brinde(String PARAM) {
    ped_amostra_brinde = PARAM;
  }
  /**
    * DATA_ENTREGA_CLIENTE: M�todo Gets para este campo
    */
  public String getData_entrega_cliente() {
    return data_entrega_cliente;
  }
  /**
    * DATA_ENTREGA_CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setData_entrega_cliente(String PARAM) {
    data_entrega_cliente = PARAM;
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
    cli_rzao = null;
    valor_pedido = null;
    esc_seqn = null;
    rep_rzao = null;
    cliente = null;
    ped_amostra_brinde = null;
    data_entrega_cliente = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,", request)) {
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
        errors.add("dt_emissao", new ActionMessage("error.validate.date","Emiss�o","dt_emissao","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(valor_pedido)) {
        errors.add("valor_pedido", new ActionMessage("error.validate.number","double","valor_pedido","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_entrega_cliente)) {
        errors.add("data_entrega_cliente", new ActionMessage("error.validate.date","Dt_digit","data_entrega_cliente","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
