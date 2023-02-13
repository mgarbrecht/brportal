package portalbr.dbobj.view;

/** DataBase Object from table .Jw_poi_aberto_rep_entrada_pedidos
  * @version 19/12/2022 14:50:21
  */
public class Jw_poi_aberto_rep_entrada_pedidos implements java.io.Serializable, com.egen.util.jdbc.View {
  private int codigo_regional;
  private java.lang.String nome_regional;
  private int codigo_gerente;
  private java.lang.String nome_gerente;
  private java.lang.String endereco;
  private java.lang.String estado_gerente;
  private int codigo_marca;
  private java.lang.String descricao_marca;
  private java.lang.String codigo_representante;
  private java.lang.String rep_rzao;
  private double preco_previsto;
  private double preco_realizado;
  private double dif_preco;
  private double reais_previsto;
  private double reais_realizado;
  private double dif_reais;
  private double reais_faturado;
  private double reais_a_faturar;
  private int pares_previsto;
  private int pares_realizado;
  private double dif_pares;
  private int pares_faturado;
  private int pares_a_faturar;
  private double reais_realizado_anterior;
  private int pares_realizado_anterior;
  private java.lang.String ref_grupo_posicao_fab_descricao;
  private double dif_pares_pos;
  private double dif_reais_pos;
  private double dif_preco_pos;

  public Jw_poi_aberto_rep_entrada_pedidos() {
  }

  public int getCodigo_regional() {
    return codigo_regional;
  }

  public void setCodigo_regional(int PARAM) {
    this.codigo_regional = PARAM;
  }

  public java.lang.String getNome_regional() {
    return nome_regional;
  }

  public void setNome_regional(java.lang.String PARAM) {
    this.nome_regional = PARAM;
  }

  public int getCodigo_gerente() {
    return codigo_gerente;
  }

  public void setCodigo_gerente(int PARAM) {
    this.codigo_gerente = PARAM;
  }

  public java.lang.String getNome_gerente() {
    return nome_gerente;
  }

  public void setNome_gerente(java.lang.String PARAM) {
    this.nome_gerente = PARAM;
  }

  public java.lang.String getEndereco() {
    return endereco;
  }

  public void setEndereco(java.lang.String PARAM) {
    this.endereco = PARAM;
  }

  public java.lang.String getEstado_gerente() {
    return estado_gerente;
  }

  public void setEstado_gerente(java.lang.String PARAM) {
    this.estado_gerente = PARAM;
  }

  public int getCodigo_marca() {
    return codigo_marca;
  }

  public void setCodigo_marca(int PARAM) {
    this.codigo_marca = PARAM;
  }

  public java.lang.String getDescricao_marca() {
    return descricao_marca;
  }

  public void setDescricao_marca(java.lang.String PARAM) {
    this.descricao_marca = PARAM;
  }

  public java.lang.String getCodigo_representante() {
    return codigo_representante;
  }

  public void setCodigo_representante(java.lang.String PARAM) {
    this.codigo_representante = PARAM;
  }

  public java.lang.String getRep_rzao() {
    return rep_rzao;
  }

  public void setRep_rzao(java.lang.String PARAM) {
    this.rep_rzao = PARAM;
  }

  public double getPreco_previsto() {
    return preco_previsto;
  }

  public void setPreco_previsto(double PARAM) {
    this.preco_previsto = PARAM;
  }

  public double getPreco_realizado() {
    return preco_realizado;
  }

  public void setPreco_realizado(double PARAM) {
    this.preco_realizado = PARAM;
  }

  public double getDif_preco() {
    return dif_preco;
  }

  public void setDif_preco(double PARAM) {
    this.dif_preco = PARAM;
  }

  public double getReais_previsto() {
    return reais_previsto;
  }

  public void setReais_previsto(double PARAM) {
    this.reais_previsto = PARAM;
  }

  public double getReais_realizado() {
    return reais_realizado;
  }

  public void setReais_realizado(double PARAM) {
    this.reais_realizado = PARAM;
  }

  public double getDif_reais() {
    return dif_reais;
  }

  public void setDif_reais(double PARAM) {
    this.dif_reais = PARAM;
  }

  public double getReais_faturado() {
    return reais_faturado;
  }

  public void setReais_faturado(double PARAM) {
    this.reais_faturado = PARAM;
  }

  public double getReais_a_faturar() {
    return reais_a_faturar;
  }

  public void setReais_a_faturar(double PARAM) {
    this.reais_a_faturar = PARAM;
  }

  public int getPares_previsto() {
    return pares_previsto;
  }

  public void setPares_previsto(int PARAM) {
    this.pares_previsto = PARAM;
  }

  public int getPares_realizado() {
    return pares_realizado;
  }

  public void setPares_realizado(int PARAM) {
    this.pares_realizado = PARAM;
  }

  public double getDif_pares() {
    return dif_pares;
  }

  public void setDif_pares(double PARAM) {
    this.dif_pares = PARAM;
  }

  public int getPares_faturado() {
    return pares_faturado;
  }

  public void setPares_faturado(int PARAM) {
    this.pares_faturado = PARAM;
  }

  public int getPares_a_faturar() {
    return pares_a_faturar;
  }

  public void setPares_a_faturar(int PARAM) {
    this.pares_a_faturar = PARAM;
  }

  public double getReais_realizado_anterior() {
    return reais_realizado_anterior;
  }

  public void setReais_realizado_anterior(double PARAM) {
    this.reais_realizado_anterior = PARAM;
  }

  public int getPares_realizado_anterior() {
    return pares_realizado_anterior;
  }

  public void setPares_realizado_anterior(int PARAM) {
    this.pares_realizado_anterior = PARAM;
  }

  public java.lang.String getRef_grupo_posicao_fab_descricao() {
    return ref_grupo_posicao_fab_descricao;
  }

  public void setRef_grupo_posicao_fab_descricao(java.lang.String PARAM) {
    this.ref_grupo_posicao_fab_descricao = PARAM;
  }

  public double getDif_pares_pos() {
    return dif_pares_pos;
  }

  public void setDif_pares_pos(double PARAM) {
    this.dif_pares_pos = PARAM;
  }

  public double getDif_reais_pos() {
    return dif_reais_pos;
  }

  public void setDif_reais_pos(double PARAM) {
    this.dif_reais_pos = PARAM;
  }

  public double getDif_preco_pos() {
    return dif_preco_pos;
  }

  public void setDif_preco_pos(double PARAM) {
    this.dif_preco_pos = PARAM;
  }

}
