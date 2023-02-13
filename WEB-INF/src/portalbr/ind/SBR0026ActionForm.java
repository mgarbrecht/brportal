package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/06/2010 11:11:56
 * Last Modify Date 22/06/2015 13:11:57
 */

public class Sbr0026ActionForm extends org.apache.struts.action.ActionForm
{
  public String lin_cdgo;
  public String lin_desc;
  public String codigo_marca;
  public String desc_marca;
  public String ped_tipo;
  public String abre_automaticamente;
  public String mensagem;
  private boolean valida = false;
  public Sbr0026ActionForm() {
  }
  /**
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        String[][] select = { {"lin_nome",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          lin_desc = ((db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"");
        } else {
          lin_desc = "";
        }
      }
    } catch (Exception e) {
      lin_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lin_cdgo;
  }

  public String[][] getLin_cdgo_Ajax(Sbr0026ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          list[0] = new String[]{"lin_desc", ((db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"")};
        } else {
          list[0] = new String[]{"lin_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * LIN_DESC: Method to get the field value.
    */
  public String getLin_desc() {
    return lin_desc;
  }
  /**
    * LIN_DESC: Method to set the field value.
    */
  public void setLin_desc(String PARAM) {
    lin_desc = PARAM;
  }
  /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_marca != null && codigo_marca.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(codigo_marca)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          desc_marca = ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"");
        } else {
          desc_marca = "";
        }
      }
    } catch (Exception e) {
      desc_marca = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return codigo_marca;
  }

  public String[][] getCodigo_marca_Ajax(Sbr0026ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_marca() != null && PARAM.getCodigo_marca().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getCodigo_marca()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"desc_marca", ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"")};
        } else {
          list[0] = new String[]{"desc_marca", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"desc_marca", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String PARAM) {
    codigo_marca = PARAM;
  }
  /**
    * DESC_MARCA: Method to get the field value.
    */
  public String getDesc_marca() {
    return desc_marca;
  }
  /**
    * DESC_MARCA: Method to set the field value.
    */
  public void setDesc_marca(String PARAM) {
    desc_marca = PARAM;
  }
  /**
    * PED_TIPO: Method to get the field value.
    */
  public String getPed_tipo() {
    return ped_tipo;
  }
  /**
    * PED_TIPO: Method to set the field value.
    */
  public void setPed_tipo(String PARAM) {
    ped_tipo = PARAM;
  }
  Vector ped_tipoList = new Vector(10, 1);
  public java.util.Vector getPed_tipoList() {
    if (ped_tipoList == null || ped_tipoList.size() == 0) {
      ped_tipoList.addElement("");
      ped_tipoLabelList.addElement("Ambos");
      ped_tipoList.addElement("PE");
      ped_tipoLabelList.addElement("Pronta Entrega");
      ped_tipoList.addElement("PP");
      ped_tipoLabelList.addElement("Produto Pronto");
      ped_tipoList.addElement("PG");
      ped_tipoLabelList.addElement("Programado");
    }
    java.util.Vector list = ped_tipoList;
    return list;
  }
  java.util.Vector ped_tipoLabelList = new Vector(10, 1);
  public java.util.Vector getPed_tipoLabelList() {
    java.util.Vector list = ped_tipoLabelList;
    return list;
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
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    lin_cdgo = null;
    lin_desc = null;
    codigo_marca = null;
    desc_marca = null;
    ped_tipo = null;
    abre_automaticamente = null;
    mensagem = null;
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
