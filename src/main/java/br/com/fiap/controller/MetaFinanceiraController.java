package br.com.fiap.controller;

import br.com.fiap.model.MetaFinanceira;
import br.com.fiap.service.MetaFinanceiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api")
public class MetaFinanceiraController {

    @Autowired
    private MetaFinanceiraService metaFinanceiraService;

    @PostMapping("/metafinanceira")
    @ResponseStatus(HttpStatus.CREATED)
    public MetaFinanceira salvar(@RequestBody MetaFinanceira metaFinanceira){
        return metaFinanceiraService.cadastrar(metaFinanceira);
    }

    @GetMapping("/metafinanceira/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MetaFinanceira buscarPorId(@PathVariable Long id){
        return metaFinanceiraService.buscarPorId(id);
    }

    @GetMapping("/metafinanceira")
    @ResponseStatus(HttpStatus.OK)
    public List<MetaFinanceira> buscarTodos(){
        return metaFinanceiraService.buscarTodasMetaFinanceiras();
    }

    @DeleteMapping("/metafinanceira/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        metaFinanceiraService.excluirMetaFinanceira(id);
    }

    @PutMapping("/metafinanceira/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MetaFinanceira atualizar(@PathVariable Long id, @RequestBody MetaFinanceira metaFinanceira){
        return metaFinanceiraService.atualizar(metaFinanceira, id);
    }
}
