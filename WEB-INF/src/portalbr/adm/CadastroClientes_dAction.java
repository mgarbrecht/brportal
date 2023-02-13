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
 * Creation Date 03/04/2006 16:45:36
 * Last Modify Date 27/11/2020 15:50:09
 */

public class CadastroClientes_dAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    //---------------------------------------------------------------------------------------
    // Autor             : Mateus Garbrecht (TechnoCorp)
    // Data de Criação   : 03/04/2006
    // Objetivo          : Mostra os dados do cliente selecionado no relatório:
    //                     /adm/CadastroClientes_rForm.jsp
    //----------------------------------------------------------------------------------------
    // Autor             : Ronaldo Prass (TechnoCorp)
    // Data de Alteração : 20/08/2008
    // Descrição         : Inclusão da coluna Transportadora
    //----------------------------------------------------------------------------------------
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_cad_roteiros", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception",com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {
      if (j != null) {
        j.close();
        j = null;
      }
    }
    return actionForward;
  }
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    //----------------------------------------------------------
    String codigo_regional = "null";
    String codigo_representante = "null";
    String codigo_analista = "";
    String tipo = "";
    String cliente = "null";
    acesso.Usuario u = new acesso.Usuario();
    u = (acesso.Usuario) session.getAttribute("User");
    acesso.EntidadeNegocio ent = new acesso.EntidadeNegocio();
    acesso.TipoEntidadeNegocio tipoent = new acesso.TipoEntidadeNegocio();
    if (!(u.getEntidadeNegocio() == null)) {
      ent = (acesso.EntidadeNegocio) u.getEntidadeNegocio();
      tipoent = (acesso.TipoEntidadeNegocio) ent.getTipoEntidadeNegocio();
      tipo = tipoent.getTipo() + "";
      if (tipo.equals("REGIONAL DE VENDA")) {
        codigo_regional = ent.getChave() + "";
      }
      if ((tipo.equals("REPRESENTANTE COMERCIAL")) || (tipo.equals("REPRESENTANTE EXPORTACAO"))) {
        codigo_representante = ent.getChave() + "";
      }
      if (tipo.equals("ANALISTA REGIONAL")) {
        codigo_analista = ent.getChave() + "";
      }
      if (tipo.equals("CLIENTE MERCADO EXTERNO")) {
        cliente = ent.getChave() + "";
      }
      if (tipo.equals("CLIENTE MERCADO INTERNO")) {
        cliente = ent.getChave() + "";
      }
    }

    if (tipo.equals("ANALISTA REGIONAL")) {
      com.egen.util.jdbc.JdbcUtil ja = null;
      try {
        ja = new com.egen.util.jdbc.JdbcUtil();
        portalbr.dbobj.view.Jw_regional_analista tablea = new portalbr.dbobj.view.Jw_regional_analista();
        String[][] select = null;
        Object[][] where = { {"codigo_gerente","=",codigo_analista} };
        Vector res_Jw_regional_analista = ja.select(tablea, select, where, null, null, null);
        if (res_Jw_regional_analista != null && res_Jw_regional_analista.size() > 0) {
          portalbr.dbobj.view.Jw_regional_analista r = (portalbr.dbobj.view.Jw_regional_analista) res_Jw_regional_analista.elementAt(0);
          codigo_regional = r.getCodigo_regional();
        }
      }
      finally {
        if (ja != null) {
          ja.close();
          ja = null;
        }
      }
    }
    //----------------------------------------------------------
    CadastroClientes_dActionForm f = (CadastroClientes_dActionForm) form;
    portalbr.dbobj.view.Jw_clientes_cad_roteiros table = new portalbr.dbobj.view.Jw_clientes_cad_roteiros();
    StringBuilder query = new StringBuilder();
    query.append(" SELECT /*+ all_rows */ ");
    query.append("        DISTINCT ");
    query.append("        cli.cli_cdgo || ' - ' || esc.esc_seqn cliente ");
    query.append("      , to_char(cli_dtin, 'dd/mm/yyyy')|| '(Rep' ||nvl(codigo_representante_abertura, '-') || ')' cliente_desde ");
    query.append("      , decode(cli_situ, 'A', 'Ativo', 'Inativo') || ' ' || mot.descricao_motivo situacao_cliente ");
    query.append("      , decode(esc.esc_situacao, 'A', 'Ativo', 'Inativo') situacao_loja ");
    query.append("      , cli_rzao ");
    query.append("      , cli_nome ");
    query.append("      , ecl_bair || ' - ' || ecl_cdad || '/' || ecl.est_unifed bairro_cidade_uf ");
    query.append("      , esc.esc_email ");
    query.append("      , tra.tra_nome transportadora ");
    query.append("      , cli.cli_cdgo ");
    query.append("      , esc.esc_seqn ");
    query.append("      , '' classificacao ");
    query.append("      , seg.seg_desc ");
    query.append("      , decode(cli.cli_aceita_antecipacao,'S','Sim','N','Não') cli_aceita_antecipacao ");
    query.append("      , decode(cli.cli_aceita_antecipacao_allegro,'S','Sim','N','Não') cli_aceita_antecipacao_allegro ");
    query.append("      , decode(cli.cli_aceita_antecipacao_riva,'S','Sim','N','Não') cli_aceita_antecipacao_riva ");
    query.append("      , (SELECT rowtocol('SELECT (gre_grupo ||'' - ''|| gre_descricao || '' ('' ||decode(status,''A'',''Ativo'',''Inativo'')||'')'') FROM grupo_economico WHERE cli_cdgo = ' || cli.cli_cdgo || 'order by status') from dual) grupo_economico ");
    query.append("      , '' situacao_grupo ");
    query.append("      , esc.codigo_motivo ");
    query.append("      , pck_motivo_bloqueio.get_nome(esc.codigo_motivo) descricao_motivo ");
    query.append("   FROM cli                       cli ");
    query.append("      , esc                       esc ");
    query.append("      , ecl                       ecl ");
    query.append("      , cliente_representante     cli_rep ");
    query.append("      , rep                       rep ");
    query.append("      , motivos_bloqueios         mot ");
    query.append("      , seg                       seg ");
    query.append("      , tra                       tra ");
    query.append("  WHERE mot.codigo_motivo(+) = cli.codigo_motivo ");
    query.append("    AND seg.seg_cdgo         = cli.seg_cdgo ");
    query.append("    AND esc.esc_seqn         = ecl.esc_seqn ");
    query.append("    AND cli.cli_cdgo         = esc.cli_cdgo ");
    query.append("    AND esc.cli_cdgo         = ecl.cli_cdgo ");
    query.append("    AND esc.cli_cdgo         = cli_rep.codigo_cliente ");
    query.append("    AND esc.esc_seqn         = cli_rep.codigo_sequencial ");
    query.append("    AND rep.rep_cdgo         = cli_rep.codigo_representante ");
    query.append("    AND (ecl.ned_cdgo = 'UNI' or ecl.ned_cdgo = 'ENT') ");
    query.append("    AND esc.tra_cdgo = tra.tra_cdgo");
    query.append("    AND esc.esc_seqn         = ").append(f.getEsc_seqn());
    query.append("    AND cli.cli_cdgo         = ").append(f.getCli_cdgo());
    query.append("    AND rep.rep_cdgo         = nvl("+ codigo_representante + ", rep.rep_cdgo) ");
    query.append("    AND rep.codigo_regional  = nvl("+ codigo_regional + ", rep.codigo_regional) ");

    if (false) {
      throw new Exception (query.toString());
    };
    Vector res_Jw_clientes_cad_roteiros = j.select(table, query.toString(), null);

    if (res_Jw_clientes_cad_roteiros != null && res_Jw_clientes_cad_roteiros.size() > 0) {
      portalbr.dbobj.view.Jw_clientes_cad_roteiros r = (portalbr.dbobj.view.Jw_clientes_cad_roteiros) res_Jw_clientes_cad_roteiros.elementAt(0);
      f.setCliente((r.getCliente() != null) ? r.getCliente() + "":"");
      f.setCliente_desde((r.getCliente_desde() != null) ? r.getCliente_desde() + "":"");
      f.setSituacao_cliente((r.getSituacao_cliente() != null) ? r.getSituacao_cliente() + "":"");
      f.setSituacao_loja((r.getSituacao_loja() != null) ? r.getSituacao_loja() + "":"");
      f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
      f.setCli_nome((r.getCli_nome() != null) ? r.getCli_nome() + "":"");
      f.setBairro_cidade_uf((r.getBairro_cidade_uf() != null) ? r.getBairro_cidade_uf() + "":"");
      f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
      f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
      f.setEsc_email((r.getEsc_email() != null) ? r.getEsc_email() + "":"");
      f.setTransportadora((r.getTransportadora() != null) ? r.getTransportadora() + "":"");
      f.setSeg_desc((r.getSeg_desc() != null) ? r.getSeg_desc() + "":"");
      f.setCli_aceita_antecipacao((r.getCli_aceita_antecipacao() != null) ? r.getCli_aceita_antecipacao() + "":"");
      f.setCli_aceita_antecipacao_allegro((r.getCli_aceita_antecipacao_allegro() != null) ? r.getCli_aceita_antecipacao_allegro() + "":"");
      f.setCli_aceita_antecipacao_riva((r.getCli_aceita_antecipacao_riva() != null) ? r.getCli_aceita_antecipacao_riva() + "":"");
      f.setGrupo_economico((r.getGrupo_economico() != null) ? r.getGrupo_economico() + "":"");
      f.setCodigo_motivo((r.getCodigo_motivo() != null) ? r.getCodigo_motivo() + "":"");
      f.setDescricao_motivo((r.getDescricao_motivo() != null) ? r.getDescricao_motivo() + "":"");

    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_cad_roteiros", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    //-------------------------------------------
    portalbr.dbobj.view.Jw_clientes_cad_dados_clientes table2 = new portalbr.dbobj.view.Jw_clientes_cad_dados_clientes();
    StringBuilder query2 = new StringBuilder();
    query2.append(" SELECT /*+ all_rows */ e.ecl_nome || ', ' || e.ecl_nmro || ' - ' || decode(ecl_cpto, null, '', ecl_cpto || ' - ') || ");
    query2.append("             substr(e.ecl_cep, 1, 5) || '-' || substr(e.ecl_cep, 6, 3) endereco ");
    query2.append("      , substr(to_char(s.esc_cgc, '00000000000000'), 0, 3) || '.' || ");
    query2.append("             substr(to_char(s.esc_cgc, '00000000000000'), 4, 3) || '.' || ");
    query2.append("             substr(to_char(s.esc_cgc, '00000000000000'), 7, 3) || '/' || ");
    query2.append("             substr(to_char(s.esc_cgc, '00000000000000'), 10, 4) || '-' || ");
    query2.append("             substr(to_char(s.esc_cgc, '00000000000000'), 14, 2) cgc ");
    query2.append("      , s.esc_inse inscricao ");
    query2.append("      , p.pec_nome pessoa ");
    query2.append("      , decode(nvl(c.classificacao, '@'), 'C', 'SIM', 'NÃO') classificacao ");
    query2.append("      , esc_indic_prote ind_prote ");
    query2.append("      , esc_num_dias_prote nro_dias_prote ");
    query2.append("   FROM ecl e ");
    query2.append("      , esc s ");
    query2.append("      , pec p ");
    query2.append("      , parametros_cobranca_cliente c ");
    query2.append("  WHERE e.cli_cdgo    = s.cli_cdgo ");
    query2.append("    AND e.esc_seqn    = s.esc_seqn ");
    query2.append("    AND p.cli_cdgo (+)= e.cli_cdgo ");
    query2.append("    AND p.esc_seqn (+)= e.esc_seqn ");
    query2.append("    AND e.cli_cdgo    = ").append(f.getCli_cdgo());
    query2.append("    AND e.esc_seqn    = ").append(f.getEsc_seqn());
    query2.append("    AND e.cli_cdgo    > 0 ");
    query2.append("    AND e.cli_cdgo    = c.cli_cdgo (+)");
    query2.append("    AND e.esc_seqn    = c.esc_seqn (+) ");
    query2.append("    AND (e.ned_cdgo = 'UNI' or e.ned_cdgo = 'ENT') ");

    Vector res_Jw_clientes_cad_dados_clientes = j.select(table2, query2.toString(), null);

    if (res_Jw_clientes_cad_dados_clientes != null && res_Jw_clientes_cad_dados_clientes.size() > 0) {
      portalbr.dbobj.view.Jw_clientes_cad_dados_clientes r2 = (portalbr.dbobj.view.Jw_clientes_cad_dados_clientes) res_Jw_clientes_cad_dados_clientes.elementAt(0);
      f.setEndereco((r2.getEndereco() != null) ? r2.getEndereco() + "":"");
      f.setCgc((r2.getCgc() != null) ? r2.getCgc() + "":"");
      f.setInscricao((r2.getInscricao() != null) ? r2.getInscricao() + "":"");
      f.setProtestar((r2.getInd_prote() != null) ? r2.getInd_prote() + "":"");
      f.setNro_dias((r2.getNro_dias_prote() != null) ? r2.getNro_dias_prote() + "":"");
      f.setVendor((r2.getClassificacao() != null) ? r2.getClassificacao() + "":"");
    } else {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_clientes_cad_roteiros", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    //------------------------------------------
    portalbr.dbobj.view.Jw_clientes_fones t_jw_clientes_fones = new portalbr.dbobj.view.Jw_clientes_fones();
    portalbr.dbobj.view.Jw_clientes_contatos t_jw_clientes_contatos = new portalbr.dbobj.view.Jw_clientes_contatos();
    String contatos_l = "";
    //------------------------------------------
    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT /*+ all_rows */ ");
    sb.append("        pec_nome ");
    sb.append("      , pec_cpf ");
    sb.append("   FROM pec ");
    sb.append("  WHERE cli_cdgo = ").append(f.getCli_cdgo());
    sb.append("    AND esc_seqn = ").append(f.getEsc_seqn());
    Vector res_Jw_clientes_contatos = j.select(t_jw_clientes_contatos, sb.toString(), null);
    session.setAttribute("res_Jw_clientes_contatos",res_Jw_clientes_contatos);
    //-------------------------------------------
    StringBuilder sb2 = new StringBuilder();
    sb2.append(" SELECT /*+ all_rows */ ");
    sb2.append("        to_char(ffs_ddd2, '0000')||'-'||ffs_nmro2 fone ");
    sb2.append("   FROM fax_fon2 ");
    sb2.append("  WHERE cli_cdgo = ").append(f.getCli_cdgo());
    sb2.append("    AND esc_seqn = ").append(f.getEsc_seqn());

    Vector res_Jw_clientes_fones = j.select(t_jw_clientes_fones, sb2.toString(), null);
    session.setAttribute("res_Jw_clientes_fones",res_Jw_clientes_fones);
    //-------------------------------------------------
    session.setAttribute(mapping.getName(), form);
  }
}
