package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.gateway.UnidadeGateway;

@Component
public class CadastrarUnidadeUseCase {

	@Autowired
	private UnidadeGateway gateway;
	
	public UnidadeEntity cadastrarUnidade(UnidadeEntity entity){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		entity.setDataCadastro(timestamp);
		
		entity.setStatus(1);
		
		
		return gateway.salvarUnidade(entity);
	}
}
