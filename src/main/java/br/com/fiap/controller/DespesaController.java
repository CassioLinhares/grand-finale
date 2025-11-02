package br.com.fiap.controller;

import br.com.fiap.model.Despesa;
import br.com.fiap.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @PostMapping("/despesa")
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa salvar(@RequestBody Despesa despesa){
        return despesaService.cadastrar(despesa);
    }

    @GetMapping("/despesa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa buscarPorId(@PathVariable Long id){
        return despesaService.buscarPorId(id);
    }

    @GetMapping("/despesa")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> buscarTodos(){
        return despesaService.buscarTodasDespesas();
    }

    @DeleteMapping("/despesa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        despesaService.excluirDespesas(id);
    }

    @PutMapping("/despesa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa atualizar(@PathVariable Long id, @RequestBody Despesa despesa){
        return despesaService.atualizar(id, despesa);
    }
}
