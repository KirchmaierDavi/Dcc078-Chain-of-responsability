package com.decorator.cor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChainOfResponsibilityTest {
    private ManipuladorSolicitacao cadeia;

    @BeforeEach
    public void configurarCadeia() {
        ManipuladorSolicitacao delegado = new Delegado();
        ManipuladorSolicitacao presidente = new Presidente();
        ManipuladorSolicitacao diretoriaGeral = new DiretoriaGeral();

        delegado.setProximoManipulador(presidente);
        presidente.setProximoManipulador(diretoriaGeral);

        cadeia = delegado;
    }

    @Test
    public void deveProcessarSolicitacaoPeloDelegado() {
        SolicitacaoSindicato solicitacao = new SolicitacaoSindicato("Material de escritorio", 500.0, "Compra");
        String resultado = cadeia.processar(solicitacao);
        assertTrue(resultado.contains("Delegado"));
        assertTrue(resultado.contains("Material de escritorio"));
    }

    @Test
    public void deveProcessarSolicitacaoPeloPresidente() {
        SolicitacaoSindicato solicitacao = new SolicitacaoSindicato("Equipamentos informatica", 3000.0, "Compra");
        String resultado = cadeia.processar(solicitacao);
        assertTrue(resultado.contains("Presidente"));
        assertTrue(resultado.contains("Equipamentos informatica"));
    }

    @Test
    public void deveProcessarSolicitacaoPelaDiretoriaGeral() {
        SolicitacaoSindicato solicitacao = new SolicitacaoSindicato("Reforma sede sindical", 50000.0, "Obra");
        String resultado = cadeia.processar(solicitacao);
        assertTrue(resultado.contains("Diretoria Geral"));
        assertTrue(resultado.contains("Reforma sede sindical"));
    }

    @Test
    public void deveProcessarSolicitacaoNoLimiteDoDelegado() {
        SolicitacaoSindicato solicitacao = new SolicitacaoSindicato("Suprimentos", 1000.0, "Compra");
        String resultado = cadeia.processar(solicitacao);
        assertTrue(resultado.contains("Delegado"));
    }

    @Test
    public void deveProcessarSolicitacaoNoLimiteDoPresidente() {
        SolicitacaoSindicato solicitacao = new SolicitacaoSindicato("Mobiliario", 5000.0, "Compra");
        String resultado = cadeia.processar(solicitacao);
        assertTrue(resultado.contains("Presidente"));
    }

    @Test
    public void deveProcessarSolicitacaoAcimaDeTodosLimites() {
        SolicitacaoSindicato solicitacao = new SolicitacaoSindicato("Expansao sede", 100000.0, "Investimento");
        String resultado = cadeia.processar(solicitacao);
        assertTrue(resultado.contains("Diretoria Geral"));
    }
}
