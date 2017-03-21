package br.com.proinde.incidentdb.client.service;

import br.com.proinde.incidentdb.client.domain.Incident;
import br.com.proinde.incidentdb.client.repository.IncidentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class IncidentService extends AbstractService<Incident, Long> {

    private final IncidentRepository repository;

    public IncidentService(IncidentRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Incident, Long> getRepository() {
        return repository;
    }
}
