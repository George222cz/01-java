package tree;

import calendar.Event;
import calendar.EventSet;
import calendar.Tree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TestTree {
    private Tree<EventSet> emptyTree;
    private Tree<EventSet> tree;
    private EventSet eventSet = new EventSet(new Date(117, 6, 1));

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        emptyTree = new Tree<>();
        tree = new Tree<>();

        tree.add(eventSet);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testEquals() {

        assertNotEquals(tree, emptyTree);
    }

    @Test
    public void testAddingToEmptyTree() {
        emptyTree.add(eventSet);
        assertNotEquals(emptyTree, tree);
    }

}