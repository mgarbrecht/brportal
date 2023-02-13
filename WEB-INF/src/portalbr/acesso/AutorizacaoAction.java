package portalbr.acesso;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;

/**
 * Creation Date 10/02/2006 10:10:35
 * Last Modify Date 02/07/2015 14:14:43
 */

public class AutorizacaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    ActionForward actionForward = null;
    try {
      AutorizacaoActionForm f = (AutorizacaoActionForm) form;
      /*
              if(f.getTipo().equals("usuario") && (!f.getUsua_id().equals(""))){
                 actionForward = new ActionForward("/acesso/AutorizacaoForm.do?tipo=usuario&usua_id="+f.getUsua_id(), true);
              } else if(f.getTipo().equals("entidade") && (!f.getEnne_id().equals(""))){
                 actionForward = new ActionForward("/acesso/AutorizacaoForm.do?tipo=entidade&enne_id="+f.getEnne_id(), true);
              } else if(f.getTipo().equals("tipo_entidade") && (!f.getTien_id().equals(""))){
                 actionForward = new ActionForward("/acesso/AutorizacaoForm.do?tipo=tipo_entidade&tien_id="+f.getTien_id(), true);
              } else {
                 actionForward = mapping.findForward("same");
              }
          */

      request.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_pop_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    ActionForward actionForward = null;
    try {
      request.setAttribute("AutorizacaoActionForm", form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }


  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 10/02/2006
    // Data de Alteração :
    //------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    AutorizacaoActionForm f = (AutorizacaoActionForm) form;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn());
      if (!(f.getDoin_id().equals(""))) {
        acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn(), Integer.parseInt(f.getDoin_id()));
        autorizacao.setDocumentoInterface((acesso.DocumentoInterface) documento);
        //--temporario--
        if ((!(f.getDias_consulta_retroativa().equals("")))) {
          autorizacao.setDiasConsultaRetroativa(Integer.parseInt(f.getDias_consulta_retroativa()));
        } else {
          autorizacao.setDiasConsultaRetroativa(0);
        }
      }
      //--------------------------------------------------------------------------------------
      if (f.getTipo().equals("usuario")) {
        if (!(f.getUsua_id().equals(""))) {
          acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn(), Integer.parseInt(f.getUsua_id()));
          autorizacao.setUsuario((acesso.Usuario) usuario);
        }
        if ((f.getNegar_acesso() + "").equals("S")) {
          autorizacao.revogarUsuario();
        } else {
          autorizacao.autorizarUsuario();
        }
      }
      //--------------------------------------------------------------------------------------
      if (f.getTipo().equals("tipo_entidade")) {
        if (!(f.getTien_id().equals(""))) {
          acesso.TipoEntidadeNegocioAPI tipo_entidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getTien_id()));
          autorizacao.setTipoEntidadeNegocio((acesso.TipoEntidadeNegocio) tipo_entidade);
        }
      }
      //--------------------------------------------------------------------------------------
      if (f.getTipo().equals("entidade")) {
        if (!(f.getEnne_id().equals(""))) {
          acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getEnne_id()));
          autorizacao.setEntidadeNegocio((acesso.EntidadeNegocio) entidade);
        }
      }
      //--------------------------------------------------------------------------------------
      autorizacao.insert();
      //-------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    f.setId("");
    f.setDoin_id("");
    f.setDoin_nome("");
    session.setAttribute(mapping.getName(), form);
    return actionForward;
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //------------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 10/02/2006
    // Data de Alteração :
    //------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AutorizacaoActionForm f = (AutorizacaoActionForm) form;
      acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn());
      acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn(), Integer.parseInt(f.getDoin_id()));
      autorizacao.setDocumentoInterface((acesso.DocumentoInterface) documento);
      if (f.getTipo().equals("usuario")) {
        acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn(), Integer.parseInt(f.getUsua_id()));
        autorizacao.setUsuario((acesso.Usuario) usuario);
        if ((f.getNegar_acesso() + "").equals("S")) {
          autorizacao.revogarUsuario();
        } else {
          autorizacao.autorizarUsuario();
        }
      }

      if (f.getTipo().equals("tipo_entidade")) {
        acesso.TipoEntidadeNegocioAPI tipo_entidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getTien_id()));
        autorizacao.setTipoEntidadeNegocio((acesso.TipoEntidadeNegocio) tipo_entidade);
      }

      if (f.getTipo().equals("entidade")) {
        acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getEnne_id()));
        autorizacao.setEntidadeNegocio((acesso.EntidadeNegocio) entidade);
      }
      //  autorizacao.update();

      //-------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    return actionForward;
  }
  public ActionForward perform_delete_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //-----------------------------------------
    // Autor             : Mateus Garbrecht
    // Data de Criação   : 10/02/2006
    // Data de Alteração :
    //------------------------------------------

    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    AutorizacaoActionForm f = (AutorizacaoActionForm) form;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      if (f.getTipo().equals("usuario")) {
        acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn(), acesso.AutorizacaoDocumentoInterfaceAPI.ClassificadorAcesso.USUARIO, Integer.parseInt(f.getId()));
        autorizacao.delete();
      }

      if (f.getTipo().equals("tipo_entidade")) {
        acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn(), acesso.AutorizacaoDocumentoInterfaceAPI.ClassificadorAcesso.TIPO_ENTIDADE_NEGOCIO, Integer.parseInt(f.getId()));
        autorizacao.delete();
      }

      if (f.getTipo().equals("entidade")) {
        acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn(), acesso.AutorizacaoDocumentoInterfaceAPI.ClassificadorAcesso.ENTIDADE_NEGOCIO, Integer.parseInt(f.getId()));
        autorizacao.delete();
      }
      //--------------------------------------------------------------------------

      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }

    f.setId("");
    f.setDoin_id("");
    f.setDoin_nome("");
    f.setNegar_acesso("");
    session.setAttribute(mapping.getName(), form);
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    ActionForward actionForward = null;
    try {
      AutorizacaoActionForm f = (AutorizacaoActionForm) form;
      form.reset(mapping, request);
      request.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      request.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_copiar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {

      j = new com.egen.util.jdbc.JdbcUtil();
      AutorizacaoActionForm f = (AutorizacaoActionForm) form;
      portalbr.dbobj.view.Jw_acessos_usuarios table = new portalbr.dbobj.view.Jw_acessos_usuarios();
      String[][] select = null;
      Object[][] where = { {"Acus_usua_id","=", com.egen.util.text.FormatNumber.toInteger(f.getUsua_id_novo())} };
      Vector res_Jw_acessos_usuarios = j.select(table, select, where, null, null, null);
      if (res_Jw_acessos_usuarios != null && res_Jw_acessos_usuarios.size() > 0) {
        throw new Exception("O Usuário de destino já possui permissões!");
      }

      //----------------------------------
      Object[][] where2 = { {"Acus_usua_id","=", com.egen.util.text.FormatNumber.toInteger(f.getUsua_id())} };
      res_Jw_acessos_usuarios = j.select(table, select, where2, null, null, null);
      //----------------------------------


      if (res_Jw_acessos_usuarios != null && res_Jw_acessos_usuarios.size() > 0) {
        acesso.UsuarioAPI usuario = new acesso.UsuarioAPI(j.getConn(), Integer.parseInt(f.getUsua_id_novo()));
        for (int x = 0; x < res_Jw_acessos_usuarios.size(); x++) {
          portalbr.dbobj.view.Jw_acessos_usuarios r = (portalbr.dbobj.view.Jw_acessos_usuarios) res_Jw_acessos_usuarios.elementAt(x);
          acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn(), r.getAcus_doin_id());
          acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn());
          autorizacao.setDocumentoInterface((acesso.DocumentoInterface) documento);
          autorizacao.setUsuario((acesso.Usuario) usuario);

          if ((r.getAcus_negar_acesso() + "").equals("S")) {
            autorizacao.revogarUsuario();
          } else {
            autorizacao.autorizarUsuario();
          }
          autorizacao.insert();
        }
      }
      //-----------------------------------------------------------------------------------------
      //    int doin_id = 0;
      //    acesso.AcessoDocumentoInterfaceAPI documento = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
      //      for(int x=0; x<res_Jw_acessos_usuarios.size(); x++) {
      //        portalbr.dbobj.view.Jw_acessos_usuarios r = (portalbr.dbobj.view.Jw_acessos_usuarios) res_Jw_acessos_usuarios.elementAt(x);
      //        doin_id = r.getAcus_doin_id();
      //        documento.geraAutorizacoes(doin_id);
      //      }
      //-----------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  public ActionForward perform_copiar_entidade_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      //  String driver = util.rdb.ConnectionJDBC.getJdbcDriver("orasco");
      //  String url = util.rdb.ConnectionJDBC.getJdbcURL("orasco");
      //  j = new com.egen.util.jdbc.JdbcUtil("wbrio","wbrio",url,driver);
      j = new com.egen.util.jdbc.JdbcUtil();
      AutorizacaoActionForm f = (AutorizacaoActionForm) form;

      portalbr.dbobj.table.Acessos_entidades_negocio table = new portalbr.dbobj.table.Acessos_entidades_negocio();
      String[][] select = null;
      Object[][] where = { {"Acen_enne_id","=", com.egen.util.text.FormatNumber.toInteger(f.getEnne_id_novo())} };
      Vector res_Acessos_entidades_negocio = j.select(table, select, where, null, null, null);
      if (res_Acessos_entidades_negocio != null && res_Acessos_entidades_negocio.size() > 0) {
        throw new Exception("A Entidade de destino já possui permissões!");
      }

      //----------------------------------
      Object[][] where2 = { {"Acen_enne_id","=", com.egen.util.text.FormatNumber.toInteger(f.getEnne_id())} };
      res_Acessos_entidades_negocio = j.select(table, select, where2, null, null, null);
      //----------------------------------


      if (res_Acessos_entidades_negocio != null && res_Acessos_entidades_negocio.size() > 0) {
        for (int x = 0; x < res_Acessos_entidades_negocio.size(); x++) {
          portalbr.dbobj.table.Acessos_entidades_negocio r = (portalbr.dbobj.table.Acessos_entidades_negocio) res_Acessos_entidades_negocio.elementAt(x);
          acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn());
          acesso.EntidadeNegocioAPI entidade = new acesso.EntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getEnne_id_novo()));
          autorizacao.setEntidadeNegocio((acesso.EntidadeNegocio) entidade);
          acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn(), r.getAcen_doin_id());
          autorizacao.setDocumentoInterface((acesso.DocumentoInterface) documento);
          autorizacao.insert();
        }
      }

      //-----------------------------------------------------------------------------------------
      //    int doin_id = 0;
      //    acesso.AcessoDocumentoInterfaceAPI documento = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
      //      for(int x=0; x<res_Acessos_entidades_negocio.size(); x++) {
      //        portalbr.dbobj.table.Acessos_entidades_negocio r = (portalbr.dbobj.table.Acessos_entidades_negocio) res_Acessos_entidades_negocio.elementAt(x);
      //        doin_id = r.getAcen_doin_id();
      //        documento.geraAutorizacoes(doin_id);
      //      }
      //-----------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  public ActionForward perform_copiar_tipo_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      String driver = util.rdb.ConnectionJDBC.getJdbcDriver("orasco");
      String url = util.rdb.ConnectionJDBC.getJdbcURL("orasco");
      j = new com.egen.util.jdbc.JdbcUtil("wbrio","wbrio",url, driver);
      AutorizacaoActionForm f = (AutorizacaoActionForm) form;

      portalbr.dbobj.table.Acessos_tipos_entidade_negocio table = new portalbr.dbobj.table.Acessos_tipos_entidade_negocio();
      String[][] select = null;
      Object[][] where = { {"Aten_tien_id","=", com.egen.util.text.FormatNumber.toInteger(f.getTien_id_novo())} };
      Vector res_Acessos_tipos_entidade_negocio = j.select(table, select, where, null, null, null);
      if (res_Acessos_tipos_entidade_negocio != null && res_Acessos_tipos_entidade_negocio.size() > 0) {
        throw new Exception("O Tipo de Entidade de destino já possui permissões!");
      }

      //----------------------------------
      Object[][] where2 = { {"Aten_tien_id","=", com.egen.util.text.FormatNumber.toInteger(f.getTien_id())} };
      res_Acessos_tipos_entidade_negocio = j.select(table, select, where2, null, null, null);
      //----------------------------------


      if (res_Acessos_tipos_entidade_negocio != null && res_Acessos_tipos_entidade_negocio.size() > 0) {
        for (int x = 0; x < res_Acessos_tipos_entidade_negocio.size(); x++) {
          portalbr.dbobj.table.Acessos_tipos_entidade_negocio r = (portalbr.dbobj.table.Acessos_tipos_entidade_negocio) res_Acessos_tipos_entidade_negocio.elementAt(x);
          acesso.AutorizacaoDocumentoInterfaceAPI autorizacao = new acesso.AutorizacaoDocumentoInterfaceAPI(j.getConn());
          acesso.TipoEntidadeNegocioAPI tipo_entidade = new acesso.TipoEntidadeNegocioAPI(j.getConn(), Integer.parseInt(f.getTien_id_novo()));
          autorizacao.setTipoEntidadeNegocio((acesso.TipoEntidadeNegocio) tipo_entidade);
          acesso.DocumentoInterfaceAPI documento = new acesso.DocumentoInterfaceAPI(j.getConn(), r.getAten_doin_id());
          autorizacao.setDocumentoInterface((acesso.DocumentoInterface) documento);
          autorizacao.insert();
        }
      }

      //-----------------------------------------------------------------------------------------
      //    int doin_id = 0;
      //    acesso.AcessoDocumentoInterfaceAPI documento = new acesso.AcessoDocumentoInterfaceAPI(j.getConn());
      //      for(int x=0; x<res_Acessos_tipos_entidade_negocio.size(); x++) {
      //        portalbr.dbobj.table.Acessos_tipos_entidade_negocio r = (portalbr.dbobj.table.Acessos_tipos_entidade_negocio) res_Acessos_tipos_entidade_negocio.elementAt(x);
      //        doin_id = r.getAten_doin_id();
      //        documento.geraAutorizacoes(doin_id);
      //      }
      //-----------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  public ActionForward perform_gerar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      AutorizacaoActionForm f = (AutorizacaoActionForm) form;
      //-----------------------------------------------------------------------------------------


      acesso.Autorizacoes autorizacoes = new acesso.Autorizacoes();
      String tipoGeracao = null;
      if (f.getTipo().equalsIgnoreCase("tipo_entidade")) {
        tipoGeracao = "T";
        autorizacoes.setTienId(Integer.parseInt(f.getTien_id()));
      } else if (f.getTipo().equalsIgnoreCase("entidade")) {
        tipoGeracao = "E";
        autorizacoes.setEnneId(Integer.parseInt(f.getEnne_id()));
      } else if (f.getTipo().equalsIgnoreCase("usuario")) {
        tipoGeracao = "U";
        autorizacoes.setUsuaId(Integer.parseInt(f.getUsua_id()));
      }
      if (f.getDoin_id() != "") {
        autorizacoes.setDoinId(Integer.parseInt(f.getDoin_id()));
      }
      autorizacoes.setTipoGeracao(tipoGeracao);
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception", autorizacoes.gerar()));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);


      //-----------------------------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void tg_gerar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  public ActionForward perform_atualiza_arvore_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      session.removeAttribute("treeAcesso");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
