package portalbr.dbobj.view;

import java.lang.reflect.*;

/*** DataBase Object from view Web_poi_detalhes
     Version: 2.7 -  Date: 13/04/2006 14:14:27 */
public class Web_poi_detalhes implements java.io.Serializable, com.egen.util.jdbc.View {
  private java.lang.String Lin_nome;
  private java.lang.String Fil;
  private java.lang.String Pe;
  private java.lang.String Dt;
  private java.lang.String Dtf;
  private double Capacidade;
  private double Vendido;
  private java.lang.String Situacao;
  private double Bloq;

  public Web_poi_detalhes() {
  }

  public java.lang.String getLin_nome() {
    return Lin_nome;
  }

  public void setLin_nome(java.lang.String LIN_NOME) {
    Lin_nome = LIN_NOME;
  }

  public java.lang.String getFil() {
    return Fil;
  }

  public void setFil(java.lang.String FIL) {
    Fil = FIL;
  }

  public java.lang.String getPe() {
    return Pe;
  }

  public void setPe(java.lang.String PE) {
    Pe = PE;
  }

  public java.lang.String getDt() {
    return Dt;
  }

  public void setDt(java.lang.String DT) {
    Dt = DT;
  }

  public java.lang.String getDtf() {
    return Dtf;
  }

  public void setDtf(java.lang.String DTF) {
    Dtf = DTF;
  }

  public double getCapacidade() {
    return Capacidade;
  }

  public void setCapacidade(double CAPACIDADE) {
    Capacidade = CAPACIDADE;
  }

  public double getVendido() {
    return Vendido;
  }

  public void setVendido(double VENDIDO) {
    Vendido = VENDIDO;
  }

  public java.lang.String getSituacao() {
    return Situacao;
  }

  public void setSituacao(java.lang.String SITUACAO) {
    Situacao = SITUACAO;
  }

  public double getBloq() {
    return Bloq;
  }

  public void setBloq(double BLOQ) {
    Bloq = BLOQ;
  }

}
