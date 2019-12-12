package br.com.sig.msadmin.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.gateway.ViaturaGateway;

@Component
public class CadastrarViaturaUseCase {

	@Autowired
	private ViaturaGateway gateway;
	
	public ViaturaEntity cadastrarViatura(ViaturaEntity entity){
		return gateway.salvarViatura(entity);
	}
}
