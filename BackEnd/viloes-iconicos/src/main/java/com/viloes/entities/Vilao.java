package com.viloes.entities;

import com.viloes.enums.NivelAmeaca;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_vilão")
public class Vilao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVilao;
	
	@NotBlank(message = "O Nome Do Vilão É Obrigatório.")
	private String nomeVilao;
	
	@NotBlank(message = "A Franquia / Obra É Obrigatória.")
	private String franquiaObra;
	
	@NotNull(message = "O Nível De Ameaça É Obrigatório.")
	@Enumerated(EnumType.STRING)
	private NivelAmeaca nivelAmeaca;
	
	@NotNull (message = "Informe Se O Vilão Possui Superpoderes.")
	private Boolean possuiSuperpoderes;
	
	public Vilao() {}
	
	public Vilao (String nomeVilao, String franquiaObra, NivelAmeaca nivelAmeaca, Boolean possuiSuperpoderes) {
		this.nomeVilao = nomeVilao;
		this.franquiaObra = franquiaObra;
		this.nivelAmeaca = nivelAmeaca;
		this.possuiSuperpoderes = possuiSuperpoderes;
	}

	public Long getIdVilao() {
		return idVilao;
	}

	public void setIdVilao(Long idVilao) {
		this.idVilao = idVilao;
	}

	public String getNomeVilao() {
		return nomeVilao;
	}

	public void setNomeVilao(String nomeVilao) {
		this.nomeVilao = nomeVilao;
	}

	public String getFranquiaObra() {
		return franquiaObra;
	}

	public void setFranquiaObra(String franquiaObra) {
		this.franquiaObra = franquiaObra;
	}

	public NivelAmeaca getNivelAmeaca() {
		return nivelAmeaca;
	}

	public void setNivelAmeaca(NivelAmeaca nivelAmeaca) {
		this.nivelAmeaca = nivelAmeaca;
	}

	public Boolean getPossuiSuperpoderes() {
		return possuiSuperpoderes;
	}

	public void setPossuiSuperpoderes(Boolean possuiSuperpoderes) {
		this.possuiSuperpoderes = possuiSuperpoderes;
	}
	
	

	
}
