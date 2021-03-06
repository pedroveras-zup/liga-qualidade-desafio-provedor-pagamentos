package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.util.List;
import java.util.Map;

public class Operacoes {
    private List<Transacao> transacoes;
    private Map<String, Adiantamento> adiantamentos;

    public Operacoes(List<Transacao> transacoes, Map<String, Adiantamento> adiantamentos) {
        this.transacoes = transacoes;
        this.adiantamentos = adiantamentos;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public Map<String, Adiantamento> getAdiantamentos() {
        return adiantamentos;
    }
}
