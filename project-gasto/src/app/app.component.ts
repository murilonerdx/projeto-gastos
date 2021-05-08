import { DatePipe, formatDate, registerLocaleData } from '@angular/common';
import { Component, OnInit, Pipe, PipeTransform } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Gasto } from './gasto';
import { GastoService } from './gasto.service';

import localeBr from '@angular/common/locales/pt';

registerLocaleData(localeBr, 'pt')




@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['../assets/bootstrap/css/bootstrap.min.css']
})
  

  
export class AppComponent implements OnInit{

  
  
  gasto = {} as Gasto;
  gastos: Gasto[];

  constructor(private gastoService: GastoService) { }


  ngOnInit(): void {
    this.getGastos();
  }
  getGastos() {
    this.gastoService.getGastos().subscribe((gastos: Gasto[]) => {
      this.gastos = gastos;
    });
  }

  gastoSaveForm=new FormGroup({  
    valorGasto:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
    dataGasto:new FormControl('',[Validators.required]),  
  });  

  saveGastos(saveGasto) {

    this.gasto=new Gasto();     
    this.gasto.dataGasto = formatDate(this.GastoData.value, 'dd/MM/yyyy', 'pt-BR')
    this.gasto.valorGasto = this.GastoValor.value
    console.log(this.gasto.valorGasto);
    console.log(this.gasto.dataGasto);
    this.saveGasto();  
  }  

  saveGasto() {
    this.gastoService.saveGasto(this.gasto)  
    .subscribe(data => console.log(data), error => console.log(error));  
    this.gasto = new Gasto();
    this.getGastos();
  }

  refresh(): void {
    window.location.reload();
  }
  
  cleanForm(form: NgForm) {
    this.getGastos();
    form.resetForm();
    this.gasto = {} as Gasto;
  }

  get GastoValor(){  
    return this.gastoSaveForm.get('valorGasto');  
  }  
  
  get GastoData(){  
    return this.gastoSaveForm.get('dataGasto');  
  }  
 


  title = 'project-gasto';
}
