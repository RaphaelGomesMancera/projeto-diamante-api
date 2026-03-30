package br.com.fiap.projetodiamante.service;

import br.com.fiap.projetodiamante.model.Dragon;
import br.com.fiap.projetodiamante.model.Reino;
import br.com.fiap.projetodiamante.repository.DragonRepository;
import br.com.fiap.projetodiamante.repository.ReinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DragonService {

    private final DragonRepository dragonRepository;
    private final ReinoRepository reinoRepository;

    public DragonService(DragonRepository dragonRepository, ReinoRepository reinoRepository) {
        this.dragonRepository = dragonRepository;
        this.reinoRepository = reinoRepository;
    }

    public List<Dragon> listarTodos() {
        return dragonRepository.findAll();
    }

    public Optional<Dragon> buscarPorId(Long id) {
        return dragonRepository.findById(id);
    }

    public Dragon salvar(Dragon dragon) {
        associarReinoSeExistir(dragon);
        return dragonRepository.save(dragon);
    }

    public Optional<Dragon> atualizar(Long id, Dragon dragonAtualizado) {
        return dragonRepository.findById(id).map(dragon -> {
            dragon.setNome(dragonAtualizado.getNome());
            dragon.setCor(dragonAtualizado.getCor());
            dragon.setPoderDeFogo(dragonAtualizado.getPoderDeFogo());
            dragon.setPeso(dragonAtualizado.getPeso());
            dragon.setAltura(dragonAtualizado.getAltura());
            dragon.setPossuiMontador(dragonAtualizado.getPossuiMontador());
            dragon.setReino(buscarReinoValido(dragonAtualizado.getReino()));
            return dragonRepository.save(dragon);
        });
    }

    public boolean deletar(Long id) {
        Optional<Dragon> dragon = dragonRepository.findById(id);

        if (dragon.isEmpty()) {
            return false;
        }

        dragonRepository.deleteById(id);
        return true;
    }

    private void associarReinoSeExistir(Dragon dragon) {
        dragon.setReino(buscarReinoValido(dragon.getReino()));
    }

    private Reino buscarReinoValido(Reino reino) {
        if (reino == null || reino.getId() == null) {
            return null;
        }

        return reinoRepository.findById(reino.getId()).orElse(null);
    }
}
