package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 16/09/2015 16:40:03
 * Last Modify Date 16/09/2015 17:00:57
 */

public class ConsultaUsuariosAlteracaoActionForm extends org.apache.struts.action.ActionForm
{
  public String usuario;
  public String nome;
  public String usuario_alteracao;
  public String usua_nome;
  public String dt_inicial;
  public String dt_final;
  private boolean valida = false;
  public ConsultaUsuariosAlteracaoActionForm() {
  }
  /**
    * USUARIO: Método Gets para este campo
    */
  public String getUsuario() {
    return usuario;
  }
  /**
    * USUARIO: Método Sets pára este campo.
    */
  public void setUsuario(String PARAM) {
    usuario = PARAM;
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
    * USUARIO_ALTERACAO: Método Gets para este campo
    */
  public String getUsuario_alteracao() {
    return usuario_alteracao;
  }
  /**
    * USUARIO_ALTERACAO: Método Sets pára este campo.
    */
  public void setUsuario_alteracao(String PARAM) {
    usuario_alteracao = PARAM;
  }
  /**
    * USUA_NOME: Método Gets para este campo
    */
  public String getUsua_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (usuario_alteracao != null && usuario_alteracao.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        String[][] select = { {"usua_nome",null} };
        Object[][] where = { {"usua_usuario","like",usuario_alteracao}, };
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

  public String[][] getUsua_nome_Ajax(ConsultaUsuariosAlteracaoActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getUsuario_alteracao() != null && PARAM.getUsuario_alteracao().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Usuarios db_object = new Usuarios();
        Object[][] where = { {"usua_usuario","like",PARAM.getUsuario_alteracao()}, };
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
    * DT_INICIAL: Método Gets para este campo
    */
  public String getDt_inicial() {
    return dt_inicial;
  }
  /**
    * DT_INICIAL: Método Sets pára este campo.
    */
  public void setDt_inicial(String PARAM) {
    dt_inicial = PARAM;
  }
  /**
    * DT_FINAL: Método Gets para este campo
    */
  public String getDt_final() {
    return dt_final;
  }
  /**
    * DT_FINAL: Método Sets pára este campo.
    */
  public void setDt_final(String PARAM) {
    dt_final = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usuario = null;
    nome = null;
    usuario_alteracao = null;
    usua_nome = null;
    dt_inicial = null;
    dt_final = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (com.egen.util.text.Validate.isNull(dt_inicial)) {
        errors.add("dt_inicial", new ActionMessage("error.validate.notnull","Dt. Alteração Inicial","dt_inicial","0"));
      }
      if (com.egen.util.text.Validate.isNull(dt_final)) {
        errors.add("dt_final", new ActionMessage("error.validate.notnull","Dt. Alteração Final","dt_final","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
