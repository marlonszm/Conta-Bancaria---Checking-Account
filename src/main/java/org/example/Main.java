package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcaoCriar;
        int opcaoMenu;
        System.out.println("SEJA BEM-VINDO(A)");
        System.out.println("O que deseja fazer?");
        System.out.println("1- Criar um Conta");
        System.out.println("2- Encerrar execução");
        opcaoCriar = sc.nextInt();
        while(opcaoCriar != 1 && opcaoCriar != 2){
            System.out.println("Escolha um número válido!\n (1) Criar uma conta \n (2) Encerrar execução");
            opcaoCriar = sc.nextInt();
        }
        if (opcaoCriar == 1){
            int saldoConta;
            System.out.print("Saldo da conta: ");
            saldoConta = sc.nextInt();
            ContaCorrente contaMarlon = new ContaCorrente(saldoConta);
            System.out.println("MENU");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Consultar cheque especial");
            System.out.println("3 - Depositar dinheiro");
            System.out.println("4 - Sacar dinheiro");
            System.out.println("5 - Verificar se você está usando o cheque especial");
            System.out.println("6 - Encerrar programa");
            opcaoMenu = sc.nextInt();
            while(opcaoMenu != 1 && opcaoMenu != 2 && opcaoMenu != 3 && opcaoMenu != 4 && opcaoMenu != 5 && opcaoMenu != 6){
                System.out.println("Escolha uma opção válida");
                opcaoMenu = sc.nextInt();
            }
            while(opcaoMenu != 6){
                if(opcaoMenu == 1){
                    System.out.println("Saldo: " + contaMarlon.getSaldo());
                }
                if(opcaoMenu == 2){
                    System.out.println("Cheque especial: " + contaMarlon.getChequeEspecialDisponivel());
                }
                if(opcaoMenu == 3){
                    double valor;
                    System.out.print("Informe o valor: ");
                    valor = sc.nextDouble();
                    System.out.println("Valor depositado. \n R$ " + valor);
                }
                if(opcaoMenu == 4){
                    double valor;
                    System.out.print("Informe o valor: ");
                    valor = sc.nextDouble();
                    contaMarlon.sacar(valor);

                }
                if(opcaoMenu == 5){
                    if (contaMarlon.getChequeUtilizado() == true){
                        System.out.println("Cheque está sendo utilizado");
                    }
                    else{
                        System.out.println("Cheque não utilizado");
                    }
                }

                System.out.println("1 - Consultar saldo");
                System.out.println("2 - Consultar cheque especial");
                System.out.println("3 - Depositar dinheiro");
                System.out.println("4 - Sacar dinheiro");
                System.out.println("5 - Verificar se você está usando o cheque especial");
                System.out.println("6 - Encerrar programa");
                opcaoMenu = sc.nextInt();
            }

        }
        else{
            System.out.println("Programa encerrado");
        }
    }
}