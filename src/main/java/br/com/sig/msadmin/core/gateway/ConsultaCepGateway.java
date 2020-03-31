package br.com.sig.msadmin.core.gateway;

import br.com.sig.msadmin.core.entity.EnderecoEntity;

public interface ConsultaCepGateway {
	
	EnderecoEntity consultaViaCep(String cep);
}
