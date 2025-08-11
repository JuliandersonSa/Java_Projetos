package aplicacao;

public class CapitalExtra extends Capital {
		// Agora, só precisamos do atributo que é específico desta classe. 
		// Não tem nenhum, todos os atributos vêm da classe abstrata mãe.
		
		// Construtor (método que é chamado quando se cria um novo objeto 'Extra').
		// Inicializa os atributos do objeto e pode ser acessado de qualquer lugar por ser 'public'.
		public CapitalExtra(double valor, String categoria, String descricao) {
				super(valor, categoria, descricao);
			} //fecha-método-construtor
	} //fecha-classe-Extra
