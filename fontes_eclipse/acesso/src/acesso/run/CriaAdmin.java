package acesso.run;

import acesso.UsuarioAPI;
import java.sql.Connection;
import util.rdb.ConnectionJDBC;

public class CriaAdmin
{ 

    public CriaAdmin()
    {
    }

    public static void main(String args[]) throws Exception {
        if(args == null) {
        } else {
            Connection conn = ConnectionJDBC.get("orasco", "wbrio", "wbrio");
            UsuarioAPI usua = new UsuarioAPI(conn);
            String user;
            byte pswd[];
            if(args.length >= 2) {
                user = args[0];
                pswd = args[1].getBytes();
            } else {
                user = "admin";
                pswd = args[0].getBytes();
            }
            usua.setNome("Adminstrador de acesso");
            usua.setUsuario(user);
            usua.setSenha(pswd);
            usua.setSuperUsuario(true);
            usua.insert();
            conn.commit();
            conn.close();
        System.exit(0);
    }
    }
}
