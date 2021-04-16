package com.task.hallbooking.repository;

import com.task.hallbooking.model.BookingEntity;
import com.task.hallbooking.model.HallType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<BookingEntity, Long> {

  List<BookingEntity> findAllByHall(final HallType hallType);
}
