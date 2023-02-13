package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld_verifica_repres_regional
  * @version 05/07/2010 07:07:14
  */
public class Jw_titulos_cld_verifica_repres_regionalMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","rep_cdgo","5","false","text","rep_cdgo","","","","","","",},
                            {"java.lang.String","rep_razao","35","false","text","rep_razao","","","","","","",},
                            {"java.lang.String","codigo_reg","22","false","text","codigo_reg","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select distinct rep_cdgo rep_cdgo, rep.rep_rzao rep_razao, ger.codigo_regional codigo_reg from titulos tit, rep rep, gerentes_regionais_vendas ger, cli c where tit.tip_codigo='NTC' and trunc(tit.tit_datemi)between to_date('10/10/1000','dd/mm/yyyy')AND to_date('10/10/3000','dd/mm/yyyy')and nvl(tit.tit_status,'X')='A' and tit.rep_codigo=rep.rep_cdgo and tit.cli_codigo=c.cli_cdgo and ger.codigo_gerente=1 and rep.rep_gerente_antigo=ger.codigo_gerente and(tit.emp_empresa, tit.fil_filial, tit.tip_codigo , tit.tit_codigo)not in(select m.emp_empresa, m.fil_filial, m.tip_codigo , m.tit_codigo from mov_receber m where nvl(m.emp_empresa,null)	=nvl(tit.emp_empresa,null)and nvl(m.fil_filial,null)	=nvl(tit.fil_filial,null)and nvl(m.tip_codigo,null)	=nvl(tit.tip_codigo,null)and m.tit_codigo 	=nvl(tit.tit_codigo,null)and nvl(m.trn_codigo,null)	in('DIS','TNC','CON','FAL','NEG','PNE')and trunc(mov_data)			<=to_date('10/10/3000','dd/mm/yyyy')and nvl(m.mov_data,null)		<=to_date('10/10/3000','dd/mm/yyyy')and nvl(m.mov_sequencia,0)	=0 and rownum=1)";
    return query;
  }

}
