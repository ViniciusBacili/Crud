package br.com.cast.avaliacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.cast.avaliacao.model.Aluno;
import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.model.QTurma;
import br.com.cast.avaliacao.repository.AlunoRepository;
import br.com.cast.avaliacao.repository.TurmaRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepo;
	
	@Autowired
	private TurmaRepository turmaRepo;

	@GetMapping("/cadastro")
	public String exbirFormulario(@RequestParam("curso") Curso curso, Model model) throws Exception {


		if (curso.getAtivo() == 0) {

			throw new Exception("Curso não esta ativo");
		}

		model.addAttribute("aluno", new Aluno());
		model.addAttribute("turmas", turmaRepo.findAll(QTurma.turma.curso.eq(curso)));
		return "form-cad-criaAluno";
	}	

	@PostMapping("/cadastro")
	public String cadastrarCurso(
			@ModelAttribute("aluno") Aluno aluno,
			Model model) {

		alunoRepo.save(aluno);

		model.addAttribute("aluno", new Aluno());

		return "form-cad-criaAluno";
	}

}
