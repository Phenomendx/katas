package com.example.roverkata;

import static com.example.roverkata.CompasDirection.NORTH;
import static com.example.roverkata.TestUtility.givenInitialRoverLocation;
import static com.example.roverkata.TestUtility.givenRoverHasObstacles;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RoverFeature {

  private Rover rover;

  @Test
  void no_obstacles() {
    rover = givenInitialRoverLocation(new Position(0, 0), NORTH);

    String actualLocation = rover.execute("MMRMMLM");

    assertEquals("2:3:N", actualLocation);
  }

  @Test
  void wrap_around() {
    rover = givenInitialRoverLocation(new Position(0, 0), NORTH);

    String actualLocation = rover.execute("MMMMMMMMMM");

    assertEquals("0:0:N", actualLocation);
  }

  @Test
  void with_obstacles() {
    Rover rover = givenRoverHasObstacles(List.of("0:3:N"));

    String actualLocation = rover.execute("MMMM");

    assertEquals("0:0:2:N", actualLocation);
  }

}
