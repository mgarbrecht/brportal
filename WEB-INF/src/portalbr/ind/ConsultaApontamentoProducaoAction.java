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
 * Creation Date 27/05/2014 09:25:51
 * Last Modify Date 30/06/2020 15:48:50
 */

public class ConsultaApontamentoProducaoAction extends com.egen.util.struts.AbstractAction {

  public ActionForward perform_select_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      StringBuilder query = new StringBuilder();
      StringBuilder sbSetores = new StringBuilder();
      ConsultaApontamentoProducaoActionForm f = (ConsultaApontamentoProducaoActionForm) form;
      //--- Usuário ATELIER ---
      String atelier = null;
      acesso.Sessao sessao = new acesso.Sessao(session);
      if (sessao.getTipoEntidadeNegocio().equals("ATELIER")) {
        atelier = sessao.getChave();
      }
      if (atelier == null) {
        if (f.getRemessa().equals("")) {
          if (f.getFil_filial().equals("")) {
            throw new Exception("A filial deve ser informada!");
          }
        }
      }
      if (f.getRemessa().equals("")) {
        if (f.getData_inicial().equals("") || f.getData_final().equals("")) {
          throw new Exception("Todos os campos obrigatórios devem ser informados!");
        }
      }
      //-----------------------------------------------------------------
      if (session.getAttribute("listaSetores") != null) {
        for (String s:
            (java.util.List < String >) session.getAttribute("listaSetores")) {
          if (sbSetores.length() == 0) {
            sbSetores.append(" AND nvl(sf.set_cdgo,NULL) in (");
          } else {
            sbSetores.append(",");
          }
          sbSetores.append("'" + s + "'");
        }
        sbSetores.append(")");
      }
      if (f.getAbrir_remessa().equals("N")) {
        query.append(" SELECT app_minfab ");
        query.append("       ,fct_mask_modelo(lin_cdgo, ref_cdgo, cab_cdgo)||'.'||cor_cdgo modelo ");
        query.append("       ,lin_cdgo ");
        query.append("       ,DECODE('N', 'N', ref_cdgo) ref_cdgo ");
        query.append("       ,DECODE('S', 'S', cab_cdgo) cab_cdgo ");
        query.append("       ,DECODE('S', 'S', cor_cdgo) cor_cdgo ");
        query.append("       ,set_cdgo ");
        query.append("       ,SUM(pares) pares ");
        query.append("   FROM (SELECT to_number(fct_remov_carac_espec_cnpj(a.app_minfab)) app_minfab ");
        query.append("               ,r.lin_cdgo ");
        query.append("               ,t.ref_cdgo ");
        query.append("               ,t.cab_cdgo ");
        query.append("               ,t.cor_cdgo ");
        query.append("               ,f.ref_grupo_posicao_fab ");
        query.append("               ,sf.set_cdgo ");
        query.append("               ,CASE ");
        query.append("                      WHEN (a.set_cdgo = sf.set_cdgo) THEN ");
        query.append("                       a.app_parbom ");
        query.append("                      ELSE ");
        query.append("                       NULL ");
        query.append("                    END pares ");
        query.append("           FROM apont_prod a ");
        query.append("              , talao_fase tf ");
        query.append("              , remessa r ");
        query.append("              , talao t ");
        query.append("              , ref f ");
        query.append("              , set_fil sf ");
        query.append("          WHERE 1=1 ");
        if (f.getRemessa().equals("")) {
          if (f.getHora_inicial() != "") {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + " " + f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + "','dd/mm/yyyy') ");
          }
          if (f.getHora_final() != "") {
            query.append(" AND a.dtrh_corrente <= to_date('" + f.getData_final() + " " + f.getHora_final() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND a.dtrh_corrente < to_date('" + f.getData_final() + "','dd/mm/yyyy') + 1 ");
          }
        }
        query.append("            AND r.rem_nro = NVL(a.rem_nro, NULL) ");
        query.append("            AND NVL(r.emp_empresa, NULL) = nvl(null, r.emp_empresa) ");
        if (f.getFil_filial() != "") {
          query.append("         AND r.fil_filial = '" + f.getFil_filial() + "' ");
        }
        if (f.getRemessa() != "") {
          query.append("         AND a.rem_nro = " + f.getRemessa());
        }
        query.append("            AND a.rem_nro = tf.rem_nro ");
        query.append("            AND a.tal_nro = tf.tal_nro ");
        query.append("            AND a.set_cdgo = tf.set_cdgo ");
        if (f.getFil_filial() != "") {
          query.append("         AND NVL(tf.fil_filial, NULL) = '" + f.getFil_filial() + "' ");
        }
        query.append("            AND NVL(a.rem_nro, NULL) = t.rem_nro ");
        query.append("            AND NVL(a.tal_nro, NULL) = t.tal_nro ");
        query.append("            AND f.lin_cdgo = r.lin_cdgo ");
        query.append("            AND f.ref_cdgo = t.ref_cdgo ");
        if (f.getCodigo_marca() != "") {
          query.append("         AND NVL(f.codigo_marca, NULL) = " + f.getCodigo_marca());
        }
        if (f.getCodigo_mini_fabrica() != "") {
          query.append("         AND fct_remov_carac_espec_cnpj(a.app_minfab) = " + f.getCodigo_mini_fabrica());
        }
        query.append("            AND sf.emp_empresa = NVL(r.emp_empresa, NULL) ");
        query.append("            AND sf.fil_filial = NVL(r.fil_filial, NULL) ");
        query.append(sbSetores.toString());
        if (atelier != null) {
          query.append(" AND (NVL(fct_remov_carac_espec_cnpj(a.app_minfab),null),sf.fil_filial) IN (SELECT mfa_codigo, fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + ")");
          query.append(" AND tf.fil_filial IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + " ) AND r.fil_filial IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + " ) ");
        }
        query.append("         ) ");
        query.append("  GROUP BY app_minfab ");
        query.append("          ,lin_cdgo ");
        query.append("          ,fct_mask_modelo(lin_cdgo, ref_cdgo, cab_cdgo)||'.'|| cor_cdgo ");
        query.append("          ,DECODE('N', 'N', ref_cdgo) ");
        query.append("          ,DECODE('S', 'S', cab_cdgo) ");
        query.append("          ,DECODE('S', 'S', cor_cdgo) ");
        query.append("          ,set_cdgo ");
      } else if (f.getAbrir_remessa().equals("M")) {
        query.append(" SELECT app_minfab ");
        query.append("       ,fct_mask_modelo(lin_cdgo, ref_cdgo) modelo ");
        query.append("       ,lin_cdgo ");
        query.append("       ,DECODE('N', 'N', ref_cdgo) ref_cdgo ");
        query.append("       ,set_cdgo ");
        query.append("       ,SUM(pares) pares ");
        query.append("   FROM (SELECT to_number(fct_remov_carac_espec_cnpj(a.app_minfab)) app_minfab ");
        query.append("               ,r.lin_cdgo ");
        query.append("               ,t.ref_cdgo ");
        query.append("               ,f.ref_grupo_posicao_fab ");
        query.append("               ,sf.set_cdgo ");
        query.append("               ,SUM(CASE ");
        query.append("                      WHEN (a.set_cdgo = sf.set_cdgo) THEN ");
        query.append("                       a.app_parbom ");
        query.append("                      ELSE ");
        query.append("                       NULL ");
        query.append("                    END) pares ");
        query.append("           FROM apont_prod a ");
        query.append("              , talao_fase tf ");
        query.append("              , remessa r ");
        query.append("              , talao t ");
        query.append("              , ref f ");
        query.append("              , set_fil sf ");
        query.append("          WHERE 1=1 ");
        if (f.getRemessa().equals("")) {
          if (f.getHora_inicial() != "") {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + " " + f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + "','dd/mm/yyyy') ");
          }
          if (f.getHora_final() != "") {
            query.append(" AND a.dtrh_corrente <= to_date('" + f.getData_final() + " " + f.getHora_final() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND TRUNC(a.dtrh_corrente) <= to_date('" + f.getData_final() + "','dd/mm/yyyy') ");
          }
        }
        query.append("            AND r.rem_nro = NVL(a.rem_nro, NULL) ");
        query.append("            AND NVL(r.emp_empresa, NULL) = nvl(null, r.emp_empresa) ");
        if (f.getFil_filial() != "") {
          query.append("         AND NVL(r.fil_filial, NULL) = '" + f.getFil_filial() + "' ");
        }
        if (f.getRemessa() != "") {
          query.append("         AND a.rem_nro = " + f.getRemessa());
        }
        query.append("            AND a.rem_nro = tf.rem_nro ");
        query.append("            AND a.tal_nro = tf.tal_nro ");
        query.append("            AND a.set_cdgo = tf.set_cdgo ");
        if (f.getFil_filial() != "") {
          query.append("         AND NVL(tf.fil_filial, NULL) = '" + f.getFil_filial() + "' ");
        }
        query.append("            AND NVL(a.rem_nro, NULL) = t.rem_nro ");
        query.append("            AND NVL(a.tal_nro, NULL) = t.tal_nro ");
        query.append("            AND f.lin_cdgo = r.lin_cdgo ");
        query.append("            AND f.ref_cdgo = t.ref_cdgo ");
        if (f.getCodigo_marca() != "") {
          query.append("         AND NVL(f.codigo_marca, NULL) = " + f.getCodigo_marca());
        }
        if (f.getCodigo_mini_fabrica() != "") {
          query.append("         AND fct_remov_carac_espec_cnpj(a.app_minfab) = " + f.getCodigo_mini_fabrica());
        }
        query.append("            AND sf.emp_empresa = NVL(r.emp_empresa, NULL) ");
        query.append("            AND sf.fil_filial = NVL(r.fil_filial, NULL) ");
        query.append(sbSetores.toString());
        if (atelier != null) {
          query.append(" AND (NVL(fct_remov_carac_espec_cnpj(a.app_minfab),null),sf.fil_filial) IN (SELECT mfa_codigo, fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + ")");
          query.append(" AND NVL(tf.fil_filial, NULL) IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + " ) AND NVL(r.fil_filial, NULL) IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + " ) ");
        }
        query.append("          GROUP BY a.app_minfab ");
        query.append("                  ,r.lin_cdgo ");
        query.append("                  ,t.ref_cdgo ");
        query.append("                  ,f.ref_grupo_posicao_fab ");
        query.append("                  ,a.set_cdgo ");
        query.append("                  ,sf.set_cdgo ");
        query.append("                  ,sf.sequencia_setor) ");
        query.append("  GROUP BY app_minfab ");
        query.append("          ,lin_cdgo ");
        query.append("          ,fct_mask_modelo(lin_cdgo, ref_cdgo) ");
        query.append("          ,DECODE('N', 'N', ref_cdgo) ");
        query.append("          ,set_cdgo ");
      } else if (f.getAbrir_remessa().equals("N")) {
        query.append(" SELECT app_minfab ");
        query.append("       ,rem_nro ");
        query.append("       ,tal_nro ");
        query.append("       ,fct_mask_modelo(lin_cdgo, ref_cdgo, cab_cdgo)||'.'||cor_cdgo modelo ");
        query.append("       ,lin_cdgo ");
        query.append("       ,DECODE('N', 'N', ref_cdgo) ref_cdgo ");
        query.append("       ,DECODE('S', 'S', cab_cdgo) cab_cdgo ");
        query.append("       ,DECODE('S', 'S', cor_cdgo) cor_cdgo ");
        query.append("       ,set_cdgo ");
        query.append("       ,SUM(pares) pares ");
        query.append("   FROM (SELECT to_number(fct_remov_carac_espec_cnpj(a.app_minfab)) app_minfab ");
        query.append("               ,a.rem_nro ");
        query.append("               ,a.tal_nro ");
        query.append("               ,r.lin_cdgo ");
        query.append("               ,t.ref_cdgo ");
        query.append("               ,t.cab_cdgo ");
        query.append("               ,t.cor_cdgo ");
        query.append("               ,f.ref_grupo_posicao_fab ");
        query.append("               ,sf.set_cdgo ");
        query.append("               ,SUM(CASE ");
        query.append("                      WHEN (a.set_cdgo = sf.set_cdgo) THEN ");
        query.append("                       a.app_parbom ");
        query.append("                      ELSE ");
        query.append("                       NULL ");
        query.append("                    END) pares ");
        query.append("           FROM apont_prod a ");
        query.append("               ,talao_fase tf ");
        query.append("               ,remessa r ");
        query.append("               ,talao t ");
        query.append("               ,REF f ");
        query.append("               ,set_fil sf ");
        query.append("          WHERE 1=1 ");
        if (f.getRemessa().equals("")) {
          if (f.getHora_inicial() != "") {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + " " + f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + "','dd/mm/yyyy') ");
          }
          if (f.getHora_final() != "") {
            query.append(" AND a.dtrh_corrente <= to_date('" + f.getData_final() + " " + f.getHora_final() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND TRUNC(a.dtrh_corrente) <= to_date('" + f.getData_final() + "','dd/mm/yyyy') ");
          }
        }
        query.append("            AND r.rem_nro = NVL(a.rem_nro, NULL) ");
        query.append("            AND NVL(r.emp_empresa, NULL) = nvl(null, r.emp_empresa) ");
        if (f.getFil_filial() != "") {
          query.append("         AND NVL(r.fil_filial, NULL) = '" + f.getFil_filial() + "' ");
        }
        if (f.getRemessa() != "") {
          query.append("         AND a.rem_nro = " + f.getRemessa());
        }
        query.append("            AND a.rem_nro = tf.rem_nro ");
        query.append("            AND a.tal_nro = tf.tal_nro ");
        query.append("            AND a.set_cdgo = tf.set_cdgo ");
        if (f.getFil_filial() != "") {
          query.append("         AND NVL(tf.fil_filial, NULL) = '" + f.getFil_filial() + "' ");
        }
        query.append("            AND NVL(a.rem_nro, NULL) = t.rem_nro ");
        query.append("            AND NVL(a.tal_nro, NULL) = t.tal_nro ");
        query.append("            AND f.lin_cdgo = r.lin_cdgo ");
        query.append("            AND f.ref_cdgo = t.ref_cdgo ");
        if (f.getCodigo_marca() != "") {
          query.append("         AND NVL(f.codigo_marca, NULL) = " + f.getCodigo_marca());
        }
        if (f.getCodigo_mini_fabrica() != "") {
          query.append("         AND fct_remov_carac_espec_cnpj(a.app_minfab) = " + f.getCodigo_mini_fabrica());
        }
        query.append("            AND sf.emp_empresa = NVL(r.emp_empresa, NULL) ");
        query.append("            AND sf.fil_filial = NVL(r.fil_filial, NULL) ");
        query.append(sbSetores.toString());
        if (atelier != null) {
          query.append(" AND nvl(fct_remov_carac_espec_cnpj(a.app_minfab),null) IN (SELECT mfa_codigo FROM atelier_fabricas_vw where for_codigo = " + atelier + ")");
          query.append(" AND NVL(tf.fil_filial, NULL) IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + ") AND NVL(r.fil_filial, NULL) IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + ") ");
        }
        query.append("          GROUP BY a.app_minfab ");
        query.append("                  ,a.rem_nro ");
        query.append("                  ,a.tal_nro ");
        query.append("                  ,r.lin_cdgo ");
        query.append("                  ,t.ref_cdgo ");
        query.append("                  ,t.cab_cdgo ");
        query.append("                  ,t.cor_cdgo ");
        query.append("                  ,f.ref_grupo_posicao_fab ");
        query.append("                  ,a.set_cdgo ");
        query.append("                  ,sf.set_cdgo ");
        query.append("                  ,sf.sequencia_setor) ");
        query.append("  GROUP BY app_minfab ");
        query.append("          ,rem_nro ");
        query.append("          ,tal_nro ");
        query.append("          ,lin_cdgo ");
        query.append("          ,fct_mask_modelo(lin_cdgo, ref_cdgo, cab_cdgo)||'.'|| cor_cdgo ");
        query.append("          ,DECODE('N', 'N', ref_cdgo) ");
        query.append("          ,DECODE('S', 'S', cab_cdgo) ");
        query.append("          ,DECODE('S', 'S', cor_cdgo) ");
        query.append("          ,set_cdgo ");
      } else {
        query.append(" SELECT app_minfab ");
        query.append("       ,rem_nro ");
        query.append("       ,rem_pares ");
        query.append("       ,tal_nro ");
        query.append("       ,fct_mask_modelo(lin_cdgo, ref_cdgo, cab_cdgo)||'.'||cor_cdgo modelo ");
        query.append("       ,lin_cdgo ");
        query.append("       ,DECODE('N', 'N', ref_cdgo) ref_cdgo ");
        query.append("       ,DECODE('S', 'S', cab_cdgo) cab_cdgo ");
        query.append("       ,DECODE('S', 'S', cor_cdgo) cor_cdgo ");
        query.append("       ,set_cdgo ");
        query.append("       ,SUM(pares) pares ");
        query.append("   FROM (SELECT to_number(fct_remov_carac_espec_cnpj(a.app_minfab)) app_minfab ");
        query.append("               ,a.rem_nro ");
        query.append("               ,a.tal_nro ");
        query.append("               ,r.lin_cdgo ");
        query.append("               ,t.ref_cdgo ");
        query.append("               ,r.rem_pares ");
        query.append("               ,t.cab_cdgo ");
        query.append("               ,t.cor_cdgo ");
        query.append("               ,f.ref_grupo_posicao_fab ");
        query.append("               ,sf.set_cdgo ");
        query.append("               ,SUM(CASE ");
        query.append("                      WHEN (a.set_cdgo = sf.set_cdgo) THEN ");
        query.append("                       a.app_parbom ");
        query.append("                      ELSE ");
        query.append("                       NULL ");
        query.append("                    END) pares ");
        query.append("           FROM apont_prod a ");
        query.append("               ,talao_fase tf ");
        query.append("               ,remessa r ");
        query.append("               ,talao t ");
        query.append("               ,REF f ");
        query.append("               ,set_fil sf ");
        query.append("          WHERE 1=1 ");
        if (f.getRemessa().equals("")) {
          if (f.getHora_inicial() != "") {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + " " + f.getHora_inicial() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND a.dtrh_corrente >= to_date('" + f.getData_inicial() + "','dd/mm/yyyy') ");
          }
          if (f.getHora_final() != "") {
            query.append(" AND a.dtrh_corrente <= to_date('" + f.getData_final() + " " + f.getHora_final() + "','dd/mm/yyyy hh24:mi') ");
          } else {
            query.append(" AND TRUNC(a.dtrh_corrente) <= to_date('" + f.getData_final() + "','dd/mm/yyyy') ");
          }
        }
        query.append("            AND r.rem_nro = NVL(a.rem_nro, NULL) ");
        query.append("            AND NVL(r.emp_empresa, NULL) = nvl(null, r.emp_empresa) ");
        if (f.getFil_filial() != "") {
          query.append("         AND NVL(r.fil_filial, NULL) = '" + f.getFil_filial() + "' ");
        }
        if (f.getRemessa() != "") {
          query.append("         AND a.rem_nro = " + f.getRemessa());
        }
        query.append("            AND a.rem_nro = tf.rem_nro ");
        query.append("            AND a.tal_nro = tf.tal_nro ");
        query.append("            AND a.set_cdgo = tf.set_cdgo ");
        if (f.getFil_filial() != "") {
          query.append("         AND NVL(tf.fil_filial, NULL) = '" + f.getFil_filial() + "' ");
        }
        query.append("            AND NVL(a.rem_nro, NULL) = t.rem_nro ");
        query.append("            AND NVL(a.tal_nro, NULL) = t.tal_nro ");
        query.append("            AND f.lin_cdgo = r.lin_cdgo ");
        query.append("            AND f.ref_cdgo = t.ref_cdgo ");
        if (f.getCodigo_marca() != "") {
          query.append("         AND NVL(f.codigo_marca, NULL) = " + f.getCodigo_marca());
        }
        if (f.getCodigo_mini_fabrica() != "") {
          query.append("         AND fct_remov_carac_espec_cnpj(a.app_minfab) = " + f.getCodigo_mini_fabrica());
        }
        query.append("            AND sf.emp_empresa = NVL(r.emp_empresa, NULL) ");
        query.append("            AND sf.fil_filial = NVL(r.fil_filial, NULL) ");
        query.append(sbSetores.toString());
        if (atelier != null) {
          query.append(" AND nvl(fct_remov_carac_espec_cnpj(a.app_minfab),null) IN (SELECT mfa_codigo FROM atelier_fabricas_vw where for_codigo = " + atelier + ")");
          query.append(" AND NVL(tf.fil_filial, NULL) IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + " ) AND NVL(r.fil_filial, NULL) IN (SELECT distinct fil_filial FROM atelier_fabricas_vw where for_codigo = " + atelier + " ) ");
        }
        query.append("          GROUP BY a.app_minfab ");
        query.append("                  ,a.rem_nro ");
        query.append("                  ,a.tal_nro ");
        query.append("                  ,r.rem_pares ");
        query.append("                  ,r.lin_cdgo ");
        query.append("                  ,t.ref_cdgo ");
        query.append("                  ,t.cab_cdgo ");
        query.append("                  ,t.cor_cdgo ");
        query.append("                  ,f.ref_grupo_posicao_fab ");
        query.append("                  ,a.set_cdgo ");
        query.append("                  ,sf.set_cdgo ");
        query.append("                  ,sf.sequencia_setor) ");
        query.append("  GROUP BY app_minfab ");
        query.append("          ,rem_nro ");
        query.append("          ,tal_nro ");
        query.append("          ,lin_cdgo ");
        query.append("          ,rem_pares ");
        query.append("          ,fct_mask_modelo(lin_cdgo, ref_cdgo, cab_cdgo)||'.'|| cor_cdgo ");
        query.append("          ,DECODE('N', 'N', ref_cdgo) ");
        query.append("          ,DECODE('S', 'S', cab_cdgo) ");
        query.append("          ,DECODE('S', 'S', cor_cdgo) ");
        query.append("          ,set_cdgo ");
      }
      acesso.Usuario usuario = (acesso.Usuario) session.getAttribute("User");
      if (usuario.mostraQuery()) {
        throw new Exception(query.toString());
      }
      if (f.getTipo().equals("xls")) {
        util.file.GeraXLS g = new util.file.GeraXLS(request);
        if (f.getAbrir_remessa().equals("N")) {
          g.setRelatorio("ApontamentoProducaoXls.jasper");
        } else if (f.getAbrir_remessa().equals("M")) {
          g.setRelatorio("ApontamentoProducaoModeloXls.jasper");
        } else if (f.getAbrir_remessa().equals("S")) {
          g.setRelatorio("ApontamentoProducaoRemessaXls.jasper");
        } else {
          g.setRelatorio("ApontamentoProducaoRemessaSetorXls.jasper");
        }
        g.setParametro("P_QUERY", query.toString());
        g.gerar();
        request.setAttribute("abre_automaticamenteXLS", "N");
      } else {
        util.file.GeraPDF g = new util.file.GeraPDF(request);
        if (f.getAbrir_remessa().equals("N")) {
          g.setRelatorio("ApontamentoProducao.jasper");
        } else if (f.getAbrir_remessa().equals("M")) {
          g.setRelatorio("ApontamentoProducaoModelo.jasper");
        } else if (f.getAbrir_remessa().equals("S")) {
          g.setRelatorio("ApontamentoProducaoRemessa.jasper");
        } else {
          g.setRelatorio("ApontamentoProducaoRemessaSetor.jasper");
        }
        g.setParametro("P_QUERY", query.toString());
        g.gerar();
        request.setAttribute("abre_automaticamentePDF", "N");
      }
      //-----------------------------------------------------------------
      actionForward = mapping.findForward("same");
    }
    catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Apont_prod", new ActionMessage("error.action.exception", com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    } finally {}
    return actionForward;
  }
  public ActionForward perform_resetfull_action(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    try {
      ConsultaApontamentoProducaoActionForm f = (ConsultaApontamentoProducaoActionForm) form;
      session.removeAttribute("res_Apont_prod");
      form.reset(mapping, request);
      session.setAttribute(mapping.getName(), form);
      session.removeAttribute("listaSetores");
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Apont_prod", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
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
      ConsultaApontamentoProducaoActionForm f = (ConsultaApontamentoProducaoActionForm) form;
      session.setAttribute(mapping.getName(), form);
      actionForward = mapping.findForward("same");
    } catch (Exception e) {
      ActionErrors errors = new ActionErrors();
      errors.add("ActionErrors.GLOBAL_ERROR_bl_form_Apont_prod", new ActionMessage("error.action.exception",com.egen.util.system.Error.getMessage(e)));
      request.setAttribute(org.apache.struts.Globals.ERROR_KEY, errors);
      session.setAttribute("exception", com.egen.util.system.Error.getDescription(e));
      actionForward = mapping.findForward("same");
    }
    return actionForward;
  }

}
