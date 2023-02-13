package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 26/03/2010 07:14:28
 * Last Modify Date 19/01/2015 09:35:45
 */

public class ClientesNaoAtendidosActionForm extends org.apache.struts.action.ActionForm
{
  public String data_ini;
  public String data_fim;
  public String reg_cdgo;
  public String rep_cdgo;
  public String rep_situ;
  public String cli_rep_situ;
  private boolean valida = false;
  public ClientesNaoAtendidosActionForm() {
  }
  /**
    * DATA_INI: Método Gets para este campo
    */
  public String getData_ini() {
    return data_ini;
  }
  /**
    * DATA_INI: Método Sets pára este campo.
    */
  public void setData_ini(String PARAM) {
    data_ini = PARAM;
  }
  /**
    * DATA_FIM: Método Gets para este campo
    */
  public String getData_fim() {
    return data_fim;
  }
  /**
    * DATA_FIM: Método Sets pára este campo.
    */
  public void setData_fim(String PARAM) {
    data_fim = PARAM;
  }
  /**
    * REG_CDGO: Método Gets para este campo
    */
  public String getReg_cdgo() {
    return reg_cdgo;
  }
  /**
    * REG_CDGO: Método Sets pára este campo.
    */
  public void setReg_cdgo(String PARAM) {
    reg_cdgo = PARAM;
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
    * REP_SITU: Método Gets para este campo
    */
  public String getRep_situ() {
    return rep_situ;
  }
  /**
    * REP_SITU: Método Sets pára este campo.
    */
  public void setRep_situ(String PARAM) {
    rep_situ = PARAM;
  }
  Vector rep_situList = new Vector(10, 1);
  public java.util.Vector getRep_situList() {
    if (rep_situList == null || rep_situList.size() == 0) {
      rep_situList.addElement("");
      rep_situLabelList.addElement("Todos");
      rep_situList.addElement("'A'");
      rep_situLabelList.addElement("Ativos");
      rep_situList.addElement("'I'");
      rep_situLabelList.addElement("Inativos");
    }
    java.util.Vector list = rep_situList;
    return list;
  }
  java.util.Vector rep_situLabelList = new Vector(10, 1);
  public java.util.Vector getRep_situLabelList() {
    java.util.Vector list = rep_situLabelList;
    return list;
  }
  /**
    * CLI_REP_SITU: Método Gets para este campo
    */
  public String getCli_rep_situ() {
    return cli_rep_situ;
  }
  /**
    * CLI_REP_SITU: Método Sets pára este campo.
    */
  public void setCli_rep_situ(String PARAM) {
    cli_rep_situ = PARAM;
  }
  Vector cli_rep_situList = new Vector(10, 1);
  public java.util.Vector getCli_rep_situList() {
    if (cli_rep_situList == null || cli_rep_situList.size() == 0) {
      cli_rep_situList.addElement("");
      cli_rep_situLabelList.addElement("Todos");
      cli_rep_situList.addElement("'A'");
      cli_rep_situLabelList.addElement("Ativos");
      cli_rep_situList.addElement("'I'");
      cli_rep_situLabelList.addElement("Inativos");
    }
    java.util.Vector list = cli_rep_situList;
    return list;
  }
  java.util.Vector cli_rep_situLabelList = new Vector(10, 1);
  public java.util.Vector getCli_rep_situLabelList() {
    java.util.Vector list = cli_rep_situLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    data_ini = null;
    data_fim = null;
    reg_cdgo = null;
    rep_cdgo = null;
    rep_situ = null;
    cli_rep_situ = null;
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
