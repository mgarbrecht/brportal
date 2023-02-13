package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 21/09/2022 11:08:46
 * Last Modify Date 26/09/2022 17:58:00
 */

public class RelatorioApontamentoCaixasActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  public String rem_nro;
  public String ped_nmro;
  public String fornecedor;
  public String fornecedor_razao;
  private boolean valida = false;
  public RelatorioApontamentoCaixasActionForm() {
  }
  /**
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("T");
      tipoLabelList.addElement("Todos");
      tipoList.addElement("A");
      tipoLabelList.addElement("Apontados");
      tipoList.addElement("N");
      tipoLabelList.addElement("Não Apontados");
    }
    java.util.Vector list = tipoList;
    return list;
  }
  java.util.Vector tipoLabelList = new Vector(10, 1);
  public java.util.Vector getTipoLabelList() {
    java.util.Vector list = tipoLabelList;
    return list;
  }
  /**
    * REM_NRO: Method to get the field value.
    */
  public String getRem_nro() {
    return rem_nro;
  }
  /**
    * REM_NRO: Method to set the field value.
    */
  public void setRem_nro(String PARAM) {
    rem_nro = PARAM;
  }
  /**
    * PED_NMRO: Method to get the field value.
    */
  public String getPed_nmro() {
    return ped_nmro;
  }
  /**
    * PED_NMRO: Method to set the field value.
    */
  public void setPed_nmro(String PARAM) {
    ped_nmro = PARAM;
  }
  /**
    * FORNECEDOR: Method to get the field value.
    */
  public String getFornecedor() {
    return fornecedor;
  }
  /**
    * FORNECEDOR: Method to set the field value.
    */
  public void setFornecedor(String PARAM) {
    fornecedor = PARAM;
  }
  /**
    * FORNECEDOR_RAZAO: Method to get the field value.
    */
  public String getFornecedor_razao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fornecedor != null && fornecedor.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(fornecedor)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          fornecedor_razao = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fornecedor_razao = "";
        }
      }
    } catch (Exception e) {
      fornecedor_razao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fornecedor_razao;
  }

  public String[][] getFornecedor_razao_Ajax(RelatorioApontamentoCaixasActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFornecedor() != null && PARAM.getFornecedor().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        Object[][] where = { {"for_codigo","like",PARAM.getFornecedor()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          list[0] = new String[]{"fornecedor_razao", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fornecedor_razao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fornecedor_razao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FORNECEDOR_RAZAO: Method to set the field value.
    */
  public void setFornecedor_razao(String PARAM) {
    fornecedor_razao = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo = null;
    rem_nro = null;
    ped_nmro = null;
    fornecedor = null;
    fornecedor_razao = null;
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
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
