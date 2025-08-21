package aplicacao;

public class CapitalSalario extends Capital {
		// Construtor
		public CapitalSalario (double valor, String categoria, String descricao) {
				super (valor, categoria, descricao);
			}
			
		@Override
		public void exibirDetalhes() {
				System.out.printf("Total Salário: R$ %.2f\n", getValor());
			}
	}//fecha-classe-CapitalSalario
