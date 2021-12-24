package com.challenge.demo.controllers;

import com.challenge.demo.models.PersonaModel;
import com.challenge.demo.models.ResponseModel;
import com.challenge.demo.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    PersonaService personaService;

    @PostMapping(path = "/new")
    public ResponseEntity<ResponseModel> newPersona(@RequestBody PersonaModel persona) {
        return personaService.newPersona(persona);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<ResponseModel> deletePersona(@RequestParam Integer dni){
        try{
            ResponseEntity<ResponseModel> resp = personaService.deletePersonaByDNI(dni);
            return resp;
        } catch (Exception e){
            return ResponseEntity.status(501).body(new ResponseModel(null,e.getMessage(),501));
        }

    }

    @PostMapping(path = "/update")
    public ResponseEntity<ResponseModel> updatePersona(@RequestBody PersonaModel persona){
        ResponseEntity<ResponseModel> obj = personaService.updatePersona(persona);
        return obj;
    }
    
}
