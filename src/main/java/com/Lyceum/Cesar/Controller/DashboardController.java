package com.Lyceum.Cesar.Controller;

import com.Lyceum.Cesar.Dto.DashboardDTO;
import com.Lyceum.Cesar.Models.Matricula;
import com.Lyceum.Cesar.Repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @GetMapping("/minhas-turmas/{alunoId}")
    public List<DashboardDTO> getMinhasTurmas(@PathVariable Long alunoId) {
        List<Matricula> matriculas = matriculaRepository.findByAlunoId(alunoId);

        return matriculas.stream().map(m -> {
            DashboardDTO dto = new DashboardDTO();
            dto.setDisciplinaNome(m.getDisciplina().getNome());
            dto.setCodigo(m.getDisciplina().getCodigo());
            dto.setProfessorNome(m.getDisciplina().getProfessor().getNomeCompleto());
            dto.setHorario(m.getDisciplina().getHorario());
            dto.setSala(m.getDisciplina().getSala());
            dto.setMedia(m.getMedia());
            dto.setFaltas(m.getFaltas());
            return dto;
        }).collect(Collectors.toList());
    }
}