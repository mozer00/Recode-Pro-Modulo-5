package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PromocaoController {

		
		@RequestMapping("/promocao")
		public ModelAndView index() {
			ModelAndView modelAndView = new ModelAndView("views/promocao/index.html");
			modelAndView.addObject("promocao");
			return modelAndView;
		}
}
