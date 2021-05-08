package com.murilo.gerirgastos.repositories;

import com.murilo.gerirgastos.entities.Financa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancaRepository extends JpaRepository<Financa, Long> {
}
