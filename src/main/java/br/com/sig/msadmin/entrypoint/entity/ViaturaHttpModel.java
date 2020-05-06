package br.com.sig.msadmin.entrypoint.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViaturaHttpModel{
    
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
		
		//private tb_seg_usuario id_usuario_gravacao;
	    
		private	Date dt_gravacao_viatura;
		private Date dt_alt_viatura;
	    
		//private tb_seg_usuario seg_id_usuario;
		
		/*	private Date dataAlteracao;
			private Date dataDesativacao;
			private Long idCadastro;
			private Long idAlteracao;
			private Long idDesativacao;
			*/
}