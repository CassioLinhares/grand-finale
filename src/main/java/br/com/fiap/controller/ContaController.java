package br.com.fiap.controller;

import br.com.fiap.model.Conta;
import br.com.fiap.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("/conta")
    @ResponseStatus(HttpStatus.CREATED)
    public Conta salvar(@RequestBody Conta conta){
        return contaService.cadastrar(conta);
    }

    @GetMapping("/conta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conta buscarPorId(@PathVariable Long id){
        return contaService.buscarPorId(id);
    }

    @GetMapping("/conta")
    @ResponseStatus(HttpStatus.OK)
    public List<Conta> buscarTodos(){
        return contaService.buscarTodasContas();
    }

    @DeleteMapping("/conta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        contaService.excluir(id);
    }

    @PutMapping("/conta/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Conta atualizar(@PathVariable Long id, @RequestBody Conta conta){
        return contaService.atualizar(id, conta);
    }
}
