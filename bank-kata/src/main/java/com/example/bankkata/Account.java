package com.example.bankkata;


public class Account {

  private TransactionRepository transactionRepository;
  private StatementPrinter statementPrinter;

  public Account(TransactionRepository transactionRepository,
      StatementPrinter statementPrinter) {
    this.transactionRepository = transactionRepository;
    this.statementPrinter = statementPrinter;
  }

  public void deposit(int amount) {
    transactionRepository.addDeposit(amount);
  }

  public void withdraw(int amount) {
    transactionRepository.addWithdrawl(amount);
  }

  public void printStatement() {
    statementPrinter.print(transactionRepository.allTransactions());
  }

}
