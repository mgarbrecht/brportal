package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/10/2012 17:10:34
 * Last Modify Date 26/10/2012 08:49:39
 */

public class ConsultaNotaFiscal_tActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String descricao;
  private boolean valida = false;
  public ConsultaNotaFiscal_tActionForm() {
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
    * DESCRICAO: Método Gets para este campo
    */
  public String getDescricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo != null && codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipo_ocorrencia db_object = new Tipo_ocorrencia();
        String[][] select = { {"DESCRICAO",null} };
        Object[][] where = { {"CODIGO","=",com.egen.util.text.FormatNumber.toInt(codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipo_ocorrencia) results.elementAt(0);
          descricao = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          descricao = "";
        }
      }
    } catch (Exception e) {
      descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return descricao;
  }

  public String[][] getDescricao_Ajax(ConsultaNotaFiscal_tActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo() != null && PARAM.getCodigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipo_ocorrencia db_object = new Tipo_ocorrencia();
        Object[][] where = { {"CODIGO","like",PARAM.getCodigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipo_ocorrencia) results.elementAt(0);
          list[0] = new String[]{"descricao", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESCRICAO: Método Sets pára este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    descricao = null;
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
