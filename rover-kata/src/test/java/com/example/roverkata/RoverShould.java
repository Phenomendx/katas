package com.example.roverkata;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
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

    givenInitialRoverLocation(new Position(0, 0), CompasDirection.EAST);

    String actualLocation = rover.execute(command);

    assertEquals(expectedLocation, actualLocation);
  }

  @ParameterizedTest
  @CsvSource({
      "M,N,0:1:N",
      "MM,N,0:2:N",
      "M,E,1:0:E",
      "MM,E,2:0:E",
      "M,S,0:-1:S",
      "MM,S,0:-2:S",
      "M,W,-1:0:W",
      "MM,W,-2:0:W",
  })
  void move_rover(String command, String initialDirection, String expectedLocation) {

    givenInitialRoverLocation(new Position(0, 0), setDirection(initialDirection));

    final String actualLocation = rover.execute(command);

    assertEquals(expectedLocation, actualLocation);
  }


  @ParameterizedTest
  @CsvSource({
      "MR,N,0:1:E",
      "RM,N,1:0:E",
  })
  void move_and_rotate(String command, String initialDirection, String expectedLocation) {

    givenInitialRoverLocation(new Position(0, 0), setDirection(initialDirection));

    final String actualLocation = rover.execute(command);

    assertEquals(expectedLocation, actualLocation);

  }

  private CompasDirection setDirection(String initialDirection) {
    Map<String, CompasDirection> directions = Map.of(
        "N", CompasDirection.NORTH,
        "E", CompasDirection.EAST,
        "S", CompasDirection.SOUTH,
        "W", CompasDirection.WEST
    );
    return directions.get(initialDirection);
  }

  private void givenInitialRoverLocation(Position position, CompasDirection direction) {
    rover.setLocation(new RoverLocation(position, direction));
  }
}
