package portalbr.dbobj.view;

/** DataBase Object from table .Jw_consulta_log_jobs
  * @version 26/01/2022 14:20:21
  */
public class Jw_consulta_log_jobsMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","data","16","false","text","data","","","","","","",},
                            {"java.lang.String","owner","240","false","text","owner","","","","","","",},
                            {"java.lang.String","job","240","false","text","job","","","","","","",},
                            {"java.lang.String","status","240","false","text","status","","","","","","",},
                            {"java.lang.String","errors","4000","false","text","errors","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "select to_char(log_date,'dd/mm/yyyy hh24:mi') data, owner,substr(job_name,11,10) job,status,errors  from sys.dba_SCHEDULER_JOB_RUN_DETAILS where status not like '%SUCCEEDED%'  and log_date >=sysdate-1 order by log_date desc";
    return query;
  }

}
