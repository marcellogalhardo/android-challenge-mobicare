package br.com.mobicare.viajabessa.tasks;

import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.mobicare.viajabessa.events.ObtemPacotesTaskConcluidaEvent;
import br.com.mobicare.viajabessa.events.ObtemPacotesTaskFalhaEvent;
import br.com.mobicare.viajabessa.models.Pacote;
import br.com.mobicare.viajabessa.services.PacoteService;
import br.com.mobicare.viajabessa.services.ServiceFactory;
import br.com.mobicare.viajabessa.utils.BusProvider;

public class ObtemPacotesTask extends AsyncTask<String, Object, List<Pacote>> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected List<Pacote> doInBackground(String... params) {
        PacoteService service = ServiceFactory.criarPacoteService();
        try {
            List<Pacote> pacotes = service.obterTodos();
            BusProvider.getInstance().post(new ObtemPacotesTaskConcluidaEvent(pacotes));
        } catch (Exception e) {
            BusProvider.getInstance().post(new ObtemPacotesTaskFalhaEvent(e));
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Pacote> pacotes) {
        super.onPostExecute(pacotes);
    }
}
