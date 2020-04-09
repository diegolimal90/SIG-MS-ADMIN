package br.com.sig.msadmin.dataprovider.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="tbl_especialidade_profissional")
public class EspecialidadeProfissionalTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nomeEspecialidade;
	
	@JsonBackReference
	@OneToMany(mappedBy="especialidade")
	private List<TipoProfissionalTable> tipoProfissionais;
}
