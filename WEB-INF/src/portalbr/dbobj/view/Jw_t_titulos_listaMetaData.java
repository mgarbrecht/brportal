package portalbr.dbobj.view;

/** DataBase Object from table .Jw_t_titulos_lista
  * @version 17/05/2019 15:34:33
  */
public class Jw_t_titulos_listaMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.sql.Date","tit_datven3","12","false","text","","","","","","","",},
                            {"java.lang.String","tit_codigo","8","false","text","","","","","","","",},
                            {"java.lang.String","tit_numbco","20","false","text","","","","","","","",},
                            {"java.lang.String","tit_status","9","false","text","","","","","","","",},
                            {"java.lang.String","tip_codigo","3","false","text","","","","","","","",},
                            {"java.sql.Date","tit_datvenc","12","false","text","","","","","","","",},
                            {"java.sql.Date","tit_datrec","12","false","text","","","","","","","",},
                            {"java.sql.Date","tit_datemi","12","false","text","","","","","","","",},
                            {"double","tit_dspont","26","false","text","","","","","","","",},
                            {"double","tit_dsante","26","false","text","","","","","","","",},
                            {"double","tit_valor","24","false","text","","","","","","","",},
                            {"double","tit_vlrec","24","false","text","","","","","","","",},
                            {"java.lang.String","prt_codigo","4","false","text","","","","","","","",},
                            {"java.lang.String","prt_descri","30","false","text","","","","","","","",},
                            {"java.lang.String","emp_empresa","3","false","text","","","","","","","",},
                            {"java.lang.String","fil_filial","4","false","text","","","","","","","",},
                            {"java.lang.String","desc_sit","30","false","text","","","","","","","",},
                            {"java.lang.String","ncc","10","false","text","","","","","","","",},
                            {"java.lang.String","nota","10","false","text","","","","","","","",},
                            {"java.lang.String","serie","10","false","text","","","","","","","",},
                            {"double","taxa_juro","10","false","text","","","","","","","",},
                            {"java.lang.String","trn_codigo","10","false","text","","","","","","","",},
                            {"java.util.Date","mov_data","10","false","text","","","","","","","",},
                            {"java.util.Date","datvenc","10","false","text","","","","","","","",},
                            {"java.lang.String","cobjur","1","false","text","","","","","","","",},
                            {"java.lang.String","tit_abatim","1","false","text","","","","","","","",},
                            {"java.lang.String","vnc_cartor","10","false","text","","","","","","","",},
                            {"java.lang.String","dif","10","false","text","","","","","","","",},
                            {"java.lang.String","condes","10","false","text","","","","","","","",},
                            {"java.lang.String","rep_codigo","5","false","text","","","","","","","",},
                            {"java.sql.Date","data_atual","12","false","text","","","","","","","",},
                            {"java.lang.String","ped_nmro","10","false","text","","","","","","","",},
                            {"java.lang.String","w_liq","10","false","text","","","","","","","",},
                            {"java.lang.String","w_saldo_tot","10","false","text","","","","","","","",},
                            {"java.lang.String","w_valor_tot","10","false","text","","","","","","","",},
                            {"java.lang.String","pedido","10","false","text","","","","","","","",},
                            {"java.lang.String","vendor","1","false","text","Vendor","","","","","","",},
                            {"java.lang.String","cnpj","100","false","text","Cnpj","","","","","","",},
                            {"java.lang.String","cnpj_sem_formato","100","false","text","cnpj_sem_formato","","","","","","",},
                            {"java.lang.String","cli_rzao","240","false","text","cli_rzao","","","","","","",},
                            {"java.lang.Integer","cli_codigo","20","false","text","cli_codigo","","","","","","",},
                            {"java.lang.Integer","esc_seqn","20","false","text","esc_seqn","","","","","","",},
                            {"java.lang.String","cli_rzao","200","false","text","cli_rzao","","","","","","",},
                            {"java.lang.Integer","cac_sequencia","3","false","text","cac_sequencia","","","","","","",},
                            {"java.lang.String","linha_digitavel","200","false","text","linha_digitavel","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select trunc(tit_datvenc)+ 3 tit_datven3, tit_codigo , tit_numbco, decode(tit_status,'A','Aberto','C','Cancelado','L','Liquidado')tit_status, tip_codigo, tit_datvenc, tit_datrec, tit_datemi, tit_dspont, tit_dsante, tit_valor, tit_vlrec, p.prt_codigo, p.prt_descri , emp_empresa, fil_filial, sit.descricao_situacao_do_titulo desc_sit, '' ncc, '' nota, '' serie, '' taxa_juro, '' trn_codigo, null mov_data, null datvenc, 'N' cobjur, '0' tit_abatim, '' vnc_cartor, '' dif, '' condes, t.rep_codigo, trunc(SYSDATE)data_atual, '' ped_nmro, '' w_liq, '' w_saldo_tot, '' w_valor_tot, '' pedido, '' vendor , '' cnpj, '' cnpj_sem_formato           ,null cli_codigo,null esc_seqn, null cli_rzao,  t.cac_sequencia, '' linha_digitavel from titulos t, situacoes_dos_titulos	sit, portadores p where t.emp_empresa 			='01' and p.prt_codigo(+)=t.prt_codigo and	 nvl(T.tip_codigo,null)		in('DUP','NTP','NTC')and cli_codigo=162 and esc_seqn 				=nvl(1,esc_seqn)and tit_datvenc 				>=nvl(NULL,tit_datvenc)and tit_status 			 	=decode('T','T',tit_status,decode('T','A','A','L','L','C','C'))and t.sit_codigo_situacao_titulo=sit.codigo_situacao_titulo and(t.emp_empresa, t.fil_filial, t.tip_codigo , t.tit_codigo)not in(select m.emp_empresa, m.fil_filial, m.tip_codigo , m.tit_codigo from mov_receber m where nvl(m.emp_empresa,null)=nvl(t.emp_empresa,null)and nvl(m.fil_filial,null)=nvl(t.fil_filial,null)and nvl(m.tip_codigo,null)=nvl(t.tip_codigo,null)and m.tit_codigo=nvl(t.tit_codigo,null)and nvl(m.trn_codigo,null)in('CON','TNC','FAL','NEG','PNE')and trunc(mov_data)<=trunc(sysdate)and nvl(m.mov_data,null)<=trunc(sysdate)and nvl(m.mov_sequencia,0)=0 and rownum=1)order by tit_datvenc,tit_status";
    return query;
  }

}
