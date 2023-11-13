package org.portifolio.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.portifolio.service.PessoaService;
import org.portifolio.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/pessoa", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class PessoaController {

    private final PessoaService pessoaService;


    @GetMapping(value = "/all")
    public List<PessoaVO> findAllProject() throws Exception {
        return   pessoaService.findAll();
    }

    @PutMapping(value = "/addPessoa")
    public PessoaVO addPessoa(@RequestBody final PessoaVO params) throws Exception {
        return pessoaService.save(params);

    }


    @PostMapping(value = "/alterPessoa")
    public ResponseEntity<PessoaVO> alterBrand(@RequestBody final PessoaVO params) {
        PessoaVO p = pessoaService.alter(params);
        if(p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/excluir")
    public ResponseEntity<PessoaVO> excluir(@RequestBody final PessoaVO params) {
        PessoaVO p = pessoaService.excluir(params);
        if(p != null)
            return new ResponseEntity<>(p, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
