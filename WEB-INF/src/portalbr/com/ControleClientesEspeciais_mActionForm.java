package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/05/2011 14:08:30
 * Last Modify Date 20/03/2023 18:01:33
 */

public class ControleClientesEspeciais_mActionForm extends org.apache.struts.action.ActionForm
{
  public String gridCheckField;
  public String banco;
  public String alterado;
  public String ped_nmro;
  public String ped_boni;
  public String ped_boni2;
  public String ped_desc;
  public String cnd_cdgo;
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
  public String portao;
  public String cd_entrega;
  public String data_entrega_cliente;
  public String ped_amostra_brinde;
  public String esc_seqn;
  public String nome_regional;
  public String rep_rzao;
  public String ped_tipo;
  public String dt_rec_etiqueta_filial;
  public String encarte1;
  public boolean prioridade_embarque;
  public String atacado;
  public String alerta;
  public String ped_especie_pedido;
  public String ped_obse;
  public String dt_emiss;
  public String nro_normativa_cliente;
  public String descricao_normativa_cliente;
  public String min_fabr;
  public String bloqueio_49;
  public String loja;
  public String cidade;
  public String ped_invoice;
  public String ocorrencia;
  public String data_bloqueio;
  public String data_prevista_desbloqueio;
  public String dt_solicitacao_alarme;
  public String dt_rec_alarme_pcp;
  public String dt_rec_alarme_filial;
  public String nfe_numero;
  public String valor_pedido;
  public String distribuicao;
  public String livro;
  public String ref_cliente_por_pedido;
  public String tra_cdgo;
  public String tra_rzao;
  public String dt_corte;
  public String preco_pdv;
  public String certificado_origem;
  public String gerar_requisicao;
  public String tes_codigo;
  public String les_codigo;
  public String data_etiquetagem;
  public String descricao_modelos;
  public String liberado_faturar;
  public String descricao_situacao;
  public String descricao_embalagem;
  public String cnpj;
  public String numero_romaneio;
  public String data_finalizacao_romaneio;
  public String modelo_alarme;
  public String grades_corrugados;
  public String filial_local_estoque;
  public String bloqueio_oc;
  public String bloqueio_distribuicao;
  public String bloqueio_cliente;
  public String bloqueio_sku;
  public String bloqueio_credito;
  public String bloqueio_suframa;
  private boolean valida = false;
  public ControleClientesEspeciais_mActionForm() {
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
    * PED_BONI: M�todo Gets para este campo
    */
  public String getPed_boni() {
    return ped_boni;
  }
  /**
    * PED_BONI: M�todo Sets p�ra este campo.
    */
  public void setPed_boni(String PARAM) {
    ped_boni = PARAM;
  }
  /**
    * PED_BONI2: M�todo Gets para este campo
    */
  public String getPed_boni2() {
    return ped_boni2;
  }
  /**
    * PED_BONI2: M�todo Sets p�ra este campo.
    */
  public void setPed_boni2(String PARAM) {
    ped_boni2 = PARAM;
  }
  /**
    * PED_DESC: M�todo Gets para este campo
    */
  public String getPed_desc() {
    return ped_desc;
  }
  /**
    * PED_DESC: M�todo Sets p�ra este campo.
    */
  public void setPed_desc(String PARAM) {
    ped_desc = PARAM;
  }
  /**
    * CND_CDGO: M�todo Gets para este campo
    */
  public String getCnd_cdgo() {
    return cnd_cdgo;
  }
  /**
    * CND_CDGO: M�todo Sets p�ra este campo.
    */
  public void setCnd_cdgo(String PARAM) {
    cnd_cdgo = PARAM;
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
    * DT_ENTREGA_ETIQUETA: M�todo Gets para este campo
    */
  public String getDt_entrega_etiqueta() {
    return dt_entrega_etiqueta;
  }
  /**
    * DT_ENTREGA_ETIQUETA: M�todo Sets p�ra este campo.
    */
  public void setDt_entrega_etiqueta(String PARAM) {
    dt_entrega_etiqueta = PARAM;
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

  public String[][] getDezena_Ajax(ControleClientesEspeciais_mActionForm PARAM) {
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
    * DT_INSPECAO: M�todo Gets para este campo
    */
  public String getDt_inspecao() {
    return dt_inspecao;
  }
  /**
    * DT_INSPECAO: M�todo Sets p�ra este campo.
    */
  public void setDt_inspecao(String PARAM) {
    dt_inspecao = PARAM;
  }
  /**
    * DT_MONTAGEM: M�todo Gets para este campo
    */
  public String getDt_montagem() {
    return dt_montagem;
  }
  /**
    * DT_MONTAGEM: M�todo Sets p�ra este campo.
    */
  public void setDt_montagem(String PARAM) {
    dt_montagem = PARAM;
  }
  /**
    * GRUPO_ECONOMICO: M�todo Gets para este campo
    */
  public String getGrupo_economico() {
    return grupo_economico;
  }
  /**
    * GRUPO_ECONOMICO: M�todo Sets p�ra este campo.
    */
  public void setGrupo_economico(String PARAM) {
    grupo_economico = PARAM;
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
    * CABIDE: M�todo Gets para este campo
    */
  public String getCabide() {
    return cabide;
  }
  /**
    * CABIDE: M�todo Sets p�ra este campo.
    */
  public void setCabide(String PARAM) {
    cabide = PARAM;
  }
  /**
    * AMOSTRA: M�todo Gets para este campo
    */
  public String getAmostra() {
    return amostra;
  }
  /**
    * AMOSTRA: M�todo Sets p�ra este campo.
    */
  public void setAmostra(String PARAM) {
    amostra = PARAM;
  }
  /**
    * TIPO_AMOSTRA: M�todo Gets para este campo
    */
  public String getTipo_amostra() {
    return tipo_amostra;
  }
  /**
    * TIPO_AMOSTRA: M�todo Sets p�ra este campo.
    */
  public void setTipo_amostra(String PARAM) {
    tipo_amostra = PARAM;
  }
  /**
    * PEDIDO_PROD: M�todo Gets para este campo
    */
  public String getPedido_prod() {
    return pedido_prod;
  }
  /**
    * PEDIDO_PROD: M�todo Sets p�ra este campo.
    */
  public void setPedido_prod(String PARAM) {
    pedido_prod = PARAM;
  }
  /**
    * ENCARTE: M�todo Gets para este campo
    */
  public String getEncarte() {
    return encarte;
  }
  /**
    * ENCARTE: M�todo Sets p�ra este campo.
    */
  public void setEncarte(String PARAM) {
    encarte = PARAM;
  }
  /**
    * DT_ENT_AMOSTRA_COMERCIAL: M�todo Gets para este campo
    */
  public String getDt_ent_amostra_comercial() {
    return dt_ent_amostra_comercial;
  }
  /**
    * DT_ENT_AMOSTRA_COMERCIAL: M�todo Sets p�ra este campo.
    */
  public void setDt_ent_amostra_comercial(String PARAM) {
    dt_ent_amostra_comercial = PARAM;
  }
  /**
    * DT_ENT_AMOSTRA_PCP: M�todo Gets para este campo
    */
  public String getDt_ent_amostra_pcp() {
    return dt_ent_amostra_pcp;
  }
  /**
    * DT_ENT_AMOSTRA_PCP: M�todo Sets p�ra este campo.
    */
  public void setDt_ent_amostra_pcp(String PARAM) {
    dt_ent_amostra_pcp = PARAM;
  }
  /**
    * PORTAO: M�todo Gets para este campo
    */
  public String getPortao() {
    return portao;
  }
  /**
    * PORTAO: M�todo Sets p�ra este campo.
    */
  public void setPortao(String PARAM) {
    portao = PARAM;
  }
  /**
    * CD_ENTREGA: M�todo Gets para este campo
    */
  public String getCd_entrega() {
    return cd_entrega;
  }
  /**
    * CD_ENTREGA: M�todo Sets p�ra este campo.
    */
  public void setCd_entrega(String PARAM) {
    cd_entrega = PARAM;
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
    * NOME_REGIONAL: M�todo Gets para este campo
    */
  public String getNome_regional() {
    return nome_regional;
  }
  /**
    * NOME_REGIONAL: M�todo Sets p�ra este campo.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
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
    * PED_TIPO: M�todo Gets para este campo
    */
  public String getPed_tipo() {
    return ped_tipo;
  }
  /**
    * PED_TIPO: M�todo Sets p�ra este campo.
    */
  public void setPed_tipo(String PARAM) {
    ped_tipo = PARAM;
  }
  /**
    * DT_REC_ETIQUETA_FILIAL: M�todo Gets para este campo
    */
  public String getDt_rec_etiqueta_filial() {
    return dt_rec_etiqueta_filial;
  }
  /**
    * DT_REC_ETIQUETA_FILIAL: M�todo Sets p�ra este campo.
    */
  public void setDt_rec_etiqueta_filial(String PARAM) {
    dt_rec_etiqueta_filial = PARAM;
  }
  /**
    * ENCARTE1: M�todo Gets para este campo
    */
  public String getEncarte1() {
    return encarte1;
  }
  /**
    * ENCARTE1: M�todo Sets p�ra este campo.
    */
  public void setEncarte1(String PARAM) {
    encarte1 = PARAM;
  }
  /**
    * PRIORIDADE_EMBARQUE: M�todo Gets para este campo
    */
  public boolean getPrioridade_embarque() {
    return prioridade_embarque;
  }
  /**
    * PRIORIDADE_EMBARQUE: M�todo Sets p�ra este campo.
    */
  public void setPrioridade_embarque(boolean PARAM) {
    prioridade_embarque = PARAM;
  }
  /**
    * ATACADO: M�todo Gets para este campo
    */
  public String getAtacado() {
    return atacado;
  }
  /**
    * ATACADO: M�todo Sets p�ra este campo.
    */
  public void setAtacado(String PARAM) {
    atacado = PARAM;
  }
  /**
    * ALERTA: M�todo Gets para este campo
    */
  public String getAlerta() {
    return alerta;
  }
  /**
    * ALERTA: M�todo Sets p�ra este campo.
    */
  public void setAlerta(String PARAM) {
    alerta = PARAM;
  }
  /**
    * PED_ESPECIE_PEDIDO: M�todo Gets para este campo
    */
  public String getPed_especie_pedido() {
    return ped_especie_pedido;
  }
  /**
    * PED_ESPECIE_PEDIDO: M�todo Sets p�ra este campo.
    */
  public void setPed_especie_pedido(String PARAM) {
    ped_especie_pedido = PARAM;
  }
  /**
    * PED_OBSE: M�todo Gets para este campo
    */
  public String getPed_obse() {
    return ped_obse;
  }
  /**
    * PED_OBSE: M�todo Sets p�ra este campo.
    */
  public void setPed_obse(String PARAM) {
    ped_obse = PARAM;
  }
  /**
    * DT_EMISS: M�todo Gets para este campo
    */
  public String getDt_emiss() {
    return dt_emiss;
  }
  /**
    * DT_EMISS: M�todo Sets p�ra este campo.
    */
  public void setDt_emiss(String PARAM) {
    dt_emiss = PARAM;
  }
  /**
    * NRO_NORMATIVA_CLIENTE: M�todo Gets para este campo
    */
  public String getNro_normativa_cliente() {
    return nro_normativa_cliente;
  }
  /**
    * NRO_NORMATIVA_CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setNro_normativa_cliente(String PARAM) {
    nro_normativa_cliente = PARAM;
  }
  /**
    * DESCRICAO_NORMATIVA_CLIENTE: M�todo Gets para este campo
    */
  public String getDescricao_normativa_cliente() {
    return descricao_normativa_cliente;
  }
  /**
    * DESCRICAO_NORMATIVA_CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setDescricao_normativa_cliente(String PARAM) {
    descricao_normativa_cliente = PARAM;
  }
  /**
    * MIN_FABR: M�todo Gets para este campo
    */
  public String getMin_fabr() {
    return min_fabr;
  }
  /**
    * MIN_FABR: M�todo Sets p�ra este campo.
    */
  public void setMin_fabr(String PARAM) {
    min_fabr = PARAM;
  }
  /**
    * BLOQUEIO_49: M�todo Gets para este campo
    */
  public String getBloqueio_49() {
    return bloqueio_49;
  }
  /**
    * BLOQUEIO_49: M�todo Sets p�ra este campo.
    */
  public void setBloqueio_49(String PARAM) {
    bloqueio_49 = PARAM;
  }
  /**
    * LOJA: M�todo Gets para este campo
    */
  public String getLoja() {
    return loja;
  }
  /**
    * LOJA: M�todo Sets p�ra este campo.
    */
  public void setLoja(String PARAM) {
    loja = PARAM;
  }
  /**
    * CIDADE: M�todo Gets para este campo
    */
  public String getCidade() {
    return cidade;
  }
  /**
    * CIDADE: M�todo Sets p�ra este campo.
    */
  public void setCidade(String PARAM) {
    cidade = PARAM;
  }
  /**
    * PED_INVOICE: M�todo Gets para este campo
    */
  public String getPed_invoice() {
    return ped_invoice;
  }
  /**
    * PED_INVOICE: M�todo Sets p�ra este campo.
    */
  public void setPed_invoice(String PARAM) {
    ped_invoice = PARAM;
  }
  /**
    * OCORRENCIA: M�todo Gets para este campo
    */
  public String getOcorrencia() {
    return ocorrencia;
  }
  /**
    * OCORRENCIA: M�todo Sets p�ra este campo.
    */
  public void setOcorrencia(String PARAM) {
    ocorrencia = PARAM;
  }
  /**
    * DATA_BLOQUEIO: M�todo Gets para este campo
    */
  public String getData_bloqueio() {
    return data_bloqueio;
  }
  /**
    * DATA_BLOQUEIO: M�todo Sets p�ra este campo.
    */
  public void setData_bloqueio(String PARAM) {
    data_bloqueio = PARAM;
  }
  /**
    * DATA_PREVISTA_DESBLOQUEIO: M�todo Gets para este campo
    */
  public String getData_prevista_desbloqueio() {
    return data_prevista_desbloqueio;
  }
  /**
    * DATA_PREVISTA_DESBLOQUEIO: M�todo Sets p�ra este campo.
    */
  public void setData_prevista_desbloqueio(String PARAM) {
    data_prevista_desbloqueio = PARAM;
  }
  /**
    * DT_SOLICITACAO_ALARME: M�todo Gets para este campo
    */
  public String getDt_solicitacao_alarme() {
    return dt_solicitacao_alarme;
  }
  /**
    * DT_SOLICITACAO_ALARME: M�todo Sets p�ra este campo.
    */
  public void setDt_solicitacao_alarme(String PARAM) {
    dt_solicitacao_alarme = PARAM;
  }
  /**
    * DT_REC_ALARME_PCP: M�todo Gets para este campo
    */
  public String getDt_rec_alarme_pcp() {
    return dt_rec_alarme_pcp;
  }
  /**
    * DT_REC_ALARME_PCP: M�todo Sets p�ra este campo.
    */
  public void setDt_rec_alarme_pcp(String PARAM) {
    dt_rec_alarme_pcp = PARAM;
  }
  /**
    * DT_REC_ALARME_FILIAL: M�todo Gets para este campo
    */
  public String getDt_rec_alarme_filial() {
    return dt_rec_alarme_filial;
  }
  /**
    * DT_REC_ALARME_FILIAL: M�todo Sets p�ra este campo.
    */
  public void setDt_rec_alarme_filial(String PARAM) {
    dt_rec_alarme_filial = PARAM;
  }
  /**
    * NFE_NUMERO: M�todo Gets para este campo
    */
  public String getNfe_numero() {
    return nfe_numero;
  }
  /**
    * NFE_NUMERO: M�todo Sets p�ra este campo.
    */
  public void setNfe_numero(String PARAM) {
    nfe_numero = PARAM;
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
    * DISTRIBUICAO: M�todo Gets para este campo
    */
  public String getDistribuicao() {
    return distribuicao;
  }
  /**
    * DISTRIBUICAO: M�todo Sets p�ra este campo.
    */
  public void setDistribuicao(String PARAM) {
    distribuicao = PARAM;
  }
  /**
    * LIVRO: M�todo Gets para este campo
    */
  public String getLivro() {
    return livro;
  }
  /**
    * LIVRO: M�todo Sets p�ra este campo.
    */
  public void setLivro(String PARAM) {
    livro = PARAM;
  }
  /**
    * REF_CLIENTE_POR_PEDIDO: M�todo Gets para este campo
    */
  public String getRef_cliente_por_pedido() {
    return ref_cliente_por_pedido;
  }
  /**
    * REF_CLIENTE_POR_PEDIDO: M�todo Sets p�ra este campo.
    */
  public void setRef_cliente_por_pedido(String PARAM) {
    ref_cliente_por_pedido = PARAM;
  }
  /**
    * TRA_CDGO: M�todo Gets para este campo
    */
  public String getTra_cdgo() {
    return tra_cdgo;
  }
  /**
    * TRA_CDGO: M�todo Sets p�ra este campo.
    */
  public void setTra_cdgo(String PARAM) {
    tra_cdgo = PARAM;
  }
  /**
    * TRA_RZAO: M�todo Gets para este campo
    */
  public String getTra_rzao() {
    return tra_rzao;
  }
  /**
    * TRA_RZAO: M�todo Sets p�ra este campo.
    */
  public void setTra_rzao(String PARAM) {
    tra_rzao = PARAM;
  }
  /**
    * DT_CORTE: M�todo Gets para este campo
    */
  public String getDt_corte() {
    return dt_corte;
  }
  /**
    * DT_CORTE: M�todo Sets p�ra este campo.
    */
  public void setDt_corte(String PARAM) {
    dt_corte = PARAM;
  }
  /**
    * PRECO_PDV: M�todo Gets para este campo
    */
  public String getPreco_pdv() {
    return preco_pdv;
  }
  /**
    * PRECO_PDV: M�todo Sets p�ra este campo.
    */
  public void setPreco_pdv(String PARAM) {
    preco_pdv = PARAM;
  }
  /**
    * CERTIFICADO_ORIGEM: M�todo Gets para este campo
    */
  public String getCertificado_origem() {
    return certificado_origem;
  }
  /**
    * CERTIFICADO_ORIGEM: M�todo Sets p�ra este campo.
    */
  public void setCertificado_origem(String PARAM) {
    certificado_origem = PARAM;
  }
  /**
    * GERAR_REQUISICAO: M�todo Gets para este campo
    */
  public String getGerar_requisicao() {
    return gerar_requisicao;
  }
  /**
    * GERAR_REQUISICAO: M�todo Sets p�ra este campo.
    */
  public void setGerar_requisicao(String PARAM) {
    gerar_requisicao = PARAM;
  }
  /**
    * TES_CODIGO: M�todo Gets para este campo
    */
  public String getTes_codigo() {
    return tes_codigo;
  }
  /**
    * TES_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setTes_codigo(String PARAM) {
    tes_codigo = PARAM;
  }
  /**
    * LES_CODIGO: M�todo Gets para este campo
    */
  public String getLes_codigo() {
    return les_codigo;
  }
  /**
    * LES_CODIGO: M�todo Sets p�ra este campo.
    */
  public void setLes_codigo(String PARAM) {
    les_codigo = PARAM;
  }
  /**
    * DATA_ETIQUETAGEM: M�todo Gets para este campo
    */
  public String getData_etiquetagem() {
    return data_etiquetagem;
  }
  /**
    * DATA_ETIQUETAGEM: M�todo Sets p�ra este campo.
    */
  public void setData_etiquetagem(String PARAM) {
    data_etiquetagem = PARAM;
  }
  /**
    * DESCRICAO_MODELOS: M�todo Gets para este campo
    */
  public String getDescricao_modelos() {
    return descricao_modelos;
  }
  /**
    * DESCRICAO_MODELOS: M�todo Sets p�ra este campo.
    */
  public void setDescricao_modelos(String PARAM) {
    descricao_modelos = PARAM;
  }
  /**
    * LIBERADO_FATURAR: M�todo Gets para este campo
    */
  public String getLiberado_faturar() {
    return liberado_faturar;
  }
  /**
    * LIBERADO_FATURAR: M�todo Sets p�ra este campo.
    */
  public void setLiberado_faturar(String PARAM) {
    liberado_faturar = PARAM;
  }
  /**
    * DESCRICAO_SITUACAO: M�todo Gets para este campo
    */
  public String getDescricao_situacao() {
    return descricao_situacao;
  }
  /**
    * DESCRICAO_SITUACAO: M�todo Sets p�ra este campo.
    */
  public void setDescricao_situacao(String PARAM) {
    descricao_situacao = PARAM;
  }
  /**
    * DESCRICAO_EMBALAGEM: M�todo Gets para este campo
    */
  public String getDescricao_embalagem() {
    return descricao_embalagem;
  }
  /**
    * DESCRICAO_EMBALAGEM: M�todo Sets p�ra este campo.
    */
  public void setDescricao_embalagem(String PARAM) {
    descricao_embalagem = PARAM;
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
    * NUMERO_ROMANEIO: M�todo Gets para este campo
    */
  public String getNumero_romaneio() {
    return numero_romaneio;
  }
  /**
    * NUMERO_ROMANEIO: M�todo Sets p�ra este campo.
    */
  public void setNumero_romaneio(String PARAM) {
    numero_romaneio = PARAM;
  }
  /**
    * DATA_FINALIZACAO_ROMANEIO: M�todo Gets para este campo
    */
  public String getData_finalizacao_romaneio() {
    return data_finalizacao_romaneio;
  }
  /**
    * DATA_FINALIZACAO_ROMANEIO: M�todo Sets p�ra este campo.
    */
  public void setData_finalizacao_romaneio(String PARAM) {
    data_finalizacao_romaneio = PARAM;
  }
  /**
    * MODELO_ALARME: M�todo Gets para este campo
    */
  public String getModelo_alarme() {
    return modelo_alarme;
  }
  /**
    * MODELO_ALARME: M�todo Sets p�ra este campo.
    */
  public void setModelo_alarme(String PARAM) {
    modelo_alarme = PARAM;
  }
  /**
    * GRADES_CORRUGADOS: M�todo Gets para este campo
    */
  public String getGrades_corrugados() {
    return grades_corrugados;
  }
  /**
    * GRADES_CORRUGADOS: M�todo Sets p�ra este campo.
    */
  public void setGrades_corrugados(String PARAM) {
    grades_corrugados = PARAM;
  }
  /**
    * FILIAL_LOCAL_ESTOQUE: M�todo Gets para este campo
    */
  public String getFilial_local_estoque() {
    return filial_local_estoque;
  }
  /**
    * FILIAL_LOCAL_ESTOQUE: M�todo Sets p�ra este campo.
    */
  public void setFilial_local_estoque(String PARAM) {
    filial_local_estoque = PARAM;
  }
  /**
    * BLOQUEIO_OC: M�todo Gets para este campo
    */
  public String getBloqueio_oc() {
    return bloqueio_oc;
  }
  /**
    * BLOQUEIO_OC: M�todo Sets p�ra este campo.
    */
  public void setBloqueio_oc(String PARAM) {
    bloqueio_oc = PARAM;
  }
  /**
    * BLOQUEIO_DISTRIBUICAO: M�todo Gets para este campo
    */
  public String getBloqueio_distribuicao() {
    return bloqueio_distribuicao;
  }
  /**
    * BLOQUEIO_DISTRIBUICAO: M�todo Sets p�ra este campo.
    */
  public void setBloqueio_distribuicao(String PARAM) {
    bloqueio_distribuicao = PARAM;
  }
  /**
    * BLOQUEIO_CLIENTE: M�todo Gets para este campo
    */
  public String getBloqueio_cliente() {
    return bloqueio_cliente;
  }
  /**
    * BLOQUEIO_CLIENTE: M�todo Sets p�ra este campo.
    */
  public void setBloqueio_cliente(String PARAM) {
    bloqueio_cliente = PARAM;
  }
  /**
    * BLOQUEIO_SKU: M�todo Gets para este campo
    */
  public String getBloqueio_sku() {
    return bloqueio_sku;
  }
  /**
    * BLOQUEIO_SKU: M�todo Sets p�ra este campo.
    */
  public void setBloqueio_sku(String PARAM) {
    bloqueio_sku = PARAM;
  }
  /**
    * BLOQUEIO_CREDITO: M�todo Gets para este campo
    */
  public String getBloqueio_credito() {
    return bloqueio_credito;
  }
  /**
    * BLOQUEIO_CREDITO: M�todo Sets p�ra este campo.
    */
  public void setBloqueio_credito(String PARAM) {
    bloqueio_credito = PARAM;
  }
  /**
    * BLOQUEIO_SUFRAMA: M�todo Gets para este campo
    */
  public String getBloqueio_suframa() {
    return bloqueio_suframa;
  }
  /**
    * BLOQUEIO_SUFRAMA: M�todo Sets p�ra este campo.
    */
  public void setBloqueio_suframa(String PARAM) {
    bloqueio_suframa = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gridCheckField = null;
    banco = null;
    alterado = null;
    ped_nmro = null;
    ped_boni = null;
    ped_boni2 = null;
    ped_desc = null;
    cnd_cdgo = null;
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
    portao = null;
    cd_entrega = null;
    data_entrega_cliente = null;
    ped_amostra_brinde = null;
    esc_seqn = null;
    nome_regional = null;
    rep_rzao = null;
    ped_tipo = null;
    dt_rec_etiqueta_filial = null;
    encarte1 = null;
    prioridade_embarque = false;
    atacado = null;
    alerta = null;
    ped_especie_pedido = null;
    ped_obse = null;
    dt_emiss = null;
    nro_normativa_cliente = null;
    descricao_normativa_cliente = null;
    min_fabr = null;
    bloqueio_49 = null;
    loja = null;
    cidade = null;
    ped_invoice = null;
    ocorrencia = null;
    data_bloqueio = null;
    data_prevista_desbloqueio = null;
    dt_solicitacao_alarme = null;
    dt_rec_alarme_pcp = null;
    dt_rec_alarme_filial = null;
    nfe_numero = null;
    valor_pedido = null;
    distribuicao = null;
    livro = null;
    ref_cliente_por_pedido = null;
    tra_cdgo = null;
    tra_rzao = null;
    dt_corte = null;
    preco_pdv = null;
    certificado_origem = null;
    gerar_requisicao = null;
    tes_codigo = null;
    les_codigo = null;
    data_etiquetagem = null;
    descricao_modelos = null;
    liberado_faturar = null;
    descricao_situacao = null;
    descricao_embalagem = null;
    cnpj = null;
    numero_romaneio = null;
    data_finalizacao_romaneio = null;
    modelo_alarme = null;
    grades_corrugados = null;
    filial_local_estoque = null;
    bloqueio_oc = null;
    bloqueio_distribuicao = null;
    bloqueio_cliente = null;
    bloqueio_sku = null;
    bloqueio_credito = null;
    bloqueio_suframa = null;
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
