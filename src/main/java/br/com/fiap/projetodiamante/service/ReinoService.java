package br.com.fiap.projetodiamante.service;

import br.com.fiap.projetodiamante.model.Reino;
import br.com.fiap.projetodiamante.repository.ReinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReinoService {

    private final ReinoRepository reinoRepository;

    public ReinoService(ReinoRepository reinoRepository) {
        this.reinoRepository = reinoRepository;
    }

    public List<Reino> listarTodos() {
        return reinoRepository.findAll();
    }

    public Optional<Reino> buscarPorId(Long id) {
        return reinoRepository.findById(id);
    }

    public Reino salvar(Reino reino) {
        return reinoRepository.save(reino);
    }

    public Optional<Reino> atualizar(Long id, Reino reinoAtualizado) {
        return reinoRepository.findById(id).map(reino -> {
            reino.setNome(reinoAtualizado.getNome());
            reino.setRegiao(reinoAtualizado.getRegiao());
            reino.setQuantidadeCastelos(reinoAtualizado.getQuantidadeCastelos());
            reino.setReinoAliado(reinoAtualizado.getReinoAliado());
            return reinoRepository.save(reino);
        });
    }

    public boolean deletar(Long id) {
        Optional<Reino> reino = reinoRepository.findById(id);

        if (reino.isEmpty()) {
            return false;
        }

        reinoRepository.deleteById(id);
        return true;
    }
}
