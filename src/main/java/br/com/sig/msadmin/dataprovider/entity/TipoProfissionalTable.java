package br.com.sig.msadmin.dataprovider.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name="tbl_tipo_profissional")
public class TipoProfissionalTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nmProfissao;
	private String nrDocumento;
	private LocalDate dtValidadeDocumento;
	private String dsCategoriaCnh;
	private String dsCursoObrigatorio;
	private LocalDate dtValidadeCurso;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="id_especialidade")
	private EspecialidadeProfissionalTable especialidade;
	
	@JsonBackReference
	@OneToMany(mappedBy="tpProfissional")
	private List<ProfissionalTable> profissionais;
}
