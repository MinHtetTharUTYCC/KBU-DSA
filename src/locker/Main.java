package locker;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("🔐 PASSWORD STRENGTH DEMONSTRATION 🔐");
        System.out.println("=".repeat(70)+"\n");

        System.out.println("Target: 20-digit numeric password (10²⁰ possibilities)");
        System.out.println("Total combinations: 100,000,000,000,000,000,000");
        System.out.println("\nPress ENTER to start the performance test...");

        new Scanner(System.in).nextLine();

        System.out.println("\n🚀 Starting CPU benchmark...\n");

        // Accurate tracking variables
        AtomicLong accurateGuesses = new AtomicLong(0);
        long[] guessesPerSecond = new long[20];
        boolean running = true;

        // Start progress monitor thread
        boolean finalRunning = running;
        Thread monitorThread = new Thread(() -> {
            try {
                long lastTotal = 0;
                for (int sec = 0; sec < 20 && finalRunning; sec++) {
                    Thread.sleep(1000);
                    long currentTotal = accurateGuesses.get();
                    long delta = currentTotal - lastTotal;
                    guessesPerSecond[sec] = delta;
                    lastTotal = currentTotal;

                    // Show actual guess attempts - last 10
                    System.out.printf("[%2ds] Tested: %,15d | Rate: %,10d/s%n",
                            sec + 1, currentTotal, delta);
                    System.out.print("      Last 10 guesses: ");
                    for (int i = 9; i >= 0; i--) {
                        long guessNum = currentTotal - i;
                        if (guessNum >= 0) {
                            String guess = String.format("%020d", guessNum % 1000000000000000000L);
                            System.out.print(guess);
                            if (i > 0) System.out.print(", ");
                        }
                    }
                    System.out.println("\n");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        monitorThread.start();

        long startTime = System.currentTimeMillis();

        // ACTUAL WORKLOAD - This is what really runs for 20 seconds
        final int BATCH_SIZE = 10000;
        final long endTimeTarget = startTime + 20000; // 20 seconds

        while (System.currentTimeMillis() < endTimeTarget) {
            // Process a batch of work
            LongStream.range(0, BATCH_SIZE)
                    .parallel()
                    .forEach(i -> {
                        // Real computational work (similar to password checking)
                        long currentGuess = accurateGuesses.get() + i;
                        String padded = String.format("%020d", currentGuess % 1000000);
                        BigInteger dummy = new BigInteger(padded);

                        // Force the computation to not be optimized away
                        if (dummy.bitLength() < 0) { // Never true, but compiler doesn't know
                            System.out.println("Impossible");
                        }
                    });

            // Count this batch
            accurateGuesses.addAndGet(BATCH_SIZE);
        }

        long actualEndTime = System.currentTimeMillis();
        long actualDuration = actualEndTime - startTime;
        running = false;


        monitorThread.join();

        // Calculate REAL performance
        long totalRealGuesses = accurateGuesses.get();
        double realSeconds = actualDuration / 1000.0;
        double realGuessesPerSecond = totalRealGuesses / realSeconds;

        System.out.println("\n" + "=".repeat(70));
        System.out.println("📊 ACCURATE PERFORMANCE MEASUREMENT");
        System.out.println("=".repeat(70));
        System.out.printf("Actual run time: %.2f seconds%n", realSeconds);
        System.out.printf("Total operations: %,d%n", totalRealGuesses);
        System.out.printf("Measured speed: %,.0f operations/second%n", realGuessesPerSecond);
        System.out.println("=".repeat(70));

        // Calculate time to crack
        System.out.println("\n⏱️  TIME TO CRACK ANALYSIS");
        System.out.print("=".repeat(70));
        System.out.println();

        BigInteger totalCombinations = new BigInteger("100000000000000000000"); // 10^20
        BigInteger opsPerSecond = BigInteger.valueOf((long) realGuessesPerSecond);

        // Calculate seconds needed
        BigInteger secondsNeeded = totalCombinations.divide(opsPerSecond);

        // Convert to various time units
        BigInteger minutesNeeded = secondsNeeded.divide(BigInteger.valueOf(60));
        BigInteger hoursNeeded = minutesNeeded.divide(BigInteger.valueOf(60));
        BigInteger daysNeeded = hoursNeeded.divide(BigInteger.valueOf(24));
        BigInteger yearsNeeded = daysNeeded.divide(BigInteger.valueOf(365));

        // Calculate millennia, million years, billion years
        BigInteger millenniaNeeded = yearsNeeded.divide(BigInteger.valueOf(1000));
        BigInteger millionYearsNeeded = yearsNeeded.divide(BigInteger.valueOf(1_000_000));
        BigInteger billionYearsNeeded = yearsNeeded.divide(BigInteger.valueOf(1_000_000_000));

        System.out.printf("At this CPU speed: %,.0f guesses/second%n%n", realGuessesPerSecond);
        System.out.printf("Seconds:        %s%n", formatBigInt(secondsNeeded));
        System.out.printf("Minutes:        %s%n", formatBigInt(minutesNeeded));
        System.out.printf("Hours:          %s%n", formatBigInt(hoursNeeded));
        System.out.printf("Days:           %s%n", formatBigInt(daysNeeded));
        System.out.printf("Years:          %s%n", formatBigInt(yearsNeeded));
        System.out.printf("Millennia:      %s%n", formatBigInt(millenniaNeeded));
        System.out.printf("Million years:  %s%n", formatBigInt(millionYearsNeeded));
        System.out.printf("Billion years:  %s%n", formatBigInt(billionYearsNeeded));

        System.out.print("=".repeat(70)+"\n");
        System.out.println("✅ DEMONSTRATION COMPLETE");
    }

    private static String formatBigInt(BigInteger num) {
        String str = num.toString();
        StringBuilder formatted = new StringBuilder();
        int count = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) {
                formatted.insert(0, ',');
            }
            formatted.insert(0, str.charAt(i));
            count++;
        }

        return formatted.toString();
    }
}