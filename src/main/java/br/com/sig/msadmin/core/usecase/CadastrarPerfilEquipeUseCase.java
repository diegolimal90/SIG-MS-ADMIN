package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.core.gateway.PerfilEquipeGateway;

@Component
public class CadastrarPerfilEquipeUseCase {

	@Autowired
	private PerfilEquipeGateway gateway;
	
	public PerfilEquipeEntity cadastrarPerfilEquipe(PerfilEquipeEntity entity){		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		entity.setDataCadastro(timestamp);
		return gateway.cadastrarPerfilEquipe(entity);
	}
	
}
