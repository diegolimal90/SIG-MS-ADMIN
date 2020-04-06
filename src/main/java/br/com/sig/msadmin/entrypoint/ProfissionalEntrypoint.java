package br.com.sig.msadmin.entrypoint;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.usecase.CadastrarProfissionalUseCase;
import br.com.sig.msadmin.entrypoint.entity.PerfilEquipeHttpModel;
import br.com.sig.msadmin.entrypoint.entity.ProfissionalHttpModel;
import br.com.sig.msadmin.entrypoint.mapper.ProfissionalHttpModelMapper;

@RestController
@RequestMapping(value="/profissional")
public class ProfissionalEntrypoint {
	
	@Autowired
	private CadastrarProfissionalUseCase cadastrarProfissionalUseCase;
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public ResponseEntity<PerfilEquipeHttpModel> cadastrarPerfilEquipe(@RequestBody ProfissionalHttpModel httpModel){
		
		ProfissionalEntity entity = ProfissionalHttpModelMapper.to(httpModel);
		entity = cadastrarProfissionalUseCase.cadastrarProfissional(entity);
		ProfissionalHttpModel response = ProfissionalHttpModelMapper.from(entity);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(response.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
}
