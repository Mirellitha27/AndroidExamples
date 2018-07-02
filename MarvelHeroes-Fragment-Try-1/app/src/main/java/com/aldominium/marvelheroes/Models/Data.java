package com.aldominium.marvelheroes.Models;

/**
 * Created by aldo on 30/12/2016.
 */

public class Data<T> {

    private int total;
    private T results;

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }


}
