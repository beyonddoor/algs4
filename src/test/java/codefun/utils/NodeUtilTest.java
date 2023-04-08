package codefun.utils;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class NodeUtilTest {
    @Test
    public void testCreateNodes_5Elements() {
        var list = OpenLinkList.createNodes(new Integer[] {
                1,2,3,4,5
        });
        assertEquals("1 2 3 4 5", list.toString( " "));
    }

    @Test
    public void testCreateNodes_0Elements() {
        var list = OpenLinkList.createNodes(new Integer[] {
        });
        assertNull(list.toString(" "));
    }

    @Test
    public void testCreateNodes_1Elements() {
        var list = OpenLinkList.createNodes(new Integer[] {
                1
        });
        assertEquals("1", list.toString( " "));
    }

    @Test
    public void testDeleteTail_4Elements() {
        var list = OpenLinkList.createNodes(new Integer[] {
                1,2,3,4,5
        });
        list.deleteTail();
        assertEquals("1 2 3 4", list.toString( " "));
    }

    @Test
    public void testDeleteTail_1Element() {
        var list = OpenLinkList.createNodes(new Integer[] {
                1
        });
        list.deleteTail();
        assertNull(list.toString( " "));
    }

    @Test
    public void testDeleteNthNode_5Elements() {
        var list = OpenLinkList.createNodes(new Integer[] {
                1,2,3,4,5
        });
        assertEquals(3, (int)list.deleteNthNode(2));
        assertEquals("1 2 4 5", list.toString(" "));
    }

    @Test
    public void testDeleteNthNode_head() {
        var list = OpenLinkList.createNodes(new Integer[] {
                1,2,3,4,5
        });
        assertEquals(1, (int)list.deleteNthNode(0));
        assertEquals("2 3 4 5", list.toString(" "));
    }

    @Test
    public void testDeleteNthNode_fail() {
        var list = OpenLinkList.createNodes(new Integer[] {
                1,2,3,4,5
        });

        assertThrowsExactly(NoSuchElementException.class, ()->list.deleteNthNode(5));
    }
}