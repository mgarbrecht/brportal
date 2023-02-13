package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/09/2010 10:56:28
 * Last Modify Date 21/08/2013 11:58:10
 */

public class EntPedidosActionForm extends org.apache.struts.action.ActionForm
{
  public String numero_pedido;
  public String codigo_cliente;
  public String cli_rzao;
  public String estabelecimento_cliente;
  public String data_pedido;
  public String nome_planilha;
  public String status;
  public String tem_alteracao;
  public String pos;
  public boolean gridCheckField;
  public String numero_pedido1;
  public String numero_item;
  public String codigo_linha;
  public String codigo_referencia;
  public String codigo_corrugado;
  public String codigo_cabedal;
  public String descricao_item;
  public String codigo_cor;
  public String codigo_grade;
  public String quantidade_pares;
  public String preco_unitario;
  public String registro_banco;
  public String registro_alterado;
  public String loja_cliente;
  public String descricao_erro;
  private boolean valida = false;
  public EntPedidosActionForm() {
  }
  /**
    * NUMERO_PEDIDO: Method to get the field value.
    */
  public String getNumero_pedido() {
    return numero_pedido;
  }
  /**
    * NUMERO_PEDIDO: Method to set the field value.
    */
  public void setNumero_pedido(String PARAM) {
    numero_pedido = PARAM;
  }
  /**
    * CODIGO_CLIENTE: Method to get the field value.
    */
  public String getCodigo_cliente() {
    return codigo_cliente;
  }
  /**
    * CODIGO_CLIENTE: Method to set the field value.
    */
  public void setCodigo_cliente(String PARAM) {
    codigo_cliente = PARAM;
  }
  /**
    * CLI_RZAO: Method to get the field value.
    */
  public String getCli_rzao() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (codigo_cliente != null && codigo_cliente.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        String[][] select = { {"cli_rzao",null} };
        Object[][] where = { {"cli_cdgo","=",com.egen.util.text.FormatNumber.toInt(codigo_cliente)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          cli_rzao = (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":"";
        } else {
          cli_rzao = "";
        }
      }
    } catch (Exception e) {
      cli_rzao = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return cli_rzao;
  }

  public String[][] getCli_rzao_Ajax(EntPedidosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCodigo_cliente() != null && PARAM.getCodigo_cliente().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cli db_object = new Cli();
        Object[][] where = { {"cli_cdgo","=",PARAM.getCodigo_cliente()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cli) results.elementAt(0);
          list[0] = new String[]{"cli_rzao", (db_object.getCli_rzao() != null) ? db_object.getCli_rzao() + "":""};
        } else {
          list[0] = new String[]{"cli_rzao", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cli_rzao", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * CLI_RZAO: Method to set the field value.
    */
  public void setCli_rzao(String PARAM) {
    cli_rzao = PARAM;
  }
  /**
    * ESTABELECIMENTO_CLIENTE: Method to get the field value.
    */
  public String getEstabelecimento_cliente() {
    return estabelecimento_cliente;
  }
  /**
    * ESTABELECIMENTO_CLIENTE: Method to set the field value.
    */
  public void setEstabelecimento_cliente(String PARAM) {
    estabelecimento_cliente = PARAM;
  }
  /**
    * DATA_PEDIDO: Method to get the field value.
    */
  public String getData_pedido() {
    return data_pedido;
  }
  /**
    * DATA_PEDIDO: Method to set the field value.
    */
  public void setData_pedido(String PARAM) {
    data_pedido = PARAM;
  }
  /**
    * NOME_PLANILHA: Method to get the field value.
    */
  public String getNome_planilha() {
    return nome_planilha;
  }
  /**
    * NOME_PLANILHA: Method to set the field value.
    */
  public void setNome_planilha(String PARAM) {
    nome_planilha = PARAM;
  }
  /**
    * STATUS: Method to get the field value.
    */
  public String getStatus() {
    return status;
  }
  /**
    * STATUS: Method to set the field value.
    */
  public void setStatus(String PARAM) {
    status = PARAM;
  }
  Vector statusList = new Vector(10, 1);
  public java.util.Vector getStatusList() {
    if (statusList == null || statusList.size() == 0) {
      statusList.addElement("");
      statusLabelList.addElement("Todos");
      statusList.addElement("O");
      statusLabelList.addElement("Open");
      statusList.addElement("C");
      statusLabelList.addElement("Completed");
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
    * TEM_ALTERACAO: Method to get the field value.
    */
  public String getTem_alteracao() {
    return tem_alteracao;
  }
  /**
    * TEM_ALTERACAO: Method to set the field value.
    */
  public void setTem_alteracao(String PARAM) {
    tem_alteracao = PARAM;
  }
  /**
    * POS: Method to get the field value.
    */
  public String getPos() {
    return pos;
  }
  /**
    * POS: Method to set the field value.
    */
  public void setPos(String PARAM) {
    pos = PARAM;
  }
  /**
    * GRIDCHECKFIELD: Method to get the field value.
    */
  public boolean getGridCheckField() {
    return gridCheckField;
  }
  /**
    * GRIDCHECKFIELD: Method to set the field value.
    */
  public void setGridCheckField(boolean PARAM) {
    gridCheckField = PARAM;
  }
  /**
    * NUMERO_PEDIDO1: Method to get the field value.
    */
  public String getNumero_pedido1() {
    return numero_pedido1;
  }
  /**
    * NUMERO_PEDIDO1: Method to set the field value.
    */
  public void setNumero_pedido1(String PARAM) {
    numero_pedido1 = PARAM;
  }
  /**
    * NUMERO_ITEM: Method to get the field value.
    */
  public String getNumero_item() {
    return numero_item;
  }
  /**
    * NUMERO_ITEM: Method to set the field value.
    */
  public void setNumero_item(String PARAM) {
    numero_item = PARAM;
  }
  /**
    * CODIGO_LINHA: Method to get the field value.
    */
  public String getCodigo_linha() {
    return codigo_linha;
  }
  /**
    * CODIGO_LINHA: Method to set the field value.
    */
  public void setCodigo_linha(String PARAM) {
    codigo_linha = PARAM;
  }
  /**
    * CODIGO_REFERENCIA: Method to get the field value.
    */
  public String getCodigo_referencia() {
    return codigo_referencia;
  }
  /**
    * CODIGO_REFERENCIA: Method to set the field value.
    */
  public void setCodigo_referencia(String PARAM) {
    codigo_referencia = PARAM;
  }
  /**
    * CODIGO_CORRUGADO: Method to get the field value.
    */
  public String getCodigo_corrugado() {
    return codigo_corrugado;
  }
  /**
    * CODIGO_CORRUGADO: Method to set the field value.
    */
  public void setCodigo_corrugado(String PARAM) {
    codigo_corrugado = PARAM;
  }
  /**
    * CODIGO_CABEDAL: Method to get the field value.
    */
  public String getCodigo_cabedal() {
    return codigo_cabedal;
  }
  /**
    * CODIGO_CABEDAL: Method to set the field value.
    */
  public void setCodigo_cabedal(String PARAM) {
    codigo_cabedal = PARAM;
  }
  /**
    * DESCRICAO_ITEM: Method to get the field value.
    */
  public String getDescricao_item() {
    return descricao_item;
  }
  /**
    * DESCRICAO_ITEM: Method to set the field value.
    */
  public void setDescricao_item(String PARAM) {
    descricao_item = PARAM;
  }
  /**
    * CODIGO_COR: Method to get the field value.
    */
  public String getCodigo_cor() {
    return codigo_cor;
  }
  /**
    * CODIGO_COR: Method to set the field value.
    */
  public void setCodigo_cor(String PARAM) {
    codigo_cor = PARAM;
  }
  /**
    * CODIGO_GRADE: Method to get the field value.
    */
  public String getCodigo_grade() {
    return codigo_grade;
  }
  /**
    * CODIGO_GRADE: Method to set the field value.
    */
  public void setCodigo_grade(String PARAM) {
    codigo_grade = PARAM;
  }
  /**
    * QUANTIDADE_PARES: Method to get the field value.
    */
  public String getQuantidade_pares() {
    return quantidade_pares;
  }
  /**
    * QUANTIDADE_PARES: Method to set the field value.
    */
  public void setQuantidade_pares(String PARAM) {
    quantidade_pares = PARAM;
  }
  /**
    * PRECO_UNITARIO: Method to get the field value.
    */
  public String getPreco_unitario() {
    return preco_unitario;
  }
  /**
    * PRECO_UNITARIO: Method to set the field value.
    */
  public void setPreco_unitario(String PARAM) {
    preco_unitario = PARAM;
  }
  /**
    * REGISTRO_BANCO: Method to get the field value.
    */
  public String getRegistro_banco() {
    return registro_banco;
  }
  /**
    * REGISTRO_BANCO: Method to set the field value.
    */
  public void setRegistro_banco(String PARAM) {
    registro_banco = PARAM;
  }
  /**
    * REGISTRO_ALTERADO: Method to get the field value.
    */
  public String getRegistro_alterado() {
    return registro_alterado;
  }
  /**
    * REGISTRO_ALTERADO: Method to set the field value.
    */
  public void setRegistro_alterado(String PARAM) {
    registro_alterado = PARAM;
  }
  /**
    * LOJA_CLIENTE: Method to get the field value.
    */
  public String getLoja_cliente() {
    return loja_cliente;
  }
  /**
    * LOJA_CLIENTE: Method to set the field value.
    */
  public void setLoja_cliente(String PARAM) {
    loja_cliente = PARAM;
  }
  /**
    * DESCRICAO_ERRO: Method to get the field value.
    */
  public String getDescricao_erro() {
    return descricao_erro;
  }
  /**
    * DESCRICAO_ERRO: Method to set the field value.
    */
  public void setDescricao_erro(String PARAM) {
    descricao_erro = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    numero_pedido = null;
    codigo_cliente = null;
    cli_rzao = null;
    estabelecimento_cliente = null;
    data_pedido = null;
    nome_planilha = null;
    status = null;
    tem_alteracao = null;
    pos = null;
    gridCheckField = false;
    numero_pedido1 = null;
    numero_item = null;
    codigo_linha = null;
    codigo_referencia = null;
    codigo_corrugado = null;
    codigo_cabedal = null;
    descricao_item = null;
    codigo_cor = null;
    codigo_grade = null;
    quantidade_pares = null;
    preco_unitario = null;
    registro_banco = null;
    registro_alterado = null;
    loja_cliente = null;
    descricao_erro = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("insert_action,update_action,delete_action,", request)) {
      if (com.egen.util.text.Validate.isNull(codigo_cliente)) {
        errors.add("codigo_cliente", new ActionMessage("error.validate.notnull","Cliente","codigo_cliente","0"));
      }
      if (com.egen.util.text.Validate.isNull(data_pedido)) {
        errors.add("data_pedido", new ActionMessage("error.validate.notnull","Data pedido","data_pedido","0"));
      }
      if (!com.egen.util.text.Validate.isDate(data_pedido)) {
        errors.add("data_pedido", new ActionMessage("error.validate.date","Data pedido","data_pedido","0"));
      }
    }
    if (getGridCheckField()) {
      if (com.egen.util.text.Validate.isValidate("insert1_action,update1_action,delete1_action,", request)) {
        if (com.egen.util.text.Validate.isNull(numero_pedido1)) {
          errors.add("numero_pedido1", new ActionMessage("error.validate.notnull","Numero_pedido","numero_pedido1","1"));
        }
        if (com.egen.util.text.Validate.isNull(numero_item)) {
          errors.add("numero_item", new ActionMessage("error.validate.notnull","Seq.","numero_item","1"));
        }
        if (com.egen.util.text.Validate.isNull(registro_banco)) {
          errors.add("registro_banco", new ActionMessage("error.validate.notnull","registro_banco","registro_banco","1"));
        }
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
