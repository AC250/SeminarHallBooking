package com.task.hallbooking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class StartAndEndDto {

  @JsonFormat(pattern = "yyyy-MM-dd")
  LocalDate startDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  LocalDate endDate;

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }
}
