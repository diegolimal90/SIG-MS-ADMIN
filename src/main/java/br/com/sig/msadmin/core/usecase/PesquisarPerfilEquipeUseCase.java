package br.com.sig.msadmin.core.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.core.gateway.PerfilEquipeGateway;

@Component
public class PesquisarPerfilEquipeUseCase {

	@Autowired
	private PerfilEquipeGateway gateway;
	
	public List<PerfilEquipeEntity> pesquisarEquipe(){
		return gateway.pesquisarPerfil();
	}
	
}
