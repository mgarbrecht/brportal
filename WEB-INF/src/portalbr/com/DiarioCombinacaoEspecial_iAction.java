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
 * Creation Date 08/06/2015 16:01:00
 * Last Modify Date 23/06/2015 10:39:53
 */

public class DiarioCombinacaoEspecial_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_iActionForm f = (DiarioCombinacaoEspecial_iActionForm) form;
      try {
        tg_insert_action_1(mapping, form, request, response);
        insert_action(j, mapping, form, request, response);
        tg_insert_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  private void insert_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DiarioCombinacaoEspecial_iActionForm f = (DiarioCombinacaoEspecial_iActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    util.consultas.Parametros parametros = new util.consultas.Parametros();
    {
      if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
        String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_diario_combinacao_especial");
        realPath2bl_form = realPath2bl_form + java.io.File.separator;
        org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
        if (inputfile2bl_form.getFileSize() > 512000) {
          throw new Exception("O arquivo de imagem 1 ultrapassou o tamanho máximo de 500kb!");
        }
      }
    }



    Ref_combinacao_especial table = new Ref_combinacao_especial();

    f.setId_solicitacao(query.retorna("SELECT brio.seq_ref_comb_espec.nextval FROM dual"));
    request.setAttribute("solicitacao", f.getId_solicitacao());
    table.setId_solicitacao(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getId_solicitacao()));
    table.setData_solicitacao(com.egen.util.text.FormatDate.parseTimestamp(f.getData_solicitacao(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_solicitacao(f.getUsuario_solicitacao());
    table.setCodigo_marca(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCodigo_marca()));
    table.setLin_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getLin_cdgo()));
    table.setRef_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getRef_cdgo()));
    table.setCab_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCab_cdgo()));
    table.setCor_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCor_cdgo()));
    table.setObservacao(f.getObservacao());
    table.setDescricao(f.getDescricao());
    table.setMaterial_cor1(f.getMaterial_cor1());
    table.setMaterial_cor2(f.getMaterial_cor2());
    table.setMaterial_cor3(f.getMaterial_cor3());
    table.setBiqueira_debrum(f.getBiqueira_debrum());
    table.setCapa_palmilha(f.getCapa_palmilha());
    table.setCacharel(f.getCacharel());
    table.setForro(f.getForro());
    table.setMetais(f.getMetais());
    table.setTaloneira(f.getTaloneira());
    table.setSalto(f.getSalto());
    table.setRep_cdgo(f.getRep_cdgo());
    table.setTipo_solicitacao_comb_especial(f.getTipo_solicitacao());
    table.setEnfeite(f.getEnfeite());
    table.setCarimbo_etiqueta(f.getCarimbo_etiqueta());
    table.setCli_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCli_cdgo()));
    table.setGre_grupo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getGre_grupo()));
    table.setPrs_negociacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPrs_negociacao()));
    table.setPares_linha(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_linha()));
    table.setPares_alteracao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_alteracao()));
    table.setPreco_liguido(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_liguido()));
    table.setValor_fabricacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_fabricacao()));
    table.setLl_alteracao_solicitada(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_alteracao_solicitada()));
    table.setSituacao_solicitacao("P");
    table.setData_aceite(com.egen.util.text.FormatDate.parseDate(f.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_aceite(f.getUsuario_aceite());
    table.setValor_pdv(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_pdv()));
    table.setLl_0(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_0()));
    table.setLl_1(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_1()));
    table.setLl_2(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_2()));
    table.setLl_3(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_3()));
    table.setPreco_vendor(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_vendor()));


    j.insert(table);
    if (session.getAttribute("v_numeracao") != null) {
      Ref_comb_especial_grade t_grade = new Ref_comb_especial_grade();
      for (Object a:
          ((Vector) session.getAttribute("v_numeracao")).toArray()) {
        String[] s = ((String) a).split("#");
        Object[][] name_value = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"numeracao", s[0]}, {"qtp_pars", Integer.parseInt(s[1])} };
        j.insert(t_grade, name_value);
      }
      session.removeAttribute("v_numeracao");
    }

    //--- Upload Imagem ------------------------------
    if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
      String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_diario_combinacao_especial");
      realPath2bl_form = realPath2bl_form + java.io.File.separator;
      org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
      java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
      java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(realPath2bl_form + "S"+f.getId_solicitacao() + "_1_"+inputfile2bl_form.getFileName());
      int bytesRead2bl_form = 0;
      byte[] buffer2bl_form = new byte[8192];
      while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
        bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
      }
      bos2bl_form.close();
      stream2bl_form.close();
      Ref_combinacao_especial_img table_img = new Ref_combinacao_especial_img();
      Object[][] name_value_img = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"id_imagem",1}, {"imagem","S"+f.getId_solicitacao() + "_1_"+f.getArquivo()}, {"descricao_imagem",null}, };
      j.insert(table_img , name_value_img);
    }


    //--- Envia Email ---
    /*
    util.email.EmailUtil email = new util.email.EmailUtil();
    email.inicializa();
    email.setEmailDestinatario(parametros.retornaParametro("email_nova_solicitacao"));
    email.setAssunto("BRPortal - Nova solicitacao: id: "+f.getId_solicitacao());

    StringBuilder sb = new StringBuilder();
    sb.append("<table border=\"1\">");
    sb.append("   <tr><td><b>ID:</b></td><td>"+f.getId_solicitacao()+"</td></tr> ");
    sb.append("   <tr><td><b>Solicitacao:</b></td><td>"+f.getTipo_solicitacao()+"</td></tr> ");
    sb.append("   <tr><td><b>Marca:</b></td><td>"+f.getCodigo_marca()+"</tr></tr> ");
    sb.append("   <tr><td><b>Linha:</b></td><td>"+f.getLin_cdgo()+"</td></tr> ");
    sb.append("   <tr><td><b>Referencia:</b></td><td>"+f.getRef_cdgo()+"</td></tr> ");
    sb.append("   <tr><td><b>Cabedal:</b></td><td>"+f.getCab_cdgo()+"</td></tr> ");
    sb.append("   <tr><td><b>Cor:</b></td><td>"+f.getCor_cdgo()+"</td></tr> ");
    sb.append("   <tr><td><b>Observacao:</b></td><td>"+f.getObservacao()+"</td></tr> ");
    sb.append("</table>");
    email.adicionaLinha(sb.toString());
    email.enviarEmail();
    */

    //------------------------------------------------

    Vector res_Ref_combinacao_especial = (Vector) session.getAttribute("res_Ref_combinacao_especial");
    if (res_Ref_combinacao_especial != null && table != null) {
      res_Ref_combinacao_especial.addElement(table);
      session.setAttribute("res_Ref_combinacao_especial", res_Ref_combinacao_especial);
    }
    form.reset(mapping, request);
    session.setAttribute(mapping.getName(), form);
  }
  private void tg_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionErrors errors = new ActionErrors();
    errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("msg.successfuloperation",""));
    request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
  }

  private void tg_insert_action_1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DiarioCombinacaoEspecial_iActionForm f = (DiarioCombinacaoEspecial_iActionForm) form;
      if (f.getTipo_solicitacao() != null && f.getTipo_solicitacao().equalsIgnoreCase("1")) {
        if (session.getAttribute("v_numeracao") == null) {
          throw new Exception("Informe a grade!");
        }
      }

      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DiarioCombinacaoEspecial_iActionForm f = (DiarioCombinacaoEspecial_iActionForm) form;
      tg_resetfull_action(mapping, form, request, response);
      session.removeAttribute("res_Ref_combinacao_especial");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }
  private void tg_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DiarioCombinacaoEspecial_iActionForm f = (DiarioCombinacaoEspecial_iActionForm) form;
      session.removeAttribute("v_numeracao");
      session.removeAttribute("v_pares");
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    } finally {
    }
  }

  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DiarioCombinacaoEspecial_iActionForm f = (DiarioCombinacaoEspecial_iActionForm) form;


      actionForward = new ActionForward("/com/DiarioCombinacaoEspecialForm.jsp",true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
      }
    }
    return actionForward;
  }
  public ActionForward perform_refresh_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DiarioCombinacaoEspecial_iActionForm f = (DiarioCombinacaoEspecial_iActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ref_combinacao_especial", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
