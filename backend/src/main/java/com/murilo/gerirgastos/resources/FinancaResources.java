package com.murilo.gerirgastos.resources;

import com.murilo.gerirgastos.entities.Financa;
import com.murilo.gerirgastos.entities.Gasto;
import com.murilo.gerirgastos.services.FinancaService;
import com.murilo.gerirgastos.services.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value="/api/financa")
public class FinancaResources {
    @Autowired
    private FinancaService service;


    @GetMapping
    public ResponseEntity<List<Financa>> findAll(){
        List<Financa> financa = service.getAll();
        return ResponseEntity.ok().body(financa);
    }

    @PostMapping
    public ResponseEntity<Financa> save(@RequestBody Financa obj) throws ParseException {
        Financa financa = service.save(obj);
        return ResponseEntity.ok().body(financa);
    }

}
