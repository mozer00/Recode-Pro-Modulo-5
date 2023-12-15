package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Cliente;
import mvc.model.Destino;
import mvc.model.Viagem;
import mvc.repository.ClienteRepository;
import mvc.repository.DestinoRepository;
import mvc.repository.ViagemRepository;

@Controller
@RequestMapping("/viagem")
public class ViagemController {
	@Autowired
	private ViagemRepository viagemRepository;
	@Autowired
	private DestinoRepository destinoRepository;
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public ModelAndView viagem() {
		ModelAndView modelAndView = new ModelAndView("views/viagem/index.html");
		modelAndView.addObject("viagem", viagemRepository.findAll());
		

		return modelAndView;
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("views/viagem/create.html");

		List<Destino> destinos = destinoRepository.findAll();
		List<Cliente> clientes = clienteRepository.findAll();

		modelAndView.addObject("cliente", clientes);
		modelAndView.addObject("destino", destinos);

		modelAndView.addObject("viagem", new Viagem());

		return modelAndView;
	}

	@PostMapping("/create")
	public String create(Viagem viagem, @RequestParam("cliente_id") Long clienteId,
			@RequestParam("destino_id") Long destinoId) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteId);
		Destino destino = new Destino();
		destino.setId(destinoId);

		viagem.setCliente(cliente);
		viagem.setDestino(destino);

		viagemRepository.save(viagem);

		return "redirect:/viagem";
	}

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("views/viagem/update.html");

		Viagem viagem = viagemRepository.findById(id).orElse(null);
		modelAndView.addObject("viagem", viagem);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id, @ModelAttribute("viagem") Viagem viagem) {

		viagemRepository.save(viagem);
		ModelAndView modelAndView = new ModelAndView("redirect:/viagem");
		return modelAndView;

	}

	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/viagem");

		viagemRepository.deleteById(id);

		return modelAndView;
	}

}
