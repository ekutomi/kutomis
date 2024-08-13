package net.kutomi.kutomis.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.kutomi.kutomis.model.Mensagem;

public record EdicaoMensagem(

    @NotNull
    Long id,
    @NotBlank
    String mensagem
) {
    public EdicaoMensagem(Mensagem mensagem) {
        this(mensagem.getId(),mensagem.getMensagem());
    }
}
