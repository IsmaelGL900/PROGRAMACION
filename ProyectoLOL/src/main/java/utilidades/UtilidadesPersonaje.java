package utilidades;

import modelos.Personaje;
import modelos.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPersonaje {

    public Personaje levelUp(Personaje personaje) {
        personaje.setNivel(personaje.getNivel() + 1);

        int nivel = personaje.getNivel();
        personaje.setAtaque(personaje.getAtaqueBase() + personaje.getEscalabilidad().getIncrementoDañoNivel() * nivel);
        personaje.setDefensa(personaje.getDefensaBase() + personaje.getEscalabilidad().getIncrementoDefensaNivel() * nivel);
        personaje.setVida(personaje.getVidaBase() + personaje.getEscalabilidad().getIncrementoSaludNivel() * nivel);
        personaje.setMana(personaje.getManaBase() + personaje.getEscalabilidad().getIncrementoManaNivel() * nivel);
        return personaje;
    }

    public Map<Region, List<Personaje>> getPersonajesPorRegion(List<Personaje> personajes) {
        Map<Region, List<Personaje>> personajesPorRegion = new HashMap<>();

        for (Personaje personaje : personajes) {
            if (personajesPorRegion.containsKey(personaje.getRegion())) {
                personajesPorRegion.get(personaje.getRegion()).add(personaje);
            } else {
                personajesPorRegion.put(personaje.getRegion(), new ArrayList<>(List.of(personaje)));
            }
        }
        return personajesPorRegion;
    }



}
