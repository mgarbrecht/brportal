package portalbr.lov;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 23/05/2011 08:58:45
 * Last Modify Date 23/05/2011 16:19:26
 */

public class FichatecnicaActionForm extends org.apache.struts.action.ActionForm
{
  public String id_nro;
  public String data;
  public String projeto_cdgo;
  public String fma_cdgo;
  public String base;
  public String codigo_colecao;
  public String gde_cdgo;
  public String lin_cdgo;
  public String projeto_desc;
  public String forma_desc;
  public String grade_desc;
  public String linha_desc;
  public String ref_cdgo;
  public String ref_desc;
  public String padrao;
  public String codigo_desc;
  public String cod_mini_fab;
  public String cod_mini_fab_desc;
  public String tecnico_resp;
  public String tecnico_pre;
  public String data_entrega_amostra;
  public String status;
  private boolean valida = false;
  public FichatecnicaActionForm() {
  }
  /**
    * ID_NRO: Método Gets para este campo
    */
  public String getId_nro() {
    return id_nro;
  }
  /**
    * ID_NRO: Método Sets pára este campo.
    */
  public void setId_nro(String PARAM) {
    id_nro = PARAM;
  }
  /**
    * DATA: Método Gets para este campo
    */
  public String getData() {
    return data;
  }
  /**
    * DATA: Método Sets pára este campo.
    */
  public void setData(String PARAM) {
    data = PARAM;
  }
  /**
    * PROJETO_CDGO: Método Gets para este campo
    */
  public String getProjeto_cdgo() {
    return projeto_cdgo;
  }
  /**
    * PROJETO_CDGO: Método Sets pára este campo.
    */
  public void setProjeto_cdgo(String PARAM) {
    projeto_cdgo = PARAM;
  }
  /**
    * FMA_CDGO: Método Gets para este campo
    */
  public String getFma_cdgo() {
    return fma_cdgo;
  }
  /**
    * FMA_CDGO: Método Sets pára este campo.
    */
  public void setFma_cdgo(String PARAM) {
    fma_cdgo = PARAM;
  }
  /**
    * BASE: Método Gets para este campo
    */
  public String getBase() {
    return base;
  }
  /**
    * BASE: Método Sets pára este campo.
    */
  public void setBase(String PARAM) {
    base = PARAM;
  }
  /**
    * CODIGO_COLECAO: Método Gets para este campo
    */
  public String getCodigo_colecao() {
    return codigo_colecao;
  }
  /**
    * CODIGO_COLECAO: Método Sets pára este campo.
    */
  public void setCodigo_colecao(String PARAM) {
    codigo_colecao = PARAM;
  }
  /**
    * GDE_CDGO: Método Gets para este campo
    */
  public String getGde_cdgo() {
    return gde_cdgo;
  }
  /**
    * GDE_CDGO: Método Sets pára este campo.
    */
  public void setGde_cdgo(String PARAM) {
    gde_cdgo = PARAM;
  }
  /**
    * LIN_CDGO: Método Gets para este campo
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Método Sets pára este campo.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * PROJETO_DESC: Método Gets para este campo
    */
  public String getProjeto_desc() {
    return projeto_desc;
  }
  /**
    * PROJETO_DESC: Método Sets pára este campo.
    */
  public void setProjeto_desc(String PARAM) {
    projeto_desc = PARAM;
  }
  /**
    * FORMA_DESC: Método Gets para este campo
    */
  public String getForma_desc() {
    return forma_desc;
  }
  /**
    * FORMA_DESC: Método Sets pára este campo.
    */
  public void setForma_desc(String PARAM) {
    forma_desc = PARAM;
  }
  /**
    * GRADE_DESC: Método Gets para este campo
    */
  public String getGrade_desc() {
    return grade_desc;
  }
  /**
    * GRADE_DESC: Método Sets pára este campo.
    */
  public void setGrade_desc(String PARAM) {
    grade_desc = PARAM;
  }
  /**
    * LINHA_DESC: Método Gets para este campo
    */
  public String getLinha_desc() {
    return linha_desc;
  }
  /**
    * LINHA_DESC: Método Sets pára este campo.
    */
  public void setLinha_desc(String PARAM) {
    linha_desc = PARAM;
  }
  /**
    * REF_CDGO: Método Gets para este campo
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Método Sets pára este campo.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * REF_DESC: Método Gets para este campo
    */
  public String getRef_desc() {
    return ref_desc;
  }
  /**
    * REF_DESC: Método Sets pára este campo.
    */
  public void setRef_desc(String PARAM) {
    ref_desc = PARAM;
  }
  /**
    * PADRAO: Método Gets para este campo
    */
  public String getPadrao() {
    return padrao;
  }
  /**
    * PADRAO: Método Sets pára este campo.
    */
  public void setPadrao(String PARAM) {
    padrao = PARAM;
  }
  /**
    * CODIGO_DESC: Método Gets para este campo
    */
  public String getCodigo_desc() {
    return codigo_desc;
  }
  /**
    * CODIGO_DESC: Método Sets pára este campo.
    */
  public void setCodigo_desc(String PARAM) {
    codigo_desc = PARAM;
  }
  /**
    * COD_MINI_FAB: Método Gets para este campo
    */
  public String getCod_mini_fab() {
    return cod_mini_fab;
  }
  /**
    * COD_MINI_FAB: Método Sets pára este campo.
    */
  public void setCod_mini_fab(String PARAM) {
    cod_mini_fab = PARAM;
  }
  /**
    * COD_MINI_FAB_DESC: Método Gets para este campo
    */
  public String getCod_mini_fab_desc() {
    return cod_mini_fab_desc;
  }
  /**
    * COD_MINI_FAB_DESC: Método Sets pára este campo.
    */
  public void setCod_mini_fab_desc(String PARAM) {
    cod_mini_fab_desc = PARAM;
  }
  /**
    * TECNICO_RESP: Método Gets para este campo
    */
  public String getTecnico_resp() {
    return tecnico_resp;
  }
  /**
    * TECNICO_RESP: Método Sets pára este campo.
    */
  public void setTecnico_resp(String PARAM) {
    tecnico_resp = PARAM;
  }
  /**
    * TECNICO_PRE: Método Gets para este campo
    */
  public String getTecnico_pre() {
    return tecnico_pre;
  }
  /**
    * TECNICO_PRE: Método Sets pára este campo.
    */
  public void setTecnico_pre(String PARAM) {
    tecnico_pre = PARAM;
  }
  /**
    * DATA_ENTREGA_AMOSTRA: Método Gets para este campo
    */
  public String getData_entrega_amostra() {
    return data_entrega_amostra;
  }
  /**
    * DATA_ENTREGA_AMOSTRA: Método Sets pára este campo.
    */
  public void setData_entrega_amostra(String PARAM) {
    data_entrega_amostra = PARAM;
  }
  /**
    * STATUS: Método Gets para este campo
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Método Sets pára este campo.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id_nro = null;
    data = null;
    projeto_cdgo = null;
    fma_cdgo = null;
    base = null;
    codigo_colecao = null;
    gde_cdgo = null;
    lin_cdgo = null;
    projeto_desc = null;
    forma_desc = null;
    grade_desc = null;
    linha_desc = null;
    ref_cdgo = null;
    ref_desc = null;
    padrao = null;
    codigo_desc = null;
    cod_mini_fab = null;
    cod_mini_fab_desc = null;
    tecnico_resp = null;
    tecnico_pre = null;
    data_entrega_amostra = null;
    status = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (!com.egen.util.struts.Token.isTokenValid(mapping, request)) {
      errors.add("Warning", new ActionMessage("token.error","<br>","","",""));
    }
    com.egen.util.struts.Token.saveToken(mapping, request);

    if (com.egen.util.text.Validate.isValidate("insert_action,update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(id_nro)) {
        errors.add("id_nro", new ActionMessage("error.validate.notnull","Id_nro","id_nro","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data)) {
        errors.add("data", new ActionMessage("error.validate.date","Data","data","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_entrega_amostra)) {
        errors.add("data_entrega_amostra", new ActionMessage("error.validate.date","Data_entrega_amostra","data_entrega_amostra","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
