package br.com.sig.msadmin.entrypoint.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadoHttpModel implements Serializable{
	private static final long serialVersionUID = 8641420559747293848L;
	
	private Long id;
	private String nmEstado;
	private String sgEstado;

	private PaisHttpModel pais;
	
}
