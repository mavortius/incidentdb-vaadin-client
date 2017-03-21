package br.com.proinde.incidentdb.client.repository;


import br.com.proinde.incidentdb.client.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

}
