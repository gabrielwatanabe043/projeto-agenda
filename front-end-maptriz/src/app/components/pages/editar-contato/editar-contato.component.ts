import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Contato } from 'src/app/model/Contato';
import { ContatoEditar } from 'src/app/model/ContatoEditar';
import { ContatoService } from 'src/app/services/contato.service';

@Component({
  selector: 'app-editar-contato',
  templateUrl: './editar-contato.component.html',
  styleUrls: ['./editar-contato.component.scss']
})
export class EditarContatoComponent implements OnInit {
  
  contatoFormEditar!: FormGroup;
  sucesso = false;
  erroModal = false;
  msgErro = "";
  msgSucesso = "";
  contato!:Contato;
  constructor(private route: ActivatedRoute, private service: ContatoService,private router: Router) {
}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      
      const id = params['id'];
      this.service.getContato(id).subscribe(response =>{
        this.contato = response;
        this.inicializaForm()
      })
     
    });
    this.inicializaForm()
 
    
  }
  inicializaForm(){
    this.contatoFormEditar = new FormGroup({
      nome: new FormControl(this.contato ? this.contato.nome :  '', [Validators.required,]),
      cep: new FormControl(this.contato ? this.contato.cep : '', [Validators.required,]),
      telefone: new FormControl(this.contato ? this.contato.telefone : '', [Validators.required,])
    });
  }
  get nome() {
    return this.contatoFormEditar.get("nome")!;
  }
 
  get cep() {
    return this.contatoFormEditar.get("cep")!;
  }
  get telefone() {
    return this.contatoFormEditar.get("telefone")!;
  }


  submitForm() {
    if (this.contatoFormEditar.valid) {
      this.service.updateContato(this.contato.id, this.contatoFormEditar.value).subscribe(response => { this.sucess() }, error => { this.msgErro = error.error.message, this.erro() });
    }
  }
  sucess() {
    this.service.notificacao().subscribe(
      response => {this.msgSucesso = response.mensagem}
    )
    this.sucesso = true;
   
    setTimeout(() => {
      this.sucesso = false;
      this.router.navigate(['/home'])
    }, 2000)


  }

  erro() {
    this.erroModal = true;
    setTimeout(() => {
      this.erroModal = false;
    }, 2000)
  }

}
