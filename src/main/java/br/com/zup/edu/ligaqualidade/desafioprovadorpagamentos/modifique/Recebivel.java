package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Recebivel {

    private EnumStatusRecebivel status;
    private String dataRecebimento;
    private BigDecimal valorOriginal;
    private BigDecimal valorComDesconto;


    public Recebivel(EnumStatusRecebivel status, LocalDate dataRecebimento, BigDecimal valorOriginal, BigDecimal valorComDesconto) {
        this.status = status;
        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataRecebimento = parser.format(dataRecebimento);
        this.valorOriginal = valorOriginal;
        this.valorComDesconto = valorComDesconto;
    }

    public BigDecimal getValorComDesconto() {
        return valorComDesconto;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public String  getDataRecebimento() {
        return dataRecebimento;
    }

    public String getStatusComoString() {
        return status.toString().toLowerCase();
    }
}
