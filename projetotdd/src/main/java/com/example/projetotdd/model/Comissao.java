package com.example.projetotdd.model;

/**
 * Comissao
 */
public class Comissao {

  public double calcular(double valorVenda){
    return (valorVenda > 1000.0) ? valorVenda * 0.15 : valorVenda * 0.10;
  }
}