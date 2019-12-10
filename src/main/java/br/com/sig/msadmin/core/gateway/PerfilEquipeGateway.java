package br.com.sig.msadmin.core.gateway;

import java.util.List;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;

public interface PerfilEquipeGateway {

	PerfilEquipeEntity salvarPerfil(PerfilEquipeEntity entity) throws RuntimeException;
	
	List<PerfilEquipeEntity> pesquisarPerfil();
	
}
