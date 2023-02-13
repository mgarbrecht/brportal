package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/09/2014 08:49:14
 * Last Modify Date 22/06/2015 17:01:59
 */

public class VendaEstrategicosActionForm extends org.apache.struts.action.ActionForm
{
  public String marca_cdgo;
  public String marca_desc;
  public String lin_cdgo;
  public String lin_desc;
  public String ref_cdgo;
  public String ref_desc;
  public String cab_cdgo;
  public String cab_desc;
  public String cor_cdgo;
  public String cor_desc;
  public String tipo_estoque;
  public String qtde_ini;
  public String qtde_fim;
  public String grade;
  public String mix;
  public String cb_img_prod;
  public String cb_preco;
  public String cb_painel;
  private boolean valida = false;
  public VendaEstrategicosActionForm() {
  }
  /**
    * MARCA_CDGO: Método Gets para este campo
    */
  public String getMarca_cdgo() {
    return marca_cdgo;
  }
  /**
    * MARCA_CDGO: Método Sets pára este campo.
    */
  public void setMarca_cdgo(String PARAM) {
    marca_cdgo = PARAM;
  }
  /**
    * MARCA_DESC: Método Gets para este campo
    */
  public String getMarca_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (marca_cdgo != null && marca_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        String[][] select = { {"descricao_marca",null} };
        Object[][] where = { {"codigo_marca","=",com.egen.util.text.FormatNumber.toInt(marca_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          marca_desc = ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"");
        } else {
          marca_desc = "";
        }
      }
    } catch (Exception e) {
      marca_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return marca_desc;
  }

  public String[][] getMarca_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getMarca_cdgo() != null && PARAM.getMarca_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Marcas_produtos db_object = new Marcas_produtos();
        Object[][] where = { {"codigo_marca","like",PARAM.getMarca_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Marcas_produtos) results.elementAt(0);
          list[0] = new String[]{"marca_desc", ((db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"")};
        } else {
          list[0] = new String[]{"marca_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"marca_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * MARCA_DESC: Método Sets pára este campo.
    */
  public void setMarca_desc(String PARAM) {
    marca_desc = PARAM;
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
    * LIN_DESC: Método Gets para este campo
    */
  public String getLin_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        String[][] select = { {"lin_nome",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInt(lin_cdgo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          lin_desc = ((db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"");
        } else {
          lin_desc = "";
        }
      }
    } catch (Exception e) {
      lin_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return lin_desc;
  }

  public String[][] getLin_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Lin db_object = new Lin();
        Object[][] where = { {"lin_cdgo","like",PARAM.getLin_cdgo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Lin) results.elementAt(0);
          list[0] = new String[]{"lin_desc", ((db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"")};
        } else {
          list[0] = new String[]{"lin_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"lin_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIN_DESC: Método Sets pára este campo.
    */
  public void setLin_desc(String PARAM) {
    lin_desc = PARAM;
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
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (lin_cdgo != null && lin_cdgo.length() > 0 && ref_cdgo != null && ref_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        String[][] select = { {"ref_desc",null} };
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatNumber.toInteger(lin_cdgo)}, {"ref_cdgo","=",com.egen.util.text.FormatNumber.toInteger(ref_cdgo)}, };
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
      }
    }
    return ref_desc;
  }

  public String[][] getRef_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLin_cdgo() != null && PARAM.getLin_cdgo().length() > 0 && PARAM.getRef_cdgo() != null && PARAM.getRef_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Ref db_object = new Ref();
        Object[][] where = { {"lin_cdgo","=",com.egen.util.text.FormatDate.parseTimestamp(PARAM.getLin_cdgo(), "")}, {"ref_cdgo","=",com.egen.util.text.FormatDate.parseTimestamp(PARAM.getRef_cdgo(), "")}, };
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
    * CAB_CDGO: Método Gets para este campo
    */
  public String getCab_cdgo() {
    return cab_cdgo;
  }
  /**
    * CAB_CDGO: Método Sets pára este campo.
    */
  public void setCab_cdgo(String PARAM) {
    cab_cdgo = PARAM;
  }
  /**
    * CAB_DESC: Método Gets para este campo
    */
  public String getCab_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cab_cdgo != null && cab_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        String[][] select = { {"cab_desc",null} };
        Object[][] where = { {"cab_cdgo","=",com.egen.util.text.FormatNumber.toInteger(cab_cdgo)}, };
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
      }
    }
    return cab_desc;
  }

  public String[][] getCab_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCab_cdgo() != null && PARAM.getCab_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cabedal db_object = new Cabedal();
        Object[][] where = { {"cab_cdgo","=",com.egen.util.text.FormatDate.parseTimestamp(PARAM.getCab_cdgo(), "dd/MM/yyyy")}, };
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
    * COR_CDGO: Método Gets para este campo
    */
  public String getCor_cdgo() {
    return cor_cdgo;
  }
  /**
    * COR_CDGO: Método Sets pára este campo.
    */
  public void setCor_cdgo(String PARAM) {
    cor_cdgo = PARAM;
  }
  /**
    * COR_DESC: Método Gets para este campo
    */
  public String getCor_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (cor_cdgo != null && cor_cdgo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        String[][] select = { {"cor_desc",null} };
        Object[][] where = { {"cor_cdgo","=",com.egen.util.text.FormatNumber.toInt(cor_cdgo)}, };
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
      }
    }
    return cor_desc;
  }

  public String[][] getCor_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getCor_cdgo() != null && PARAM.getCor_cdgo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Cor db_object = new Cor();
        Object[][] where = { {"cor_cdgo","like",PARAM.getCor_cdgo()}, };
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
    * TIPO_ESTOQUE: Método Gets para este campo
    */
  public String getTipo_estoque() {
    return tipo_estoque;
  }
  /**
    * TIPO_ESTOQUE: Método Sets pára este campo.
    */
  public void setTipo_estoque(String PARAM) {
    tipo_estoque = PARAM;
  }
  /**
    * QTDE_INI: Método Gets para este campo
    */
  public String getQtde_ini() {
    return qtde_ini;
  }
  /**
    * QTDE_INI: Método Sets pára este campo.
    */
  public void setQtde_ini(String PARAM) {
    qtde_ini = PARAM;
  }
  /**
    * QTDE_FIM: Método Gets para este campo
    */
  public String getQtde_fim() {
    return qtde_fim;
  }
  /**
    * QTDE_FIM: Método Sets pára este campo.
    */
  public void setQtde_fim(String PARAM) {
    qtde_fim = PARAM;
  }
  /**
    * GRADE: Método Gets para este campo
    */
  public String getGrade() {
    return grade;
  }
  /**
    * GRADE: Método Sets pára este campo.
    */
  public void setGrade(String PARAM) {
    grade = PARAM;
  }
  /**
    * MIX: Método Gets para este campo
    */
  public String getMix() {
    return mix;
  }
  /**
    * MIX: Método Sets pára este campo.
    */
  public void setMix(String PARAM) {
    mix = PARAM;
  }
  Vector mixList = new Vector(10, 1);
  public java.util.Vector getMixList() {
    if (mixList == null || mixList.size() == 0) {
      mixList.addElement("T");
      mixLabelList.addElement("Todos");
      mixList.addElement("M");
      mixLabelList.addElement("No Mix");
      mixList.addElement("F");
      mixLabelList.addElement("Fora Mix");
    }
    java.util.Vector list = mixList;
    return list;
  }
  java.util.Vector mixLabelList = new Vector(10, 1);
  public java.util.Vector getMixLabelList() {
    java.util.Vector list = mixLabelList;
    return list;
  }
  /**
    * CB_IMG_PROD: Método Gets para este campo
    */
  public String getCb_img_prod() {
    return cb_img_prod;
  }
  /**
    * CB_IMG_PROD: Método Sets pára este campo.
    */
  public void setCb_img_prod(String PARAM) {
    cb_img_prod = PARAM;
  }
  /**
    * CB_PRECO: Método Gets para este campo
    */
  public String getCb_preco() {
    return cb_preco;
  }
  /**
    * CB_PRECO: Método Sets pára este campo.
    */
  public void setCb_preco(String PARAM) {
    cb_preco = PARAM;
  }
  /**
    * CB_PAINEL: Método Gets para este campo
    */
  public String getCb_painel() {
    return cb_painel;
  }
  /**
    * CB_PAINEL: Método Sets pára este campo.
    */
  public void setCb_painel(String PARAM) {
    cb_painel = PARAM;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    marca_cdgo = null;
    marca_desc = null;
    lin_cdgo = null;
    lin_desc = null;
    ref_cdgo = null;
    ref_desc = null;
    cab_cdgo = null;
    cab_desc = null;
    cor_cdgo = null;
    cor_desc = null;
    tipo_estoque = null;
    qtde_ini = null;
    qtde_fim = null;
    grade = null;
    mix = null;
    cb_img_prod = null;
    cb_preco = null;
    cb_painel = null;
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
      if (com.egen.util.text.Validate.isNull(marca_cdgo)) {
        errors.add("marca_cdgo", new ActionMessage("error.validate.notnull","Marca","marca_cdgo","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
