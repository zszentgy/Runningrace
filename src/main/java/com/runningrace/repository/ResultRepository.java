package com.runningrace.repository;

import com.runningrace.model.Result;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    
    List<Result> findByRaceIdOrderByTimeResultAsc(Long raceId);

    // Method to find a result by runnerId and raceId
    Optional<Result> findByRunnerIdAndRaceId(Long runnerId, Long raceId);

}
