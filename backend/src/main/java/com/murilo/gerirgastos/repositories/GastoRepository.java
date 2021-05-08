package com.murilo.gerirgastos.repositories;

import com.murilo.gerirgastos.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GastoRepository extends JpaRepository<Gasto, Long> {
}
