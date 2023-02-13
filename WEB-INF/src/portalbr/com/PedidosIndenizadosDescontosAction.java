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
 * Creation Date 15/03/2011 11:09:56
 * Last Modify Date 29/07/2022 15:25:54
 */

public class PedidosIndenizadosDescontosAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      try {
        select_action(j, mapping, form, request, response);
      }
      finally {
      }
      if (session.getAttribute("mostra") == null) {
        actionForward = new ActionForward("/com/PedidosIndenizadosDescontos_fForm.do?blank_action=", true);
      } else {
        actionForward = mapping.findForward("same");
      }
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
    PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
    //--------------------------------------------------
    String representante = "null";
    String regional = "null";
    String analista = "null";
    //--------------------------------------------------
    acesso.Sessao sessao = new acesso.Sessao(session);
    if ((sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) || sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
      representante = "'"+sessao.getChave() + "'";
    }
    if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
      regional = sessao.getChave();
    }
    if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
      analista = sessao.getChave();
    }
    //--------------------------------------------------
    if (f != null) {
      String parametros = (String) session.getAttribute("query");
      Jw_ped_desconto_indenizacao table = new Jw_ped_desconto_indenizacao();
      StringBuilder sb = new StringBuilder();
      sb.append(" SELECT ped.ped_nmro ");
      sb.append("      , pd.tipo_desconto ");
      sb.append("      , pd.ped_obse ");
      sb.append("      , pd.valor_desconto ");
      sb.append("      , pd.percentual_desc ");
      sb.append("      , ped.cnd_cdgo ");
      sb.append("      , NVL(pd.situacao, 'N') situacao ");
      sb.append("      , pd.prazo_adicional ");
      sb.append("      , (SELECT 'S' FROM ped_desconto_indenizacao WHERE ped_nmro = ped.ped_nmro) banco ");
      sb.append("      , ped_sequencial_maquina ");
      sb.append("      , c.cli_cdgo || '-' || esc_seqn || '-' || INITCAP(c.cli_rzao) cliente ");
      sb.append("      , ped.ped_stat ");
      sb.append("      , fct_valor_pedido(ped.ped_nmro) valor ");
      sb.append("      , pck_cnd.get_nome(ped.cnd_cdgo) cnd_desc ");
      sb.append("      , ped.ped_especie_pedido ");
      sb.append("      , nvl((SELECT DISTINCT 'N' aceita_desconto ");
      sb.append("                        FROM ped p ");
      sb.append("                           , ite i ");
      sb.append("                       WHERE p.ped_nmro = i.ped_nmro ");
      sb.append("                         AND ((NVL(p.ped_boni, 0) > 0) OR (NVL(p.ped_boni2, 0) > 0) OR ");
      sb.append("                              (NVL(fct_valor_pedido(p.ped_nmro), 0) > 0)) ");
      sb.append("                         AND p.ped_nmro = ped.ped_nmro ");
      sb.append("                         AND p.ped_tipo <> 'EX' ");
      sb.append("                         AND p.ped_especie_pedido <> 'A' ");
      sb.append("                         AND EXISTS (SELECT 1 ");
      sb.append("                                       FROM ref_sem_desconto rsd ");
      sb.append("                                      WHERE rsd.lin_cdgo = i.lin_cdgo ");
      sb.append("                                        AND rsd.ref_cdgo = i.ref_cdgo) ");
      sb.append("                       UNION ");
      sb.append("                      SELECT DISTINCT 'N' aceita_desconto ");
      sb.append("                        FROM ite i ");
      sb.append("                           , ref r ");
      sb.append("                       WHERE i.ped_nmro = ped.ped_nmro ");
      sb.append("                         AND i.lin_cdgo = r.lin_cdgo ");
      sb.append("                         AND i.ref_cdgo = r.ref_cdgo ");
      sb.append("                         AND r.ref_grupo_posicao_fab = 26 ");
      sb.append("                         ),'S') aceita_desconto ");
      sb.append("      , c.cli_cdgo ");
      sb.append("      , (select fct_marca_produto(i.lin_cdgo, i.ref_cdgo) from ite i where i.ped_nmro = ped.ped_nmro and rownum = 1) codigo_marca ");
      sb.append("      , ped.esc_seqn ");
      sb.append("      , rv.codigo_regional ");
      sb.append("      , rv.nome_regional ");
      sb.append("   FROM ped ped ");
      sb.append("      , ped_desconto_indenizacao pd  ");
      sb.append("      , cli c ");
      sb.append("      , rep r ");
      sb.append("      , regionais_vendas rv ");
      sb.append("      , gerentes_regionais_vendas gr ");
      sb.append("  WHERE ped.rep_cdgo = r.rep_cdgo ");
      sb.append("    AND c.cli_cdgo = ped.cli_cdgo ");
      sb.append("    AND gr.codigo_gerente = r.codigo_gerente ");
      sb.append("    AND rv.codigo_regional = r.codigo_regional ");
      sb.append("    AND ped.rep_cdgo = NVL("+representante + ", ped.rep_cdgo) ");
      sb.append("    AND rv.codigo_regional = NVL("+regional + ", rv.codigo_regional) ");
      sb.append("    AND gr.codigo_gerente = NVL("+analista + ", gr.codigo_gerente) ");
      sb.append("    AND ped.ped_stat NOT IN ('C') ");
      sb.append("    AND pd.ped_nmro (+) = ped.ped_nmro ");
      sb.append(parametros);
      sb.append("  ORDER BY ped.ped_nmro ");

      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");

      if (usuario.mostraQuery()) {
        throw new Exception(sb.toString());
      }

      Vector res_Ped_desconto_indenizacao = j.select(table, sb.toString(), null);
      session.setAttribute("res_Ped_desconto_indenizacao",res_Ped_desconto_indenizacao);
      if (res_Ped_desconto_indenizacao != null && res_Ped_desconto_indenizacao.size() > 0) {

        if (res_Ped_desconto_indenizacao.size() > 1) {
          session.setAttribute("qtd_itens","10");
        } else {
          session.setAttribute("qtd_itens","1");
        }

        PedidosIndenizadosDescontosActionForm[]_ge_grid_array_flex = new PedidosIndenizadosDescontosActionForm[res_Ped_desconto_indenizacao.size()];
        org.apache.struts.config.ConfigEGenHelper.setFormPropertySize(mapping, "bl_form_Ped_desconto_indenizacao_lines", res_Ped_desconto_indenizacao.size());
        int _ge_pos = 0;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array_flex.length; _ge_grid_array_index++, _ge_pos++) {
          if (_ge_grid_array_index < _ge_grid_array.length) {
            f = _ge_grid_array[_ge_grid_array_index];
          } else {
            f = new PedidosIndenizadosDescontosActionForm();
            ActionServletWrapper actionServletWrapper = form.getServletWrapper();
            org.apache.struts.upload.CommonsMultipartRequestHandler commonsMultipartRequestHandler = new org.apache.struts.upload.CommonsMultipartRequestHandler();
            actionServletWrapper.setServletFor(commonsMultipartRequestHandler);
            f.setServlet(commonsMultipartRequestHandler.getServlet());
          }
          f.reset(mapping, request);
          if (res_Ped_desconto_indenizacao.size() > _ge_pos) {
            Jw_ped_desconto_indenizacao r = (Jw_ped_desconto_indenizacao) res_Ped_desconto_indenizacao.elementAt(_ge_pos);
            f.setBanco("S");
            f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "":"");
            f.setTipo_desconto((r.getTipo_desconto() != null) ? r.getTipo_desconto() + "":"");
            f.setPed_obse((r.getPed_obse() != null) ? r.getPed_obse() + "":"");
            f.setValor_desconto((r.getValor_desconto() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_desconto(), "##,##0.00") : "");
            f.setPercentual_desc((r.getPercentual_desc() != null) ? com.egen.util.text.FormatNumber.format(r.getPercentual_desc(), "##,##0.00") : "");
            f.setCnd_cdgo((r.getCnd_cdgo() != null) ? r.getCnd_cdgo() + "":"");
            f.setCnd_cdgo_ped((r.getCnd_cdgo() != null) ? r.getCnd_cdgo() + "":"");
            f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "":"");
            f.setSituacao_banco((r.getSituacao() != null) ? r.getSituacao() + "":"");
            f.setPrazo_adicional((r.getPrazo_adicional() != null) ? r.getPrazo_adicional() + "":"");
            f.setBanco((r.getBanco() != null) ? r.getBanco() + "":"");
            f.setPed_afv((r.getPed_sequencial_maquina() != null) ? r.getPed_sequencial_maquina() + "":"");
            f.setCliente((r.getCliente() != null) ? r.getCliente() + "":"");
            f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
            f.setStatus((r.getPed_stat() != null) ? r.getPed_stat() + "":"");
            f.setValor_pedido((r.getValor() != null) ? com.egen.util.text.FormatNumber.format(r.getValor(), "##,##0.00") : "");
            f.setCnd_desc((r.getCnd_desc() != null) ? r.getCnd_desc() + "":"");
            f.setPed_especie_pedido((r.getPed_especie_pedido() != null) ? r.getPed_especie_pedido() + "":"");
            f.setCodigo_marca((r.getCodigo_marca() != null) ? r.getCodigo_marca() + "":"");
            f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
            f.setCodigo_regional((r.getCodigo_regional() != null) ? r.getCodigo_regional() + "":"");
            f.setNome_regional((r.getNome_regional() != null) ? r.getNome_regional() + "":"");
            session.setAttribute("mostra","S");
          } else {
            f.reset(mapping, request);
          }
          _ge_grid_array_flex[_ge_grid_array_index] = f;
        }
        _ge_grid.set("bl_form_Ped_desconto_indenizacao_lines", _ge_grid_array_flex);
      } else {
        ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
        if (errors == null) {
          errors = new ActionErrors();
        }
        errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("warn.norowsselected",""));
        request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
        session.removeAttribute("mostra");
      }
      session.setAttribute(mapping.getName(), form);
    }
  }
  public ActionForward perform_update_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      try {
        update_action(j, mapping, form, request, response);
        session.setAttribute("ok", "s");
      }
      finally {}
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontosGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
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
  private void update_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
    PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
    util.consultas.Parametros parametros = new util.consultas.Parametros();
    util.consultas.com.PedidosIndenizadosDescontos pedidosIndenizadosDescontos = new util.consultas.com.PedidosIndenizadosDescontos();
    int limiteBonificacao = Integer.parseInt(parametros.retornaParametro("limite_bonificacao_pedido"));
    acesso.Sessao sessao = new acesso.Sessao(session);
    util.consultas.Query query = new util.consultas.Query();
    String liberadoLimite = query.retorna(j, "SELECT 'S' FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'usuario_liberado_limite_bonificacao_pedido' and valor = '" + sessao.getUsuario() + "'");
    if (liberadoLimite.equalsIgnoreCase("s")) {
      limiteBonificacao = 99999;
    }
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];

      if (f.getStatus() != null && (!(f.getStatus().equals("F")))) {

        if (f.getStatus() != null && (!(f.getStatus().equals("C")))) {


          if (((f.getTipo_desconto() != null && (!f.getTipo_desconto().equals(""))) || (f.getPed_obse() != null && (!f.getPed_obse().equals(""))) || (f.getValor_desconto() != null && (!f.getValor_desconto().equals(""))) || (f.getPrazo_adicional() != null && (!f.getPrazo_adicional().equals(""))) || (f.getCnd_cdgo() != null && (!f.getCnd_cdgo().equals("")))) && (f.getBanco() != null && (f.getBanco().equals("S"))) && (f.getAlterado() != null && (f.getAlterado().equals("S")))) {



            f.setValor_desconto(f.getValor_desconto().replace(",", "."));
            //f.setPercentual_desc(f.getPercentual_desc().replace(",","."));

            if (f.getPed_nmro().equals("")) {
              throw new Exception("Todos os parâmetros devem ser informados!");
            }

            if (f.getTipo_desconto().equals("")) {
              throw new Exception("O tipo de desconto deve ser informado!");
            }

            if (f.getValor_desconto().equals("")) {
              throw new Exception("Valor deve ser informado!");
            }

            if ((!(f.getValor_desconto().equals("")))) {
              String valor_pedido = f.getValor_pedido().replace(".", "").replace(",", ".");
              double valorPedido = Double.parseDouble(valor_pedido);
              double valorDesconto = Double.parseDouble(f.getValor_desconto());
              double descontoMaximo = valorPedido - ((50 / 100d) * valorPedido);
              if (Double.parseDouble(f.getValor_desconto()) > limiteBonificacao) {
                throw new Exception("Limite excedido");
              }

              if (Double.parseDouble(f.getValor_desconto()) > Double.parseDouble(valor_pedido)) {
                throw new Exception("Valor Desconto não pode ser maior que o valor do pedido.");
              }
              if (valorDesconto > descontoMaximo) {
                throw new Exception("Valor Desconto não pode ser maior que 50% do valor do pedido.");
              }
            }

            Ped_desconto_indenizacao table = new Ped_desconto_indenizacao();
            Vector sets = new Vector(10, 2);
            table.setPed_nmro(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPed_nmro()));
            if (f.getPed_nmro() != null) {
              sets.addElement("ped_nmro");
            }
            table.setTipo_desconto(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getTipo_desconto()));
            if (f.getTipo_desconto() != null) {
              sets.addElement("tipo_desconto");
            }
            table.setPed_obse(f.getPed_obse());
            if (f.getPed_obse() != null) {
              sets.addElement("ped_obse");
            }
            table.setValor_desconto(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getValor_desconto()));
            if (f.getValor_desconto() != null) {
              sets.addElement("valor_desconto");
            }
            /*
                 table.setPercentual_desc(com.egen.util.text.FormatNumber.parseDoubleWrapper(f.getPercentual_desc()));
                 if (f.getPercentual_desc() != null) {
                   sets.addElement("percentual_desc");
                 }
                */
            table.setCnd_cdgo(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getCnd_cdgo()));
            if (f.getCnd_cdgo() != null) {
              sets.addElement("cnd_cdgo");
            }

            table.setSituacao(f.getSituacao());

            if (f.getSituacao() != null) {
              sets.addElement("situacao");
            }

            table.setPrazo_adicional(com.egen.util.text.FormatNumber.parseIntegerWrapper(f.getPrazo_adicional()));
            if (f.getPrazo_adicional() != null) {
              sets.addElement("prazo_adicional");
            }

            table.setUsuario_criacao(sessao.getUsuario());
            sets.addElement("usuario_criacao");

            table.setData_criacao(new java.sql.Timestamp(new java.util.Date().getTime()));
            sets.addElement("data_criacao");

            if (sets != null && sets.size() > 0) {
              String[] set = new String[sets.size()];
              for (int i = 0; i < sets.size(); i++) {
                set[i] = (String) sets.elementAt(i);
              }
              int updated = 0;
              if (f.getSituacao_banco().equals("F")) {} else {
                updated = j.update(table, set);
              }

              if (updated == 0) {
                ActionErrors errors = new ActionErrors();
                errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("warn.norowsupdated", ": " + updated));
                request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
              } else {
                Vector res_Ped_desconto_indenizacao = (Vector) session.getAttribute("res_Ped_desconto_indenizacao");
                if (res_Ped_desconto_indenizacao != null) {
                  res_Ped_desconto_indenizacao.setElementAt(table, 0);
                  Ped_desconto_indenizacao r = (Ped_desconto_indenizacao) res_Ped_desconto_indenizacao.elementAt(0);
                  f.setPed_nmro((r.getPed_nmro() != null) ? r.getPed_nmro() + "" : "");
                  f.setTipo_desconto((r.getTipo_desconto() != null) ? r.getTipo_desconto() + "" : "");
                  f.setPed_obse((r.getPed_obse() != null) ? r.getPed_obse() + "" : "");
                  f.setValor_desconto((r.getValor_desconto() != null) ? com.egen.util.text.FormatNumber.format(r.getValor_desconto(), "##,##0.00") : "");
                  // f.setPercentual_desc((r.getPercentual_desc() != null) ? com.egen.util.text.FormatNumber.format(r.getPercentual_desc(), "##,##0.00") : "");
                  f.setCnd_cdgo((r.getCnd_cdgo() != null) ? r.getCnd_cdgo() + "" : "");
                  f.setSituacao((r.getSituacao() != null) ? r.getSituacao() + "" : "");
                  f.setPrazo_adicional((r.getPrazo_adicional() != null) ? r.getPrazo_adicional() + "" : "");
                }
              }
            }
            session.setAttribute(mapping.getName(), form);
          } else {

            if (((f.getTipo_desconto() != null && (!f.getTipo_desconto().equals(""))) || (f.getPed_obse() != null && (!f.getPed_obse().equals(""))) || (f.getValor_desconto() != null && (!f.getValor_desconto().equals(""))) || (f.getPrazo_adicional() != null && (!f.getPrazo_adicional().equals(""))) || (f.getCnd_cdgo() != null && (!f.getCnd_cdgo().equals("")))) && (f.getAlterado() != null && (f.getAlterado().equals("S")))) {

              f.setValor_desconto(f.getValor_desconto().replace(",", "."));
              //      f.setPercentual_desc(f.getPercentual_desc().replace(",","."));

              if (f.getPed_nmro().equals("")) {
                throw new Exception("Todos os parâmetros devem ser informados!");
              }

              if (f.getValor_desconto().equals("")) {
                throw new Exception("Valor deve ser informado!");
              }

              if ((!(f.getValor_desconto().equals("")))) {
                if (Double.parseDouble(f.getValor_desconto()) > limiteBonificacao) {
                  throw new Exception("Limite excedido");
                }
                String valor_pedido = f.getValor_pedido().replace(".", "").replace(",", ".");
                if (Double.parseDouble(f.getValor_desconto()) > Double.parseDouble(valor_pedido)) {
                  throw new Exception("Valor Desconto não pode ser maior que o valor do pedido.");
                }
              }

              String desconsiderarControleSaldo = query.retorna(j, "SELECT 'S' FROM wbrio.parametros WHERE par_sist_codigo = 'BRNET' AND nome = 'usuario_liberado_saldo_bonificacao_pedido' and valor = '" + sessao.getUsuario() + "'");
              if (!desconsiderarControleSaldo.equalsIgnoreCase("s")) {
                Double saldo = pedidosIndenizadosDescontos.retornaSaldo(j, Integer.parseInt(f.getCli_cdgo()), Integer.parseInt(f.getCodigo_marca()), Integer.parseInt(f.getEsc_seqn()));
                if ((saldo - Double.parseDouble(f.getValor_desconto())) < 0) {
                  throw new Exception("O saldo total que pode ser solicitado pelo cliente/loja/pedido/marca ("+f.getCli_cdgo() + "/"+f.getEsc_seqn() + "/"+f.getPed_nmro() + "/"+f.getCodigo_marca() + ") é: " + saldo + "! (Valor informado: "+Double.parseDouble(f.getValor_desconto()) + ")");
                }
              }

              String sit = f.getSituacao();
              if (sit.equalsIgnoreCase("N")) {
                sit = "A";
              }

              Ped_desconto_indenizacao table = new Ped_desconto_indenizacao();
              Object[][] name_value = { {"ped_nmro",com.egen.util.text.FormatNumber.toInteger(f.getPed_nmro())}, {"tipo_desconto",com.egen.util.text.FormatNumber.toInteger(f.getTipo_desconto())}, {"ped_obse",f.getPed_obse()}, {"valor_desconto",com.egen.util.text.FormatNumber.toDouble(f.getValor_desconto())}, {"cnd_cdgo",com.egen.util.text.FormatNumber.toInteger(f.getCnd_cdgo())}, {"situacao",sit}, {"prazo_adicional",com.egen.util.text.FormatNumber.toInteger(f.getPrazo_adicional())}, {"usuario_criacao", sessao.getUsuario()}, {"data_criacao", new java.sql.Timestamp(new java.util.Date().getTime())} };

              j.insert(table, name_value);

              Vector res_Ped_desconto_indenizacao = (Vector) session.getAttribute("res_Ped_desconto_indenizacao");
              if (res_Ped_desconto_indenizacao != null && table != null) {
                res_Ped_desconto_indenizacao.addElement(table);
                session.setAttribute("res_Ped_desconto_indenizacao", res_Ped_desconto_indenizacao);
              }
            }
          }
        }
      }
    }
  }
  public ActionForward perform_back_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontos_fForm.jsp", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
    }
    return actionForward;
  }
  public ActionForward perform_ajustar_pedidos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      ajustar_pedidos_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontosGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
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
  private void ajustar_pedidos_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    acesso.Sessao sessao = new acesso.Sessao(session);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
    PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
    boolean ajustou = false;
    int contador = 0;
    java.util.Vector res_Pedidos = (java.util.Vector) session.getAttribute("res_Ped_desconto_indenizacao");
    String flagExec = "";
    util.consultas.Parametros parametros = new util.consultas.Parametros();
    double percentualMaximo = Double.parseDouble(parametros.retornaParametro("percentual_maximo_valor_desconto"));
    util.consultas.Query query = new util.consultas.Query();

    int contador_validacao = 0;
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      portalbr.dbobj.view.Jw_ped_desconto_indenizacao t_ped_validacao = (portalbr.dbobj.view.Jw_ped_desconto_indenizacao) res_Pedidos.elementAt(contador_validacao++);
      if (f.getGridCheckField()) {
        if (!((t_ped_validacao.getPed_stat().equals("F")) || (t_ped_validacao.getPed_stat().equals("L")))) {
          if (t_ped_validacao.getSituacao().equals("A")) {
            double valor_desconto = Double.parseDouble(query.retorna(j, "SELECT (valor_desconto / fct_valor_pedido(pi.ped_nmro)) * 100 percentual_desconto FROM ped_desconto_indenizacao pi WHERE ped_nmro = " + f.getPed_nmro()));
            if (valor_desconto > percentualMaximo) {
              session.setAttribute("mensagem", "O valor de desconto não pode ser maior que " + percentualMaximo + "% do valor do pedido! (Pedido: " + f.getPed_nmro() + ")");
              throw new Exception("O valor de desconto não pode ser maior que " + percentualMaximo + "% do valor do pedido! (Pedido: " + f.getPed_nmro() + ")");
            }
          }
        }
      }
    }

    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      portalbr.dbobj.view.Jw_ped_desconto_indenizacao t_ped = (portalbr.dbobj.view.Jw_ped_desconto_indenizacao) res_Pedidos.elementAt(contador);
      if (f.getGridCheckField()) {
        if (!((t_ped.getPed_stat().equals("F")) || (t_ped.getPed_stat().equals("L")))) {
          if (t_ped.getSituacao().equals("A")) {
            double valor_pedido = 0;
            valor_pedido = Double.parseDouble(query.retorna(j, "SELECT fct_valor_pedido(" + f.getPed_nmro() + ") FROM dual"));
            String existe = query.retorna(j, "SELECT 'S' FROM ped_desconto_indenizacao WHERE ped_nmro = " + f.getPed_nmro() + " AND situacao = 'F'");
            if (!existe.equalsIgnoreCase("S")) {
              try {
                flagExec = "pre update ped_boni2";
                StringBuilder sbu = new StringBuilder();
                String existePia = query.retorna(j, "SELECT 'S' FROM ped_inf_adicionais WHERE ped_nmro = " + f.getPed_nmro());
                if (existePia.equalsIgnoreCase("S")) {
                  sbu.append(" UPDATE ped_inf_adicionais pia ");
                  sbu.append("    SET pia.ped_boni_avaria = nvl(pia.ped_boni_avaria, 0) ");
                  sbu.append("    + (SELECT valor_desconto ");
                  sbu.append("                                 FROM ped_desconto_indenizacao pd ");
                  sbu.append("                                WHERE pd.ped_nmro = " + f.getPed_nmro() + ") ");
                  sbu.append("  WHERE ped_nmro  = " + f.getPed_nmro());
                } else {
                  sbu.append(" INSERT INTO ped_inf_adicionais (ped_nmro, emp_empresa, ped_boni_avaria) ");
                  sbu.append(" VALUES ");
                  sbu.append("    (" + f.getPed_nmro());
                  sbu.append("    ,(SELECT emp_empresa FROM ped WHERE ped_nmro = " + f.getPed_nmro() + ") ");
                  sbu.append("    ,(SELECT valor_desconto ");
                  sbu.append("               FROM ped_desconto_indenizacao pd ");
                  sbu.append("              WHERE pd.ped_nmro = " + f.getPed_nmro() + ")) ");
                }
                query.execute(j, sbu.toString());
                query.execute(j, "UPDATE ped_desconto_indenizacao SET situacao = 'F' where ped_nmro = " + f.getPed_nmro());
                flagExec = "pos update ped_boni2";
                StringBuilder sbc = new StringBuilder();
                flagExec = "pre insert situacoes_pedidos";
                sbc.append("begin ");
                sbc.append(" delete situacoes_pedidos WHERE ped_nmro = " + f.getPed_nmro() + " AND ts_codigo_situacao = 123; ");
                sbc.append(" insert into situacoes_pedidos (ped_nmro,ts_codigo_situacao,dt_cad_situacao,usuario_situacao,observ_situacao) VALUES (" + f.getPed_nmro() + ",123,SYSDATE,'" + sessao.getUsuario() + "','" + f.getValor_desconto() + "'); ");
                sbc.append("end; ");
                java.sql.CallableStatement stmt;
                stmt = j.getConn().prepareCall(sbc.toString());
                stmt.execute();
                if (stmt != null) {
                  stmt.close();
                }
                flagExec = "pos insert situacoes_pedidos";
              } catch (Exception ex) {
                throw new Exception(ex.getMessage() + "###Pedido: " + f.getPed_nmro() + ", flag: " + flagExec + "###");
              }
            }
            ajustou = true;
          }
        }
      }
      contador++;
    }

    if (ajustou) {
      session.setAttribute("mensagem", "Os pedidos foram ajustados com sucesso!");
    }
  }
  public ActionForward perform_cancelar_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
      cancelar_action(j, mapping, form, request, response);
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontosGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void cancelar_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    DynaActionForm _ge_grid = (DynaActionForm) form;
    PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
    PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];
    boolean cancelou = false;
    int contador = 0;
    java.util.Vector res_Pedidos = (java.util.Vector) session.getAttribute("res_Ped_desconto_indenizacao");
    for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
      f = _ge_grid_array[_ge_grid_array_index];
      portalbr.dbobj.view.Jw_ped_desconto_indenizacao t_ped = (portalbr.dbobj.view.Jw_ped_desconto_indenizacao) res_Pedidos.elementAt(contador);
      if (f.getGridCheckField()) {
        // if(!((t_ped.getPed_stat().equals("F")))){
        if (true) { // Liberado para todas as situações
          util.consultas.Query query = new util.consultas.Query();
          query.execute(j, "UPDATE ped_desconto_indenizacao SET situacao = 'C' where ped_nmro = "+f.getPed_nmro());
          String emailRepresentante = query.retorna("SELECT r.rep_endereco_eletronico FROM rep r, ped p WHERE p.rep_cdgo = r.rep_cdgo and p.ped_nmro = " + f.getPed_nmro());
          String motivo = query.retorna("SELECT ped_obse FROM ped_desconto_indenizacao WHERE ped_nmro = " + f.getPed_nmro());
          cancelou = true;
          if (!emailRepresentante.equals("")) {
            util.email.EmailUtil email = new util.email.EmailUtil();
            email.inicializa();
            email.setEmailDestinatario(emailRepresentante);
            email.setAssunto("Solicitacao de indenizacao cancelada");
            email.adicionaLinha("A solicitacao de indenizacao para o ped "+f.getPed_nmro() + " foi cancelada.");
            if (!motivo.equals("")) {
              email.adicionaLinha("Motivo : " + motivo);
            }
            email.enviarEmail();
          }
        }
      }
      contador++;
    }
    if (cancelou) {
      session.setAttribute("mensagem", "As indenizações foram canceladas com sucesso!");
    }
  }
  public ActionForward perform_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];


      try {
        tg_marcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_marcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      if (_ge_grid_array != null) {
        PedidosIndenizadosDescontosActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(true);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }

  public ActionForward perform_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      PedidosIndenizadosDescontosActionForm f = _ge_grid_array[0];


      try {
        tg_desmarcar_todos_action(mapping, form, request, response);
      }
      finally {
      }
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped_desconto_indenizacao", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void tg_desmarcar_todos_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    try {
      DynaActionForm _ge_grid = (DynaActionForm) form;
      PedidosIndenizadosDescontosActionForm[]_ge_grid_array = (PedidosIndenizadosDescontosActionForm[])_ge_grid.get("bl_form_Ped_desconto_indenizacao_lines");
      if (_ge_grid_array != null) {
        PedidosIndenizadosDescontosActionForm f = null;
        for (int _ge_grid_array_index = 0; _ge_grid_array_index < _ge_grid_array.length; _ge_grid_array_index++) {
          f = _ge_grid_array[_ge_grid_array_index];
          f.setGridCheckField(false);
        }
      }
      session.setAttribute(mapping.getName(), form);
    } catch (Exception e) {
      throw e;
    }
  }
  public ActionForward perform_update_pedido_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      double valor_pedido = 0;
      util.consultas.Query query = new util.consultas.Query();
      j = new com.egen.util.jdbc.JdbcUtil();
      PedidosIndenizadosDescontosActionForm f = (PedidosIndenizadosDescontosActionForm) form;
      valor_pedido = Double.parseDouble(query.retorna(j, "SELECT fct_valor_pedido("+f.getPed_nmro1() + ") FROM dual"));
      String existe = query.retorna(j, "SELECT 'S' FROM ped_inf_adicionais WHERE ped_nmro = " + f.getPed_nmro1());
      if (existe.equalsIgnoreCase("S")) {
        StringBuilder sbu = new StringBuilder();
        sbu.append(" UPDATE ped_inf_adicionais pia ");
        sbu.append("    SET pia.ped_boni_avaria = pia.ped_boni_avaria ");
        sbu.append("  + (round((SELECT valor_desconto ");
        sbu.append("                    FROM ped_desconto_indenizacao pd ");
        sbu.append("                   WHERE pd.ped_nmro = ").append(f.getPed_nmro1()).append(") * 100 / (").append(valor_pedido).append("),2)) WHERE pia.ped_nmro = ").append(f.getPed_nmro1());
        query.execute(j, sbu.toString());
      } else {
        StringBuilder sbi = new StringBuilder();
        sbi.append(" INSERT INTO ped_inf_adicionais (ped_nmro, emp_empresa, ped_boni_avaria) ");
        sbi.append("   VALUES (").append(f.getPed_nmro1());
        sbi.append("          ,(SELECT emp_empresa FROM ped WHERE ped_nmro = ").append(f.getPed_nmro1()).append(") ");
        sbi.append("      ,(ROUND((SELECT valor_desconto FROM ped_desconto_indenizacao pd WHERE pd.ped_nmro = ").append(f.getPed_nmro1()).append(") * 100 / (").append(valor_pedido).append("), 2)))");
        query.execute(j, sbi.toString());
      }
      query.execute(j, "UPDATE ped_desconto_indenizacao SET situacao = 'F' where ped_nmro = "+f.getPed_nmro1());
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontosGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_update_pedido1_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      PedidosIndenizadosDescontosActionForm f = (PedidosIndenizadosDescontosActionForm) form;
      query.execute(j, "UPDATE ped_desconto_indenizacao SET situacao = 'C' where ped_nmro = "+f.getPed_nmro1());
      String emailRepresentante = query.retorna("SELECT r.rep_endereco_eletronico FROM rep r, ped p WHERE p.rep_cdgo = r.rep_cdgo and p.ped_nmro = " + f.getPed_nmro1());
      String motivo = query.retorna("SELECT ped_obse FROM ped_desconto_indenizacao WHERE ped_nmro = " + f.getPed_nmro1());
      if (!emailRepresentante.equals("")) {
        util.email.EmailUtil email = new util.email.EmailUtil();
        email.inicializa();
        email.setEmailDestinatario(emailRepresentante);
        email.setAssunto("Solicitacao de indenizacao cancelada");
        email.adicionaLinha("A solicitacao de indenizacao para o ped "+f.getPed_nmro1() + " foi cancelada.");
        if (!motivo.equals("")) {
          email.adicionaLinha("Motivo : " + motivo);
        }
        email.enviarEmail();
      }
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontosGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  public ActionForward perform_update_pedido2_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      double valor_pedido = 0;
      j = new com.egen.util.jdbc.JdbcUtil();
      util.consultas.Query query = new util.consultas.Query();
      PedidosIndenizadosDescontosActionForm f = (PedidosIndenizadosDescontosActionForm) form;
      valor_pedido = Double.parseDouble(query.retorna(j, "SELECT fct_valor_pedido("+f.getPed_nmro1() + ") FROM dual"));
      query.execute(j, "UPDATE ped_desconto_indenizacao SET valor_desconto = null where ped_nmro = "+f.getPed_nmro1());
      query.execute(j, "UPDATE ped_desconto_indenizacao SET situacao = 'A' where ped_nmro = "+f.getPed_nmro1());
      query.execute(j, "UPDATE ped_desconto_indenizacao SET ped_obse = null where ped_nmro = "+f.getPed_nmro1());
      actionForward = new ActionForward("/com/PedidosIndenizadosDescontosGrid.do?select_action=", true);
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Ped", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
}
