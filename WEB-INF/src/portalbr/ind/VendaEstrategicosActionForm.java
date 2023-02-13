package portalbr.ind;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 17/09/2014 08:49:14
 * Last Modify Date 17/09/2014 08:49:14
 */

public class VendaEstrategicosActionForm extends org.apache.struts.action.ActionForm
{
  public String emp_empresa;
  public String emp_desc;
  public String fil_filial;
  public String fil_desc;
  public String local_est;
  public String local_estoque_desc;
  public String comp;
  public String comp_desc;
  public String lin_cdgo;
  public String lin_desc;
  public String ref_cdgo;
  public String ref_desc;
  public String cab_cdgo;
  public String cab_desc;
  public String item_est;
  public String cor_cdgo;
  public String cor_desc;
  public String marca_cdgo;
  public String marca_desc;
  public String tipo_prod;
  public String tipo_prod_desc;
  public String grade;
  public String tipo_estoque;
  public String mix;
  public String cb_img_prod;
  public String cb_transito;
  public String cb_preco;
  public String cb_grade_quebrada;
  public String liv_codigo;
  public String liv_descri;
  public String cb_ignorar_95;
  public String qtde_ini;
  public String qtde_fim;
  public String data_inicial;
  public String data_final;
  public String ordenacao;
  private boolean valida = false;
  public VendaEstrategicosActionForm() {
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
    * EMP_DESC: Método Gets para este campo
    */
  public String getEmp_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (emp_empresa != null && emp_empresa.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        String[][] select = { {"emp_razsoc",null} };
        Object[][] where = { {"emp_empresa","like",emp_empresa}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Empresa) results.elementAt(0);
          emp_desc = ((db_object.getEmp_razsoc() != null) ? db_object.getEmp_razsoc() + "":"");
        } else {
          emp_desc = "";
        }
      }
    } catch (Exception e) {
      emp_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return emp_desc;
  }

  public String[][] getEmp_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getEmp_empresa() != null && PARAM.getEmp_empresa().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Empresa db_object = new Empresa();
        Object[][] where = { {"emp_empresa","like",PARAM.getEmp_empresa()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Empresa) results.elementAt(0);
          list[0] = new String[]{"emp_desc", ((db_object.getEmp_razsoc() != null) ? db_object.getEmp_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"emp_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"emp_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * EMP_DESC: Método Sets pára este campo.
    */
  public void setEmp_desc(String PARAM) {
    emp_desc = PARAM;
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
    * FIL_DESC: Método Gets para este campo
    */
  public String getFil_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fil_filial != null && fil_filial.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        String[][] select = { {"fil_razsoc",null} };
        Object[][] where = { {"fil_filial","like",fil_filial}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          fil_desc = ((db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"");
        } else {
          fil_desc = "";
        }
      }
    } catch (Exception e) {
      fil_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return fil_desc;
  }

  public String[][] getFil_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Filial db_object = new Filial();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Filial) results.elementAt(0);
          list[0] = new String[]{"fil_desc", ((db_object.getFil_razsoc() != null) ? db_object.getFil_razsoc() + "":"")};
        } else {
          list[0] = new String[]{"fil_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"fil_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * FIL_DESC: Método Sets pára este campo.
    */
  public void setFil_desc(String PARAM) {
    fil_desc = PARAM;
  }
  /**
    * LOCAL_EST: Método Gets para este campo
    */
  public String getLocal_est() {
    return local_est;
  }
  /**
    * LOCAL_EST: Método Sets pára este campo.
    */
  public void setLocal_est(String PARAM) {
    local_est = PARAM;
  }
  /**
    * LOCAL_ESTOQUE_DESC: Método Gets para este campo
    */
  public String getLocal_estoque_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (fil_filial != null && fil_filial.length() > 0 && local_est != null && local_est.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_localestoque db_object = new Jw_localestoque();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"fil_filial","like",fil_filial}, {"codigo","=",com.egen.util.text.FormatNumber.toInt(local_est)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_localestoque) results.elementAt(0);
          local_estoque_desc = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          local_estoque_desc = "";
        }
      }
    } catch (Exception e) {
      local_estoque_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return local_estoque_desc;
  }

  public String[][] getLocal_estoque_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getFil_filial() != null && PARAM.getFil_filial().length() > 0 && PARAM.getLocal_est() != null && PARAM.getLocal_est().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_localestoque db_object = new Jw_localestoque();
        Object[][] where = { {"fil_filial","like",PARAM.getFil_filial()}, {"codigo","like",PARAM.getLocal_est()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_localestoque) results.elementAt(0);
          list[0] = new String[]{"local_estoque_desc", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"local_estoque_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"local_estoque_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LOCAL_ESTOQUE_DESC: Método Sets pára este campo.
    */
  public void setLocal_estoque_desc(String PARAM) {
    local_estoque_desc = PARAM;
  }
  /**
    * COMP: Método Gets para este campo
    */
  public String getComp() {
    return comp;
  }
  /**
    * COMP: Método Sets pára este campo.
    */
  public void setComp(String PARAM) {
    comp = PARAM;
  }
  /**
    * COMP_DESC: Método Gets para este campo
    */
  public String getComp_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (comp != null && comp.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_comprometimentos db_object = new Jw_comprometimentos();
        String[][] select = { {"descricao",null} };
        Object[][] where = { {"codigo","=",com.egen.util.text.FormatNumber.toInt(comp)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_comprometimentos) results.elementAt(0);
          comp_desc = ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"");
        } else {
          comp_desc = "";
        }
      }
    } catch (Exception e) {
      comp_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return comp_desc;
  }

  public String[][] getComp_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getComp() != null && PARAM.getComp().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_comprometimentos db_object = new Jw_comprometimentos();
        Object[][] where = { {"codigo","like",PARAM.getComp()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_comprometimentos) results.elementAt(0);
          list[0] = new String[]{"comp_desc", ((db_object.getDescricao() != null) ? db_object.getDescricao() + "":"")};
        } else {
          list[0] = new String[]{"comp_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"comp_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * COMP_DESC: Método Sets pára este campo.
    */
  public void setComp_desc(String PARAM) {
    comp_desc = PARAM;
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
    * ITEM_EST: Método Gets para este campo
    */
  public String getItem_est() {
    return item_est;
  }
  /**
    * ITEM_EST: Método Sets pára este campo.
    */
  public void setItem_est(String PARAM) {
    item_est = PARAM;
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
    * TIPO_PROD: Método Gets para este campo
    */
  public String getTipo_prod() {
    return tipo_prod;
  }
  /**
    * TIPO_PROD: Método Sets pára este campo.
    */
  public void setTipo_prod(String PARAM) {
    tipo_prod = PARAM;
  }
  /**
    * TIPO_PROD_DESC: Método Gets para este campo
    */
  public String getTipo_prod_desc() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tipo_prod != null && tipo_prod.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_tipo_produto db_object = new Jw_tipo_produto();
        String[][] select = { {"descricao_grupo",null} };
        Object[][] where = { {"codigo_grupo","=",com.egen.util.text.FormatNumber.toInt(tipo_prod)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_tipo_produto) results.elementAt(0);
          tipo_prod_desc = ((db_object.getDescricao_grupo() != null) ? db_object.getDescricao_grupo() + "":"");
        } else {
          tipo_prod_desc = "";
        }
      }
    } catch (Exception e) {
      tipo_prod_desc = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return tipo_prod_desc;
  }

  public String[][] getTipo_prod_desc_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getTipo_prod() != null && PARAM.getTipo_prod().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Jw_tipo_produto db_object = new Jw_tipo_produto();
        Object[][] where = { {"codigo_grupo","=",com.egen.util.text.FormatNumber.toInt(PARAM.getTipo_prod())}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Jw_tipo_produto) results.elementAt(0);
          list[0] = new String[]{"tipo_prod_desc", ((db_object.getDescricao_grupo() != null) ? db_object.getDescricao_grupo() + "":"")};
        } else {
          list[0] = new String[]{"tipo_prod_desc", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"tipo_prod_desc", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * TIPO_PROD_DESC: Método Sets pára este campo.
    */
  public void setTipo_prod_desc(String PARAM) {
    tipo_prod_desc = PARAM;
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
    * CB_TRANSITO: Método Gets para este campo
    */
  public String getCb_transito() {
    return cb_transito;
  }
  /**
    * CB_TRANSITO: Método Sets pára este campo.
    */
  public void setCb_transito(String PARAM) {
    cb_transito = PARAM;
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
    * CB_GRADE_QUEBRADA: Método Gets para este campo
    */
  public String getCb_grade_quebrada() {
    return cb_grade_quebrada;
  }
  /**
    * CB_GRADE_QUEBRADA: Método Sets pára este campo.
    */
  public void setCb_grade_quebrada(String PARAM) {
    cb_grade_quebrada = PARAM;
  }
  /**
    * LIV_CODIGO: Método Gets para este campo
    */
  public String getLiv_codigo() {
    return liv_codigo;
  }
  /**
    * LIV_CODIGO: Método Sets pára este campo.
    */
  public void setLiv_codigo(String PARAM) {
    liv_codigo = PARAM;
  }
  /**
    * LIV_DESCRI: Método Gets para este campo
    */
  public String getLiv_descri() {
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (liv_codigo != null && liv_codigo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Livro db_object = new Livro();
        String[][] select = { {"liv_descri",null} };
        Object[][] where = { {"liv_codigo","=",com.egen.util.text.FormatNumber.toInt(liv_codigo)}, };
        String[] group = null;
        String[] having = null;
        String[] order = null;
        java.util.Vector results = j.select(db_object, select, where, group, having, order);
        if (results != null && results.size() > 0) {
          db_object = (Livro) results.elementAt(0);
          liv_descri = (db_object.getLiv_descri() != null) ? db_object.getLiv_descri() + "":"";
        } else {
          liv_descri = "";
        }
      }
    } catch (Exception e) {
      liv_descri = "";
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return liv_descri;
  }

  public String[][] getLiv_descri_Ajax(VendaEstrategicosActionForm PARAM) {
    String[][] list = new String[1][2];
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (PARAM.getLiv_codigo() != null && PARAM.getLiv_codigo().length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        Livro db_object = new Livro();
        Object[][] where = { {"liv_codigo","like",PARAM.getLiv_codigo()}, };
        String[] order = null;
        java.util.Vector results = j.select(db_object, where, order);
        if (results != null && results.size() > 0) {
          db_object = (Livro) results.elementAt(0);
          list[0] = new String[]{"liv_descri", (db_object.getLiv_descri() != null) ? db_object.getLiv_descri() + "":""};
        } else {
          list[0] = new String[]{"liv_descri", ""};
        }
      }
    } catch (Exception e) {
      list[0] = new String[]{"liv_descri", ""};
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return list;
  }
  /**
    * LIV_DESCRI: Método Sets pára este campo.
    */
  public void setLiv_descri(String PARAM) {
    liv_descri = PARAM;
  }
  /**
    * CB_IGNORAR_95: Método Gets para este campo
    */
  public String getCb_ignorar_95() {
    return cb_ignorar_95;
  }
  /**
    * CB_IGNORAR_95: Método Sets pára este campo.
    */
  public void setCb_ignorar_95(String PARAM) {
    cb_ignorar_95 = PARAM;
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
    * DATA_INICIAL: Método Gets para este campo
    */
  public String getData_inicial() {
    return data_inicial;
  }
  /**
    * DATA_INICIAL: Método Sets pára este campo.
    */
  public void setData_inicial(String PARAM) {
    data_inicial = PARAM;
  }
  /**
    * DATA_FINAL: Método Gets para este campo
    */
  public String getData_final() {
    return data_final;
  }
  /**
    * DATA_FINAL: Método Sets pára este campo.
    */
  public void setData_final(String PARAM) {
    data_final = PARAM;
  }
  /**
    * ORDENACAO: Método Gets para este campo
    */
  public String getOrdenacao() {
    return ordenacao;
  }
  /**
    * ORDENACAO: Método Sets pára este campo.
    */
  public void setOrdenacao(String PARAM) {
    ordenacao = PARAM;
  }
  Vector ordenacaoList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoList() {
    if (ordenacaoList == null || ordenacaoList.size() == 0) {
      ordenacaoList.addElement("les_lin_ref");
      ordenacaoLabelList.addElement("Local/Linha/Ref");
      ordenacaoList.addElement("normal");
      ordenacaoLabelList.addElement("Emp/Fil/Les/Tes/Tco/Modelo");
      ordenacaoList.addElement("linha");
      ordenacaoLabelList.addElement("Linha/Ref");
      ordenacaoList.addElement("les");
      ordenacaoLabelList.addElement("Les/Tes/Tco/Modelo");
      ordenacaoList.addElement("fil_lin_ref");
      ordenacaoLabelList.addElement("Filial/Linha/Ref");
    }
    java.util.Vector list = ordenacaoList;
    return list;
  }
  java.util.Vector ordenacaoLabelList = new Vector(10, 1);
  public java.util.Vector getOrdenacaoLabelList() {
    java.util.Vector list = ordenacaoLabelList;
    return list;
  }
  /**
    * Limpar todos os campos.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    emp_empresa = null;
    emp_desc = null;
    fil_filial = null;
    fil_desc = null;
    local_est = null;
    local_estoque_desc = null;
    comp = null;
    comp_desc = null;
    lin_cdgo = null;
    lin_desc = null;
    ref_cdgo = null;
    ref_desc = null;
    cab_cdgo = null;
    cab_desc = null;
    item_est = null;
    cor_cdgo = null;
    cor_desc = null;
    marca_cdgo = null;
    marca_desc = null;
    tipo_prod = null;
    tipo_prod_desc = null;
    grade = null;
    tipo_estoque = null;
    mix = null;
    cb_img_prod = null;
    cb_transito = null;
    cb_preco = null;
    cb_grade_quebrada = null;
    liv_codigo = null;
    liv_descri = null;
    cb_ignorar_95 = null;
    qtde_ini = null;
    qtde_fim = null;
    data_inicial = null;
    data_final = null;
    ordenacao = null;
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
      if (com.egen.util.text.Validate.isNull(emp_empresa)) {
        errors.add("emp_empresa", new ActionMessage("error.validate.notnull","Empresa","emp_empresa","0"));
      }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
