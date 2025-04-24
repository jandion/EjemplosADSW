package tema2.cartas;

public class Carta implements Comparable<Carta> {
    private Valor valor;
    private Palo palo;

    public Carta(Valor valor, Palo palo) {
        this.valor = valor;
        this.palo = palo;
    }
    public Valor getValor() {
        return valor;
    }
    public void setValor(Valor valor) {
        this.valor = valor;
    }
    public Palo getPalo() {
        return palo;
    }
    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    public String toString() {
        String rep = "";
        switch (valor) {
            case AS:
                rep += "A";
                break;
            case JACK:;
                rep += "J";
                break;
            case QUEEN:
                rep += "Q";
                break;
            case KING:
                rep += "K";
                break;
            default:
                rep += valor.ordinal() + 1;
                break;
        }
        switch (palo) {
            case PICAS:
                rep += "♠";
                break;
            case CORAZONES:
                rep += "♥";
                break;
            case DIAMANTES:
                rep += "♦";
                break;
            case TREBOLES:
                rep += "♣";
                break;
        }
        return rep;
    }

    @Override
    public int compareTo(Carta other) {
        if (this.getPalo() == other.getPalo()) {
            if (this.getValor() == other.getValor()) {
                return 0;
            } else if ( this.getValor().ordinal() > other.getValor().ordinal()) {
                return 1;
            }
            return -1;
        } else {
            return this.getPalo().ordinal() - other.getPalo().ordinal();
        }
    }
}
