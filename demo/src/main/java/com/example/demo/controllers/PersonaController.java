package com.example.demo.controllers;
import com.example.demo.entities.Persona;
import com.example.demo.services.PersonaServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/persona")
public class PersonaController extends BaseControllerImpl<Persona,PersonaServiceImpl>{
}
