package br.com.sig.msadmin.entrypoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.usecase.CadastrarUnidadeUseCase;
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;
import br.com.sig.msadmin.entrypoint.mapper.UnidadeHttpModelMapper;

@RestController
@RequestMapping(value="/unidades")
public class CadastrarUnidadeEntrypoint {
	
	@Autowired
	private CadastrarUnidadeUseCase useCase;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<UnidadeHttpModel> cadastrarUnidade(@RequestBody UnidadeHttpModel httpModel){
		UnidadeEntity entity = UnidadeHttpModelMapper.to(httpModel);
		entity = useCase.cadastrarUnidade(entity);
		UnidadeHttpModel response = UnidadeHttpModelMapper.from(entity);
		
		return ResponseEntity.ok().body(response);
	}
}
