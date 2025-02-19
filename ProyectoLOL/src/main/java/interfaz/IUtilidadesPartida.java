package interfaz;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;

import java.util.List;

public interface IUtilidadesPartida {
    void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles);
    void finalizarPartida(Partida partida, Integer equipoVencedor);
}
