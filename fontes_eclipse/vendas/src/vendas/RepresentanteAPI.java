package vendas;

import java.sql.*;

public class RepresentanteAPI extends Representante {

  private Connection conn;	

  public RepresentanteAPI(Connection conn) {
    this.conn = conn;
  }

  public void select(String codigo) throws SQLException {
    PreparedStatement pstm = conn.prepareStatement(
    		new StringBuilder(" select rep_cdgo ")
    		          .append("      , rep_rzao ")
    		          .append("      , rep_situ ")
    		          .append("      , codigo_regional ")
    		          .append("   from rep ")
    		          .append("  where rep_cdgo = ? ").toString());
    pstm.setString(1, codigo);
    ResultSet rset = pstm.executeQuery();
    if (rset.next()) {
      this.codigo = rset.getString(1);
      this.razao = rset.getString(2);
      this.situacao = rset.getString(3);
      int regi_cod = rset.getInt(4);
      if (regi_cod == 0)
        this.regional = null;
      else {
        RegionalAPI regi = new RegionalAPI(this.conn);
        regi.select(regi_cod);
        this.regional = (Regional) regi;
      }
    }
    else
      throw new SQLException("Representante não cadastrado.");
    pstm.close();
  }

}