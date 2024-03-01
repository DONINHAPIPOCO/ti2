package com.ti2cc;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		Carro carro = new Carro();
		
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		dao.conectar();
		
		Carro[] carros = dao.getCarros();
		int codigo = 0;
		String modelo = "";
		String marca = "";
		String placa = "";

		
		while(true){
			
			System.out.println("1 - Listar");
			System.out.println("2 - Inserir");
			System.out.println("3 - Excluir");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Sair");
			
			System.out.print("Selecione uma opção: ");
			opcao = Integer.parseInt(entrada.nextLine());
			
			
			switch (opcao) {
				
				case 1:
					carros = dao.getCarros();
					
					System.out.println("");
					
					for(int i = 0; i < carros.length; i++) {
						System.out.println(carros[i]);
						
					}
					
					System.out.println("");
					
					break;
					
				case 2:
					System.out.print("Digite o código: ");
					codigo = Integer.parseInt(entrada.nextLine());
					
					carros = dao.getCarros();
					
					for(int i = 0; i < carros.length; i++) {
						if(carros[i].getCodigo() == codigo) {
							System.out.println("ERRO! Esse código já existe!");
							return;
							
						} else {
							carro.setCodigo(codigo);
							
						}
						
					}
					
					System.out.print("Digite o modelo: ");
					modelo = entrada.nextLine();
					carro.setModelo(modelo);
					
					System.out.print("Digite a marca: ");
					marca = entrada.nextLine();
					carro.setMarca(marca);
					
					System.out.print("Digite a placa do carro: ");
					placa = entrada.nextLine();
					for(int i = 0; i < carros.length; i++) {
						if(carros[i].getPlaca().equals(placa)) {
							System.out.println("ERRO! Essa placa já existe!");
							return;
							
						} else {
							carro.setPlaca(placa);
							
						}
						
					}
					
					dao.inserirCarro(carro);
					System.out.println("Inserido com sucesso!\n");
					
					break;
					
				case 3:
					System.out.print("Digite o código do carro a ser removido: ");
					codigo = Integer.parseInt(entrada.nextLine());
					dao.excluirCarro(codigo);
					System.out.println("Removido com sucesso!");
					
					break;
					
					
				case 4:
					System.out.print("Digite o código do carro a ser atualizado: ");
					codigo = Integer.parseInt(entrada.nextLine());
					
					carros = dao.getCarros();
					carro = dao.getCarro(codigo);
					
					for(int i = 0; i < carros.length; i++) {
						if(carros[i].getCodigo() == codigo) {
							System.out.print("Digite o novo modelo: ");
							modelo = entrada.nextLine();
							if(!modelo.isBlank()) {
								carro.setModelo(modelo);
								
							}
							
							System.out.print("Digite a nova marca: ");
							marca = entrada.nextLine();
							if(!marca.isBlank()) {
								carro.setMarca(marca);
								
							}
							
							System.out.print("Digite a nova placa: ");
							placa = entrada.nextLine();
							if(!marca.isBlank()) {
								carro.setPlaca(placa);
								
							}
							
						} else {
							System.out.println("ERRO! Esse código não existe!");
							return;
							
						}
						
					}
					
					
					
					dao.atualizarCarro(carro);
					
					break;
					
				case 5:
					System.out.println("Saindo...");
					dao.close();		
					entrada.close();
					
					return;
					
				default:
					System.out.println("ERRO! Digite um código válido!");
			
			}
			
		}
		
		
		
	}
}