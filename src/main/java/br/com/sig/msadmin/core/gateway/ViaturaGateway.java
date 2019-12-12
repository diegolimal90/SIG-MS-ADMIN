package br.com.sig.msadmin.core.gateway;

import java.util.List;

import br.com.sig.msadmin.core.entity.ViaturaEntity;

public interface ViaturaGateway {

	ViaturaEntity salvarViatura(ViaturaEntity entity);
	
	List<ViaturaEntity> pesquisarViatura();
	
}
