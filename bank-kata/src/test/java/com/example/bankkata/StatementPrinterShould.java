package com.example.bankkata;

import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StatementPrinterShould {

  public static final String HEADER = "DATE | AMOUNT | BALANCE";

  public static final List<Transaction> NO_TRANSACTIONS = Collections.EMPTY_LIST;

  @Mock
  private Console console;

  private StatementPrinter statementPrinter;

  @BeforeEach
  void setUp() {
    statementPrinter = new StatementPrinter(console);
  }

  @Test
  void always_print_the_header() {

    statementPrinter.print(NO_TRANSACTIONS);

    verify(console).printLine(HEADER);
  }

  @Test
  void print_transacations_in_reverse_chronological_order() {

    List<Transaction> transactions = transactionsContaining(
        deposit("01/04/2014", 1000),
        withdrawal("02/04/2014", 100),
        deposit("10/04/2014", 500)
    );
    statementPrinter.print(transactions);

    InOrder inOrder = Mockito.inOrder(console);
    inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
    inOrder.verify(console).printLine(" 10/04/2014 | 500    | 1400");
    inOrder.verify(console).printLine(" 02/04/2014 | -100   | 900");
    inOrder.verify(console).printLine(" 01/04/2014 | 1000   | 1000");
  }

  private List<Transaction> transactionsContaining(Transaction... transactions) {
    return List.of(transactions);
  }

  private Transaction withdrawal(String date, int amount) {
    return new Transaction(date, -amount);
  }

  private Transaction deposit(String date, int amount) {
    return new Transaction(date, amount);
  }
}