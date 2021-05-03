package br.com.exercicio.listaconvidados.service;

import br.com.exercicio.listaconvidados.model.Convidado;
import br.com.exercicio.listaconvidados.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvidadoService {

    @Autowired
    private ConvidadoRepository convidadorepository;

    public Iterable<Convidado> obterTodos(){

        Iterable<Convidado> convidados = convidadorepository.findAll();

        return convidados;
    }

    public void salvar(Convidado convidado){
        convidadorepository.save(convidado);
    }

}
