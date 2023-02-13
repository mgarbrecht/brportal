package vendas;

import java.sql.Date;

public class AgendaVisita {

  protected int id;
  protected Date dataInicial;
  protected Date dataFinal;
  protected Representante representante;
  protected Date dataExclusao;
  
  public int getId() {
    return id;
  }
  
  public Date getDataInicial() {
    return dataInicial;
  }
  
  public Date getDataFinal() {
    return dataFinal;
  }
  
  public Representante getRepresentante() {
    return representante;
  }
  
  public void setDataInicial(Date data) {
    this.dataInicial = data;
  }
  
  public void setDataFinal(Date data) {
    this.dataFinal = data;
  }
    
  public void setRepresentante(Representante rep) {
    this.representante = rep;
  }
  
  public Date getDataExclusao() {
    return this.dataExclusao;
  }
  
  public boolean isDeleted() {
    return (this.dataExclusao != null);
  }
  
}