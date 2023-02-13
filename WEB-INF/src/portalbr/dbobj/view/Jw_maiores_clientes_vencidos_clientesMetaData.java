package portalbr.dbobj.view;

/** DataBase Object from table .Jw_maiores_clientes_vencidos_clientes
  * @version 03/04/2013 09:22:18
  */
public class Jw_maiores_clientes_vencidos_clientesMetaData {

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
    String query = "SELECT T.CLI_CODIGO codigo , '' fone ,c.cli_rzao cliente, SUBSTR(E.ECL_CDAD,1,30)||'-'||E.EST_UNIFED ECL_CDAD, ROUND(((SYSDATE)- MIN(T.TIT_DATVENC)))DIAS, SUM(FNC_CTR_SALDO_NEGOCIACAO(T.EMP_EMPRESA, T.FIL_FILIAL, T.TIP_CODIGO, T.TIT_CODIGO, T.SIT_CODIGO_SITUACAO_TITULO, T.TIT_VLPCP, T.TIT_VLDEB))VALOR FROM TITULOS T, ECL E, CLI c WHERE t.cli_codigo=E.CLI_CDGO and c.cli_cdgo=t.cli_codigo AND t.esc_seqn=DECODE(E.ESC_SEQN,0,1,E.ESC_SEQN)AND E.NED_CDGO IN('UNI','COB')and TIT_STATUS='A' AND T.EMP_EMPRESA='01' AND NVL(T.TIP_CODIGO,NULL)IN(SELECT TIT_GRU.TIP_CODIGO FROM TIPOS_DE_TITULO_POR_GRUPO TIT_GRU WHERE TIT_GRU.GTT_CODIGO_GRUPO_TIPO_TITULO=4)AND T.REP_CODIGO=NVL(null,T.REP_CODIGO)AND T.REV_CODIGO_REGIONAL=NVL(1,T.REV_CODIGO_REGIONAL)AND T.TIT_DATVENC < TRUNC(SYSDATE-10)AND T.TIPO_DE_MERCADO='MI' AND NOT EXISTS(SELECT 1 FROM MOV_RECEBER M WHERE NVL(M.EMP_EMPRESA,NULL)=NVL(T.EMP_EMPRESA,NULL)AND NVL(M.FIL_FILIAL,NULL)=NVL(T.FIL_FILIAL,NULL)AND NVL(M.TIP_CODIGO,NULL)=NVL(T.TIP_CODIGO,NULL)AND M.TIT_CODIGO=NVL(T.TIT_CODIGO,NULL)AND EXISTS(SELECT 1 FROM TRANSACOES_POR_GRUPO TRN_GRU WHERE TRN_GRU.GRT_CODIGO_GRUPO_TRANSACAO=15 AND TRN_GRU.TRN_CODIGO=M.TRN_CODIGO AND DATA_INICIAL <=SYSDATE AND NVL(DATA_FINAL,SYSDATE)>=SYSDATE)AND NVL(M.MOV_SEQUENCIA,0)=0 AND M.MOV_DATA <=TRUNC(SYSDATE - 10)AND ROWNUM=1)GROUP BY T.CLI_CODIGO, c.cli_rzao, E.ECL_CDAD, E.EST_UNIFED";
    return query;
  }

}
