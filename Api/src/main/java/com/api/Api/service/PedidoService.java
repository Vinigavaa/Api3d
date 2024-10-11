package com.api.Api.service;

import com.api.Api.domain.Pedido;
import com.api.Api.domain.PedidoRequestDTO;
import com.api.Api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido createPedido(PedidoRequestDTO data){
        Pedido newPedido = new Pedido();
        newPedido.setAndares(data.andares());
        newPedido.setCor1(data.cor1());
        newPedido.setCor2(data.cor2());
        newPedido.setCor3(data.cor3());
        newPedido.setDesenho1(data.desenho1());
        newPedido.setDesenho2(data.desenho2());
        newPedido.setDesenho3(data.desenho3());
        pedidoRepository.save(newPedido);
        return newPedido;
    }


    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById (UUID id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado."));
    }

    public Pedido uptadePedido(UUID id, PedidoRequestDTO pedidoRequestDTO) {
        Pedido updatePedido = getPedidoById(id);
        updatePedido.setAndares(pedidoRequestDTO.andares());
        updatePedido.setCor1(pedidoRequestDTO.cor1());
        updatePedido.setCor2(pedidoRequestDTO.cor2());
        updatePedido.setCor3(pedidoRequestDTO.cor3());
        updatePedido.setDesenho1(pedidoRequestDTO.desenho1());
        updatePedido.setDesenho2(pedidoRequestDTO.desenho2());
        updatePedido.setDesenho3(pedidoRequestDTO.desenho3());
        return pedidoRepository.save(updatePedido);
    }

    public void deletePedido(UUID id) {
        Pedido pedido = getPedidoById(id);
        pedidoRepository.delete(pedido);
    }
}
