package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 20/12/2010 07:45:08
 * Last Modify Date 20/12/2010 08:07:47
 */

public class FiltroPadraoActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_id;
  public String usua_nome;
  public String usua_usuario;
  public String usua_senha;
  public String usua_super;
  public String usua_enne_id;
  public String usua_dt_senha;
  public String usua_acessos;
  public String usua_dt_ultimo_acesso;
  public String situacao;
  public String dias_consulta_retroativa;
  public String usua_expira_senha;
  public String controla_usua_id;
  public String pos;
  private boolean valida = false;
  public FiltroPadraoActionForm() {
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
    return usua_nome;
  }
  /**
    * USUA_NOME: Método Sets pára este campo.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * USUA_USUARIO: Método Gets para este campo
    */
  public String getUsua_usuario() {
    return usua_usuario;
  }
  /**
    * USUA_USUARIO: Método Sets pára este campo.
    */
  public void setUsua_usuario(String PARAM) {
    usua_usuario = PARAM;
  }
  /**
    * USUA_SENHA: Método Gets para este campo
    */
  public String getUsua_senha() {
    return usua_senha;
  }
  /**
    * USUA_SENHA: Método Sets pára este campo.
    */
  public void setUsua_senha(String PARAM) {
    usua_senha = PARAM;
  }
  /**
    * USUA_SUPER: Método Gets para este campo
    */
  public String getUsua_super() {
    return usua_super;
  }
  /**
    * USUA_SUPER: Método Sets pára este campo.
    */
  public void setUsua_super(String PARAM) {
    usua_super = PARAM;
  }
  /**
    * USUA_ENNE_ID: Método Gets para este campo
    */
  public String getUsua_enne_id() {
    return usua_enne_id;
  }
  /**
    * USUA_ENNE_ID: Método Sets pára este campo.
    */
  public void setUsua_enne_id(String PARAM) {
    usua_enne_id = PARAM;
  }
  /**
    * USUA_DT_SENHA: Método Gets para este campo
    */
  public String getUsua_dt_senha() {
    return usua_dt_senha;
  }
  /**
    * USUA_DT_SENHA: Método Sets pára este campo.
    */
  public void setUsua_dt_senha(String PARAM) {
    usua_dt_senha = PARAM;
  }
  /**
    * USUA_ACESSOS: Método Gets para este campo
    */
  public String getUsua_acessos() {
    return usua_acessos;
  }
  /**
    * USUA_ACESSOS: Método Sets pára este campo.
    */
  public void setUsua_acessos(String PARAM) {
    usua_acessos = PARAM;
  }
  /**
    * USUA_DT_ULTIMO_ACESSO: Método Gets para este campo
    */
  public String getUsua_dt_ultimo_acesso() {
    return usua_dt_ultimo_acesso;
  }
  /**
    * USUA_DT_ULTIMO_ACESSO: Método Sets pára este campo.
    */
  public void setUsua_dt_ultimo_acesso(String PARAM) {
    usua_dt_ultimo_acesso = PARAM;
  }
  /**
    * SITUACAO: Método Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: Método Sets pára este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  /**
    * DIAS_CONSULTA_RETROATIVA: Método Gets para este campo
    */
  public String getDias_consulta_retroativa() {
    return dias_consulta_retroativa;
  }
  /**
    * DIAS_CONSULTA_RETROATIVA: Método Sets pára este campo.
    */
  public void setDias_consulta_retroativa(String PARAM) {
    dias_consulta_retroativa = PARAM;
  }
  /**
    * USUA_EXPIRA_SENHA: Método Gets para este campo
    */
  public String getUsua_expira_senha() {
    return usua_expira_senha;
  }
  /**
    * USUA_EXPIRA_SENHA: Método Sets pára este campo.
    */
  public void setUsua_expira_senha(String PARAM) {
    usua_expira_senha = PARAM;
  }
  /**
    * CONTROLA_USUA_ID: Método Gets para este campo
    */
  public String getControla_usua_id() {
    return controla_usua_id;
  }
  /**
    * CONTROLA_USUA_ID: Método Sets pára este campo.
    */
  public void setControla_usua_id(String PARAM) {
    controla_usua_id = PARAM;
  }
  /**
    * POS: Método Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Método Sets pára este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_id = null;
    usua_nome = null;
    usua_usuario = null;
    usua_senha = null;
    usua_super = null;
    usua_enne_id = null;
    usua_dt_senha = null;
    usua_acessos = null;
    usua_dt_ultimo_acesso = null;
    situacao = null;
    dias_consulta_retroativa = null;
    usua_expira_senha = null;
    controla_usua_id = null;
    pos = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(usua_id)) {
        errors.add("usua_id", new ActionMessage("error.validate.notnull","usua_id","usua_id","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_nome)) {
        errors.add("usua_nome", new ActionMessage("error.validate.notnull","Nome","usua_nome","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_usuario)) {
        errors.add("usua_usuario", new ActionMessage("error.validate.notnull","Usuário","usua_usuario","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_senha)) {
        errors.add("usua_senha", new ActionMessage("error.validate.notnull","Senha","usua_senha","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_super)) {
        errors.add("usua_super", new ActionMessage("error.validate.notnull","Super","usua_super","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_dt_senha)) {
        errors.add("usua_dt_senha", new ActionMessage("error.validate.notnull","usua_dt_senha","usua_dt_senha","0"));
      }
      if (!com.egen.util.text.Validate.isDate(usua_dt_senha)) {
        errors.add("usua_dt_senha", new ActionMessage("error.validate.date","usua_dt_senha","usua_dt_senha","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_acessos)) {
        errors.add("usua_acessos", new ActionMessage("error.validate.notnull","usua_acessos","usua_acessos","0"));
      }
      if (!com.egen.util.text.Validate.isDate(usua_dt_ultimo_acesso)) {
        errors.add("usua_dt_ultimo_acesso", new ActionMessage("error.validate.date","usua_dt_ultimo_acesso","usua_dt_ultimo_acesso","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_expira_senha)) {
        errors.add("usua_expira_senha", new ActionMessage("error.validate.notnull","Usua_expira_senha","usua_expira_senha","0"));
      }
      if (com.egen.util.text.Validate.isNull(controla_usua_id)) {
        errors.add("controla_usua_id", new ActionMessage("error.validate.notnull","usua_id","controla_usua_id","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
