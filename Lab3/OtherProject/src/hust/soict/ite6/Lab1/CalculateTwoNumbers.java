import javax.swing.JOptionPane;
public class CalculateTwoNumbers{
    public static void main(String[] args){
        String strNum1, strNum2;
        
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);

        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double diff = num1 - num2;
        double product = num1 * num2;

        if (num2 != 0) {
            double quotient = num1 / num2;
            JOptionPane.showMessageDialog(null, "This is your sum: " + sum, "Sum", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "This is your difference: " + diff, "Difference", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "This is your product: " + product, "Product", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "This is your quotient: " + quotient, "Quotient", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Division by zero is not allowed!", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        System.exit(0);
    }
}