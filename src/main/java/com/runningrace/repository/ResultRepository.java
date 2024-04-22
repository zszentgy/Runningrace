package com.runningrace.repository;

import com.runningrace.model.Result;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByRaceIdOrderByTimeResultAsc(Long raceId);
}
