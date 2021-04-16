package com.task.hallbooking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_entities")
public class BookingEntity {

  @Id
  @Column(name = "booking_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long bookingId;

  @Column(name = "hall")
  private HallType hall;

  @Column(name = "start_date_and_time")
  @JsonFormat(pattern = "yyyy-MM-dd, HH:mm")
  private LocalDateTime startDateAndTime;

  @Column(name = "end_date_and_time")
  @JsonFormat(pattern = "yyyy-MM-dd, HH:mm")
  private LocalDateTime endDateAndTime;

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(long bookingId) {
    this.bookingId = bookingId;
  }

  public HallType getHall() {
    return hall;
  }

  public void setHall(HallType hall) {
    this.hall = hall;
  }

  public LocalDateTime getStartDateAndTime() {
    return startDateAndTime;
  }

  public void setStartDateAndTime(LocalDateTime startDateAndTime) {
    this.startDateAndTime = startDateAndTime;
  }

  public LocalDateTime getEndDateAndTime() {
    return endDateAndTime;
  }

  public void setEndDateAndTime(LocalDateTime endDateAndTime) {
    this.endDateAndTime = endDateAndTime;
  }
}
