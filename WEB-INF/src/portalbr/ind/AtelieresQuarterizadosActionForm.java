package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 13/01/2015 08:21:46
 * Last Modify Date 23/01/2015 11:40:09
 */

public class AtelieresQuarterizadosActionForm extends org.apache.struts.action.ActionForm
{
  public String fo_codigo;
  public String fo_razsoc;
  public String fo_codigo_quarterizado;
  public String fen_seq_quarterizado;
  public String fen_cgc_quarterizado;
  public String f_razsoc;
  public String est_unifed_quarterizado;
  public String fen_cidade_quarterizado;
  private boolean valida = false;
  public AtelieresQuarterizadosActionForm() {
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
    * FO_RAZSOC: Método Gets para este campo
    */
  public String getFo_razsoc() {
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
          fo_razsoc = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fo_razsoc = "";
        }
      }
    } catch (Exception e) {
      fo_razsoc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fo_razsoc;
  }

  public String[][] getFo_razsoc_Ajax(AtelieresQuarterizadosActionForm PARAM) {
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
          list[0] = new String[]{"fo_razsoc", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fo_razsoc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fo_razsoc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FO_RAZSOC: Método Sets pára este campo.
    */
  public void setFo_razsoc(String PARAM) {
    fo_razsoc = PARAM;
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
    * F_RAZSOC: Método Gets para este campo
    */
  public String getF_razsoc() {
    return f_razsoc;
  }
  /**
    * F_RAZSOC: Método Sets pára este campo.
    */
  public void setF_razsoc(String PARAM) {
    f_razsoc = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fo_codigo = null;
    fo_razsoc = null;
    fo_codigo_quarterizado = null;
    fen_seq_quarterizado = null;
    fen_cgc_quarterizado = null;
    f_razsoc = null;
    est_unifed_quarterizado = null;
    fen_cidade_quarterizado = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
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
