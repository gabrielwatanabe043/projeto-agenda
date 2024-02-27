import { Injectable } from '@angular/core';
import { Contato } from '../model/Contato';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ContatoCreate } from '../model/ContatoCreate';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {
  private api = "http://localhost:8080/contato"
  constructor(private http: HttpClient) { }

 
  getAllContatos():Observable<Contato[]>{
    
    return this.http.get<Contato[]>(this.api); 
  }
  createContato(contato:ContatoCreate):Observable<any>{
    return this.http.post<any>(this.api, contato,{observe: 'response'})
  }
  deleteContato(id:string){
    return this.http.delete(`${this.api}/${id}`)
  }

}
