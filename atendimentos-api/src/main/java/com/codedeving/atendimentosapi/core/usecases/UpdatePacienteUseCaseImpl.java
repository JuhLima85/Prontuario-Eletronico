package com.codedeving.atendimentosapi.core.usecases;

import com.codedeving.atendimentosapi.core.domain.Paciente;

import com.codedeving.atendimentosapi.core.exceptions.PacienteNotFoundException;
import com.codedeving.atendimentosapi.core.gateways.PacienteGateway;

public class UpdatePacienteUseCaseImpl implements UpdatePacienteUseCase {

    private final PacienteGateway pacienteGateway;

    public UpdatePacienteUseCaseImpl(PacienteGateway pacienteGateway) {
        this.pacienteGateway = pacienteGateway;
    }

    @Override
    public Paciente execute(Integer id, Paciente paciente) {
        if(paciente.nome() == null || paciente.nome().isEmpty()){
            throw new PacienteNotFoundException("O campo 'Nome' é obrigatório.");
        } else if (paciente.email() == null || paciente.email().isEmpty()){
            throw new PacienteNotFoundException("O campo 'E-mail' é obrigatório.");
        }
        return pacienteGateway.updatePaciente(id, paciente);
    }
}
