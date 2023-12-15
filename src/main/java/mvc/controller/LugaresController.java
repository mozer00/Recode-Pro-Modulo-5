package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LugaresController {

	@RequestMapping("/lugares")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("views/lugares/index.html");
		modelAndView.addObject("lugares");
		return modelAndView;
	
}
}
