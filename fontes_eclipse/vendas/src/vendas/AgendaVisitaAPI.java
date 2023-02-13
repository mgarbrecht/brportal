package vendas;

import java.sql.*;

public class AgendaVisitaAPI extends AgendaVisita {

  private Connection conn;
  private AgendaVisita old;
  
  public AgendaVisitaAPI(Connection conn) {
    this.conn = conn;
  }

  public AgendaVisitaAPI(Connection conn, int id) throws SQLException {
    this(conn);
    select(id);
  }

  private void validate() throws Exception {
    StringBuffer emsg = new StringBuffer();
    if (this.dataInicial == null || this.dataFinal == null)
      emsg.append("A data inicial e final devem ser informadas.\n");
    else if (!this.dataInicial.equals(this.dataFinal)
        && !this.dataInicial.before(this.dataFinal))
      emsg.append("A data inicial deve ser menor ou igual a final.\n");
    if (this.representante == null)
      emsg.append("O representante deve ser informado.");
    if (this.representante != null && this.dataInicial != null
        && this.dataFinal != null) {
      PreparedStatement pstm = conn.prepareStatement(
    		  new StringBuilder("select agvi_id")
    		  		    .append("  from agenda_visitas ")
    		  		    .append(" where agvi_rep_cdgo = ? ")
    		  		    .append("   and((agvi_dt_inicial <= ?" + " and agvi_dt_final >= ?)")
    		  		    .append("    or (agvi_dt_inicial <= ?" + " and agvi_dt_final >= ?))")
    		  		    .append("   and agvi_id != ?").toString());
      pstm.setString(1, this.representante.getCodigo());
      pstm.setDate(2, this.dataInicial);
      pstm.setDate(3, this.dataInicial);
      pstm.setDate(4, this.dataFinal);
      pstm.setDate(5, this.dataFinal);
      pstm.setInt(6, this.id);
      ResultSet rset = pstm.executeQuery();
      if (rset.next())
        emsg.append("Agenda de visitas já cadastrada neste período.\n");
      pstm.close();
    }
    if (emsg.length() > 0)
      throw new Exception(emsg.toString());
  }

  public void insert() throws Exception {
    if (this.id == 0) {
      PreparedStatement pstm;
      ResultSet rset;
      int newId;
      validate();
      pstm = this.conn.prepareStatement("select brio.agenda_visita_seq.nextval from sys.dual");
      rset = pstm.executeQuery();
      rset.next();
      newId = rset.getInt(1);
      pstm.close();
      pstm = this.conn.prepareStatement(
    		  new StringBuilder("insert into agenda_visitas ")
    		            .append("            ( agvi_id ")
    		            .append("            , agvi_rep_cdgo ")
    		            .append("            , agvi_dt_inicial ")
                        .append("            , agvi_dt_final) ")
                        .append("     values (?, ?, ?, ?)").toString());
      pstm.setInt(1, newId);
      pstm.setString(2, this.representante.getCodigo());
      pstm.setDate(3, this.dataInicial);
      pstm.setDate(4, this.dataFinal);
      pstm.executeUpdate();
      pstm.close();
      select(newId);
    }
    else
      throw new Exception("Agenda de visitas já cadastrada.");
  }

  public void select(int id) throws SQLException {
    PreparedStatement pstm;
    ResultSet rset;
    pstm = this.conn.prepareStatement(
    			new StringBuilder("select agvi_id ")
    			          .append("     , agvi_dt_inicial ")
    			          .append("     , agvi_dt_final ")
    			          .append("     , agvi_rep_cdgo ")
    			          .append("     , agvi_dt_exclusao ")
    			          .append("  from agenda_visitas where agvi_id = ?").toString());
    pstm.setInt(1, id);
    rset = pstm.executeQuery();
    if (rset.next()) {
      this.id = rset.getInt(1);
      this.dataInicial = rset.getDate(2);
      this.dataFinal = rset.getDate(3);
      RepresentanteAPI repr = new RepresentanteAPI(this.conn);
      repr.select(rset.getString(4));
      this.dataExclusao = rset.getDate(5);
      this.representante = (Representante) repr;
      pstm.close();
      this.old = (AgendaVisita) this;
    }
    else {
      pstm.close();
      throw new SQLException("Agenda de visitas não cadastrada.");
    }
  }

  public void update() throws Exception {
    if (this.old != null && this.id == this.old.id) {
      PreparedStatement pstm;
      validate();
      pstm = this.conn.prepareStatement(
    		  new StringBuilder("update agenda_visitas ")
    		            .append("   set agvi_dt_inicial = ? ")
    		            .append("     , agvi_dt_final = ? ")
    		            .append("     , agvi_rep_cdgo = ? ")
    		            .append(" where agvi_id = ? ").toString());
      pstm.setDate(1, this.dataInicial);
      pstm.setDate(2, this.dataFinal);
      pstm.setString(3, this.representante.getCodigo());
      pstm.setInt(4, this.id);
      pstm.executeUpdate();
      pstm.close();
    }
    else
      throw new Exception("Agenda de visitas não cadastrada.");
  }

  public void delete() throws SQLException {
    if (this.old != null && this.id == this.old.id) {
      Date dtNow = new Date((new java.util.Date()).getTime());
      PreparedStatement pstm = this.conn.prepareStatement(
    		  new StringBuilder(" select agvc_id ")
    		            .append("   from agenda_visitas_clientes ")
    		            .append("  where agvc_agvi_id = ? ").toString());
      pstm.setInt(1, this.id);
      ResultSet rset = pstm.executeQuery();
      if (rset.next()) {
        AgendaVisitaClienteAPI visita = new AgendaVisitaClienteAPI(this.conn);
        do {
          visita.select(rset.getInt(1));
          visita.delete();
        } while (rset.next());
      }
      pstm.close();
      pstm = conn.prepareStatement("update agenda_visitas set agvi_dt_exclusao = ? where agvi_id = ?");
      pstm.setDate(1, dtNow);
      pstm.setInt(2, this.id);
      pstm.executeUpdate();
      pstm.close();
      select(this.id);
    }
    else
      throw new SQLException("Agenda de visitas não cadastrada.");
  }

}