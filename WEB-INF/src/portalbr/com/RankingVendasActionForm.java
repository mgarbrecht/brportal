package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 25/01/2007 15:12:11
 * Last Modify Date 22/08/2022 18:20:30
 */

public class RankingVendasActionForm extends org.apache.struts.action.ActionForm
{
  public String dt_inicio;
  public String dt_fim;
  public String codigo_marca;
  public String unn_codigo;
  public String dias_semana;
  public String tipo;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public RankingVendasActionForm() {
  }
  /**
    * DT_INICIO: Método Gets para este campo
    */
  public String getDt_inicio() {
    return dt_inicio;
  }
  /**
    * DT_INICIO: Método Sets pára este campo.
    */
  public void setDt_inicio(String PARAM) {
    dt_inicio = PARAM;
  }
  /**
    * DT_FIM: Método Gets para este campo
    */
  public String getDt_fim() {
    return dt_fim;
  }
  /**
    * DT_FIM: Método Sets pára este campo.
    */
  public void setDt_fim(String PARAM) {
    dt_fim = PARAM;
  }
  /**
    * CODIGO_MARCA: Método Gets para este campo
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Método Sets pára este campo.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  private Vector codigo_marcaList = new Vector(10, 10);
  public void setCodigo_marcaList(java.util.Vector VECTOR) {
    codigo_marcaList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaList() {
    if (codigo_marcaList == null || codigo_marcaList.size() == 0) {
      codigo_marcaList = new Vector(10, 10);
      codigo_marcaLabelList = new Vector(10, 10);
      codigo_marcaList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      codigo_marcaLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_marcas db_object = new Jw_marcas();
        String[][] select = {{"codigo_marca", null},{"descricao_marca", null}};
        Object[][] where = null;
        String[] order = {"codigo_marca"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Jw_marcas) results.elementAt(i);
          codigo_marcaList.addElement(""+db_object.getCodigo_marca());
          codigo_marcaLabelList.addElement(""+db_object.getDescricao_marca());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "RankingVendas.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return codigo_marcaList;
  }
  private java.util.Vector codigo_marcaLabelList = new Vector(10, 10);
  public void setCodigo_marcaLabelList(java.util.Vector VECTOR) {
    codigo_marcaLabelList = VECTOR;
  }
  public java.util.Vector getCodigo_marcaLabelList() {
    return codigo_marcaLabelList;
  }
  /**
    * UNN_CODIGO: Método Gets para este campo
    */
  public String getUnn_codigo() {
    return unn_codigo;
  }
  /**
    * UNN_CODIGO: Método Sets pára este campo.
    */
  public void setUnn_codigo(String PARAM) {
    unn_codigo = PARAM;
  }
  Vector unn_codigoList = new Vector(10, 1);
  public java.util.Vector getUnn_codigoList() {
    if (unn_codigoList == null || unn_codigoList.size() == 0) {
      unn_codigoList.addElement("");
      unn_codigoLabelList.addElement("TODOS");
      unn_codigoList.addElement("01");
      unn_codigoLabelList.addElement("MANUFATURADOS");
      unn_codigoList.addElement("02");
      unn_codigoLabelList.addElement("ASSANDALIADOS");
      unn_codigoList.addElement("03");
      unn_codigoLabelList.addElement("INJECAO DIRETA");
    }
    java.util.Vector list = unn_codigoList;
    return list;
  }
  java.util.Vector unn_codigoLabelList = new Vector(10, 1);
  public java.util.Vector getUnn_codigoLabelList() {
    java.util.Vector list = unn_codigoLabelList;
    return list;
  }
  /**
    * DIAS_SEMANA: Método Gets para este campo
    */
  public String getDias_semana() {
    return dias_semana;
  }
  /**
    * DIAS_SEMANA: Método Sets pára este campo.
    */
  public void setDias_semana(String PARAM) {
    dias_semana = PARAM;
  }
  Vector dias_semanaList = new Vector(10, 1);
  public java.util.Vector getDias_semanaList() {
    if (dias_semanaList == null || dias_semanaList.size() == 0) {
      dias_semanaList.addElement("1");
      dias_semanaLabelList.addElement("1");
      dias_semanaList.addElement("2");
      dias_semanaLabelList.addElement("2");
      dias_semanaList.addElement("3");
      dias_semanaLabelList.addElement("3");
      dias_semanaList.addElement("4");
      dias_semanaLabelList.addElement("4");
      dias_semanaList.addElement("5");
      dias_semanaLabelList.addElement("5");
      dias_semanaList.addElement("6");
      dias_semanaLabelList.addElement("6");
      dias_semanaList.addElement("7");
      dias_semanaLabelList.addElement("7");
    }
    java.util.Vector list = dias_semanaList;
    return list;
  }
  java.util.Vector dias_semanaLabelList = new Vector(10, 1);
  public java.util.Vector getDias_semanaLabelList() {
    java.util.Vector list = dias_semanaLabelList;
    return list;
  }
  /**
    * TIPO: Método Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Método Sets pára este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("S");
      tipoLabelList.addElement("Semanal");
      tipoList.addElement("D");
      tipoLabelList.addElement("Diário");
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
    * ABRE_AUTOMATICAMENTE: Método Gets para este campo
    */
  public String getAbre_automaticamente() {
    return abre_automaticamente;
  }
  /**
    * ABRE_AUTOMATICAMENTE: Método Sets pára este campo.
    */
  public void setAbre_automaticamente(String PARAM) {
    abre_automaticamente = PARAM;
  }
  /**
    * MENSAGEM: Método Gets para este campo
    */
  public String getMensagem() {
    return mensagem;
  }
  /**
    * MENSAGEM: Método Sets pára este campo.
    */
  public void setMensagem(String PARAM) {
    mensagem = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    dt_inicio = null;
    dt_fim = null;
    codigo_marca = null;
    unn_codigo = null;
    dias_semana = null;
    tipo = null;
    abre_automaticamente = null;
    mensagem = null;
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
