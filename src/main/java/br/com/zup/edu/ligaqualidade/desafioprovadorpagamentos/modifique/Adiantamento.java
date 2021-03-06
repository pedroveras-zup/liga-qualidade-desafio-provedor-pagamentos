package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Adiantamento {
    private String idTransacao;
    private BigDecimal taxa;

    public Adiantamento(String transacaoString) {
        String[] transacaoStringSeparada = transacaoString.split(",");
        this.idTransacao = transacaoStringSeparada[0];
        this.taxa = new BigDecimal(transacaoStringSeparada[1]);
    }

    public static Map<String, Adiantamento> toMap(List<String> transacoesString) {
        return transacoesString.stream().map(Adiantamento::new)
                .collect(Collectors.toMap(Adiantamento::getIdTransacao, adiantamento -> adiantamento));
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(String idTransacao) {
        this.idTransacao = idTransacao;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}
