
package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal{
		private static ArrayList<Despesa> todasDespesas = new ArrayList<>();
		private static ArrayList<Capital> todosCapitais = new ArrayList<>();
	
		// Menu principal do aplicativo
		public static void main(String[] args) {
				Scanner teclado = new Scanner(System.in);
			
				int opcao = 0;
				do {
						System.out.println("\n-----------------------------------");
						System.out.println("=== MENU_PRINCIPAL ===");
						System.out.println(" [1] Registrar Capital");
						System.out.println(" [2] Registrar Despesa");
						System.out.println(" [3] Visualizar saldos");
						System.out.println(" [4] Sair\n");
						System.out.print("Escolha uma opção: ");
						
						try {
								opcao = teclado.nextInt();
								teclado.nextLine();
								if (opcao < 1 || opcao > 4) {
										System.out.println("\n-----------------------------------");
										System.out.println("[Erro] Ecolha uma opção entre 1 e 4.\n");
									} else {
											switch (opcao) {
													case 1:
														registrarCapital(teclado);
														break;
													case 2:
														registrarDespesa(teclado);
														break;
													case 3:
														visualizarSaldosCapital();
														break;
													case 4:
														System.out.println("\n-----------------------------------");
														System.out.println("[ Saindo do programa... ]");
														break;
												}
										}
							} catch (InputMismatchException e) {
									System.out.println("\n-----------------------------------");
									System.out.println("[Erro] Digite um número.\n");
									teclado.nextLine();
								} //fecha-catch
					} while (opcao != 4);
			} //fecha-metodo-main
			
			
			// Menu para registrar capital.
			private static void registrarCapital(Scanner teclado) {
				int opcao = 0;
				do {
						System.out.println("\n-----------------------------------");
						System.out.println("=== REGISTRAR_CAPITAL ===");
						System.out.println(" [1] Salário");
						System.out.println(" [2] Vale Alimentação");
						System.out.println(" [3] Vale Transporte");
						System.out.println(" [4] Extras");
						System.out.println(" [5] Voltar\n");
						System.out.print("Escolha uma opção: ");
						
						try {	
							opcao = teclado.nextInt();
							teclado.nextLine();
							if (opcao < 1 || opcao > 5) {
									System.out.println("\n-----------------------------------");
									System.out.println("[Erro] Escolha uma opção entre 1 e 5.\n");
								} else {
										switch (opcao) {
												// Registro capital salário
												case 1:
													double salarioValor = 0;
													boolean salarioValidado = false; 
													while (!salarioValidado) {
															try {
																	System.out.print("Valor do Salário: R$ ");
																	salarioValor = teclado.nextDouble();
																	teclado.nextLine();
																	
																	if (salarioValor < 0) {
																			System.out.println("\n-----------------------------------");
																			System.out.println("[Erro] Digite um valor positivo.\n");
																		} else {
																				String salarioCategoria = "salario";
																				System.out.print("Descrição: ");
																				String salarioDescricao = teclado.nextLine();
																				if (salarioDescricao.isEmpty()) {
																						salarioDescricao = "Descrição: N/A";
																					} 
																				CapitalSalario novoCapitalSalario = new CapitalSalario(salarioValor, salarioCategoria, salarioDescricao);
																				todosCapitais.add(novoCapitalSalario);
																				System.out.printf("R$ %.2f - %s - %s\n", 
																					novoCapitalSalario.getValor(),
																					novoCapitalSalario.getCategoria(),
																					novoCapitalSalario.getDescricao());
																				salarioValidado = true;
																			} //fecha-else
																} catch (InputMismatchException e) {
																		System.out.println("\n-----------------------------------");
																		System.out.println("[Erro] Digite um número.\n");
																		teclado.nextLine();
																	} //fecha-catch
														} //fecha-while
													break;
												// Registro capital vale alimentação
												case 2:
													double alimentacaoValor = 0;
													boolean alimentacaoValidado = false;
													while (!alimentacaoValidado) {
															try{
																	System.out.print("Valor do Vale Alimentação: R$ ");
																	alimentacaoValor = teclado.nextDouble();
																	teclado.nextLine();
																	
																	if (alimentacaoValor < 0) {
																			System.out.println("\n-----------------------------------");
																			System.out.println("[Erro] Digite um valor positico.\n");
																		} else {
																				String alimentacaoCategoria = "vale_alimentacao";
																				System.out.print("Descrição: ");
																				String alimentacaoDescricao = teclado.nextLine();
																				if (alimentacaoDescricao.isEmpty()) {
																						alimentacaoDescricao = "Descrição: N/A";
																					}
																				CapitalValeAlimentacao novoCapitalValeAlimentacao = new CapitalValeAlimentacao(alimentacaoValor, alimentacaoCategoria, alimentacaoDescricao);
																				todosCapitais.add(novoCapitalValeAlimentacao);
																				System.out.printf("R$ %.2f - %s - %s\n", 
																					novoCapitalValeAlimentacao.getValor(),
																					novoCapitalValeAlimentacao.getCategoria(),
																					novoCapitalValeAlimentacao.getDescricao());
																				alimentacaoValidado = true;
																			} //fecha-else
																} catch (InputMismatchException e) {
																		System.out.println("\n-----------------------------------");
																		System.out.println("[Erro] Digite um número.\n");
																		teclado.nextLine();
																	} //fecha-catch
														} //fecha-while
													break;
												// Registro capital transporte
												case 3:
													double transporteValor = 0.0;
													boolean transporteValidado = false;
													while (!transporteValidado) {
															try {
																	System.out.print("Valor do Transporte: R$ ");
																	transporteValor = teclado.nextDouble();
																	teclado.nextLine();
																	
																	if (transporteValor < 0) {
																			System.out.println("\n-----------------------------------");
																			System.out.println("[Erro] Digite um valor positivo.\n");
																		} else {
																				String transporteCategoria = "vale_transporte";
																				System.out.print("Descrição: ");
																				String transporteDescricao = teclado.nextLine();
																				if (transporteDescricao.isEmpty()) {
																						transporteDescricao = "Descriçao: N/A";
																					}
																				CapitalValeTransporte novoCapitalValeTransporte = new CapitalValeTransporte(transporteValor, transporteCategoria, transporteDescricao);
																				todosCapitais.add(novoCapitalValeTransporte);
																				System.out.printf("R$ %.2f - %s - %s\n", 
																					novoCapitalValeTransporte.getValor(),
																					novoCapitalValeTransporte.getCategoria(),
																					novoCapitalValeTransporte.getDescricao());
																				transporteValidado = true;
																			} //fecha-else
																} catch (InputMismatchException e) {
																		System.out.println("\n-----------------------------------");
																		System.out.println("[Erro] Digite um número.\n");
																		teclado.nextLine();
																	} //fecha-catch
														} //fecha-while
													break;
												// Registro capital extras
												case 4:
													double extraValor =0;
													boolean extraValido = false;
													while (!extraValido) {
															try {
																	System.out.print("Valor do Extra: R$ ");
																	extraValor = teclado.nextDouble();
																	teclado.nextLine();
																	
																	if (extraValor < 0) {
																			System.out.println("\n-----------------------------------");
																			System.out.println("[Erro] Digite um valor positivo.\n");
																		} else {
																				System.out.print("Descrição do Extra: ");
																				String extraDescricao = teclado.nextLine();
																				String extraCategoria = "extra";
																				// Criar um novo objeto Capital
																				CapitalExtra novoCapitalExtra = new CapitalExtra(extraValor, extraCategoria, extraDescricao);
																				// Adicionar o novo objeto Capital à lista geral "todosCapitais"
																				todosCapitais.add(novoCapitalExtra);
																				// Usar os getters para exibir os registros
																				System.out.printf("R$ %.2f - %s - %s\n", 
																					novoCapitalExtra.getValor(),
																					novoCapitalExtra.getCategoria(),
																					novoCapitalExtra.getDescricao());
																				extraValido = true;
																			} //fecha-else
																} catch (InputMismatchException e) {
																		System.out.println("\n-----------------------------------");
																		System.out.println("[Erro] Digite um número.\n");
																		teclado.nextLine();
																	} //fecha-catch
														}
													break;
												case 5:
													System.out.println("\n-----------------------------------");
													System.out.println("Voltando ao menu principal...\n");
													break;
											} //fecha-switch
									} //fecha-else
							
						} catch (InputMismatchException e) {
								System.out.println("\n-----------------------------------");
								System.out.println("[Erro] Digite um número\n");
								teclado.nextLine();
							} //fecha-catch
					} while (opcao != 5);
										
					try {
							System.out.print("Escolha uma opção: ");
							
						} catch (InputMismatchException e) {
								System.out.println("\n-----------------------------------");
								System.out.println("[Erro] Digite um número\n");
								teclado.nextLine();
							} //fecha-catch
				} //fecha-metodo-registrarCapital
				
				
			// Menu para chamar métodos específicos para registrar despesas
			private static void registrarDespesa(Scanner teclado) {
					int opcao = 0;
					do {
							System.out.println("\n-----------------------------------");
							System.out.println("=== REGISTRAR_DESPESAS ===");
							System.out.println(" [1] Cartão de Crédito-Registro Detalhado");
							System.out.println(" [2] Despesa Fixa");
							System.out.println(" [3] Despesa Mercado");
							System.out.println(" [4] Despesa variada");
							System.out.println(" [5] Voltar");
							System.out.print("Escolha uma opção: ");
							
							try {
									opcao = teclado.nextInt();
									teclado.nextLine();
									
									if (opcao < 1 || opcao > 5) {
											System.out.println("\n-----------------------------------");
											System.out.println("[Erro] Escolha uma opção entre 1 e 5.");
										} else {
												switch (opcao) {
														case 1:
															double cartaoValor = 0;
															boolean opcaoCartaoValidado = false;
															while (!opcaoCartaoValidado) {
																	try {
																			System.out.println("Registrar Despesa Fatura Total: Escolha '[2] Despesa Fixa'.");
																			System.out.print("Valor da Compra no Cartão de Crédito: R$ ");
																			cartaoValor = teclado.nextDouble();
																			teclado.nextLine();
																			
																			if (cartaoValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Parcelas: ");
																						int cartaoParcelas = teclado.nextInt();
																						teclado.nextLine();
																						if (cartaoParcelas < 0) {
																								System.out.println("[Erro] Digite um número positivo");
																							} else {
																									double valorParcela = cartaoValor / cartaoParcelas;
																									System.out.printf("%d parcela(s) de %.2f reais\n", cartaoParcelas, valorParcela);
																									System.out.print("Banco: ");
																									String cartaoBanco = teclado.nextLine();
																									System.out.print("Descrição: ");
																									String cartaoDescricao = teclado.nextLine();
																									DespesaCredito novaDespesaCredito = new DespesaCredito(cartaoValor, cartaoParcelas, valorParcela, cartaoBanco, cartaoDescricao);
																									todasDespesas.add(novaDespesaCredito);
																									System.out.printf("[ Total: R$ %.2f - %d parcela(s) de %.2f reais - Banco: %s - Descrição: %s ] - [ Registrado com sucesso! ]\n", 
																										novaDespesaCredito.getValor(),
																										novaDespesaCredito.getParcelas(),
																										novaDespesaCredito.getValorParcela(),
																										novaDespesaCredito.getBanco(),
																										novaDespesaCredito.getDescricao());
																									opcaoCartaoValidado = true;
																								}
																					}
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-catch
																} //fecha-while 
															break;
														case 2:
															registrarDespesaFixa(teclado);
															break;
														case 3:
															registrarDespesaMercado(teclado);
															break;
														case 4:
															registrarDespesaVariada(teclado);
															break;
														case 5:
															break;
													} //fecha-switch
											}
								} catch (InputMismatchException e) {
										System.out.println("\n-----------------------------------");
										System.out.println("[Erro] Digite um número.");
										teclado.nextLine();
									}
						} while (opcao != 5);
				} //fecha-metodo-registrarDespesa
				
				
			// Menu para registrar as despesas fixas
			private static void registrarDespesaFixa(Scanner teclado) {
					int opcaoFixa = 0;
					do {
							System.out.println("\n-----------------------------------");
							System.out.println("=== REGISTRAR_DESPESA_FIXA ===");
							System.out.println(" [1] Aluguel");
							System.out.println(" [2] Luz");
							System.out.println(" [3] Água");
							System.out.println(" [4] Internet");
							System.out.println(" [5] Cursos");
							System.out.println(" [6] Fatura Cartão de Crédito");
							System.out.println(" [7] Nova Despesas Fixas");
							System.out.println(" [8] Voltar");
							System.out.print("Escolha uma opção: ");
							
							try {
									opcaoFixa = teclado.nextInt();
									teclado.nextLine();
									
									if (opcaoFixa < 0 || opcaoFixa > 8) {
											System.out.println("\n-----------------------------------");
											System.out.println("[Erro] Escolha uma opçao entre 1 e 8.");
										} else {
												switch (opcaoFixa) {
														case 1:
															double aluguelValor = 0.0;
															String aluguelCategoria = "";
															boolean aluguelValidado = false;
															while (!aluguelValidado) {
																	try {
																			System.out.print("Valor do Aluguel: R$ ");
																			aluguelValor = teclado.nextDouble();
																			teclado.nextLine();
																			
																			if (aluguelValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Descrição: ");
																						String aluguelDescricao = teclado.nextLine();
																						if (aluguelDescricao.isEmpty()) {
																								aluguelDescricao = "N/A";
																							}
																						aluguelCategoria = "aluguel";
																						DespesaFixa novaDespesaFixa = new DespesaFixa(aluguelValor, aluguelCategoria, aluguelDescricao);
																						todasDespesas.add(novaDespesaFixa);
																						System.out.printf("[ R$ %.2f - %s - %s] - [ Despesa Fixa registrado com sucesso!]\n", 
																							novaDespesaFixa.getValor(), 
																							novaDespesaFixa.getCategoria(),
																							novaDespesaFixa.getDescricao());
																						aluguelValidado = true;
																					} //fecha-else
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-catch
																} //fecha-while
															break;
														case 2:
															double luzValor = 0.0;
															boolean luzValidado = false;
															while (!luzValidado) {
																	try {
																			System.out.print("Valor da Luz: R$ ");
																			luzValor = teclado.nextDouble();
																			teclado.nextLine();
																			if (luzValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Descrição: ");
																						String luzDescricao = teclado.nextLine();
																						if (luzDescricao.isEmpty()) {
																								luzDescricao = "N/A";
																							}
																						String luzCategoria = "luz";
																						DespesaFixa novaDespesaFixa = new DespesaFixa(luzValor, luzCategoria, luzDescricao);
																						todasDespesas.add(novaDespesaFixa);
																						System.out.printf("[ R$ %.2f - %s - %s] - [ Luz registrado com sucesso! ]\n", 
																							novaDespesaFixa.getValor(),
																							novaDespesaFixa.getCategoria(),
																							novaDespesaFixa.getDescricao());
																						luzValidado = true;
																					} //fecha-else
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-catch
																} //fecha-while
															break;
														case 3:
															double aguaValor = 0.0;
															boolean aguaValidado = false;
															while (!aguaValidado) {
																	try {
																			System.out.print("Valor da Água: R$ ");
																			aguaValor = teclado.nextDouble();
																			teclado.nextLine();
																			if (aguaValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Descrição: ");
																						String aguaDescricao = teclado.nextLine();
																						if (aguaDescricao.isEmpty()) {
																								aguaDescricao = "N/A";
																							} 
																						String aguaCategoria = "agua";
																						DespesaFixa novaDespesaFixa = new DespesaFixa(aguaValor, aguaCategoria, aguaDescricao);
																						todasDespesas.add(novaDespesaFixa);
																						System.out.printf("[ R$ %.2f - %s - %s] - [ Água registrado com sucesso ]\n", 
																							novaDespesaFixa.getValor(),
																							novaDespesaFixa.getCategoria(),
																							novaDespesaFixa.getDescricao());
																						aguaValidado = true;
																					} //fecha-else
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-
																} //fecha-while
															break;
														case 4:
															double internetValor = 0.0;
															boolean internetValidado = false;
															while (!internetValidado) {
																	try {
																			System.out.print("Valor da internet: R$ ");
																			internetValor = teclado.nextDouble();
																			teclado.nextLine();
																			if (internetValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Descrição: ");
																						String internetDescricao = teclado.nextLine();
																						if (internetDescricao.isEmpty()) {
																								internetDescricao = "N/A";
																							}
																						String internetCategoria = "internet";
																						DespesaFixa novaDespesaFixa = new DespesaFixa(internetValor, internetCategoria, internetDescricao);
																						todasDespesas.add(novaDespesaFixa);
																						System.out.printf("[ R$ %.2f - %s - %s] - [ Internet registrado com sucesso! ]\n", 
																							novaDespesaFixa.getValor(),
																							novaDespesaFixa.getCategoria(),
																							novaDespesaFixa.getDescricao());
																						internetValidado = true;
																					} //fecha-else
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-cacth
																} //fecha-while
															break;
														case 5:
															double cursoValor = 0.0;
															boolean cursoValidado = false;
															while (!cursoValidado) {
																	try {
																			System.out.print("Valor do Curso: R$ ");
																			cursoValor = teclado.nextDouble();
																			teclado.nextLine();
																			if (cursoValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																					 System.out.print("Descrição: ");
																					 String cursoDescricao = teclado.nextLine();
																					 if (cursoDescricao.isEmpty()) {
																							cursoDescricao = "N/A";
																						 }
																					 String cursoCategoria = "curso";
																					 DespesaFixa novaDespesaFixa = new DespesaFixa(cursoValor, cursoCategoria, cursoDescricao);
																					 todasDespesas.add(novaDespesaFixa);
																					 System.out.printf("[ R$ %.2f - %s - %s] - [ Curso registrado com sucesso! ]\n", 
																						novaDespesaFixa.getValor(),
																						novaDespesaFixa.getCategoria(),
																						novaDespesaFixa.getDescricao());
																					 cursoValidado = true; 								
																					} //fecha-else
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-catch
																} //fecha-while
															break;
														case 6:
															double faturaValor = 0.0;
															boolean faturaValidado = false;
															while (!faturaValidado) {
																	try {
																			System.out.print("Valor da Fatura: R$ ");
																			faturaValor = teclado.nextDouble();
																			teclado.nextLine();
																			if (faturaValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Banco: ");
																						String faturaBanco = teclado.nextLine();
																						if (faturaBanco == "") {
																								faturaBanco = "N/A";
																							} 
																						System.out.print("Descrição: ");
																						String faturaDescricao = teclado.nextLine();
																						if (faturaDescricao.isEmpty()) {
																								faturaDescricao = "N/A";
																							}	
																						String faturaCategoria = "fatura";
																						DespesaFixa novaDespesaFixa = new DespesaFixa(faturaValor, faturaCategoria, faturaDescricao);
																						todasDespesas.add(novaDespesaFixa);
																						System.out.printf("[ R$ %.2f - %s - %s ] - [ Fatura registrado com sucesso! ]\n", 
																							novaDespesaFixa.getValor(),
																							novaDespesaFixa.getCategoria(),
																							novaDespesaFixa.getDescricao());
																						faturaValidado = true;
																					} //fecha-else
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-catch
																} //fecha-while
															break;
														case 7:
															double novoValor = 0.0;
															boolean novoValidado = false;
															while (!novoValidado) {
																	try {
																			System.out.print("Valor da Nova Categoria: R$ ");
																			novoValor = teclado.nextDouble();
																			teclado.nextLine();
																			if (novoValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Nome da Nova Categoria: ");
																						String novoCategoria = teclado.nextLine();
																						if (novoCategoria.isEmpty()) {
																								novoCategoria = "nova_despesa_fixa";
																							}
																						System.out.print("Descrição: ");
																						String novoDescricao = teclado.nextLine();
																						if (novoDescricao.isEmpty()) {
																								novoDescricao = "Descrição: N/A";
																							}
																						DespesaFixa novaDespesaFixa = new DespesaFixa(novoValor, novoCategoria, novoDescricao);
																						todasDespesas.add(novaDespesaFixa);
																						System.out.printf("[ R$ %.2f - %s - %s ] - [ Registrado com sucesso! ]\n", 
																							novaDespesaFixa.getValor(),
																							novaDespesaFixa.getCategoria(),
																							novaDespesaFixa.getDescricao()); 
																						novoValidado = true; 
																					} //fecha-else
																			
																		} catch (InputMismatchException e) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Digite um número.");
																				teclado.nextLine();
																			} //fecha-catch
																} //fecha-while
															break;
														case 8:
															break;
													} //fecha-switch
											} //fecha-else
										 
								} catch (InputMismatchException e) {
										System.out.println("\n-----------------------------------");
										System.out.println("[Erro] Digite um número.");
										teclado.nextLine();
									} //fecha-catch
						} while (opcaoFixa != 8);
						
				} //fecha-metodo-registrarDespesaFixa
				
				//OBS: Continua aqui. Lembrar de criar ArrayList para salvar e somar os valores de todos os novos nétodos e diferenciar gasto de vale alimentação.
				private static void registrarDespesaMercado(Scanner teclado) {
						int opcaoMercado = 0;
						String categoriaMercado = "";
						String tipoMercado = "";
						double valorMercado = 0.0;
						String descricaoMercado = "";
						do {	
								System.out.println("\n-----------------------------------");
								System.out.println("=== REGISTRAR_DESPESA_MERCADO ===");
								System.out.println(" [1] Vale Alimentação.");
								System.out.println(" [2] Dinheiro Normal");
								System.out.println(" [3] Voltar");
								System.out.print(" Escolha uma opção: ");
								
								try {
										opcaoMercado = teclado.nextInt();
										teclado.nextLine();
										
										if (opcaoMercado < 1 || opcaoMercado > 3) {
												System.out.println("\n-----------------------------------");
												System.out.println("[Erro] Escolha uma opção entre 1 e 3.");
											} else if (opcaoMercado == 1) {
													int opcaoVale = 0;
													do {
															System.out.println("\n-----------------------------------");
															System.out.println("=== REGISTRAR_DESPESA_MERCADO_VALE ===");
															System.out.println(" [1] Fribal");
															System.out.println(" [2] Mix Pinheiro");
															System.out.println(" [3] Outra Categoria");
															System.out.println(" [4] Voltar");
															System.out.print("Escolha uma opção: ");
															
															try {
																	opcaoVale = teclado.nextInt();
																	teclado.nextLine();
																	if (opcaoVale < 1 || opcaoVale > 4) {
																			System.out.println("\n-----------------------------------");
																			System.out.println("[Erro] Escolha uma opção entre 1 e 4.");
																		} else {
																				switch (opcaoVale) {
																						case 1:
																							boolean opcaoUmValidado = false;
																							while (!opcaoUmValidado) {
																									try {
																											System.out.print("Valor Fribal: R$ ");
																											valorMercado = teclado.nextDouble();
																											teclado.nextLine();
																											if (valorMercado < 0) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um valor positivo.");
																												} else {
																														System.out.print("Descrição: ");
																														descricaoMercado = teclado.nextLine();
																														if (descricaoMercado.isEmpty()) {
																																descricaoMercado = "Descrição: N/A";
																															} //fecha-if
																														categoriaMercado = "Fribal";
																														tipoMercado = "vale";
																														// Criar um novo objeto Despesa
																														DespesaMercado novaDespesaMercadoVale = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																														// Adicionar o objeto Despesa à lista correta
																														todasDespesas.add(novaDespesaMercadoVale); // Adiciona o objeto, não mais um Object[]
																														// Usando os getters para exibir
																														System.out.printf("[ R$ %.2f - %s - %s - %s ] [Registrado! ]\n",
																															novaDespesaMercadoVale.getValor(),
																															novaDespesaMercadoVale.getCategoria(),
																															novaDespesaMercadoVale.getTipoPagamento(),
																															novaDespesaMercadoVale.getDescricao());
																														opcaoUmValidado = true;
																													} //fecha-else
																										} catch (InputMismatchException e) {
																												System.out.println("\n-----------------------------------");
																												System.out.println("[Erro] Digite um número.");
																												teclado.nextLine();
																											} //fecha-catch
																								} //fecha-while
																								break;
																							case 2: 
																								boolean opcaoDoisValidado = false;
																								while (!opcaoDoisValidado) {
																										try {
																												System.out.print("Valor Mix Pinheiro: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Mix Pinheiro";
																															tipoMercado = "vale";
																															DespesaMercado novaDespesaMercadoVale = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoVale);
																															System.out.printf("[ R$ %.2f - %s - %s ] [ Registrado!! ]\n", 
																																novaDespesaMercadoVale.getValor(), 
																																novaDespesaMercadoVale.getCategoria(), 
																																novaDespesaMercadoVale.getTipoPagamento(), 
																																novaDespesaMercadoVale.getDescricao());
																															opcaoDoisValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 3:
																								boolean opcaoTresValidado = false;
																								while (!opcaoTresValidado) {
																										try {
																												System.out.print("Valor Outra Categoria: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Nome da Nova Categoria: ");
																															categoriaMercado = teclado.nextLine();
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															tipoMercado = "vale";
																															DespesaMercado novaDespesaMercadoVale = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoVale);
																															System.out.printf(" [ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																															novaDespesaMercadoVale.getValor(), 
																															novaDespesaMercadoVale.getCategoria(), 
																															novaDespesaMercadoVale.getTipoPagamento(), 
																															novaDespesaMercadoVale.getDescricao());
																															opcaoTresValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 4:
																								break;
																					} //fecha-switch
																			} //fecha-else
																} catch (InputMismatchException e) {
																		System.out.println("\n-----------------------------------");
																		System.out.println("[Erro] Digite um número.");
																		teclado.nextLine();
																	} //fecha-catch
														} while (opcaoVale != 4);
												} else if (opcaoMercado == 2) {
														int opcaoDinheiro = 0;
														do {
																System.out.println("\n-----------------------------------");
																System.out.println("=== REGISTRAR_DESPESA_MERCADO_DINHEIRO ===");
																System.out.println(" [1] Fribal");
																System.out.println(" [2] Mix Pinheiro");
																System.out.println(" [3] JB");
																System.out.println(" [4] Rodrigues");
																System.out.println(" [5] Pão");
																System.out.println(" [6] Frutaria");
																System.out.println(" [7] Tempero");
																System.out.println(" [8] Construção");
																System.out.println(" [9] Nova Categoria");
																System.out.println(" [10] Voltar");
																System.out.print("Escolha uma opção: ");
																
																try {
																		opcaoDinheiro = teclado.nextInt();
																		teclado.nextLine();
																		if (opcaoDinheiro < 1 || opcaoDinheiro > 10) {
																				System.out.println("\n-----------------------------------");
																				System.out.println("[Erro] Escolha uma opção entre 1 e 10.");
																			} else {
																					switch (opcaoDinheiro) {
																							case 1:
																								boolean opcaoUmValidado = false;
																								while (!opcaoUmValidado) {
																										try {
																												System.out.print("Valor Fribal: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																														System.out.print("Descrição: ");
																														descricaoMercado = teclado.nextLine();
																														if (descricaoMercado.isEmpty()) {
																																descricaoMercado = "Descrição: N/A";
																															} //fecha-if
																														categoriaMercado = "Fribal";
																														tipoMercado = "dinheiro";
																														DespesaMercado novaDespesaMercado = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																														System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																															novaDespesaMercado.getValor(),
																															novaDespesaMercado.getCategoria(),
																															novaDespesaMercado.getTipoPagamento(),
																															novaDespesaMercado.getDescricao());
																														opcaoUmValidado = true;
																													} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 2:
																								boolean opcaoDoisValidado = false;
																								while (!opcaoDoisValidado) {
																										try {
																												System.out.print("Valor Mix Pinheiro: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Mix Pinheiro";
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																																novaDespesaMercadoDinheiro.getValor(),
																																novaDespesaMercadoDinheiro.getCategoria(),
																																novaDespesaMercadoDinheiro.getTipoPagamento(),
																																novaDespesaMercadoDinheiro.getDescricao());
																															opcaoDoisValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 3:
																								boolean opcaoTresValidado = false;
																								while (!opcaoTresValidado) {
																										try {
																												System.out.print("Valor JB: ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.println("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "JB";
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																																novaDespesaMercadoDinheiro.getValor(),
																																novaDespesaMercadoDinheiro.getCategoria(),
																																novaDespesaMercadoDinheiro.getTipoPagamento(),
																																novaDespesaMercadoDinheiro.getDescricao());
																															opcaoTresValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();;
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 4:
																								boolean opcaoQuatroValidado = false;
																								while (!opcaoQuatroValidado) {
																										try {
																												System.out.print("Valor Rodrigues: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Rodrigues";
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																															novaDespesaMercadoDinheiro.getValor(), 
																															novaDespesaMercadoDinheiro.getCategoria(), 
																															novaDespesaMercadoDinheiro.getTipoPagamento(), 
																															novaDespesaMercadoDinheiro.getDescricao());
																															opcaoQuatroValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 5:
																								boolean opcaoQuintoValidado = false;
																								while (!opcaoQuintoValidado) {
																										try {
																												System.out.print("Valor Pão: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Pão";
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [Registrado! ]\n", 
																																novaDespesaMercadoDinheiro.getValor(),
																																novaDespesaMercadoDinheiro.getCategoria(),
																																novaDespesaMercadoDinheiro.getTipoPagamento(),
																																novaDespesaMercadoDinheiro.getDescricao());
																															opcaoQuintoValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 6:
																								boolean opcaoSextoValidado = false;
																								while (!opcaoSextoValidado) {
																										try {
																												System.out.print("Valor Frutaria: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																}
																															categoriaMercado = "Frutaria";
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																																novaDespesaMercadoDinheiro.getValor(),
																																novaDespesaMercadoDinheiro.getCategoria(),
																																novaDespesaMercadoDinheiro.getTipoPagamento(),
																																novaDespesaMercadoDinheiro.getDescricao());
																															opcaoSextoValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 7:
																								boolean opcaoSeteValidado = false;
																								while (!opcaoSeteValidado) {
																										try {
																												System.out.print("Valor Tempero: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																 descricaoMercado = "Descrição: N/A";
																																}
																															categoriaMercado = "Tempero";
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																															novaDespesaMercadoDinheiro.getValor(),
																															novaDespesaMercadoDinheiro.getCategoria(),
																															novaDespesaMercadoDinheiro.getTipoPagamento(),
																															novaDespesaMercadoDinheiro.getDescricao());
																															opcaoSeteValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 8:
																								boolean opcaoOitoValidado = false;
																								while (!opcaoOitoValidado) {
																										try {
																												System.out.print("Valor Construção: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Descrição; ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																}
																															categoriaMercado = "Construcao";
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																															novaDespesaMercadoDinheiro.getValor(),
																															novaDespesaMercadoDinheiro.getCategoria(),
																															novaDespesaMercadoDinheiro.getTipoPagamento(),
																															novaDespesaMercadoDinheiro.getDescricao());
																															opcaoOitoValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um número.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 9:
																								boolean opcaoNoveValidado = false;
																								while (!opcaoNoveValidado) {
																										try {
																												System.out.print("Valor Nova Categoria: R$ ");
																												valorMercado = teclado.nextDouble();
																												teclado.nextLine();
																												if (valorMercado < 0) {
																														System.out.println("\n-----------------------------------");
																														System.out.println("[Erro] Digite um valor positivo.");
																													} else {
																															System.out.print("Nome Nova Categoria: ");
																															categoriaMercado = teclado.nextLine();
																															if (categoriaMercado.isEmpty()) {
																																	categoriaMercado = "Nova_Categoria";
																																} //fecha-if
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado.isEmpty()) {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															tipoMercado = "dinheiro";
																															DespesaMercado novaDespesaMercadoDinheiro = new DespesaMercado(valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
																															todasDespesas.add(novaDespesaMercadoDinheiro);
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", 
																																novaDespesaMercadoDinheiro.getValor(),
																																novaDespesaMercadoDinheiro.getCategoria(),
																																novaDespesaMercadoDinheiro.getTipoPagamento(),
																																novaDespesaMercadoDinheiro.getDescricao());
																															opcaoNoveValidado = true;
																														} //fecha-else
																											} catch (InputMismatchException e) {
																													System.out.println("\n-----------------------------------");
																													System.out.println("[Erro] Digite um núemro.");
																													teclado.nextLine();
																												} //fecha-catch
																									} //fecha-while
																								break;
																							case 10:
																								break;
																						} //fecha-switch
																				} //fecha-else
																	} catch (InputMismatchException e) {
																			System.out.println("\n-----------------------------------");
																			System.out.println("[Erro] Digite um número.");
																			teclado.nextLine();
																		} //fecha-catch
															} while (opcaoDinheiro != 10);
													} //fecha-else-if
									} catch (InputMismatchException e) {
											System.out.println("\n-----------------------------------");
											System.out.println("[Erro] Digite um número.");
											teclado.nextLine();
										} //fecha-catch
							} while (opcaoMercado != 3);
					} //fecha-metodo-registrarDespesaMercado
				
				private static void registrarDespesaVariada(Scanner teclado) {
						double valorVariada = 0.0;
						String categoriaVariada = "";
						String descricaoVariada = "";
						boolean opcaoVariadaValidado = false;
						while(!opcaoVariadaValidado) {
								try {
										System.out.print("Valor da Despesa Variada: R$ ");
										valorVariada = teclado.nextDouble();
										teclado.nextLine();
										if (valorVariada < 0) {
												System.out.println("[Erro] Digite um valor positivo.");
											} else {
													System.out.print("Categoria: ");
													categoriaVariada = teclado.nextLine();
													if (categoriaVariada.isEmpty()) {
															categoriaVariada = "Variada";
														}
													System.out.print("Descrição: ");
													descricaoVariada = teclado.nextLine();
													// trim() é usado para que espaços em branco não seja considerado um valor válido
													if (descricaoVariada.trim().isEmpty()) {
															descricaoVariada = "N/A";
														}
													DespesaVariada novaDespesaVariada = new DespesaVariada(valorVariada, categoriaVariada, descricaoVariada);
													todasDespesas.add(novaDespesaVariada);
													System.out.printf("[ %.2f - %s - %s ] Registrado!\n", 
														novaDespesaVariada.getValor(),
														novaDespesaVariada.getCategoria(),
														novaDespesaVariada.getDescricao());
													opcaoVariadaValidado = true;
												} //fecha-else
									} catch (InputMismatchException e) {
											System.out.println("\n-----------------------------------");
											System.out.println("[Erro] Digite um número.");
											teclado.nextLine();
										} //fecha-catch
							} //fecha-while 
					} //fecha-método-registrarDespesaVariada
				
			// Menu para visualizar todos saldos de capital somados
			private static void visualizarSaldosCapital() {	
					double totalTodasDespesas = 0.0;
					double totalDespesaFixa = 0.0;
					double totalDespesaCredito = 0.0;
					double totalDespesaMercado = 0.0;
					double totalDespesaVariada = 0.0;
					
					boolean temDespesaFixa = false;
					boolean temDespesaCredito = false;
					boolean temDespesaMercado = false;
					boolean temDespesaVariada = false;
					
					for (Despesa despesa : todasDespesas) {
							totalTodasDespesas += despesa.getValor();
							
							if (despesa instanceof DespesaFixa) {
									totalDespesaFixa += despesa.getValor();
									temDespesaFixa = true;
								}	
							if (despesa instanceof DespesaCredito) {
									totalDespesaCredito += despesa.getValor();
									temDespesaCredito = true;
								}	
							if (despesa instanceof DespesaMercado) {
									totalDespesaMercado += despesa.getValor();
									temDespesaMercado = true;
								}
							if (despesa instanceof DespesaVariada) {
									totalDespesaVariada += despesa.getValor();
									temDespesaVariada = true;
								}
						} //fecha-for
					
					if (temDespesaFixa) {
							System.out.println("\n-----------------------------------");
							System.out.println("\n=== DESPESA FIXA DETALHADA ===");
							for (Despesa despesa : todasDespesas) {
									if (despesa instanceof DespesaFixa) {
										DespesaFixa d = (DespesaFixa) despesa;
										System.out.printf("R$ %.2f - %s - %s\n", d.getValor(), d.getCategoria(), d.getDescricao());
									}
								}
						} //fecha-if
						
					if (temDespesaCredito) {
							System.out.println("\n-----------------------------------");
							System.out.println("\n=== DESPESA CARTÃO DE CRÉDITO DETALHADA ===");
							for (Despesa despesa : todasDespesas) {
									if (despesa instanceof DespesaCredito) {
											DespesaCredito d = (DespesaCredito) despesa;
											System.out.printf("R$ %.2f - %dx de %.2f - %s - %s\n", d.getValor(), d.getParcelas(), d.getValorParcela(), d.getBanco(), d.getDescricao());
										}
								}
						} //fecha-if
						
					if (temDespesaMercado) {
							System.out.println("\n-----------------------------------");
							System.out.println("\n=== DESPESA MERCADO DETALHADA ===");
							for (Despesa despesa : todasDespesas) {
									if (despesa instanceof DespesaMercado) {
											DespesaMercado d = (DespesaMercado) despesa;
											System.out.printf("R$ %.2f - %s - %s - %s\n", d.getValor(), d.getCategoria(), d.getTipoPagamento(), d.getDescricao());
										}
								}
						} //fecha-if
						
					if (temDespesaVariada) {
							System.out.println("\n-----------------------------------");
							System.out.println("\n=== DESPESA VARIADA DETALHADA ===");
							for (Despesa despesa : todasDespesas) {
									if (despesa instanceof DespesaVariada) {
											DespesaVariada d = (DespesaVariada) despesa;
											System.out.printf("R$ %.2f - %s - %s\n", d.getValor(), d.getCategoria(), d.getDescricao());
										}
								}
						} //fecha-if
					
					System.out.println("\n-----------------------------------");
					System.out.printf("TOTAL TODAS DESPESAS: R$ %.2f\n", totalTodasDespesas);
					System.out.printf("TOTAL DESPESA FIXA: R$ %.2f\n", totalDespesaFixa);
					System.out.printf("TOTAL DESPESA CARTÃO DE CRÉDITO: R$ %.2f\n", totalDespesaCredito);
					System.out.printf("TOTAL DESPESA MERCADO: R$ %.2f\n",totalDespesaMercado);
					System.out.printf("TOTAL DESPESA VARIADA: R$ %.2f\n", totalDespesaVariada);
			} //fecha-metodo-visualizarSaldos
			
					double totalTodosCapitais = 0.0;
					double totalCapitalSalario = 0.0;
					double totalCapitalExtra =
					double totalCapitalValeAlimentacao = 0.0;
					double totalCapitalValeTransporte = 0.0;
					
					boolean temCapialSalario = false;
					boolean temCapitalExtra = false;
					boolean temCapitalValeAlimentacao = false;
					boolean temCapitalValeTransporte = false;
					
					for (Capital capital : todosCapitais) {
							totalTodosCapitais += capital.getValor();
							
							if (capital instanceof CapitaSalario) {
									totalCapitalSalario += capital.getValor();
									temCapialSalario = true;
								}
						}

				
	} //fecha-clsse-Pricipal
