package utilidades;

import modelos.Personaje;
import modelos.Region;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPersonaje {

    public static Personaje levelUp(Personaje personaje) {
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

    public Personaje getMasPoderoso(List<Personaje> personaje) {
        Personaje personajemaspoderoso = null;
        double maxsumaestadisticas = 0.0;

        for (Personaje p : personaje) {
            p.setNivel(17);
            levelUp(p);
            double sumaestadistica = p.getVida() + p.getAtaque() + p.getDefensa() + p.getMana();

            if (sumaestadistica > maxsumaestadisticas) {
                maxsumaestadisticas = sumaestadistica;
                personajemaspoderoso = p;
            }

        }
        return personajemaspoderoso;
    }

    public Map<Region, List<Personaje>> getMasPoderosoPorRegion(List<Personaje> personajes) {
        Map<Region, List<Personaje>> maxpersonajesPorRegion = new HashMap<>();

        for (Personaje p : personajes) {
            if (maxpersonajesPorRegion.containsKey(p.getRegion())) {
                maxpersonajesPorRegion.get(p.getRegion()).add(p);
            } else {
                maxpersonajesPorRegion.put(p.getRegion(), new ArrayList<>(List.of(p)));
            }
        }

        for (Region r : maxpersonajesPorRegion.keySet()) {
            getMasPoderoso(maxpersonajesPorRegion.get(r));
        }
        return maxpersonajesPorRegion;
    }
}
