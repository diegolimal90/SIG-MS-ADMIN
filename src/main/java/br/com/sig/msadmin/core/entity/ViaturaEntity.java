package br.com.sig.msadmin.core.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaturaEntity{

    private Long id_viatura;
    private Date dt_cadastro_viatura;
    private String cd_identificacao_viatura;
    private String cd_placa_viatura;
    private int ano_viatura; 
    private String ds_fabricante;
    private Date dt_km_inicial;
    private int nr_km_inicial;
    private Date dt_km_final;
    private int nr_km_final;
    private String ds_viatura;
	private String ds_observacao;
		
   // private SegUsuarioEntity usuario_gravacao;
    
	private	Date dt_gravacao_viatura;
	private Date dt_alt_viatura;
    
	//private SegUsuarioEntity usuario;
	
	//	private Date dataDesativacao;
	//	private Long idCadastro;
	//	private Long idAlteracao;
	//	private Long idDesativacao;
    
    
    
    
    
    
    

     
}