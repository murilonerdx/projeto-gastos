package com.murilo.gerirgastos.services;

import com.murilo.gerirgastos.entities.Financa;
import com.murilo.gerirgastos.entities.Gasto;
import com.murilo.gerirgastos.repositories.FinancaRepository;
import com.murilo.gerirgastos.repositories.GastoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FinancaService {


    @Autowired
    private FinancaRepository repository;

    @Autowired
    private FinancaRepository financaRepository;

    public Financa save(Financa obj) {
        return repository.save(obj);
    }

    public List<Financa> getAll() {
        return repository.findAll();
    }

    public Financa findById(Long id) {
        Optional<Financa> obj = repository.findById(id);
        return obj.orElseThrow(RuntimeException::new);
    }


}
