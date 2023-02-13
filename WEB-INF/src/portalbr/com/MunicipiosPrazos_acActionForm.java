package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 18/11/2013 10:53:57
 * Last Modify Date 20/11/2013 12:11:14
 */

public class MunicipiosPrazos_acActionForm extends org.apache.struts.action.ActionForm
{
  public String id;
  public String codigo;
  public String descricao_municipio;
  public String codigo_ibge;
  public String est_unifed;
  public String descricao;
  public String prazo_entrega;
  public String sigla_transportadora;
  public String segunda;
  public String terca;
  public String quarda;
  public String quinta;
  public String sexta;
  public String sabado;
  public String domingo;
  public String dthr_inclusao;
  public String usuario_inclusao;
  public String dthr_alteracao;
  public String usuario_alteracao;
  private boolean valida = false;
  public MunicipiosPrazos_acActionForm() {
  }
  /**
    * ID: M�todo Gets para este campo
    */
  public String getId() {
    return id;
  }
  /**
    * ID: M�todo Sets p�ra este campo.
    */
  public void setId(String PARAM) {
    id = PARAM;
  }
  /**
    * CODIGO: M�todo Gets para este campo
    */
  public String getCodigo() {
    return codigo;
  }
  /**
    * CODIGO: M�todo Sets p�ra este campo.
    */
  public void setCodigo(String PARAM) {
    codigo = PARAM;
  }
  /**
    * DESCRICAO_MUNICIPIO: M�todo Gets para este campo
    */
  public String getDescricao_municipio() {
    return descricao_municipio;
  }
  /**
    * DESCRICAO_MUNICIPIO: M�todo Sets p�ra este campo.
    */
  public void setDescricao_municipio(String PARAM) {
    descricao_municipio = PARAM;
  }
  /**
    * CODIGO_IBGE: M�todo Gets para este campo
    */
  public String getCodigo_ibge() {
    return codigo_ibge;
  }
  /**
    * CODIGO_IBGE: M�todo Sets p�ra este campo.
    */
  public void setCodigo_ibge(String PARAM) {
    codigo_ibge = PARAM;
  }
  /**
    * EST_UNIFED: M�todo Gets para este campo
    */
  public String getEst_unifed() {
    return est_unifed;
  }
  /**
    * EST_UNIFED: M�todo Sets p�ra este campo.
    */
  public void setEst_unifed(String PARAM) {
    est_unifed = PARAM;
  }
  /**
    * DESCRICAO: M�todo Gets para este campo
    */
  public String getDescricao() {
    return descricao;
  }
  /**
    * DESCRICAO: M�todo Sets p�ra este campo.
    */
  public void setDescricao(String PARAM) {
    descricao = PARAM;
  }
  /**
    * PRAZO_ENTREGA: M�todo Gets para este campo
    */
  public String getPrazo_entrega() {
    return prazo_entrega;
  }
  /**
    * PRAZO_ENTREGA: M�todo Sets p�ra este campo.
    */
  public void setPrazo_entrega(String PARAM) {
    prazo_entrega = PARAM;
  }
  /**
    * SIGLA_TRANSPORTADORA: M�todo Gets para este campo
    */
  public String getSigla_transportadora() {
    return sigla_transportadora;
  }
  /**
    * SIGLA_TRANSPORTADORA: M�todo Sets p�ra este campo.
    */
  public void setSigla_transportadora(String PARAM) {
    sigla_transportadora = PARAM;
  }
  /**
    * SEGUNDA: M�todo Gets para este campo
    */
  public String getSegunda() {
    return segunda;
  }
  /**
    * SEGUNDA: M�todo Sets p�ra este campo.
    */
  public void setSegunda(String PARAM) {
    segunda = PARAM;
  }
  /**
    * TERCA: M�todo Gets para este campo
    */
  public String getTerca() {
    return terca;
  }
  /**
    * TERCA: M�todo Sets p�ra este campo.
    */
  public void setTerca(String PARAM) {
    terca = PARAM;
  }
  /**
    * QUARDA: M�todo Gets para este campo
    */
  public String getQuarda() {
    return quarda;
  }
  /**
    * QUARDA: M�todo Sets p�ra este campo.
    */
  public void setQuarda(String PARAM) {
    quarda = PARAM;
  }
  /**
    * QUINTA: M�todo Gets para este campo
    */
  public String getQuinta() {
    return quinta;
  }
  /**
    * QUINTA: M�todo Sets p�ra este campo.
    */
  public void setQuinta(String PARAM) {
    quinta = PARAM;
  }
  /**
    * SEXTA: M�todo Gets para este campo
    */
  public String getSexta() {
    return sexta;
  }
  /**
    * SEXTA: M�todo Sets p�ra este campo.
    */
  public void setSexta(String PARAM) {
    sexta = PARAM;
  }
  /**
    * SABADO: M�todo Gets para este campo
    */
  public String getSabado() {
    return sabado;
  }
  /**
    * SABADO: M�todo Sets p�ra este campo.
    */
  public void setSabado(String PARAM) {
    sabado = PARAM;
  }
  /**
    * DOMINGO: M�todo Gets para este campo
    */
  public String getDomingo() {
    return domingo;
  }
  /**
    * DOMINGO: M�todo Sets p�ra este campo.
    */
  public void setDomingo(String PARAM) {
    domingo = PARAM;
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
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id = null;
    codigo = null;
    descricao_municipio = null;
    codigo_ibge = null;
    est_unifed = null;
    descricao = null;
    prazo_entrega = null;
    sigla_transportadora = null;
    segunda = null;
    terca = null;
    quarda = null;
    quinta = null;
    sexta = null;
    sabado = null;
    domingo = null;
    dthr_inclusao = null;
    usuario_inclusao = null;
    dthr_alteracao = null;
    usuario_alteracao = null;
  }
  /**
    * Valida��o dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(codigo)) {
        errors.add("codigo", new ActionMessage("error.validate.notnull","Munic�pio","codigo","0"));
      }
      if (com.egen.util.text.Validate.isNull(est_unifed)) {
        errors.add("est_unifed", new ActionMessage("error.validate.notnull","UF","est_unifed","0"));
      }
      if (com.egen.util.text.Validate.isNull(prazo_entrega)) {
        errors.add("prazo_entrega", new ActionMessage("error.validate.notnull","Prazo Entrega","prazo_entrega","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dthr_inclusao)) {
        errors.add("dthr_inclusao", new ActionMessage("error.validate.date","Dthr_inclusao","dthr_inclusao","0"));
      }
      if (!com.egen.util.text.Validate.isDate(dthr_alteracao)) {
        errors.add("dthr_alteracao", new ActionMessage("error.validate.date","Dthr_alteracao","dthr_alteracao","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
