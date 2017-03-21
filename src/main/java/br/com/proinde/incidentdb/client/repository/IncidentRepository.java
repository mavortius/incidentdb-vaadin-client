package br.com.proinde.incidentdb.client.repository;

import br.com.proinde.incidentdb.client.domain.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {
}
