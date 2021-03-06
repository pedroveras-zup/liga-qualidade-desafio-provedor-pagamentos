package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceberCartaoDeCredito implements Recebimento{

    private static final int PRAZO_RECEBIMENTO = 30;
    private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.05");

    @Override
    public Recebivel receber(Transacao transacao) {
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataParaRecebimento = LocalDate.parse(transacao.getDataPagamento(),parser).plusDays(PRAZO_RECEBIMENTO);


        BigDecimal valorComDesconto =  transacao.getValor().subtract(getDesconto(transacao));

        return new Recebivel(EnumStatusRecebivel.AGUARDANDO_PAGAMENTO, dataParaRecebimento,transacao.getValor(),valorComDesconto);
    }


    private BigDecimal getDesconto(Transacao transacao) {
        return transacao.getValor().multiply(PERCENTUAL_DESCONTO);
    }


}
