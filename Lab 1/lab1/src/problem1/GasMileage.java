//********************************************************************
//  GasMileage.java       Author: Lewis/Loftus
//
//  Demonstrates the use of the Scanner class to read numeric data.
//********************************************************************

import java.util.Scanner;

public class GasMileage
{
   //-----------------------------------------------------------------
   //  Calculates fuel efficiency based on values entered by the
   //  user.
   //-----------------------------------------------------------------
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      while (true) {
          System.out.print("Enter car, miles, and gallons (separated by blanks, e.g., Car1 100 5.5): ");
          String car = scan.next();
          double miles = scan.nextDouble();
          double gallons = scan.nextDouble();

          double mpg = miles / gallons;

          System.out.println("Car: " + car + ", Miles Per Gallon: " + mpg);

          String choice;
          while (true) {
              System.out.print("Do you want to calculate for another car? (yes/no): ");
              choice = scan.next().toLowerCase();
              if (choice.equals("yes") || choice.equals("no")) {
                  break;
              } else {
                  System.out.println("Invalid input. Please enter 'yes' or 'no'.");
              }
          }

          if (choice.equals("no")) {
              break;
          }
      }

      scan.close();
  }
}