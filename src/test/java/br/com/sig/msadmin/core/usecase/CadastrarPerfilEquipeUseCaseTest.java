package br.com.sig.msadmin.core.usecase;

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
public class CadastrarPerfilEquipeUseCaseTest {
	
	@InjectMocks
    private CadastrarPerfilEquipeUseCase useCase;

	@Mock
	private PerfilEquipeDataProvider dataProvider;
	
    PerfilEquipeEntity perfilEquipe = PerfilEquipeEntity.builder()
			.id(1L)
			.nome("Teste de perfil de equipe")
			.sigla("PEQ")
			.veiculoId(2L)
			.profissionaisId(3L)
			.descricaoEquipamentos("Teste de cadastrar perfil de equipe")
			.qtEquipamento(2)
			.idCadastro(1L)
			.build();

    PerfilEquipeEntity perfilEquipeModelo = PerfilEquipeEntity.builder()
			.id(1L)
			.nome("Teste de perfil de equipe")
			.sigla("PEQ")
			.veiculoId(2L)
			.profissionaisId(3L)
			.descricaoEquipamentos("Teste de cadastrar perfil de equipe")
			.qtEquipamento(2)
			.idCadastro(1L)
			.build();
    
    @Test
    public void CadastrarPerfilEquipeUseCase_success(){

        Mockito.when(dataProvider.cadastrarPerfilEquipe(Mockito.any(PerfilEquipeEntity.class))).thenReturn(perfilEquipeModelo);
        
        PerfilEquipeEntity response = useCase.cadastrarPerfilEquipe(perfilEquipe);

        Assert.assertNotEquals(perfilEquipe, response);

    }

}
