package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 29/04/2010 14:22:39
 * Last Modify Date 07/01/2015 11:26:06
 */

public class OndeEncontrarActionForm extends org.apache.struts.action.ActionForm
{
  public String marca_cdgo;
  public String desc_marca;
  public String cli_cdgo;
  public String cli_rzao;
  public String est_unifed;
  public String desc_unifed;
  private boolean valida = false;
  public OndeEncontrarActionForm() {
  }
  /**
    * MARCA_CDGO: Método Gets para este campo
    */
  public String getMarca_cdgo() {
    return marca_cdgo;
  }
  /**
    * MARCA_CDGO: Método Sets pára este campo.
    */
  public void setMarca_cdgo(String PARAM) {
    marca_cdgo = PARAM;
  }
  /**
    * DESC_MARCA: Método Gets para este campo
    */
  public String getDesc_marca() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (marca_cdgo != null && marca_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = null;
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(marca_cdgo)}, };
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
    return desc_marca;
  }

  public String[][] getDesc_marca_Ajax(OndeEncontrarActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getMarca_cdgo() != null && PARAM.getMarca_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getMarca_cdgo()}, };
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
    * DESC_MARCA: Método Sets pára este campo.
    */
  public void setDesc_marca(String PARAM) {
    desc_marca = PARAM;
  }
  /**
    * CLI_CDGO: Método Gets para este campo
    */
  public String getCli_cdgo() {
    return cli_cdgo;
  }
  /**
    * CLI_CDGO: Método Sets pára este campo.
    */
  public void setCli_cdgo(String PARAM) {
    cli_cdgo = PARAM;
  }
  /**
    * CLI_RZAO: Método Gets para este campo
    */
  public String getCli_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cli_cdgo != null && cli_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = null;
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(cli_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        } else {
          cli_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(OndeEncontrarActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCli_cdgo() != null && PARAM.getCli_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=",PARAM.getCli_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CLI_RZAO: Método Sets pára este campo.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * EST_UNIFED: Método Gets para este campo
    */
  public String getEst_unifed() {
    return est_unifed;
  }
  /**
    * EST_UNIFED: Método Sets pára este campo.
    */
  public void setEst_unifed(String PARAM) {
    est_unifed = PARAM;
  }
  /**
    * DESC_UNIFED: Método Gets para este campo
    */
  public String getDesc_unifed() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (est_unifed != null && est_unifed.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Estados db_object = new Estados();
        String[][] select = null;
        Object[][] where = { {"est_unifed","like",est_unifed}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Estados) results.elementAt(0);
          desc_unifed = ((db_object.getEst_descri() != null) ? db_object.getEst_descri() + "":"");
        } else {
          desc_unifed = "";
        }
      }
    } catch (Exception e) {
      desc_unifed = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return desc_unifed;
  }

  public String[][] getDesc_unifed_Ajax(OndeEncontrarActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEst_unifed() != null && PARAM.getEst_unifed().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Estados db_object = new Estados();
        Object[][] where = { {"upper(est_unifed)","=",PARAM.getEst_unifed().toUpperCase()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Estados) results.elementAt(0);
          list[0] = new String[]{"desc_unifed", ((db_object.getEst_descri() != null) ? db_object.getEst_descri() + "":"")};
        } else {
          list[0] = new String[]{"desc_unifed", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"desc_unifed", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DESC_UNIFED: Método Sets pára este campo.
    */
  public void setDesc_unifed(String PARAM) {
    desc_unifed = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    marca_cdgo = null;
    desc_marca = null;
    cli_cdgo = null;
    cli_rzao = null;
    est_unifed = null;
    desc_unifed = null;
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
