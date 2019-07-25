import java.io.File;
import java.util.Scanner;

public class Digits {
    private Digit[] trainingData;
    private Digit[] testingData;

    public Digits(boolean training, boolean testing) {
        if(training) {
            trainingData = new Digit[60000];
        }
        if(testing) {
            testingData = new Digit[10000];
        }
        importData();
    }

    private void importData() {
        File file;
        Scanner scanner;
        if(trainingData != null) {
            file = new File("trainingData.csv");
            try {
                scanner = new Scanner(file);
                for (int i = 0; i < 60000; i++) {
                    trainingData[i] = new Digit(scanner.nextLine());
                }
            } catch (Exception e){
                System.out.println("File not Found");
            }

        }
        if(testingData != null) {
            file = new File("testingData.csv");
            try {
                scanner = new Scanner(file);
                for (int i = 0; i < 10000; i++) {
                    testingData[i] = new Digit(scanner.nextLine());
                }
            } catch (Exception e){
                System.out.println("File not Found");
            }

        }

    }

    public Digit[] getTestingData() {
        return testingData;
    }

    public Digit getTestingData(int index) {
        return testingData[index];
    }

    public Digit[] getTrainingData() {
        return trainingData;
    }

    public Digit getTrainingData(int index) {
        return trainingData[index];
    }
}