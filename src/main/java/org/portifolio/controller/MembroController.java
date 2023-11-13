package org.portifolio.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.portifolio.service.MembroService;
import org.portifolio.vo.MembroVO;
import org.portifolio.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/membro", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MembroController {


    private final  MembroService membroService;


    @GetMapping(value = "/all")
    public List<MembroVO> findAllProject() throws Exception {
        return   membroService.findAll();
    }

    @PutMapping(value = "/addMembro")
    public MembroVO addProject(@RequestBody final MembroVO params) throws Exception {
        return membroService.save(params);

    }


    @PostMapping(value = "/alterMembro")
    public ResponseEntity<MembroVO> alterBrand(@RequestBody final MembroVO params) {
        MembroVO p = membroService.alter(params);
        if(p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/excluir")
    public ResponseEntity<MembroVO> excluir(@RequestBody final MembroVO params) {
        MembroVO p = membroService.excluir(params);
        if(p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
