package br.com.mobicare.viajabessa.events;

import android.view.View;
import android.widget.AdapterView;

public class PacoteListagemItemClickEvent {
    public final AdapterView<?> parent;
    public final View view;
    public final int position;
    public final long id;

    public PacoteListagemItemClickEvent(AdapterView<?> parent, View view, int position, long id) {
        this.parent = parent;
        this.view = view;
        this.position = position;
        this.id = id;
    }
}
