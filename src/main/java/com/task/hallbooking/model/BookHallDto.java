package com.task.hallbooking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookHallDto {

  HallType hallName;

  @JsonFormat(pattern = "yyyy-MM-dd")
  LocalDate date;

  @JsonFormat(pattern = "HH:mm")
  LocalTime startTime;

  @JsonFormat(pattern = "HH:mm")
  LocalTime endTime;

  public HallType getHallName() {
    return hallName;
  }

  public LocalDate getDate() {
    return date;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public LocalTime getEndTime() {
    return endTime;
  }

  public void setHallName(HallType hallName) {
    this.hallName = hallName;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public void setEndTime(LocalTime endTime) {
    this.endTime = endTime;
  }
}
