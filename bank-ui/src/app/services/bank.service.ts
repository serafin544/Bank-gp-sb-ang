import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class BankService {

  constructor(private http:HttpClient) { }

  getBank(){
    return this.http.get('/server/api/bank')
  }

  createDeposit(deposit){
    let body = JSON.stringify(deposit);
    return this.http.post('/server/api/bank', body, httpOptions);
  }
}
