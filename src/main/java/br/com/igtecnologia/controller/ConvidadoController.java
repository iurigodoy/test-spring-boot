package br.com.igtecnologia.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.igtecnologia.dao.ConvidadoDao;
import br.com.igtecnologia.model.Convidado;

@Controller
@RequestMapping("/index")
public class ConvidadoController {
	
	@Autowired
	private ConvidadoDao convidadoDao;
	
	@GetMapping
	public String getAll(Model model) {
		model.addAttribute(new Convidado());
		model.addAttribute("convidados", convidadoDao.findAll());
		return "index";
	}

	@RequestMapping("{id}")
	public String getOne(Long id, Model model) {
		model.addAttribute("empresa", convidadoDao.getOne(id));
		return "edt-index";
	}
	
	@PostMapping
	public String save(@Valid Convidado convidado, BindingResult result) {
		if(result.hasErrors()) {
		    return "forward:index";
		} else {
			this.convidadoDao.save(convidado);
			return "redirect:/index";
		}
	}
	
	@Async
	@RequestMapping("delete/{id}")
	public void delete(Long id) {
		convidadoDao.delete(id);
	}

	@Async
	@RequestMapping("restore/{id}")
	public void restore(Long id) {
		//convidadoDao.restore(id);
	}
	
}
