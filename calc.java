public class Calculatrice {

    public double addition(double a, double b) {
        return a + b;
    }

    public double soustraction(double a, double b) {
        return a - b;
    }

    public double multiplication(double a, double b) {
        return a * b;
    }

    public ResultatDivision division(double a, double b) {
        if (b == 0) {
            return new ResultatDivision(Double.NaN, "Division par zéro impossible.");
        }
        return new ResultatDivision(a / b, null);
    }
}

class ResultatDivision {
    double resultat;
    String messageErreur;

    public ResultatDivision(double resultat, String messageErreur) {
        this.resultat = resultat;
        this.messageErreur = messageErreur;
    }
}
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Calculatrice calculatrice = new Calculatrice();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Entrez l'opération (+, -, *, /) ou 'q' pour quitter :");
            String operation = scanner.nextLine();

            if (operation.equals("q")) {
                break;
            }

            System.out.println("Entrez le premier nombre :");
            double a = scanner.nextDouble();
            scanner.nextLine(); // Consomme la nouvelle ligne

            System.out.println("Entrez le deuxième nombre :");
            double b = scanner.nextDouble();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (operation) {
                case "+":
                    System.out.println("Résultat : " + calculatrice.addition(a, b));
                    break;
                case "-":
                    System.out.println("Résultat : " + calculatrice.soustraction(a, b));
                    break;
                case "*":
                    System.out.println("Résultat : " + calculatrice.multiplication(a, b));
                    break;
                case "/":
                    ResultatDivision resultatDivision = calculatrice.division(a, b);
                    if (resultatDivision.messageErreur != null) {
                        System.out.println("Erreur : " + resultatDivision.messageErreur);
                    } else {
                        System.out.println("Résultat : " + resultatDivision.resultat);
                    }
                    break;
                default:
                    System.out.println("Opération invalide.");
            }
        }

        scanner.close();
    }
}