package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CadastrarPerfilEquipeUseCaseTest {
	
	@Mock
    private CadastrarPerfilEquipeUseCase useCase;
       
	private Date date = new Date();

    PerfilEquipeEntity PerfilEquipe = PerfilEquipeEntity.builder()
			.id(1L)
			.nome("Teste de perfil de equipe")
			.sigla("PEQ")
			.veiculoId(2L)
			.profissionaisId(3L)
			.descricaoEquipamentos("Teste de cadastrar perfil de equipe")
			.qtEquipamento(2)
			.dataCadastro(date)
			.idCadastro(1L)
			.build();

    PerfilEquipeEntity PerfilEquipeModelo = PerfilEquipeEntity.builder()
			.id(1L)
			.nome("Teste de perfil de equipe")
			.sigla("PEQ")
			.veiculoId(2L)
			.profissionaisId(3L)
			.descricaoEquipamentos("Teste de cadastrar perfil de equipe")
			.qtEquipamento(2)
			.dataCadastro(date)
			.idCadastro(1L)
			.build();
    
    @Test
    public void CadastrarPerfilEquipeUseCase_success(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PerfilEquipeModelo.setDataCadastro(timestamp);

        Mockito.when(useCase.cadastrarPerfilEquipe(Mockito.any(PerfilEquipeEntity.class))).thenReturn(PerfilEquipeModelo);
        
        PerfilEquipeEntity response = useCase.cadastrarPerfilEquipe(PerfilEquipe);

        Assert.assertNotEquals(PerfilEquipe, response);

    }

    @Test(expected = NullPointerException.class)
    public void CadastrarPerfilEquipeUseCase_exception(){
        PerfilEquipeEntity vazio = PerfilEquipeEntity.builder().build();

        Mockito.doThrow(new NullPointerException("Entidade vazia")).when(useCase).cadastrarPerfilEquipe(Mockito.any(PerfilEquipeEntity.class));

        PerfilEquipeEntity teste = useCase.cadastrarPerfilEquipe(vazio);
    }

}
