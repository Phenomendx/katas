package com.example.bankkata;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClockTest {

  private Clock clock;

  @BeforeEach
  void setUp() {
    clock = new TestableClock();
  }

  @Test
  void return_todays_date_in_dd_MM_yyyy_format() {
    String date  = clock.todayAsString();
    assertThat(date).isEqualTo("08/02/2020");
  }

  private class TestableClock extends Clock {

    @Override
    protected LocalDate today() {
      return LocalDate.of(2020,2,8);
    }
  }
}