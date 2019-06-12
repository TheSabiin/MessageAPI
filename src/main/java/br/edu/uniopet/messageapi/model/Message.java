package br.edu.uniopet.messageapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private Date created;

    @OneToOne(cascade = CascadeType.ALL)
    private Body body;
}