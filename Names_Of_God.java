//Made by Julian Lopez

import java.io.*;
import java.util.*;

public class Names_Of_God
{
  public static void main(String[] args) throws FileNotFoundException
  {
    PrintStream textF = new PrintStream(new File("godNames.txt"));
    PrintStream terminal = System.out;
    Scanner scan = new Scanner(System.in);

    System.out.println("Do you want the names to be outputed to the terminal or to a text file?");
    System.out.println("Type \"FILE\" or \"TERMINAL\"");
    String outputT = scan.nextLine();

    System.out.println("How many letters do you want to use?");
    System.out.println("WARNING: using more than 5 letters will take more than an hour");
    int numOlet = scan.nextInt();

    if(outputT.equals("FILE"))
      System.setOut(textF);
    if(outputT.equals("TERMINAL"))
      System.setOut(terminal);

    int [] godNum = new int [numOlet];
    for(int i = 0; i < godNum.length; i++)
    {
      godNum[i] = 0;
    }

    createName(godNum, godNum.length);

  }

  public static int [] createName(int [] Name, int count)
  {
    if (count > 0)
    {
      for(int i = 0; i < 26; i++)
      {
        Name[count-1] = i;
        createName(Name, count-1);
      }
    }
    else
    {
      printName(Name);
      System.out.println();
    }
    return Name;
  }

  public static void printName(int [] Numbers)
  {
    int pTrue = 1;
    String letters = "abcdefghijklmnopqrstuvwxyz";

    for(int i = 3; i < Numbers.length; i++)
    {
      if(Numbers[i] == Numbers[i-1] && Numbers[i-1] == Numbers[i-2] && Numbers[i-2] == Numbers[i-3])
      {
        pTrue = 0;
      }
    }
    if(pTrue==1)
    {
      for(int i = 0; i < Numbers.length; i++)
      {
        System.out.print(letters.charAt(Numbers[i]));
      }
    }
  }

}
