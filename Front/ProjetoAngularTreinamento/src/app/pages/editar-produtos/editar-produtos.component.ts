import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { IProduto } from 'src/app/interfaces/produto';
import { ProdutosService } from 'src/app/services/produtos.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-editar-produtos',
  templateUrl: './editar-produtos.component.html',
  styleUrls: ['./editar-produtos.component.css']
})
export class EditarProdutosComponent implements OnInit {
  idProduto!: string;
  produtoForm = new FormGroup({
    id: new FormControl(0),
    nome: new FormControl('', Validators.required),
    codigoBarras: new FormControl('', Validators.required),
    preco: new FormControl(0)
  });

  constructor(private produtosService: ProdutosService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.idProduto = this.route.snapshot.paramMap.get('id')!;
    this.produtosService.buscarPorId(this.idProduto).subscribe( produto => {
      this.produtoForm.patchValue({
        id: produto.id,
        nome: produto.nome,
        codigoBarras: produto.codigoBarras,
        preco: produto.preco
      });
    });
  }

  enviar() {
    const produto: IProduto = this.produtoForm.value as IProduto;
    

    this.produtosService.editarProduto(produto).subscribe(
      (result) => {
        Swal.fire(
          'Produto alterado com sucesso',
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