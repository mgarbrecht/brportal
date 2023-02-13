package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_vencidos_cheques
  * @version 03/04/2013 09:22:41
  */
public class Jw_maiores_clientes_vencidos_chequesMetaData {

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
    String query = "SELECT C.CLI_CDGO codigo,  '' fone,  cl.cli_rzao cliente,  SUBSTR(E.ECL_CDAD, 1, 30)||'-'||E.EST_UNIFED ECL_CDAD,  round((SYSDATE+1)- MIN(C.DATA_DE_DEPOSITO))dias,  SUM(FNC_CTR_SALDO_CHEQUE(C.NUMERO_DO_CHEQUE,C.AGE_CODIGO,C.PRT_CODIGO_BANCO,C.CLI_CDGO,  C.TIP_CODIGO,C.FIL_FILIAL,C.EMP_EMPRESA,C.SIT_CODIGO_SITUACAO_TITULO,  C.CHE_VLPCP,C.CHE_VLDEB,C.VALOR_DO_CHEQUE,C.VALOR_RECEBIDO))valor  FROM BRCONREC.CHEQUES C,  REP R,  GERENTES_REGIONAIS_VENDAS G,  ECL E, CLI cl  WHERE c.cli_cdgo=E.CLI_CDGO and cl.cli_cdgo=c.cli_cdgo AND  esc_seqn=1 and  E.NED_CDGO IN('UNI', 'COB')and   C.SIT_CODIGO_SITUACAO_TITULO	IN('4')  AND NVL(C.TIP_CODIGO,NULL)	IN   											(SELECT TIT_GRU.TIP_CODIGO  											 FROM TIPOS_DE_TITULO_POR_GRUPO TIT_GRU  											 WHERE TIT_GRU.GTT_CODIGO_GRUPO_TIPO_TITULO=5)  AND R.REP_CDGO 						=C.REP_CDGO  AND G.CODIGO_GERENTE 						=R.REP_GERENTE_ANTIGO  AND C.REP_CDGO 						=NVL(null,C.REP_CDGO)  AND R.CODIGO_REGIONAL 						=NVL(1,R.CODIGO_REGIONAL)  AND C.DATA_DE_DEPOSITO 						< TRUNC(SYSDATE - 10)  AND NOT EXISTS (SELECT '1'  FROM MOVIMENTOS_CHEQUE M  WHERE M.EMP_EMPRESA=C.EMP_EMPRESA  AND M.FIL_FILIAL=C.FIL_FILIAL  AND M.TIP_CODIGO=C.TIP_CODIGO  AND M.CLI_CDGO=C.CLI_CDGO  AND M.PRT_CODIGO_BANCO=C.PRT_CODIGO_BANCO  AND M.AGE_CODIGO=C.AGE_CODIGO  AND M.CHE_NUMERO_DO_CHEQUE=C.NUMERO_DO_CHEQUE  AND EXISTS (SELECT 1  FROM TRANSACOES_POR_GRUPO TRN_GRU  WHERE TRN_GRU.GRT_CODIGO_GRUPO_TRANSACAO=15  AND TRN_GRU.TRN_CODIGO=M.TRN_CODIGO  AND DATA_INICIAL <=SYSDATE  AND NVL(DATA_FINAL,SYSDATE)>=SYSDATE)  AND M.DATA_DO_MOVIMENTO <=TRUNC(SYSDATE)  AND NVL(M.MOC_SEQUENCIA,0)=0  AND ROWNUM=1)  GROUP BY C.CLI_CDGO,cl.cli_rzao,E.ECL_CDAD,E.EST_UNIFED";
    return query;
  }

}
