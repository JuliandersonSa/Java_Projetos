package aplicacao;

public class DespesaCredito extends Despesa {
		private int parcelas;
		private double valorParcela;
		private String banco;
		
		public DespesaCredito (double valor, int parcelas, double valorParcela, String banco, String descricao) {
				super(valor, descricao);
				this.parcelas = parcelas;
				this.valorParcela = valorParcela;
				this.banco = banco;
			}
			
		public int getParcelas() {
				return parcelas;
			}
		public double getValorParcela() {
				return valorParcela;
			}
		public String getBanco() {
				return banco;
			}
	
		@Override
		public String getTipo() {
				return "Despesa Cartão Crédito";
			}
		@Override
		public void exibirDetalhes() {
				System.out.println("===RELATÓRIO DESPESA CRÉDITO===");
				System.out.printf("Banco: %s\n", getBanco());
				System.out.printf("Descrição: %s\n", getDescricao());
				System.out.printf("Valor: R$ %.2f\n", getValor());
				System.out.printf("%dx de R$ %.2f\n", getParcelas(), getValorParcela());
				System.out.println("------------------------------------------------");
			}
	} //fecha-classe-DespesaCredito
