package br.com.sig.msadmin.entrypoint;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.usecase.CadastrarViaturaUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarViaturaUseCase;
import br.com.sig.msadmin.entrypoint.entity.ViaturaHttpModel;


@RunWith(MockitoJUnitRunner.class)
public class ViaturaEntrypointTest {

	private MockMvc mockMvc;
	
    @InjectMocks
	private ViaturaEntrypoint entrypoint;

    @Mock
    private CadastrarViaturaUseCase CadastrarViaturaUseCase;
    
    @Mock
    private PesquisarViaturaUseCase PesquisarViaturaUseCase;

    private ViaturaEntity viatura = ViaturaEntity.builder()
    											 .ano_viatura(2010)
    											 .cd_placa_viatura("API-7777")
    											 .ds_fabricante("Ford")
    											 .nr_km_inicial(2000)
    											 .nr_km_final(2000)
                                                 .build();

    private ViaturaHttpModel httpModel = ViaturaHttpModel.builder()
    											 .ano_viatura(2010)
    											 .cd_placa_viatura("API-7777")
    											 .ds_fabricante("Ford")
    											 .nr_km_inicial(2000)
    											 .nr_km_final(2000)
                                                 .build();
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.entrypoint).build();
	}
    
    @Test
	public void cadastrarViaturaEntrypointStatusCode_201() throws JsonProcessingException, Exception  {

		Mockito.when(CadastrarViaturaUseCase.cadastrarViatura(Mockito.any(ViaturaEntity.class))).thenReturn(viatura);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.post("/viaturas/")
				.contentType(MediaType.APPLICATION_JSON)
				.content( new ObjectMapper().writeValueAsString(this.httpModel) )
				).andExpect(status().isCreated());	
    }
    
    @Test
	public void pesquisarViaturaEntrypointStatusCode_200() throws Exception  {

		List<ViaturaEntity> listEntity = new ArrayList<>();
		listEntity.add(viatura);
		
		Mockito.when(PesquisarViaturaUseCase.pesquisarViatura()).thenReturn(listEntity);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.get("/viaturas/")
				).andExpect(status().isOk());
	}
}