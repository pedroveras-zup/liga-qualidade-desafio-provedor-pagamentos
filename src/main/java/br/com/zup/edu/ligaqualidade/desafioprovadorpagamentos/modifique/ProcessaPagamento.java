package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.util.ArrayList;
import java.util.List;

public class ProcessaPagamento {

    public static List<String[]> processa(Operacoes operacoes) {
        List<String[]> recebiveis = new ArrayList<>();

        operacoes.getTransacoes().forEach(transacao -> {
            Recebimento recebimento = transacao.getMetodoPagamento().getRecebimento();
            Recebivel recebivel = recebimento.receber(transacao);

            if (operacoes.getAdiantamentos().containsKey(transacao.getIdTransacao())) {
                Adiantamento adiantamento = operacoes.getAdiantamentos().get(transacao.getIdTransacao());
                recebivel = ReceberAdiantamento.adianta(recebivel, adiantamento.getTaxa());
            }

            recebiveis.add(new String[] {recebivel.getStatusComoString(), String.valueOf(recebivel.getValorOriginal()),
                    String.valueOf(recebivel.getValorComDesconto()),
                    recebivel.getDataRecebimento()});
        });

        return recebiveis;
    }
}
