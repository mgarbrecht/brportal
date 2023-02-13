package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/01/2015 11:04:53
 * Last Modify Date 23/01/2015 14:34:51
 */

public class AtelieresQuarterizados_mActionForm extends org.apache.struts.action.ActionForm
{
  public String fo_codigo;
  public String fo_razsoc1;
  public String fo_codigo_quarterizado;
  public String fen_seq_quarterizado;
  public String fo_razsoc;
  public String fo_fant;
  public String fen_cgc_quarterizado;
  public String fen_cep_quarterizado;
  public String fen_cidade_quarterizado;
  public String est_unifed_quarterizado;
  public String fen_rua_quarterizado;
  public String fen_nro_quarterizado;
  public String fen_compto_quarterizado;
  public String fen_bairro_quarterizado;
  public String fen_insmun_quarterizado;
  public String fen_insest_quarterizado;
  public String fen_ativo_quarterizado;
  public String fen_email_quarterizado;
  public String fen_gln_quarterizado;
  public String tipo_log_quarterizado;
  public String fen_observacao_quarterizado;
  public String dthr_inclusao;
  public String dthr_alteracao;
  public String usuario_inclusao;
  public String usuario_alteracao;
  private boolean valida = false;
  public AtelieresQuarterizados_mActionForm() {
  }
  /**
    * FO_CODIGO: Método Gets para este campo
    */
  public String getFo_codigo() {
    return fo_codigo;
  }
  /**
    * FO_CODIGO: Método Sets pára este campo.
    */
  public void setFo_codigo(String PARAM) {
    fo_codigo = PARAM;
  }
  /**
    * FO_RAZSOC1: Método Gets para este campo
    */
  public String getFo_razsoc1() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fo_codigo != null && fo_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Atelier_vw db_object = new Atelier_vw();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(fo_codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Atelier_vw) results.elementAt(0);
          fo_razsoc1 = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fo_razsoc1 = "";
        }
      }
    } catch (Exception e) {
      fo_razsoc1 = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fo_razsoc1;
  }

  public String[][] getFo_razsoc1_Ajax(AtelieresQuarterizados_mActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFo_codigo() != null && PARAM.getFo_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Atelier_vw db_object = new Atelier_vw();
        Object[][] where = { {"for_codigo","like",PARAM.getFo_codigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Atelier_vw) results.elementAt(0);
          list[0] = new String[]{"fo_razsoc1", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fo_razsoc1", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fo_razsoc1", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FO_RAZSOC1: Método Sets pára este campo.
    */
  public void setFo_razsoc1(String PARAM) {
    fo_razsoc1 = PARAM;
  }
  /**
    * FO_CODIGO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFo_codigo_quarterizado() {
    return fo_codigo_quarterizado;
  }
  /**
    * FO_CODIGO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFo_codigo_quarterizado(String PARAM) {
    fo_codigo_quarterizado = PARAM;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_seq_quarterizado() {
    return fen_seq_quarterizado;
  }
  /**
    * FEN_SEQ_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_seq_quarterizado(String PARAM) {
    fen_seq_quarterizado = PARAM;
  }
  /**
    * FO_RAZSOC: Método Gets para este campo
    */
  public String getFo_razsoc() {
    return fo_razsoc;
  }
  /**
    * FO_RAZSOC: Método Sets pára este campo.
    */
  public void setFo_razsoc(String PARAM) {
    fo_razsoc = PARAM;
  }
  /**
    * FO_FANT: Método Gets para este campo
    */
  public String getFo_fant() {
    return fo_fant;
  }
  /**
    * FO_FANT: Método Sets pára este campo.
    */
  public void setFo_fant(String PARAM) {
    fo_fant = PARAM;
  }
  /**
    * FEN_CGC_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_cgc_quarterizado() {
    return fen_cgc_quarterizado;
  }
  /**
    * FEN_CGC_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_cgc_quarterizado(String PARAM) {
    fen_cgc_quarterizado = PARAM;
  }
  /**
    * FEN_CEP_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_cep_quarterizado() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fen_cep_quarterizado != null && fen_cep_quarterizado.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_atelieres_quarterizados_cep db_object = new Jw_atelieres_quarterizados_cep();
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT SUBSTR(a.nome_log, 1, DECODE(INSTR(a.nome_log, ' - '), 0, 41, INSTR(a.nome_log, ' - ')) - 1) rua ");
        sb.append("                ,a.local_log cidade ");
        sb.append("                ,a.bairro_1_log bairro ");
        sb.append("                ,a.uf_log uf ");
        sb.append("                ,a.cep8_log cep1 ");
        sb.append("                ,a.cep_log cep2 ");
        sb.append("                ,a.tipo_log tipo ");
        sb.append("   FROM estados b ");
        sb.append("       ,cep_logradouros a ");
        sb.append("  WHERE (a.cep8_log = TO_CHAR(TO_NUMBER("+fen_cep_quarterizado + ")) OR a.cep_log = TO_NUMBER("+fen_cep_quarterizado + ")) ");
        sb.append("    AND a.uf_log = b.est_unifed ");
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_atelieres_quarterizados_cep db_object1 = new Jw_atelieres_quarterizados_cep();
        java.util.Vector results = j.select(db_object1, sb.toString(), null);
        if (results != null && results.size() > 0) {
          db_object = (Jw_atelieres_quarterizados_cep) results.elementAt(0);
          fen_rua_quarterizado = ((db_object.getRua() != null) ? db_object.getRua() + "":"");
          fen_cidade_quarterizado = ((db_object.getCidade() != null) ? db_object.getCidade() + "":"");
          fen_bairro_quarterizado = ((db_object.getBairro() != null) ? db_object.getBairro() + "":"");
          est_unifed_quarterizado = ((db_object.getUf() != null) ? db_object.getUf() + "":"");
        } else {
          fen_rua_quarterizado = "";
          fen_cidade_quarterizado = "";
          fen_bairro_quarterizado = "";
          est_unifed_quarterizado = "";
        }
      }
    } catch (Exception e) {
      fen_rua_quarterizado = "";
      fen_cidade_quarterizado = "";
      fen_bairro_quarterizado = "";
      est_unifed_quarterizado = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fen_cep_quarterizado;
  }

  public String[][] getFen_cep_quarterizado_Ajax(AtelieresQuarterizados_mActionForm PARAM) {
    String[][] list = new String[4][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFen_cep_quarterizado() != null && PARAM.getFen_cep_quarterizado().length() > 0) {
        StringBuilder sb = new StringBuilder();
        sb.append(" SELECT DISTINCT SUBSTR(a.nome_log, 1, DECODE(INSTR(a.nome_log, ' - '), 0, 41, INSTR(a.nome_log, ' - ')) - 1) rua ");
        sb.append("                ,a.local_log cidade ");
        sb.append("                ,a.bairro_1_log bairro ");
        sb.append("                ,a.uf_log uf ");
        sb.append("                ,a.cep8_log cep1 ");
        sb.append("                ,a.cep_log cep2 ");
        sb.append("                ,a.tipo_log tipo ");
        sb.append("   FROM estados b ");
        sb.append("       ,cep_logradouros a ");
        sb.append("  WHERE (a.cep8_log = TO_CHAR(TO_NUMBER("+PARAM.getFen_cep_quarterizado() + ")) OR a.cep_log = TO_NUMBER("+PARAM.getFen_cep_quarterizado() + ")) ");
        sb.append("    AND a.uf_log = b.est_unifed ");
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_atelieres_quarterizados_cep db_object = new Jw_atelieres_quarterizados_cep();
        java.util.Vector results = j.select(db_object, sb.toString(), null);
        if (results != null && results.size() > 0) {
          db_object = (Jw_atelieres_quarterizados_cep) results.elementAt(0);
          list[0] = new String[]{"fen_rua_quarterizado", ((db_object.getRua() != null) ? db_object.getRua() + "":"")};
          list[1] = new String[]{"fen_cidade_quarterizado", ((db_object.getCidade() != null) ? db_object.getCidade() + "":"")};
          list[2] = new String[]{"fen_bairro_quarterizado", ((db_object.getBairro() != null) ? db_object.getBairro() + "":"")};
          list[3] = new String[]{"est_unifed_quarterizado", ((db_object.getUf() != null) ? db_object.getUf() + "":"")};
        } else {
          list[0] = new String[]{"fen_rua_quarterizado", ""};
          list[1] = new String[]{"fen_cidade_quarterizado", ""};
          list[2] = new String[]{"fen_bairro_quarterizado", ""};
          list[3] = new String[]{"est_unifed_quarterizado", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fen_rua_quarterizado", ""};
      list[1] = new String[]{"fen_cidade_quarterizado", ""};
      list[2] = new String[]{"fen_bairro_quarterizado", ""};
      list[3] = new String[]{"est_unifed_quarterizado", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FEN_CEP_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_cep_quarterizado(String PARAM) {
    fen_cep_quarterizado = PARAM;
  }
  /**
    * FEN_CIDADE_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_cidade_quarterizado() {
    return fen_cidade_quarterizado;
  }
  /**
    * FEN_CIDADE_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_cidade_quarterizado(String PARAM) {
    fen_cidade_quarterizado = PARAM;
  }
  /**
    * EST_UNIFED_QUARTERIZADO: Método Gets para este campo
    */
  public String getEst_unifed_quarterizado() {
    return est_unifed_quarterizado;
  }
  /**
    * EST_UNIFED_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setEst_unifed_quarterizado(String PARAM) {
    est_unifed_quarterizado = PARAM;
  }
  private Vector est_unifed_quarterizadoList = new Vector(10, 10);
  public void setEst_unifed_quarterizadoList(java.util.Vector VECTOR) {
    est_unifed_quarterizadoList = VECTOR;
  }
  public java.util.Vector getEst_unifed_quarterizadoList() {
    if (est_unifed_quarterizadoList == null || est_unifed_quarterizadoList.size() == 0) {
      est_unifed_quarterizadoList = new Vector(10, 10);
      est_unifed_quarterizadoLabelList = new Vector(10, 10);
      est_unifed_quarterizadoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      est_unifed_quarterizadoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Estados db_object = new Estados();
        String[][] select = {{"est_unifed", null},{"est_descri", null}};
        Object[][] where = {{"pais_codigo", "=", "55"},{"est_exportador","=","N"}};
        String[] order = {"est_unifed"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Estados) results.elementAt(i);
          est_unifed_quarterizadoList.addElement(""+db_object.getEst_unifed());
          est_unifed_quarterizadoLabelList.addElement(db_object.getEst_unifed() + " - "+db_object.getEst_descri());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "AtelieresQuarterizados_m.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return est_unifed_quarterizadoList;
  }
  private java.util.Vector est_unifed_quarterizadoLabelList = new Vector(10, 10);
  public void setEst_unifed_quarterizadoLabelList(java.util.Vector VECTOR) {
    est_unifed_quarterizadoLabelList = VECTOR;
  }
  public java.util.Vector getEst_unifed_quarterizadoLabelList() {
    return est_unifed_quarterizadoLabelList;
  }
  /**
    * FEN_RUA_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_rua_quarterizado() {
    return fen_rua_quarterizado;
  }
  /**
    * FEN_RUA_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_rua_quarterizado(String PARAM) {
    fen_rua_quarterizado = PARAM;
  }
  /**
    * FEN_NRO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_nro_quarterizado() {
    return fen_nro_quarterizado;
  }
  /**
    * FEN_NRO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_nro_quarterizado(String PARAM) {
    fen_nro_quarterizado = PARAM;
  }
  /**
    * FEN_COMPTO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_compto_quarterizado() {
    return fen_compto_quarterizado;
  }
  /**
    * FEN_COMPTO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_compto_quarterizado(String PARAM) {
    fen_compto_quarterizado = PARAM;
  }
  /**
    * FEN_BAIRRO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_bairro_quarterizado() {
    return fen_bairro_quarterizado;
  }
  /**
    * FEN_BAIRRO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_bairro_quarterizado(String PARAM) {
    fen_bairro_quarterizado = PARAM;
  }
  /**
    * FEN_INSMUN_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_insmun_quarterizado() {
    return fen_insmun_quarterizado;
  }
  /**
    * FEN_INSMUN_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_insmun_quarterizado(String PARAM) {
    fen_insmun_quarterizado = PARAM;
  }
  /**
    * FEN_INSEST_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_insest_quarterizado() {
    return fen_insest_quarterizado;
  }
  /**
    * FEN_INSEST_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_insest_quarterizado(String PARAM) {
    fen_insest_quarterizado = PARAM;
  }
  /**
    * FEN_ATIVO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_ativo_quarterizado() {
    return fen_ativo_quarterizado;
  }
  /**
    * FEN_ATIVO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_ativo_quarterizado(String PARAM) {
    fen_ativo_quarterizado = PARAM;
  }
  /**
    * FEN_EMAIL_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_email_quarterizado() {
    return fen_email_quarterizado;
  }
  /**
    * FEN_EMAIL_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_email_quarterizado(String PARAM) {
    fen_email_quarterizado = PARAM;
  }
  /**
    * FEN_GLN_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_gln_quarterizado() {
    return fen_gln_quarterizado;
  }
  /**
    * FEN_GLN_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_gln_quarterizado(String PARAM) {
    fen_gln_quarterizado = PARAM;
  }
  /**
    * TIPO_LOG_QUARTERIZADO: Método Gets para este campo
    */
  public String getTipo_log_quarterizado() {
    return tipo_log_quarterizado;
  }
  /**
    * TIPO_LOG_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setTipo_log_quarterizado(String PARAM) {
    tipo_log_quarterizado = PARAM;
  }
  /**
    * FEN_OBSERVACAO_QUARTERIZADO: Método Gets para este campo
    */
  public String getFen_observacao_quarterizado() {
    return fen_observacao_quarterizado;
  }
  /**
    * FEN_OBSERVACAO_QUARTERIZADO: Método Sets pára este campo.
    */
  public void setFen_observacao_quarterizado(String PARAM) {
    fen_observacao_quarterizado = PARAM;
  }
  /**
    * DTHR_INCLUSAO: Método Gets para este campo
    */
  public String getDthr_inclusao() {
    return dthr_inclusao;
  }
  /**
    * DTHR_INCLUSAO: Método Sets pára este campo.
    */
  public void setDthr_inclusao(String PARAM) {
    dthr_inclusao = PARAM;
  }
  /**
    * DTHR_ALTERACAO: Método Gets para este campo
    */
  public String getDthr_alteracao() {
    return dthr_alteracao;
  }
  /**
    * DTHR_ALTERACAO: Método Sets pára este campo.
    */
  public void setDthr_alteracao(String PARAM) {
    dthr_alteracao = PARAM;
  }
  /**
    * USUARIO_INCLUSAO: Método Gets para este campo
    */
  public String getUsuario_inclusao() {
    return usuario_inclusao;
  }
  /**
    * USUARIO_INCLUSAO: Método Sets pára este campo.
    */
  public void setUsuario_inclusao(String PARAM) {
    usuario_inclusao = PARAM;
  }
  /**
    * USUARIO_ALTERACAO: Método Gets para este campo
    */
  public String getUsuario_alteracao() {
    return usuario_alteracao;
  }
  /**
    * USUARIO_ALTERACAO: Método Sets pára este campo.
    */
  public void setUsuario_alteracao(String PARAM) {
    usuario_alteracao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fo_codigo = null;
    fo_razsoc1 = null;
    fo_codigo_quarterizado = null;
    fen_seq_quarterizado = null;
    fo_razsoc = null;
    fo_fant = null;
    fen_cgc_quarterizado = null;
    fen_cep_quarterizado = null;
    fen_cidade_quarterizado = null;
    est_unifed_quarterizado = null;
    fen_rua_quarterizado = null;
    fen_nro_quarterizado = null;
    fen_compto_quarterizado = null;
    fen_bairro_quarterizado = null;
    fen_insmun_quarterizado = null;
    fen_insest_quarterizado = null;
    fen_ativo_quarterizado = null;
    fen_email_quarterizado = null;
    fen_gln_quarterizado = null;
    tipo_log_quarterizado = null;
    fen_observacao_quarterizado = null;
    dthr_inclusao = null;
    dthr_alteracao = null;
    usuario_inclusao = null;
    usuario_alteracao = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(fo_codigo)) {
        errors.add("fo_codigo", new ActionMessage("error.validate.notnull","Atelier","fo_codigo","0"));
      }
      if (com.egen.util.text.Validate.isNull(fo_codigo_quarterizado)) {
        errors.add("fo_codigo_quarterizado", new ActionMessage("error.validate.notnull","Fornecedor Quarterizado","fo_codigo_quarterizado","0"));
      }
      if (com.egen.util.text.Validate.isNull(fen_seq_quarterizado)) {
        errors.add("fen_seq_quarterizado", new ActionMessage("error.validate.notnull","Seq. Quarterizado","fen_seq_quarterizado","0"));
      }
      if (com.egen.util.text.Validate.isNull(fo_razsoc)) {
        errors.add("fo_razsoc", new ActionMessage("error.validate.notnull","Razão Social","fo_razsoc","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dthr_inclusao)) {
        errors.add("dthr_inclusao", new ActionMessage("error.validate.date","Dthr_inclusao","dthr_inclusao","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dthr_alteracao)) {
        errors.add("dthr_alteracao", new ActionMessage("error.validate.date","Dthr_alteracao","dthr_alteracao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
