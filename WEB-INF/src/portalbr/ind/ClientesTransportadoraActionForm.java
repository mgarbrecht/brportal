package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 22/08/2014 10:26:00
 * Last Modify Date 03/10/2018 13:01:19
 */

public class ClientesTransportadoraActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo_transportadora;
  public String razao_transportadora;
  public String codigo_cliente;
  public String razao_social;
  public String consignatarios;
  private boolean valida = false;
  public ClientesTransportadoraActionForm() {
  }
  /**
    * CODIGO_TRANSPORTADORA: Método Gets para este campo
    */
  public String getCodigo_transportadora() {
    return codigo_transportadora;
  }
  /**
    * CODIGO_TRANSPORTADORA: Método Sets pára este campo.
    */
  public void setCodigo_transportadora(String PARAM) {
    codigo_transportadora = PARAM;
  }
  /**
    * RAZAO_TRANSPORTADORA: Método Gets para este campo
    */
  public String getRazao_transportadora() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_transportadora != null && codigo_transportadora.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        String[][] select = { {"tra_rzao",null} };
        Object[][] where = { {"tra_cdgo","=",com.egen.util.text.FormatNumber.toInt(codigo_transportadora)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          razao_transportadora = ((db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":"");
        } else {
          razao_transportadora = "";
        }
      }
    } catch (Exception e) {
      razao_transportadora = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return razao_transportadora;
  }

  public String[][] getRazao_transportadora_Ajax(ClientesTransportadoraActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_transportadora() != null && PARAM.getCodigo_transportadora().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tra db_object = new Tra();
        Object[][] where = { {"tra_cdgo","like",PARAM.getCodigo_transportadora()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tra) results.elementAt(0);
          list[0] = new String[]{"razao_transportadora", ((db_object.getTra_rzao() != null) ? db_object.getTra_rzao() + "":"")};
        } else {
          list[0] = new String[]{"razao_transportadora", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"razao_transportadora", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * RAZAO_TRANSPORTADORA: Método Sets pára este campo.
    */
  public void setRazao_transportadora(String PARAM) {
    razao_transportadora = PARAM;
  }
  /**
    * CODIGO_CLIENTE: Método Gets para este campo
    */
  public String getCodigo_cliente() {
    return codigo_cliente;
  }
  /**
    * CODIGO_CLIENTE: Método Sets pára este campo.
    */
  public void setCodigo_cliente(String PARAM) {
    codigo_cliente = PARAM;
  }
  /**
    * RAZAO_SOCIAL: Método Gets para este campo
    */
  public String getRazao_social() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_cliente != null && codigo_cliente.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = { {"cli_rzao",null} };
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(codigo_cliente)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          razao_social = ((db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"");
        } else {
          razao_social = "";
        }
      }
    } catch (Exception e) {
      razao_social = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return razao_social;
  }

  public String[][] getRazao_social_Ajax(ClientesTransportadoraActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_cliente() != null && PARAM.getCodigo_cliente().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=",PARAM.getCodigo_cliente()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"razao_social", ((db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"")};
        } else {
          list[0] = new String[]{"razao_social", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"razao_social", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * RAZAO_SOCIAL: Método Sets pára este campo.
    */
  public void setRazao_social(String PARAM) {
    razao_social = PARAM;
  }
  /**
    * CONSIGNATARIOS: Método Gets para este campo
    */
  public String getConsignatarios() {
    return consignatarios;
  }
  /**
    * CONSIGNATARIOS: Método Sets pára este campo.
    */
  public void setConsignatarios(String PARAM) {
    consignatarios = PARAM;
  }
  Vector consignatariosList = new Vector(10, 1);
  public java.util.Vector getConsignatariosList() {
    if (consignatariosList == null || consignatariosList.size() == 0) {
      consignatariosList.addElement("");
      consignatariosLabelList.addElement("Todos");
      consignatariosList.addElement("S");
      consignatariosLabelList.addElement("Sim");
      consignatariosList.addElement("N");
      consignatariosLabelList.addElement("Não");
    }
    java.util.Vector list = consignatariosList;
    return list;
  }
  java.util.Vector consignatariosLabelList = new Vector(10, 1);
  public java.util.Vector getConsignatariosLabelList() {
    java.util.Vector list = consignatariosLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_transportadora = null;
    razao_transportadora = null;
    codigo_cliente = null;
    razao_social = null;
    consignatarios = null;
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
