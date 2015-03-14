package br.com.mobicare.viajabessa.services;

import java.util.List;

import br.com.mobicare.viajabessa.models.Pacote;
import retrofit.http.GET;

public interface PacoteService {
    public static final String URI = "http://private-6082a-mobicareviajabessa.apiary-mock.com/";

    @GET("/pacotes")
    List<Pacote> obterTodos();

}