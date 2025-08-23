package aplicacao;

public class CapitalValeAlimentacao extends Capital {
		//Construtor
		public CapitalValeAlimentacao (double valor, String categoria, String descricao) {
				super (valor, categoria, descricao);
			}
			
		@Override
		public String getTipo() {
				return "Vale Alimentação";
			}
		@Override
		public void exibirDetalhes() {
				System.out.printf("Total Vale Alimentação: R$ %.2f\n", getValor());
			}
	}//fecha-classe-CapitalValeAlimentacao
