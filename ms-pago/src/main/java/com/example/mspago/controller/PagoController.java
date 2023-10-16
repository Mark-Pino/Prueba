package com.example.mspago.controller;

import com.example.mspago.entity.Pago;
import com.example.mspago.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/pagos")
public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @PostMapping("/realizar")
    public Pago realizarPago(@RequestBody Pago pago) {
        return pagoService.realizarPago(pago);
    }

    @PostMapping("/cancelar")
    public Pago cancelarPago(@RequestBody Pago pago) {
        return pagoService.cancelarPago(pago);
    }

    @GetMapping("/{id}")
    public Optional<Pago> obtenerPagoPorId(@PathVariable Integer id) {
        return pagoService.listarPorId(id);
    }
}