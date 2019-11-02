package br.com.sig.msadmin.core.gateway;

import javax.naming.ServiceUnavailableException;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;

public interface ProfissionalGateway {

	ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity)  throws ServiceUnavailableException;
}
