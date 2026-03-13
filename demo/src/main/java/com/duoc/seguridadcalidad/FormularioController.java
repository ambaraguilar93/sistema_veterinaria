package com.duoc.seguridadcalidad;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.duoc.seguridadcalidad.model.Paciente;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pacientes")
public class FormularioController {

    private List<Paciente> pacientes = new ArrayList<>();

    // Mostrar formulario
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "formulario";
    }

    // Guardar paciente
    @PostMapping("/guardar")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        pacientes.add(paciente);
        return "redirect:/pacientes/lista";
    }

    // Mostrar pacientes
    @GetMapping("/lista")
    public String listarPacientes(Model model) {
        model.addAttribute("pacientes", pacientes);
        return "pacientes";
    }
}