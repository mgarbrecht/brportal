package util.boleto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import util.rand.Palavra;

public class GeracaoXML {

	private HttpServletRequest request;
	 
	public GeracaoXML(HttpServletRequest req){
		this.request = req;
	}

	public void gerar(String portador, String query) {
		PreparedStatement pstm = null;
		ResultSet rset = null;
		com.egen.util.jdbc.JdbcUtil j = null;
		try {
			String arquivo = Palavra.geraPalavra();
			util.consultas.Parametros parametros = new util.consultas.Parametros();
			j = new com.egen.util.jdbc.JdbcUtil();
			String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
			StringBuilder sbBB = new StringBuilder();
			sbBB.append(" SELECT to_char(CASE WHEN vencido = 'N' THEN f.tit_datvenc ELSE TRUNC(SYSDATE) END, 'dd/mm/yyyy') dtvencitrec ");
			sbBB.append("	   , CASE WHEN vencido = 'N' THEN f.tit_valor ELSE f.tit_valor + f.valor_vencido END vlrparcitrec ");
			sbBB.append("	   , '001' codbanco ");
			sbBB.append("	   , '9' dvbanco ");
			sbBB.append("	   , f.car_codigo codcartcob ");
			sbBB.append("	   , 'N' aceite ");
			sbBB.append("	   , to_char(f.tit_datemi,'dd/mm/yyyy') dtemitvenda ");
			sbBB.append("	      ,f.cli_rzao razcli ");
			sbBB.append("	      ,fct_formata_cnpj(f.esc_cgc) cnpjcli ");
			sbBB.append("	      ,f.ecl_cdad cidcli ");
			sbBB.append("	      ,f.est_unifed ufcli ");
			sbBB.append("	      ,'R$' codmoeda ");
			sbBB.append("	      ,'J' pessoacli ");
			sbBB.append("	      ,CASE WHEN vencido = 'N' THEN 'PAGÁVEL EM QUALQUER BANCO ATÉ O VENCIMENTO' ELSE 'PAGÁVEL SOMENTE NO BANCO DO BRASIL' END desclpmodbol ");
			sbBB.append("	      ,'' variacaocartcob ");
			sbBB.append("	      ,SUBSTR(f.tit_numbco, 0, LENGTH(f.tit_numbco) - 1) || '-' || SUBSTR(f.tit_numbco, LENGTH(f.tit_numbco), LENGTH(f.tit_numbco) - 1) nossonumero ");
			sbBB.append("	      ,to_char(SYSDATE,'dd/mm/yyyy') dataemissao ");
			sbBB.append("	      ,f.tit_numbco ");
			sbBB.append("	      ,f.tit_ageced ");
			sbBB.append("	      ,CASE ");
			sbBB.append("	         WHEN f.cac_sequencia = '106' THEN ");
			sbBB.append("	          ('0019' || ");
			sbBB.append("	          TO_CHAR((CASE ");
			sbBB.append("	                     WHEN vencido = 'N' THEN ");
			sbBB.append("	                      f.tit_datvenc ");
			sbBB.append("	                     ELSE ");
			sbBB.append("	                      TRUNC(SYSDATE) ");
			sbBB.append("	                   END) - TO_DATE('07/10/1997', 'dd/mm/yyyy')) || ");
			sbBB.append("	          TRIM(REPLACE(TO_CHAR((CASE ");
			sbBB.append("	                                  WHEN vencido = 'N' THEN ");
			sbBB.append("	                                   f.tit_valor ");
			sbBB.append("	                                  ELSE ");
			sbBB.append("	                                   f.tit_valor + f.valor_vencido ");
			sbBB.append("	                                END), '00000000.00'), '.', '')) || '834960' || ");
			sbBB.append("	          (substr(tit_numbco, length(tit_numbco) - 5, length(substr(tit_numbco, length(tit_numbco) - 5)) - 1)) || ");
			sbBB.append("	          '316800001819' || '18') ");
			sbBB.append("	         ELSE ");
			sbBB.append("	          (CASE ");
			sbBB.append("	            WHEN f.cac_sequencia IN (104, 105) THEN ");
			sbBB.append("	             ('0019' || ");
			sbBB.append("	             TO_CHAR((CASE ");
			sbBB.append("	                        WHEN vencido = 'N' THEN ");
			sbBB.append("	                         f.tit_datvenc ");
			sbBB.append("	                        ELSE ");
			sbBB.append("	                         TRUNC(SYSDATE) ");
			sbBB.append("	                      END) - TO_DATE('07/10/1997', 'dd/mm/yyyy')) || ");
			sbBB.append("	             TRIM(REPLACE(TO_CHAR((CASE ");
			sbBB.append("	                                     WHEN vencido = 'N' THEN ");
			sbBB.append("	                                      f.tit_valor ");
			sbBB.append("	                                     ELSE ");
			sbBB.append("	                                      f.tit_valor + f.valor_vencido ");
			sbBB.append("	                                   END), '00000000.00'), '.', '')) || '000000' || ");
			sbBB.append("	             SUBSTR(f.tit_numbco, 0, LENGTH(f.tit_numbco)) || '11') ");
			sbBB.append("	            ELSE ");
			sbBB.append("	             ('0019' || ");
			sbBB.append("	             TO_CHAR((CASE ");
			sbBB.append("	                        WHEN vencido = 'N' THEN ");
			sbBB.append("	                         f.tit_datvenc ");
			sbBB.append("	                        ELSE ");
			sbBB.append("	                         TRUNC(SYSDATE) ");
			sbBB.append("	                      END) - TO_DATE('07/10/1997', 'dd/mm/yyyy')) || ");
			sbBB.append("	             TRIM(REPLACE(TO_CHAR((CASE ");
			sbBB.append("	                                     WHEN vencido = 'N' THEN ");
			sbBB.append("	                                      f.tit_valor ");
			sbBB.append("	                                     ELSE ");
			sbBB.append("	                                      f.tit_valor + f.valor_vencido ");
			sbBB.append("	                                   END), '00000000.00'), '.', '')) || ");
			sbBB.append("	             SUBSTR(f.tit_numbco, 0, LENGTH(f.tit_numbco) - 1) || ");
			sbBB.append("	             LPAD(SUBSTR(f.tit_ageced, 0, LENGTH(f.tit_ageced) - 1), 4, 0) || ");
			sbBB.append("	             LPAD(f.cob_numero_da_conta_bancaria || f.car_codigo, 10, 0)) ");
			sbBB.append("	          END) ");
			sbBB.append("	       END base ");
			sbBB.append("	      ,instrucoes ");
			sbBB.append("	      ,SUBSTR(tit_ageced, 0, LENGTH(tit_ageced) - 1) || '-' || ");
			sbBB.append("	       SUBSTR(tit_ageced, LENGTH(tit_ageced), LENGTH(tit_ageced)) || '/' || ");
			sbBB.append("	       cob_numero_da_conta_bancaria || '-' || cob_digito_da_conta_bancaria agencia ");
			sbBB.append("	      ,encargos ");
			sbBB.append("	      ,f.tit_codigo ");
			sbBB.append("	      ,f.cli_rzao || CHR(10) || ecl_nome || ' ' || ecl_nmro || ' ' || ");
			sbBB.append("	       ecl_cpto || CHR(10) || ecl_cdad || ' - ' || est_unifed || ' - ' || ");
			sbBB.append("	       SUBSTR(ecl_cep, 0, 5) || '-' || SUBSTR(ecl_cep, 6, 8) endereco_sacado ");
			sbBB.append("	      ,'DM' especie_doc ");
			sbBB.append("	      ,f.cli_rzao || ' - ' || fct_formata_cnpj(f.esc_cgc) razclicnpj ");
			sbBB.append("	      ,CASE ");
			sbBB.append("	         WHEN f.cac_sequencia = '88' THEN ");
			sbBB.append("	          '17336831' ");
			sbBB.append("	         WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) = 0) THEN ");
			sbBB.append("	          '16148298' ");
			sbBB.append("	         WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) > 0) THEN ");
			sbBB.append("	          '17336831' ");
			sbBB.append("	         WHEN f.cac_sequencia = '90' THEN ");
			sbBB.append("	          '16148322' ");
			sbBB.append("	         WHEN f.cac_sequencia = '104' THEN ");
			sbBB.append("	          '19177411' ");
			sbBB.append("	         WHEN f.cac_sequencia = '105' THEN ");
			sbBB.append("	          '19209176' ");
			sbBB.append("	         WHEN f.cac_sequencia = '106' THEN ");
			sbBB.append("	          '834960' ");
			sbBB.append("	       END contrato ");
			sbBB.append("         ,'' sacador ");
			sbBB.append("	      ,NVL(f.tit_vlncciaa, 0) tit_vlncciaa ");
			sbBB.append("         ,nvl(nf.chave_nfe,'') chave_nfe ");
			sbBB.append("	  FROM brconrec.v_duplicata f ");
		    sbBB.append("        , tit_nf tn ");
		    sbBB.append("        , nf_saida nf ");
			sbBB.append("	 WHERE NVL(f.prt_codigo, NULL) = '001' ");
			sbBB.append("      AND nf.emp_empresa (+) = tn.emp_empresa ");
			sbBB.append("      AND nf.fil_filial (+) = tn.fil_filial ");
			sbBB.append("	   AND nf.nfs_nmro (+) = tn.nsa_numero ");
			sbBB.append("	   AND nf.nfs_serie (+) = tn.nsa_serie ");
			sbBB.append("	   AND tn.emp_empresa (+) = f.emp_empresa ");
			sbBB.append("	   AND tn.fil_filial (+) = f.fil_filial ");
			sbBB.append("	   AND tn.tip_codigo (+) = f.tip_codigo ");
			sbBB.append("	   AND tn.tit_codigo (+) = f.tit_codigo ");
			sbBB.append("	   AND ").append(query);
			
			StringBuilder sbBanrisul = new StringBuilder();
			sbBanrisul.append(" SELECT to_char(CASE ");
			sbBanrisul.append("          WHEN vencido = 'N' THEN ");
			sbBanrisul.append("           f.tit_datvenc ");
			sbBanrisul.append("          ELSE ");
			sbBanrisul.append("           TRUNC(SYSDATE) ");
			sbBanrisul.append("        END,'dd/mm/yyyy') dtvencitrec ");
			sbBanrisul.append("       ,CASE ");
			sbBanrisul.append("          WHEN vencido = 'N' THEN ");
			sbBanrisul.append("           f.tit_valor ");
			sbBanrisul.append("          ELSE ");
			sbBanrisul.append("           f.tit_valor + f.valor_vencido ");
			sbBanrisul.append("        END vlrparcitrec ");
			sbBanrisul.append("       ,0.0 valor ");
			sbBanrisul.append("       ,'041' codbanco ");
			sbBanrisul.append("       ,'8' dvbanco ");
			sbBanrisul.append("       ,DECODE(f.car_codigo, 1, 'ELETR C/REG', 2, 'ELETR C/REG', '') codcartcob ");
			sbBanrisul.append("       ,'' aceite ");
			sbBanrisul.append("       ,to_char(f.tit_datemi,'dd/mm/yyyy') dtemitvenda ");
			sbBanrisul.append("       ,f.cli_rzao razcli ");
			sbBanrisul.append("       ,fct_formata_cnpj(f.esc_cgc) cnpjcli ");
			sbBanrisul.append("       ,f.ecl_cdad cidcli ");
			sbBanrisul.append("       ,f.est_unifed ufcli ");
			sbBanrisul.append("       ,'R$' codmoeda ");
			sbBanrisul.append("       ,'J' pessoacli ");
			sbBanrisul.append("       ,CASE ");
			sbBanrisul.append("          WHEN (TRUNC(tit_datvenc) - TRUNC(SYSDATE) < 0) THEN ");
			sbBanrisul.append("           'PAGÁVEL SOMENTE NO BANRISUL' ");
			sbBanrisul.append("          ELSE ");
			sbBanrisul.append("           'PAGUE PREFERENCIALMENTE NA REDE INTEGRADA BANRISUL' ");
			sbBanrisul.append("        END desclpmodbol ");
			sbBanrisul.append("       ,'' variacaocartcob ");
			sbBanrisul.append("       ,f.tit_numbco nossonumero ");
			sbBanrisul.append("       ,to_char(SYSDATE,'dd/mm/yyyy') dataemissao ");
			sbBanrisul.append("       ,f.tit_numbco ");
			sbBanrisul.append("       ,f.tit_ageced ");
			sbBanrisul.append("       ,'04191290' || '0478830' || substr(tit_numbco, 0, 8) || '041' || ");
			sbBanrisul.append("        TO_CHAR((CASE ");
			sbBanrisul.append("                  WHEN vencido = 'N' THEN ");
			sbBanrisul.append("                   f.tit_datvenc ");
			sbBanrisul.append("                  ELSE ");
			sbBanrisul.append("                   TRUNC(SYSDATE) ");
			sbBanrisul.append("                END) - TO_DATE('07/10/1997', 'dd/mm/yyyy')) || ");
			sbBanrisul.append("        TRIM(REPLACE(TO_CHAR((CASE ");
			sbBanrisul.append("                               WHEN vencido = 'N' THEN ");
			sbBanrisul.append("                                f.tit_valor ");
			sbBanrisul.append("                               ELSE ");
			sbBanrisul.append("                                f.tit_valor + f.valor_vencido ");
			sbBanrisul.append("                             END), '00000000.00'), '.', '')) base ");
			sbBanrisul.append("       ,instrucoes ");
			sbBanrisul.append("       ,'290.76  047883.0.32' agencia ");
			sbBanrisul.append("       ,encargos ");
			sbBanrisul.append("       ,f.tit_codigo ");
			sbBanrisul.append("       ,ecl_nome || ',' || ecl_nmro || ' ' || ecl_cpto || ' ' || ");
			sbBanrisul.append("        SUBSTR(ecl_cep, 0, 5) || '-' || SUBSTR(ecl_cep, 6, 8) || ' - ' || ");
			sbBanrisul.append("        ecl_cdad || ' - ' || est_unifed endereco_sacado ");
			sbBanrisul.append("       ,'8050 / CE' especie_doc ");
			sbBanrisul.append("       ,f.cli_rzao || ' - ' || fct_formata_cnpj(f.esc_cgc) razclicnpj ");
			sbBanrisul.append("       ,CASE ");
			sbBanrisul.append("          WHEN f.cac_sequencia = '88' THEN ");
			sbBanrisul.append("           '17336831' ");
			sbBanrisul.append("          WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) = 0) THEN ");
			sbBanrisul.append("           '16148298' ");
			sbBanrisul.append("          WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) > 0) THEN ");
			sbBanrisul.append("           '17336831' ");
			sbBanrisul.append("          WHEN f.cac_sequencia = '90' THEN ");
			sbBanrisul.append("           '16148322' ");
			sbBanrisul.append("        END contrato ");
			sbBanrisul.append("       ,'CALCADOS BEIRA RIO S/A  088379771000182' sacador ");
			sbBanrisul.append("       ,f.tit_valor ");
			sbBanrisul.append("       ,f.valor_vencido ");
			sbBanrisul.append("       ,f.tit_vlncciaa ");
			sbBanrisul.append("       ,nvl(nf.chave_nfe,'') chave_nfe ");
			sbBanrisul.append("   FROM brconrec.v_duplicata f ");
			sbBanrisul.append("      , tit_nf tn ");
			sbBanrisul.append("      , nf_saida nf ");
			sbBanrisul.append("  WHERE NVL(f.prt_codigo, NULL) = '041' ");
			sbBanrisul.append("    AND nf.emp_empresa (+) = tn.emp_empresa ");
			sbBanrisul.append("    AND nf.fil_filial (+) = tn.fil_filial ");
			sbBanrisul.append("	   AND nf.nfs_nmro (+) = tn.nsa_numero ");
			sbBanrisul.append("	   AND nf.nfs_serie (+) = tn.nsa_serie ");
			sbBanrisul.append("	   AND tn.emp_empresa (+) = f.emp_empresa ");
			sbBanrisul.append("	   AND tn.fil_filial (+) = f.fil_filial ");
			sbBanrisul.append("	   AND tn.tip_codigo (+) = f.tip_codigo ");
			sbBanrisul.append("	   AND tn.tit_codigo (+) = f.tit_codigo ");
			sbBanrisul.append("    AND ").append(query);

			StringBuilder sbBradesco = new StringBuilder();
			sbBradesco.append(" SELECT to_char(CASE ");
			sbBradesco.append("                 WHEN vencido = 'N' THEN ");
			sbBradesco.append("                  f.tit_datvenc ");
			sbBradesco.append("         ELSE ");
			sbBradesco.append("          TRUNC(SYSDATE) ");
			sbBradesco.append("       END, 'dd/mm/yyyy') dtvencitrec ");
			sbBradesco.append("      ,CASE ");
			sbBradesco.append(" WHEN vencido = 'N' THEN ");
			sbBradesco.append("  f.tit_valor ");
			sbBradesco.append(" ELSE ");
			sbBradesco.append("  f.tit_valor + f.valor_vencido ");
			sbBradesco.append(" END vlrparcitrec ");
			sbBradesco.append("      ,NULL valor ");
			sbBradesco.append("      ,'237' codbanco ");
			sbBradesco.append("      ,'2' dvbanco ");
			sbBradesco.append("      ,DECODE(f.car_codigo, '09', '9', f.car_codigo) codcartcob ");
			sbBradesco.append("      ,'N' aceite ");
			sbBradesco.append("      ,to_char(f.tit_datemi, 'dd/mm/yyyy') dtemitvenda ");
			sbBradesco.append("      ,f.cli_rzao razcli ");
			sbBradesco.append("      , fct_formata_cnpj(f.esc_cgc) cnpjcli ");
			sbBradesco.append("      ,f.ecl_cdad cidcli ");
			sbBradesco.append("      ,f.est_unifed ufcli ");
			sbBradesco.append("      ,'R$' codmoeda ");
			sbBradesco.append("      ,'J' pessoacli ");
			sbBradesco.append("      ,CASE ");
			sbBradesco.append("         WHEN vencido = 'N' THEN ");
			sbBradesco.append("          'Pagável Preferencialmente na Rede Bradesco ou no Bradesco Expresso.' ");
			sbBradesco.append("         ELSE ");
			sbBradesco.append("          'Pagável somente no Bradesco' ");
			sbBradesco.append("       END desclpmodbol ");
			sbBradesco.append("      ,'' variacaocartcob ");
			sbBradesco.append("      ,DECODE(vendor, 'N', (LPAD(SUBSTR(f.tit_numbco, 0, 11), 11, 0)), (SUBSTR(LPAD(tit_numbco, 12, 0), 2, 12))) nossonumero ");
			sbBradesco.append("      ,f.mov_data dataemissao ");
			sbBradesco.append("      ,DECODE(vendor, 'N', f.tit_numbco, (SUBSTR(LPAD(tit_numbco, 12, 0), 2, 12))) tit_numbco ");
			sbBradesco.append("      ,f.tit_ageced ");
			sbBradesco.append("      ,'2379X' || ");
			sbBradesco.append("       TO_CHAR((CASE ");
			sbBradesco.append("                 WHEN vencido = 'N' THEN ");
			sbBradesco.append("                  f.tit_datvenc ");
			sbBradesco.append("                 ELSE ");
			sbBradesco.append("                  TRUNC(SYSDATE) ");
			sbBradesco.append("               END) - TO_DATE('07/10/1997', 'dd/mm/yyyy')) || ");
			sbBradesco.append("       TRIM(REPLACE(TO_CHAR(((CASE ");
			sbBradesco.append("                              WHEN vencido = 'N' THEN ");
			sbBradesco.append("                               f.tit_valor ");
			sbBradesco.append("                              ELSE ");
			sbBradesco.append("                               f.tit_valor + f.valor_vencido ");
			sbBradesco.append("                            END)), '00000000.00'), '.', '')) || ");
			sbBradesco.append("       DECODE(vendor, 'N', (LPAD(SUBSTR(tit_ageced, 0, 4), 4, 0)), '4130') || ");
			sbBradesco.append("       LPAD(f.car_codigo, 2, 0) || ");
			sbBradesco.append("       DECODE(vendor, 'N', (LPAD(SUBSTR(f.tit_numbco, 0, 11), 11, 0)), (SUBSTR(LPAD(tit_numbco, 12, 0), 2, 12))) || ");
			sbBradesco.append("       DECODE(vendor, 'N', (CASE ");
			sbBradesco.append("                 WHEN emp_empresa = '01' THEN ");
			sbBradesco.append("                  '0000014' ");
			sbBradesco.append("                 ELSE ");
			sbBradesco.append("                  '0000018' ");
			sbBradesco.append("               END), '0052267') || '0' base ");
			sbBradesco.append("      ,instrucoes ");
			sbBradesco.append("      ,DECODE(vendor, 'N', (SUBSTR(tit_ageced, 0, LENGTH(tit_ageced) - 1)), '04130') || ");
			sbBradesco.append("       ' / ' || DECODE(vendor, 'N', (CASE ");
			sbBradesco.append("                          WHEN (multa_atraso_tit > 0 AND taxa_vendor_comprador > 0 AND ");
			sbBradesco.append("                               cac_sequencia <> 85) THEN ");
			sbBradesco.append("                           '0313254' ");
			sbBradesco.append("                          WHEN (multa_atraso_tit > 0 AND taxa_vendor_comprador > 0 AND ");
			sbBradesco.append("                               cac_sequencia = 85) THEN ");
			sbBradesco.append("                           '52267-8' ");
			sbBradesco.append("                          ELSE ");
			sbBradesco.append("                           (CASE ");
			sbBradesco.append("                             WHEN emp_empresa = '01' THEN ");
			sbBradesco.append("                              '14-0' ");
			sbBradesco.append("                             ELSE ");
			sbBradesco.append("                              cob_numero_da_conta_bancaria || '-' || ");
			sbBradesco.append("                              cob_digito_da_conta_bancaria ");
			sbBradesco.append("                           END) ");
			sbBradesco.append("                        END), '52267-8') agencia ");
			sbBradesco.append("      ,encargos ");
			sbBradesco.append("      ,f.tit_codigo ");
			sbBradesco.append("      ,ecl_nome || ',' || ecl_nmro || ' ' || ecl_cpto || ' ' || ");
			sbBradesco.append("       SUBSTR(ecl_cep, 0, 5) || '-' || SUBSTR(ecl_cep, 6, 8) || ' - ' || ");
			sbBradesco.append("       ecl_cdad || ' - ' || est_unifed endereco_sacado ");
			sbBradesco.append("      ,DECODE(vendor, 'N', 'DM', 'FI') especie_doc ");
			sbBradesco.append("      ,f.cli_rzao || ' - ' || fct_formata_cnpj(f.esc_cgc) razclicnpj ");
			sbBradesco.append("      ,CASE ");
			sbBradesco.append("         WHEN f.cac_sequencia = '88' THEN ");
			sbBradesco.append("          '17336831' ");
			sbBradesco.append("         WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) = 0) THEN ");
			sbBradesco.append("          '16148298' ");
			sbBradesco.append("         WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) > 0) THEN ");
			sbBradesco.append("          '17336831' ");
			sbBradesco.append("         WHEN f.cac_sequencia = '90' THEN ");
			sbBradesco.append("          '16148322' ");
			sbBradesco.append("       END contrato ");
			sbBradesco.append("      ,CASE ");
			sbBradesco.append("         WHEN f.emp_empresa = '02' THEN ");
			sbBradesco.append("          '' ");
			sbBradesco.append("         ELSE ");
			sbBradesco.append("          'CALCADOS BEIRA RIO S/A  088379771000182' ");
			sbBradesco.append("       END sacador ");
			sbBradesco.append("      ,f.emp_razsoc || ' - CNPJ/CPF: ' || fct_formata_cnpj(emp_cgc) razemp ");
			sbBradesco.append("      ,f.tit_vlncciaa ");
			sbBradesco.append("      ,nvl(nf.chave_nfe,'') chave_nfe ");
			sbBradesco.append("  FROM brconrec.v_duplicata f ");
			sbBradesco.append("     , tit_nf tn ");
			sbBradesco.append("     , nf_saida nf ");
			sbBradesco.append(" WHERE NVL(f.prt_codigo, NULL) = '237' ");
			sbBradesco.append("   AND nf.emp_empresa (+) = tn.emp_empresa ");
			sbBradesco.append("   AND nf.fil_filial (+) = tn.fil_filial ");
			sbBradesco.append("	  AND nf.nfs_nmro (+) = tn.nsa_numero ");
			sbBradesco.append("	  AND nf.nfs_serie (+) = tn.nsa_serie ");
			sbBradesco.append("	  AND tn.emp_empresa (+) = f.emp_empresa ");
			sbBradesco.append("	  AND tn.fil_filial (+) = f.fil_filial ");
			sbBradesco.append("	  AND tn.tip_codigo (+) = f.tip_codigo ");
			sbBradesco.append("	  AND tn.tit_codigo (+) = f.tit_codigo ");
			sbBradesco.append("   AND ").append(query);

			StringBuilder sbSantander = new StringBuilder();
			sbSantander.append(" SELECT to_char(CASE ");
			sbSantander.append("                 WHEN vencido = 'N' THEN ");
			sbSantander.append("                  f.tit_datvenc ");
			sbSantander.append("                 ELSE ");
			sbSantander.append("                  TRUNC(SYSDATE) ");
			sbSantander.append("               END, 'dd/mm/yyyy') dtvencitrec ");
			sbSantander.append("      ,CASE ");
			sbSantander.append("         WHEN vencido = 'N' THEN ");
			sbSantander.append("          f.tit_valor ");
			sbSantander.append("         ELSE ");
			sbSantander.append("          f.tit_valor + f.valor_vencido ");
			sbSantander.append("       END vlrparcitrec ");
			sbSantander.append("      ,0.0 valor ");
			sbSantander.append("      ,'033' codbanco ");
			sbSantander.append("      ,'7' dvbanco ");
			sbSantander.append("      ,DECODE(f.car_codigo, 1, 'ELETR C/REG', 2, 'ELETR C/REG', '') codcartcob ");
			sbSantander.append("      ,'NAO ACEITO' aceite ");
			sbSantander.append("      ,to_char(f.tit_datemi, 'dd/mm/yyyy') dtemitvenda ");
			sbSantander.append("      ,f.cli_rzao razcli ");
			sbSantander.append("      ,fct_formata_cnpj(f.esc_cgc) cnpjcli ");
			sbSantander.append("      ,f.ecl_cdad cidcli ");
			sbSantander.append("      ,f.est_unifed ufcli ");
			sbSantander.append("      ,'REAL' codmoeda ");
			sbSantander.append("      ,'J' pessoacli ");
			sbSantander.append("      ,CASE ");
			sbSantander.append("         WHEN vencido = 'N' THEN ");
			sbSantander.append("          'PAGÁVEL PREFERENCIALMENTE NO GRUPO SANTANDER' ");
			sbSantander.append("         ELSE ");
			sbSantander.append("          'PAGÁVEL SOMENTE NO SANTANDER' ");
			sbSantander.append("       END desclpmodbol ");
			sbSantander.append("      ,'' variacaocartcob ");
			sbSantander.append("      ,LPAD(f.tit_numbco, 13, '0') nossonumero ");
			sbSantander.append("      ,to_char(SYSDATE,'dd/mm/yyyy') dataemissao ");
			sbSantander.append("      ,f.tit_numbco ");
			sbSantander.append("      ,f.tit_ageced ");
			sbSantander.append("      ,'03399' || DECODE(vendor, 'N', (CASE ");
			sbSantander.append("                            WHEN (multa_atraso_tit > 0 AND taxa_vendor_comprador > 0) THEN ");
			sbSantander.append("                             '0313254' ");
			sbSantander.append("                            ELSE ");
			sbSantander.append("                             '5720338' ");
			sbSantander.append("                          END), '0313254') || LPAD(f.tit_numbco, 13, '0') || '0' || ");
			sbSantander.append("       DECODE(vendor, 'N', (CASE ");
			sbSantander.append("                 WHEN (multa_atraso_tit > 0 AND taxa_vendor_comprador > 0) THEN ");
			sbSantander.append("                  '104' ");
			sbSantander.append("                 ELSE ");
			sbSantander.append("                  '104' ");
			sbSantander.append("               END), '302') || ");
			sbSantander.append("       TO_CHAR((CASE ");
			sbSantander.append("                 WHEN vencido = 'N' THEN ");
			sbSantander.append("                  f.tit_datvenc ");
			sbSantander.append("                 ELSE ");
			sbSantander.append("                  TRUNC(SYSDATE) ");
			sbSantander.append("               END) - TO_DATE('07/10/1997', 'dd/mm/yyyy')) || ");
			sbSantander.append("       TRIM(REPLACE(TO_CHAR((CASE ");
			sbSantander.append("                              WHEN vencido = 'N' THEN ");
			sbSantander.append("                               f.tit_valor ");
			sbSantander.append("                              ELSE ");
			sbSantander.append("                               f.tit_valor + f.valor_vencido ");
			sbSantander.append("                            END), '00000000.00'), '.', '')) base ");
			sbSantander.append("      ,instrucoes ");
			sbSantander.append("      ,SUBSTR(tit_ageced, 0, LENGTH(tit_ageced) - 1) || ' / ' || ");
			sbSantander.append("       DECODE(vendor, 'N', (CASE ");
			sbSantander.append("                 WHEN (multa_atraso_tit > 0 AND taxa_vendor_comprador > 0) THEN ");
			sbSantander.append("                  '0313254' ");
			sbSantander.append("                 ELSE ");
			sbSantander.append("                  '5720338' ");
			sbSantander.append("               END), '0313254') agencia ");
			sbSantander.append("      ,encargos ");
			sbSantander.append("      ,f.tit_codigo ");
			sbSantander.append("      ,ecl_nome || ',' || ecl_nmro || ' ' || ecl_cpto || ' ' || ");
			sbSantander.append("       SUBSTR(ecl_cep, 0, 5) || '-' || SUBSTR(ecl_cep, 6, 8) || ' - ' || ");
			sbSantander.append("       ecl_cdad || ' - ' || est_unifed endereco_sacado ");
			sbSantander.append("      ,'DM' especie_doc ");
			sbSantander.append("      ,f.cli_rzao || ' - ' || fct_formata_cnpj(f.esc_cgc) razclicnpj ");
			sbSantander.append("      ,CASE ");
			sbSantander.append("         WHEN f.cac_sequencia = '88' THEN ");
			sbSantander.append("          '17336831' ");
			sbSantander.append("         WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) = 0) THEN ");
			sbSantander.append("          '16148298' ");
			sbSantander.append("         WHEN (f.cac_sequencia = '89' AND NVL(taxa_vendor_comprador, 0) > 0) THEN ");
			sbSantander.append("          '17336831' ");
			sbSantander.append("         WHEN f.cac_sequencia = '90' THEN ");
			sbSantander.append("          '16148322' ");
			sbSantander.append("       END contrato ");
			sbSantander.append("      ,'CALCADOS BEIRA RIO S/A  088379771000182' sacador ");
			sbSantander.append("      ,f.tit_vlncciaa ");
			sbSantander.append("      ,nvl(nf.chave_nfe,'') chave_nfe ");
			sbSantander.append("  FROM brconrec.v_duplicata f ");
			sbSantander.append("     , tit_nf tn ");
			sbSantander.append("     , nf_saida nf ");			
			sbSantander.append(" WHERE NVL(f.prt_codigo, NULL) = '033' ");
			sbSantander.append("   AND nf.emp_empresa (+) = tn.emp_empresa ");
			sbSantander.append("   AND nf.fil_filial (+) = tn.fil_filial ");
			sbSantander.append("   AND nf.nfs_nmro (+) = tn.nsa_numero ");
			sbSantander.append("   AND nf.nfs_serie (+) = tn.nsa_serie ");
			sbSantander.append("   AND tn.emp_empresa (+) = f.emp_empresa ");
			sbSantander.append("   AND tn.fil_filial (+) = f.fil_filial ");
			sbSantander.append("   AND tn.tip_codigo (+) = f.tip_codigo ");
			sbSantander.append("   AND tn.tit_codigo (+) = f.tit_codigo ");
			sbSantander.append("   AND ").append(query);

			String sbQuery = null;
			if (portador.equalsIgnoreCase("001")) {
				sbQuery = sbBB.toString();
			} else if (portador.equalsIgnoreCase("237")) {
				sbQuery = sbBradesco.toString();
			} else if (portador.equalsIgnoreCase("041")) {
				sbQuery = sbBanrisul.toString();
			} else {
				sbQuery = sbSantander.toString();
			}
			
			pstm = j.getConn().prepareStatement(sbQuery);
			rset = pstm.executeQuery();
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(diretorioTemporario + arquivo + ".txt"), "Windows-1252"));
			StringBuilder sbArquivo = new StringBuilder();
			sbArquivo.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append("\r\n");
		
			while (rset.next()) {
				sbArquivo.append("<boleto>").append("\r\n");
				sbArquivo.append("	<numero_documento>").append(rset.getString("tit_codigo")).append("</numero_documento>").append("\r\n");
				sbArquivo.append("	<banco>").append(rset.getString("codbanco")).append("</banco>").append("\r\n");
				sbArquivo.append("	<dv>").append(rset.getString("dvbanco")).append("</dv>").append("\r\n");
				
				if (portador.equalsIgnoreCase("001")) {
					sbArquivo.append("	<linha_digitavel>")
							.append(util.boleto.CodigoBarra.getLinhaDigitavel(rset.getString("base")))
							.append("</linha_digitavel>").append("\r\n");
				} else if (portador.equalsIgnoreCase("237")) {
					sbArquivo.append("	<linha_digitavel>")
							.append(util.boleto.CodigoBarraBradesco.getLinhaDigitavel(rset.getString("base")))
							.append("</linha_digitavel>").append("\r\n");
				} else if (portador.equalsIgnoreCase("041")) {
					sbArquivo.append("	<linha_digitavel>")
							.append(util.boleto.CodigoBarraBanrisul.getLinhaDigitavel(rset.getString("base")))
							.append("</linha_digitavel>").append("\r\n");
				} else {
					sbArquivo.append("	<linha_digitavel>")
							.append(util.boleto.CodigoBarraSantander.getLinhaDigitavel(rset.getString("base")))
							.append("</linha_digitavel>").append("\r\n");
				}
				sbArquivo.append("	<cedente>CALÇADOS BEIRA RIO S/A</cedente>").append("\r\n");
				sbArquivo.append("	<endereco_cedente>RS 239 KM-4 NR 4400 SAO JOSE NOVO HAMBURGO RS - 93352000</endereco_cedente>").append("\r\n");
				sbArquivo.append("	<especie>").append(rset.getString("codmoeda")).append("</especie>").append("\r\n");
				sbArquivo.append("	<nosso_numero>").append(rset.getString("nossonumero")).append("</nosso_numero>").append("\r\n");
				sbArquivo.append("	<cnpj_cedente>88379771/0001-82</cnpj_cedente>").append("\r\n");
				sbArquivo.append("	<aceite>").append(rset.getString("aceite")).append("</aceite>").append("\r\n");
				sbArquivo.append("	<especie>").append(rset.getString("especie_doc")).append("</especie>").append("\r\n");
				sbArquivo.append("	<data_documento>").append(rset.getString("dtemitvenda")).append("</data_documento>").append("\r\n");
				sbArquivo.append("	<contrato>").append(rset.getString("contrato")).append("</contrato>").append("\r\n");
				sbArquivo.append("	<vencimento>").append(rset.getString("dtvencitrec")).append("</vencimento>").append("\r\n");
				sbArquivo.append("	<valor_documento>").append(rset.getString("vlrparcitrec")).append("</valor_documento>").append("\r\n");
				sbArquivo.append("	<desconto_abatimento>").append(rset.getString("tit_vlncciaa")).append("</desconto_abatimento>").append("\r\n");
				sbArquivo.append("	<sacado>").append(rset.getString("razclicnpj")).append("</sacado>").append("\r\n");
				sbArquivo.append("	<cnpj_sacado>").append(rset.getString("cnpjcli")).append("</cnpj_sacado>").append("\r\n");
				sbArquivo.append("	<endereco_sacado>").append(rset.getString("endereco_sacado")).append("</endereco_sacado>").append("\r\n");
				sbArquivo.append("	<sacador_avalista>").append(rset.getString("sacador")).append("</sacador_avalista>").append("\r\n");
				sbArquivo.append("	<instrucoes>").append(rset.getString("instrucoes")).append("</instrucoes>").append("\r\n");
				sbArquivo.append("	<local_pagamento>").append(rset.getString("desclpmodbol")).append("</local_pagamento>").append("\r\n");
				sbArquivo.append("	<data_processamento>").append(rset.getString("dataemissao")).append("</data_processamento>").append("\r\n");
				sbArquivo.append("  <carteira>").append(rset.getString("codcartcob")).append(rset.getString("variacaocartcob")!=null?("/"+rset.getString("variacaocartcob")):"").append("</carteira>").append("\r\n");
				sbArquivo.append("  <chave_nfe>").append(rset.getString("chave_nfe")!=null?rset.getString("chave_nfe"):"").append("</chave_nfe>").append("\r\n");
				sbArquivo.append("</boleto>").append("\r\n");
			}
		    out.write(sbArquivo.toString());
			out.close();
			zipaArquivo(arquivo);
			excluiArquivo(diretorioTemporario + arquivo + ".txt");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rset != null) {
				try {
					rset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (j != null) {
				j.close();
			}
		}
	}
	
	private void zipaArquivo(String nomeArquivo) {
		util.consultas.Parametros parametros = new util.consultas.Parametros();
		String zipFile;
		String arquivo = nomeArquivo + ".zip";
		try {
			String diretorioTemporario = parametros.retornaParametro("diretorio_pdf");
			String link = parametros.retornaParametro("diretorio_link_pdf");
			zipFile = diretorioTemporario + arquivo;
			FileOutputStream fout = new FileOutputStream(zipFile);
			ZipOutputStream zout = new ZipOutputStream(fout);
			File f = new File(diretorioTemporario + nomeArquivo+".txt");
			try {
				byte[] buffer = new byte[1024];
				FileInputStream fin = new FileInputStream(f);
				zout.putNextEntry(new ZipEntry(f.getName()));
				int length;
				while ((length = fin.read(buffer)) > 0) {
					zout.write(buffer, 0, length);
				}
				zout.closeEntry();
				fin.close();
			} catch (IOException ioe) {
				ioe.printStackTrace(System.out);
			}
			zout.close();
			this.request.setAttribute("arquivo", link + arquivo);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	

	private void excluiArquivo(String arquivo) {
		File f = new File(arquivo);
		if (f.isFile()) {
			f.delete();
		}
	}

}
