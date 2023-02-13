package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/01/2012 10:26:37
 * Last Modify Date 03/04/2013 13:11:03
 */

public class SolicitacaoAlteracaoComissao_iActionForm extends org.apache.struts.action.ActionForm
{
  public String tipo;
  public String id_solicitacao;
  public String nfs_nmro;
  public String nfs_serie;
  public String emp_empresa;
  public String fil_filial;
  public String valor_nota;
  public String qtd_duplicatas;
  public String valor_calculado;
  public String nro_dias_prorrogacao;
  public String data_solicitacao;
  public String usuario_solicitacao;
  public String situacao;
  public String ped_boni;
  public String ped_comr;
  public String comissao_nova;
  public String valor_calculado1;
  public String motivo;
  private boolean valida = false;
  public SolicitacaoAlteracaoComissao_iActionForm() {
  }
  /**
    * TIPO: Método Gets para este campo
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Método Sets pára este campo.
    */
  public void setTipo(String PARAM) {
    tipo = PARAM;
  }
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("P");
      tipoLabelList.addElement("Prorrogação");
      tipoList.addElement("D");
      tipoLabelList.addElement("Desconto não concedido");
    }
    java.util.Vector list = tipoList;
    return list;
  }
  java.util.Vector tipoLabelList = new Vector(10, 1);
  public java.util.Vector getTipoLabelList() {
    java.util.Vector list = tipoLabelList;
    return list;
  }
  /**
    * ID_SOLICITACAO: Método Gets para este campo
    */
  public String getId_solicitacao() {
    return id_solicitacao;
  }
  /**
    * ID_SOLICITACAO: Método Sets pára este campo.
    */
  public void setId_solicitacao(String PARAM) {
    id_solicitacao = PARAM;
  }
  /**
    * NFS_NMRO: Método Gets para este campo
    */
  public String getNfs_nmro() {
    return nfs_nmro;
  }
  /**
    * NFS_NMRO: Método Sets pára este campo.
    */
  public void setNfs_nmro(String PARAM) {
    nfs_nmro = PARAM;
  }
  /**
    * NFS_SERIE: Método Gets para este campo
    */
  public String getNfs_serie() {
    return nfs_serie;
  }
  /**
    * NFS_SERIE: Método Sets pára este campo.
    */
  public void setNfs_serie(String PARAM) {
    nfs_serie = PARAM;
  }
  /**
    * EMP_EMPRESA: Método Gets para este campo
    */
  public String getEmp_empresa() {
    return emp_empresa;
  }
  /**
    * EMP_EMPRESA: Método Sets pára este campo.
    */
  public void setEmp_empresa(String PARAM) {
    emp_empresa = PARAM;
  }
  /**
    * FIL_FILIAL: Método Gets para este campo
    */
  public String getFil_filial() {
    return fil_filial;
  }
  /**
    * FIL_FILIAL: Método Sets pára este campo.
    */
  public void setFil_filial(String PARAM) {
    fil_filial = PARAM;
  }
  /**
    * VALOR_NOTA: Método Gets para este campo
    */
  public String getValor_nota() {
    return valor_nota;
  }
  /**
    * VALOR_NOTA: Método Sets pára este campo.
    */
  public void setValor_nota(String PARAM) {
    valor_nota = PARAM;
  }
  /**
    * QTD_DUPLICATAS: Método Gets para este campo
    */
  public String getQtd_duplicatas() {
    return qtd_duplicatas;
  }
  /**
    * QTD_DUPLICATAS: Método Sets pára este campo.
    */
  public void setQtd_duplicatas(String PARAM) {
    qtd_duplicatas = PARAM;
  }
  /**
    * VALOR_CALCULADO: Método Gets para este campo
    */
  public String getValor_calculado() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (valor_nota != null && valor_nota.length() > 0 && qtd_duplicatas != null && qtd_duplicatas.length() > 0 && nro_dias_prorrogacao != null && nro_dias_prorrogacao.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        String[][] select = { {"cab_data_alteracao",null} };
        Object[][] where = { {"cab_cdgo","=",com.egen.util.text.FormatNumber.toInteger(valor_nota)}, {"cab_desc","like",qtd_duplicatas}, {"cab_nomesp","like",nro_dias_prorrogacao}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        /*    java.util.Vector results = j.select(db_object, select, where, group, having, order);
            if (results!=null && results.size()>0) {
              db_object = (Cabedal)results.elementAt(0);
              valor_calculado = ((db_object.getCab_data_alteracao()!=null)?db_object.getCab_data_alteracao()+"":"");
            } else {
              valor_calculado = "";
            }
        */
      }
    } catch (Exception e) {
      valor_calculado = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return valor_calculado;
  }

  public String[][] getValor_calculado_Ajax(SolicitacaoAlteracaoComissao_iActionForm PARAM) {
    String[][] list = new String[1][2];
    try {
      util.consultas.Query query = new util.consultas.Query();
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      String funcao = parametros.retornaParametro("formula_custo_total_prorrogacao");
      funcao = funcao.replace("<valor_nota>", PARAM.getValor_nota());
      funcao = funcao.replace("<dias_prorrogacao>", PARAM.getNro_dias_prorrogacao());
      funcao = funcao.replace("<quantidade_duplicatas>", PARAM.getQtd_duplicatas());

      list[0] = new String[]{"valor_calculado", query.retorna("select round(" + funcao + ",2) from dual")};

    } catch (Exception e) {
      list[0] = new String[]{"valor_calculado", "0"};
    } finally {
    }
    return list;
  }/**
    * VALOR_CALCULADO: Método Sets pára este campo.
    */

  public void setValor_calculado(String PARAM) {
    valor_calculado = PARAM;
  }
  /**
    * NRO_DIAS_PRORROGACAO: Método Gets para este campo
    */
  public String getNro_dias_prorrogacao() {
    return nro_dias_prorrogacao;
  }
  /**
    * NRO_DIAS_PRORROGACAO: Método Sets pára este campo.
    */
  public void setNro_dias_prorrogacao(String PARAM) {
    nro_dias_prorrogacao = PARAM;
  }
  /**
    * DATA_SOLICITACAO: Método Gets para este campo
    */
  public String getData_solicitacao() {
    return data_solicitacao;
  }
  /**
    * DATA_SOLICITACAO: Método Sets pára este campo.
    */
  public void setData_solicitacao(String PARAM) {
    data_solicitacao = PARAM;
  }
  /**
    * USUARIO_SOLICITACAO: Método Gets para este campo
    */
  public String getUsuario_solicitacao() {
    return usuario_solicitacao;
  }
  /**
    * USUARIO_SOLICITACAO: Método Sets pára este campo.
    */
  public void setUsuario_solicitacao(String PARAM) {
    usuario_solicitacao = PARAM;
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
    * PED_BONI: Método Gets para este campo
    */
  public String getPed_boni() {
    return ped_boni;
  }
  /**
    * PED_BONI: Método Sets pára este campo.
    */
  public void setPed_boni(String PARAM) {
    ped_boni = PARAM;
  }
  /**
    * PED_COMR: Método Gets para este campo
    */
  public String getPed_comr() {
    return ped_comr;
  }
  /**
    * PED_COMR: Método Sets pára este campo.
    */
  public void setPed_comr(String PARAM) {
    ped_comr = PARAM;
  }
  /**
    * COMISSAO_NOVA: Método Gets para este campo
    */
  public String getComissao_nova() {
    return comissao_nova;
  }
  /**
    * COMISSAO_NOVA: Método Sets pára este campo.
    */
  public void setComissao_nova(String PARAM) {
    comissao_nova = PARAM;
  }
  /**
    * VALOR_CALCULADO1: Método Gets para este campo
    */
  public String getValor_calculado1() {
    return valor_calculado1;
  }
  /**
    * VALOR_CALCULADO1: Método Sets pára este campo.
    */
  public void setValor_calculado1(String PARAM) {
    valor_calculado1 = PARAM;
  }
  /**
    * MOTIVO: Método Gets para este campo
    */
  public String getMotivo() {
    return motivo;
  }
  /**
    * MOTIVO: Método Sets pára este campo.
    */
  public void setMotivo(String PARAM) {
    motivo = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    tipo = null;
    id_solicitacao = null;
    nfs_nmro = null;
    nfs_serie = null;
    emp_empresa = null;
    fil_filial = null;
    valor_nota = null;
    qtd_duplicatas = null;
    valor_calculado = null;
    nro_dias_prorrogacao = null;
    data_solicitacao = null;
    usuario_solicitacao = null;
    situacao = null;
    ped_boni = null;
    ped_comr = null;
    comissao_nova = null;
    valor_calculado1 = null;
    motivo = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,", request)) {
      if (com.egen.util.text.Validate.isNull(nfs_nmro)) {
        errors.add("nfs_nmro", new ActionMessage("error.validate.notnull","Nota","nfs_nmro","0"));
      }
      if (com.egen.util.text.Validate.isNull(nfs_serie)) {
        errors.add("nfs_serie", new ActionMessage("error.validate.notnull","Série","nfs_serie","0"));
      }
      if (com.egen.util.text.Validate.isNull(emp_empresa)) {
        errors.add("emp_empresa", new ActionMessage("error.validate.notnull","Empresa","emp_empresa","0"));
      }
      if (com.egen.util.text.Validate.isNull(fil_filial)) {
        errors.add("fil_filial", new ActionMessage("error.validate.notnull","Filial","fil_filial","0"));
      }
      if (com.egen.util.text.Validate.isNull(valor_nota)) {
        errors.add("valor_nota", new ActionMessage("error.validate.notnull","Valor Nota","valor_nota","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
