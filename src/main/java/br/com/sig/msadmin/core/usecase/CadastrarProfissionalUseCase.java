package br.com.sig.msadmin.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.EnderecoEntity;
import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.gateway.ConsultaCepGateway;
import br.com.sig.msadmin.core.gateway.ProfissionalGateway;

@Component
public class CadastrarProfissionalUseCase {
	
	@Autowired
	private ProfissionalGateway profissionalGateway;
	
	@Autowired
	private ConsultaCepGateway consultaCepGateway;

	public ProfissionalEntity cadastrarProfissional(ProfissionalEntity entity, String cep) {
		
		// TODO lógica da regra de negócio 
		EnderecoEntity endereco = consultaCepGateway.consultaViaCep(cep);
		
		return profissionalGateway.cadastrarProfissional(entity);
	}

}
