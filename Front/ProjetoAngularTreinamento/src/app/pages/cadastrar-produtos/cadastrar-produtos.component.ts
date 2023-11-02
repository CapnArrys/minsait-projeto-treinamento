import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IProduto } from 'src/app/interfaces/produto';
import { ProdutosService } from 'src/app/services/produtos.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cadastrar-produtos',
  templateUrl: './cadastrar-produtos.component.html',
  styleUrls: ['./cadastrar-produtos.component.css']
})
export class CadastrarProdutosComponent {
  constructor(private produtosService: ProdutosService, private router: Router) {}

  produtoForm = new FormGroup({
    nome: new FormControl('', Validators.required),
    codigoBarras: new FormControl('', Validators.required),
    preco: new FormControl(0)
  });

  enviar() {
    const produto: IProduto = this.produtoForm.value as IProduto;
    

    this.produtosService.cadastrarProduto(produto).subscribe(
      (result) => {
        Swal.fire(
          'Produto cadastrado com sucesso',
          'operação bem sucedida',
          'success'
        );
        this.router.navigate(['/produtos']);
      },
      (error) => {
        const { message } = error;
        Swal.fire('Algo deu errado', message, 'error');
      }
    );
  }
}

