package com.inventarios.bean;

public enum Casillero {
    RADIO(0),
    CHECKBOX(1);

    private final int casillero;

    private Casillero(int _casillero) {
        this.casillero = _casillero;
    }

    public int getCasillero() {
        return this.casillero;
    }
}
