import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

import { ContatoService } from 'src/app/services/contato.service';

@Component({
  selector: 'app-novo-contato',
  templateUrl: './novo-contato.component.html',
  styleUrls: ['./novo-contato.component.scss']
})
export class NovoContatoComponent implements OnInit {
  contatoForm!: FormGroup;
  sucesso = false;
  erroModal = false;
  msgErro = "";
  constructor(private contatoService: ContatoService, private router: Router) {

  }

  ngOnInit(): void {
    this.contatoForm = new FormGroup({
      nome: new FormControl('', [Validators.required]),
      numeroDocumento: new FormControl('', [Validators.required]),
      cep: new FormControl('', [Validators.required]),
      telefone: new FormControl('', [Validators.required]),
      tipoPessoa: new FormControl('', [Validators.required]),
    });
  }
  get nome() {
    return this.contatoForm.get("nome")!;
  }
  get numeroDocumento() {
    return this.contatoForm.get("numeroDocumento")!;
  }
  get cep() {
    return this.contatoForm.get("cep")!;
  }
  get telefone() {
    return this.contatoForm.get("telefone")!;
  }
  get tipoPessoa() {
    return this.contatoForm.get("tipoPessoa")!;
  }

  submitForm() {
    if (this.contatoForm.valid) {
      this.contatoService.createContato(this.contatoForm.value).subscribe(response => { this.sucess() }, error => { this.msgErro = error.error.message, this.erro() });
    }
  }

  sucess() {
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
