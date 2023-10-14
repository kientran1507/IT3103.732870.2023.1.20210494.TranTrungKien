import javax.swing.JOptionPane;
public class SolveEquation {
    public static void main(String[] args) {
        String[] options = { "First-degree equation", "Linear system", "Quadratic equation" };

        int choice = JOptionPane.showOptionDialog(
            null,
            "Choose an equation to solve:",
            "Equation Solver",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            options,
            options[0]
        );

        switch (choice) {
            case 0:
                solveFirstDegreeEquation();
                break;
            case 1:
                solveLinearSystem();
                break;
            case 2:
                solveQuadraticEquation();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid choice. Please choose a valid option.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void solveFirstDegreeEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'a' for the linear equation: \n a*x + b = 0"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter the constant 'b':\n "+ a + "*x + b = 0"));
        JOptionPane.showMessageDialog(null,"This is your equation: \n" + a + "*x + " + b + " = 0", "Confirm", JOptionPane.INFORMATION_MESSAGE);

        if (a != 0) {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "Solution for the linear equation: x = " + x, "Solution", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The equation is not first-degree (linear) because 'a' cannot be 0.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void solveLinearSystem() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'a11' for the linear system: \n a11*x1 + a12*x2 = b1 \n a21*x1 + a22*x2 = b2"));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'a12': \n" + a11 + "*x1 + a12*x2 = b1 \n a21*x1 + a22*x2 = b2"));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'a21': \n" + a11 + "*x1 + " + a12 +"*x2=b1 \n a21*x1 + a22*x2 = b2"));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'a22': \n" + a11 + "*x1 + " + a12 +"*x2=b1 \n" + a21 + "*x1 + a22*x2 = b2"));

        double b1 = Double.parseDouble(JOptionPane.showInputDialog("Enter the constant 'b1': \n" + a11 + "*x1 + " + a12 +"*x2=b1 \n" + a21 + "*x1 + "+ a22 +"*x2 = b2"));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog("Enter the constant 'b2': \n" + a11 + "*x1 + " + a12 +"*x2=" + b1 + "\n" + a21 + "*x1 + "+ a22 +"*x2 = b2"));
        JOptionPane.showMessageDialog(null, "This is your equation: \n" + a11 + "*x1 + " + a12 +"*x2=" + b1 + "\n" + a21 + "*x1 + "+ a22 +"*x2 = " + b2, "Confirm", JOptionPane.INFORMATION_MESSAGE);
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            JOptionPane.showMessageDialog(null, "Solution for the linear system:\n x1 = " + x1 + "\n x2 = " + x2, "Solution", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.", "Solution", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The system has no solution.", "Solution", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public static void solveQuadraticEquation() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'a' for the quadratic equation: \n a*x^2 + b*x + c = 0:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'b': \n" + a + "*x^2 + b*x + c = 0:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter the coefficient 'c': \n" + a + "*x^2 + " + b + "*x + c = 0:"));
        JOptionPane.showMessageDialog(null,"This is your equation: \n" + a + "*x^2 + " + b + "*x + " + c +" = 0:","Confirm", JOptionPane.INFORMATION_MESSAGE);
        double discriminant = b * b - 4 * a * c;

        if (a != 0) {
            if (discriminant > 0) {
                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                JOptionPane.showMessageDialog(null, "Solutions for the quadratic equation:\n Root 1 = " + root1 + "\n Root 2 = " + root2, "Solution", JOptionPane.INFORMATION_MESSAGE);
            } else if (discriminant == 0) {
                double root = -b / (2 * a);
                JOptionPane.showMessageDialog(null, "Double root for the quadratic equation: x = " + root, "Solution", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The quadratic equation has no real roots.", "Solution", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "The equation is not second-degree (quadratic) because 'a' cannot be 0.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
