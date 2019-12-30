package br.com.sig.msadmin.core.usecase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.dataprovider.PerfilEquipeDataProvider;

@RunWith(MockitoJUnitRunner.class)
public class PesquisarPerfilEquipeUseCaseTest {

	@InjectMocks 
    private PesquisarPerfilEquipeUseCase useCase;
    
	@Mock
    private PerfilEquipeDataProvider dataProvider;
         
    @Test
    public void PesquisarPerfilEquipeUseCase_success(){
    	PerfilEquipeEntity entity = PerfilEquipeEntity.builder()
    			.id(1L)
    			.nome("Teste de perfil de equipe")
    			.sigla("PEQ")
    			.veiculoId(2L)
    			.profissionaisId(3L)
    			.descricaoEquipamentos("Teste de cadastrar perfil de equipe")
    			.qtEquipamento(2)
    			.idCadastro(1L)
    			.build();
    	
    	List<PerfilEquipeEntity> list = new ArrayList<>();
    	list.add(entity);
    	
        Mockito.when(dataProvider.pesquisarPerfilEquipe()).thenReturn(list);
        
        List<PerfilEquipeEntity> response = useCase.pesquisarPerfilEquipe();

        Assert.assertEquals(list, response);

    }

}