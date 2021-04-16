package com.task.hallbooking.service;

import com.task.hallbooking.model.BookHallDto;
import com.task.hallbooking.model.BookingEntity;
import com.task.hallbooking.model.HallRequestDto;
import com.task.hallbooking.model.HallType;
import com.task.hallbooking.model.StartAndEndDto;
import com.task.hallbooking.repository.BookingRepo;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

  private final BookingRepo bookingRepo;

  public BookingService(final BookingRepo bookingRepo) {
    this.bookingRepo = bookingRepo;
  }

  public List<BookingEntity> getFromDates(final StartAndEndDto startAndEndDto) {
    return bookingRepo.findAll().stream()
        .filter(
            bookingEntity ->
                bookingEntity
                        .getStartDateAndTime()
                        .isAfter(startAndEndDto.getStartDate().atStartOfDay())
                    && bookingEntity
                        .getStartDateAndTime()
                        .isBefore(startAndEndDto.getEndDate().atTime(23, 59, 59)))
        .collect(Collectors.toList());
  }

  public Object bookHall(final BookHallDto bookHallDto) {
    if (bookHallDto.getEndTime().isBefore(bookHallDto.getStartTime())) {
      return "End time should be after start time";
    }
    if (!isHallAvailable(
        bookHallDto.getHallName(),
        LocalDateTime.of(bookHallDto.getDate(), bookHallDto.getStartTime()),
        LocalDateTime.of(bookHallDto.getDate(), bookHallDto.getEndTime()))) {
      return "Sorry, The hall was booked already :(";
    }
    final BookingEntity bookingEntity = new BookingEntity();
    bookingEntity.setHall(bookHallDto.getHallName());
    bookingEntity.setStartDateAndTime(
        LocalDateTime.of(bookHallDto.getDate(), bookHallDto.getStartTime()));
    bookingEntity.setEndDateAndTime(
        LocalDateTime.of(bookHallDto.getDate(), bookHallDto.getEndTime()));
    return bookingRepo.save(bookingEntity);
  }

  public Object requestHall(final HallRequestDto hallRequestDto) {
    if (hallRequestDto.getEndDateAndTime().isBefore(hallRequestDto.getStartDateAndTime())) {
      return "End time should be after start time";
    }
    Optional<HallType> availableHall =
        Arrays.stream(HallType.values())
            .filter(hallType -> hallType.getCapacity() >= hallRequestDto.getCapacity())
            .sorted(Comparator.comparing(Object::toString))
            .filter(
                hallType ->
                    isHallAvailable(
                        hallType,
                        hallRequestDto.getStartDateAndTime(),
                        hallRequestDto.getEndDateAndTime()))
            .findFirst();
    if (availableHall.isPresent()) {
      final BookHallDto bookHallDto = new BookHallDto();
      bookHallDto.setHallName(availableHall.get());
      bookHallDto.setDate(hallRequestDto.getStartDateAndTime().toLocalDate());
      bookHallDto.setStartTime(hallRequestDto.getStartDateAndTime().toLocalTime());
      bookHallDto.setEndTime(hallRequestDto.getEndDateAndTime().toLocalTime());
      return bookHallDto;
    } else {
      return "Sorry, No hall is available :(";
    }
  }

  private boolean isHallAvailable(
      final HallType hallType,
      final LocalDateTime startDateAndTime,
      final LocalDateTime endDateAndTime) {
    return bookingRepo.findAllByHall(hallType).stream()
        .noneMatch(
            bookingEntity ->
                (bookingEntity.getStartDateAndTime().isAfter(startDateAndTime)
                        && bookingEntity.getStartDateAndTime().isBefore(endDateAndTime))
                    || (bookingEntity.getEndDateAndTime().isAfter(startDateAndTime)
                        && bookingEntity.getEndDateAndTime().isBefore(endDateAndTime))
                    || (startDateAndTime.isAfter(bookingEntity.getStartDateAndTime())
                        && startDateAndTime.isBefore(bookingEntity.getEndDateAndTime()))
                    || (endDateAndTime.isAfter(bookingEntity.getStartDateAndTime())
                        && endDateAndTime.isBefore(bookingEntity.getEndDateAndTime()))
                    || startDateAndTime.isEqual(bookingEntity.getStartDateAndTime()));
  }
}
