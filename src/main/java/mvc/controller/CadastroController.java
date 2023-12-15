package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class CadastroController {

	@RequestMapping("/cadastro")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("views/cadastro/index.html");
		modelAndView.addObject("cadastro");
		return modelAndView;
	}
}
