package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Cliente;
import mvc.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ModelAndView cliente() {
		ModelAndView modelAndView = new ModelAndView("views/cliente/index.html");
		modelAndView.addObject("cliente", clienteRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/cliente/create.html");
		modelAndView.addObject("cliente", new Cliente());
		return modelAndView;
	}



	@PostMapping("/create")
	public String create(Cliente cliente) {
		clienteRepository.save(cliente);

		return "redirect:/cliente";
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/cliente/update.html");

		Cliente cliente = clienteRepository.findById(id).orElse(null);
		modelAndView.addObject("cliente", cliente);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id, @ModelAttribute("cliente") Cliente cliente) {
		cliente.setId(id); 

		clienteRepository.save(cliente);
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		clienteRepository.deleteById(id);

		return modelAndView;		
	}

}
