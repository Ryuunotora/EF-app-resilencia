package pe.edu.cibertec.EF_app_resilencia.service;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    public String crearPedido(String pedido){
        if (Math.random() > 0.5){
            throw new RuntimeException("Error en llamada");
        }
        return "Pedido" + pedido + "Creado con exito";
    }

    public String obtenerPedidos(){
        if (Math.random() > 0.5){
            throw new RuntimeException("Error en llamada");
        }
        return "Lista de Pedidos: Pedido 0001, Pedido 0002, Pedido 0003,.....";

    }
}
