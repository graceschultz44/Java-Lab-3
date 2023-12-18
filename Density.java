// Grace Schultz
// 48761302
// Lab 4-Fall 2022
import java.util.Scanner;
public class Density {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        double[] mass = new double[3];
        double[] volume = new double[3];
        System.out.println("Enter the mass and volume for your 3 compounds.");
        for (int i = 0; i < mass.length && i < volume.length; i++) {
            System.out.print("Enter mass in grams: ");
            mass[i] = input.nextDouble();
            System.out.print("Enter volume in milliliters: ");
            volume[i] = input.nextDouble();
        }
        calculateDensity(mass, volume);
    }

    public static void calculateDensity(double[] mass, double[] volume) {
        for (int i = 0; i < mass.length && i < volume.length; i++) {
            System.out.printf("The density for mass = %.2f g ", mass[i]);
            System.out.printf("and volume = %.2f", volume[i]);
            System.out.printf(" ml is: %.2f g/ml", mass[i] / volume[i]);
            System.out.println();
        }
    }
}