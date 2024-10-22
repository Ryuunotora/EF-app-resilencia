package pe.edu.cibertec.EF_app_resilencia.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.EF_app_resilencia.service.PedidoService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/test")
public class PedidoController {

    private final PedidoService pedidoService;

    @GetMapping("/crear")
    @CircuitBreaker(name = "myService", fallbackMethod = "errorService")
    public String crearPedido(@RequestParam String pedido){
        return pedidoService.crearPedido(pedido);
    }

    @GetMapping("/listar")
    @CircuitBreaker(name = "myService", fallbackMethod = "errorService")
    public String listaPedidos(){
        return pedidoService.obtenerPedidos();
    }

    public String errorService(Throwable throwable){
        return "Servicio temporalmente no disponible. Intentalo de Nuevo";
    }

}
