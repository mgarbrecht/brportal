package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 26/07/2018 12:31:25
 * Last Modify Date 12/09/2019 14:07:52
 */

public class EmbarqueExportacaoActionForm extends org.apache.struts.action.ActionForm
{
  public String ped_invoice;
  public String nfs_nmro;
  public String nfs_serie;
  public String fil_filial;
  public String rem_nro;
  public String ped_nmro;
  public String gerar_planilha;
  private boolean valida = false;
  public EmbarqueExportacaoActionForm() {
  }
  /**
    * PED_INVOICE: Method to get the field value.
    */
  public String getPed_invoice() {
    return ped_invoice;
  }
  /**
    * PED_INVOICE: Method to set the field value.
    */
  public void setPed_invoice(String PARAM) {
    ped_invoice = PARAM;
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
    * NFS_SERIE: Method to get the field value.
    */
  public String getNfs_serie() {
    return nfs_serie;
  }
  /**
    * NFS_SERIE: Method to set the field value.
    */
  public void setNfs_serie(String PARAM) {
    nfs_serie = PARAM;
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
    * GERAR_PLANILHA: Method to get the field value.
    */
  public String getGerar_planilha() {
    return gerar_planilha;
  }
  /**
    * GERAR_PLANILHA: Method to set the field value.
    */
  public void setGerar_planilha(String PARAM) {
    gerar_planilha = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    ped_invoice = null;
    nfs_nmro = null;
    nfs_serie = null;
    fil_filial = null;
    rem_nro = null;
    ped_nmro = null;
    gerar_planilha = null;
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
