class Main {
  public static void main(String[] args) {
		
      AVLTreeMS<Integer> tr = new AVLTreeMS<Integer>();
			System.out.println();
      tr.add(4);
      tr.add(5);
      System.out.println("Tree Height:" + tr.height());
      tr.print();
			tr.range();
      tr.add(6);
			
      System.out.println("Tree Height:" + tr.height());
      tr.print();
			tr.range();
      tr.add(1);
      System.out.println("Tree Height:" + tr.height());
      tr.print();
      tr.add(2);
      System.out.println("Tree Height:" + tr.height());
      tr.print();
      tr.add(0);
      System.out.println("Tree Height:" + tr.height());
      tr.print();
      tr.add(3);
      System.out.println("Tree Height:" + tr.height());
      tr.print();
      tr.print2();
   }
    
}
