package br.com.thiago;

import br.com.thiago.db.DBCidade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by thiago on 8/27/18.
 */
@RestController
public class CidadeController {

    /*******************************************************************************************************************
     * Algumas questoes nao foram feitas por falta de tempo
     * Alguns tratamentos de erros foram deixados de lado pela mesma razao pouco tempo para o desenvolvimento
     ******************************************************************************************************************/

    @GetMapping("/capitais")
    public List<Cidade> retornarCapitais(){
        return new DBCidade().retornarCapitais();
    }

    @GetMapping("/totalCidades")
    public int retornarTotalCidades(){
        return new DBCidade().retornarTotalCidades();
    }

    @GetMapping("/totalCidadesEstado")
    public List<CidadeEstado> retornarCidadesEstado(){
        return new DBCidade().retornarCidadesEstado();
    }

    @GetMapping("/cidade/{ibge}")
    public Cidade consultarIbge(@PathVariable int ibge){
        return new DBCidade().consultarCidade(ibge);
    }

    @GetMapping("/cidadePorEstado/{estado}")
    public List<Cidade> consultarCidadesEstado(@PathVariable String estado){
        return new DBCidade().consultarCidadePorEstado(estado);
    }

    @DeleteMapping("/cidade/{id}")
    public void excluirCidade(@PathVariable int id){
        new DBCidade().excluirCidade(id);
    }

    @PostMapping("/cidade")
    public void cadastrarCidade(@RequestBody Cidade cidade){
        new DBCidade().cadastrarCidade(cidade);
    }
}
