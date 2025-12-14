
import com.bst.model.BinaryNode;
import com.bst.services.BinarySearchTreeService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeServiceTest {

    private final BinarySearchTreeService service = new BinarySearchTreeService();

    @Test
    void testInsertSingleNode() {
        BinaryNode root = service.buildTree(new int[]{10});
        assertEquals(10, root.value);
        assertNull(root.left);
        assertNull(root.right);
    }

    @Test
    void testInsertLeftAndRight() {
        BinaryNode root = service.buildTree(new int[]{20, 10, 30});
        assertEquals(20, root.value);
        assertEquals(10, root.left.value);
        assertEquals(30, root.right.value);
    }

    @Test
    void testSequentialInsertOrder() {
        BinaryNode root = service.buildTree(new int[]{20, 10, 30, 5, 15});
        assertEquals(20, root.value);
        assertEquals(10, root.left.value);
        assertEquals(5, root.left.left.value);
        assertEquals(15, root.left.right.value);
        assertEquals(30, root.right.value);
    }
}