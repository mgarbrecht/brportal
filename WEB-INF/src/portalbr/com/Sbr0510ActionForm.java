package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/10/2017 17:25:07
 * Last Modify Date 28/01/2019 13:49:07
 */

public class Sbr0510ActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_nmro;
  public String lin_cdgo;
  public String ref_cdgo;
  public String cab_cdgo;
  public String abrir_numeracao;
  private boolean valida = false;
  public Sbr0510ActionForm() {
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
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * REF_CDGO: Method to get the field value.
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Method to set the field value.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * CAB_CDGO: Method to get the field value.
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Method to set the field value.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  /**
    * ABRIR_NUMERACAO: Method to get the field value.
    */
  public String getAbrir_numeracao() {
    return abrir_numeracao;
  }
  /**
    * ABRIR_NUMERACAO: Method to set the field value.
    */
  public void setAbrir_numeracao(String PARAM) {
    abrir_numeracao = PARAM;
  }
  Vector abrir_numeracaoList = new Vector(10, 1);
  public java.util.Vector getAbrir_numeracaoList() {
    if (abrir_numeracaoList == null || abrir_numeracaoList.size() == 0) {
      abrir_numeracaoList.addElement("N");
      abrir_numeracaoLabelList.addElement("Não");
      abrir_numeracaoList.addElement("S");
      abrir_numeracaoLabelList.addElement("Sim");
    }
    java.util.Vector list = abrir_numeracaoList;
    return list;
  }
  java.util.Vector abrir_numeracaoLabelList = new Vector(10, 1);
  public java.util.Vector getAbrir_numeracaoLabelList() {
    java.util.Vector list = abrir_numeracaoLabelList;
    return list;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_nmro = null;
    lin_cdgo = null;
    ref_cdgo = null;
    cab_cdgo = null;
    abrir_numeracao = null;
  }
  /**
    * Validate fields and return errors.
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
