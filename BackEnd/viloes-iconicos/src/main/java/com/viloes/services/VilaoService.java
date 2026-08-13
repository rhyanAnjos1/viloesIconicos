package com.viloes.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.viloes.entities.Vilao;
import com.viloes.enums.NivelAmeaca;
import com.viloes.repository.VilaoRepository;

@Service
public class VilaoService {

    private final VilaoRepository repository;

    VilaoService(VilaoRepository repository) {
        this.repository = repository;
    }

    public List<Vilao> listarTodos() {
        return repository.findAll();
    }

    public Vilao buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Vilao salvar(Vilao vilao) {

        if (vilao.getPossuiSuperpoderes() == null) {
            throw new RuntimeException(
                    "O campo Possui Superpoderes é obrigatório."
            );
        }

        if (vilao.getNivelAmeaca() == NivelAmeaca.UNIVERSO
                && !vilao.getPossuiSuperpoderes()) {

            throw new RuntimeException(
                    "Vilões com nível de ameaça UNIVERSO devem obrigatoriamente possuir superpoderes."
            );
        }

        boolean duplicado =
                repository.existsByNomeVilaoIgnoreCaseAndFranquiaObraIgnoreCase(
                        vilao.getNomeVilao(),
                        vilao.getFranquiaObra()
                );

        if (duplicado) {
            throw new RuntimeException(
                    "Já existe um vilão com este nome na mesma franquia/obra."
            );
        }

        return repository.save(vilao);
    }

    public Vilao atualizar(Long id, Vilao vilaoAtualizado) {

        Vilao vilaoAntigo = repository.findById(id).orElse(null);

        if (vilaoAntigo == null) {
            return null;
        }

        if (vilaoAtualizado.getPossuiSuperpoderes() == null) {
            throw new RuntimeException(
                    "O campo Possui Superpoderes é obrigatório."
            );
        }

        if (vilaoAtualizado.getNivelAmeaca() == NivelAmeaca.UNIVERSO
                && !vilaoAtualizado.getPossuiSuperpoderes()) {

            throw new RuntimeException(
                    "Vilões com nível de ameaça UNIVERSO devem obrigatoriamente possuir superpoderes."
            );
        }

        boolean duplicado =
                repository.existsByNomeVilaoIgnoreCaseAndFranquiaObraIgnoreCaseAndIdVilaoNot(
                        vilaoAtualizado.getNomeVilao(),
                        vilaoAtualizado.getFranquiaObra(),
                        id
                );

        if (duplicado) {
            throw new RuntimeException(
                    "Já existe outro vilão com este nome na mesma franquia/obra."
            );
        }

        vilaoAntigo.setNomeVilao(vilaoAtualizado.getNomeVilao());
        vilaoAntigo.setFranquiaObra(vilaoAtualizado.getFranquiaObra());
        vilaoAntigo.setNivelAmeaca(vilaoAtualizado.getNivelAmeaca());
        vilaoAntigo.setPossuiSuperpoderes(
                vilaoAtualizado.getPossuiSuperpoderes()
        );

        return repository.save(vilaoAntigo);
    }

    public boolean deletar(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }

        return false;
    }
}