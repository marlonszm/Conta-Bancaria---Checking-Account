package org.example;

public class ContaCorrente {

    private double saldo;
    private final double chequeEspecialInicial;
    private double chequeEspecialDisponivel;
    private double chequeUsado;
    private boolean chequeUtilizado;

    public ContaCorrente(double saldoInicial){
        this.saldo = saldoInicial;
        if(this.saldo <= 500){
            this.chequeEspecialInicial = 50.00;
        } else {
            this.chequeEspecialInicial = this.saldo / 2.0;
        }
        this.chequeEspecialDisponivel = this.chequeEspecialInicial;
        this.chequeUsado = 0.0;
        this.chequeUtilizado = false;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public double getChequeEspecialDisponivel(){
        return this.chequeEspecialDisponivel;
    }

    public boolean getChequeUtilizado(){
        return this.chequeUtilizado;
    }

    public double getLimite(){
        return this.saldo + this.chequeEspecialDisponivel;
    }

    public void depositar(double valor){
        if (valor <= 0) return;

        if (this.chequeUsado > 0) {
            double paraQuitar = Math.min(valor, this.chequeUsado);
            this.chequeUsado -= paraQuitar;
            this.chequeEspecialDisponivel += paraQuitar;
            valor -= paraQuitar;

            if (this.chequeUsado == 0) {
                double totalUsado = this.chequeEspecialInicial - this.chequeEspecialDisponivel;
                if (totalUsado > 0) {
                    double taxa = totalUsado * 0.20;
                    if (valor + this.saldo >= taxa) {
                        if (valor >= taxa) {
                            valor -= taxa;
                        } else {
                            double restanteTaxa = taxa - valor;
                            valor = 0;
                            this.saldo -= restanteTaxa;
                        }
                    } else {
                        double totalDisponivelParaTaxa = valor + this.saldo;
                        valor = 0;
                        this.saldo = totalDisponivelParaTaxa - taxa;
                    }
                }
            }
        }

        if (valor > 0) {
            this.saldo += valor;
        }

        this.chequeUtilizado = this.chequeUsado > 0;

        if (this.chequeEspecialDisponivel > this.chequeEspecialInicial) {
            this.chequeEspecialDisponivel = this.chequeEspecialInicial;
        }
    }

    public void sacar(double valor){
        if (valor <= 0) {
            System.out.println("Valor inválido.");
            return;
        }

        double limiteAtual = getLimite();
        if (valor > limiteAtual) {
            System.out.println("Valor excedeu o limite disponível");
            return;
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
        } else {
            double restante = valor - this.saldo;
            this.saldo = 0;
            double usadoAntes = this.chequeUsado;
            this.chequeUsado += restante;
            this.chequeEspecialDisponivel -= restante;
            if (this.chequeEspecialDisponivel < 0) {
                this.chequeEspecialDisponivel = 0;
            }
            this.chequeUtilizado = this.chequeUsado > 0;
        }
    }

    public String pagarBoleto(double valor){
        if (valor <= 0) {
            return "Valor inválido";
        }

        double limiteAtual = getLimite();
        if (valor > limiteAtual) {
            return "Valor excedeu o limite disponível";
        }

        if (this.saldo >= valor) {
            this.saldo -= valor;
            return String.format("Boleto no valor de R$%.2f pago\n", valor);
        } else {
            double restante = valor - this.saldo;
            this.saldo = 0;
            this.chequeUsado += restante;
            this.chequeEspecialDisponivel -= restante;
            if (this.chequeEspecialDisponivel < 0) this.chequeEspecialDisponivel = 0;
            this.chequeUtilizado = true;
            return String.format("Boleto no valor de R$%.2f pago usando cheque especial\n", valor);
        }
    }
}
