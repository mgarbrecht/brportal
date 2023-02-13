package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 14/06/2007 13:40:06
 * Last Modify Date 11/02/2019 10:14:10
 */

public class BaixaArquivosTransportadorasActionForm extends org.apache.struts.action.ActionForm
{
  public String codigo;
  public String nome;
  public String caminho;
  public String data_envio;
  private boolean valida = false;
  public BaixaArquivosTransportadorasActionForm() {
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
  private Vector codigoList = new Vector(10, 10);
  public void setCodigoList(java.util.Vector VECTOR) {
    codigoList = VECTOR;
  }
  public java.util.Vector getCodigoList() {
    if (codigoList == null || codigoList.size() == 0) {
      codigoList = new Vector(10, 10);
      codigoLabelList = new Vector(10, 10);
      codigoList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      codigoLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_arquivos_edi db_object = new Jw_arquivos_edi();
        String[][] select = {{"CODIGO", null},{"NOME", null}};
        Object[][] where = null;
        String[] order = {"NOME"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_arquivos_edi) results.elementAt(i);
          codigoList.addElement(""+db_object.getCodigo());
          codigoLabelList.addElement(""+db_object.getNome());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "BaixaArquivosTransportadoras.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return codigoList;
  }
  private java.util.Vector codigoLabelList = new Vector(10, 10);
  public void setCodigoLabelList(java.util.Vector VECTOR) {
    codigoLabelList = VECTOR;
  }
  public java.util.Vector getCodigoLabelList() {
    return codigoLabelList;
  }
  /**
    * NOME: Método Gets para este campo
    */
  public String getNome() {
    return nome;
  }
  /**
    * NOME: Método Sets pára este campo.
    */
  public void setNome(String PARAM) {
    nome = PARAM;
  }
  /**
    * CAMINHO: Método Gets para este campo
    */
  public String getCaminho() {
    return caminho;
  }
  /**
    * CAMINHO: Método Sets pára este campo.
    */
  public void setCaminho(String PARAM) {
    caminho = PARAM;
  }
  /**
    * DATA_ENVIO: Método Gets para este campo
    */
  public String getData_envio() {
    return data_envio;
  }
  /**
    * DATA_ENVIO: Método Sets pára este campo.
    */
  public void setData_envio(String PARAM) {
    data_envio = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo = null;
    nome = null;
    caminho = null;
    data_envio = null;
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
