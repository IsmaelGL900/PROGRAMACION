package utilidades;

import modelos.Item;
import modelos.Personaje;

import java.util.List;

public class UtilidadesItem {
    public static void equiparItem(Personaje personaje, Item item) {
        personaje.getEquipamento().add(item);

        personaje.setAtaque(personaje.getAtaque() + item.getAumentoDaño());
        personaje.setDefensa(personaje.getDefensa() + item.getAumentoDefensa());
        personaje.setMana(personaje.getMana() + item.getAumentoMana());
        personaje.setVida(personaje.getVida() + item.getAumentoSalud());
    }
}
