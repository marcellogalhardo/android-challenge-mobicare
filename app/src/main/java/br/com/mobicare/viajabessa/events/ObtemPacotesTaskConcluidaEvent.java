package br.com.mobicare.viajabessa.events;

import java.util.List;

import br.com.mobicare.viajabessa.models.Pacote;

public class ObtemPacotesTaskConcluidaEvent {
    public final List<Pacote> pacotes;

    public ObtemPacotesTaskConcluidaEvent(List<Pacote> pacotes) {
        this.pacotes = pacotes;
    }

}
