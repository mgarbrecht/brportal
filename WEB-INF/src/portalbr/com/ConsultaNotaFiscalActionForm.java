package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/03/2006 11:59:36
 * Last Modify Date 09/02/2023 10:58:31
 */

public class ConsultaNotaFiscalActionForm extends org.apache.struts.action.ActionForm
{
  public String nfs_nmro;
  public String emp_empresa;
  public String emp_razsoc;
  public String fil_filial;
  public String fil_razsoc;
  public String codigo_regional;
  public String nome_regional;
  public String est_unifed;
  public String rep_cdgo;
  public String rep_rzao;
  public String cli_cdgo;
  public String cli_rzao;
  public String esc_seqn;
  public String gre_grupo;
  public String gre_descricao;
  public String codigo_marca;
  public String descricao_marca;
  public String tra_cdgo;
  public String desc_tra;
  public String sigla_transportadora;
  public String nfs_cons;
  public String nfs_cons_desc;
  public String ano_fatura;
  public String numero_fatura;
  public String dt_inicial;
  public String dt_final;
  public String especie;
  public String reg;
  public String rep;
  public String filial;
  public String nro_romaneio;
  public String cb_notas_fretes;
  public String cb_notas_remessa;
  public String cb_amostra;
  public String cb_brindes;
  public String cb_sem_ocorrencia_entrega;
  public String cb_notas_em_devolucao;
  public String romaneio;
  public String desconsidera_notas_entrada;
  public String gera_excel;
  private boolean valida = false;
  public ConsultaNotaFiscalActionForm() {
  }
  /**
    * NFS_NMRO: Method to get the field value.
    */
  public String getNfs_nmro() {
    return nfs_nmro;
  }
  /**
    * NFS_NMRO: Method to set the field value.
    */
  public void setNfs_nmro(String PARAM) {
    nfs_nmro = PARAM;
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
  /**
    * EMP_RAZSOC: Method to get the field value.
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

  public String[][] getEmp_razsoc_Ajax(ConsultaNotaFiscalActionForm PARAM) {
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
    * EMP_RAZSOC: Method to set the field value.
    */
  public void setEmp_razsoc(String PARAM) {
    emp_razsoc = PARAM;
  }
  /**
    * FIL_FILIAL: Method to get the field value.
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Method to set the field value.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * FIL_RAZSOC: Method to get the field value.
    */
  public String getFil_razsoc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fil_filial != null && fil_filial.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = {{"fil_razsoc",null}};
        Object[][] where = { {"fil_filial","like",fil_filial} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          fil_razsoc = (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"";
        } else {
          fil_razsoc = "";
        }
      }
    } catch (Exception e) {
      fil_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return fil_razsoc;
  }

  public String[][] getFil_razsoc_Ajax(ConsultaNotaFiscalActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          list[0] = new String[]{"fil_razsoc", (db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":""};
        } else {
          list[0] = new String[]{"fil_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fil_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * FIL_RAZSOC: Method to set the field value.
    */
  public void setFil_razsoc(String PARAM) {
    fil_razsoc = PARAM;
  }
  /**
    * CODIGO_REGIONAL: Method to get the field value.
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Method to set the field value.
    */
  public void setCodigo_regional(String PARAM) {
    codigo_regional = PARAM;
  }
  /**
    * NOME_REGIONAL: Method to get the field value.
    */
  public String getNome_regional() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_regional != null && codigo_regional.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        String[][] select = { {"nome_regional",null} };
        Object[][] where = { {"codigo_regional","=",com.egen.util.text.FormatNumber.toInt(codigo_regional)}, };
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
      }
    }
    return nome_regional;
  }

  public String[][] getNome_regional_Ajax(ConsultaNotaFiscalActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_regional() != null && PARAM.getCodigo_regional().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Regionais_vendas db_object = new Regionais_vendas();
        Object[][] where = { {"codigo_regional","like",PARAM.getCodigo_regional()}, };
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
      }
    }
    return list;
  }
  /**
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String PARAM) {
    nome_regional = PARAM;
  }
  /**
    * EST_UNIFED: Method to get the field value.
    */
  public String getEst_unifed() {
    return est_unifed;
  }
  /**
    * EST_UNIFED: Method to set the field value.
    */
  public void setEst_unifed(String PARAM) {
    est_unifed = PARAM;
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String PARAM) {
    rep_cdgo = PARAM;
  }
  /**
    * REP_RZAO: Method to get the field value.
    */
  public String getRep_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (rep_cdgo != null && rep_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        String[][] select = { {"rep_rzao",null} };
        Object[][] where = { {"rep_cdgo","like",rep_cdgo}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          rep_rzao = (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":"";
        } else {
          rep_rzao = "";
        }
      }
    } catch (Exception e) {
      rep_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return rep_rzao;
  }

  public String[][] getRep_rzao_Ajax(ConsultaNotaFiscalActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getRep_cdgo() != null && PARAM.getRep_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Rep db_object = new Rep();
        Object[][] where = { {"rep_cdgo","like",PARAM.getRep_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Rep) results.elementAt(0);
          list[0] = new String[]{"rep_rzao", (db_object.getRep_rzao() != null) ? db_object.getRep_rzao() + "":""};
        } else {
          list[0] = new String[]{"rep_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"rep_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String PARAM) {
    rep_rzao = PARAM;
  }
  /**
    * CLI_CDGO: Method to get the field value.
    */
  public String getCli_cdgo() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = {{"cli_rzao",null}};
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        } else {
          cli_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return cli_cdgo;
  }

  public String[][] getCli_cdgo_Ajax(ConsultaNotaFiscalActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=",PARAM.getCli_cdgo()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * CLI_CDGO: Method to set the field value.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
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
    * GRE_GRUPO: Method to get the field value.
    */
  public String getGre_grupo() {
    return gre_grupo;
  }
  /**
    * GRE_GRUPO: Method to set the field value.
    */
  public void setGre_grupo(String PARAM) {
    gre_grupo = PARAM;
  }
  /**
    * GRE_DESCRICAO: Method to get the field value.
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

  public String[][] getGre_descricao_Ajax(ConsultaNotaFiscalActionForm PARAM) {
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
    * GRE_DESCRICAO: Method to set the field value.
    */
  public void setGre_descricao(String PARAM) {
    gre_descricao = PARAM;
  }
  /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * DESCRICAO_MARCA: Method to get the field value.
    */
  public String getDescricao_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          descricao_marca = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
        } else {
          descricao_marca = "";
        }
      }
    } catch (Exception e) {
      descricao_marca = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao_marca;
  }

  public String[][] getDescricao_marca_Ajax(ConsultaNotaFiscalActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"descricao_marca", (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":""};
        } else {
          list[0] = new String[]{"descricao_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao_marca", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String PARAM) {
    descricao_marca = PARAM;
  }
  /**
    * TRA_CDGO: Method to get the field value.
    */
  public String getTra_cdgo() {
    return tra_cdgo;
  }
  /**
    * TRA_CDGO: Method to set the field value.
    */
  public void setTra_cdgo(String PARAM) {
    tra_cdgo = PARAM;
  }
  /**
    * DESC_TRA: Method to get the field value.
    */
  public String getDesc_tra() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tra_cdgo != null && tra_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        String[][] select = { {"tra_rzao",null} };
        Object[][] where = { {"tra_cdgo","=",com.egen.util.text.FormatNumber.toInt(tra_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          desc_tra = ((db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":"");
        } else {
          desc_tra = "";
        }
      }
    } catch (Exception e) {
      desc_tra = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return desc_tra;
  }

  public String[][] getDesc_tra_Ajax(ConsultaNotaFiscalActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getTra_cdgo() != null && PARAM.getTra_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        Object[][] where = { {"tra_cdgo","like",PARAM.getTra_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          list[0] = new String[]{"desc_tra", ((db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":"")};
        } else {
          list[0] = new String[]{"desc_tra", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"desc_tra", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESC_TRA: Method to set the field value.
    */
  public void setDesc_tra(String PARAM) {
    desc_tra = PARAM;
  }
  /**
    * SIGLA_TRANSPORTADORA: Method to get the field value.
    */
  public String getSigla_transportadora() {
    return sigla_transportadora;
  }
  /**
    * SIGLA_TRANSPORTADORA: Method to set the field value.
    */
  public void setSigla_transportadora(String PARAM) {
    sigla_transportadora = PARAM;
  }
  /**
    * NFS_CONS: Method to get the field value.
    */
  public String getNfs_cons() {
    return nfs_cons;
  }
  /**
    * NFS_CONS: Method to set the field value.
    */
  public void setNfs_cons(String PARAM) {
    nfs_cons = PARAM;
  }
  /**
    * NFS_CONS_DESC: Method to get the field value.
    */
  public String getNfs_cons_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (nfs_cons != null && nfs_cons.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        String[][] select = { {"tra_rzao",null} };
        Object[][] where = { {"tra_cdgo","=",com.egen.util.text.FormatNumber.toInt(nfs_cons)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          nfs_cons_desc = ((db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":"");
        } else {
          nfs_cons_desc = "";
        }
      }
    } catch (Exception e) {
      nfs_cons_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return nfs_cons_desc;
  }

  public String[][] getNfs_cons_desc_Ajax(ConsultaNotaFiscalActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getNfs_cons() != null && PARAM.getNfs_cons().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        Object[][] where = { {"tra_cdgo","like",PARAM.getNfs_cons()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          list[0] = new String[]{"nfs_cons_desc", ((db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":"")};
        } else {
          list[0] = new String[]{"nfs_cons_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"nfs_cons_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * NFS_CONS_DESC: Method to set the field value.
    */
  public void setNfs_cons_desc(String PARAM) {
    nfs_cons_desc = PARAM;
  }
  /**
    * ANO_FATURA: Method to get the field value.
    */
  public String getAno_fatura() {
    return ano_fatura;
  }
  /**
    * ANO_FATURA: Method to set the field value.
    */
  public void setAno_fatura(String PARAM) {
    ano_fatura = PARAM;
  }
  /**
    * NUMERO_FATURA: Method to get the field value.
    */
  public String getNumero_fatura() {
    return numero_fatura;
  }
  /**
    * NUMERO_FATURA: Method to set the field value.
    */
  public void setNumero_fatura(String PARAM) {
    numero_fatura = PARAM;
  }
  /**
    * DT_INICIAL: Method to get the field value.
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Method to set the field value.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Method to get the field value.
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Method to set the field value.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * ESPECIE: Method to get the field value.
    */
  public String getEspecie() {
    return especie;
  }
  /**
    * ESPECIE: Method to set the field value.
    */
  public void setEspecie(String PARAM) {
    especie = PARAM;
  }
  /**
    * REG: Method to get the field value.
    */
  public String getReg() {
    return reg;
  }
  /**
    * REG: Method to set the field value.
    */
  public void setReg(String PARAM) {
    reg = PARAM;
  }
  /**
    * REP: Method to get the field value.
    */
  public String getRep() {
    return rep;
  }
  /**
    * REP: Method to set the field value.
    */
  public void setRep(String PARAM) {
    rep = PARAM;
  }
  /**
    * FILIAL: Method to get the field value.
    */
  public String getFilial() {
    return filial;
  }
  /**
    * FILIAL: Method to set the field value.
    */
  public void setFilial(String PARAM) {
    filial = PARAM;
  }
  /**
    * NRO_ROMANEIO: Method to get the field value.
    */
  public String getNro_romaneio() {
    return nro_romaneio;
  }
  /**
    * NRO_ROMANEIO: Method to set the field value.
    */
  public void setNro_romaneio(String PARAM) {
    nro_romaneio = PARAM;
  }
  /**
    * CB_NOTAS_FRETES: Method to get the field value.
    */
  public String getCb_notas_fretes() {
    return cb_notas_fretes;
  }
  /**
    * CB_NOTAS_FRETES: Method to set the field value.
    */
  public void setCb_notas_fretes(String PARAM) {
    cb_notas_fretes = PARAM;
  }
  /**
    * CB_NOTAS_REMESSA: Method to get the field value.
    */
  public String getCb_notas_remessa() {
    return cb_notas_remessa;
  }
  /**
    * CB_NOTAS_REMESSA: Method to set the field value.
    */
  public void setCb_notas_remessa(String PARAM) {
    cb_notas_remessa = PARAM;
  }
  /**
    * CB_AMOSTRA: Method to get the field value.
    */
  public String getCb_amostra() {
    return cb_amostra;
  }
  /**
    * CB_AMOSTRA: Method to set the field value.
    */
  public void setCb_amostra(String PARAM) {
    cb_amostra = PARAM;
  }
  /**
    * CB_BRINDES: Method to get the field value.
    */
  public String getCb_brindes() {
    return cb_brindes;
  }
  /**
    * CB_BRINDES: Method to set the field value.
    */
  public void setCb_brindes(String PARAM) {
    cb_brindes = PARAM;
  }
  /**
    * CB_SEM_OCORRENCIA_ENTREGA: Method to get the field value.
    */
  public String getCb_sem_ocorrencia_entrega() {
    return cb_sem_ocorrencia_entrega;
  }
  /**
    * CB_SEM_OCORRENCIA_ENTREGA: Method to set the field value.
    */
  public void setCb_sem_ocorrencia_entrega(String PARAM) {
    cb_sem_ocorrencia_entrega = PARAM;
  }
  /**
    * CB_NOTAS_EM_DEVOLUCAO: Method to get the field value.
    */
  public String getCb_notas_em_devolucao() {
    return cb_notas_em_devolucao;
  }
  /**
    * CB_NOTAS_EM_DEVOLUCAO: Method to set the field value.
    */
  public void setCb_notas_em_devolucao(String PARAM) {
    cb_notas_em_devolucao = PARAM;
  }
  /**
    * ROMANEIO: Method to get the field value.
    */
  public String getRomaneio() {
    return romaneio;
  }
  /**
    * ROMANEIO: Method to set the field value.
    */
  public void setRomaneio(String PARAM) {
    romaneio = PARAM;
  }
  Vector romaneioList = new Vector(10, 1);
  public java.util.Vector getRomaneioList() {
    if (romaneioList == null || romaneioList.size() == 0) {
      romaneioList.addElement("T");
      romaneioLabelList.addElement("Todos");
      romaneioList.addElement("S");
      romaneioLabelList.addElement("Sim");
      romaneioList.addElement("N");
      romaneioLabelList.addElement("Não");
    }
    java.util.Vector list = romaneioList;
    return list;
  }
  java.util.Vector romaneioLabelList = new Vector(10, 1);
  public java.util.Vector getRomaneioLabelList() {
    java.util.Vector list = romaneioLabelList;
    return list;
  }
  /**
    * DESCONSIDERA_NOTAS_ENTRADA: Method to get the field value.
    */
  public String getDesconsidera_notas_entrada() {
    return desconsidera_notas_entrada;
  }
  /**
    * DESCONSIDERA_NOTAS_ENTRADA: Method to set the field value.
    */
  public void setDesconsidera_notas_entrada(String PARAM) {
    desconsidera_notas_entrada = PARAM;
  }
  Vector desconsidera_notas_entradaList = new Vector(10, 1);
  public java.util.Vector getDesconsidera_notas_entradaList() {
    if (desconsidera_notas_entradaList == null || desconsidera_notas_entradaList.size() == 0) {
      desconsidera_notas_entradaList.addElement("N");
      desconsidera_notas_entradaLabelList.addElement("Não");
      desconsidera_notas_entradaList.addElement("S");
      desconsidera_notas_entradaLabelList.addElement("Sim");
    }
    java.util.Vector list = desconsidera_notas_entradaList;
    return list;
  }
  java.util.Vector desconsidera_notas_entradaLabelList = new Vector(10, 1);
  public java.util.Vector getDesconsidera_notas_entradaLabelList() {
    java.util.Vector list = desconsidera_notas_entradaLabelList;
    return list;
  }
  /**
    * GERA_EXCEL: Method to get the field value.
    */
  public String getGera_excel() {
    return gera_excel;
  }
  /**
    * GERA_EXCEL: Method to set the field value.
    */
  public void setGera_excel(String PARAM) {
    gera_excel = PARAM;
  }
  Vector gera_excelList = new Vector(10, 1);
  public java.util.Vector getGera_excelList() {
    if (gera_excelList == null || gera_excelList.size() == 0) {
      gera_excelList.addElement("N");
      gera_excelLabelList.addElement("Não");
      gera_excelList.addElement("S");
      gera_excelLabelList.addElement("Sim");
      gera_excelList.addElement("R");
      gera_excelLabelList.addElement("Resumido");
      gera_excelList.addElement("ID");
      gera_excelLabelList.addElement("Abertura ID do Produto");
      gera_excelList.addElement("NF");
      gera_excelLabelList.addElement("NF");
    }
    java.util.Vector list = gera_excelList;
    return list;
  }
  java.util.Vector gera_excelLabelList = new Vector(10, 1);
  public java.util.Vector getGera_excelLabelList() {
    java.util.Vector list = gera_excelLabelList;
    return list;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    nfs_nmro = null;
    emp_empresa = null;
    emp_razsoc = null;
    fil_filial = null;
    fil_razsoc = null;
    codigo_regional = null;
    nome_regional = null;
    est_unifed = null;
    rep_cdgo = null;
    rep_rzao = null;
    cli_cdgo = null;
    cli_rzao = null;
    esc_seqn = null;
    gre_grupo = null;
    gre_descricao = null;
    codigo_marca = null;
    descricao_marca = null;
    tra_cdgo = null;
    desc_tra = null;
    sigla_transportadora = null;
    nfs_cons = null;
    nfs_cons_desc = null;
    ano_fatura = null;
    numero_fatura = null;
    dt_inicial = null;
    dt_final = null;
    especie = null;
    reg = null;
    rep = null;
    filial = null;
    nro_romaneio = null;
    cb_notas_fretes = null;
    cb_notas_remessa = null;
    cb_amostra = null;
    cb_brindes = null;
    cb_sem_ocorrencia_entrega = null;
    cb_notas_em_devolucao = null;
    romaneio = null;
    desconsidera_notas_entrada = null;
    gera_excel = null;
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
      if (!com.egen.util.text.Validate.isNumber(nfs_nmro)) {
        errors.add("nfs_nmro", new ActionMessage("error.validate.number","Número","nfs_nmro","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(cli_cdgo)) {
        errors.add("cli_cdgo", new ActionMessage("error.validate.number","Cliente","cli_cdgo","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(esc_seqn)) {
        errors.add("esc_seqn", new ActionMessage("error.validate.number","Seqüencial","esc_seqn","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_inicial)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.date","Data Inicial","dt_inicial","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dt_final)) {
        errors.add("dt_final", new ActionMessage("error.validate.date","Data Final","dt_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
