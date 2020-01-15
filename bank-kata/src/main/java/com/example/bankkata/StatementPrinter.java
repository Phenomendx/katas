package com.example.bankkata;

import java.util.List;

public class StatementPrinter {

  public static final String HEADER = "DATE | AMOUNT | BALANCE";

  private Console console;

  public StatementPrinter(Console console) {
    this.console = console;
  }

  public void print(List<Transaction> transactions) {
    console.printLine(HEADER);
  }
}
