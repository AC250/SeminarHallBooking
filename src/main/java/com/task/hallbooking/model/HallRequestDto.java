package com.task.hallbooking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class HallRequestDto {

  int capacity;

  @JsonFormat(pattern = "yyyy-MM-dd, HH:mm")
  LocalDateTime startDateAndTime;

  @JsonFormat(pattern = "yyyy-MM-dd, HH:mm")
  LocalDateTime endDateAndTime;

  public int getCapacity() {
    return capacity;
  }

  public LocalDateTime getStartDateAndTime() {
    return startDateAndTime;
  }

  public LocalDateTime getEndDateAndTime() {
    return endDateAndTime;
  }
}
