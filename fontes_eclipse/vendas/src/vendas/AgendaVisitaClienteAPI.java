package vendas;

import java.sql.*;

public class AgendaVisitaClienteAPI extends AgendaVisitaCliente {

  private Connection conn;
  private int esc_seqn;
  private AgendaVisitaCliente old;
  
  public AgendaVisitaClienteAPI(Connection conn) {
    this.conn = conn;
  }

  public AgendaVisitaClienteAPI(Connection conn, int id) throws SQLException {
    this(conn);
    select(id);
  }

  private void validate() throws Exception {
    StringBuffer emsg = new StringBuffer();
    if (this.agenda == null)
      emsg.append("A agenda de visita deve ser informada.\n");
    if (this.cliente == null)
      emsg.append("O cliente deve ser informado.\n");
    else {
      Statement stm = conn.createStatement();
      ResultSet rset = stm.executeQuery(
    		  new StringBuilder(" select esc.esc_seqn ")
    		            .append("   from esc ")
    		            .append("      , ecl ")
    		            .append("      , cliente_representante clr ")
    		            .append("  where esc.cli_cdgo = ").append(this.cliente.getCodigo())
    		            .append("    and esc.esc_situacao = 'A' ")
    		            .append("    and ecl.cli_cdgo = esc.cli_cdgo ")
    		            .append("    and ecl.ned_cdgo in ('UNI', 'ENT', 'COB') ")
    		            .append("    and clr.codigo_cliente = esc.cli_cdgo ")
    		            .append("    and clr.codigo_sequencial = esc.esc_seqn ")
    		            .append("    and clr.codigo_representante = '").append(this.agenda.representante.getCodigo()).append("'")
    		            .append("    and clr.situacao = 'A' ").toString());
      if (rset.next()) {
        this.esc_seqn = rset.getInt(1);
        stm.close();
      }
      else
        emsg.append("Estabelecimento de cliente não encontrado.\n");
    }
    if (this.tipo == null)
      emsg.append("O tipo deve ser informado.\n");
    if (emsg.length() > 0)
      throw new Exception(emsg.toString());
  }

  public void insert() throws Exception {
    if (this.id == 0) {
      PreparedStatement pstm;
      ResultSet rset;
      int newId;
      validate();
      pstm = conn.prepareStatement("select brio.agenda_visita_seq.nextval"
          + " from sys.dual");
      rset = pstm.executeQuery();
      rset.next();
      newId = rset.getInt(1);
      pstm.close();
      pstm = this.conn.prepareStatement("insert into agenda_visitas_clientes"
          + "(agvc_id, agvc_tipo, agvc_agvi_id, agvc_cli_cdgo,"
          + " agvc_esc_seqn) values(?, ?, ?, ?, ?)");
      pstm.setInt(1, newId);
      if (this.tipo == MotivoVisita.REPOSICAO)
        pstm.setString(2, "R");
      else if (this.tipo == MotivoVisita.VENDA)
        pstm.setString(2, "V");
      else if (this.tipo == MotivoVisita.VENDA_REPOSICAO)
        pstm.setString(2, "A");
      pstm.setInt(3, this.agenda.getId());
      pstm.setInt(4, this.cliente.getCodigo());
      pstm.setInt(5, this.esc_seqn);
      pstm.executeUpdate();
      pstm.close();
      select(newId);
    }
    else
      throw new Exception("Visita de cliente já cadastrada.");
  }

  public void select(int id) throws SQLException {
    PreparedStatement pstm;
    ResultSet rset;
    String tipo;
    pstm = this.conn.prepareStatement(
    		new StringBuilder(" select agvc_id ")
    		          .append("      , agvc_tipo ")
    		          .append("      , agvc_agvi_id ")
    		          .append("      , agvc_cli_cdgo ")
    		          .append("      , agvc_esc_seqn ")
    		          .append("      , agvc_dt_exclusao ")
    		          .append("   from agenda_visitas_clientes ")
    		          .append("  where agvc_id = ? ").toString());
    pstm.setInt(1, id);
    rset = pstm.executeQuery();
    if (rset.next()) {
      this.id = rset.getInt(1);
      tipo = rset.getString(2);
      if (tipo.equalsIgnoreCase("A"))
        this.tipo = MotivoVisita.VENDA_REPOSICAO;
      else if (tipo.equalsIgnoreCase("R"))
        this.tipo = MotivoVisita.REPOSICAO;
      else if (tipo.equalsIgnoreCase("V"))
        this.tipo = MotivoVisita.VENDA;
      this.agenda = (AgendaVisita) new AgendaVisitaAPI(this.conn, rset
          .getInt(3));
      this.cliente = (Cliente) new ClienteAPI(this.conn, rset.getInt(4));
      this.esc_seqn = rset.getInt(5);
      this.dataExclusao = rset.getDate(6);
      pstm.close();
      this.old = (AgendaVisitaCliente) this;
    }
    else {
      pstm.close();
      throw new SQLException("Visita de cliente não cadastrada.");
    }
  }

  public void update() throws Exception {
    if (this.old != null && this.id == this.old.id) {
      PreparedStatement pstm;
      validate();
      pstm = this.conn.prepareStatement(
    		  new StringBuilder(" update agenda_visitas_clientes ")
    		            .append("    set agvc_tipo = ? ")
    		            .append("      , agvc_agvi_id = ? ")
    		            .append("      , agvc_cli_cdgo = ? ")
    		            .append("      , agvc_esc_seqn = ? ")
    		            .append("  where agvc_id = ? ").toString());
      if (this.tipo == MotivoVisita.REPOSICAO)
        pstm.setString(1, "R");
      else if (this.tipo == MotivoVisita.VENDA)
        pstm.setString(1, "V");
      else if (this.tipo == MotivoVisita.VENDA_REPOSICAO)
        pstm.setString(1, "A");
      pstm.setInt(2, this.agenda.getId());
      pstm.setInt(3, this.cliente.getCodigo());
      pstm.setInt(4, this.esc_seqn);
      pstm.setInt(5, this.id);
      pstm.executeUpdate();
      pstm.close();
    }
    else
      throw new Exception("Visita de cliente não cadastrada.");
  }

  public void delete() throws SQLException {
    if (this.old != null && this.id == this.old.id) {
      Date dtNow = new Date((new java.util.Date()).getTime());
      PreparedStatement pstm = conn
          .prepareStatement("update agenda_visitas_clientes set agvc_dt_exclusao = ? where agvc_id = ?");
      pstm.setDate(1, dtNow);
      pstm.setInt(2, this.id);
      pstm.executeUpdate();
      pstm.close();
      select(this.id);
    }
    else
      throw new SQLException("Visitas de cliente não cadastrada.");
  }

}