package portalbr.com;

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
 * Creation Date 14/12/2007 07:44:14
 * Last Modify Date 22/06/2015 13:33:56
 */

public class Dev0002Action extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception("Query não disponível! Relatório utilizado: dev0002.rdf");
      }
      String perfilRepresentante = "N";
      Dev0002ActionForm f = (Dev0002ActionForm) form;
      util.consultas.Parametros parametros = new util.consultas.Parametros();
      acesso.Sessao sessao = new acesso.Sessao(session);
      if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO"))) {
        perfilRepresentante = "S";
      }
      if (f.getTipo_relatorio().equals("pdf")) {
        util.file.GeraPDF g = new util.file.GeraPDF(request);
        g.setRelatorio("dev0002.rdf");
        g.setParametro("P_SITUACAO", f.getSituacao());
        g.setParametro("P_MARCA", f.getMarca());
        g.setParametro("P_FIL_FILIAL", f.getFil_filial());
        g.setParametro("P_NFS_NMRO", f.getNfs_nmro());
        g.setParametro("P_PRECO", f.getTipo_preco());
        g.setParametro("P_LIVRO_ALTERNATIVO", f.getLivro_alternativo());
        g.setParametro("P_ATRASO_FIM", f.getAtraso_fim());
        g.setParametro("P_ATRASO", f.getAtraso());
        g.setParametro("P_DIRETORIO_IMAGEM", parametros.retornaParametro("diretorio_imagens_report"));
        if (f.getReg().equals("")) {
          g.setParametro("P_REGIONAL", "0");
        } else {
          g.setParametro("P_REGIONAL", f.getReg());
        }
        g.setParametro("P_REP", f.getRep_cdgo());
        g.setParametro("P_UNID_NEGOCIO", f.getUnn_codigo());
        g.setParametro("P_CLIENTE", f.getCli_cdgo());
        if (f.getGre_grupo().equals("")) {
          g.setParametro("P_GRUPO", "0");
        } else {
          g.setParametro("P_GRUPO", f.getGre_grupo());
        }
        g.setParametro("P_EXIBE_CLIENTE", f.getExibe_cliente());
        g.setParametro("P_EXIBE_REP", f.getExibe_rep());

        if (f.getLin_cdgo().equals("")) {
          g.setParametro("P_LINHA", "0");
        } else {
          g.setParametro("P_LINHA", f.getLin_cdgo());
        }
        g.setParametro("P_IND_ABERTO_FECHADO", f.getAberto_fechado());
        g.setParametro("P_TRA", f.getTra_cdgo());
        g.setParametro("P_PERFIL_REPRESENTANTE", perfilRepresentante);
        g.gerar();
        if ((f.getAbre_automaticamente() + "").equals("checked")) {
          request.setAttribute("abre_automaticamente","S");
        } else {
          request.setAttribute("abre_automaticamente","N");
        }
      } else {
        //-----------------------------------------------------------------------
        util.consultas.com.Dev0002 dev0002 = new util.consultas.com.Dev0002();
        String arquivo = null;
        if ((f.getCb_agrupado() + "").equals("checked")) {
          arquivo = dev0002.geraExcelAgrupado(f.getSituacao(), (f.getMarca() != ""?f.getMarca() : "null"), (f.getTipo_preco() != ""?f.getTipo_preco() : "null"), (f.getLivro_alternativo() != ""?f.getLivro_alternativo() : "null"), (f.getAtraso_fim() != ""?f.getAtraso_fim() : "null"), (f.getAtraso() != ""?f.getAtraso() : "null"), (f.getReg() != ""?f.getReg() : "null"), (f.getRep_cdgo() != ""?f.getRep_cdgo() : "null"), (f.getUnn_codigo() != ""?f.getUnn_codigo() : "null"), (f.getCli_cdgo() != ""?f.getCli_cdgo() : "null"), (f.getGre_grupo() != ""?f.getGre_grupo() : "null"), (f.getLin_cdgo() != ""?f.getLin_cdgo() : "null"), (f.getAberto_fechado() != ""?f.getAberto_fechado() : "null"), (f.getTra_cdgo() != ""?f.getTra_cdgo() : "null"), (f.getFil_filial() != ""?f.getFil_filial() : "null"), (f.getNfs_nmro() != ""?f.getNfs_nmro() : "null"), (perfilRepresentante != ""?perfilRepresentante : "N"));
        } else {
          arquivo = dev0002.geraExcel(f.getSituacao(), (f.getMarca() != ""?f.getMarca() : "null"), (f.getTipo_preco() != ""?f.getTipo_preco() : "null"), (f.getLivro_alternativo() != ""?f.getLivro_alternativo() : "null"), (f.getAtraso_fim() != ""?f.getAtraso_fim() : "null"), (f.getAtraso() != ""?f.getAtraso() : "null"), (f.getReg() != ""?f.getReg() : "null"), (f.getRep_cdgo() != ""?f.getRep_cdgo() : "null"), (f.getUnn_codigo() != ""?f.getUnn_codigo() : "null"), (f.getCli_cdgo() != ""?f.getCli_cdgo() : "null"), (f.getGre_grupo() != ""?f.getGre_grupo() : "null"), (f.getLin_cdgo() != ""?f.getLin_cdgo() : "null"), (f.getAberto_fechado() != ""?f.getAberto_fechado() : "null"), (f.getTra_cdgo() != ""?f.getTra_cdgo() : "null"), (f.getFil_filial() != ""?f.getFil_filial() : "null"), (f.getNfs_nmro() != ""?f.getNfs_nmro() : "null"), (perfilRepresentante != ""?perfilRepresentante : "N"));
        }
        if (arquivo.equals("")) {
          throw new Exception("Nenhum registro encontrado!");
        }
        request.setAttribute("abre_automaticamente","X");
        request.setAttribute("arquivo", arquivo);
      }
      //-----------------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      Dev0002ActionForm f = (Dev0002ActionForm) form;
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
