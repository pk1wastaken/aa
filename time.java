public class TimeDivisionMultiplexing {
    public static void main(String[] args) {
        String[] signals = {"Signal 1", "Signal 2", "Signal 3"};
        int[] durations = {2, 3, 1};

        try {
            timeDivisionMultiplexing(signals, durations);
        } catch (InterruptedException e) {
            System.out.println("Keyboard interrupt detected. Time Division Multiplexing stopped.");
        }
    }

    public static void transmitSignal(String signal, int duration) throws InterruptedException {
        System.out.println("Transmitting '" + signal + "' for " + duration + " seconds...");
        Thread.sleep(duration * 1000);
    }

    public static void timeDivisionMultiplexing(String[] signals, int[] durations) throws InterruptedException {
        System.out.println("Time Division Multiplexing started:");
        for (int i = 0; i < signals.length; i++) transmitSignal(signals[i], durations[i]);
        System.out.println("Time Division Multiplexing completed");
    }
}
