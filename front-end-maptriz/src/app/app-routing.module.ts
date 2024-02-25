import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/pages/home/home.component';
import { NovoContatoComponent } from './components/pages/novo-contato/novo-contato.component';

const routes: Routes = 
  [{path: 'home', component: HomeComponent},{path: '', component: HomeComponent},{path: 'novo-contato', component: NovoContatoComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
