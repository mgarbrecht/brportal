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
 * Creation Date 09/08/2006 17:05:23
 * Last Modify Date 03/10/2019 09:10:05
 */

public class ClientesGruposEconomicos_dAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    com.egen.util.jdbc.JdbcUtil j = null;
    try {
      j = new com.egen.util.jdbc.JdbcUtil();
      select_action(j, mapping, form, request, response);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
  private void select_action(JdbcUtil j, ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(true);
    ClientesGruposEconomicos_dActionForm f = (ClientesGruposEconomicos_dActionForm) form;
    portalbr.dbobj.view.Jw_plus_clientes table = new portalbr.dbobj.view.Jw_plus_clientes();
    boolean filtraPerfil = false;
    StringBuilder parametros = new StringBuilder();
    StringBuilder sbFiltro = new StringBuilder();
    acesso.Sessao sessao = new acesso.Sessao(session);

    String escSeqn = null;
    if (!((f.getEsc_seqn() + "").equalsIgnoreCase("null"))) {
      escSeqn = f.getEsc_seqn();
    }

    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE COMERCIAL")) {
      filtraPerfil = true;
      parametros.append(" AND cr.codigo_representante = '"+sessao.getChave() + "' ");
    }
    if (sessao.getTipoEntidadeNegocio().equals("REPRESENTANTE EXPORTACAO")) {
      filtraPerfil = true;
      parametros.append(" AND cr.codigo_representante = '"+sessao.getChave() + "' ");
    }
    if (sessao.getTipoEntidadeNegocio().equals("ANALISTA REGIONAL")) {
      filtraPerfil = true;
      parametros.append(" AND ger.codigo_gerente = "+sessao.getChave());
    }
    if (sessao.getTipoEntidadeNegocio().equals("REGIONAL DE VENDA")) {
      filtraPerfil = true;
      parametros.append(" AND reg.codigo_regional = "+sessao.getChave());
    }

    sbFiltro.append(" AND EXISTS (SELECT 1 ");
    sbFiltro.append("               FROM grupo_economico g ");
    sbFiltro.append("                  , cli cc ");
    sbFiltro.append("                  , cliente_representante cr ");
    sbFiltro.append("                  , rep rep ");
    sbFiltro.append("                  , regionais_vendas reg ");
    sbFiltro.append("                  , gerentes_regionais_vendas ger ");
    sbFiltro.append("              WHERE g.cli_cdgo = cc.cli_cdgo ");
    sbFiltro.append(parametros.toString());
    sbFiltro.append("                AND cc.cli_cdgo = ").append(f.getCli_cdgo());
    sbFiltro.append("                AND cr.codigo_cliente = cc.cli_cdgo ");
    sbFiltro.append("                AND cr.codigo_representante = rep.rep_cdgo ");
    sbFiltro.append("                AND ger.codigo_regional = reg.codigo_regional ");
    sbFiltro.append("                AND reg.codigo_regional = rep.codigo_regional ");
    sbFiltro.append("                AND NVL(cr.situacao, NULL) = 'A' ");
    sbFiltro.append("                AND NVL(rep.rep_situ, NULL) = 'A' ");
    sbFiltro.append("                AND NVL(ger.situacao_gerente, NULL) = 'A' ");
    sbFiltro.append("                AND cc.cli_cdgo = c.cli_cdgo ");
    sbFiltro.append("                AND ROWNUM = 1 ) ");


    StringBuilder sb = new StringBuilder();
    sb.append(" SELECT DISTINCT ");
    sb.append("        c.cli_cdgo ");
    sb.append("      , e.esc_seqn ");
    sb.append("      , c.cli_rzao ");
    sb.append("      , c.cli_nome ");
    sb.append("      , decode(C.cli_situ,'A','Ativo','I','Inativo') cli_situ ");
    sb.append("      , decode(s.esc_situacao,'A','Ativo','I','Inativo','F','Fechado') esc_situacao ");
    sb.append("      , c.cli_dtin ");
    sb.append("      , se.seg_desc ");
    sb.append("      , decode(c.cli_exige_pc,'S','Sim','N','Não','') cli_exige_pc ");
    sb.append("      , decode(C.cli_agrupa_notas,'S','Sim','N','Não','') cli_agrupa_notas ");
    sb.append("      , decode(C.cli_aceita_antecipacao,'S','Sim','N','Não','') cli_aceita_antecipacao ");
    sb.append("      , substr(ltrim(to_char(s.esc_cgc, '00000000000000')), 1, 2) || '.' ||  ");
    sb.append("            substr(ltrim(to_char(s.esc_cgc, '00000000000000')), 3, 3) || '.' ||  ");
    sb.append("            substr(ltrim(to_char(s.esc_cgc, '00000000000000')), 6, 3) || '/' ||  ");
    sb.append("            substr(ltrim(to_char(s.esc_cgc, '00000000000000')), 9, 4) || '-' ||  ");
    sb.append("            substr(ltrim(to_char(s.esc_cgc, '00000000000000')), 13, 2) cgc  ");
    sb.append("      , s.esc_inse inscricao ");
    sb.append("      , e.ecl_nome||', '|| e.ecl_nmro||' - '|| substr(e.ecl_cep,1,5)||'-'|| ");
    sb.append("            substr(e.ecl_cep,6,3) ender ");
    sb.append("      , e.ecl_bair||' - '||e.ecl_cdad||'/'||e.est_unifed bairro_cidade ");
    sb.append("      , e.ecl_cdad||' - '||e.est_unifed cid_uf ");
    sb.append("   FROM ecl            e ");
    sb.append("      , cli            c ");
    sb.append("      , esc            s ");
    sb.append("      , seg            se ");
    sb.append("  WHERE e.cli_cdgo   = s.cli_cdgo ");
    if (filtraPerfil) {
      sb.append(sbFiltro.toString());
    }

    sb.append("    AND e.cli_cdgo   = c.cli_cdgo ");
    sb.append("    AND e.esc_seqn   = s.esc_seqn ");

    if (escSeqn != null) {
      sb.append(" AND e.esc_seqn = " + escSeqn);
    }

    sb.append("    AND c.seg_cdgo   = se.seg_cdgo ");
    sb.append("    AND e.cli_cdgo   > 0 ");
    sb.append("    AND e.cli_cdgo   = ").append(f.getCli_cdgo());
    sb.append("    AND (e.ned_cdgo  = 'UNI' OR e.ned_cdgo   = 'ENT') ");

    Vector res_Jw_plus_clientes = j.select(table, sb.toString(), null);



    if (res_Jw_plus_clientes != null && res_Jw_plus_clientes.size() > 0) {
      portalbr.dbobj.view.Jw_plus_clientes r = (portalbr.dbobj.view.Jw_plus_clientes) res_Jw_plus_clientes.elementAt(0);
      f.setCli_cdgo((r.getCli_cdgo() != null) ? r.getCli_cdgo() + "":"");
      f.setEsc_seqn((r.getEsc_seqn() != null) ? r.getEsc_seqn() + "":"");
      f.setCliente(r.getCli_cdgo() + " - "+r.getEsc_seqn());
      f.setCli_rzao((r.getCli_rzao() != null) ? r.getCli_rzao() + "":"");
      f.setCli_nome((r.getCli_nome() != null) ? r.getCli_nome() + "":"");
      f.setSeg_desc((r.getSeg_desc() != null) ? r.getSeg_desc() + "":"");
      f.setCgc((r.getCgc() != null) ? r.getCgc() + "":"");
      f.setInscricao((r.getInscricao() != null) ? r.getInscricao() + "":"");
      f.setEnder((r.getEnder() != null) ? r.getEnder() + "":"");
      f.setBairro_cidade((r.getBairro_cidade() != null) ? r.getBairro_cidade() + "":"");
      f.setCid_uf((r.getCid_uf() != null) ? r.getCid_uf() + "":"");
      f.setCli_dtin(com.egen.util.text.FormatDate.format(r.getCli_dtin(), "dd/MM/yyyy"));
      f.setCli_situ((r.getCli_situ() != null) ? r.getCli_situ() + "":"");
      f.setEsc_situacao((r.getEsc_situacao() != null) ? r.getEsc_situacao() + "":"");
      f.setCli_exige_pc((r.getCli_exige_pc() != null) ? r.getCli_exige_pc() + "":"");
      f.setCli_agrupa_notas((r.getCli_agrupa_notas() != null) ? r.getCli_agrupa_notas() + "":"");
      f.setCli_aceita_antecipacao((r.getCli_aceita_antecipacao() != null) ? r.getCli_aceita_antecipacao() + "":"");

    }


    //----------------- CONTATO/FONE DO CLIENTE ---------------------
    String contato = "";
    String fone = "";
    portalbr.dbobj.view.Jw_clientes_contatos table_contatos = new portalbr.dbobj.view.Jw_clientes_contatos();
    StringBuilder sbc = new StringBuilder();
    sbc.append(" SELECT pec.pec_nome ");
    sbc.append("   FROM pec ");
    sbc.append("      , cli c ");
    sbc.append("  WHERE pec.cli_cdgo = ").append(f.getCli_cdgo());
    sbc.append("    AND c.cli_cdgo = pec.cli_cdgo ");
    if (filtraPerfil) {
      sbc.append(sbFiltro.toString());
    }
    sbc.append("    AND pec.esc_seqn = ").append(f.getEsc_seqn());

    Vector res_Jw_clientes_contatos = j.select(table_contatos, sbc.toString(), null);

    if (res_Jw_clientes_contatos != null && res_Jw_clientes_contatos.size() > 0) {
      portalbr.dbobj.view.Jw_clientes_contatos r1 = (portalbr.dbobj.view.Jw_clientes_contatos) res_Jw_clientes_contatos.elementAt(0);
      contato = r1.getPec_nome();
    }

    portalbr.dbobj.view.Jw_clientes_fones table_fones = new portalbr.dbobj.view.Jw_clientes_fones();
    StringBuilder sbf = new StringBuilder();
    sbf.append(" SELECT to_char(ffs_ddd2, '0000')||'-'||ffs_nmro2 fone ");
    sbf.append("   FROM fax_fon2 ff ");
    sbf.append("      , cli c ");
    sbf.append("  WHERE ff.cli_cdgo  = ").append(f.getCli_cdgo());
    sbf.append("    AND c.cli_cdgo = ff.cli_cdgo ");
    if (filtraPerfil) {
      sbf.append(sbFiltro.toString());
    }
    sbf.append("    AND ff.esc_seqn  = ").append(f.getEsc_seqn());
    sbf.append("    AND ff.ned_cdgo  ='UNI' ");

    Vector res_Jw_clientes_fones = j.select(table_fones, sbf.toString(), null);

    if (res_Jw_clientes_fones != null && res_Jw_clientes_fones.size() > 0) {
      for (int x = 0; x < res_Jw_clientes_fones.size(); x++) {
        portalbr.dbobj.view.Jw_clientes_fones r2 = (portalbr.dbobj.view.Jw_clientes_fones) res_Jw_clientes_fones.elementAt(x);
        fone += r2.getFone() + "  ";
      }
    }
    f.setContato(contato + " "+fone);

    if (!(res_Jw_plus_clientes != null && res_Jw_plus_clientes.size() > 0)) {
      ActionErrors errors = (ActionErrors) request.getAttribute(org.apache.struts.Globals.ERROR_KEY);
      if (errors == null) {
        errors = new ActionErrors();
      }
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Jw_plus_clientes", new ActionMessage("warn.norowsselected",""));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
    }
    session.setAttribute("mapping.getName()", form);
  }

}
