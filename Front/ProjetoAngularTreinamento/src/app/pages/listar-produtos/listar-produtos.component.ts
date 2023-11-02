import { Component } from '@angular/core';
import { IProduto } from 'src/app/interfaces/produto';
import { ProdutosService } from 'src/app/services/produtos.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-listar-produtos',
  templateUrl: './listar-produtos.component.html',
  styleUrls: ['./listar-produtos.component.css']
})
export class ListarProdutosComponent {
  produtos: IProduto[] = [];

  constructor(private produtosService: ProdutosService) {}

  ngOnInit() {
    this.produtosService.buscarTodos().subscribe(
      (produtos) => {
        this.produtos = produtos;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  remover(id: number) {
    Swal.fire({
      title: 'Você tem certeza?',
      text: "Essa ação não pode ser revertida",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Sim, Deletar'
    }).then((result) => {
      if (result.isConfirmed) {
        this.produtosService.removerProduto(id).subscribe(
          (result) => {
            Swal.fire(
              'Produto removido com sucesso',
              'operação bem sucedida',
              'success'
            );
            this.produtos = this.produtos.filter((produto) => produto.id !== id);
          },
          (error) => {
            const { message } = error;
            Swal.fire('Algo deu errado', message, 'error');
          }
        );
      }
    })
  }
}