import { Injectable } from '@angular/core';
import { Contato } from '../model/Contato';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ContatoCreate } from '../model/ContatoCreate';
import { ContatoEditar } from '../model/ContatoEditar';
import { Mensagem } from '../model/Mensagem';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {
  private api = "http://localhost:8080/contato"
  private apiNotificacao = "https://run.mocky.io/v3/c9ec2ca3-a7f5-41d0-8550-b859508f4948"
  constructor(private http: HttpClient) { }

  getContato(id:string):Observable<Contato>{
    return this.http.get<Contato>(`${this.api}/${id}`); 
  }
  getAllContatos():Observable<Contato[]>{
    return this.http.get<Contato[]>(this.api); 
  }
  createContato(contato:ContatoCreate):Observable<any>{
    return this.http.post<any>(this.api, contato,{observe: 'response'})
  }
  deleteContato(id:string):Observable<any>{
    return this.http.delete(`${this.api}/${id}`)
  }
  updateContato(id:string, contato:ContatoEditar):Observable<any>{
    return this.http.put<any>(`${this.api}/${id}`, contato,{observe: 'response'})
  }

  notificacao():Observable<Mensagem>{
    return this.http.put<Mensagem>(this.apiNotificacao,{observe: 'response'})
  }
}
