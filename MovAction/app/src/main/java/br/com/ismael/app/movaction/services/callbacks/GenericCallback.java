package br.com.ismael.app.movaction.services.callbacks;

import br.com.ismael.app.movaction.models.MaisPopulares;
import retrofit2.Call;
import retrofit2.Response;

public abstract class GenericCallback<T> implements IGenericCallback<T> {
    @Override
    public abstract void onResponse(Call<T> call, Response<T> response);

    @Override
    public abstract void onFailure(Call<T> call, Throwable t) ;
}
