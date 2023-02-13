package portalbr.direto;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 02/02/2016 17:12:44
 * Last Modify Date 24/02/2016 12:21:16
 */

public class CartaoCreditoActionForm extends org.apache.struts.action.ActionForm
{
  public String negociacao;
  public String bandeira;
  public String nome_titular;
  public String numero_cartao;
  public String mes_validade;
  public String ano_validade;
  public String codigo_seguranca;
  public String valor;
  public String condicao;
  public String tid1;
  private boolean valida = false;
  public CartaoCreditoActionForm() {
  }
  /**
    * NEGOCIACAO: Method to get the field value.
    */
  public String getNegociacao() {
    return negociacao;
  }
  /**
    * NEGOCIACAO: Method to set the field value.
    */
  public void setNegociacao(String PARAM) {
    negociacao = PARAM;
  }
  /**
    * BANDEIRA: Method to get the field value.
    */
  public String getBandeira() {
    return bandeira;
  }
  /**
    * BANDEIRA: Method to set the field value.
    */
  public void setBandeira(String PARAM) {
    bandeira = PARAM;
  }
  Vector bandeiraList = new Vector(10, 1);
  public java.util.Vector getBandeiraList() {
    if (bandeiraList == null || bandeiraList.size() == 0) {
      bandeiraList.addElement("visa");
      bandeiraLabelList.addElement("Visa");
      bandeiraList.addElement("mastercard");
      bandeiraLabelList.addElement("MasterCard");
    }
    java.util.Vector list = bandeiraList;
    return list;
  }
  java.util.Vector bandeiraLabelList = new Vector(10, 1);
  public java.util.Vector getBandeiraLabelList() {
    java.util.Vector list = bandeiraLabelList;
    return list;
  }
  /**
    * NOME_TITULAR: Method to get the field value.
    */
  public String getNome_titular() {
    return nome_titular;
  }
  /**
    * NOME_TITULAR: Method to set the field value.
    */
  public void setNome_titular(String PARAM) {
    nome_titular = PARAM;
  }
  /**
    * NUMERO_CARTAO: Method to get the field value.
    */
  public String getNumero_cartao() {
    return numero_cartao;
  }
  /**
    * NUMERO_CARTAO: Method to set the field value.
    */
  public void setNumero_cartao(String PARAM) {
    numero_cartao = PARAM;
  }
  /**
    * MES_VALIDADE: Method to get the field value.
    */
  public String getMes_validade() {
    return mes_validade;
  }
  /**
    * MES_VALIDADE: Method to set the field value.
    */
  public void setMes_validade(String PARAM) {
    mes_validade = PARAM;
  }
  Vector mes_validadeList = new Vector(10, 1);
  public java.util.Vector getMes_validadeList() {
    if (mes_validadeList == null || mes_validadeList.size() == 0) {
      mes_validadeList.addElement("1");
      mes_validadeLabelList.addElement("1");
      mes_validadeList.addElement("2");
      mes_validadeLabelList.addElement("2");
      mes_validadeList.addElement("3");
      mes_validadeLabelList.addElement("3");
      mes_validadeList.addElement("4");
      mes_validadeLabelList.addElement("4");
      mes_validadeList.addElement("5");
      mes_validadeLabelList.addElement("5");
      mes_validadeList.addElement("6");
      mes_validadeLabelList.addElement("6");
      mes_validadeList.addElement("7");
      mes_validadeLabelList.addElement("7");
      mes_validadeList.addElement("8");
      mes_validadeLabelList.addElement("8");
      mes_validadeList.addElement("9");
      mes_validadeLabelList.addElement("9");
      mes_validadeList.addElement("10");
      mes_validadeLabelList.addElement("10");
      mes_validadeList.addElement("11");
      mes_validadeLabelList.addElement("11");
      mes_validadeList.addElement("12");
      mes_validadeLabelList.addElement("12");
    }
    java.util.Vector list = mes_validadeList;
    return list;
  }
  java.util.Vector mes_validadeLabelList = new Vector(10, 1);
  public java.util.Vector getMes_validadeLabelList() {
    java.util.Vector list = mes_validadeLabelList;
    return list;
  }
  /**
    * ANO_VALIDADE: Method to get the field value.
    */
  public String getAno_validade() {
    return ano_validade;
  }
  /**
    * ANO_VALIDADE: Method to set the field value.
    */
  public void setAno_validade(String PARAM) {
    ano_validade = PARAM;
  }
  Vector ano_validadeList = new Vector(10, 1);
  public java.util.Vector getAno_validadeList() {
    if (ano_validadeList == null || ano_validadeList.size() == 0) {
      ano_validadeList.addElement("2016");
      ano_validadeLabelList.addElement("2016");
      ano_validadeList.addElement("2017");
      ano_validadeLabelList.addElement("2017");
      ano_validadeList.addElement("2018");
      ano_validadeLabelList.addElement("2018");
      ano_validadeList.addElement("2019");
      ano_validadeLabelList.addElement("2019");
      ano_validadeList.addElement("2020");
      ano_validadeLabelList.addElement("2020");
      ano_validadeList.addElement("2021");
      ano_validadeLabelList.addElement("2021");
      ano_validadeList.addElement("2022");
      ano_validadeLabelList.addElement("2022");
      ano_validadeList.addElement("2023");
      ano_validadeLabelList.addElement("2023");
      ano_validadeList.addElement("2024");
      ano_validadeLabelList.addElement("");
      ano_validadeList.addElement("2025");
      ano_validadeLabelList.addElement("");
      ano_validadeList.addElement("2026");
      ano_validadeLabelList.addElement("2026");
      ano_validadeList.addElement("2027");
      ano_validadeLabelList.addElement("2027");
      ano_validadeList.addElement("2028");
      ano_validadeLabelList.addElement("2028");
      ano_validadeList.addElement("2029");
      ano_validadeLabelList.addElement("2029");
      ano_validadeList.addElement("2030");
      ano_validadeLabelList.addElement("2030");
    }
    java.util.Vector list = ano_validadeList;
    return list;
  }
  java.util.Vector ano_validadeLabelList = new Vector(10, 1);
  public java.util.Vector getAno_validadeLabelList() {
    java.util.Vector list = ano_validadeLabelList;
    return list;
  }
  /**
    * CODIGO_SEGURANCA: Method to get the field value.
    */
  public String getCodigo_seguranca() {
    return codigo_seguranca;
  }
  /**
    * CODIGO_SEGURANCA: Method to set the field value.
    */
  public void setCodigo_seguranca(String PARAM) {
    codigo_seguranca = PARAM;
  }
  /**
    * VALOR: Method to get the field value.
    */
  public String getValor() {
    return valor;
  }
  /**
    * VALOR: Method to set the field value.
    */
  public void setValor(String PARAM) {
    valor = PARAM;
  }
  /**
    * CONDICAO: Method to get the field value.
    */
  public String getCondicao() {
    return condicao;
  }
  /**
    * CONDICAO: Method to set the field value.
    */
  public void setCondicao(String PARAM) {
    condicao = PARAM;
  }
  Vector condicaoList = new Vector(10, 1);
  public java.util.Vector getCondicaoList() {
    if (condicaoList == null || condicaoList.size() == 0) {
      condicaoList.addElement("1");
      condicaoLabelList.addElement("À Vista");
      condicaoList.addElement("2");
      condicaoLabelList.addElement("2x vezes");
      condicaoList.addElement("3");
      condicaoLabelList.addElement("3x vezes");
    }
    java.util.Vector list = condicaoList;
    return list;
  }
  java.util.Vector condicaoLabelList = new Vector(10, 1);
  public java.util.Vector getCondicaoLabelList() {
    java.util.Vector list = condicaoLabelList;
    return list;
  }
  /**
    * TID1: Method to get the field value.
    */
  public String getTid1() {
    return tid1;
  }
  /**
    * TID1: Method to set the field value.
    */
  public void setTid1(String PARAM) {
    tid1 = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    negociacao = null;
    bandeira = null;
    nome_titular = null;
    numero_cartao = null;
    mes_validade = null;
    ano_validade = null;
    codigo_seguranca = null;
    valor = null;
    condicao = null;
    tid1 = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("processar_action,", request)) {
      if (com.egen.util.text.Validate.isNull(negociacao)) {
        errors.add("negociacao", new ActionMessage("error.validate.notnull","Negociação","negociacao","0"));
      }
      if (com.egen.util.text.Validate.isNull(bandeira)) {
        errors.add("bandeira", new ActionMessage("error.validate.notnull","Bandeira","bandeira","0"));
      }
      if (com.egen.util.text.Validate.isNull(nome_titular)) {
        errors.add("nome_titular", new ActionMessage("error.validate.notnull","Nome do Titular","nome_titular","0"));
      }
      if (com.egen.util.text.Validate.isNull(numero_cartao)) {
        errors.add("numero_cartao", new ActionMessage("error.validate.notnull","Número do Cartão","numero_cartao","0"));
      }
      if (com.egen.util.text.Validate.isNull(mes_validade)) {
        errors.add("mes_validade", new ActionMessage("error.validate.notnull","Mês/Ano Validade","mes_validade","0"));
      }
      if (com.egen.util.text.Validate.isNull(ano_validade)) {
        errors.add("ano_validade", new ActionMessage("error.validate.notnull","ANO_VALIDADE","ano_validade","0"));
      }
      if (com.egen.util.text.Validate.isNull(codigo_seguranca)) {
        errors.add("codigo_seguranca", new ActionMessage("error.validate.notnull","Código de Segurança","codigo_seguranca","0"));
      }
      if (!com.egen.util.text.Validate.isMaxlength(codigo_seguranca, 3)) {
        errors.add("codigo_seguranca", new ActionMessage("error.validate.maxlength","Código de Segurança","codigo_seguranca","3","0"));
      }
      if (com.egen.util.text.Validate.isNull(valor)) {
        errors.add("valor", new ActionMessage("error.validate.notnull","Valor","valor","0"));
      }
      if (com.egen.util.text.Validate.isNull(condicao)) {
        errors.add("condicao", new ActionMessage("error.validate.notnull","Condição de Pagamento","condicao","0"));
      }
    }
    if (com.egen.util.text.Validate.isValidate("cancelar_action,", request)) {
      if (com.egen.util.text.Validate.isNull(tid1)) {
        errors.add("tid1", new ActionMessage("error.validate.notnull","TID","tid1","1"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
