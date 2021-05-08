package com.murilo.gerirgastos.resources;

import com.murilo.gerirgastos.entities.Financa;
import com.murilo.gerirgastos.entities.Gasto;
import com.murilo.gerirgastos.services.GastoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/api/gastos")
public class GastoResources {

    @Autowired
    private GastoService service;

    @PostMapping
    public ResponseEntity<Gasto> save(@RequestBody Gasto obj) throws ParseException {
        Gasto gasto = service.save(obj);
        return ResponseEntity.ok().body(gasto);
    }

    @GetMapping
    public ResponseEntity<List<Gasto>> findAll(){
        List<Gasto> gasto = service.getAll();
        return ResponseEntity.ok().body(gasto);
    }
}
