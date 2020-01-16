package com.example.roverkata;

import static com.example.roverkata.CompasDirection.NORTH;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoverFeature {

  private Rover rover;

  @BeforeEach
  void setUp() {
    rover = givenInitialRoverLocation(new Position(0, 0), NORTH);
  }

  @Test
  void no_obstacles() {

    String actualLocation = rover.execute("MMRMMLM");

    assertEquals("2:3:N", actualLocation);
  }

  @Test
  void wrap_around() {

    String actualLocation = rover.execute("MMMMMMMMMM");

    assertEquals("0:0:N", actualLocation);
  }

  @Test
  void with_obstacles() {

    String actualLocation = rover.execute("MMMM");

    assertEquals("0:0:2:N", actualLocation);
  }

  private Rover givenInitialRoverLocation(Position position, CompasDirection setDirection) {
    return new Rover(Collections.emptyList(), new RoverLocation(new Position(0, 0), setDirection));
  }

}
