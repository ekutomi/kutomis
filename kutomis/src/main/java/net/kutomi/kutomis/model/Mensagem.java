package net.kutomi.kutomis.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import net.kutomi.kutomis.dtos.MensagemDTO;
import net.kutomi.kutomis.enums.TipoMensagem;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name="TB_Mensagem")
@Entity(name="Mensagem")
public class Mensagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_usuario")
    private Integer idUsuario;

    @Column(name="mensagem")
    private String mensagem;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="id_tipo")
    private TipoMensagem tipoMensagem;

    private Boolean ativo;

    public Mensagem(MensagemDTO mensagem) {
        this.idUsuario = mensagem.idUsuario();
        this.tipoMensagem = TipoMensagem.values()[mensagem.tipoMensagem()];
        this.mensagem = mensagem.mensagem();
        this.ativo = true;
    }
}
