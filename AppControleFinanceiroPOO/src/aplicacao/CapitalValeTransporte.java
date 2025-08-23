package aplicacao;

public class CapitalValeTransporte extends Capital {
		// Construtor
		public CapitalValeTransporte (double valor, String categoria, String descricao) {
				super (valor, categoria, descricao);
			}
			
		@Override
		public String getTipo() {
				return "Vale Transporte";
			}
		@Override
		public void exibirDetalhes() {
				System.out.printf("Total Vale Transporte: R$ $.2f\n", getValor());
			}
	}//fecha-classe-CapitalValeTransporte
