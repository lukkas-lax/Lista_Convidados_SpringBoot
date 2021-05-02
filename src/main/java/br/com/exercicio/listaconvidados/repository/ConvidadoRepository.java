package br.com.exercicio.listaconvidados.repository;

import br.com.exercicio.listaconvidados.model.Convidado;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

}
