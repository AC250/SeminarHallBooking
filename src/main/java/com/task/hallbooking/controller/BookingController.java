package com.task.hallbooking.controller;

import com.task.hallbooking.model.BookHallDto;
import com.task.hallbooking.model.BookingEntity;
import com.task.hallbooking.model.HallRequestDto;
import com.task.hallbooking.model.StartAndEndDto;
import com.task.hallbooking.service.BookingService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

  private final BookingService bookingService;

  public BookingController(final BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @GetMapping("/getBetweenDates")
  public ResponseEntity<List<BookingEntity>> getBetweenDates(
      @RequestBody final StartAndEndDto startAndEndDto) {
    return new ResponseEntity<>(bookingService.getFromDates(startAndEndDto), HttpStatus.OK);
  }

  @PostMapping("/bookHall")
  public ResponseEntity<Object> bookHall(@RequestBody final BookHallDto bookHallDto) {
    return new ResponseEntity<>(bookingService.bookHall(bookHallDto), HttpStatus.CREATED);
  }

  @PostMapping("/requestHall")
  public ResponseEntity<Object> requestHallDetails(
      @RequestBody final HallRequestDto hallRequestDto) {
    return new ResponseEntity<>(bookingService.requestHall(hallRequestDto), HttpStatus.OK);
  }
}
