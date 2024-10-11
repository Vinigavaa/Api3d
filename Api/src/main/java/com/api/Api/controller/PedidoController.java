package com.api.Api.controller;

import com.api.Api.domain.Pedido;
import com.api.Api.domain.PedidoRequestDTO;
import com.api.Api.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Pedido>create (
            @RequestParam("andares") int andares,
            @RequestParam("cor1") String cor1,
            @RequestParam("cor2") String cor2,
            @RequestParam("cor3") String cor3,
            @RequestParam("desenho1") String desenho1,
            @RequestParam("desenho2") String desenho2,
            @RequestParam("desenho3") String desenho3
    ){
        PedidoRequestDTO pedidoRequestDTO = new PedidoRequestDTO(andares, cor1, cor2, cor3, desenho1,desenho2,desenho3);
        Pedido newPedido = this.pedidoService.createPedido(pedidoRequestDTO);
        return ResponseEntity.ok(newPedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos(){
        List<Pedido> pedidos = this.pedidoService.getAllPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable("id") UUID id){
        Pedido pedido = this.pedidoService.getPedidoById(id);
        return ResponseEntity.ok(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido (@PathVariable("id") UUID id, @RequestBody PedidoRequestDTO pedidoRequestDTO){
        Pedido updatePedido = this.pedidoService.uptadePedido(id, pedidoRequestDTO);
        return ResponseEntity.ok(updatePedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable("id") UUID id){
        this.pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }



}
