package br.com.sig.msadmin.entrypoint;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.usecase.CadastrarViaturaUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarViaturaUseCase;
import br.com.sig.msadmin.entrypoint.entity.ViaturaHttpModel;


@RunWith(MockitoJUnitRunner.class)
public class ViaturaEntrypointTest {
    
    @InjectMocks
	private ViaturaEntrypoint entrypoint;

    @Mock
    private CadastrarViaturaUseCase CadastrarViaturaUseCase;
    
    @Mock
    private PesquisarViaturaUseCase PesquisarViaturaUseCase;

    private ViaturaEntity viatura = ViaturaEntity.builder()
                                                 .ano(2010)
                                                 .placa("API-7777")
                                                 .fabricante("Ford")
                                                 .quilometragem_atual(2000)
                                                 .quilometragem_inicial(1000)
                                                 .build();

    private ViaturaHttpModel httpModel = ViaturaHttpModel.builder()
                                                         .ano(2010)
                                                         .placa("API-7777")
                                                         .fabricante("Ford")
                                                         .quilometragem_atual(2000)
                                                         .quilometragem_inicial(1000)
                                                         .build();

    @Test
	public void cadastrarViaturaEntrypoint_success() {

		Mockito.when(CadastrarViaturaUseCase.cadastrarViatura(Mockito.any(ViaturaEntity.class))).thenReturn(viatura);
		
		ResponseEntity<ViaturaHttpModel> response = entrypoint.cadastrarViatura(httpModel);
		
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());	
		
    }
    
    @Test
	public void pesquisarViaturaEntrypoint_success() {

		List<ViaturaEntity> listEntity = new ArrayList<>();
		listEntity.add(viatura);
		
		Mockito.when(PesquisarViaturaUseCase.pesquisarViatura()).thenReturn(listEntity);
		
		ResponseEntity<List<ViaturaHttpModel>> listResponse = entrypoint.pesquisarViatura();
		
		Assert.assertEquals(HttpStatus.OK, listResponse.getStatusCode());
	}
}