package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.gateway.ViaturaGateway;

@Component
public class CadastrarViaturaUseCase {

	@Autowired
	private ViaturaGateway gateway;
	
	public ViaturaEntity cadastrarViatura(ViaturaEntity entity){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		entity.setDataCadastro(timestamp);
		
		return gateway.salvarViatura(entity);
	}
}
