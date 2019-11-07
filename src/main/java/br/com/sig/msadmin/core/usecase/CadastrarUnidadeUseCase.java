package br.com.sig.msadmin.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.gateway.UnidadeGateway;

@Component
public class CadastrarUnidadeUseCase {

	@Autowired
	private UnidadeGateway gateway;
	
	public UnidadeEntity cadastrarUnidade(UnidadeEntity entity){
		return gateway.salvarUnidade(entity);
	}
}
