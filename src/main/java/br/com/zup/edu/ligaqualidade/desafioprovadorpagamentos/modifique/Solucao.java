package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solucao {

	/**
	 * @param infoTransacoes    dados das transações. A String está formatada da seguinte maneira:
	 *                          <b>"valor,metodoPagamento,numeroCartao,nomeCartao,validade,cvv,idTransacao"</b>
	 *                          <ol>
	 *                          <li> Valor é um decimal</li>
	 *                          <li> O método de pagamento é 'DEBITO' ou 'CREDITO' </li>
	 *                          <li> Validade é uma data no formato dd/MM/yyyy. </li>
	 *                          </ol>
	 * @param infoAdiantamentos informacao da transacao que pode ser recebida adiantada. A String está formatada da seguinte maneira:
	 *                          <b>"idTransacao,taxa"</b>
	 *                          <ol>
	 *                          <li> Taxa é um decimal </li>
	 *                          </ol>
	 * @return Uma lista de array de string com as informações na seguinte ordem:
	 * [status,valorOriginal,valorASerRecebidoDeFato,dataEsperadoRecebimento].
	 * <ol>
	 *  <li>O status pode ser 'pago' ou 'aguardando_pagamento'</li>
	 *  <li>O valor original e o a ser recebido de fato devem vir no formato decimal. Ex: 50.45</li>
	 *  <li>dataEsperadoRecebimento deve ser formatada como dd/MM/yyyy. Confira a classe {@link DateTimeFormatter}</li>
	 * </ol>
	 * <p>
	 * É esperado que o retorno respeite a ordem de recebimento
	 */
	public static List<String[]> executa(List<String> infoTransacoes, List<String> infoAdiantamentos) {
		List<Transacao> transacoes = Transacao.toList(infoTransacoes);
		Map<String, Adiantamento> adiantamentos = Adiantamento.toMap(infoAdiantamentos);

		return ProcessaPagamento.processa(new Operacoes(transacoes, adiantamentos));
	}

}



