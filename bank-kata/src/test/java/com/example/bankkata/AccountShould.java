package com.example.bankkata;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AccountShould {

  @Mock
  private TransactionRepository transactionRepository;

  @Mock
  private StatementPrinter statementPrinter;

  private Account account;

  @BeforeEach
  void setUp() {
    account = new Account(transactionRepository, statementPrinter);
  }

  @Test
  void
  store_a_deposit_transaction() {
    account.deposit(100);

    verify(transactionRepository).addDeposit(100);
  }

  @Test
  void
  store_a_withdrawal_transaction() {
    account.withdraw(100);

    verify(transactionRepository).addWithdrawl(100);
  }

  @Test
  void print_a_statment() {

    List<Transaction> transactions = List.of(new Transaction("08/01/2020", 100));
    given(transactionRepository.allTransactions()).willReturn(transactions);

    account.printStatement();

    verify(statementPrinter).print(transactions);

  }

}