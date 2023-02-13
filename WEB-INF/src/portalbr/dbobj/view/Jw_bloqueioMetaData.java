package portalbr.dbobj.view;

/** DataBase Object from table .Jw_bloqueio
  * @version 24/04/2008 14:08:53
  */
public class Jw_bloqueioMetaData {

  /*** Method for getting table metadada. 
     * { type, name, length, not_null (parameter type), html_type, label, format, validate_type, case_restriction } */
  public static String[][] getMetadata() {
    String[][] metadata = {
                            {"java.lang.String","LOCK_USERNAME","30","false","text","","","","","","","",},
                            {"java.lang.String","LOCK_USER","30","false","text","","","","","","","",},
                            {"java.lang.String","WAIT_USERNAME","30","false","text","","","","","","","",},
                            {"java.lang.String","WAIT_USER","30","false","text","","","","","","","",}
                          };
    return metadata;
  }

  public static String getSelect() throws Exception {
    String query = "SELECT s2.username lock_username,        s2.osuser lock_user,        s1.username wait_username,        s1.osuser wait_user     FROM v$session s1,        v$session    s2,        dba_locks    w,        dba_locks    h  WHERE h.blocking_others = 'Blocking'    AND h.mode_held !     = 'None'    AND h.mode_requested  = 'None'    AND w.lock_type   (+) = h.lock_type    AND w.lock_id1    (+) = h.lock_id1    AND w.lock_id2    (+) = h.lock_id2    AND s1.sid        (+) = w.session_id    AND s2.sid        (+) = h.session_id  ORDER BY s2.username";
    return query;
  }

}
