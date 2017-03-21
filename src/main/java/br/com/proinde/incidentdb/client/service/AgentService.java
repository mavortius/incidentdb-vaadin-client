package br.com.proinde.incidentdb.client.service;

import br.com.proinde.incidentdb.client.domain.Agent;
import br.com.proinde.incidentdb.client.repository.AgentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AgentService extends AbstractService<Agent, Long> {

    private final AgentRepository repository;

    public AgentService(AgentRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Agent, Long> getRepository() {
        return repository;
    }
}
