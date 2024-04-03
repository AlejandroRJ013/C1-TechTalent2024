import java.util.*;

public class mainEntregaDoor {
    public static void main(String[] args) {
        ArrayList<Videojuego> Juegos = new ArrayList<>(); 
        ArrayList<Series> Series = new ArrayList<>(); 

        Videojuego juego1 = new Videojuego("The Legend of Zelda: Breath of the Wild", 
        120, "Aventura", "Nintendo");
        Videojuego juego2 = new Videojuego("Super Mario Odyssey", 
        60, "Plataforma", "Nintendo");
        Videojuego juego3 = new Videojuego("Hollow Knight", 
        28, "Metroidvania", "Team Cherry");
        Videojuego juego4 = new Videojuego("The Witcher 3: Wild Hunt", 
        100, "RPG", "CD Projekt Red");
        Videojuego juego5 = new Videojuego("Red Dead Redemption 2", 
        60, "Acción-Aventura", "Rockstar Games");
        Juegos.addAll(Arrays.asList(juego1, juego2, juego3, juego4, juego5));

        Series serie1 = new Series("Breaking Bad", 5, 
        "Droga(Drama)", "Vince Gilligan");
        Series serie2 = new Series("Game of Thrones", 8, 
        "Fantasía", "David Benioff, D. B. Weiss");
        Series serie3 = new Series("Hunter x Hunter", 6, 
        "Anime", "Yoshihiro Togashi");
        Series serie4 = new Series("Friends", 10, 
        "Comedia", "David Crane, Marta Kauffman");
        Series serie5 = new Series("Stranger Things", 4, 
        "Ciencia ficción", "Duffer Brothers");
        Series.addAll(Arrays.asList(serie1, serie2, serie3, serie4, serie5));

        ArrayList<Object> Series_Juegos = new ArrayList<>();
        Series_Juegos.addAll(Arrays.asList(serie1, serie2, serie3, serie4, serie5, 
        juego1, juego2, juego3, juego4, juego5));

        //  SELECCIONAR ALGUNOS COMO ENTREGADOS
        juego1.entregado();
        juego3.entregado();
        serie2.entregado();
        serie4.entregado();
        serie5.entregado();

        int contadorEntregrados = 0;
        ArrayList<String> titulos = new ArrayList<>();
        
        for (Object o : Juegos) {
            Videojuego SerieJuego = (Videojuego) o;
            if (SerieJuego.estaEntregado()) {
                titulos.add(SerieJuego.getTitulo());
                contadorEntregrados++;
                SerieJuego.devolver();
            }
        }
        for (Object o : Series) {
            Series SerieJuego = (Series) o;
            if (SerieJuego.estaEntregado()) {
                titulos.add(SerieJuego.getTitulo());
                contadorEntregrados++;
                SerieJuego.devolver();
            }
        }
        
        if (contadorEntregrados == 0) {
            System.out.println("No hay nada entregado");
        } else {
            System.out.println("Hay "+ contadorEntregrados+ 
            " entregas los cuales son: \n\t"+titulos+"\n");
        }

        Series serieMayorTemporadas = new Series();
        Videojuego juegoMasLargo = new Videojuego();

        for (Videojuego juego : Juegos) {
            juegoMasLargo = juego.comparativa(Series_Juegos);
        }
        for (Series serie : Series) {
            serieMayorTemporadas = serie.comparativa(Series_Juegos);
        }
        System.out.println(juegoMasLargo.masHorasToString()+
        "\n\n"+serieMayorTemporadas.masTemporadasToString());
    }
}