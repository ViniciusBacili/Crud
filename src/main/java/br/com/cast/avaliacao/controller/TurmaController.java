package br.com.cast.avaliacao.controller;

import java.util.ArrayList;
import java.util.Date;
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

import com.querydsl.core.types.dsl.BooleanExpression;

import br.com.cast.avaliacao.model.Curso;
import br.com.cast.avaliacao.model.QTurma;
import br.com.cast.avaliacao.model.Turma;
import br.com.cast.avaliacao.repository.TurmaRepository;


@Controller
@RequestMapping("/turma")
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepo;

	@GetMapping("/cadastro")
	public String exbirFormulario(@RequestParam("curso") Curso curso, Model model) throws Exception {


		if (curso.getAtivo() == 0) {

			throw new Exception("Curso não esta ativo");
		}

		Turma ag = new Turma();
		ag.setCurso(curso);

		model.addAttribute("turma", ag);
		return "form-cad-criaTurma";
	}	
	
	@GetMapping("/lista")
	public @ResponseBody List<Turma> listarTurmas(@RequestParam("dataInicio") Date dataInicio) {

		List<Turma> turmas = new ArrayList<>();
		return turmas;
	}

	@PostMapping("/cadastro")
	public String cadastrarTurma(
			@ModelAttribute("turma") Turma turma,
			Model model) throws Exception {
		
		BooleanExpression if1 = QTurma.turma.curso.eq(turma.getCurso())
				.and(QTurma.turma.dataInicio.before(turma.getDataInicio()))
				.and(QTurma.turma.dataFim.after(turma.getDataFim()));

		if (turmaRepo.exists(if1)) {
			throw new Exception("Já existe curso cadastrado para este periodo");
		}

		BooleanExpression if2 = QTurma.turma.curso.eq(turma.getCurso())
				.and(QTurma.turma.dataInicio.before(turma.getDataInicio()))
				.and(QTurma.turma.dataFim.after(turma.getDataFim()));

		if (turmaRepo.exists(if2)) {
			throw new Exception("Já existe curso cadastrado para este periodo");
		}

		BooleanExpression if3 = QTurma.turma.curso.eq(turma.getCurso())
				.and(QTurma.turma.dataInicio.after(turma.getDataInicio()))
						.and(QTurma.turma.dataFim.before(turma.getDataFim()));

		if (turmaRepo.exists(if3)) {
			throw new Exception("Já existe curso cadastrado para este periodo");
		}

		BooleanExpression if4 = QTurma.turma.curso.eq(turma.getCurso())
				.and(QTurma.turma.dataInicio.after(turma.getDataInicio())
						.and(QTurma.turma.dataFim.before(turma.getDataFim())));

		if (turmaRepo.exists(if4)) {
			throw new Exception("Já existe curso cadastrado para este periodo");
		}

		BooleanExpression if5 = QTurma.turma.curso.eq(turma.getCurso())
				.and(QTurma.turma.dataInicio.between(turma.getDataInicio(), turma.getDataFim()))
				.and(QTurma.turma.dataFim.between(turma.getDataInicio(), turma.getDataFim()))
				.and(QTurma.turma.dataInicio.before(turma.getDataInicio()))
				.and(QTurma.turma.dataFim.before(turma.getDataFim()));

		if (turmaRepo.exists(if5)) {
			throw new Exception("Já existe curso cadastrado para este periodo");
		}

		BooleanExpression if6 = QTurma.turma.curso.eq(turma.getCurso())
				.and(QTurma.turma.dataInicio.notBetween(turma.getDataInicio(), turma.getDataFim()))
				.and(QTurma.turma.dataFim.after(turma.getDataInicio()));

		if (turmaRepo.exists(if6)) {
			throw new Exception("Já existe curso cadastrado para este periodo");
		}


		turmaRepo.save(turma);

//		model.addAttribute("turma", new Turma());

		return "redirect:/curso/cadastro";
	}

}

