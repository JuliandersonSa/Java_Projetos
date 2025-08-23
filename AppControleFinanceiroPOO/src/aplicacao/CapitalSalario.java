package aplicacao;

public class CapitalSalario extends Capital {
		// Construtor
		public CapitalSalario (double valor, String categoria, String descricao) {
				super (valor, categoria, descricao);
			}
			
		@Override
		public String getTipo() {
				return "Salário";
			}
		@Override
		public void exibirDetalhes() {
				System.out.println("===RELATÓRIO CAPITAL SALÁRIO===");
				System.out.printf("Valor: R$ %.2f\n", getValor());
				System.out.printf("Descrição: %s\n", getDescricao());
			}
	}//fecha-classe-CapitalSalario
