package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 03/03/2006 17:00:05
 * Last Modify Date 22/06/2015 12:47:19
 */

public class CodigoBarraDun14ActionForm extends org.apache.struts.action.ActionForm
{
  public String cod_linha;
  public String lin_nome;
  public String cod_refer;
  public String ref_desc;
  public String cabedal;
  public String cab_desc;
  public String cor;
  public String cor_desc;
  public String gde_cdgo;
  public String status;
  public String lin_cdgo;
  public String ref_cdgo;
  public String ano_fatura_proforma;
  public String numero_fatura_proforma;
  private boolean valida = false;
  public CodigoBarraDun14ActionForm() {
  }
  /**
    * COD_LINHA: Método Gets para este campo
    */
  public String getCod_linha() {
    return cod_linha;
  }
  /**
    * COD_LINHA: Método Sets pára este campo.
    */
  public void setCod_linha(String PARAM) {
    cod_linha = PARAM;
  }
  /**
    * LIN_NOME: Método Gets para este campo
    */
  public String getLin_nome() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cod_linha != null && cod_linha.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Lin db_object = new portalbr.dbobj.table.Lin();
        String[][] select = {{"lin_nome",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(cod_linha)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          lin_nome = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
        } else {
          lin_nome = "";
        }
      }
    } catch (Exception e) {
      lin_nome = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return lin_nome;
  }

  public String[][] getLin_nome_Ajax(CodigoBarraDun14ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCod_linha() != null && PARAM.getCod_linha().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Lin db_object = new portalbr.dbobj.table.Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getCod_linha()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          list[0] = new String[]{"lin_nome", (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":""};
        } else {
          list[0] = new String[]{"lin_nome", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_nome", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }/**
    * LIN_NOME: Método Sets pára este campo.
    */

  public void setLin_nome(String PARAM) {
    lin_nome = PARAM;
  }
  /**
    * COD_REFER: Método Gets para este campo
    */
  public String getCod_refer() {
    return cod_refer;
  }
  /**
    * COD_REFER: Método Sets pára este campo.
    */
  public void setCod_refer(String PARAM) {
    cod_refer = PARAM;
  }
  /**
    * REF_DESC: Método Gets para este campo
    */
  public String getRef_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cod_linha != null && cod_linha.length() > 0 && cod_refer != null && cod_refer.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        String[][] select = {{"ref_desc",null}};
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cod_linha)}, {"ref_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cod_refer)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          ref_desc = (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":"";
        } else {
          ref_desc = "";
        }
      }
    } catch (Exception e) {
      ref_desc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return ref_desc;
  }

  public String[][] getRef_desc_Ajax(CodigoBarraDun14ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCod_linha() != null && PARAM.getCod_linha().length() > 0 && PARAM.getCod_refer() != null && PARAM.getCod_refer().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        Object[][] where = { {"lin_cdgo","=",PARAM.getCod_linha()}, {"ref_cdgo","=",PARAM.getCod_refer()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Ref) results.elementAt(0);
          list[0] = new String[]{"ref_desc", (db_object.getRef_desc() != null) ? db_object.getRef_desc() + "":""};
        } else {
          list[0] = new String[]{"ref_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"ref_desc", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * REF_DESC: Método Sets pára este campo.
    */
  public void setRef_desc(String PARAM) {
    ref_desc = PARAM;
  }
  /**
    * CABEDAL: Método Gets para este campo
    */
  public String getCabedal() {
    return cabedal;
  }
  /**
    * CABEDAL: Método Sets pára este campo.
    */
  public void setCabedal(String PARAM) {
    cabedal = PARAM;
  }
  /**
    * CAB_DESC: Método Gets para este campo
    */
  public String getCab_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cabedal != null && cabedal.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        String[][] select = {{"cab_desc",null}};
        Object[][] where = { {"cab_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cabedal)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cabedal) results.elementAt(0);
          cab_desc = (db_object.getCab_desc() != null) ? db_object.getCab_desc() + "":"";
        } else {
          cab_desc = "";
        }
      }
    } catch (Exception e) {
      cab_desc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return cab_desc;
  }

  public String[][] getCab_desc_Ajax(CodigoBarraDun14ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCabedal() != null && PARAM.getCabedal().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        Object[][] where = { {"cab_cdgo","=",PARAM.getCabedal()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cabedal) results.elementAt(0);
          list[0] = new String[]{"cab_desc", (db_object.getCab_desc() != null) ? db_object.getCab_desc() + "":""};
        } else {
          list[0] = new String[]{"cab_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cab_desc", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * CAB_DESC: Método Sets pára este campo.
    */
  public void setCab_desc(String PARAM) {
    cab_desc = PARAM;
  }
  /**
    * COR: Método Gets para este campo
    */
  public String getCor() {
    return cor;
  }
  /**
    * COR: Método Sets pára este campo.
    */
  public void setCor(String PARAM) {
    cor = PARAM;
  }
  /**
    * COR_DESC: Método Gets para este campo
    */
  public String getCor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cor != null && cor.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        String[][] select = {{"cor_desc",null}};
        Object[][] where = { {"cor_cdgo","=",com.egen.util.text.FormatNumber.toInt(cor)} };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Cor) results.elementAt(0);
          cor_desc = (db_object.getCor_desc() != null) ? db_object.getCor_desc() + "":"";
        } else {
          cor_desc = "";
        }
      }
    } catch (Exception e) {
      cor_desc = "";
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return cor_desc;
  }

  public String[][] getCor_desc_Ajax(CodigoBarraDun14ActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCor() != null && PARAM.getCor().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        Object[][] where = { {"cor_cdgo","like",PARAM.getCor()} };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Cor) results.elementAt(0);
          list[0] = new String[]{"cor_desc", (db_object.getCor_desc() != null) ? db_object.getCor_desc() + "":""};
        } else {
          list[0] = new String[]{"cor_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"cor_desc", ""};
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return list;
  }
  /**
    * COR_DESC: Método Sets pára este campo.
    */
  public void setCor_desc(String PARAM) {
    cor_desc = PARAM;
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
      statusList.addElement("A");
      statusLabelList.addElement("CodigoBarraDun14.ativas");
      statusList.addElement("I");
      statusLabelList.addElement("CodigoBarraDun14.inativas");
      statusList.addElement("");
      statusLabelList.addElement("CodigoBarraDun14.todas");
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
    * ANO_FATURA_PROFORMA: Método Gets para este campo
    */
  public String getAno_fatura_proforma() {
    return ano_fatura_proforma;
  }
  /**
    * ANO_FATURA_PROFORMA: Método Sets pára este campo.
    */
  public void setAno_fatura_proforma(String PARAM) {
    ano_fatura_proforma = PARAM;
  }
  /**
    * NUMERO_FATURA_PROFORMA: Método Gets para este campo
    */
  public String getNumero_fatura_proforma() {
    return numero_fatura_proforma;
  }
  /**
    * NUMERO_FATURA_PROFORMA: Método Sets pára este campo.
    */
  public void setNumero_fatura_proforma(String PARAM) {
    numero_fatura_proforma = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    cod_linha = null;
    lin_nome = null;
    cod_refer = null;
    ref_desc = null;
    cabedal = null;
    cab_desc = null;
    cor = null;
    cor_desc = null;
    gde_cdgo = null;
    status = null;
    lin_cdgo = null;
    ref_cdgo = null;
    ano_fatura_proforma = null;
    numero_fatura_proforma = null;
  }
  /**
    * Validação dos campos, retornando um ActionErrors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (com.egen.util.text.Validate.isValidate("select_action,", request)) {
      if (!com.egen.util.text.Validate.isNumber(cod_refer)) {
        errors.add("cod_refer", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.cod_refer"), "cod_refer","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(cabedal)) {
        errors.add("cabedal", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.cabedal"), "cabedal","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(cor)) {
        errors.add("cor", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.cor"), "cor","0"));
      }
      if (!com.egen.util.text.Validate.isNumber(gde_cdgo)) {
        errors.add("gde_cdgo", new ActionMessage("error.validate.number",java.util.ResourceBundle.getBundle("ComercialResources").getString("CodigoBarraDun14.gde_cdgo"), "gde_cdgo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
