package project3;
 public class Main{
 	  public static void main(String[] args) {
 	      Customer c1=new Customer("LiMing");
 	      c1. addRental(new Rental(new Movie("Jack",2),6));
 	      System. out.print(c1.statement());
 	  }
 	} 