package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Creation Date 13/03/2006 15:41:20
 * Last Modify Date 15/03/2006 16:32:11
 */

public class PoiRegionalMarcasActionForm extends org.apache.struts.action.ActionForm
{
  public String situacao_gerente;
  
  public void setSituacao_gerente(String SITUACAO_GERENTE){
     this.situacao_gerente = SITUACAO_GERENTE;  
  }     
  public String getSituacao_gerente(){
    return this.situacao_gerente; 
  }

  public String codigo_regional; 
  public String nome_regional;
  public String agrupa_regionais;
  public String rep_cdgo;
  public String rep_rzao;
  public String unidade_negocio;
  public String unn_descri;
  public String codigo_marca;
  public String descricao_marca;
  public String mes;
  public String ano;
  public String mes_final;
  public String ano_final;
  public String f_regional ="";;
  public String f_representante;
  private boolean valida = false;
  public PoiRegionalMarcasActionForm() {
  }

  /**
    * AGRUPA_REGIONAIS: Method to get the field value.
    */
  public String getAgrupa_regionais() {
    return agrupa_regionais;
  }
  /**
    * AGRUPA_REGIONAIS: Method to set the field value.
    */
  public void setAgrupa_regionais(String AGRUPA_REGIONAIS) {
    agrupa_regionais = AGRUPA_REGIONAIS;
  }
 /**
    * CODIGO_MARCA: Method to get the field value.
    */
  public String getCodigo_marca() {
    return codigo_marca;
  }
  /**
    * CODIGO_MARCA: Method to set the field value.
    */
  public void setCodigo_marca(String CODIGO_MARCA) {
    codigo_marca = CODIGO_MARCA;
  }

 /**
    * DESCRICAO_MARCA: Method to get the field value.
    */
  public String getDescricao_marca() {
    return descricao_marca;
  }
  /**
    * DESCRICAO_MARCA: Method to set the field value.
    */
  public void setDescricao_marca(String DESCRICAO_MARCA) {
    descricao_marca = DESCRICAO_MARCA;
  }


  /**
    * CODIGO_REGIONAL: Method to get the field value.
    */
  public String getCodigo_regional() {
    return codigo_regional;
  }
  /**
    * CODIGO_REGIONAL: Method to set the field value.
    */
  public void setCodigo_regional(String CODIGO_REGIONAL) {
    codigo_regional = CODIGO_REGIONAL;
  }
  /**
    * NOME_REGIONAL: Method to get the field value.
    */
  public String getNome_regional() {
    return nome_regional;
  }
  /**
    * NOME_REGIONAL: Method to set the field value.
    */
  public void setNome_regional(String NOME_REGIONAL) {
    nome_regional = NOME_REGIONAL;
  }
  /**
    * REP_CDGO: Method to get the field value.
    */
  public String getRep_cdgo() {
    return rep_cdgo;
  }
  /**
    * REP_CDGO: Method to set the field value.
    */
  public void setRep_cdgo(String REP_CDGO) {
    rep_cdgo = REP_CDGO;
  }
  /**
    * REP_RZAO: Method to get the field value.
    */
  public String getRep_rzao() {
    return rep_rzao;
  }
  /**
    * REP_RZAO: Method to set the field value.
    */
  public void setRep_rzao(String REP_RZAO) {
    rep_rzao = REP_RZAO;
  }
  /**
    * UNIDADE_NEGOCIO: Method to get the field value.
    */
  public String getUnidade_negocio() {
    return unidade_negocio;
  }
  /**
    * UNIDADE_NEGOCIO: Method to set the field value.
    */
  public void setUnidade_negocio(String UNIDADE_NEGOCIO) {
    unidade_negocio = UNIDADE_NEGOCIO;
  }
  /**
    * UNN_DESCRI: Method to get the field value.
    */
  public String getUnn_descri() {
    return unn_descri;
  }
  /**
    * UNN_DESCRI: Method to set the field value.
    */
  public void setUnn_descri(String UNN_DESCRI) {
    unn_descri = UNN_DESCRI;
  }
  /**
    * MES: Method to get the field value.
    */
  public String getMes() {
    return mes;
  }
  /**
    * MES: Method to set the field value.
    */
  public void setMes(String MES) {
    mes = MES;
  }
  /**
    * ANO: Method to get the field value.
    */
  public String getAno() {
    return ano;
  }
  /**
    * ANO: Method to set the field value.
    */
  public void setAno(String ANO) {
    ano = ANO;
  }


  /**
    * MES_FINAL: Method to get the field value.
    */
  public String getMes_final() {
    return mes_final;
  }
  /**
    * MES_FINAL: Method to set the field value.
    */
  public void setMes_final(String MES_FINAL) {
    mes_final = MES_FINAL;
  }
  /**
    * ANO_FINAL: Method to get the field value.
    */
  public String getAno_final() {
    return ano_final;
  }
  /**
    * ANO_final: Method to set the field value.
    */
  public void setAno_final(String ANO_FINAL) {
    ano_final = ANO_FINAL;
  }
  


  /**
    * F_REGIONAL: Method to get the field value.
    */
  public String getF_regional() {
    return f_regional;
  }
  /**
    * F_REGIONAL: Method to set the field value.
    */
  public void setF_regional(String F_REGIONAL) {
    f_regional = F_REGIONAL;
  }
  /**
    * F_REPRESENTANTE: Method to get the field value.
    */
  public String getF_representante() {
    return f_representante;
  }
  /**
    * F_REPRESENTANTE: Method to set the field value.
    */
  public void setF_representante(String F_REPRESENTANTE) {
    f_representante = F_REPRESENTANTE;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    codigo_regional = null;
    nome_regional = null;
    rep_cdgo = null;
    rep_rzao = null;
    codigo_marca = null;
    descricao_marca = null;
    unidade_negocio = null;
    unn_descri = null;
    agrupa_regionais = null;
    mes = null;
    ano = null;
    f_regional = null;
    f_representante = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;

    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
//-------------------
  String codigo_regional2="";
     String codigo_representante2="";
     String tipo2="";
     acesso.Usuario u2 = new acesso.Usuario();
     u2 = (acesso.Usuario)session.getAttribute("User");
     acesso.EntidadeNegocio ent2 = new acesso.EntidadeNegocio();
     acesso.TipoEntidadeNegocio tipoent2 = new acesso.TipoEntidadeNegocio();

     if(!(u2.getEntidadeNegocio()==null)){
          ent2 = (acesso.EntidadeNegocio) u2.getEntidadeNegocio();
          tipoent2 = (acesso.TipoEntidadeNegocio) ent2.getTipoEntidadeNegocio();
          tipo2 = tipoent2.getTipo()+"";
          if(tipo2.equals("REGIONAL DE VENDA")){
            codigo_regional2 = ent2.getChave()+"";
          }
          if((tipo2.equals("REPRESENTANTE COMERCIAL")) || (tipo2.equals("REPRESENTANTE EXPORTACAO"))){
            codigo_representante2 = ent2.getChave()+"";
          }

     }
//-------------------

      if (com.egen.util.text.Validate.isNull(mes)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Mês Inicial","mes","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(mes, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Mês Inicial","mes","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Ano Inicial","ano","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ano, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Ano Inicial","ano","0"));
      }

      if (com.egen.util.text.Validate.isNull(mes_final)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Mês Final","mes_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(mes_final, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Mês Final","mes_final","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano_final)) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.notnull","Ano Final","ano_final","0"));
      }
      if (!com.egen.util.text.Validate.isRegex(ano_final, "^[0-9]*$")) {
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_poi", new ActionMessage("error.validate.regex","Ano Final","ano_final","0"));
      }


    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
