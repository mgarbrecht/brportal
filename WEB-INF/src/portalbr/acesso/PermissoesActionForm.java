package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 19/10/2009 10:36:24
 * Last Modify Date 15/08/2016 12:30:11
 */

public class PermissoesActionForm extends org.apache.struts.action.ActionForm
{
  public String tien_id;
  public String tien_tipo;
  public String enne_id;
  public String enne_descricao;
  public String usua_id;
  public String usua_nome;
  public String doin_id;
  public String doin_nome;
  private boolean valida = false;
  public PermissoesActionForm() {
  }
  /**
    * TIEN_ID: Método Gets para este campo
    */
  public String getTien_id() {
    return tien_id;
  }
  /**
    * TIEN_ID: Método Sets pára este campo.
    */
  public void setTien_id(String PARAM) {
    tien_id = PARAM;
  }
  /**
    * TIEN_TIPO: Método Gets para este campo
    */
  public String getTien_tipo() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tien_id != null && tien_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_entidade_negocio db_object = new Tipos_entidade_negocio();
        String[][] select = { {"tien_tipo",null} };
        Object[][] where = { {"tien_id","=",com.egen.util.text.FormatNumber.toInteger(tien_id)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipos_entidade_negocio) results.elementAt(0);
          tien_tipo = (db_object.getTien_tipo() != null) ? db_object.getTien_tipo() + "":"";
        } else {
          tien_tipo = "";
        }
      }
    } catch (Exception e) {
      tien_tipo = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return tien_tipo;
  }

  public String[][] getTien_tipo_Ajax(PermissoesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getTien_id() != null && PARAM.getTien_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_entidade_negocio db_object = new Tipos_entidade_negocio();
        Object[][] where = { {"tien_id","=",com.egen.util.text.FormatNumber.toInt(PARAM.getTien_id())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Tipos_entidade_negocio) results.elementAt(0);
          list[0] = new String[]{"tien_tipo", (db_object.getTien_tipo() != null) ? db_object.getTien_tipo() + "":""};
        } else {
          list[0] = new String[]{"tien_tipo", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"tien_tipo", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * TIEN_TIPO: Método Sets pára este campo.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * ENNE_ID: Método Gets para este campo
    */
  public String getEnne_id() {
    return enne_id;
  }
  /**
    * ENNE_ID: Método Sets pára este campo.
    */
  public void setEnne_id(String PARAM) {
    enne_id = PARAM;
  }
  /**
    * ENNE_DESCRICAO: Método Gets para este campo
    */
  public String getEnne_descricao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (enne_id != null && enne_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Entidades_negocio db_object = new Entidades_negocio();
        String[][] select = { {"enne_descricao",null} };
        Object[][] where = { {"enne_id","=",com.egen.util.text.FormatNumber.toInteger(enne_id)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Entidades_negocio) results.elementAt(0);
          enne_descricao = (db_object.getEnne_descricao() != null) ? db_object.getEnne_descricao() + "":"";
        } else {
          enne_descricao = "";
        }
      }
    } catch (Exception e) {
      enne_descricao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return enne_descricao;
  }

  public String[][] getEnne_descricao_Ajax(PermissoesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEnne_id() != null && PARAM.getEnne_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Entidades_negocio db_object = new Entidades_negocio();
        Object[][] where = { {"enne_id","=",com.egen.util.text.FormatNumber.toInteger(PARAM.getEnne_id())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Entidades_negocio) results.elementAt(0);
          list[0] = new String[]{"enne_descricao", (db_object.getEnne_descricao() != null) ? db_object.getEnne_descricao() + "":""};
        } else {
          list[0] = new String[]{"enne_descricao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"enne_descricao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * ENNE_DESCRICAO: Método Sets pára este campo.
    */
  public void setEnne_descricao(String PARAM) {
    enne_descricao = PARAM;
  }
  /**
    * USUA_ID: Método Gets para este campo
    */
  public String getUsua_id() {
    return usua_id;
  }
  /**
    * USUA_ID: Método Sets pára este campo.
    */
  public void setUsua_id(String PARAM) {
    usua_id = PARAM;
  }
  /**
    * USUA_NOME: Método Gets para este campo
    */
  public String getUsua_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (usua_id != null && usua_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        String[][] select = { {"usua_nome",null} };
        Object[][] where = { {"usua_id","=",com.egen.util.text.FormatNumber.toInteger(usua_id)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Usuarios) results.elementAt(0);
          usua_nome = (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"";
        } else {
          usua_nome = "";
        }
      }
    } catch (Exception e) {
      usua_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return usua_nome;
  }

  public String[][] getUsua_nome_Ajax(PermissoesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getUsua_id() != null && PARAM.getUsua_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        Object[][] where = { {"usua_id","like",PARAM.getUsua_id()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Usuarios) results.elementAt(0);
          list[0] = new String[]{"usua_nome", (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":""};
        } else {
          list[0] = new String[]{"usua_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"usua_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * USUA_NOME: Método Sets pára este campo.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * DOIN_ID: Método Gets para este campo
    */
  public String getDoin_id() {
    return doin_id;
  }
  /**
    * DOIN_ID: Método Sets pára este campo.
    */
  public void setDoin_id(String PARAM) {
    doin_id = PARAM;
  }
  /**
    * DOIN_NOME: Método Gets para este campo
    */
  public String getDoin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (doin_id != null && doin_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Documentos_interfaces db_object = new Documentos_interfaces();
        String[][] select = { {"doin_nome",null} };
        Object[][] where = { {"doin_id","=",com.egen.util.text.FormatNumber.toInteger(doin_id)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Documentos_interfaces) results.elementAt(0);
          doin_nome = (db_object.getDoin_nome() != null) ? db_object.getDoin_nome() + "":"";
        } else {
          doin_nome = "";
        }
      }
    } catch (Exception e) {
      doin_nome = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return doin_nome;
  }

  public String[][] getDoin_nome_Ajax(PermissoesActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getDoin_id() != null && PARAM.getDoin_id().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Documentos_interfaces db_object = new Documentos_interfaces();
        Object[][] where = { {"doin_id","like",PARAM.getDoin_id()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Documentos_interfaces) results.elementAt(0);
          list[0] = new String[]{"doin_nome", (db_object.getDoin_nome() != null) ? db_object.getDoin_nome() + "":""};
        } else {
          list[0] = new String[]{"doin_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"doin_nome", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * DOIN_NOME: Método Sets pára este campo.
    */
  public void setDoin_nome(String PARAM) {
    doin_nome = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tien_id = null;
    tien_tipo = null;
    enne_id = null;
    enne_descricao = null;
    usua_id = null;
    usua_nome = null;
    doin_id = null;
    doin_nome = null;
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
