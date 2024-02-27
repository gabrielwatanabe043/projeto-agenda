import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { NovoContatoComponent } from './components/pages/novo-contato/novo-contato.component';
import { EditarContatoComponent } from './components/pages/editar-contato/editar-contato.component';

const routes: Routes = 
  [{path: 'home', component: HomeComponent},{path: '', component: HomeComponent},{path: 'novo-contato', component: NovoContatoComponent},{path: 'editar-contato/:id', component: EditarContatoComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
