package br.com.sig.msadmin.core.gateway;

import br.com.sig.msadmin.core.entity.UnidadeEntity;

public interface UnidadeGateway {

	UnidadeEntity salvarUnidade(UnidadeEntity entity) throws RuntimeException;
}
