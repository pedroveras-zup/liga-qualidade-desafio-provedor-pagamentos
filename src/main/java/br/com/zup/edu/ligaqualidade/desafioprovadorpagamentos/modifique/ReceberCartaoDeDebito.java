package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceberCartaoDeDebito implements Recebimento {

    private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.03");

    @Override
    public Recebivel receber(Transacao transacao) {
        BigDecimal valorComDesconto =  transacao.getValor().subtract(getDesconto(transacao));
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return new Recebivel(EnumStatusRecebivel.PAGO, LocalDate.parse(transacao.getDataPagamento(),parser),transacao.getValor(),valorComDesconto);

    }

    private BigDecimal getDesconto(Transacao transacao) {
        return transacao.getValor().multiply(PERCENTUAL_DESCONTO);
    }
}
