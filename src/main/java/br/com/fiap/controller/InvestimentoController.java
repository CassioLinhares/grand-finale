package br.com.fiap.controller;

import br.com.fiap.model.Investimento;
import br.com.fiap.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @PostMapping("/investimento")
    @ResponseStatus(HttpStatus.CREATED)
    public Investimento salvar(@RequestBody Investimento investimento){
        return investimentoService.cadastrar(investimento);
    }

    @GetMapping("/investimento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Investimento buscarPorId(@PathVariable Long id){
        return investimentoService.buscarPorId(id);
    }

    @GetMapping("/investimento")
    @ResponseStatus(HttpStatus.OK)
    public List<Investimento> buscarTodos(){
        return investimentoService.buscarTodosInvestimentos();
    }

    @DeleteMapping("/investimento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        investimentoService.excluir(id);
    }

    @PutMapping("/investimento/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Investimento atualizar(@RequestBody Investimento investimento, @PathVariable Long id){
        return investimentoService.atualizar(investimento, id);
    }
}
