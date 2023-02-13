package portalbr.dbobj.view;

/** DataBase Object from table .Jw_pendencias_regionais
  * @version 03/04/2013 09:19:04
  */
public class Jw_pendencias_regionaisMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"int","codigo_regional","10","false","text","","","","","","","",},
                            {"java.lang.String","nome_regional","40","false","text","","","","","","","",},
                            {"java.lang.String","rep_cdgo","5","false","text","","","","","","","",},
                            {"java.lang.String","rep_nome","35","false","text","","","","","","","",},
                            {"java.lang.String","rep_situ","1","false","text","","","","","","","",},
                            {"double","vencido","22","false","text","","","","","","","",},
                            {"double","vencer","22","false","text","","","","","","","",},
                            {"double","percentual","22","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT reg.codigo_regional,        reg.nome_regional,        rcd.rep_cdgo,         r.rep_rzao rep_nome,         r.rep_situ,         SUM(VLR_VENCIDO)         vencido ,         SUM(VLR_VENCER)          vencer,         case when (nvl(sum(vlr_vencido), 0) + nvl(sum(vlr_vencer), 0)) > 0 then              (sum(vlr_vencido) * 100 /              (sum(vlr_vencido) + sum(vlr_vencer)))             else 0         end percentual            FROM RESUMO_COBRANCA_DIARIO     RCD,        REGIONAIS_VENDAS           REG,        REP                        R  WHERE r.rep_cdgo = rcd.rep_cdgo    AND RCD.CODIGO_REGIONAL = REG.CODIGO_REGIONAL    AND DATA_COBRANCA = (SELECT MAX(DATA_COBRANCA)                           FROM RESUMO_COBRANCA_DIARIO)  GROUP BY reg.codigo_regional         , reg.nome_regional         , rcd.rep_cdgo         , r.rep_rzao         , r.rep_situ";
    return query;
  }

}
