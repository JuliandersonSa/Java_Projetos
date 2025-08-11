
package aplicacao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Principal{
		private static double salario = 0.0;
		private static ArrayList<Object[]> extras = new ArrayList<>();
		private static double transporte = 0.0;
		private static double valeAlimentacao = 0.0;
		private static ArrayList<Object[]> despesaFixa = new ArrayList<>();
		private static ArrayList<Object[]> cartaoCredito =  new ArrayList<>();
		private static ArrayList<Object[]> despesaMercadoVale = new ArrayList<>();
		private static ArrayList<Object[]> despesaMercadoDinheiro = new ArrayList<>();
		private static double saldoDespesaVariada = 0.0;
	
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
																				System.out.printf("[ R$ %.2f ] - [ Salario registrado com sucesso! ]\n", salarioValor);
																				salario += salarioValor;
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
																				System.out.printf("[ R$ %.2f ] - [ Vale Alimentação registrado com sucesso! ]\n", alimentacaoValor);
																				valeAlimentacao += alimentacaoValor;
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
																				System.out.printf("[ %.2f ] - [ Transporte registrado com sucesso ]\n", transporteValor);
																				transporte += transporteValor;
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
																				// Armazenar o valor e a descrição com um array de objetos
																				extras.add(new Object[] {extraValor, extraDescricao});
																				System.out.printf("[ R$ %.2f - %s ] - [ Extra registrado com sucesso! ]\n", extraValor, extraDescricao);
																				extraValido = true; // 
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
																						System.out.print("Banco: ");
																						String cartaoBanco = teclado.nextLine();
																						System.out.print("Descrição: ");
																						String cartaoDescricao = teclado.nextLine();
																						cartaoCredito.add(new Object[] {cartaoValor, cartaoBanco, cartaoDescricao});
																						System.out.printf("[ R$ %.2f - %s - %s ] - [ Registrado com sucesso! ]\n", cartaoValor, cartaoBanco, cartaoDescricao);
																						opcaoCartaoValidado = true;
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
							System.out.println(" [7] Outras Despesas Fixas");
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
																						if (aluguelDescricao == "") {
																								aluguelDescricao = "N/A";
																							}
																						despesaFixa.add(new Object[] {aluguelValor, aluguelDescricao});
																						System.out.printf("[ R$ %.2f - %s ] - [ Aluguel registrado com sucesso!]\n", aluguelValor, aluguelDescricao);
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
																						if (luzDescricao == "") {
																								luzDescricao = "N/A";
																							}
																						System.out.printf("[ R$ %.2f - %s ] - [ Luz registrado com sucesso! ]\n", luzValor, luzDescricao);
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
																						if (aguaDescricao == "") {
																								aguaDescricao = "N/A";
																							} 
																						System.out.printf("[ R$ %.2f - %s ] - [ Água registrado com sucesso ]\n", aguaValor, aguaDescricao);
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
																						if (internetDescricao == "") {
																								internetDescricao = "N/A";
																							}
																						System.out.printf("[ R$ %.2f - %s ] - [ Internet registrado com sucesso! ]\n", internetValor, internetDescricao);
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
																					 if (cursoDescricao == "") {
																							cursoDescricao = "N/A";
																						 }
																					 System.out.printf("[ R$ %.2f - %s ] - [ Curso registrado com sucesso! ]\n", cursoValor, cursoDescricao);
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
																						if (faturaDescricao == "") {
																								faturaDescricao = "N/A";
																							}	
																						System.out.printf("[ R$ %.2f - %s - %s - ] - [ Fatura registrado com sucesso! ]\n", faturaValor, faturaBanco, faturaDescricao);
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
															double outroValor = 0.0;
															boolean outroValidado = false;
															while (!outroValidado) {
																	try {
																			System.out.print("Valor da Nova Categoria: R$ ");
																			outroValor = teclado.nextDouble();
																			teclado.nextLine();
																			if (outroValor < 0) {
																					System.out.println("\n-----------------------------------");
																					System.out.println("[Erro] Digite um valor positivo.");
																				} else {
																						System.out.print("Nome da Nova Categoria: ");
																						String outroNome = teclado.nextLine();
																						if (outroNome == "") {
																								outroNome = "Outras_Despesas_Fixas";
																							}
																						System.out.print("Descrição: ");
																						String outroDescricao = teclado.nextLine();
																						if (outroDescricao == "") {
																								outroDescricao = "Descrição: N/A";
																							}
																						System.out.printf("[ %s: R$ %.2f - %s ] - [ %s registrado com sucesso! ]\n", outroNome, outroValor, outroDescricao, outroNome); 
																						outroValidado = true; 
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
																														if (descricaoMercado == "") {
																																descricaoMercado = "Descrição: N/A";
																															} //fecha-if
																														categoriaMercado = "Fsribal";
																														tipoMercado = "vale";
																														despesaMercadoVale.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																														System.out.printf("[ R$ %.2f - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Mix Pinheiro";
																															tipoMercado = "vale";
																															despesaMercadoVale.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s ] [ Registrado!! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															tipoMercado = "vale";
																															despesaMercadoVale.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf(" [ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																														if (descricaoMercado == "") {
																																descricaoMercado = "Descrição: N/A";
																															} //fecha-if
																														categoriaMercado = "Fribal";
																														tipoMercado = "dinheiro";
																														despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																														System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Mix Pinheiro";
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "JB";
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado,  tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Rodrigues";
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															categoriaMercado = "Pão";
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																}
																															categoriaMercado = "Frutaria";
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																 descricaoMercado = "Descrição: N/A";
																																}
																															categoriaMercado = "Tempero";
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																}
																															categoriaMercado = "Construcao";
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
																															if (categoriaMercado == "") {
																																	categoriaMercado = "Nova_Categoria";
																																} //fecha-if
																															System.out.print("Descrição: ");
																															descricaoMercado = teclado.nextLine();
																															if (descricaoMercado == "") {
																																	descricaoMercado = "Descrição: N/A";
																																} //fecha-if
																															tipoMercado = "dinheiro";
																															despesaMercadoDinheiro.add(new Object[] {valorMercado, categoriaMercado, tipoMercado, descricaoMercado});
																															System.out.printf("[ R$ %.2f - %s - %s - %s ] [ Registrado! ]\n", valorMercado, categoriaMercado, tipoMercado, descricaoMercado);
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
				
				
			// Menu para visualizar todos saldos de capital somados
			private static void visualizarSaldosCapital() {	
					System.out.println("\n-----------------------------------");
					System.out.printf("[ Total Salário: R$ %.2f ]\n", salario);  
					
					System.out.printf("[ Total Vale Alimentação: R$ %.2f ]\n", valeAlimentacao);
					
					System.out.printf("[ Total Transporte: R$ %.2f ]\n", transporte);
					
					double totalExtras = 0.0;
					for (Object[] extra : extras) {
							totalExtras += (Double) extra[0];
						}
					System.out.printf("[ Total Extras: R$ %.2f ]\n", totalExtras);
			} //fecha-metodo-visualizarSaldos

				
	} //fecha-clsse-Pricipal
