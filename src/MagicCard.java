import java.util.Scanner;

public class MagicCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards = scanner.nextLine().trim().split("\\s+");
        String oddEvent = scanner.nextLine();
        String magicCard = scanner.nextLine();

        long sum = 0;
        Integer start = 0;

        if (oddEvent.equals("odd")){
            start = 1;
        }

        for (int i = start; i < cards.length; i+=2) {
            Integer current = calclulateValue(magicCard, cards[i]);
            sum += current;
        }

        System.out.println(sum);
    }

    private static Integer calclulateValue(String magicCard, String card) {
        Integer value = 0;
        String cardFace = card.substring(0, card.length()-1);
        Character cardSuit = card.charAt(card.length() - 1);
        String magicCardFace = magicCard.substring(0, magicCard.length() - 1);
        Character magicCardSuit = magicCard.charAt(magicCard.length()-1);

        switch (cardFace){
            case "A":
                value = 150;
                break;
            case "K":
                value = 140;
                break;
            case "Q":
                value = 130;
                break;
            case "J":
                value = 120;
                break;
            default:
                value = Integer.parseInt(cardFace)*10;
        }

        if (cardFace.equals(magicCardFace)){
            value*=3;
        }else {
            if (cardSuit.equals(magicCardSuit)){
                value*=2;
            }
        }

        return value;
    }
}
