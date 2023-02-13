package portalbr.adm;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import com.egen.util.jdbc.*;
import com.egen.util.text.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 09/12/2005 14:55:19
 * Last Modify Date 10/12/2020 14:12:57
 */

public class Clientes_atendidosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    Clientes_atendidosActionForm f = (Clientes_atendidosActionForm) form;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      session.setAttribute("ca_consulta_saldo_limite_credito","N");
      session.setAttribute("ca_consulta_clientes","N");
      session.setAttribute("ca_consulta_grupos","N");
      session.setAttribute("ca_consulta_cidades","N");
      session.setAttribute("ca_consulta_segmentos","N");
      session.setAttribute("ca_consulta_regionais","N");
      session.setAttribute("ca_abrir_meses", "N");
      if ((f.getCb_saldo_limite_credito() + "").equals("S")) {
        session.setAttribute("ca_consulta_saldo_limite_credito","S");
      }
      if ((f.getCb_consulta_clientes() + "").equals("S")) {
        session.setAttribute("ca_consulta_clientes","S");
      }
      if ((f.getCb_consulta_grupos() + "").equals("S")) {
        session.setAttribute("ca_consulta_grupos","S");
      }
      if ((f.getCb_consulta_cidades() + "").equals("S")) {
        session.setAttribute("ca_consulta_cidades","S");
      }
      if ((f.getCb_consulta_segmentos() + "").equals("S")) {
        session.setAttribute("ca_consulta_segmentos","S");
      }
      if ((f.getCb_consulta_regionais() + "").equals("S")) {
        session.setAttribute("ca_consulta_regionais","S");
      }
      if ((f.getCb_abrir_meses() + "").equals("S")) {
        session.setAttribute("ca_abrir_meses","S");
      }

      if ((!(f.getCb_consulta_cidades() + "").equals("S")) && (!(f.getCb_consulta_clientes() + "").equals("S")) && (!(f.getCb_consulta_grupos() + "").equals("S"))) {
        throw new Exception("Ao menos uma das opções de visualização deve ser informada!");
      }

      if (f.getOrdenacao().equals("0")) {
        throw new Exception("O Tipo deve ser informado!");
      }
      j = new com.egen.util.jdbc.JdbcUtil();
      Date d1 = FormatDate.parse(f.getDt_inicial());
      Date d2 = FormatDate.parse(f.getDt_final());
      if (d2.before(d1)) {
        throw new Exception("A Data Final não pode ser menor que a Data Inicial!");
      }

      //-------------------------------------------------
      String parametros = "";
      session.setAttribute("codigo_regional","null");
      session.setAttribute("codigo_marca","null");
      session.setAttribute("lin_cdgo","null");

      session.setAttribute("situacao_representante","null");
      session.setAttribute("situacao_representante_marca","null");
      session.setAttribute("situacao_cliente_representante","null");

      session.setAttribute("codigo_marcad","null");
      session.setAttribute("lin_cdgod","null");

      acesso.Usuario u = new acesso.Usuario();
      u = (acesso.Usuario) session.getAttribute("User");
      acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
      acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
      if (!(u.getEntidadeNegocio() == null)) {
        ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
        tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      }

      /* --- descomentar se for utilizada validação por período ---
              if(u.getDiasConsultaRetroativa()!=null && u.getDiasConsultaRetroativa()>0){
                  if(FormatDate.parseDate(f.getDt_inicial()).before(FormatDate.addDate(new Date(),-u.getDiasConsultaRetroativa()))){
                       throw new Exception("Período inválido! A data inicial deve ser maior ou igual a: "+
                          FormatDate.format(FormatDate.addDate(new Date(),-u.getDiasRetroativos()),"dd/MM/yyyy")
                       );
                  }
               }
          */

      session.setAttribute("forn",ent.getChave() + "");

      if (!(f.getRepresentante() + "").equals("")) {
        session.setAttribute("codigo_representante",f.getRepresentante() + "");
      }


      if (!(f.getCodigo_regional() + "").equals("")) {
        parametros += "&codigo_regional="+f.getCodigo_regional();
        session.setAttribute("codigo_regional",f.getCodigo_regional() + "");
      } else {
        parametros += "&codigo_regional="+f.getReg();
      }

      if (!(f.getCodigo_marca() + "").equals("")) {
        parametros += "&codigo_marca="+f.getCodigo_marca();
        session.setAttribute("codigo_marca",f.getCodigo_marca() + "");
      }

      if (!(f.getLin_cdgo() + "").equals("")) {
        parametros += "&codigo_linha="+f.getLin_cdgo();
        session.setAttribute("lin_cdgo",f.getLin_cdgo() + "");
      }

      parametros += "&dt_inicial="+f.getDt_inicial() + "&dt_final="+f.getDt_final();
      session.setAttribute("dt_inicial",f.getDt_inicial() + "");
      session.setAttribute("dt_final",f.getDt_final() + "");

      //----------------------------------------------------
      if (!(f.getReg().equals(""))) {
        session.setAttribute("codigo_regional",f.getReg() + "");
      }
      //---------------------------------------------------
      String descricao_marca = "";
      try {
        if ((!(f.getCodigo_marca().equals("")))) {
          portalbr.dbobj.table.Marcas_produtos db_object = new portalbr.dbobj.table.Marcas_produtos();
          Object[][] where = { {"codigo_marca","=",f.getCodigo_marca()} };
          String[] order = null;
          java.util.Vector results = j.select(db_object, where, order);
          if (results != null && results.size() > 0) {
            db_object = (portalbr.dbobj.table.Marcas_produtos) results.elementAt(0);
            descricao_marca = (db_object.getDescricao_marca() != null) ? db_object.getDescricao_marca() + "":"";
            session.setAttribute("codigo_marcad",f.getCodigo_marca() + "-"+descricao_marca);
          }
        }
      } catch (Exception e) {
        descricao_marca = "";
      } finally {
      }

      String descricao_linha = "";
      try {
        if ((!(f.getLin_cdgo().equals("")))) {
          portalbr.dbobj.table.Lin db_object = new portalbr.dbobj.table.Lin();
          Object[][] where = { {"lin_cdgo","=",f.getLin_cdgo()} };
          String[] order = null;
          java.util.Vector results = j.select(db_object, where, order);
          if (results != null && results.size() > 0) {
            db_object = (portalbr.dbobj.table.Lin) results.elementAt(0);
            descricao_linha = (db_object.getLin_nome() != null) ? db_object.getLin_nome() + "":"";
            session.setAttribute("lin_cdgod",f.getLin_cdgo() + "-"+descricao_linha);
          }
        }
      } catch (Exception e) {
        descricao_linha = "";
      } finally {
      }

      //----------------------------------------------------------------------

      if (f.getOrdenacao().equals("1")) {
        String check = f.getCheck_rep() + "";
        if (check.equals("1") || check.equals("9")) {
          if (f.getSituacao_representante().equals("null")) {
            session.setAttribute("situacao_representante","null");
          } else {
            session.setAttribute("situacao_representante","'"+f.getSituacao_representante() + "'");
          }
          if (f.getSituacao_cliente_representante().equals("null")) {
            session.setAttribute("situacao_cliente_representante","null");
          } else {
            session.setAttribute("situacao_cliente_representante","'"+f.getSituacao_cliente_representante() + "'");
          }
          if (f.getSituacao_representante_marca().equals("null")) {
            session.setAttribute("situacao_representante_marca","null");
          } else {
            session.setAttribute("situacao_representante_marca","'"+f.getSituacao_representante_marca() + "'");
          }
          actionForward = new ActionForward("/adm/Clientes_representanteForm.do?select_action="+parametros);
          session.setAttribute("tipo","Por Regional-> Representante");
        }
        if (check.equals("null")) {
          actionForward = new ActionForward("/adm/Clientes_regionalForm.do?select_action="+parametros);
          session.setAttribute("tipo","Por Regional");
        }
      }


      if (f.getOrdenacao().equals("3")) {
        session.setAttribute("tipo","Por Fluxo");
        if ((f.getCheck_reg() + "").equals("null") && (f.getCheck_mar() + "").equals("null")) {
          actionForward = new ActionForward("/adm/Clientes_fluxoForm.do?select_action="+parametros);
        } else if ((f.getCheck_reg() + "").equals("1") && (f.getCheck_mar() + "").equals("null")) {
          actionForward = new ActionForward("/adm/Clientes_fluxo_regionalForm.do?select_action="+parametros);
        } else if ((f.getCheck_reg() + "").equals("1") && (f.getCheck_mar() + "").equals("1")) {
          actionForward = new ActionForward("/adm/Clientes_fluxo_representanteForm.do?select_action="+parametros);
        }
      }

      if (f.getOrdenacao().equals("4")) {
        session.setAttribute("tipo","Por Quantidade de Atendimentos");
        if ((f.getCheck_reg() + "").equals("null") && (f.getCheck_mar() + "").equals("null")) {
          actionForward = new ActionForward("/adm/Clientes_quantidade_atendimentosForm.do?select_action="+parametros);
        } else if ((f.getCheck_reg() + "").equals("1") && (f.getCheck_mar() + "").equals("null")) {
          actionForward = new ActionForward("/adm/Clientes_quantidade_atendimentos_regionalForm.do?select_action="+parametros);
        } else if ((f.getCheck_reg() + "").equals("1") && (f.getCheck_mar() + "").equals("1")) {
          actionForward = new ActionForward("/adm/Clientes_quantidade_atendimentos_representanteForm.do?select_action="+parametros);
        }
      }

      if (f.getOrdenacao().equals("9")) {
        actionForward = new ActionForward("/adm/Clientes_representanteForm.do?select_action="+parametros);
      }

      if (f.getOrdenacao().equals("2")) {
        String check = f.getCheck_reg() + "";

        if (check.equals("1")) {

          String check_reg = f.getCheck_mar() + "";
          if (check_reg.equals("null")) {
            actionForward = new ActionForward("/adm/Clientes_marca_regionalForm.do?select_action="+parametros);
            session.setAttribute("tipo","Por Marca-> Regional");
          } else {
            if (f.getSituacao_representante().equals("null")) {
              session.setAttribute("situacao_representante","null");
            } else {
              session.setAttribute("situacao_representante","'"+f.getSituacao_representante() + "'");
            }
            if (f.getSituacao_cliente_representante().equals("null")) {
              session.setAttribute("situacao_cliente_representante","null");
            } else {
              session.setAttribute("situacao_cliente_representante","'"+f.getSituacao_cliente_representante() + "'");
            }
            if (f.getSituacao_representante_marca().equals("null")) {
              session.setAttribute("situacao_representante_marca","null");
            } else {
              session.setAttribute("situacao_representante_marca","'"+f.getSituacao_representante_marca() + "'");
            }
            actionForward = new ActionForward("/adm/Clientes_marca_regional_representanteForm.do?select_action="+parametros);
            session.setAttribute("tipo","Por Marca-> Regional-> Representante");
          }
        }
        if (check.equals("null")) {
          actionForward = new ActionForward("/adm/Clientes_marcaForm.do?select_action="+parametros);
          session.setAttribute("tipo","Por Marca");
        }
      }


      if (((tipoent.getTipo() + "").equals("REPRESENTANTE COMERCIAL")) || ((tipoent.getTipo() + "").equals("REPRESENTANTE EXPORTACAO"))) {
        session.setAttribute("tipo","Por Representante");
        if (f.getSituacao_cliente_representante().equals("null")) {
          session.setAttribute("situacao_cliente_representante",f.getSituacao_cliente_representante());
        } else {
          session.setAttribute("situacao_cliente_representante","'"+f.getSituacao_cliente_representante() + "'");
        }
      }



      if (f.getSituacao_representante().equals("null")) {
        session.setAttribute("situacao_representante","null");
      } else {
        session.setAttribute("situacao_representante","'"+f.getSituacao_representante() + "'");
      }
      if (f.getSituacao_cliente_representante().equals("null")) {
        session.setAttribute("situacao_cliente_representante","null");
      } else {
        session.setAttribute("situacao_cliente_representante","'"+f.getSituacao_cliente_representante() + "'");
      }
      if (f.getSituacao_representante_marca().equals("null")) {
        session.setAttribute("situacao_representante_marca","null");
      } else {
        session.setAttribute("situacao_representante_marca","'"+f.getSituacao_representante_marca() + "'");
      }


    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Resumo_ped", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Clientes_atendidosActionForm f = (Clientes_atendidosActionForm) form;
      session.removeAttribute("res_Resumo_ped");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Resumo_ped", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Clientes_atendidosActionForm f = (Clientes_atendidosActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Resumo_ped", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
