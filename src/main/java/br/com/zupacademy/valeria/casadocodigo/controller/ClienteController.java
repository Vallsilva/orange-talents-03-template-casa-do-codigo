package br.com.zupacademy.valeria.casadocodigo.controller;

import br.com.zupacademy.valeria.casadocodigo.controller.request.ClienteRequest;
import br.com.zupacademy.valeria.casadocodigo.controller.response.ClienteResponse;
import br.com.zupacademy.valeria.casadocodigo.model.Cliente;
import br.com.zupacademy.valeria.casadocodigo.model.Estado;
import br.com.zupacademy.valeria.casadocodigo.model.Pais;
import br.com.zupacademy.valeria.casadocodigo.model.TipoPessoa;
import br.com.zupacademy.valeria.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.valeria.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.valeria.casadocodigo.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody @Valid ClienteRequest clienteRequest){

        Pais pais = paisRepository.findById(clienteRequest.getPaisId()).get();
        Estado estado = estadoRepository.findById(clienteRequest.getEstadoId()).get();


        if(clienteRequest.getDocumento().length()==11){
            TipoPessoa tipoPessoa = TipoPessoa.FISICA;
            Cliente cliente = clienteRequest.converter(tipoPessoa, estado, pais);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        } else if (clienteRequest.getDocumento().length() == 14){
            TipoPessoa tipoPessoa = TipoPessoa.JURIDICA;
            Cliente cliente = clienteRequest.converter(tipoPessoa, estado, pais);
            clienteRepository.save(cliente);
            return ResponseEntity.ok(cliente);
        }
        else return ResponseEntity.badRequest().build();
    }
}
