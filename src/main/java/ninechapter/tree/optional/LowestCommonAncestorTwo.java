package ninechapter.tree.optional;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorTwo {

    class ParentTreeNode {
      public ParentTreeNode parent, left, right;
    }

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        if (root == null) return null;
        Set<ParentTreeNode> linkA = new HashSet<>();
        linkA.add(A);
        while(A != root) {
            linkA.add(A.parent);
            A = A.parent;
        }
        while (!linkA.contains(B)) {
            B = B.parent;
        }
        return B;
    }
}
