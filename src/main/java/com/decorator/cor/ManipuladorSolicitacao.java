package com.decorator.cor;

public abstract class ManipuladorSolicitacao {
    protected ManipuladorSolicitacao proximoManipulador;

    public void setProximoManipulador(ManipuladorSolicitacao proximoManipulador) {
        this.proximoManipulador = proximoManipulador;
    }

    public abstract String processar(SolicitacaoSindicato solicitacao);
}

