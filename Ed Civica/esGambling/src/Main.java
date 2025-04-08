import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SlotMachine machine = new SlotMachine();
        int balance = 100;

        System.out.println("🎰 Benvenuto alla Slot Machine!");
        System.out.println("💰 Saldo iniziale: " + balance + " crediti");

        while (balance > 0) {
            System.out.print("\nInserisci la puntata (0 per uscire): ");
            int bet = scanner.nextInt();

            if (bet == 0) {
                System.out.println("👋 Grazie per aver giocato! Saldo finale: " + balance);
                break;
            }

            if (bet > balance) {
                System.out.println("❌ Puntata troppo alta! Saldo disponibile: " + balance);
                continue;
            }

            balance -= bet;

            String[] result = machine.spin();
            System.out.println("🌀 Risultato: " + String.join(" | ", result));

            if (machine.isWinningSpin(result)) {
                int winnings = machine.calculateWinnings(result[0], bet);
                balance += winnings;
                System.out.println("🎉 Hai vinto " + winnings + " crediti!");
            } else {
                System.out.println("😞 Nessuna vincita.");
            }

            System.out.println("💰 Saldo attuale: " + balance);
        }

        if (balance == 0) {
            System.out.println("💸 Hai esaurito i crediti. Fine del gioco.");
        }

        scanner.close();
    }
}
