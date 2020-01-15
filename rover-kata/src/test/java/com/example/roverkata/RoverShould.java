package com.example.roverkata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverShould {

  private Rover rover;

  @BeforeEach
  void setUp() {
    rover = new Rover();
  }

  @ParameterizedTest
  @CsvSource({
      "R,0:0:S",
      "RR,0:0:W",
      "RRR,0:0:N",
      "RRRR,0:0:E",
      "RRRRR,0:0:S",
      "RRRRRR,0:0:W",
      "L,0:0:N",
      "LL,0:0:W",
      "LLL,0:0:S",
      "LLLL,0:0:E",
      "LLLLL,0:0:N",
  })
  void rotate_rover(String command, String expectedLocation) {

    givenTheInitialOrientation(CompasDirection.EAST);

    String actualLocation = rover.execute(command);

    assertEquals(expectedLocation, actualLocation);
  }

  @Test
  void move_rover() {

    String expectedPosition = "1:0:N";

    final String actualPosition = rover.execute("M");

    assertEquals(expectedPosition, actualPosition);
  }

  private void givenTheInitialOrientation(CompasDirection roverInitialOrientation) {
    if (roverInitialOrientation.equals(CompasDirection.EAST)) {
      rover.execute("R");
    }
  }
}
