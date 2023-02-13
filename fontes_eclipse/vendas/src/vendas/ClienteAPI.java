package vendas;

import java.sql.*;

public class ClienteAPI extends Cliente {

  private Connection conn;
  
  public ClienteAPI(Connection conn) {
    this.conn = conn;
  }

  public ClienteAPI(Connection conn, int id) throws SQLException {
    this(conn);
    select(id);
  }

  public void select(int codigo) throws SQLException {
    PreparedStatement pstm = conn.prepareStatement(
    		new StringBuilder(" select cli_cdgo ")
    		          .append("      , cli_rzao ")
    		          .append("      , cli_nome ")
    		          .append("      , cli_situ ")
    		          .append("   from cli ")
    		          .append("  where cli_cdgo = ? ").toString());
    pstm.setInt(1, codigo);
    ResultSet rset = pstm.executeQuery();
    if (rset.next()) {
      this.codigo = rset.getInt(1);
      this.razao = rset.getString(2);
      this.nome = rset.getString(3);
      this.situacao = rset.getString(4);
      pstm.close();
    }
    else {
      pstm.close();
      throw new SQLException("Cliente não cadastrado.");
    }
  }

}