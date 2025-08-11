package aplicacao;

// A palavra-chave 'extends' faz esta classe herdar tudo de Despesa
public class DespesaFixa extends Despesa {
		// Agora, só precisamos do atributo que é específico desta classe
		private String categoria;
		
		// Construtor
		public DespesaFixa(double valor, String categoria, String descricao) {
				// 'super(valor, descricao)' chama o construtor da classe mãe (Despesa)
				// para inicializar os atributos que ela herdou.
				super(valor, descricao);
				// Aqui inicializamos o atributo específico desta classe.
				this.categoria = categoria;
			} //fecha-método-construtor
			
		// Método getter para o atributo específico
		public String getCategoria() {
				return categoria;
			}
		// Não precisamos mais dos métodos getValor() e getDescricao() 
		// Eles já foram herdados da classe Despesa.
	} //fecha-classe-DespesaFixa
