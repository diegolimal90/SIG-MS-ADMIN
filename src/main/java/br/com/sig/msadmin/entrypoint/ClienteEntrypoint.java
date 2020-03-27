package br.com.sig.msadmin.entrypoint;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.usecase.CadastrarClienteUseCase;
import br.com.sig.msadmin.entrypoint.entity.ClienteHttpModel;
import br.com.sig.msadmin.entrypoint.mapper.ClienteHttpModelMapper;

@RestController
@RequestMapping(value="/clientes")
public class ClienteEntrypoint {
	
	@Autowired
	private CadastrarClienteUseCase cadastrarClienteUseCase;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<ClienteHttpModel> cadastrarCliente(@RequestBody ClienteHttpModel httpModel){
		ClienteEntity entity = ClienteHttpModelMapper.to(httpModel);
		entity = cadastrarClienteUseCase.cadastrarCliente(entity);
		ClienteHttpModel response = ClienteHttpModelMapper.from(entity);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(response.getId())
                .toUri();
                
		return ResponseEntity.created(uri).build();
	}
}