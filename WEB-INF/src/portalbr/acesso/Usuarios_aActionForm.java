package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/01/2006 13:29:55
 * Last Modify Date 22/09/2015 09:35:11
 */

public class Usuarios_aActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_id;
  public String usua_usuario;
  public String usua_nome;
  public String usua_email;
  public String usua_senha;
  public String confirma_senha;
  public String forca_senha_check;
  public String usua_enne_id;
  public String enne_descricao;
  public String dias_consulta_retroativa;
  public String usua_super;
  public String usua_expira_senha;
  public String pos;
  public String chamador;
  public String forca_senha;
  public String situacao;
  public String usuario_inclusao;
  public String dthr_inclusao;
  public String usuario_alteracao;
  public String dthr_alteracao;
  private boolean valida = false;
  public Usuarios_aActionForm() {
  }
  /**
    * USUA_ID: M�todo Gets para este campo
    */
  public String getUsua_id() {
    return usua_id;
  }
  /**
    * USUA_ID: M�todo Sets p�ra este campo.
    */
  public void setUsua_id(String PARAM) {
    usua_id = PARAM;
  }
  /**
    * USUA_USUARIO: M�todo Gets para este campo
    */
  public String getUsua_usuario() {
    return usua_usuario;
  }
  /**
    * USUA_USUARIO: M�todo Sets p�ra este campo.
    */
  public void setUsua_usuario(String PARAM) {
    usua_usuario = PARAM;
  }
  /**
    * USUA_NOME: M�todo Gets para este campo
    */
  public String getUsua_nome() {
    return usua_nome;
  }
  /**
    * USUA_NOME: M�todo Sets p�ra este campo.
    */
  public void setUsua_nome(String PARAM) {
    usua_nome = PARAM;
  }
  /**
    * USUA_EMAIL: M�todo Gets para este campo
    */
  public String getUsua_email() {
    return usua_email;
  }
  /**
    * USUA_EMAIL: M�todo Sets p�ra este campo.
    */
  public void setUsua_email(String PARAM) {
    usua_email = PARAM;
  }
  /**
    * USUA_SENHA: M�todo Gets para este campo
    */
  public String getUsua_senha() {
    return usua_senha;
  }
  /**
    * USUA_SENHA: M�todo Sets p�ra este campo.
    */
  public void setUsua_senha(String PARAM) {
    usua_senha = PARAM;
  }
  /**
    * CONFIRMA_SENHA: M�todo Gets para este campo
    */
  public String getConfirma_senha() {
    return confirma_senha;
  }
  /**
    * CONFIRMA_SENHA: M�todo Sets p�ra este campo.
    */
  public void setConfirma_senha(String PARAM) {
    confirma_senha = PARAM;
  }
  /**
    * FORCA_SENHA_CHECK: M�todo Gets para este campo
    */
  public String getForca_senha_check() {
    return forca_senha_check;
  }
  /**
    * FORCA_SENHA_CHECK: M�todo Sets p�ra este campo.
    */
  public void setForca_senha_check(String PARAM) {
    forca_senha_check = PARAM;
  }
  /**
    * USUA_ENNE_ID: M�todo Gets para este campo
    */
  public String getUsua_enne_id() {
    return usua_enne_id;
  }
  /**
    * USUA_ENNE_ID: M�todo Sets p�ra este campo.
    */
  public void setUsua_enne_id(String PARAM) {
    usua_enne_id = PARAM;
  }
  /**
    * ENNE_DESCRICAO: M�todo Gets para este campo
    */
  public String getEnne_descricao() {
    return enne_descricao;
  }
  /**
    * ENNE_DESCRICAO: M�todo Sets p�ra este campo.
    */
  public void setEnne_descricao(String PARAM) {
    enne_descricao = PARAM;
  }
  /**
    * DIAS_CONSULTA_RETROATIVA: M�todo Gets para este campo
    */
  public String getDias_consulta_retroativa() {
    return dias_consulta_retroativa;
  }
  /**
    * DIAS_CONSULTA_RETROATIVA: M�todo Sets p�ra este campo.
    */
  public void setDias_consulta_retroativa(String PARAM) {
    dias_consulta_retroativa = PARAM;
  }
  /**
    * USUA_SUPER: M�todo Gets para este campo
    */
  public String getUsua_super() {
    return usua_super;
  }
  /**
    * USUA_SUPER: M�todo Sets p�ra este campo.
    */
  public void setUsua_super(String PARAM) {
    usua_super = PARAM;
  }
  Vector usua_superList = new Vector(10, 1);
  public java.util.Vector getUsua_superList() {
    if (usua_superList == null || usua_superList.size() == 0) {
      usua_superList.addElement("N");
      usua_superLabelList.addElement("N�o");
      usua_superList.addElement("S");
      usua_superLabelList.addElement("Sim");
    }
    java.util.Vector list = usua_superList;
    return list;
  }
  java.util.Vector usua_superLabelList = new Vector(10, 1);
  public java.util.Vector getUsua_superLabelList() {
    java.util.Vector list = usua_superLabelList;
    return list;
  }
  /**
    * USUA_EXPIRA_SENHA: M�todo Gets para este campo
    */
  public String getUsua_expira_senha() {
    return usua_expira_senha;
  }
  /**
    * USUA_EXPIRA_SENHA: M�todo Sets p�ra este campo.
    */
  public void setUsua_expira_senha(String PARAM) {
    usua_expira_senha = PARAM;
  }
  Vector usua_expira_senhaList = new Vector(10, 1);
  public java.util.Vector getUsua_expira_senhaList() {
    if (usua_expira_senhaList == null || usua_expira_senhaList.size() == 0) {
      usua_expira_senhaList.addElement("S");
      usua_expira_senhaLabelList.addElement("Sim");
      usua_expira_senhaList.addElement("N");
      usua_expira_senhaLabelList.addElement("N�o");
    }
    java.util.Vector list = usua_expira_senhaList;
    return list;
  }
  java.util.Vector usua_expira_senhaLabelList = new Vector(10, 1);
  public java.util.Vector getUsua_expira_senhaLabelList() {
    java.util.Vector list = usua_expira_senhaLabelList;
    return list;
  }
  /**
    * POS: M�todo Gets para este campo
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: M�todo Sets p�ra este campo.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * CHAMADOR: M�todo Gets para este campo
    */
  public String getChamador() {
    return chamador;
  }
  /**
    * CHAMADOR: M�todo Sets p�ra este campo.
    */
  public void setChamador(String PARAM) {
    chamador = PARAM;
  }
  /**
    * FORCA_SENHA: M�todo Gets para este campo
    */
  public String getForca_senha() {
    return forca_senha;
  }
  /**
    * FORCA_SENHA: M�todo Sets p�ra este campo.
    */
  public void setForca_senha(String PARAM) {
    forca_senha = PARAM;
  }
  /**
    * SITUACAO: M�todo Gets para este campo
    */
  public String getSituacao() {
    return situacao;
  }
  /**
    * SITUACAO: M�todo Sets p�ra este campo.
    */
  public void setSituacao(String PARAM) {
    situacao = PARAM;
  }
  Vector situacaoList = new Vector(10, 1);
  public java.util.Vector getSituacaoList() {
    if (situacaoList == null || situacaoList.size() == 0) {
      situacaoList.addElement("I");
      situacaoLabelList.addElement("Sim");
      situacaoList.addElement("A");
      situacaoLabelList.addElement("N�o");
    }
    java.util.Vector list = situacaoList;
    return list;
  }
  java.util.Vector situacaoLabelList = new Vector(10, 1);
  public java.util.Vector getSituacaoLabelList() {
    java.util.Vector list = situacaoLabelList;
    return list;
  }
  /**
    * USUARIO_INCLUSAO: M�todo Gets para este campo
    */
  public String getUsuario_inclusao() {
    return usuario_inclusao;
  }
  /**
    * USUARIO_INCLUSAO: M�todo Sets p�ra este campo.
    */
  public void setUsuario_inclusao(String PARAM) {
    usuario_inclusao = PARAM;
  }
  /**
    * DTHR_INCLUSAO: M�todo Gets para este campo
    */
  public String getDthr_inclusao() {
    return dthr_inclusao;
  }
  /**
    * DTHR_INCLUSAO: M�todo Sets p�ra este campo.
    */
  public void setDthr_inclusao(String PARAM) {
    dthr_inclusao = PARAM;
  }
  /**
    * USUARIO_ALTERACAO: M�todo Gets para este campo
    */
  public String getUsuario_alteracao() {
    return usuario_alteracao;
  }
  /**
    * USUARIO_ALTERACAO: M�todo Sets p�ra este campo.
    */
  public void setUsuario_alteracao(String PARAM) {
    usuario_alteracao = PARAM;
  }
  /**
    * DTHR_ALTERACAO: M�todo Gets para este campo
    */
  public String getDthr_alteracao() {
    return dthr_alteracao;
  }
  /**
    * DTHR_ALTERACAO: M�todo Sets p�ra este campo.
    */
  public void setDthr_alteracao(String PARAM) {
    dthr_alteracao = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    usua_id = null;
    usua_usuario = null;
    usua_nome = null;
    usua_email = null;
    usua_senha = null;
    confirma_senha = null;
    forca_senha_check = null;
    usua_enne_id = null;
    enne_descricao = null;
    dias_consulta_retroativa = null;
    usua_super = null;
    usua_expira_senha = null;
    pos = null;
    chamador = null;
    forca_senha = null;
    situacao = null;
    usuario_inclusao = null;
    dthr_inclusao = null;
    usuario_alteracao = null;
    dthr_alteracao = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("update_action,delete_action,", request)) {
      if (!com.egen.util.text.Validate.isRegex(usua_enne_id, "^[0-9]*$")) {
        errors.add("usua_enne_id", new ActionMessage("error.validate.regex","Entidade Neg�cio","usua_enne_id","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
