package br.com.sig.msadmin.core.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.gateway.UnidadeGateway;

@Component
public class PesquisarUnidadeUseCase {

	@Autowired
	private UnidadeGateway gateway;
	
	public List<UnidadeEntity> pesquisarUnidades(){
		return gateway.pesquisarUnidades();
	}
}