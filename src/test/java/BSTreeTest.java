import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BSTreeTest {
    
    

    @Test
    void testAll() {
        
        BSTree testTree = new BSTree();

        // //Testing an empty tree
        // assertTrue(testTree.isEmpty());
        // assertNull(testTree.retrieve(10));
        // assertNull(testTree.largest());
        // assertEquals(0, testTree.sum());
        // assertEquals(0, testTree.getSize());
        // assertEquals(0, testTree.retrieveDepth(5));
        // BSTree empty1 = new BSTree();
        // BSTree empty2 = new BSTree();
        // assertTrue(empty1.myEquals(empty2));
        

        
        // Testing the insertions
        testTree.insert(10);
        testTree.insert(15);
        testTree.insert(5);
        testTree.insert(85);
        testTree.insert(70);
        testTree.insert(2);
        testTree.insert(8);
        testTree.insert(6);
        testTree.insert(9);

        // Checks the empty is not empty and retrieving as well 
        // assertFalse(empty1.myEquals(testTree));  
        // assertFalse(testTree.myEquals(empty1));
        // assertFalse(testTree.isEmpty());
        // assertEquals(10, testTree.retrieve(10));
        // assertEquals(9, testTree.retrieve(9));
        // assertEquals(85, testTree.retrieve(85));
        // assertNull(testTree.retrieve(7));     //values that are not there
        // assertNull(testTree.retrieve(100));


        // Distance from root
        assertEquals(0, testTree.retrieveDepth(10));
        assertEquals(1, testTree.retrieveDepth(15));
        assertEquals(1, testTree.retrieveDepth(5));
        assertEquals(2, testTree.retrieveDepth(85));
        assertEquals(3, testTree.retrieveDepth(9));
        assertEquals(4, testTree.retrieveDepth(7));


        BSTree newTestTree = new BSTree();
        assertNull(newTestTree.largest()); // largest on null

        newTestTree.insert(10);
        assertEquals(10, newTestTree.largest());

        newTestTree.insert(15);
        newTestTree.insert(5);
        newTestTree.insert(85);
        newTestTree.insert(70);
        assertEquals(85, newTestTree.largest());
        
        assertEquals(List.of(2, 5, 6, 8, 9, 10, 15, 70, 85), testTree.toList());
        assertEquals(210, testTree.sum());
        assertEquals(9, testTree.getSize());


        
        BSTree tree2 = new BSTree();
        tree2.insert(10);
        tree2.insert(15);
        tree2.insert(5);
        tree2.insert(85);
        tree2.insert(70);
        tree2.insert(2);
        tree2.insert(8);
        tree2.insert(6);
        tree2.insert(9);
        assertTrue(testTree.myEquals(tree2));

        
        tree2.insert(1);
        assertFalse(testTree.myEquals(tree2));

        
        
        BSTree treeA = new BSTree();
        treeA.insert(5);
        treeA.insert(1);
        treeA.insert(10);

        BSTree treeB = new BSTree();
        treeB.insert(1);
        treeB.insert(5);
        treeB.insert(10);
        assertFalse(treeA.myEquals(treeB));
        

        BSTree oneTree = new BSTree();
        oneTree.insert(7);
        assertEquals(7, oneTree.largest());

        
        BSTree leftTree = new BSTree();
        leftTree.insert(20);
        leftTree.insert(10);
        leftTree.insert(5);
        assertEquals(20, leftTree.largest());

       
        BSTree rightTree = new BSTree();
        rightTree.insert(1);
        rightTree.insert(2);
        rightTree.insert(3);
        rightTree.insert(4);
        assertEquals(4, rightTree.largest());

        BSTree treea1 = new BSTree();
        BSTree treea2 = new BSTree();
        treea1.insert(42);
        treea2.insert(42);
        assertTrue(treea1.myEquals(treea2));

        treea2.insert(99);
        assertFalse(treea1.myEquals(treea2));




    }
}
