package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/04/2006 17:02:01
 * Last Modify Date 24/07/2021 09:31:50
 */

public class CobrancaClientesRepresentantesActionForm extends org.apache.struts.action.ActionForm
{
  public String arquivo;
  public String rep;
  public String codigo_novo;
  public String abre_automaticamente;
  public String mensagem;
  public String rep_cdgo;
  private boolean valida = false;
  public CobrancaClientesRepresentantesActionForm() {
  }
  /**
    * ARQUIVO: Method to get the field value.
    */
  public String getArquivo() {
    return arquivo;
  }
  /**
    * ARQUIVO: Method to set the field value.
    */
  public void setArquivo(String PARAM) {
    arquivo = PARAM;
  }
  Vector arquivoList = new Vector(10, 1);
  public java.util.Vector getArquivoList() {
    if (arquivoList == null || arquivoList.size() == 0) {
      arquivoList.addElement("CMS0170");
      arquivoLabelList.addElement("Demonstrativo de conta corrente");
      arquivoList.addElement("CMS0210");
      arquivoLabelList.addElement("Valor de IRRF e depósito");
      arquivoList.addElement("CMS5002");
      arquivoLabelList.addElement("Adiantamento de comissão s/ faturamento");
      arquivoList.addElement("CMS5020");
      arquivoLabelList.addElement("Comissões sobre liquidação pós-fechamento");
      arquivoList.addElement("CMS5005");
      arquivoLabelList.addElement("Estorno de comissão indevida");
      arquivoList.addElement("CMS5006");
      arquivoLabelList.addElement("Estorno de adiant. de comissão s/ merc. devolv.");
      arquivoList.addElement("CMS5007");
      arquivoLabelList.addElement("Adiantamento de créd. refat. devoluções");
      arquivoList.addElement("CMS5013");
      arquivoLabelList.addElement("Estorno de adiant comissão por in ");
      arquivoList.addElement("CMS5015");
      arquivoLabelList.addElement("Adiantamento de comissão s/ faturamento vendor");
      arquivoList.addElement("CMS5016");
      arquivoLabelList.addElement("Amostras");
      arquivoList.addElement("CTR5023");
      arquivoLabelList.addElement("Pendências por representante");
      arquivoList.addElement("CMS5011");
      arquivoLabelList.addElement("Previsão Comissões s/Liquidação");
      arquivoList.addElement("EXP0276");
      arquivoLabelList.addElement("Comissão sobre liquidação");
    }
    java.util.Vector list = arquivoList;
    return list;
  }
  java.util.Vector arquivoLabelList = new Vector(10, 1);
  public java.util.Vector getArquivoLabelList() {
    java.util.Vector list = arquivoLabelList;
    return list;
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
    * CODIGO_NOVO: Method to get the field value.
    */
  public String getCodigo_novo() {
    return codigo_novo;
  }
  /**
    * CODIGO_NOVO: Method to set the field value.
    */
  public void setCodigo_novo(String PARAM) {
    codigo_novo = PARAM;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to get the field value.
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Method to set the field value.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Method to get the field value.
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Method to set the field value.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    arquivo = null;
    rep = null;
    codigo_novo = null;
    abre_automaticamente = null;
    mensagem = null;
    rep_cdgo = null;
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
