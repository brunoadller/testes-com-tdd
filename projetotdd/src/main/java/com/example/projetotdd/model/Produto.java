package com.example.projetotdd.model;

public class Produto {
  private Long id;
  private String nome;
  private Integer quantidade;
  private double desconto;
  private double acrescimo;
  private double valor;

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public Integer getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
  public double getDesconto() {
    return desconto;
  }
  public void setDesconto(double desconto) {
    this.desconto = desconto;
  }
  public double getAcrescimo() {
    return acrescimo;
  }
  public void setAcrescimo(double acrescimo) {
    this.acrescimo = acrescimo;
  }
  public double getValor() {
    return valor;
  }
  public void setValor(double valor) {
    this.valor = valor;
  }

  public double calcularValorTotal(){
    return (quantidade * valor) + acrescimo - desconto;
  }
  
}
