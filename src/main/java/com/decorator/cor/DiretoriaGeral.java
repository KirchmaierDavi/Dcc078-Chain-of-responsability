package com.decorator.cor;

import com.decorator.cor.SolicitacaoSindicato;

public class DiretoriaGeral extends ManipuladorSolicitacao {
    @Override
    public String processar(SolicitacaoSindicato solicitacao) {
        return "Diretoria Geral aprovou a solicitacao: " + solicitacao.getDescricao();
    }
}
