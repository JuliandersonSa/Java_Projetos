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
		public void exibirDetalhes() {
				System.out.printf("Total Despesa Crédito: R$ %.2f\n", getValor());
			}
	} //fecha-classe-DespesaCredito
