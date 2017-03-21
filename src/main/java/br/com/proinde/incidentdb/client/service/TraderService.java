package br.com.proinde.incidentdb.client.service;

import br.com.proinde.incidentdb.client.domain.Trader;
import br.com.proinde.incidentdb.client.repository.TraderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TraderService extends AbstractService<Trader, Long> {

    private final TraderRepository repository;

    public TraderService(TraderRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Trader, Long> getRepository() {
        return repository;
    }
}
