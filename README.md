# 💳 Conta Corrente – Java OOP Challenge

### 📌 Sobre o desafio  
[EN] This project is part of the CI&T Java & AWS Bootcamp. The objective is to implement a **checking account (ContaCorrente)** using object-oriented programming, practicing **abstraction, encapsulation, and business rules**.

[PT] Este projeto faz parte do Bootcamp de Java & AWS da CI&T. O objetivo é implementar uma **conta corrente (ContaCorrente)** utilizando programação orientada a objetos, praticando **abstração, encapsulamento e regras de negócio**.

---

## 🚀 Funcionalidades implementadas

A classe `ContaCorrente` deve simular:

- ✔️ Saldo da conta  
- ✔️ Cheque especial com valor variável  
- ✔️ Limite total (saldo + cheque especial)  
- ✔️ Depósito  
- ✔️ Saque com uso de cheque especial  
- ✔️ Pagamento de boletos  
- ✔️ Identificação do uso do cheque especial  
- ✔️ Cobrança de taxa ao ultrapassar limite  

---

## 🧠 Regras de Negócio

### 💰 Inicialização
- Se o saldo inicial for **≤ 500**, o cheque especial padrão é **R$50,00**.
- Caso contrário, o cheque especial vale **metade do saldo inicial**.
- O limite total é `saldo + chequeEspecial`.

---

### 🏦 Depósito
- Aumenta o saldo.  
- Aumenta também o limite disponível.

---

### 🏧 Saque
- O saque deve ser permitido se o valor **≤ limite total**.
- Se o saldo não for suficiente, utiliza o cheque especial.
- Caso o limite seja totalmente consumido, cobra **taxa de 20%** sobre o cheque especial.

---

### 🧾 Pagamento de boleto
- Debita o saldo ou o cheque especial conforme necessário.
- Caso utilize todo o limite, aplica taxa de 20%.
- Retorna uma mensagem indicando o status do pagamento.

---

## 📄 Exemplo de uso

```java
ContaCorrente conta = new ContaCorrente(300);

conta.depositar(200);
conta.sacar(100);
String msg = conta.pagarBoleto(250);

System.out.println(msg);
System.out.println("Saldo: " + conta.getSaldo());
System.out.println("Limite: " + conta.getLimite());
```

# 💳 Checking Account – Java OOP Challenge

### 📌 About the challenge  
This project is part of the **CI&T Java & AWS Bootcamp**.  
The objective is to implement a **checking account (`ContaCorrente`)** using Object-Oriented Programming, focusing on **abstraction, encapsulation, and business rules**.

---

## 🚀 Implemented Features

The `ContaCorrente` class simulates:

- ✔️ Account balance  
- ✔️ Overdraft (cheque especial) with variable value  
- ✔️ Total available limit (balance + overdraft)  
- ✔️ Deposit operations  
- ✔️ Withdraw operations using or not using overdraft  
- ✔️ Bill payment with overdraft support  
- ✔️ Detection of overdraft usage  
- ✔️ Fee applied when the full overdraft is consumed  

---

## 🧠 Business Rules

### 💰 Initialization
- If the initial balance is **≤ 500**, the overdraft limit is **R$50.00**.
- Otherwise, the overdraft is **half of the initial balance**.
- The total limit is calculated as:  
---

### 🏦 Deposit
- Increases account balance.  
- Automatically increases the total available limit.

---

### 🏧 Withdraw
- Withdrawals are allowed only if the requested amount **≤ total limit**.
- If the balance is insufficient, overdraft is used.
- If the entire limit is consumed, a **20% fee** is charged over the overdraft amount.

---

### 🧾 Bill Payment
- Works similarly to withdrawals.  
- Deducts from balance first, then overdraft.  
- Applies the 20% overdraft fee if the total limit reaches zero.  
- Returns a message indicating the payment status.

---

## 📄 Usage Example

```java
ContaCorrente account = new ContaCorrente(300);

account.depositar(200);
account.sacar(100);
String message = account.pagarBoleto(250);

System.out.println(message);
System.out.println("Balance: " + account.getSaldo());
System.out.println("Limit: " + account.getLimite());
```
