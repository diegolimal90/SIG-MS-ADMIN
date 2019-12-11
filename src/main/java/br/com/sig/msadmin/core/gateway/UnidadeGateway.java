package br.com.sig.msadmin.core.gateway;

import java.util.List;

import br.com.sig.msadmin.core.entity.UnidadeEntity;

public interface UnidadeGateway {

	UnidadeEntity salvarUnidade(UnidadeEntity entity);
	
	List<UnidadeEntity> pesquisarUnidades();
}