import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class BSTreeTest {
    
    BSTree testTree = new BSTree();

    @Test
    void testAll() {
        
        BSTree testTree = new BSTree();

        assertTrue(testTree.isEmpty());
        assertNull(testTree.retrieve(10));
        assertNull(testTree.largest());
        assertEquals(0, testTree.sum());
        assertEquals(0, testTree.getSize());
        assertEquals(0, testTree.retrieveDepth(5));

        

        testTree.insert(10);
        testTree.insert(15);
        testTree.insert(5);
        testTree.insert(85);
        testTree.insert(70);
        testTree.insert(2);
        testTree.insert(8);
        testTree.insert(6);
        testTree.insert(9);



        assertFalse(testTree.isEmpty());
        assertEquals(10, testTree.retrieve(10));
        assertEquals(9, testTree.retrieve(9));
        assertEquals(85, testTree.retrieve(85));
        assertNull(testTree.retrieve(7));
        assertNull(testTree.retrieve(100));


        assertEquals(0, testTree.retrieveDepth(10));
        assertEquals(1, testTree.retrieveDepth(15));
        assertEquals(1, testTree.retrieveDepth(5));
        assertEquals(2, testTree.retrieveDepth(85));
        assertEquals(3, testTree.retrieveDepth(9));
        assertEquals(4, testTree.retrieveDepth(7));


        BSTree newTestTree = new BSTree();
        assertNull(newTestTree.largest());

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
        






    }
}
