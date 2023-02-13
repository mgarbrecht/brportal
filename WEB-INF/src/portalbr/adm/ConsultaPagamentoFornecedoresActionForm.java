package portalbr.adm;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 10/05/2012 17:39:45
 * Last Modify Date 05/11/2019 09:44:30
 */

public class ConsultaPagamentoFornecedoresActionForm extends org.apache.struts.action.ActionForm
{
  public String fornecedor;
  public String fornecedor_razao_social;
  public String data_vencimento;
  public String data_vencimento_fim;
  public String data_pagamento;
  public String data_pagamento_fim;
  public String status;
  public String nota;
  public String gerar_planilha;
  private boolean valida = false;
  public ConsultaPagamentoFornecedoresActionForm() {
  }
  /**
    * FORNECEDOR: Método Gets para este campo
    */
  public String getFornecedor() {
    return fornecedor;
  }
  /**
    * FORNECEDOR: Método Sets pára este campo.
    */
  public void setFornecedor(String PARAM) {
    fornecedor = PARAM;
  }
  /**
    * FORNECEDOR_RAZAO_SOCIAL: Método Gets para este campo
    */
  public String getFornecedor_razao_social() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fornecedor != null && fornecedor.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        String[][] select = { {"for_razsoc",null} };
        Object[][] where = { {"for_codigo","=",com.egen.util.text.FormatNumber.toInteger(fornecedor)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          fornecedor_razao_social = ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"");
        } else {
          fornecedor_razao_social = "";
        }
      }
    } catch (Exception e) {
      fornecedor_razao_social = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fornecedor_razao_social;
  }

  public String[][] getFornecedor_razao_social_Ajax(ConsultaPagamentoFornecedoresActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFornecedor() != null && PARAM.getFornecedor().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Fornecedor db_object = new Fornecedor();
        Object[][] where = { {"for_codigo","like",PARAM.getFornecedor()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Fornecedor) results.elementAt(0);
          list[0] = new String[]{"fornecedor_razao_social", ((db_object.getFor_razsoc() != null) ? db_object.getFor_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fornecedor_razao_social", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fornecedor_razao_social", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FORNECEDOR_RAZAO_SOCIAL: Método Sets pára este campo.
    */
  public void setFornecedor_razao_social(String PARAM) {
    fornecedor_razao_social = PARAM;
  }
  /**
    * DATA_VENCIMENTO: Método Gets para este campo
    */
  public String getData_vencimento() {
    return data_vencimento;
  }
  /**
    * DATA_VENCIMENTO: Método Sets pára este campo.
    */
  public void setData_vencimento(String PARAM) {
    data_vencimento = PARAM;
  }
  /**
    * DATA_VENCIMENTO_FIM: Método Gets para este campo
    */
  public String getData_vencimento_fim() {
    return data_vencimento_fim;
  }
  /**
    * DATA_VENCIMENTO_FIM: Método Sets pára este campo.
    */
  public void setData_vencimento_fim(String PARAM) {
    data_vencimento_fim = PARAM;
  }
  /**
    * DATA_PAGAMENTO: Método Gets para este campo
    */
  public String getData_pagamento() {
    return data_pagamento;
  }
  /**
    * DATA_PAGAMENTO: Método Sets pára este campo.
    */
  public void setData_pagamento(String PARAM) {
    data_pagamento = PARAM;
  }
  /**
    * DATA_PAGAMENTO_FIM: Método Gets para este campo
    */
  public String getData_pagamento_fim() {
    return data_pagamento_fim;
  }
  /**
    * DATA_PAGAMENTO_FIM: Método Sets pára este campo.
    */
  public void setData_pagamento_fim(String PARAM) {
    data_pagamento_fim = PARAM;
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
  Vector statusList = new Vector(10, 1);
  public java.util.Vector getStatusList() {
    if (statusList == null || statusList.size() == 0) {
      statusList.addElement("");
      statusLabelList.addElement("Todos");
      statusList.addElement("L");
      statusLabelList.addElement("Liquidado");
      statusList.addElement("A");
      statusLabelList.addElement("Aberto");
    }
    java.util.Vector list = statusList;
    return list;
  }
  java.util.Vector statusLabelList = new Vector(10, 1);
  public java.util.Vector getStatusLabelList() {
    java.util.Vector list = statusLabelList;
    return list;
  }
  /**
    * NOTA: Método Gets para este campo
    */
  public String getNota() {
    return nota;
  }
  /**
    * NOTA: Método Sets pára este campo.
    */
  public void setNota(String PARAM) {
    nota = PARAM;
  }
  /**
    * GERAR_PLANILHA: Método Gets para este campo
    */
  public String getGerar_planilha() {
    return gerar_planilha;
  }
  /**
    * GERAR_PLANILHA: Método Sets pára este campo.
    */
  public void setGerar_planilha(String PARAM) {
    gerar_planilha = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    fornecedor = null;
    fornecedor_razao_social = null;
    data_vencimento = null;
    data_vencimento_fim = null;
    data_pagamento = null;
    data_pagamento_fim = null;
    status = null;
    nota = null;
    gerar_planilha = null;
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

    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
