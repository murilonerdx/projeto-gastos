package com.murilo.gerirgastos.services;

import com.murilo.gerirgastos.entities.Financa;
import com.murilo.gerirgastos.entities.Gasto;
import com.murilo.gerirgastos.repositories.FinancaRepository;
import com.murilo.gerirgastos.repositories.GastoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GastoService {


    @Autowired
    private GastoRepository repository;

    @Autowired
    private FinancaRepository financaRepository;

    public Gasto save(Gasto obj) {
        try {
            Gasto newGasto = findByWeek(obj);
            return repository.save(newGasto);
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

    }

    public List<Gasto> getAll() {
        return repository.findAll();
    }


    public Gasto findByWeek(Gasto obj) {
        List<Gasto> gastos = getAll();
        Double somaTotal = obj.getValorGasto();
        List<Double> listaValores = repository.findAll().stream().filter(x -> x.getDataGasto().get(Calendar.MONTH) + 1 == Calendar.getInstance().get(Calendar.MONTH) + 1).map(Gasto::getValorGasto).collect(Collectors.toList());
        for (Double valorGasto : listaValores) {
            somaTotal = somaTotal + valorGasto;
        }

        Financa fin = new Financa();
        if (gastos.isEmpty()) {
            fin.setGastoTotal(somaTotal);
            fin.setMonth(obj.getDataGasto().get(Calendar.MONTH) + 1);
            obj.setFinanca(fin);
            obj.getFinanca().setGastoTotal(somaTotal);
            obj.getFinanca().setMonth(obj.getDataGasto().get(Calendar.MONTH) + 1);
            return obj;
        }


        obj = verificaMes(obj, fin, somaTotal);
        obj.getFinanca().setMonth(obj.getDataGasto().get(Calendar.MONTH) + 1);
        return obj;

    }

    public Gasto verificaMes(Gasto obj, Financa fin, Double somaTotal) {
        int mes = 0;
        List<Gasto> gastos = getAll();

        for (Gasto gasto : gastos) {
            mes = gasto.getFinanca().getMonth();
        }

        System.out.println(obj.getDataGasto().get(Calendar.MONTH) + 1 == Calendar.getInstance().get(Calendar.MONTH) + 1);
        System.out.println(mes);

        if (obj.getDataGasto().get(Calendar.MONTH) + 1 == Calendar.getInstance().get(Calendar.MONTH) + 1) {
            fin.setGastoTotal(somaTotal);
            obj.setFinanca(fin);
            return obj;
        } else if (obj.getDataGasto().get(Calendar.MONTH) + 1 > Calendar.getInstance().get(Calendar.MONTH) + 1) {
            fin.setGastoTotal(0.00);
            obj.setFinanca(fin);
            return obj;
        }
        return obj;
    }

}
