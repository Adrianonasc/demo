package com.it.empresas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.empresas.model.response.VigenciasResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class GovConsumer {

  @Autowired
  private ObjectMapper objectMapper;

  public VigenciasResponse consultaReceitaFederal(String cnpj) {
    RestClient defaultClient = RestClient.create();
    var vigenciasResponse = defaultClient
                              .get()
                              .uri("https://brasilapi.com.br/api/cnpj/v1/" + cnpj)
                              .exchange((request, response) -> {
                              if (response.getStatusCode().is4xxClientError()) {
                                throw new RuntimeException("Erro ao consultar receita federal ");
                              }
                              else {
                                  JsonNode jsonNodeRoot = objectMapper.readTree(response.bodyTo(String.class));
                                  VigenciasResponse _vigenciasResponse = new VigenciasResponse(0L, null, jsonNodeRoot.get("cnpj").asText(),
                                                                              jsonNodeRoot.get("razao_social").asText());
                                  return  _vigenciasResponse;
                              }
    });
      return vigenciasResponse;
  }
}
