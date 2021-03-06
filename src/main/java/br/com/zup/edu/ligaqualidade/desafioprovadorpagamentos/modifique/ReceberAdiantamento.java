package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceberAdiantamento {
    private static final DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final int PRAZO_RECEBIMENTO = 30;

    public static Recebivel adianta(Recebivel recebivel, BigDecimal taxaAdiantamento) {
        LocalDate dataRecebimento =
                LocalDate.parse(recebivel.getDataRecebimento(), parser).minusDays(PRAZO_RECEBIMENTO);
        BigDecimal valorComDesconto = calculaValorComDesconto(recebivel.getValorComDesconto(),
                taxaAdiantamento);

        return new Recebivel(EnumStatusRecebivel.PAGO, dataRecebimento,
                recebivel.getValorOriginal(), valorComDesconto);
    }

    private static BigDecimal getDesconto(BigDecimal valor, BigDecimal desconto) {
        return valor.multiply(desconto);
    }

    private static BigDecimal calculaValorComDesconto(BigDecimal valor, BigDecimal desconto) {
        return valor.subtract(getDesconto(valor, desconto));
    }
}
