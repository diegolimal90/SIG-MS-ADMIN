package br.com.sig.msadmin.entrypoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.usecase.CadastrarUnidadeUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarUnidadeUseCase;
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;
import br.com.sig.msadmin.entrypoint.mapper.UnidadeHttpModelMapper;

@RestController
@RequestMapping(value="/unidades")
public class UnidadeEntrypoint {
	
	@Autowired
	private CadastrarUnidadeUseCase cadastrarUnidadeUseCase;
	
	@Autowired
	private PesquisarUnidadeUseCase buscarUnidadeUseCase;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<UnidadeHttpModel> cadastrarUnidade(@RequestBody UnidadeHttpModel httpModel){
		UnidadeEntity entity = UnidadeHttpModelMapper.to(httpModel);
		entity = cadastrarUnidadeUseCase.cadastrarUnidade(entity);
		UnidadeHttpModel response = UnidadeHttpModelMapper.from(entity);
		
		return ResponseEntity.ok().body(response);
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ResponseEntity<List<UnidadeHttpModel>> pesquisarUnidades(){
		List<UnidadeEntity> listEntity = buscarUnidadeUseCase.pesquisarUnidades();
		List<UnidadeHttpModel> listResponse = new ArrayList<>();
		
		for(UnidadeEntity entity : listEntity) {
			listResponse.add(UnidadeHttpModelMapper.from(entity));
		}
		
		return ResponseEntity.ok().body(listResponse);
	}
}