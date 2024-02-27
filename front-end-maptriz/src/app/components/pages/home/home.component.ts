
import { Component, OnInit } from '@angular/core';
import { Contato } from 'src/app/model/Contato';
import { ContatoService } from 'src/app/services/contato.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private service: ContatoService, private router: Router) { }
  isVisible = false;
  isVisibleEditar = false;

  fraseDelete: string = "Tem certeza de que deseja excluir esse contato?"
  id: string = "";
  contatos: Contato[] = [];
  contatosfiltro: Contato[] = [];
  termoBusca: string = "";
  isChecked1: boolean = false;
  isChecked2: boolean = false;

  ngOnInit(): void {
    this.carregarContatos();
  }

  carregarContatos(): void {
    this.service.getAllContatos().subscribe(c => {
      this.contatos = c;
      this.contatosfiltro = c;
    });
  }

  filtro() {
    if (this.isChecked1 == true && this.isChecked2 == true || this.isChecked1 == false && this.isChecked2 == false) {
      this.contatos = this.contatosfiltro.filter((contato => contato.nome.toLowerCase().includes(this.termoBusca.trim().toLowerCase())))
    } else if (this.isChecked1 == true && this.isChecked2 == false) {
      this.contatos = this.contatosfiltro.filter((contato => contato.tipoPessoa == "PESSOAFISICA" && contato.nome.toLowerCase().includes(this.termoBusca.trim().toLowerCase())))
    } else {
      this.contatos = this.contatosfiltro.filter((contato => contato.tipoPessoa == "PESSOAJURIDICA" && contato.nome.toLowerCase().includes(this.termoBusca.trim().toLowerCase())))
    }

  }
  excluir(id: string) {
    this.isVisible = true;
    this.id = id;
  }
  confirmacao(value: any) {
    if (value) {
      this.service.deleteContato(this.id).subscribe()
      this.isVisible = false;
      window.location.reload()
    } else {
      this.isVisible = false;
    }
  }

 

}
