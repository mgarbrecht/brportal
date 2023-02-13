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
 * Creation Date 03/02/2012 11:28:50
 * Last Modify Date 07/11/2022 16:49:00
 */

public class SolicitacaoCombinacaoEspecial_iAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      SolicitacaoCombinacaoEspecial_iActionForm f = (SolicitacaoCombinacaoEspecial_iActionForm) form;
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
      SolicitacaoCombinacaoEspecial_iActionForm f = (SolicitacaoCombinacaoEspecial_iActionForm) form;
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
      SolicitacaoCombinacaoEspecial_iActionForm f = (SolicitacaoCombinacaoEspecial_iActionForm) form;


      actionForward = new ActionForward("/com/SolicitacaoCombinacaoEspecialForm.jsp",true);
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
      SolicitacaoCombinacaoEspecial_iActionForm f = (SolicitacaoCombinacaoEspecial_iActionForm) form;
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

  public ActionForward perform_insert_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      SolicitacaoCombinacaoEspecial_iActionForm f = (SolicitacaoCombinacaoEspecial_iActionForm) form;
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
    SolicitacaoCombinacaoEspecial_iActionForm f = (SolicitacaoCombinacaoEspecial_iActionForm) form;
    util.consultas.Query query = new util.consultas.Query();
    util.consultas.Parametros parametros = new util.consultas.Parametros();
    {
      if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
        String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_solicitacao_especial");
        realPath2bl_form = realPath2bl_form + java.io.File.separator;
        org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
        if (inputfile2bl_form.getFileSize() > 512000) {
          throw new Exception("O arquivo de imagem ultrapassou o tamanho máximo de 500kb!");
        }
      } else {
        throw new Exception("A imagem deve ser informada!");
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
    table.setMaterial_cor1(f.getMaterial_cor1());
    table.setMaterial_cor2(f.getMaterial_cor2());
    table.setMaterial_cor3(f.getMaterial_cor3());
    table.setMaterial_cor4(f.getMaterial_cor4());
    table.setMaterial_cor5(f.getMaterial_cor5());
    table.setMaterial_cor6(f.getMaterial_cor6());
    table.setMaterial_cor7(f.getMaterial_cor7());
    table.setMaterial_cor8(f.getMaterial_cor8());
    table.setMaterial_cor9(f.getMaterial_cor9());
    table.setMaterial_cor10(f.getMaterial_cor10());
    table.setBiqueira_debrum(f.getBiqueira_debrum());
    table.setCapa_palmilha(f.getCapa_palmilha());
    table.setCacharel(f.getCacharel());
    table.setForro(f.getForro());
    table.setCepa(f.getCepa());
    table.setSola(f.getSola());
    table.setMetais(f.getMetais());
    table.setTaloneira(f.getTaloneira());
    table.setSalto(f.getSalto());
    table.setRep_cdgo(f.getRep_cdgo());
    table.setTipo_solicitacao_comb_especial(f.getTipo_solicitacao());
    table.setSubtipo_solicitacao_comb_espec(f.getSubtipo_solicitacao_comb_espec());
    table.setEnfeite(f.getEnfeite());
    table.setCarimbo_etiqueta(f.getCarimbo_etiqueta());
    table.setCli_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCli_cdgo()));
    table.setGre_grupo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getGre_grupo()));
    table.setPrs_negociacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPrs_negociacao()));
    table.setPares_linha(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_linha()));
    table.setPares_alteracao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPares_alteracao()));
    table.setPreco_liguido(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_liguido()));
    table.setValor_fabricacao(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_fabricacao()));
    table.setPreco_vendor(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPreco_vendor()));
    table.setLl_alteracao_solicitada(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getLl_alteracao_solicitada()));
    table.setSituacao_solicitacao("I");
    table.setData_aceite(com.egen.util.text.FormatDate.parseDate(f.getData_aceite(), "dd/MM/yyyy HH:mm:ss"));
    table.setUsuario_aceite(f.getUsuario_aceite());
    table.setMaterial(f.getMaterial());
    table.setAtacador(f.getAtacador());
    table.setIte_seqn(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getItem()));
    table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPedido()));
    j.insert(table);
    if (f.getArquivo() != null && f.getArquivo().toString() != null && f.getArquivo().toString().length() > 0) {
      Ref_combinacao_especial_img table_img = new Ref_combinacao_especial_img();
      Object[][] name_value_img = { {"id_solicitacao",com.egen.util.text.FormatNumber.toInteger(f.getId_solicitacao())}, {"id_imagem",1}, {"imagem",util.text.Caracteres.removerAcentos("S"+f.getId_solicitacao() + "_"+ f.getArquivo())}, {"descricao_imagem",null}, };
      j.insert(table_img , name_value_img);
    }

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
      String realPath2bl_form = parametros.retornaParametro("diretorio_arquivos_solicitacao_especial");
      realPath2bl_form = realPath2bl_form + java.io.File.separator;
      org.apache.struts.upload.FormFile inputfile2bl_form = f.getArquivo();
      java.io.InputStream stream2bl_form = inputfile2bl_form.getInputStream();
      java.io.OutputStream bos2bl_form = new java.io.FileOutputStream(realPath2bl_form + "S"+f.getId_solicitacao() + "_"+ util.text.Caracteres.removerAcentos(inputfile2bl_form.getFileName()));
      int bytesRead2bl_form = 0;
      byte[] buffer2bl_form = new byte[8192];
      while ((bytesRead2bl_form = stream2bl_form.read(buffer2bl_form, 0, 8192)) != -1) {
        bos2bl_form.write(buffer2bl_form, 0, bytesRead2bl_form);
      }
      bos2bl_form.close();
      stream2bl_form.close();
      try {
        java.io.File arquivo = new java.io.File(realPath2bl_form + "S"+f.getId_solicitacao() + "_"+util.text.Caracteres.removerAcentos(inputfile2bl_form.getFileName()));
        util.amazon.S3Amazon s3Amazon = new util.amazon.S3Amazon("medias.calcadosbeirario.com.br");
        s3Amazon.carregarImagem("solicitacao_combinacao_especial", arquivo);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }


    //--- Envia Email ---
    util.email.EmailUtil email = new util.email.EmailUtil();
    email.inicializa();
    email.setEmailDestinatario(parametros.retornaParametro("email_nova_solicitacao"));
    email.setAssunto("BRPortal - Nova solicitacao: id: "+f.getId_solicitacao());

    StringBuilder sb = new StringBuilder();
    sb.append("<table border=\"1\">");
    sb.append("   <tr><td><b>ID:</b></td><td>"+f.getId_solicitacao() + "</td></tr> ");
    sb.append("   <tr><td><b>Solicitacao:</b></td><td>"+f.getTipo_solicitacao() + "</td></tr> ");
    sb.append("   <tr><td><b>Marca:</b></td><td>"+f.getCodigo_marca() + "</tr></tr> ");
    sb.append("   <tr><td><b>Linha:</b></td><td>"+f.getLin_cdgo() + "</td></tr> ");
    sb.append("   <tr><td><b>Referencia:</b></td><td>"+f.getRef_cdgo() + "</td></tr> ");
    sb.append("   <tr><td><b>Cabedal:</b></td><td>"+f.getCab_cdgo() + "</td></tr> ");
    sb.append("   <tr><td><b>Cor:</b></td><td>"+f.getCor_cdgo() + "</td></tr> ");
    sb.append("   <tr><td><b>Observacao:</b></td><td>"+f.getObservacao() + "</td></tr> ");
    sb.append("</table>");
    email.adicionaLinha(sb.toString());
    //    email.enviarEmail();

    //------------------------------------------------

    Vector res_Ref_combinacao_especial = (Vector) session.getAttribute("res_Ref_combinacao_especial");
    if (res_Ref_combinacao_especial != null && table != null) {
      res_Ref_combinacao_especial.addElement(table);
      session.setAttribute("res_Ref_combinacao_especial", res_Ref_combinacao_especial);
    }
    form.reset(mapping, request);
    session.removeAttribute("v_numeracao");
    session.removeAttribute("v_pares");
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
      SolicitacaoCombinacaoEspecial_iActionForm f = (SolicitacaoCombinacaoEspecial_iActionForm) form;
      StringBuilder sb = new StringBuilder();
      util.consultas.Query query = new util.consultas.Query();

      //    if(f.getMaterial().equalsIgnoreCase("M")) {
      //       String mixProduto = query.retorna("SELECT fct_mix_produtos_linha('"+f.getLin_cdgo()+"') FROM dual");
      //       if(!mixProduto.equalsIgnoreCase(f.getMaterial())) {
      //          throw new Exception("Linha é Fora Mix!");
      //       }
      //    }

      if ((f.getTipo_solicitacao() + "").equals("3")) {
        if (f.getRef_cdgo().equals("")) {
          throw new Exception("A referência deve ser informada!");
        }
      }

      if (f.getCli_cdgo().equals("") && f.getGre_grupo().equals("")) {
        throw new Exception("Um dos campos com <img src='../img/opcional.gif'> deve ser informado!");
      }

      if (!f.getCodigo_marca().equals("")) {
        String codigoMarcaLinha = query.retorna("SELECT fct_marca_produto(r.lin_cdgo, r.ref_cdgo) marca from ref r where r.lin_cdgo = "+f.getLin_cdgo() + " and rownum = 1");
        if (!f.getCodigo_marca().equals(codigoMarcaLinha)) {
          throw new Exception("A marca informada é diferente da marca da linha!");
        }
      }

      acesso.Sessao sessao = new acesso.Sessao(session);
      acesso.Usuario user = (acesso.Usuario) session.getAttribute("User");
      //    if(f.getTipo_solicitacao().equals("5")) {
      StringBuilder sbc = new StringBuilder();
      sbc.append(" SELECT distinct 'S' existe ");
      sbc.append("   FROM ref_cor ");
      sbc.append("  WHERE lin_cdgo = " + f.getLin_cdgo());
      if (!f.getRef_cdgo().equals("")) {
        sbc.append("    AND ref_cdgo = nvl("+f.getRef_cdgo() + ", ref_cdgo) ");
      }
      if (!f.getCab_cdgo().equals("")) {
        sbc.append("    AND cab_cdgo = nvl("+f.getCab_cdgo() + ", cab_cdgo) ");
      }
      if (!f.getCor_cdgo().equals("")) {
        sbc.append("    AND cor_cdgo = nvl("+f.getCor_cdgo() + ", cor_cdgo) ");
      }

      String existeCombinacao = query.retorna(sbc.toString());

      if (!(existeCombinacao + "").equals("S")) {
        throw new Exception("Combinação linha/referência/cabedal/cor inválida!");
      }
      //}

      if (f.getTipo_solicitacao().equals("5") || f.getTipo_solicitacao().equals("2") || f.getTipo_solicitacao().equals("3")) {

        if (f.getPrs_negociacao().equals("")) {
          throw new Exception("Pares negociação deve ser informado!");
        }
        if (f.getPares_linha().equals("")) {
          throw new Exception("Pares linha deve ser informado!");
        }
        if (f.getPares_alteracao().equals("")) {
          throw new Exception("Pares solicitados deve ser informado!");
        }
        if (f.getPreco_liguido().equals("")) {
          throw new Exception("Preço líquido deve ser informado!");
        }
        if (f.getValor_fabricacao().equals("")) {
          throw new Exception("CTF deve ser informado!");
        }
        if (f.getPreco_vendor().equals("")) {
          throw new Exception("Preço vendor deve ser informado!");
        }
        if (sessao.getTipoEntidadeNegocio().equals("AREAS") || user.isSuperUsuario()) {
          if (f.getLl_alteracao_solicitada().equals("")) {
            throw new Exception("LL Alteração Solicitada deve ser informado!");
          }
        }
      }

      if (f.getTipo_solicitacao().equals("5")) {
        if (f.getLin_cdgo() != "" && f.getRef_cdgo() != "" && f.getCab_cdgo() != "" && f.getCor_cdgo() != "") {
          StringBuilder sbq = new StringBuilder();
          sbq.append(" SELECT case when nvl(sum(1),0) = 1 then 'M' else 'F' end mix ");
          sbq.append("   FROM ref_cor rc ");
          sbq.append("  WHERE lin_cdgo = " + f.getLin_cdgo());
          sbq.append("    AND ref_cdgo = " + f.getRef_cdgo());
          sbq.append("    AND cab_cdgo = " + f.getCab_cdgo());
          sbq.append("    AND cor_cdgo = " + f.getCor_cdgo());
          sbq.append("    AND fct_mix_produto(rc.lin_cdgo, rc.ref_cdgo) = 'M' ");
          sbq.append("    AND fct_mix_cabedal(rc.lin_cdgo,rc.ref_cdgo,rc.cab_cdgo) = 'M' ");
          sbq.append("    AND fct_mix_cor(rc.lin_cdgo, rc.ref_cdgo, rc.cab_cdgo, rc.cor_cdgo) = 'M' ");
          String mix = query.retorna(sbq.toString());
          if (mix.equalsIgnoreCase("M")) {
            throw new Exception("Não é possível solicitar combinações especiais tipo FORA MIX para produtos que estejam no MIX!");
          }
        }
      }

      sb.append("  SELECT 1 ");
      sb.append("  FROM dual ");
      sb.append("  WHERE EXISTS ");
      sb.append("  (SELECT * ");
      sb.append("  FROM ped p ");
      sb.append("  WHERE p.ped_nmro = " +f.getPedido());
      sb.append("  AND p.rep_cdgo = " +f.getRep_cdgo());
      sb.append("  AND p.ped_stat NOT IN ('F', 'C', 'L') ");
      sb.append("  AND EXTRACT(YEAR from p.ped_dadg) = EXTRACT(YEAR from sysdate)) ");

      if (sb.toString().equalsIgnoreCase("")) {
        throw new Exception("Para o numero do pedido ser valido ele deve ser deste ano, o representante deve ser o "+f.getRep_cdgo() + " e seu status não pode ser 'F','C', 'L' ");
      }

      if (f.getTipo_solicitacao() != null && f.getTipo_solicitacao().equalsIgnoreCase("1")) {
        if (session.getAttribute("v_numeracao") == null) {
          throw new Exception("Informe a grade!");
        }
      }
      if (!f.getLibera_valores()) {
        if (f.getPreco_vendor() != null && Double.parseDouble(f.getPreco_vendor().equals("") ? "0":f.getPreco_vendor().replace(',' , '.')) > 100) {
          throw new Exception("Para preços vendor acima de 100 reais, selecione a opção de liberação no final da tela!");
        }
        if (f.getPreco_liguido() != null && Double.parseDouble(f.getPreco_liguido().equals("") ? "0":f.getPreco_liguido().replace(',' , '.')) > 100) {
          throw new Exception("Para preços líquidos acima de 100 reais, selecione a opção de liberação no final da tela!");
        }
      }

      session.setAttribute(mapping.getName(), form);
    }
    catch (Exception e) {
      throw e;
    } finally {
    }
  }
}
