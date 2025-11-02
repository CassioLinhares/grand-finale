package br.com.fiap.controller;

import br.com.fiap.model.Orcamento;
import br.com.fiap.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @PostMapping("/orcamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Orcamento salvar(@RequestBody Orcamento orcamento){
        return orcamentoService.cadastrar(orcamento);
    }

    @GetMapping("/orcamento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Orcamento buscarPorId(@PathVariable Long id){
        return orcamentoService.buscarPorId(id);
    }

    @GetMapping("/orcamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Orcamento> buscarTodos(){
        return orcamentoService.buscarTodasOrcamentos();
    }

    @DeleteMapping("/orcamento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        orcamentoService.excluirOrcamento(id);
    }

    @PutMapping("/orcamento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Orcamento atualizar(@PathVariable Long id, @RequestBody Orcamento orcamento){
        return orcamentoService.atualizar(id, orcamento);
    }
}
