package com.duoc.seguridadcalidad;

import com.duoc.seguridadcalidad.model.RegistroMedico;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/registros")
public class RegistroMedicoController {

    private List<RegistroMedico> registros = new ArrayList<>();

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("registro", new RegistroMedico());
        return "registro-form";
    }

    @PostMapping("/guardar")
    public String guardarRegistro(@ModelAttribute RegistroMedico registro) {
        registros.add(registro);
        return "redirect:/registros/lista";
    }

    @GetMapping("/lista")
    public String listarRegistros(Model model) {
        model.addAttribute("registros", registros);
        return "registros";
    }
}
