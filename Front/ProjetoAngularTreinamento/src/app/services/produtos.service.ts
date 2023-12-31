import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { IProduto } from '../interfaces/produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {
  api = 'http://localhost:4200/api/produtos';

  constructor(private http: HttpClient) {}

  buscarTodos() {
    return this.http.get<IProduto[]>(this.api);
  }

  buscarPorId(id: string) {
    return this.http.get<IProduto>(this.api + '/' + id);
  }

  cadastrarProduto(produto: IProduto) {
    return this.http.post<IProduto>(this.api, produto);
  }

  editarProduto(produto: IProduto) {
    return this.http.put<IProduto>(this.api, produto);
  }

  removerProduto(id: number) {
    return this.http.delete(this.api + '/' + id);
  }
}
