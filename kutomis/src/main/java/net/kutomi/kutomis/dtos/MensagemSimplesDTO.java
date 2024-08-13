package net.kutomi.kutomis.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.kutomi.kutomis.model.Mensagem;

public record MensagemSimplesDTO(
        @NotNull
        Integer idUsuario,

        @NotNull
        @NotBlank
        String mensagem

) {

    public MensagemSimplesDTO(Mensagem mensagem) {
        this(mensagem.getIdUsuario(), mensagem.getMensagem());
    }

}
