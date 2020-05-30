package br.com.sig.msadmin.core.gateway;

import java.util.List;

import br.com.sig.msadmin.core.entity.EnderecoEntity;

public interface EnderecoGateway {
	EnderecoEntity cadastrarEndereco(EnderecoEntity entity);

	List<EnderecoEntity> buscarEndereco(String cep);
}
