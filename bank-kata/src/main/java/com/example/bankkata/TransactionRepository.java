package com.example.bankkata;

import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

  private Clock clock;
  private List<Transaction> transactions = new ArrayList<>();

  public TransactionRepository(Clock clock) {

    this.clock = clock;
  }

  public void addDeposit(int amount) {
    final Transaction deposit = new Transaction(clock.todayAsString(), amount);
    transactions.add(deposit);
  }

  public void addWithdrawl(int amount) {
    final Transaction withdrawl = new Transaction(clock.todayAsString(), -amount);
    transactions.add(withdrawl);
  }

  public List<Transaction> allTransactions() {
    return unmodifiableList(transactions);
  }

}
