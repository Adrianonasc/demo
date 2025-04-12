package com.it.empresas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.it.empresas.model.response.VigenciasResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class GovConsumer {

  @Autowired
  private ObjectMapper objectMapper;

  public VigenciasResponse consultaReceitaFederal(String cnpj) {
    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
        .url("https://brasilapi.com.br/api/cnpj/v1/" + cnpj)
        .build();
    try (Response response = client.newCall(request).execute()) {
      JsonNode jsonNodeRoot = objectMapper.readTree(response.body().string());
      VigenciasResponse vigenciasResponse = new VigenciasResponse(0L, null, jsonNodeRoot.get("cnpj").asText(),
          jsonNodeRoot.get("razao_social").asText());
      return vigenciasResponse;
    } catch (Exception e) {
      throw new RuntimeException("Erro ao consultar receita federal", e);
    }
  }
}
