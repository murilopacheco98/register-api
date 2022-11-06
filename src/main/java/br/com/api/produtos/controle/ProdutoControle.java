package br.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.modelo.ProdutoModelo;
import br.com.api.produtos.modelo.RespostaModelo;
import br.com.api.produtos.servico.ProdutoServico;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {

  @Autowired
  private ProdutoServico produtoServico;

  @PutMapping("/alterar")
  public ResponseEntity<?> alterar(@RequestBody ProdutoModelo produtoModelo) {
    return produtoServico.alterar(produtoModelo);
  }

  @DeleteMapping("/remover/{codigo}")
  public ResponseEntity<RespostaModelo> remover(@PathVariable("codigo") long codigo) {
    return produtoServico.remover(codigo);
  }

  @GetMapping("/listar")
  public Iterable<ProdutoModelo> listar() {
    return produtoServico.listar();
  }

  @GetMapping("/")
  public String rota() {
    return "API de produtos funcionando!";
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody ProdutoModelo produtoModelo) {
    return produtoServico.cadastrar(produtoModelo);
  }
}
