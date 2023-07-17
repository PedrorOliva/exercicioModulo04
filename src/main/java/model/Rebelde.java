package model;

public class Rebelde {
  private Integer id_rebelde;
  private String nome;
  private Integer idade;
  private String genero;
  private String localizacao;
  private Integer traidor;
  private Boolean status;

  public Rebelde() {
  }

  public Integer getId_rebelde() {
    return id_rebelde;
  }

  public void setId_rebelde(Integer id_rebelde) {
    this.id_rebelde = id_rebelde;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Integer getIdade() {
    return idade;
  }

  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  public String getGenero() {
    return genero;
  }

  public void setGenero(String genero) {
    this.genero = genero;
  }

  public String getLocalizacao() {
    return localizacao;
  }

  public void setLocalizacao(String localizacao) {
    this.localizacao = localizacao;
  }

  public Integer getTraidor() {
    return traidor;
  }

  public void setTraidor(Integer traidor) {
    this.traidor = traidor;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

}
