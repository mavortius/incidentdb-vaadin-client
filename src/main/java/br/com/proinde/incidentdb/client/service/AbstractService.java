package br.com.proinde.incidentdb.client.service;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractService<T, ID extends Serializable> {

    protected abstract JpaRepository<T, ID> getRepository();

    public List<T> findAll(int offset, int limit, Map<String, Boolean> sortOrders) {
        int page = offset / limit;
        List<Sort.Order> orders = sortOrders.entrySet().stream()
                .map(e -> new Sort.Order(e.getValue() ? Sort.Direction.ASC : Sort.Direction.DESC, e.getKey()))
                .collect(Collectors.toList());
        PageRequest pageRequest = new PageRequest(page, limit, orders.isEmpty() ? null : new Sort(orders));

        return getRepository().findAll(pageRequest).getContent();
    }

    public Integer count() {
        return Math.toIntExact(getRepository().count());
    }
}
