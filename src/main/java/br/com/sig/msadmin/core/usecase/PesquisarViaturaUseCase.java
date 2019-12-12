package br.com.sig.msadmin.core.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.gateway.ViaturaGateway;

@Component
public class PesquisarViaturaUseCase {

	@Autowired
	private ViaturaGateway gateway;
	
	public List<ViaturaEntity> pesquisarViatura(){
		return gateway.pesquisarViatura();
	}
}