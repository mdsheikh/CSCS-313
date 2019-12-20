import java.lang.Math;
public class AVLTreeMS<E extends Comparable<? super E>>{
	private static class AVLNode<E extends Comparable<? super E>>{
		private E element;
    private AVLNode<E> parent;
    private AVLNode<E> left;
    private AVLNode<E> right;
    int height;
    public AVLNode(E e){
      this(e, null, null);
    }
		public AVLNode(E e, AVLNode<E> l, AVLNode<E> r){
	    element = e;
	    left = l;
	    right = r;
      height = 0;
      if (l != null && r != null) height = Math.max(l.height, r.height) + 1;
      else if (r != null) height = r.height + 1;
      else if (l != null) height = l.height + 1;
      }

			public E getE(){
				return element;
      }
      public AVLNode<E> getParent(){
	      return parent;
      }
      public AVLNode<E> getLeft(){
	      return left;
      }
      public AVLNode<E> getRight(){
	      return right;
      }
      public int getHeight(){
	      return height;
      }
      public void setE(E e){
	      element = e;
      }
      public void setParent(AVLNode<E> p){
	      parent = p;
      }
      public void setLeft(AVLNode<E> l){
	      left = l;
      }
      public void setRight(AVLNode<E> r){
	      right = r;
      }
      public void setHeight(int h){
	      height = h;
      }
	}

	private AVLNode<E> root;
  private int size;
  public AVLTreeMS(){
    root = null;
    size = -1;
   }

	public void add(E e){
		root = add(e, root);
		root.setParent(null);

	} 
	private AVLNode<E> add(E e, AVLNode<E> n){
		if(n==null){
			size++;
			return new AVLNode<E>(e);	
		}

		int compare = e.compareTo(n.getE());
    
		if(compare< 0){
			n.left = add(e, n.left);
			n.left.setParent(n);
		}
		else if(compare > 0){
			n.right = add(e, n.right);
			n.right.setParent(n);
		}
		return n;


	}

	public int height(){
    return height(root);
   }
  private int height(AVLNode<E> n){
    if (n == null) return -1;
		return n.height;
	}
		
				
		public int range(){
			return range(root);

		}
		private int range(AVLNode<E> n){
			if(root == null) return 0;
			int minValue = 0;
			int maxValue = 0;
			while(n.left != null){
				minValue = range(n.left);
			}
			while(n.right != null){
				maxValue = range(n.right);
			}
			return maxValue - minValue;

		}	
	
	public AVLNode<E> rotateLeftChild(){
	  return rotateLeftChild(root);
		
	} 
	private AVLNode<E> rotateLeftChild(AVLNode<E>  n1){
		AVLNode<E>  n2 = n1.left;
		n1.left= n2.right;
		n2.right = n1;

		n1.height = Math.max(height(n1.left) ,height(n1.right)) +1;
		n2.height = Math.max(height(n2.left),height(n2.right)) +1;

		n1.setParent(n2);
		if(n1.left != null){
			n1.left.setParent(n1);
		}
		return n2;

	}
  public int size(){
		return size;
	}
	public void print(){
		System.out.print("Total: " + size());
		inOrder(root);
		System.out.println();
	}
	public void print2(){
		System.out.print("Total: " + size());
		preOrder(root);
		System.out.println();
	} 

	public void inOrder(AVLNode<E> n){
		if(n == null) return;
		inOrder(n.left);
		System.out.print(n.getE() + " , ");
		inOrder(n.right);
	}
	public void preOrder(AVLNode<E> n){
		if(n == null) return;
		System.out.print(n.getE() + " , ");
		preOrder(n.left);
		preOrder(n.right);
	}

}