package com.example.roverkata;

import static com.example.roverkata.CompasDirection.EAST;
import static com.example.roverkata.CompasDirection.NORTH;
import static com.example.roverkata.CompasDirection.SOUTH;
import static com.example.roverkata.CompasDirection.WEST;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverShould {


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

    Rover rover = givenInitialRoverLocation(new Position(0, 0), EAST);

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

    Rover rover = givenInitialRoverLocation(new Position(0, 0), setDirection(initialDirection));

    final String actualLocation = rover.execute(command);

    assertEquals(expectedLocation, actualLocation);
  }

  @ParameterizedTest
  @CsvSource({
      "MR,N,0:1:E",
      "RM,N,1:0:E",
  })
  void move_and_rotate(String command, String initialDirection, String expectedLocation) {

    Rover rover = givenInitialRoverLocation(new Position(0, 0), setDirection(initialDirection));

    final String actualLocation = rover.execute(command);

    assertEquals(expectedLocation, actualLocation);

  }

  @Test
  void rover_stops_when_obstacles() {

    Rover rover = givenRoverHasAnObstacleAt(List.of("0:2:N"));

    String actualLocation = rover.execute("MM");

    assertEquals("0:0:1:N", actualLocation);
  }

  private CompasDirection setDirection(String initialDirection) {
    Map<String, CompasDirection> directions = Map.of(
        "N", NORTH,
        "E", EAST,
        "S", SOUTH,
        "W", WEST
    );
    return directions.get(initialDirection);
  }

  private Rover givenRoverHasAnObstacleAt(List<String> obstacles) {
    return new Rover(obstacles, new RoverLocation(new Position(0, 0), NORTH));
  }

  private Rover givenInitialRoverLocation(Position position, CompasDirection initialDirection) {
    return new Rover(Collections.emptyList(), new RoverLocation(new Position(0, 0), initialDirection));
  }


}
