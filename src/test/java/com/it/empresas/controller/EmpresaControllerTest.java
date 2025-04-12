package com.it.empresas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.it.empresas.model.response.VigenciasResponse;
import com.it.empresas.service.EmpresaService;

public class EmpresaControllerTest {
    private EmpresaService empresaService;
    private EmpresaController empresaController;

    @BeforeEach
    void setUp() {
        empresaService = mock(EmpresaService.class);
        empresaController = new EmpresaController(empresaService);
    }

    @Test
    public void quandoListarVigencenciasDeveRetornarSucesso() throws Exception {
        // Arrange
        VigenciasResponse[] mockResponse = new VigenciasResponse[] {
                new VigenciasResponse(1L, new Date(), "12345678901234", "Empresa Teste 1"),
                new VigenciasResponse(2L, new Date(), "98765432109876", "Empresa Teste 2")
        };
        when(empresaService.listar()).thenReturn(mockResponse);

        // Act
        var a = empresaController.listar();

        // Assert
        assertEquals(2, a.length);
        assertEquals("Empresa Teste 1", a[0].nomeEmpresa());
        assertEquals("Empresa Teste 2", a[1].nomeEmpresa());
    }
}
