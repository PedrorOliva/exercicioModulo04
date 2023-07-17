package model;

public class Inventario {
  private Integer rebelde_id;
  private Integer arma;
  private Integer municao;
  private Integer agua;
  private Integer comida;

  public Inventario() {

  }

  public Integer getRebelde_id() {
    return rebelde_id;
  }

  public void setRebelde_id(Integer rebelde_id) {
    this.rebelde_id = rebelde_id;
  }

  public Integer getArma() {
    return arma;
  }

  public void setArma(Integer arma) {
    this.arma = arma;
  }

  public Integer getMunicao() {
    return municao;
  }

  public void setMunicao(Integer municao) {
    this.municao = municao;
  }

  public Integer getAgua() {
    return agua;
  }

  public void setAgua(Integer agua) {
    this.agua = agua;
  }

  public Integer getComida() {
    return comida;
  }

  public void setComida(Integer comida) {
    this.comida = comida;
  }
}
