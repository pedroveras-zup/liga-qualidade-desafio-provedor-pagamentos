package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceberCartaoDeCredito implements Recebimento {

    private static final int PRAZO_RECEBIMENTO = 30;
    private static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.05");
    private static final DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public Recebivel receber(Transacao transacao) {
        LocalDate dataParaRecebimento = LocalDate.parse(transacao.getDataPagamento(),parser).plusDays(PRAZO_RECEBIMENTO);
        BigDecimal valorComDesconto = calculaValorComDesconto(transacao.getValor(), PERCENTUAL_DESCONTO);

        return new Recebivel(EnumStatusRecebivel.AGUARDANDO_PAGAMENTO, dataParaRecebimento,transacao.getValor(),valorComDesconto);
    }

    private BigDecimal getDesconto(BigDecimal valor, BigDecimal desconto) {
        return valor.multiply(desconto);
    }

    private BigDecimal calculaValorComDesconto(BigDecimal valor, BigDecimal desconto) {
        return valor.subtract(getDesconto(valor, desconto));
    }

}
