package com.codedeving.atendimentosapi.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "TB_PACIENTE")
public class PacienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String idade;
    private String email;
    private Boolean favorito;
    @Column(columnDefinition = "LONGBLOB", length = 16777215)
    private byte[] foto;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<AtendimentoEntity> atendimentos;
}
