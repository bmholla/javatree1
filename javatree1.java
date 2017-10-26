import java.util.Random;
import java.util.LinkedList;

class javatree1
{
    public static void main(String[] args)
    {
        Tree<Integer> t = new Tree<Integer>();

        t.insert(5);
        t.insert(3);
        t.insert(4);
        t.insert(2);
        t.insert(7);
        t.insert(8);
        t.insert(6);

        //t.depthFirstTraverse();
        t.breadthFirstTraverse();
    }
}

class Tree<E>
{
    Node<E> head = null;

    Tree() {} 

    void insert(E e)
    {
        if(head == null)
            head = new Node<E>(e);
        else
            insert(e, head);
    }

    private void insert(E e, Node n)
    {
        if(e.hashCode() < n.getValue().hashCode())
        {
            if(n.getLeft() == null)
                n.setLeft(new Node<E>(e));
            else
                insert(e, n.getLeft());
        }
        else
        {
            if(n.getRight() == null)
                n.setRight(new Node<E>(e));
            else
                insert(e, n.getRight());
        }
    }

    void depthFirstTraverse()
    {
        depthFirstTraverse(head);
    }

    private void depthFirstTraverse(Node n)
    {
        if(n == null)
            return;
        else
        {
            System.out.println(n.getValue());
            if(n.getLeft() != null)
                depthFirstTraverse(n.getLeft());
            if(n.getRight() != null)
                depthFirstTraverse(n.getRight());
        }
    }

    void breadthFirstTraverse()
    {
        LinkedList<Node> ll = new LinkedList<Node>();

        ll.add(head);

        while(ll.size() > 0)
        {
            Node n = ll.remove();
            System.out.println(n.getValue());
            if(n.getLeft() != null)
                ll.add(n.getLeft());
            if(n.getRight() != null)
                ll.add(n.getRight());
        }
    }
}

class Node<E>
{
    private Node left = null, right = null;
    E e = null;

    Node(E e)
    {
        this.e = e;
    }

    Node(E e, Node left, Node right)
    {
        this.e = e;
        this.left = left;
        this.right = right;
    }
    
    public E getValue()
    {
        return this.e;
    }
    
    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }
    
    public void setLeft(Node n)
    {
        this.left = n;
    }

    public void setRight(Node n)
    {
        this.right = n;
    }
}
