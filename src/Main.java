import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Digits digits;
    private static NeuralNetwork neuralNetwork;

    public static void main(String[] args) {

        System.out.println("Please wait while data is parsed");
        digits = new Digits(true, true);
        neuralNetwork = new NeuralNetwork(784, new int[] {30, 20} , 10, 0.1);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            displayMenu();
            String command = scanner.nextLine();
            String[] commands = command.trim().split(" ");
            try {
                switch (commands[0]) {
                    case "1":
                        System.out.println("Confirm <y/n>, this could take a very long time");
                        command = scanner.nextLine().trim().toLowerCase();
                        if (command.equals("y") || command.equals("yes")){
                            train();
                        }
                        break;
                    case "2":
                        if (commands[1].trim().toLowerCase().equals("all")) {
                            checkAll();
                        } else {
                            check(Integer.parseInt(commands[1]));
                        }
                        break;
                    case "3":
                        Display display = new Display(digits.getTestingData(Integer.parseInt(commands[1]) - 1));
                        break;
                    case "4":
                        neuralNetwork.saveNetwork(commands[1]);
                        break;
                    case "5":
                        neuralNetwork = NeuralNetwork.loadNetwork(commands[1]);
                        break;
                    case "6":
                        Draw.main("Draw");
                        break;
                    case "9":
                        running = false;
                        break;

                        default:
                            System.out.println("Unrecognized command");
                }
            } catch (Exception e) {
                System.out.println("Syntax Error");
            }
        }
        System.out.print("Copyright: Ethan Budd, 2019");
    }

    private static void displayMenu() {
        System.out.println("[1] Train network");
        System.out.println("[2] <index 1 - 10,000, all> Test network at index, Runs all tests");
        System.out.println("[3] <index 1 - 10,000> Display digit");
        System.out.println("[4 <name>] Save network");
        System.out.println("[5 <name>] Load network");
        System.out.println("[9] Quit");
        System.out.print("Enter command: ");
    }

    private static void train() {
        for (int i = 0; i < digits.getTrainingData().length; i++) {

            ArrayList<Double> input = formatInput(digits.getTrainingData(i).getValues());
            ArrayList<Double> answer = formatAnswer(digits.getTrainingData(i).getNumber());

            neuralNetwork.trainDouble(input, answer);
            System.out.println("Training progress: " + (i + 1) + " / 60000");
        }
    }

    private static void check(int location){
        int index = location - 1;

        int answer = digits.getTestingData(index).getNumber();

        ArrayList<Double> input = formatInput(digits.getTestingData(index).getValues());

        ArrayList<Double> guesses = neuralNetwork.feedforward(input).toArray();
        double highestGuess = 0;
        int guessIndex = -1;

        System.out.println("Results: ");
        for (int i = 0; i < guesses.size(); i++){
            double guess = guesses.get(i);

            if (guess > highestGuess) {
                highestGuess = guess;
                guessIndex = i;
            }

            guess = guess * 100;
            System.out.print(i + ": ");
            System.out.printf("%.2f", guess);
            System.out.println("%");
        }

        System.out.println("Answer: " + answer + " Guess: " + guessIndex);
        System.out.println(answer == guessIndex ? "Correct" : "Incorrect");
    }

    private static void checkAll() {
        int correct = 0;

        for(int i = 0; i < digits.getTestingData().length; i++) {

            ArrayList<Double> input = formatInput(digits.getTestingData(i).getValues());
            ArrayList<Double> guesses = neuralNetwork.feedforward(input).toArray();
            int answer = digits.getTestingData(i).getNumber();

            double highestGuess = 0;
            int guessIndex = -1;

            for (int j = 0; j < guesses.size(); j++) {
                double guess = guesses.get(j);

                if (guess > highestGuess) {
                    highestGuess = guess;
                    guessIndex = j;
                }
            }

            if (answer == guessIndex) {
                correct++;
            }

            double accuracy = (double)correct / (double)(i + 1);
            accuracy = accuracy * 100;

            System.out.print("Testing progress: " + (i + 1) + " / 10000, Accuracy: ");
            System.out.printf("%.2f", accuracy);
            System.out.println("%");

        }
    }

    private static ArrayList<Double> formatInput(int[] input) {
        ArrayList<Double> output = new ArrayList<>(input.length);
        for (int j = 0; j < input.length; j++){
            output.add((double)input[j] / 255);
        }
        return output;
    }

    private static ArrayList<Double> formatAnswer(int answer) {
        ArrayList<Double> output = new ArrayList<>(10);
        for (int j = 0; j < 10; j++) {
            output.add(0.0);
            if (answer == j) {
                output.set(j, 1.0);
            }
        }
        return output;
    }

    public static void in(Digit digit){


        ArrayList<Double> input = formatInput(digit.getValues());

        ArrayList<Double> guesses = neuralNetwork.feedforward(input).toArray();
        double highestGuess = 0;
        int guessIndex = -1;

        System.out.println("Results: ");
        for (int i = 0; i < guesses.size(); i++){
            double guess = guesses.get(i);

            if (guess > highestGuess) {
                highestGuess = guess;
                guessIndex = i;
            }

            guess = guess * 100;
            System.out.print(i + ": ");
            System.out.printf("%.2f", guess);
            System.out.println("%");
        }

        System.out.println("Answer: Unknown Guess: " + guessIndex);
    }
}
