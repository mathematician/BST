import java.util.*;

public class Node<T>
{
	Node(Comparable<T> element)
    {
		this.element = element;
        this.left = null;
        this.right = null;
    }

    Node(Comparable<T> element, Node left, Node right)
    {
    	this.element  = element;
        this.left     = left;
        this.right    = right;
    }

    Comparable<T> element;  // Key
    Node left;         		// Left child
    Node right;				//Right child
    
	public int compareTo(Node node) 
	{
		if (this.element.getClass() != null && node.element.getClass() != null)
		{
			if ((this.element.getClass().equals(Integer.TYPE)) || (this.element.getClass().equals(Double.TYPE)) || (node.element.getClass().equals(String.class)))
				this.element = (Comparable<T>) this.element;
			if ((node.element.getClass().equals(Integer.TYPE)) || (node.element.getClass().equals(Double.TYPE)) || (node.element.getClass().equals(String.class)))
				node.element = (Comparable<T>) node.element;
		}
		
		return (this.element).compareTo((T) node.element); 
	}
}
