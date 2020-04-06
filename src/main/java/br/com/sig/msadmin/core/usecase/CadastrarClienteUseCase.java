package br.com.sig.msadmin.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ClienteEntity;
import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.gateway.ClienteGateway;
import br.com.sig.msadmin.core.gateway.ConsultaCepGateway;

@Component
public class CadastrarClienteUseCase {

   @Autowired
	private ClienteGateway gateway;

	@Autowired
	private ConsultaCepGateway consultaCepGateway;

	public ClienteEntity cadastrarCliente(ClienteEntity entity){	
		
		//TODO fazer a logica para persistencia do cliente e o endereço
//		EnderecoEntity endereco = consultaCepGateway.consultaViaCep();
		
		return gateway.cadastrarCliente(entity);
	}
}