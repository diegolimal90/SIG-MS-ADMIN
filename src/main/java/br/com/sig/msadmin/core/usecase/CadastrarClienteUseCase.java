package br.com.sig.msadmin.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.gateway.ClienteGateway;

@Component
public class CadastrarClienteUseCase {

   @Autowired
	private ClienteGateway gateway;

	public ClienteEntity cadastrarCliente(ClienteEntity entity){		
		return gateway.cadastrarCliente(entity);
	}
}