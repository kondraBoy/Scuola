import java.util.Random;
    public class SlotMachine {
        private static final String[] SYMBOLS = {"🍒", "🔔", "🍋", "💎", "7️⃣"};
        private Random random = new Random();

        public String[] spin() {
            String[] result = new String[3];
            for (int i = 0; i < 3; i++) {
                result[i] = SYMBOLS[random.nextInt(SYMBOLS.length)];
            }
            return result;
        }

        public boolean isWinningSpin(String[] result) {
            return result[0].equals(result[1]) && result[1].equals(result[2]);
        }

        public int calculateWinnings(String symbol, int bet) {
            switch (symbol) {
                case "7️⃣":
                    return bet * 10;
                case "💎":
                    return bet * 5;
                case "🔔":
                    return bet * 4;
                case "🍋":
                    return bet * 3;
                case "🍒":
                    return bet * 2;
                default:
                    return 0;
            }
        }
    }
