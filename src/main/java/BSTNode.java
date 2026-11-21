import java.lang.Comparable;
import java.util.function.Consumer;


/**
   This is a smart Node that utilizes generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{

   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;



   public BSTNode(T val)
   {
      this(val,null,null);
   }
    

   public BSTNode(T val, BSTNode<T> l,BSTNode<T> r)
   {
      this.val = val;
      this.left = l;
      this.right = r;
   }



   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
      int comparison = target.compareTo(val);

      if((comparison > 0) && right == null){
         right = new BSTNode<>(target);
         return;

       } else if ((comparison < 0) && left == null){
         left = new BSTNode<>(target);
         return;

       } else {

         if((comparison > 0) && right != null){
         right.insert(target);
         return;

       } else if ((comparison < 0) && left != null){
         left.insert(target);
         return;
       }

       }
   }


   /*
     Uses recursion to retrieved the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
      if (target == null) {
         return null;
      }

      int comparison = target.compareTo(val);

      if (comparison == 0) {
         return val;
      }

      if (comparison < 0) {
         if (left == null) {
            return null;
         }
         return left.retrieve(target);
      }

      if (right == null) {
         return null;
      }
      return right.retrieve(target);
   }


    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target)
   {
      return depthFunc(target, 0);
      
   }

   private int depthFunc(T target, int depth) {
      if (target == null) {
         return depth;
      }

      int comparison = target.compareTo(val);

      if (comparison == 0) {
         return depth;
      }

      if (comparison < 0) {
         if (left == null) {
            return depth + 1;
         }
         return left.depthFunc(target, depth + 1);
      }

      if (right == null) {
         return depth + 1;
      }
      return right.depthFunc(target, depth + 1);
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
      if (right == null) {
         return val;
      }
      return right.getLargest();
   }


   /**
      Uses recursion to do an inorder traversals.
      consume is part of a strategy pattern, to determine what the
      "Visit" should be.

    */
   public void inOrderTraversal(Consumer<T> consume)
   {
      if(left != null){
         left.inOrderTraversal(consume);
      }

      consume.accept(val);

      if(right != null){
         right.inOrderTraversal(consume);
      }
   }


   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
      if (that == null) {return false;}

      if (!(val.equals(that.val))) {
         return false;
      }

      boolean leftEquals = (left == null && that.left == null) || (left != null && left.myEquals(that.left));
      boolean rightEquals = (right == null && that.right == null) || (right != null && right.myEquals(that.right));

      return leftEquals && rightEquals;
   

   }

   public BSTNode getRight(){
      return right;
   }
   public void setRight(BSTNode n){
      right = n;
   }


   public BSTNode getLeft(){
      return left;
   }
   public void setLeft(BSTNode n){
      left = n;
   }


   public T getVal(){
      return val;
   }

}
