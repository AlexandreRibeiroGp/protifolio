package org.portifolio.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.portifolio.service.ProjectService;
import org.portifolio.vo.PessoaVO;
import org.portifolio.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/project", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ProjectController {

    private final ProjectService projectService;


    @GetMapping(value = "/all")
    public List<ProjectVO> findAllProject() throws Exception {

        return   projectService.findAll();
    }

    @PutMapping(value = "/addProject")
    public ProjectVO addProject(@RequestBody final ProjectVO params) throws Exception {
        return projectService.save(params);

    }


    @PostMapping(value = "/alterProject")
    public ResponseEntity<ProjectVO> alterBrand(@RequestBody final ProjectVO params) throws Exception {
        ProjectVO p = projectService.alter(params);
        if(p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/excluir")
    public ResponseEntity<ProjectVO> excluir(@RequestBody final ProjectVO params) {
        ProjectVO p = projectService.excluir(params);
        if(p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
