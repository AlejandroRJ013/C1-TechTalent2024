package com.ejercicio03.modelo;

public class Modelo {
    private int clicksBot1;
    private int clicksBot2;

    public Modelo() {
        clicksBot1 = 0;
        clicksBot2 = 0;
    }

    public Modelo(int click1, int click2) {
        clicksBot1 = click1;
        clicksBot2 = click2;
    }

    public void bot1Clicado() {
        clicksBot1++;
    }

    public int getClicksBot1() {
        return clicksBot1;
    }
    
    public void bot2Clicado() {
        clicksBot2++;
    }

    public int getClicksBot2() {
        return clicksBot2;

    }
}