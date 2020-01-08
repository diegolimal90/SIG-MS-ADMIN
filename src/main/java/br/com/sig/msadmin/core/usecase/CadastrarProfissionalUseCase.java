package br.com.sig.msadmin.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.gateway.ProfissionalGateway;

@Component
public class CadastrarProfissionalUseCase {
	
	@Autowired
	private ProfissionalGateway profissionalGateway;

	public ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity) {
		return profissionalGateway.cadastrarProfissional(entity);
	}

}
