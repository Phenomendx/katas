package com.example.roverkata;

import java.util.Map;
import java.util.function.Supplier;

public class RoverCommandFactory {

  private static Map<String, Supplier<RoverCommand>> commandFactory = Map.of(
      "R", RightCommand::new,
      "L", LeftCommand::new,
      "M", RightCommand::new
  );


  public static RoverCommand createRoverCommand(String command) {
    return commandFactory.get(command).get();
  }
}
