package utilidades;

import modelos.Jugador;
import modelos.Partida;
import modelos.Personaje;
import interfaz.IUtilidadesPartida;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class UtilidadesPartida implements IUtilidadesPartida {

    public void inicializarPartida(Partida partida, List<Jugador> participantes, List<Personaje> personajesDisponibles) {
        Map<Jugador, Personaje> elecciones = new HashMap<>();
        for (Jugador jugador : participantes) {
            Personaje personajeElegido = elegirPersonajeAJugador(jugador, personajesDisponibles);
            elecciones.put(jugador, personajeElegido );
        }

        Map<Integer, Set<Jugador>> jugadoresPorEquipo = new HashMap<>();
        Set<Jugador> equipo1 = new HashSet<>();
        Set<Jugador> equipo2 = new HashSet<>();
        for (int i = 0; i < participantes.size(); i++) {
            if (i % 2 == 0) {
                equipo1.add(participantes.get(i));
            } else {
                equipo2.add(participantes.get(i));
            }
        }
        jugadoresPorEquipo.put(1, equipo1);
        jugadoresPorEquipo.put(2, equipo2);
        partida.setJugadoresPorEquipo(jugadoresPorEquipo);

        partida.setInicioPartida(LocalDateTime.now());
    }

    private Personaje elegirPersonajeAJugador(Jugador jugador, List<Personaje> personajesDisponibles) {
        for (Personaje personaje : personajesDisponibles) {
            if (jugador.getPersonajesFavoritos().contains(personaje)) {
                return personaje;
            } else {
                Random random = new Random();
                return personajesDisponibles.get(random.nextInt(personajesDisponibles.size()));
            }
        }
        return null;
    }

    public void finalizarPartida(Partida partida, Integer equipoVencedor){
        partida.setFinPartida(LocalDateTime.now());

        partida.setDuracionPartida((int)Duration.between(partida.getInicioPartida(), partida.getFinPartida()).getSeconds());

        partida.setEquipoVencedor(equipoVencedor);

        Set<Jugador> GanadoresJugadores = partida.getJugadoresPorEquipo().get(equipoVencedor);

        for (Jugador jugador : GanadoresJugadores) {
            Personaje personajeUtilizado = partida.getElecciones().get(jugador);
            if (jugador.getPartidasGanadas().containsKey(personajeUtilizado)) {
                jugador.getPartidasGanadas().put(personajeUtilizado, jugador.getPartidasGanadas().get(personajeUtilizado) + 1 );
            } else {
                jugador.getPartidasGanadas().put(personajeUtilizado, 1);
            }
        }

    }

}
