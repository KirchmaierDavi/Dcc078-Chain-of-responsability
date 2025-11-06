package com.decorator.cor;

public class Presidente extends ManipuladorSolicitacao {
    private static final double LIMITE_VALOR = 5000.0;

    @Override
    public String processar(SolicitacaoSindicato solicitacao) {
        if (solicitacao.getValor() <= LIMITE_VALOR) {
            return "Presidente aprovou a solicitacao: " + solicitacao.getDescricao();
        } else if (proximoManipulador != null) {
            return proximoManipulador.processar(solicitacao);
        }
        return "Nenhum manipulador disponivel para processar a solicitacao";
    }
}

