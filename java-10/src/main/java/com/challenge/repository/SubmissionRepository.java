package com.challenge.repository;

import com.challenge.entity.Submission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
@Component
public interface SubmissionRepository extends CrudRepository<Submission, Long> {

    @Query(value = "select coalesce(max(s.score),0) from challenge ch\n" +
            "join submission s on ch.id = s.challenge_id\n" +
            "where ch.id = :challengeId", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(" select s from Submission s " +
            " join s.id.challenge cha " +
            " join cha.accelerations acc " +
            " where acc.id = :accelerationId and cha.id = :challengeId ")
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId, @Param("accelerationId") Long accelerationId);
}
