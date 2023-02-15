package pildoras.es.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	public Controlador() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/lista")
	public String listaClientes(Model model) {
		
		return "lista-clientes";
	}
}
