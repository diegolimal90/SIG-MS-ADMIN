package br.com.sig.msadmin.entrypoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.core.usecase.CadastrarPerfilEquipeUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarPerfilEquipeUseCase;
import br.com.sig.msadmin.entrypoint.entity.PerfilEquipeHttpModel;
import br.com.sig.msadmin.entrypoint.mapper.PerfilEquipeHttpModelMapper;

@RestController
@RequestMapping(value="/perfilequipes")
public class PerfilEquipeEntrypoint {
	
	@Autowired
	private CadastrarPerfilEquipeUseCase cadastrarPerfilEquipeUseCase;
	
	@Autowired
	private PesquisarPerfilEquipeUseCase pesquisarPerfilEquipeUseCase;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<PerfilEquipeHttpModel> cadastrarPerfilEquipe(@RequestBody PerfilEquipeHttpModel httpModel){
		PerfilEquipeEntity entity = PerfilEquipeHttpModelMapper.to(httpModel);
		entity = cadastrarPerfilEquipeUseCase.cadastrarPerfilEqupe(entity);
		PerfilEquipeHttpModel response = PerfilEquipeHttpModelMapper.from(entity);
			
		return ResponseEntity.ok().body(response);
		
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<List<PerfilEquipeHttpModel>> pesquisarPerfilEquipe(){
		List<PerfilEquipeEntity> listEntity = pesquisarPerfilEquipeUseCase.pesquisarEquipe();
		List<PerfilEquipeHttpModel> listResponse = new ArrayList<>();
		
		for(PerfilEquipeEntity entity: listEntity) {
			listResponse.add(PerfilEquipeHttpModelMapper.from(entity));
		}
		
		return ResponseEntity.ok().body(listResponse);
		
	}
	
}
