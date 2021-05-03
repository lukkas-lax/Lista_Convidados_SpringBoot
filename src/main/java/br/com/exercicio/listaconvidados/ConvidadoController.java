package br.com.exercicio.listaconvidados;

import br.com.exercicio.enviadoremail.EmailService;
import br.com.exercicio.listaconvidados.model.Convidado;
import br.com.exercicio.listaconvidados.service.ConvidadoService;
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
    private ConvidadoService convidadoService;


    @RequestMapping("listaconvidados")
    public String listaConvidados(Model model){

        Iterable<Convidado> convidados = convidadoService.obterTodos();
        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }

    @RequestMapping(value = "salvar", method = RequestMethod.POST)
    public String salvar(@RequestParam("nome") String nome,
                         @RequestParam("email") String email,
                         @RequestParam("telefone") String telefone, Model model){

        Convidado convidado = new Convidado(nome,email,telefone);

        convidadoService.salvar(convidado);

        /* MicroService para envio de e-mails desenvolvido por mim
        * link: https://github.com/lukkas-lax/MicroService_Envio_Email */
        new EmailService().enviar(nome,email);

        Iterable<Convidado> convidados = convidadoService.obterTodos();

        model.addAttribute("convidados", convidados);

        return "listaconvidados";
    }


}
