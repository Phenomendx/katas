package com.example.bankkata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class TransactionRepositoryShould {

  public static final String TODAY = "08/01/2019";

  @Mock
  private Clock clock;

  private TransactionRepository transactionRepository;

  @BeforeEach
  void setUp() {
    transactionRepository = new TransactionRepository(clock);
    given(clock.todayAsString()).willReturn(TODAY);
  }

  @Test
  void create_and_store_a_deposit_transaction() {

    transactionRepository.addDeposit(100);

    List<Transaction> transactions = transactionRepository.allTransactions();

    assertThat(transactions.size()).isEqualTo(1);
    assertThat(transactions.get(0)).isEqualTo(transaction(TODAY, 100));
  }

  @Test
  void create_and_store_a_withdraw_transaction() {

    transactionRepository.addWithdrawl(100);

    List<Transaction> transactions = transactionRepository.allTransactions();

    assertThat(transactions.size()).isEqualTo(1);
    assertThat(transactions.get(0)).isEqualTo(transaction(TODAY, -100));
  }

  private Transaction transaction(String date, int amount) {
    return new Transaction(date, amount);
  }

}