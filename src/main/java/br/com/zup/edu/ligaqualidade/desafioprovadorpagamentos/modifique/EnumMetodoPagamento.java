package br.com.zup.edu.ligaqualidade.desafioprovadorpagamentos.modifique;

public enum EnumMetodoPagamento {
    DEBITO{
        @Override
        public Recebimento getRecebimento() {
            return new ReceberCartaoDeDebito();
        }
    },
    CREDITO{
        @Override
        public Recebimento getRecebimento() {
            return new ReceberCartaoDeCredito();
        }
    };

    public abstract Recebimento  getRecebimento();
}
