package br.com.sig.msadmin.core.gateway;

import br.com.sig.msadmin.core.entity.ClienteEntity;

public interface ClienteGateway {

	ClienteEntity cadastrarCliente(ClienteEntity entity);
	
}