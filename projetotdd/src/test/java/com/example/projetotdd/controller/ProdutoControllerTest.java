package com.example.projetotdd.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.*;

import com.example.projetotdd.model.Produto;
import com.example.projetotdd.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ProdutoControllerTest {
  //MockMvc -> simula requisição
  //Mockito
  //Mock

  @Autowired
  private ProdutoController produtoController;

  //mocando o produtoService para poder fazer funcionar o teste
  //@MockBean para definir que o produtoservice será mocado
  @MockBean
  private ProdutoService produtoService;

  @Autowired
  private MockMvc mockMvc;

  //@BeforEach indiga que esse metodo tem que ser 
  //executado antes de cada caso de teste
  @BeforeEach
  public void setup(){
    //Aqui será executado antes de qualquer caso de teste

    //constroi um mockMvc atrvés do produtoController
    //agora ele consegue fazer requisição
    this.mockMvc = MockMvcBuilders.standaloneSetup(produtoController).build();

  }

  @Test
  public void deve_retornar_status_200_ok_ao_chamar_o_metodo_obter_todos() throws Exception{
    //Arrange
    List<Produto> produtos = new ArrayList<Produto>();
    //contrutor de requisição usado para criar uma
    var requestBuilder = MockMvcRequestBuilders.get("/api/produtos");
    //colocando o when do moKcito para preparar e mocar o metodo
    //dizendo que quer mocar o metodo obter todos
    when(this.produtoService.obterTodos()).thenReturn(produtos);


    //act
    //enviando a requisição atravé do mockMvc
    //o perform seria como se fosse o send da requisição
    //o and Expect como se fosse o retorno
    //esta verficando se o status do retorno esta ok
    this.mockMvc.perform(requestBuilder)
    
    //assert
    .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void deve_adicionar_o_produto() throws Exception{
    //Arrange

    Produto produto = new Produto();
    produto.setNome("MarTelo");
    produto.setQuantidade(10);

    //CRIANDO UM JSON
    //transforma produto em um objeto json
    String json = new ObjectMapper().writeValueAsString(produto);

    //criando a requisição do tipo post
    var requestBuilder = MockMvcRequestBuilders.post("/api/produtos")
    .content(json)
    .contentType(MediaType.APPLICATION_JSON);

    //adicionando o id do produto que iremos adicionar
    produto.setId(1l);

    //mocando o produto
    when(this.produtoService.adicionar(produto)).thenReturn(produto);


    //act
    this.mockMvc.perform(requestBuilder)
    
    //assert
  .andExpect(MockMvcResultMatchers.status().isCreated());
  }
}
