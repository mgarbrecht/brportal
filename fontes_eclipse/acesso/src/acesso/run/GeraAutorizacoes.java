package acesso.run;

import acesso.AcessoDocumentoInterfaceAPI;
import java.sql.*;
import util.rdb.ConnectionJDBC;

public class GeraAutorizacoes
{

    public GeraAutorizacoes(){}

    public static void main(String args[]) throws Exception {
        Connection conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
        Statement stmt = conn.createStatement();
        ResultSet rset = stmt.executeQuery("select doin_id from documentos_interfaces");
        if(rset.next()) {
            AcessoDocumentoInterfaceAPI acdi = new AcessoDocumentoInterfaceAPI(conn);
            do {
                acdi.geraAutorizacoes(rset.getInt(1));
            } while(rset.next());
        }
        conn.commit();
        conn.close();
        System.exit(0);
    }
}
