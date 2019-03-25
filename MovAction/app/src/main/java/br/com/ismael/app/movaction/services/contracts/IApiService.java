package br.com.ismael.app.movaction.services.contracts;

public interface IApiService {
     <T> T criarInstanciaApi(Class<T> provedor);
}
