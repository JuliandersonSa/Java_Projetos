package aplicacao;

public class CapitalExtra extends Capital {
		// Agora, só precisamos do atributo que é específico desta classe. 
		// Não tem nenhum, todos os atributos vêm da classe abstrata mãe.
		
		// Construtor (método que é chamado quando se cria um novo objeto 'Extra').
		// Inicializa os atributos do objeto e pode ser acessado de qualquer lugar por ser 'public'.
		public CapitalExtra(double valor, String categoria, String descricao) {
				super(valor, categoria, descricao);
			} //fecha-método-construtor
			
		@Override
		public String getTipo() {
				return "Extras";
			}
		@Override
		public void exibirDetalhes() {
				System.out.println("===RELATÓRIO CAPITAL EXTRA===");
				System.out.printf("Valor: R$ %.2f\n", getValor());
				System.out.printf("Descrição: %s\n", getDescricao());

			}
	} //fecha-classe-Extra
