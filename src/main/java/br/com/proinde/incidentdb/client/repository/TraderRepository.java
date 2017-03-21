package br.com.proinde.incidentdb.client.repository;

import br.com.proinde.incidentdb.client.domain.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Long> {
}
