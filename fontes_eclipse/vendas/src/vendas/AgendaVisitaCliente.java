package vendas;

import java.sql.Date;

public class AgendaVisitaCliente {

  protected int id;
  protected MotivoVisita tipo;
  protected AgendaVisita agenda;
  protected Cliente cliente;
  protected Date dataExclusao;
  
  public enum MotivoVisita {
    VENDA, REPOSICAO, VENDA_REPOSICAO
  }

  public int getId() {
    return this.id;
  }

  public void setTipo(MotivoVisita tipo) {
    this.tipo = tipo;
  }

  public MotivoVisita getTipo() {
    return this.tipo;
  }

  public void setAgendaVisita(AgendaVisita agenda) {
    this.agenda = agenda;
  }

  public AgendaVisita getAgendaVisita() {
    return this.agenda;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Cliente getCliente() {
    return this.cliente;
  }
  
  public Date getDataExclusao() {
    return this.dataExclusao;
  }
  
  public boolean isDeleted() {
    return (this.dataExclusao != null);
  }

}