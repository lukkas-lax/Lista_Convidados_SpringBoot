package br.com.exercicio.listaconvidados;

import br.com.exercicio.listaconvidados.model.Convidado;
import br.com.exercicio.listaconvidados.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvidadoController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @Autowired
    private ConvidadoRepository repository;

    @RequestMapping("listaconvidados")
    public String listaConvidados(Model model){

        Iterable<Convidado> convidados = repository.findAll();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

}
