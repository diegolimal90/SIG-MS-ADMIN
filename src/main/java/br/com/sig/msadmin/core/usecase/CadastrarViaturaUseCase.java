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

	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	public ViaturaEntity cadastrarViatura(ViaturaEntity entity){
		entity.setDataCadastro(timestamp);
		
		return gateway.salvarViatura(entity);
	}
}
