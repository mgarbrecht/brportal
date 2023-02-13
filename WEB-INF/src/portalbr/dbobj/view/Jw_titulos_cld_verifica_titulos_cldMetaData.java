package portalbr.dbobj.view;

/** DataBase Object from table .Jw_titulos_cld_verifica_titulos_cld
  * @version 05/07/2010 07:07:01
  */
public class Jw_titulos_cld_verifica_titulos_cldMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","titulo","8","false","text","titulo","","","","","","",},
                            {"java.sql.Timestamp","data_venc","22","false","text","data_venc","","","","","","",},
                            {"double","valor_cld","22","false","text","valor_cld","","","","","","",},
                            {"double","vlpcp","22","false","text","vlpcp","","","","","","",},
                            {"double","vldeb","22","false","text","vldeb","","","","","","",},
                            {"double","saldo","22","false","text","saldo","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select tit.tit_codigo titulo,  	tit.tit_datvenc data_venc,  	sum(tit.tit_valor)valor_cld,  	sum(nvl(tit.tit_vlpcp,0))vlpcp,  	sum(nvl(tit.tit_vldeb,0))vldeb,  	(sum(tit.tit_valor)-  	(sum(nvl(tit.tit_vlpcp,0))+ sum(nvl(tit.tit_vldeb,0))))saldo from titulos tit,  	rep rep,  	 gerentes_regionais_vendas ger where tit.tip_codigo='NTC'  and trunc(tit.tit_datemi)between to_date('10/10/1000','dd/mm/yyyy')and to_date('10/10/3000','dd/mm/yyyy')  and nvl(tit.tit_status,'X')='A'  and tit.rep_codigo=rep.rep_cdgo  and ger.codigo_gerente=1  and tit.cli_codigo=1  and rep.rep_cdgo=1  and rep.rep_gerente_antigo=ger.codigo_gerente  and(Tit.emp_empresa, Tit.fil_filial,  Tit.tip_codigo , Tit.tit_codigo)  NOT IN (select M.emp_empresa, M.fil_filial,  M.tip_codigo , M.tit_codigo  from mov_receber m  where NVL(M.emp_empresa,NULL)=nvl(Tit.emp_empresa,null)  and NVL(M.fil_filial,NULL)=nvl(Tit.fil_filial,null)  and NVL(M.tip_codigo,NULL)=nvl(Tit.tip_codigo,null)  and M.tit_codigo=nvl(Tit.tit_codigo,null)  and nvl(m.trn_codigo,null)in('DIS','TNC','CON','FAL','NEG','PNE')  and trunc(mov_data)<=to_date('10/10/3000','dd/mm/yyyy')  and nvl(m.mov_data,null)<=to_date('10/10/3000','dd/mm/yyyy')  and nvl(m.mov_sequencia,0)=0  and rownum=1) group by tit.tit_codigo,  tit.tit_datvenc,  tit.tit_valor,  tit.tit_vlpcp,  tit.tit_vldeb";
    return query;
  }

}
