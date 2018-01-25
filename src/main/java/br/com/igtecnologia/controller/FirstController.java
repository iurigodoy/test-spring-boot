package br.com.igtecnologia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igtecnologia.dao.ConvidadoDao;
import br.com.igtecnologia.model.Convidado;

@Controller
@RequestMapping("/convidados")
public class FirstController {
	
	@Autowired
	private ConvidadoDao convidadoDao;
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute(new Convidado());
		model.addAttribute("convidados", convidadoDao.findAll());
		return "ListaConvidados";
	}
	
	@PostMapping
	public String salvar(Convidado convidado) {
		this.convidadoDao.save(convidado);
		return "redirect:/convidados";
	}
	
}
