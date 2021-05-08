import { Injectable } from '@angular/core';  
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs';  
import { Gasto } from './gasto';
  
@Injectable({  
  providedIn: 'root'  
})  
  
export class GastoService {  
  
  private baseUrl = 'http://localhost:8080/api/gastos';  
  
  constructor(private http:HttpClient) { }  
  
  getGastos(): Observable<any> {  
    return this.http.get(`${this.baseUrl}`);  
  }  
  
  saveGasto(gasto: object): Observable<object> {  
    return this.http.post(`${this.baseUrl}`, gasto);  
  }  
    
}  