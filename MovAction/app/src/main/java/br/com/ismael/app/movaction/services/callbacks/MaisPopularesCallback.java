package br.com.ismael.app.movaction.services.callbacks;

import br.com.ismael.app.movaction.models.MaisPopulares;
import retrofit2.Call;
import retrofit2.Response;

public abstract class MaisPopularesCallback implements IMaisPopularesCallback {
    @Override
    public abstract void onResponse(Call<MaisPopulares> call, Response<MaisPopulares> response);

    @Override
    public abstract void onFailure(Call<MaisPopulares> call, Throwable t) ;
}
