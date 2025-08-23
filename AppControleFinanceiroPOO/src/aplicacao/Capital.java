package aplicacao;

public abstract class Capital {
		// Atributos que são comuns a todos os capitais
		private double valor;
		private String categoria;
		private String descricao;
		
		// Construtor
		public Capital (double valor, String categoria, String descricao) {
				this.valor = valor;
				this.categoria = categoria;
				this.descricao = descricao;
			}
			
		public double getValor() {
				return this.valor;
			}
		public String getCategoria() {
				return this.categoria;
			}
		public String getDescricao() {
				return this.descricao;
			}
			
		public abstract String getTipo();
		public abstract void exibirDetalhes();
	} //fecha-classe-abstrata-Capital
