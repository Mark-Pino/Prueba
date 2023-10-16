package com.example.mscarrito.controller;

import com.example.mscarrito.entity.CarritoItem;
import com.example.mscarrito.service.CarritoService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    @Autowired
    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping("/items")
    public List<CarritoItem> obtenerItems() {
        return carritoService.obtenerTodosLosItems();
    }

    @PostMapping("/agregar")
    public CarritoItem agregarItem(@RequestBody CarritoItem item) {
        return carritoService.agregarItemAlCarrito(item);
    }

    @GetMapping("/item/{id}")
    public Optional<CarritoItem> obtenerItemPorId(@PathVariable Integer id) {
        return carritoService.ListarPorId(id);
    }

    @DeleteMapping("/vaciar/{id}")
    public void vaciarItemPorId(@PathVariable Integer id) {
        carritoService.vaciarCarrito(id);
    }

    @DeleteMapping("/vaciar")
    public CarritoItem vaciarCarrito(@RequestBody CarritoItem item) {
        return carritoService.vaciarCarrito(item);
    }
}
