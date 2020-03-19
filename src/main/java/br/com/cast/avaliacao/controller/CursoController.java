package br.com.cast.avaliacao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cast.avaliacao.model.Categoria;
import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.model.QCurso;
import br.com.cast.avaliacao.model.QTurma;
import br.com.cast.avaliacao.repository.CursoRepository;
import br.com.cast.avaliacao.repository.TurmaRepository;

@Controller
@RequestMapping("/curso")
public class CursoController {

	@Autowired
	private CursoRepository cursoRepo;
	
	@Autowired
	private TurmaRepository turmaRepository;

	@GetMapping("/cadastro")
	public String exbirFormulario(Model model) {

		model.addAttribute("curso", new Curso());
		return "form-cad-curso";
	}	

	@GetMapping("/lista")
	public @ResponseBody List<Curso> listarCursos(@RequestParam("categoria") Categoria categoria) {

		List<Curso> cursos = new ArrayList<>();
		cursoRepo.findAll(QCurso.curso.categoria.eq(categoria)).forEach(cursos::add);
		
		for (Curso curso : cursos) {
			
			curso.setQuantidadeTurmas(new Long(turmaRepository.count(QTurma.turma.curso.eq(curso))).intValue());
		}
		
		
		return cursos;
	}

	@PostMapping("/cadastro")
	public String cadastrarCurso(
			@ModelAttribute("curso") Curso curso,
			Model model) {

		cursoRepo.save(curso);

		return "redirect:/curso/cadastro";
	}

	@GetMapping("/status")
	public String StatusCurso(
			@RequestParam("curso") Curso curso) {
		
		curso.setAtivo(curso.getAtivo().equals(1) ? 0 : 1);
		cursoRepo.save(curso);

		return "redirect:/curso/cadastro";
	}
}
