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
	} //fecha-classe-DespesaVariada
