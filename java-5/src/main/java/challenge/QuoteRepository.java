package challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuoteRepository extends CrudRepository<Quote, Integer> {
    @Query(value = "SELECT * FROM scripts ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote findRandom();

    @Query(value = "SELECT * FROM scripts WHERE actor = :actor ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Quote findByActor(@Param("actor") String actor);
}
