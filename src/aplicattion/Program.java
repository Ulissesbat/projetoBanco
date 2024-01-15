package aplicattion;

import java.util.Locale;
import java.util.Scanner;

import entities.ContaBanco;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		ContaBanco conta1 = new ContaBanco();
		boolean continuar = true;

		System.out.print("Digite o numero da conta: ");
		int conta = sc.nextInt();
		conta1.setNumConta(conta);
		System.out.print("Digite a senha: ");
		int senha = sc.nextInt();
		conta1.setSenha(senha);
		System.out.print("Digite cc para Conta Corrente ou cp para Conta Poupanca: ");
		sc.nextLine();
		String tipo = sc.nextLine();
		conta1.setTipo(tipo);
		conta1.abrirConta();
		if(tipo.equals("cc")) {
			System.out.println("PARABENS --> Voce ganhou R$ 50.00 por abrir uma Conta Corrente.\n");
			
		} else {
			System.out.println("PARABENS --> Voce ganhou R$ 150.00 por abrir uma Conta Poupanca.\n");
			
		}
		System.out.print("Nome do titular da conta: ");
		String titular = sc.nextLine();
		conta1.setTitular(titular);
		System.out.println(" Deseja fazer um deposito: sim / nao. ");
		char resp = sc.next().charAt(0);
		if (resp == 's') {
			System.out.println("Qual valor de deposito: ");
			float deposito = sc.nextFloat();
			conta1.setSaldo(deposito);
			System.out.println("Deposito realizado com sucesso!");
			
		} else {
			System.out.println( "Extrato: \n");
			System.out.println(conta1);
		
		}

		while (continuar) {
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Saque ");
			System.out.println("2 - Depósito ");
			System.out.println("3 - Consultar saldo ");
			System.out.println("4 - Fechar conta ");
			System.out.println("5 - Sair ");

			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				conta1.sacar();
				break;
			case 2:
				conta1.deposita();
				break;
			case 3:
				conta1.saldo();
				break;
			case 4:
				conta1.fecharConta();
				break;
			case 5:
				System.out.println("Programa finalizado! ");
				continuar = false;
				break;
			default:
				System.out.println("Opção inválida, tente novamente. ");
				break;
			}
		}
		sc.close();
	}
}
