package fi.jyffe.opentiku.targetservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface TargetRepository extends JpaRepository<Target, Long> {
	Collection<Target> findByUuid(String uuid);
}