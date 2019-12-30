package br.com.sig.msadmin.entrypoint;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.usecase.CadastrarViaturaUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarViaturaUseCase;
import br.com.sig.msadmin.entrypoint.entity.ViaturaHttpModel;
import br.com.sig.msadmin.entrypoint.mapper.ViaturaHttpModelMapper;

@RestController
@RequestMapping(value = "/viaturas")
public class ViaturaEntrypoint{
    @Autowired
    private CadastrarViaturaUseCase cadastrarViaturaUseCase;

    @Autowired
    private PesquisarViaturaUseCase pesquisarViaturaUseCase;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<ViaturaHttpModel> cadastrarViatura(@RequestBody ViaturaHttpModel httpModel){
        ViaturaEntity entity = ViaturaHttpModelMapper.to(httpModel);
        entity = cadastrarViaturaUseCase.cadastrarViatura(entity);
        ViaturaHttpModel response = ViaturaHttpModelMapper.from(entity);

        URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(response.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ViaturaHttpModel>> pesquisarViatura(){
        List<ViaturaEntity> listEntity = pesquisarViaturaUseCase.pesquisarViatura();
        List<ViaturaHttpModel> listResponse = new ArrayList<>();

        for(ViaturaEntity entity: listEntity){
            listResponse.add(ViaturaHttpModelMapper.from(entity));
        }

        return ResponseEntity.ok().body(listResponse);
    }
}