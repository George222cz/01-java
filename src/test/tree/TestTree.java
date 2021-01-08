package tree;

import calendar.Calendar;
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
    private Tree<EventSet> extraTree;
    private EventSet eventSet1 = new EventSet(new Date(117, 6, 1));
    private EventSet eventSet2 = new EventSet(new Date(117, 6, 2));

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
        tree.add(eventSet1);

        extraTree = new Tree<>();
        extraTree.add(eventSet1);
        extraTree.add(eventSet2);
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
        emptyTree.add(eventSet1);
        assertNotEquals(emptyTree, tree);
    }

    @Test
    public void testRemoveRoot() {
        extraTree.erase(eventSet1);
        assertEquals(tree,extraTree);
    }

    @Test
    public void testRemoveList() {
        extraTree.erase(eventSet2);
        assertEquals(tree,extraTree);
    }

    @Test
    public void testIterateOnEmptyTree() {
        assertFalse(emptyTree.iterator().hasNext());
    }

    @Test
    public void testIterateOnNotEmptyTree() {
        assertTrue(tree.iterator().hasNext());
    }

    @Test
    public void testCalendarDeleteAll() {
        Date testDate = new Date(117, 6, 1);
        Calendar calendar = new Calendar();
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-1"));
        calendar.addEvent(new Event(new Date(117, 6, 2), "2-1"));
        calendar.addEvent(new Event(new Date(117, 6, 3), "3-1"));
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-2"));
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-3"));
        calendar.addEvent(new Event(new Date(117, 6, 1), "1-4"));

        calendar.DeleteAll(testDate);
        assertEquals(null,calendar.eventsList(testDate));
    }


}