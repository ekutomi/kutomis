package net.kutomi.kutomis.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public record MensagemDTO(

        @NotNull
        Integer idUsuario,

        @NotNull
        @NotBlank
        String mensagem,

        @NotNull
        Integer tipoMensagem
) {}
