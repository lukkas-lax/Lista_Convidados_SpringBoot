package br.com.exercicio.listaconvidados;

import br.com.exercicio.listaconvidados.model.Convidado;
import br.com.exercicio.listaconvidados.repository.ConvidadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ConvidadoController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @Autowired
    private ConvidadoRepository convidadorepository;

    @RequestMapping("listaconvidados")
    public String listaConvidados(Model model){

        Iterable<Convidado> convidados = convidadorepository.findAll();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome,
                         @RequestParam("email") String email,
                         @RequestParam("telefone") String telefone, Model model){

        Convidado convidado = new Convidado(nome,email,telefone);

        convidadorepository.save(convidado);
        Iterable<Convidado> convidados = convidadorepository.findAll();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }


}
