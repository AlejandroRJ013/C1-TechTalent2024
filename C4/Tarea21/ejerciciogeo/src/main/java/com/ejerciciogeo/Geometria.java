package com.ejerciciogeo;

public class Geometria {
    private int id;
    private String nom;
    private double area;

    public Geometria(int id) {
        this.id = id;
        this.nom = figura(id);
    }

    public Geometria() {
        this.id = 9;
        this.nom = "Default";
    }

    public int areacuadrado(int n1) {
        return n1 * n1;
    }

    public double areaCirculo(int r) {
        final double PI = 3.1416;
        return PI * Math.pow(r, 2);
    }

    public int areatriangulo(int a, int b) {
        return (a * b) / 2;
    }

    public int arearectangulo(int b, int h) {
        return b * h;
    }

    public int areapentagono(int p, int a) {
        return (p * a) / 2;
    }

    public int arearombo(int D, int d) {
        return (D * d) / 2;
    }

    public int arearomboide(int b, int h) {
        return b * h;
    }

    public int areatrapecio(int B, int b, int h) {
        return ((B + b) / 2) * h;
    }

    public String figura(int fiCode) {
        String Figura = "";

        switch (fiCode) {
            case 1:
                Figura = "cuadrado";
                break;
            case 2:
                Figura = "Circulo";
                break;
            case 3:
                Figura = "Triangulo";
                break;
            case 4:
                Figura = "Rectangulo";
                break;
            case 5:
                Figura = "Pentagono";
                break;
            case 6:
                Figura = "Rombo";
                break;
            case 7:
                Figura = "Romboide";
                break;
            case 8:
                Figura = "Trapecio";
                break;
            default:
                Figura = "Default";
                break;
        }
        return Figura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Geometria [id=" + id + ", nom=" + nom + ", area=" + area + "]";
    }
}