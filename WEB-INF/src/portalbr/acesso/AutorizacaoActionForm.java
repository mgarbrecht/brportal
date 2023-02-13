package portalbr.acesso;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;

/**
 * Creation Date 10/02/2006 10:10:35
 * Last Modify Date 17/02/2006 13:56:55
 */

public class AutorizacaoActionForm extends org.apache.struts.action.ActionForm
{
  public String id;
  public String doin_id;
  public String doin_nome;
  public String tipo;
  public String tien_id;
  public String tien_tipo;
  public String tien_id_novo;
  public String tien_tipo_novo;
  public String enne_id;
  public String enne_descricao;
  public String enne_id_novo;
  public String enne_descricao_novo;
  public String usua_id;
  public String usua_nome;
  public String usua_id_novo;
  public String usua_nome_novo;
  public String negar_acesso;
  public String dias_consulta_retroativa;

  private boolean valida = false;
  public AutorizacaoActionForm() {
  }


  /**
    * DIAS_CONSULTA_RETROATIVA: Method to get the field value.
    */
  public String getDias_consulta_retroativa() {
    return dias_consulta_retroativa;
  }
  /**
    * DIAS_CONSULTA_RETROATIVA: Method to set the field value.
    */
  public void setDias_consulta_retroativa(String DIAS_CONSULTA_RETROATIVA) {
    dias_consulta_retroativa = DIAS_CONSULTA_RETROATIVA;
  }
  /**
    * ID: Method to get the field value.
    */
  public String getId() {
    return id;
  }
  /**
    * ID: Method to set the field value.
    */
  public void setId(String ID) {
    id = ID;
  }
  /**
    * DOIN_ID: Method to get the field value.
    */
  public String getDoin_id() {
    return doin_id;
  }
  /**
    * DOIN_ID: Method to set the field value.
    */
  public void setDoin_id(String DOIN_ID) {
    doin_id = DOIN_ID;
  }
  /**
    * DOIN_NOME: Method to get the field value.
    */
    public String getDoin_nome() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (doin_id != null && doin_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Documentos_interfaces db_object = new portalbr.dbobj.table.Documentos_interfaces();
        Object[][] where = { {"doin_id","=",com.egen.util.text.FormatNumber.toInteger(doin_id)} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Documentos_interfaces) results.elementAt(0);
          fieldRelationValue = (db_object.getDoin_nome() != null) ? db_object.getDoin_nome() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
           j.close();
           j = null;  
      }
    }
    doin_nome = fieldRelationValue;
    return doin_nome;
  }
  /**
    * DOIN_NOME: Method to set the field value.
    */
  public void setDoin_nome(String DOIN_NOME) {
    doin_nome = DOIN_NOME;
  }
  /**
    * TIPO: Method to get the field value.
    */
  public String getTipo() {
    return tipo;
  }
  /**
    * TIPO: Method to set the field value.
    */
  public void setTipo(String TIPO) {
    tipo = TIPO;
  }
  Vector tipoList = new Vector(10, 1);
  public java.util.Vector getTipoList() {
    if (tipoList == null || tipoList.size() == 0) {
      tipoList.addElement("1");
      tipoLabelList.addElement("--Selecione--");
      tipoList.addElement("tipo_entidade");
      tipoLabelList.addElement("Tipo Entidade");
      tipoList.addElement("entidade");
      tipoLabelList.addElement("Entidade");
      tipoList.addElement("usuario");
      tipoLabelList.addElement("Usuário");
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
    * TIEN_ID: Method to get the field value.
    */
  public String getTien_id() {
    return tien_id;
  }
  /**
    * TIEN_ID: Method to set the field value.
    */
  public void setTien_id(String TIEN_ID) {
    tien_id = TIEN_ID;
  }
  /**
    * TIEN_TIPO: Method to get the field value.
    */
  public String getTien_tipo() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tien_id != null && tien_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Tipos_entidade_negocio db_object = new portalbr.dbobj.table.Tipos_entidade_negocio();
        Object[][] where = { {"tien_id","=",com.egen.util.text.FormatNumber.toInteger(tien_id)} };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
           db_object = (portalbr.dbobj.table.Tipos_entidade_negocio) results.elementAt(0);
           fieldRelationValue = (db_object.getTien_tipo() != null) ? db_object.getTien_tipo() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
           j.close();
           j = null;
      }
    }
    tien_tipo = fieldRelationValue;
    return tien_tipo;
  }
  /**
    * TIEN_TIPO: Method to set the field value.
    */
  public void setTien_tipo(String TIEN_TIPO) {
    tien_tipo = TIEN_TIPO;
  }


  /**
    * TIEN_ID_NOVO: Method to get the field value.
    */
  public String getTien_id_novo() {
    return tien_id_novo;
  }
  /**
    * TIEN_ID_NOVO: Method to set the field value.
    */
  public void setTien_id_novo(String TIEN_ID_NOVO) {
    tien_id_novo = TIEN_ID_NOVO;
  }
  /**
    * TIEN_TIPO_NOVO: Method to get the field value.
    */
  public String getTien_tipo_novo() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (tien_id_novo != null && tien_id_novo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Tipos_entidade_negocio db_object = new portalbr.dbobj.table.Tipos_entidade_negocio();
        Object[][] where = {
                              {"tien_id","=",com.egen.util.text.FormatNumber.toInteger(tien_id_novo)}
                           };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
           db_object = (portalbr.dbobj.table.Tipos_entidade_negocio) results.elementAt(0);
           fieldRelationValue = (db_object.getTien_tipo() != null) ? db_object.getTien_tipo() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
           j.close();
           j = null;
      }
    }
    tien_tipo_novo = fieldRelationValue;
    return tien_tipo_novo;
  }
  /**
    * TIEN_TIPO_NOVO: Method to set the field value.
    */
  public void setTien_tipo_novo(String TIEN_TIPO_NOVO) {
    tien_tipo_novo = TIEN_TIPO_NOVO;
  }


  /**
    * ENNE_ID: Method to get the field value.
    */

  public String getEnne_id() {
    return enne_id;
  }
  /**
    * ENNE_ID: Method to set the field value.
    */
  public void setEnne_id(String ENNE_ID) {
    enne_id = ENNE_ID;
  }
  /**
    * ENNE_DESCRICAO: Method to get the field value.
    */
  public String getEnne_descricao() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (enne_id != null && enne_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Entidades_negocio db_object = new portalbr.dbobj.table.Entidades_negocio();
        Object[][] where = {
                              {"enne_id","=",com.egen.util.text.FormatNumber.toInteger(enne_id)}
                           };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
           db_object = (portalbr.dbobj.table.Entidades_negocio) results.elementAt(0);
           fieldRelationValue = (db_object.getEnne_descricao() != null) ? db_object.getEnne_descricao() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
           j.close();
           j = null;
      }
    }
    enne_descricao = fieldRelationValue;
    return enne_descricao;
  }
  /**
    * ENNE_DESCRICAO: Method to set the field value.
    */
  public void setEnne_descricao(String ENNE_DESCRICAO) {
    enne_descricao = ENNE_DESCRICAO;
  }


  /**
    * ENNE_ID_NOVO: Method to get the field value.
    */

  public String getEnne_id_novo() {
    return enne_id_novo;
  }
  /**
    * ENNE_ID_NOVO: Method to set the field value.
    */
  public void setEnne_id_novo(String ENNE_ID_NOVO) {
    enne_id_novo = ENNE_ID_NOVO;
  }
  /**
    * ENNE_DESCRICAO_NOVO: Method to get the field value.
    */
  public String getEnne_descricao_novo() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (enne_id_novo != null && enne_id_novo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Entidades_negocio db_object = new portalbr.dbobj.table.Entidades_negocio();
        Object[][] where = {
                              {"enne_id","=",com.egen.util.text.FormatNumber.toInteger(enne_id_novo)}
                           };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
           db_object = (portalbr.dbobj.table.Entidades_negocio) results.elementAt(0);
           fieldRelationValue = (db_object.getEnne_descricao() != null) ? db_object.getEnne_descricao() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
           j.close();
           j = null;
      }

    }
    enne_descricao_novo = fieldRelationValue;
    return enne_descricao_novo;
  }
  /**
    * ENNE_DESCRICAO_NOVO: Method to set the field value.
    */
  public void setEnne_descricao_novo(String ENNE_DESCRICAO_NOVO) {
    enne_descricao_novo = ENNE_DESCRICAO_NOVO;
  }


  /**
    * USUA_ID: Method to get the field value.
    */
  public String getUsua_id() {
    return usua_id;
  }
  /**
    * USUA_ID: Method to set the field value.
    */
  public void setUsua_id(String USUA_ID) {
    usua_id = USUA_ID;
  }
  /**
    * USUA_NOME: Method to get the field value.
    */
  public String getUsua_nome() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (usua_id != null && usua_id.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Usuarios db_object = new portalbr.dbobj.table.Usuarios();
        Object[][] where = {
                              {"usua_id","=",com.egen.util.text.FormatNumber.toInteger(usua_id)}
                           };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Usuarios) results.elementAt(0);
          fieldRelationValue = (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
           j.close();
           j = null;
      }
    }
    usua_nome = fieldRelationValue;
    return usua_nome;
  }
  /**
    * USUA_NOME: Method to set the field value.
    */
  public void setUsua_nome(String USUA_NOME) {
    usua_nome = USUA_NOME;
  }








  /**
    * USUA_ID_NOVO: Method to get the field value.
    */
  public String getUsua_id_novo() {
    return usua_id_novo;
  }
  /**
    * USUA_ID_NOVO: Method to set the field value.
    */
  public void setUsua_id_novo(String USUA_ID_NOVO) {
    usua_id_novo = USUA_ID_NOVO;
  }
  /**
    * USUA_NOME_NOVO: Method to get the field value.
    */
  public String getUsua_nome_novo() {
    String fieldRelationValue = "";
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      if (usua_id_novo != null && usua_id_novo.length() > 0) {
        j = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.table.Usuarios db_object = new portalbr.dbobj.table.Usuarios();
        Object[][] where = {
                              {"usua_id","=",com.egen.util.text.FormatNumber.toInteger(usua_id_novo)}
                           };
        java.util.Vector results = j.select(db_object, where, null);
        if (results != null && results.size() > 0) {
          db_object = (portalbr.dbobj.table.Usuarios) results.elementAt(0);
          fieldRelationValue = (db_object.getUsua_nome() != null) ? db_object.getUsua_nome() + "":"";
        }
      }
    } catch (Exception e) {
      fieldRelationValue = "";
    } finally {
      if (j != null) {
           j.close();
           j = null;
      }
    }
    usua_nome_novo = fieldRelationValue;
    return usua_nome_novo;
  }
  /**
    * USUA_NOME_NOVO: Method to set the field value.
    */
  public void setUsua_nome_novo(String USUA_NOME_NOVO) {
    usua_nome_novo = USUA_NOME_NOVO;
  }



  /**
    * NEGAR_ACESSO: Method to get the field value.
    */
  public String getNegar_acesso() {
    return negar_acesso;
  }
  /**
    * NEGAR_ACESSO: Method to set the field value.
    */
  public void setNegar_acesso(String NEGAR_ACESSO) {
    negar_acesso = NEGAR_ACESSO;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    id = null;
    doin_id = null;
    doin_nome = null;
    tipo = null;
    tien_id = null;
    tien_tipo = null;
    enne_id = null;
    enne_descricao = null;
    usua_id = null;
    usua_nome = null;
    negar_acesso = null;
    tien_id_novo = null;
    tien_tipo_novo = null;
    enne_id_novo = null;
    enne_descricao_novo = null;
    usua_id_novo = null;
    usua_nome_novo = null;
    dias_consulta_retroativa = null;
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
    
      if (tipo.equals("1")){
             errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Tipo","tipo","1"));
           }

    //  if (com.egen.util.text.Validate.isNull(doin_id)) {
    //    errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Documento","doin_id","1"));
    //  }
    //  if (!com.egen.util.text.Validate.isRegex(doin_id, "^[0-9]*$")) {
    //    errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.regex","Documento","doin_id","1"));
    //  }
   //   if(tipo.equals("tipo_entidade")){
    //       if (com.egen.util.text.Validate.isNull(tien_id)) {
    //         errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Tipo Entidade","tien_id","1"));
    //       }
   //        if (!com.egen.util.text.Validate.isRegex(tien_id, "^[0-9]*$")) {
   //          errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.regex","Tipo Entidade","tien_id","1"));
   //        }
   //   }

    //  if(tipo.equals("entidade")){
    //       if (com.egen.util.text.Validate.isNull(enne_id)) {
    //         errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Entidade","enne_id","1"));
    //       }
    //       if (!com.egen.util.text.Validate.isRegex(enne_id, "^[0-9]*$")) {
      //       errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.regex","Entidade","enne_id","1"));
      //     }
     // }

 //     if(tipo.equals("usuario")){
    //       if (com.egen.util.text.Validate.isNull(usua_id)) {
    //         errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.notnull","Usuário","usua_id","1"));
    //       }
       //    if (!com.egen.util.text.Validate.isRegex(usua_id, "^[0-9]*$")) {
       //      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.validate.regex","Usuário","usua_id","1"));
       //    }
   //   }
    }
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}
