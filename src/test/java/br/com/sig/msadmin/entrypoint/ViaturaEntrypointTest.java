package br.com.sig.msadmin.entrypoint;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.usecase.CadastrarViaturaUseCase;
import br.com.sig.msadmin.entrypoint.entity.ViaturaHttpModel;


// @RunWith(SpringRunner.class)
// @WebMvcTest(ViaturaEntrypoint.class)
@RunWith(MockitoJUnitRunner.class)
public class ViaturaEntrypointTest {
    
    @InjectMocks
	private ViaturaEntrypoint entrypoint;

    @Mock
    private CadastrarViaturaUseCase useCase;
    
    // @Autowired
    // private MockMvc mockMvc;

    // private String json = "{'ano': 2013, 'placa': 'API-8133', 'fabricante': 'Ford', 'quilometragem_atual': 1800, 'quilometragem_inicial': 1000 }";
    
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
	public void cadastrarUnidadeEntrypoint_success() {
		
		Mockito.when(useCase.cadastrarViatura(Mockito.any(ViaturaEntity.class))).thenReturn(viatura);
		
		ResponseEntity<ViaturaHttpModel> response = entrypoint.cadastrarViatura(httpModel);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());	
		
    }
    
    // @Test
    // public void cadastrarUnidadeEntrypoint_exception(){
    //     Mockito.when(useCase.cadastrarViatura(Mockito.any(ViaturaEntity.class))).thenReturn(viatura);
	// 	System.out.println("Viatura: " + viatura);
    //     ResponseEntity<ViaturaHttpModel> response = entrypoint.cadastrarViatura(httpModel);
    //     System.out.println("Response: " + response);
	// 	Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());	
    // }

    // @Test
    // public void CadastrarViaturaEntrypoint_alternative() throws Exception {
    //     System.out.println(httpModel);
    //     mockMvc.perform( MockMvcRequestBuilders
    //         .post("/viaturas")
    //         .content(asJsonString(httpModel))
    //         .contentType(MediaType.APPLICATION_JSON)
    //         .accept(MediaType.APPLICATION_JSON))
    //         .andReturn();
    // }
    
    // public static String asJsonString(final Object obj) {
    //     try {
    //         return new ObjectMapper().writeValueAsString(obj);
    //     } catch (Exception e) {
    //         throw new RuntimeException(e);
    //     }
    // }
}