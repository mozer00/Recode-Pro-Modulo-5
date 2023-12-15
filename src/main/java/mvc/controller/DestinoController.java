package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Destino;
import mvc.repository.DestinoRepository;

@Controller
@RequestMapping("/destino")
public class DestinoController {

	@Autowired
	private DestinoRepository destinoRepository;

	@GetMapping
	public ModelAndView destino() {
		ModelAndView modelAndView = new ModelAndView("views/destino/index.html");
		modelAndView.addObject("destino", destinoRepository.findAll());

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/destino/create.html");
		modelAndView.addObject("destino", new Destino());
		return modelAndView;
	}

	@PostMapping("/create")
	public String create(Destino destino) {
		destinoRepository.save(destino);

		return "redirect:/destino";
	}
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/destino/update.html");

		Destino destino = destinoRepository.findById(id).orElse(null);
		modelAndView.addObject("destino", destino);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id, @ModelAttribute("destino") Destino destino) {
		destino.setId(id); 

		destinoRepository.save(destino);
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");

		return modelAndView;
	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/destino");

		destinoRepository.deleteById(id);

		return modelAndView;		
	}

}
