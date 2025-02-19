package utilidades;

import modelos.*;
import utilidades.*;

public class UtilidadesHabilidad {

    public void golpearConHabilidad(Personaje emisor, Personaje receptor, Habilidad habilidadEmisor) {
        emisor.setNivel(17);
        UtilidadesPersonaje.levelUp(emisor);
        receptor.setNivel(17);
        UtilidadesPersonaje.levelUp(receptor);

        for (Item i : emisor.getEquipamento()) {
            UtilidadesItem.equiparItem(emisor, i);
        }

        for (Item i : receptor.getEquipamento()) {
            UtilidadesItem.equiparItem(receptor, i);
        }

        if (habilidadEmisor.getTipoHabilidad().equals(TipoHabilidad.DAÑO)) {
            habilidadEmisor.setDaño(habilidadEmisor.getDañoBase() + (0.2 * emisor.getAtaque()) - (0.1 * receptor.getDefensa()));
            emisor.setMana(emisor.getMana() - habilidadEmisor.getCosteMana());
            receptor.setVida(receptor.getVida() - habilidadEmisor.getDaño());
        }

    }
}
