package portalbr.ind;

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
 * Creation Date 17/09/2014 08:49:14
 * Last Modify Date 17/09/2014 08:49:14
 */

public class VendaEstrategicosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;

    try {
      String auxiliar = (String) session.getAttribute("codigos_estoque") == null ? "15,21":(String) session.getAttribute("codigos_estoque");
      String auxiliar2 = null;
      if (session.getAttribute("cod_produto") != null) {
        auxiliar2 = (String) session.getAttribute("cod_produto");
      } else {
      }
      VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
      util.consultas.ind.VendaEstrategicos vendaEstrategicos = new util.consultas.ind.VendaEstrategicos();
      String arquivo = null;
      String mostrarPreco = null;
      String ignorar95 = null;
      String imprimeImagens = null;
      String consideraTransito = null;
      String gradeQuebrada = null;
      //----------------------------------------------------------
      if ((f.getCb_grade_quebrada() + "").equals("checked")) {
        gradeQuebrada = "S";
      } else {
        gradeQuebrada = "N";
      }
      //----------------------------------------------------------
      if ((f.getCb_preco() + "").equals("checked")) {
        mostrarPreco = "S";
      } else {
        mostrarPreco = "N";
      }
      //----------------------------------------------------------
      if ((f.getCb_img_prod() + "").equals("checked")) {
        imprimeImagens = "S";
      } else {
        imprimeImagens = "N";
      }
      //----------------------------------------------------------
      if ((f.getCb_transito() + "").equals("checked")) {
        consideraTransito = "S";
      } else {
        consideraTransito = "N";
      }
      //----------------------------------------------------------
      if ((f.getCb_ignorar_95() + "").equals("1")) {
        ignorar95 = "S";
        if (f.getLiv_codigo().equals("")) {
          f.setLiv_codigo("32");
        }
      } else {
        ignorar95 = "N";
      }


      arquivo = vendaEstrategicos.geraExcel((f.getEmp_empresa() != ""?("'"+f.getEmp_empresa() + "'") : "null"), (f.getFil_filial() != ""?("'"+f.getFil_filial() + "'") : "null"), (f.getLocal_est() != ""?f.getLocal_est() : "null"), (f.getComp() != ""?f.getComp() : "null"), (f.getItem_est() != ""?f.getItem_est() : "null"), (f.getRef_cdgo() != ""?f.getRef_cdgo() : "null"), (f.getCab_cdgo() != ""?f.getCab_cdgo() : "null"), (f.getCor_cdgo() != ""?f.getCor_cdgo() : "null"), (f.getLin_cdgo() != ""?f.getLin_cdgo() : "null"), (f.getMarca_cdgo() != ""?f.getMarca_cdgo() : "null"), (f.getMix() != ""?f.getMix() : "null"), (f.getQtde_ini() != ""?f.getQtde_ini() : "null"), (f.getQtde_fim() != ""?f.getQtde_fim() : "null"), (f.getTipo_prod() != ""?f.getTipo_prod() : "null"), auxiliar , auxiliar2 , imprimeImagens , consideraTransito , (f.getGrade() != ""?f.getGrade() : "null"), (f.getData_inicial() != ""?f.getData_inicial() : "01/01/1000"), (f.getData_final() != ""?f.getData_final() : "01/01/3000"), f.getOrdenacao(), mostrarPreco , gradeQuebrada , (f.getLiv_codigo() != ""?f.getLiv_codigo() : "95"), ignorar95);

      if (arquivo.equals("")) {
        throw new Exception("Nenhum registro encontrado!");
      }




      //----------------------------------------------------------
      request.setAttribute("abre_automaticamente","N");
      //----------------------------------------------------------
      request.setAttribute("arquivo", arquivo);
      //----------------------------------------------------------
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
    session.setAttribute(mapping.getName(), form);
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
      form.reset(mapping, request);
      session.removeAttribute("tipos_estoque");
      session.removeAttribute("tipos_produtos");
      session.removeAttribute("cod_produto");
      session.removeAttribute("codigos_estoque");
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
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      VendaEstrategicosActionForm f = (VendaEstrategicosActionForm) form;
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
