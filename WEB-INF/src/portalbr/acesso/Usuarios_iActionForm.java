package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/01/2006 13:29:55
 * Last Modify Date 21/06/2022 15:18:13
 */

public class Usuarios_iActionForm extends org.apache.struts.action.ActionForm
{
  public String usua_id;
  public String usua_usuario;
  public String usua_nome;
  public String usua_email;
  public String usua_senha;
  public String confirma_nova_senha;
  public String usua_enne_id;
  public String tien_tipo;
  public String tipo_entidade;
  public String chave;
  public String usua_dt_senha;
  public String dias_consulta_retroativa;
  public String usua_expira_senha;
  public String usua_super;
  public String gerar_autorizacao;
  public String copiar_acessos;
  public String usua_pai;
  public String usua_pai_nome;
  public String usua_pai_id;
  private boolean valida = false;
  public Usuarios_iActionForm() {
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
    * USUA_EMAIL: Método Gets para este campo
    */
  public String getUsua_email() {
    return usua_email;
  }
  /**
    * USUA_EMAIL: Método Sets pára este campo.
    */
  public void setUsua_email(String PARAM) {
    usua_email = PARAM;
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
    * CONFIRMA_NOVA_SENHA: Método Gets para este campo
    */
  public String getConfirma_nova_senha() {
    return confirma_nova_senha;
  }
  /**
    * CONFIRMA_NOVA_SENHA: Método Sets pára este campo.
    */
  public void setConfirma_nova_senha(String PARAM) {
    confirma_nova_senha = PARAM;
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
    * TIEN_TIPO: Método Gets para este campo
    */
  public String getTien_tipo() {
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: Método Sets pára este campo.
    */
  public void setTien_tipo(String PARAM) {
    tien_tipo = PARAM;
  }
  /**
    * TIPO_ENTIDADE: Método Gets para este campo
    */
  public String getTipo_entidade() {
    return tipo_entidade;
  }
  /**
    * TIPO_ENTIDADE: Método Sets pára este campo.
    */
  public void setTipo_entidade(String PARAM) {
    tipo_entidade = PARAM;
  }
  private Vector tipo_entidadeList = new Vector(10, 10);
  public void setTipo_entidadeList(java.util.Vector VECTOR) {
    tipo_entidadeList = VECTOR;
  }
  public java.util.Vector getTipo_entidadeList() {
    if (tipo_entidadeList == null || tipo_entidadeList.size() == 0) {
      tipo_entidadeList = new Vector(10, 10);
      tipo_entidadeLabelList = new Vector(10, 10);
      tipo_entidadeList.addElement("");
      java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ApplicationResources");
      tipo_entidadeLabelList.addElement(bundle.getString("jsp.pleaseselect"));
      com.egen.util.jdbc.JdbcUtil j = null;
      try {
        j = new com.egen.util.jdbc.JdbcUtil();
        Tipos_entidade_negocio db_object = new Tipos_entidade_negocio();
        String[][] select = {{"tien_id", null},{"tien_tipo", null}};
        Object[][] where = null;
        String[] order = {"tien_tipo"};
        String[] groupby = null;
        String[] having = null;
        Vector results = j.select(db_object, select, where, groupby, having, order);
        for (int i = 0; i < results.size(); i++) {
          db_object = (Tipos_entidade_negocio) results.elementAt(i);
          tipo_entidadeList.addElement(""+db_object.getTien_id());
          tipo_entidadeLabelList.addElement(""+db_object.getTien_tipo());
        }
      } catch (Exception e) {
        com.egen.util.logger.Logging.log("portalbr", java.util.logging.Level.INFO, "Usuarios_i.", e);
      } finally {
        if (j != null) {
          j.close();
        }
      }
    }
    return tipo_entidadeList;
  }
  private java.util.Vector tipo_entidadeLabelList = new Vector(10, 10);
  public void setTipo_entidadeLabelList(java.util.Vector VECTOR) {
    tipo_entidadeLabelList = VECTOR;
  }
  public java.util.Vector getTipo_entidadeLabelList() {
    return tipo_entidadeLabelList;
  }
  /**
    * CHAVE: Método Gets para este campo
    */
  public String getChave() {
    return chave;
  }
  /**
    * CHAVE: Método Sets pára este campo.
    */
  public void setChave(String PARAM) {
    chave = PARAM;
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
  Vector usua_expira_senhaList = new Vector(10, 1);
  public java.util.Vector getUsua_expira_senhaList() {
    if (usua_expira_senhaList == null || usua_expira_senhaList.size() == 0) {
      usua_expira_senhaList.addElement("S");
      usua_expira_senhaLabelList.addElement("Sim");
      usua_expira_senhaList.addElement("N");
      usua_expira_senhaLabelList.addElement("Não");
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
  Vector usua_superList = new Vector(10, 1);
  public java.util.Vector getUsua_superList() {
    if (usua_superList == null || usua_superList.size() == 0) {
      usua_superList.addElement("N");
      usua_superLabelList.addElement("Não");
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
    * GERAR_AUTORIZACAO: Método Gets para este campo
    */
  public String getGerar_autorizacao() {
    return gerar_autorizacao;
  }
  /**
    * GERAR_AUTORIZACAO: Método Sets pára este campo.
    */
  public void setGerar_autorizacao(String PARAM) {
    gerar_autorizacao = PARAM;
  }
  Vector gerar_autorizacaoList = new Vector(10, 1);
  public java.util.Vector getGerar_autorizacaoList() {
    if (gerar_autorizacaoList == null || gerar_autorizacaoList.size() == 0) {
      gerar_autorizacaoList.addElement("S");
      gerar_autorizacaoLabelList.addElement("Sim");
      gerar_autorizacaoList.addElement("N");
      gerar_autorizacaoLabelList.addElement("Não");
    }
    java.util.Vector list = gerar_autorizacaoList;
    return list;
  }
  java.util.Vector gerar_autorizacaoLabelList = new Vector(10, 1);
  public java.util.Vector getGerar_autorizacaoLabelList() {
    java.util.Vector list = gerar_autorizacaoLabelList;
    return list;
  }
  /**
    * COPIAR_ACESSOS: Método Gets para este campo
    */
  public String getCopiar_acessos() {
    return copiar_acessos;
  }
  /**
    * COPIAR_ACESSOS: Método Sets pára este campo.
    */
  public void setCopiar_acessos(String PARAM) {
    copiar_acessos = PARAM;
  }
  /**
    * USUA_PAI: Método Gets para este campo
    */
  public String getUsua_pai() {
    return usua_pai;
  }
  /**
    * USUA_PAI: Método Sets pára este campo.
    */
  public void setUsua_pai(String PARAM) {
    usua_pai = PARAM;
  }
  /**
    * USUA_PAI_NOME: Método Gets para este campo
    */
  public String getUsua_pai_nome() {
    return usua_pai_nome;
  }
  /**
    * USUA_PAI_NOME: Método Sets pára este campo.
    */
  public void setUsua_pai_nome(String PARAM) {
    usua_pai_nome = PARAM;
  }
  /**
    * USUA_PAI_ID: Método Gets para este campo
    */
  public String getUsua_pai_id() {
    return usua_pai_id;
  }
  /**
    * USUA_PAI_ID: Método Sets pára este campo.
    */
  public void setUsua_pai_id(String PARAM) {
    usua_pai_id = PARAM;
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
    confirma_nova_senha = null;
    usua_enne_id = null;
    tien_tipo = null;
    tipo_entidade = null;
    chave = null;
    usua_dt_senha = null;
    dias_consulta_retroativa = null;
    usua_expira_senha = null;
    usua_super = null;
    gerar_autorizacao = null;
    copiar_acessos = null;
    usua_pai = null;
    usua_pai_nome = null;
    usua_pai_id = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("incluir_action,", request)) {
      if (com.egen.util.text.Validate.isNull(usua_senha)) {
        errors.add("usua_senha", new ActionMessage("error.validate.notnull","Senha","usua_senha","0"));
      }
      if (com.egen.util.text.Validate.isNull(confirma_nova_senha)) {
        errors.add("confirma_nova_senha", new ActionMessage("error.validate.notnull","Confirma Nova Senha","confirma_nova_senha","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(usua_enne_id, "^[0-9]*$")) {
        errors.add("usua_enne_id", new ActionMessage("error.validate.regex","Entidade Negócio","usua_enne_id","0"));
      }
      if (com.egen.util.text.Validate.isNull(usua_expira_senha)) {
        errors.add("usua_expira_senha", new ActionMessage("error.validate.notnull","Expira Senha","usua_expira_senha","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
