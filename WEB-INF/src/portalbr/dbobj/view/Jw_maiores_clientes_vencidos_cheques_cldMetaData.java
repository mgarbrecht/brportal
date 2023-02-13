package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_vencidos_cheques_cld
  * @version 03/04/2013 09:22:29
  */
public class Jw_maiores_clientes_vencidos_cheques_cldMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","codigo","22","false","text","codigo","","","","","","",},
                            {"java.lang.String","fone","10","false","text","fone","","","","","","",},
                            {"java.lang.String","cliente","35","false","text","cliente","","","","","","",},
                            {"java.lang.String","ecl_cdad","33","false","text","ecl_cdad","","","","","","",},
                            {"java.lang.Integer","dias","22","false","text","dias","","","","","","",},
                            {"java.lang.Double","valor","22","false","text","valor","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT	CHE.CLI_CDGO 								codigo,  '' fone,  cl.cli_rzao cliente,  SUBSTR(E.ECL_CDAD, 1, 30)||'-'||E.EST_UNIFED ECL_CDAD,  		round((SYSDATE+1)- MIN(CHE.DATA_DE_DEPOSITO))	DIAS,  		SUM(FNC_CTR_SALDO_CHEQUE(CHE.NUMERO_DO_CHEQUE,CHE.AGE_CODIGO,CHE.PRT_CODIGO_BANCO,CHE.CLI_CDGO,  CHE.TIP_CODIGO,CHE.FIL_FILIAL,CHE.EMP_EMPRESA,CHE.SIT_CODIGO_SITUACAO_TITULO,  CHE.CHE_VLPCP,CHE.CHE_VLDEB,CHE.VALOR_DO_CHEQUE,CHE.VALOR_RECEBIDO))VALOR  FROM BRCONREC.CHEQUES	 CHE,  		 REP 								REP,  		 MOVIMENTOS_CHEQUE		MOV,  cli cl,  ecl e  WHERE   che.cli_cdgo=E.CLI_CDGO and cl.cli_cdgo=che.cli_cdgo AND  esc_seqn=1 and  E.NED_CDGO IN('UNI', 'COB')and   CHE.EMP_EMPRESA 						=MOV.EMP_EMPRESA  AND CHE.FIL_FILIAL 							=MOV.FIL_FILIAL  AND CHE.TIP_CODIGO 							=MOV.TIP_CODIGO  AND CHE.CLI_CDGO 			 				=MOV.CLI_CDGO  AND CHE.PRT_CODIGO_BANCO					=MOV.PRT_CODIGO_BANCO  AND CHE.AGE_CODIGO 							=MOV.AGE_CODIGO  AND CHE.NUMERO_DO_CHEQUE					=MOV.CHE_NUMERO_DO_CHEQUE  AND REP.REP_CDGO 								=CHE.REP_CDGO  AND CHE.EMP_EMPRESA 							='01'  AND CHE.SIT_CODIGO_SITUACAO_TITULO	='7'  AND REP.CODIGO_REGIONAL 	=NVL(1,REP.CODIGO_REGIONAL)  AND REP.REP_CDGO 	=NVL(null,REP.REP_CDGO)  AND CHE.DATA_DE_DEPOSITO 	 		 < TRUNC(SYSDATE - 10)  AND MOV.TRN_CODIGO 							='CLD'  AND TRUNC(MOV.DATA_DO_MOVIMENTO)		>=TO_DATE('01/01/2000','DD/MM/YYYY')  AND NOT EXISTS (SELECT '1'  FROM MOVIMENTOS_CHEQUE M  WHERE M.EMP_EMPRESA=CHE.EMP_EMPRESA  AND M.FIL_FILIAL=CHE.FIL_FILIAL  AND M.TIP_CODIGO=CHE.TIP_CODIGO  AND M.CLI_CDGO=CHE.CLI_CDGO  AND M.PRT_CODIGO_BANCO=CHE.PRT_CODIGO_BANCO  AND M.AGE_CODIGO=CHE.AGE_CODIGO  AND M.CHE_NUMERO_DO_CHEQUE=CHE.NUMERO_DO_CHEQUE  AND EXISTS (SELECT 1  FROM TRANSACOES_POR_GRUPO TRN_GRU  WHERE TRN_GRU.GRT_CODIGO_GRUPO_TRANSACAO=15  AND TRN_GRU.TRN_CODIGO=M.TRN_CODIGO  AND DATA_INICIAL <=SYSDATE  AND NVL(DATA_FINAL,SYSDATE)>=SYSDATE)  AND M.DATA_DO_MOVIMENTO <=TRUNC(SYSDATE)  AND NVL(M.MOC_SEQUENCIA,0)=0  AND ROWNUM=1)  GROUP BY	CHE.CLI_CDGO,  		 CHE.CHE_VLPCP,  		 CHE.CHE_VLDEB,  CL.CLI_CDGO,cl.cli_rzao,E.ECL_CDAD,E.EST_UNIFED";
    return query;
  }

}
