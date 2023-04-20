package com.example.projetotdd.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

//FAZENDO O TESTE UNITÁRIO OU SEJA, TESTANDO A CLASSE
@SpringBootTest
public class ComissaoTest {

  //criando uma classe statica 
  //para não precisar instanciar toda hora
  @TestConfiguration
  static class ComissaoConfiguracao{
    @Bean
    public Comissao comissao(){
      return new Comissao();
    }
  }
  @Autowired
  private Comissao comissao;

  
  //@test defini que essa funçaão sera testada
  //sempre especificar no nome da função o que ela fará como teste
  @Test
  public void deve_calcular_100_reais_de_comissao_para_venda_de_1000_com_10_por_cento(){
    //Arrange -> Parte da preparação
    double valorVenda = 1000.00;
    double valorComissao = 100.0;

    //Act -> Parte da ação
    double valorCalculado = comissao.calcular(valorVenda);

    //Assert -> Parte da confirmação
    //assert iquals possui dois parametro, o que ele espera e um atual
    Assertions.assertEquals(valorComissao, valorCalculado);


  }
  @Test
  public void deve_calcular_300_reais_de_comissao_para_venda_de_2000_com_15_por_cento(){
    //Arrange -> Parte da preparação
    double valorVenda = 2000.00;
    double valorComissao = 300.0;

    //Act -> Parte da ação
    double valorCalculado = comissao.calcular(valorVenda);

    //Assert -> Parte da confirmação
    //assert iquals possui dois parametro, o que ele espera e um atual
    Assertions.assertEquals(valorComissao, valorCalculado);


  }
}
