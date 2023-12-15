package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class ContatoController {

	@RequestMapping("/contato")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("views/contato/index.html");
		modelAndView.addObject("contato");
		return modelAndView;
	}
}
