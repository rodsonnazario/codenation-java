package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//TODO
public interface ChallengeRepository extends CrudRepository<Challenge, Long> {
    List<Challenge> findByAccelerationsId(Long accelerationId);
//    List<Challenge> findByAccelerationsId(Long accelerationId);
}
