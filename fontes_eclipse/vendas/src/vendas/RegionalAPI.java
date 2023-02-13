package vendas;

import java.sql.*;

public class RegionalAPI extends Regional {

  public RegionalAPI(Connection conn) {
    this.conn = conn;
  }
  
  public void select(int codigo) throws SQLException {
    PreparedStatement pstm = conn.prepareStatement(
    		new StringBuilder(" select codigo_regional ")
    		          .append("      , nome_regional ")
    		          .append("      , ender_eletronico_regional ")
    		          .append("   from regionais_vendas ")
    		          .append("  where codigo_regional = ? ").toString());
    pstm.setInt(1, codigo);
    ResultSet rset = pstm.executeQuery();
    if (rset.next()) {
      this.codigo = rset.getInt(1);
      this.nome = rset.getString(2);
      this.email = rset.getString(3);
    }
    else
      throw new SQLException("Regional de venda não cadastrada.");
    pstm.close();
  }

  Connection conn;
}