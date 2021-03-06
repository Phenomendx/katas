package com.example.bankkata.feature;

import com.example.bankkata.Account;
import com.example.bankkata.Clock;
import com.example.bankkata.Console;
import com.example.bankkata.StatementPrinter;
import com.example.bankkata.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrintStatementFeature {

  @Mock
  private Console console;

  @Mock
  private Clock clock;

  private Account account;

  @BeforeEach
  void setUp() {
    TransactionRepository transactionRepository = new TransactionRepository(clock);
    StatementPrinter statementPrinter = new StatementPrinter(console);
    account = new Account(transactionRepository, statementPrinter);
  }

  @DisplayName("Prints statements containing all transactions")
  @Test
  void prints_statements_containing_all_transactions() {

    account.deposit(1000);
    account.withdraw(100);
    account.deposit(500);

    account.printStatement();

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).printLine(" DATE       | AMOUNT | BALANCE");
    inOrder.verify(console).printLine(" 10/04/2014 | 500    | 1400");
    inOrder.verify(console).printLine(" 02/04/2014 | -100   | 900");
    inOrder.verify(console).printLine(" 01/04/2014 | 1000   | 1000");
  }
}
