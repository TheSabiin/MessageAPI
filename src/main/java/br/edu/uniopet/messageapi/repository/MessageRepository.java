package br.edu.uniopet.messageapi.repository;

import br.edu.uniopet.messageapi.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
