package com.duoc.seguridadcalidad;

import com.duoc.seguridadcalidad.model.Factura;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

    @GetMapping("/nueva")
    public String nuevaFactura(Model model) {
        model.addAttribute("factura", new Factura());
        return "formFactura";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Factura factura) {

        factura.setId(BaseDatosMemoria.facturas.size() + 1);
        BaseDatosMemoria.facturas.add(factura);

        return "redirect:/facturas/lista";
    }

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("facturas", BaseDatosMemoria.facturas);
        return "listaFacturas";
    }
}