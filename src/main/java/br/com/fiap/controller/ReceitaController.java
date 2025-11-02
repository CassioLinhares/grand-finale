package br.com.fiap.controller;

import br.com.fiap.model.Receita;
import br.com.fiap.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping("/receita")
    @ResponseStatus(HttpStatus.CREATED)
    public Receita salvar(@RequestBody Receita receita){
        return receitaService.cadastrar(receita);
    }

    @GetMapping("/receita/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita buscarPorId(@PathVariable Long id){
        return receitaService.buscarPorId(id);
    }

    @GetMapping("/receita")
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> buscarTodos(){
        return receitaService.buscarTodasReceitas();
    }

    @DeleteMapping("/receita/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        receitaService.excluirReceita(id);
    }

    @PutMapping("/receita/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita atualizar(@PathVariable Long id, @RequestBody Receita receita){
        return receitaService.atualizar(receita, id);
    }
}
