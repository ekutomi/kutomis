package net.kutomi.kutomis.repository;


import net.kutomi.kutomis.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
