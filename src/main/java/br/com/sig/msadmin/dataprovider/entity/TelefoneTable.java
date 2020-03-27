package br.com.sig.msadmin.dataprovider.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="tbl_telefone")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneTable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private ClienteTable cliente;
    
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="responsavel_id")
    private ResponsavelTable responsavel;

    private String telefone;

}
