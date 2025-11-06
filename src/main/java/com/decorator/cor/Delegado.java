package com.decorator.cor;

import com.decorator.cor.SolicitacaoSindicato;

public class Delegado extends ManipuladorSolicitacao {
    private static final double LIMITE_VALOR = 1000.0;

    @Override
    public String processar(SolicitacaoSindicato solicitacao) {
        if (solicitacao.getValor() <= LIMITE_VALOR) {
            return "Delegado aprovou a solicitacao: " + solicitacao.getDescricao();
        } else if (proximoManipulador != null) {
            return proximoManipulador.processar(solicitacao);
        }
        return "Nenhum manipulador disponivel para processar a solicitacao";
    }
}
