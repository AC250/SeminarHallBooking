package com.task.hallbooking.model;

public enum HallType {
  A("A", 50),
  B("B", 100),
  C("C", 200),
  D("D", 350),
  E("E", 500),
  F("F", 1000);

  private final String name;
  private final int capacity;

  HallType(final String name, final int capacity) {
    this.name = name;
    this.capacity = capacity;
  }

  public String getName() {
    return name;
  }

  public int getCapacity() {
    return capacity;
  }

}
