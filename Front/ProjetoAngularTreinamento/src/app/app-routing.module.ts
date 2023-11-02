import { NgModule } from '@angular/core';
import { HomeComponent } from './pages/home/home.component';
import { CadastrarProdutosComponent } from './pages/cadastrar-produtos/cadastrar-produtos.component';
import { ListarProdutosComponent } from './pages/listar-produtos/listar-produtos.component';
import { RouterModule, Routes } from '@angular/router';
import { EditarProdutosComponent } from './pages/editar-produtos/editar-produtos.component';

const routes: Routes = [
  {
    path: '', component: HomeComponent
  },
  {
    path: 'produtos', component: ListarProdutosComponent
  },
  {
    path: 'produtos/cadastrar', component: CadastrarProdutosComponent
  },
  {
    path: 'produtos/editar/:id', component: EditarProdutosComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
