package aplicacao; // É importante que seja o mesmo pacote do Principal.java

public class DespesaMercado extends Despesa {
		/* 1. Atributos/características da Despesa
		 * 'private' significa que essas variáveis só podem ser acessadas diretamente
		 * de dentro da própria classe Despesa. Isso mé um conceito de 'Encapsulamento',
		 * que garante a segurança e integridade dos dados.
		 * */
		private String categoria;
		private String tipoPagamento; // "vale" ou "dinheiro"
		 
		 /* 2. Construtor (Como "construir" um objeto Despesa)
		  * O construtor é um método especial que é chamado quando você cria um novo objeto.
		  * Ele inicializa os atributos do objeto.
		  * */
		public DespesaMercado(double valor, String categoria, String tipoPagamento, String descricao) {
				super(valor, descricao);
				this.categoria = categoria;
				this.tipoPagamento = tipoPagamento;
			} //fecha-método-construtor
			
		/* 3. Métodos "Getters" (Para "Pegar" os valores dos Atributos)
		 * Como os atributos são 'private', precisamos de métodos públicos para acessá-los de fora da classe.
		 * Isso é parte do encapsulamento.
		 * */
			
		public String getCategoria() {
				return categoria;
			} //fecha-método-getCategoria
			
		public String getTipoPagamento() {
				return tipoPagamento;
			} //fecha-método-TipoPagamento		
			
		@Override
		public void exibirDetalhes() {
				System.out.printf("Total Despesa Mercado: R$ %.2f\n", getValor());
			}
			
			// Futuramente, iremos adicionar métodos "Setters" (Para alterar valores)
			// e outros métodos que uma Despesa pode "fazer".
			
	} //fecha-classe-Despesa
