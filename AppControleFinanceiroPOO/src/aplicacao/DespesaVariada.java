package aplicacao;

public class DespesaVariada extends Despesa {
		private String categoria;
		
		public DespesaVariada(double valor, String categoria, String descricao) {
				super(valor, descricao);
				this.categoria = categoria;
			}
			
		public String getCategoria() {
				return categoria;
			}
			
		@Override
		public void exibirDetalhes() {
				System.out.printf("Total Despesa Variada: R$ %.2f\n", getValor());
			}
	} //fecha-classe-DespesaVariada
