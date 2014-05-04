import java.io.*; 
import java.util.Scanner;


public class BSTexercise
{
   public static void main ( String[] args ) throws FileNotFoundException
   {  
	  Comparable tmp;
	  Double tmpDouble;
      java.util.Scanner console = new java.util.Scanner(System.in);
	  Scanner readA1 = new Scanner(new FileReader("C:\\input\\inputA1.txt"));
	  Scanner readA2 = new Scanner(new FileReader("C:\\input\\inputA2.txt"));
	  Scanner readB1 = new Scanner(new FileReader("C:\\input\\inputB1.txt"));
	  Scanner readB2 = new Scanner(new FileReader("C:\\input\\inputB2.txt"));
	  
      BinarySearchTree treeA1 = new BinarySearchTree("i");
      BinarySearchTree treeA2 = new BinarySearchTree("d");
      BinarySearchTree treeB1 = new BinarySearchTree("i");
      BinarySearchTree treeB2 = new BinarySearchTree("d");
      
      treeA1.makeEmpty();
      treeA2.makeEmpty();
      treeB1.makeEmpty();
      treeB2.makeEmpty();

      while (readA1.hasNext())  	  
    	  treeA1.insert(readA1.nextInt());
      
      while (readA2.hasNext())  	  
    	  treeA2.insert(readA2.nextDouble());
     /* 
      while (readB1.hasNext())  	  
    	  treeB1.insert(readB1.nextInt());
      
      while (readB2.hasNext())  	  
    	  treeB2.insert(readB2.nextDouble());
      */
      
      System.out.print("TreeA1 \n In-Order: ");
      System.out.println(treeA1.printTree());
      treeA1.findMax();
      treeA1.findMin();
      System.out.print("TreeA2 \n In-Order: ");
      System.out.println(treeA2.printTree());
      treeA2.findMax();
      treeA2.findMin();
      
      /*
      System.out.print("TreeB1 \n In-Order: ");
      System.out.println((treeB1.printTree()));
      treeB1.findMax();
      treeB1.findMin();
      System.out.print("TreeB2 \n In-Order: ");
      System.out.println(treeB2.printTree());
      treeB2.findMax();
      treeB2.findMin();
      */
      
      System.out.println("\nRemoving keys in TreeB1.txt from TreeA1");
      while (readB1.hasNext())
      {
    	  tmp = readB1.nextInt();
    	  if (treeA1.contains(tmp))
    		  treeA1.delete(tmp);
      }
      System.out.println(treeA1.printTree());
      
      
      System.out.println("\nRemoving keys in TreeB2.txt from TreeA2");
      while (readB2.hasNext())
      {
    	  tmpDouble = readB2.nextDouble();
    	  if (treeA2.contains(tmpDouble))
    		  treeA2.delete(tmpDouble);
      }
      System.out.println(treeA2.printTree());
   }
}
