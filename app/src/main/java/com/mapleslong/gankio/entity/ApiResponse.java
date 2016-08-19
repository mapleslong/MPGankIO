package com.mapleslong.gankio.entity;

import com.google.gson.Gson;

/**
 * Created by Mapleslong on 16/6/10.
 */
public class ApiResponse<T> {

    private boolean error;
    private T results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
