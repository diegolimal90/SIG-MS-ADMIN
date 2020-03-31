package br.com.sig.msadmin.core.usecase;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.dataprovider.ProfissionalDataProvider;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarProfissionalUseCaseTest {
	
	@InjectMocks
    private CadastrarProfissionalUseCase cadastrarProfissionalUseCase;

	@Mock
	private ProfissionalDataProvider profissionalDataProvider;
    
    @Test
    public void CadastrarPerfilEquipeUseCase_success(){
    	
    	ProfissionalEntity entity = ProfissionalEntity.builder()
    			.nmProfissional("Fulano de Teste")
    			.build();
    	
    	ProfissionalEntity entitySaved = ProfissionalEntity.builder()
    			.id(1L)
    			.nmProfissional("Fulano de Teste")
    			.build();
    	
    	String cep = "01001000";
    	
        Mockito.when(profissionalDataProvider.cadastrarProfissional(Mockito.any(ProfissionalEntity.class))).thenReturn(entitySaved);
        
        ProfissionalEntity response = cadastrarProfissionalUseCase.cadastrarProfissional(entity,cep);

        Assert.assertThat(response.getId(), Matchers.comparesEqualTo(1L));

    }

}
