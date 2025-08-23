package aplicacao;

public abstract class Despesa {
		// Atributos que são comuns a todas as despesas.
		private double valor;
		private String descricao;
		
		// Construtor
		public Despesa(double valor, String descricao) {
				this.valor = valor; // 'this.valor' refere-se ao atributo da classe; 'valor' refere-se ao parâmetro do construtor.
				this.descricao = descricao;
			}
			
		public double getValor() {
				return this.valor;
			}
		public String getDescricao() {
			return this.descricao;
			}
			
		public abstract String getTipo();
		public abstract void exibirDetalhes();
	} //fecha-classe-abstrada-Despesa
