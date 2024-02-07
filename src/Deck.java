import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Deck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        boolean salir = false;

        System.out.println("Juguemos Pocker");


            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Mezclar las cartas ");
            System.out.println("2. Mostrar la primera carta ");
            System.out.println("3. Seleccionar una carta al azar");
            System.out.println("4. Obtener una mano de 5 cartas");
            while (!salir) {
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    deck.head();
                    break;
                case 3:
                    deck.pick();
                    break;
                case 4:
                    deck.hand();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }

    }
    public List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    public void initializeDeck() {
        String[] palos = {"treboles", "corazones", "picas", "diamantes"};
        String[] colores = {"rojo", "negro"};
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String palo : palos) {
            for (String color : colores) {
                for (String valor : valores) {
                    cards.add(new Card(palo, color, valor));

                }
            }
        }
    }
        public void shuffle() {
            Collections.shuffle(cards);
            System.out.println("Se mezclo el Deck");
        }
        public void head() {
            Card firstCard = cards.remove(0);
            System.out.println("Carta " + firstCard.getPalo() + "," + firstCard.getColor() + "," + firstCard.getValor());
            System.out.println("Quedan " + cards.size() + " cartas en el deck");
        }
        public void pick() {
            int randomIndex = (int) (Math.random() * cards.size());
            Card pickedCard = cards.remove(randomIndex);
            System.out.println("Carta: " + pickedCard.getPalo() + "," + pickedCard.getColor() + "," + pickedCard.getValor());
            System.out.println("Quedan " + cards.size() + "cartas en el deck");
        }
        public void hand() {
            System.out.println("Mano de 5 cartas: ");
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println(card.getPalo() + "," + card.getColor() + ", " + card.getValor());
            }
            System.out.println("Quedan " + cards.size() + "cartas en el deck ");
        }

    }

      class Main {
        public static void main(String[] args) {
            Deck deck = new Deck();
            deck.shuffle();
            deck.head();
            deck.pick();
        }
    }

    class Card {
    public String palo;
    public String color;
    public String valor;
    public Card(String palo, String color, String valor) {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }
    public String getPalo() {
        return palo;
    }
    public String getColor() {
        return color;
    }

    public String getValor() {
        return valor;
    }
}