package com.viloes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.viloes.entities.Vilao;

public interface VilaoRepository extends JpaRepository<Vilao, Long> {
	
	 boolean existsByNomeVilaoIgnoreCaseAndFranquiaObraIgnoreCase(
	            String nomeVilao,
	            String franquiaObra
	    );
	 
	  boolean existsByNomeVilaoIgnoreCaseAndFranquiaObraIgnoreCaseAndIdVilaoNot(
	            String nomeVilao,
	            String franquiaObra,
	            Long idVilao
	    );


}
