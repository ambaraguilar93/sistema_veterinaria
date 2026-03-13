package com.duoc.seguridadcalidad;

import com.duoc.seguridadcalidad.model.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/citas")
public class CitaController {

    private List<Cita> citas = new ArrayList<>();

    // mostrar formulario
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cita", new Cita());
        return "cita-form";
    }

    // guardar cita
    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita) {
        citas.add(cita);
        return "redirect:/citas/lista";
    }

    // listar citas
    @GetMapping("/lista")
    public String listarCitas(Model model) {
        model.addAttribute("citas", citas);
        return "citas";
    }

}