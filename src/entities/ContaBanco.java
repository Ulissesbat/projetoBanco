package entities;

import java.util.Scanner;

public class ContaBanco {
	Scanner sc = new Scanner(System.in);

	private int numConta;
	protected String tipo;
	public String titular;
	public float saldo;
	public boolean status;
	private int senha;

	

	public ContaBanco() {
		saldo = 0;
		status = false;
	}
	
	public void saldo() {
		System.out.println("Saldo atual: R$ " + saldo);
	}

	public void abrirConta() {
		this.setStatus(true);

		if (tipo.equals("cc")) {
		    saldo = 50f;
		} else if (tipo.equals("cp")) {
		    saldo = 150f;
		} else {
		    System.out.println("Tipo de conta inválido.");
		    setStatus(false);
		}
		
	}


	public void fecharConta() {
		if (saldo > 0 ) {
			System.out.println("Voce precisa efetuar o saque do saldo atual no valor de R$ " + saldo);
		}
		else if (saldo < 0){
			System.out.println("Seu saldo é negativo // valor pendente " + saldo);

		}
		else {
			System.out.println("Conta fechada com sucesso!");
			this.setStatus(false);
		}
	}

	public void deposita() {
		System.out.println("Quanto deseja depositar?");
		float valorDeposito = sc.nextFloat();
		while (valorDeposito < 0) {
			System.out.println("Valor inválido. Tente novamente.");
			valorDeposito = sc.nextFloat();
		}
		setSaldo(valorDeposito);
		System.out.println("Depósito realizado com sucesso!");
		System.out.println("Saldo atual: R$ " + getSaldo());
	}
		boolean status1 = true;

	public void sacar() {
		System.out.println("Quanto deseja sacar?");
		float valorSaque = sc.nextFloat();		
		if (valorSaque > saldo) {
			System.out.println("Saldo insuficiente. Deseja continuar? Digite 's' para sim e 'n' para não.");
			char resposta = sc.next().charAt(0);
			if (resposta == 's') {
				saldo -= valorSaque;
				System.out.println("Saque realizado com sucesso!");
				System.out.println("Saldo atual: R$ " + saldo);

			} else {
				System.out.println("Operação cancelada.");
				sc.close();
			}
		} else {
			saldo -= valorSaque;
			System.out.println("Saque realizado com sucesso!");
			System.out.println("Saldo atual: R$ " + saldo);
		}
	}

	public void pagarMensal() {
		if (tipo.equals("cc")) {
			saldo -= 12.0;
		} else {
			saldo -= 20.0;
		}
	}
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public void senha() {
		if (senha != numConta) {
			System.out.print("Senha incorreta, tente novamente! ");
			sc.nextInt();
		}
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int conta) {
		this.numConta = conta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String dono) {
		this.titular = dono;
	}

	public float getSaldo() {
		return saldo;
	}

	public float setSaldo(float saldo) {
		return this.saldo += saldo;

	}
	

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String toString() {
		return "ContaBanco: [numConta=" + numConta + ", tipo=" + tipo + ", titular=" + titular

				+ ", saldo=" + String.format("%.2f", saldo) + ", status=" + status + "]\n";
	}

}
