package br.com.sig.msadmin.core.gateway;

import java.util.List;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;

public interface PerfilEquipeGateway {

	PerfilEquipeEntity cadastrarPerfilEquipe(PerfilEquipeEntity entity);
	
	List<PerfilEquipeEntity> pesquisarPerfilEquipe();
	
}
