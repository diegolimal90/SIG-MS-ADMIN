package br.com.sig.msadmin.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.core.gateway.PerfilEquipeGateway;

@Component
public class CadastrarPerfilEquipeUseCase {

	@Autowired
	private PerfilEquipeGateway gateway;
	
	public PerfilEquipeEntity cadastrarPerfilEqupe(PerfilEquipeEntity entity){
		
		
		return gateway.salvarPerfil(entity);
	}
	
}
