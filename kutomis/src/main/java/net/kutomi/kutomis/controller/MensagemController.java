package net.kutomi.kutomis.controller;

import jakarta.validation.Valid;
import net.kutomi.kutomis.dtos.EdicaoMensagem;
import net.kutomi.kutomis.dtos.MensagemDTO;
import net.kutomi.kutomis.dtos.MensagemSimplesDTO;
import net.kutomi.kutomis.model.Mensagem;
import net.kutomi.kutomis.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/mensagem")
@RestController
public class MensagemController {

    @Autowired
    private MensagemRepository repository;

    @PostMapping
    @Transactional
    public void recebeMensagem(@RequestBody @Valid MensagemDTO mensagem) {
        repository.save(new Mensagem(mensagem));
        //repository.save(new Mensagem(null, mensagem.idUsuario(), mensagem.mensagem(), mensagem.tipoMensagem()));
        System.out.println(mensagem);
    }
//
//    @GetMapping("/{mensagemId}")
//    @Transactional
//    public Mensagem buscaMensagem(@RequestParam(name = "mensagemId") Long mensagemId) {
//        return repository.findById(mensagemId);
//    }

    @GetMapping
    public List<MensagemSimplesDTO> retornaTodasMensagens() {
        return repository.
                findAll().
                stream().
                map(MensagemSimplesDTO::new).
                toList();
    }

    @GetMapping("/pages")
    public Page<MensagemSimplesDTO> retornaPaginasMensagens(@PageableDefault(size=5, sort = {"idUsuario"}) Pageable pageable) {
        return repository.
                findAll(pageable).
                map(MensagemSimplesDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizaMensagen(@RequestBody @Valid EdicaoMensagem mensagem) {
        Mensagem novaMensagem = repository.getReferenceById(mensagem.id());
        novaMensagem.setMensagem(mensagem.mensagem());
        repository.save(novaMensagem);
    }

    @DeleteMapping("/remocao-permanente/{id}")
    @Transactional
    public void apagaMensagem(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void desativaMensagem(@PathVariable Long id) {
        Mensagem msg = repository.getReferenceById(id);
        msg.setAtivo(false);
    }


}
