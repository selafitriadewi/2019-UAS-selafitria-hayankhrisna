package com.selafitriadewi.uas_alquran.base;

public class BasePresenter <V> {

    public V mView;

    public void attach(V view) {
        mView = view;
    }

    public void detach() {
        mView = null;
    }
}
