import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class BinarySearchTree
{
	Node root = null;
	Node current = null;
	String type = "";
	
	BinarySearchTree(String type)
	{
		root = new Node(null, null, null);
		current = new Node(null, null, null);
		this.type = type;
	}
	
	public String printTree() 
	{
		return printTree(root);
	}
	public String printTree(Node root) 
	{ 
		Stack stack = new Stack();
		Node current = root;
		String traverse = null;
		
		if (root == null)
			return "Tree is empty";
		//Step 3: Push current node to stack, set current = current.left until current is null
		stack.push(current);
		while (current.left != null && (current.left).compareTo(current) < 0)
		{
			stack.push((current.left));
			current = current.left;
		}
		
		while (stack.size() > 0)
		{
			current = (Node) stack.pop();
			if (traverse == null)
				traverse = current.element + " ";
			else
				traverse = traverse + current.element + " ";
			
			//If child exists
			if (current.left != null)
			{
				
				if (stack.size() == 0 && (current.left).right != current)
				{
					current = (current.left).right;
					
					stack.push(current);
					while (current.left != null && (current.left).compareTo(current) < 0)
					{
						stack.push((current.left));
						current = current.left;
					}
					
					if (current.left != null)
					{
						
						if ((current.left).right == current && (current.left).compareTo(current) > 0)
						{							
							//find left-most child
							while (current.left != null && (current.left).compareTo(current) < 0)
							{
								stack.push((current.left));
								current = current.left;
							}
						}
					}
				}
				else 
					if ((current.left).right == current && (current.left).compareTo(current) > 0)
					{
						//stack.push(current.left);
						current = current.left;
						stack.push(current);
						
						//find left-most child
						while (current.left != null && (current.left).compareTo(current) < 0)
						{
							stack.push((current.left));
							current = current.left;
						}
					}
			}
			
			
			//Two Child
			if (current.left != null)
			{
				if ((current.left).right != current)
				{
					if (((current.left).right).compareTo(current) > 0)
					{
						current = (current.left).right;
						stack.push(current);
						
						//find left-most child
						while (current.left != null && (current.left).compareTo(current) < 0)
						{
							stack.push((current.left));
							current = current.left;
						}
					}
				}			
			}
		}
		return traverse;
	}

	public boolean contains(Comparable e)
	{
		//System.out.println(e);
		Node current = root;
		
		if (root == null)
			return false;
		
		while (current.element != e)
		{

			//e < current
			if ((current.element).compareTo(e) > 0)
			{
				if (current.left == null)
					break;
				else if ((current.left).compareTo(current) < 0)
					current = current.left;
				else
					break;
			} 
			else //e > current
			{
				if (current.left == null)
					break;
				else if ((current.left).compareTo(current) > 0)
					current = current.left;
				else if (((current).left).right != current)
					current = (current.left).right;
				else
					break;
			}
		}
		
		if (current.element == e)
		{
			System.out.println(e + " is in the tree");
			/* testing purposes
			if (current.left != null)
			{
				if (current.left.compareTo(current) > 0)
					System.out.println("R: " + current.left.element);
				if (current.left.compareTo(current) < 0)
					System.out.println("L: " + current.left.element);
				
				if ((current.left).right != current)
				{
					if ((current.left).right.compareTo(current) > 0)
						System.out.println("R: " + (current.left).right.element);
					if ((current.left).right.compareTo(current) < 0)
						System.out.println("L: " + (current.left).right.element);
				}				
			}
			*/
			return true;
		}
		else
		{
			System.out.println(e + " is not in the tree");
			return false;
		}
		
	}
		public boolean contains(Double e)
		{
			Node current = root;
			//System.out.println(current.element);
			
			if (root == null)
				return false;
			
			while (current.element != e)
			{

				//e < current
				if (e < (Double) current.element)
				{
					if (current.left == null)
						break;
					else if ((current.left).compareTo(current) < 0)
						current = current.left;
					else
						break;
				} 
				else if (e > (Double) current.element)
				{
					if (current.left == null)
						break;
					else if ((current.left).compareTo(current) > 0)
						current = current.left;
					else if (((current).left).right != current)
						current = (current.left).right;
					else
						break;
				}
				else
					break;
			}
			
		if (((Double) current.element).compareTo(e) == 0)
		{
			/* Testing purposes
			System.out.println(e + " is in the tree");
			if (current.left != null)
			{
				if (current.left.compareTo(current) > 0)
					System.out.println("R: " + current.left.element);
				if (current.left.compareTo(current) < 0)
					System.out.println("L: " + current.left.element);
				
				if ((current.left).right != current)
				{
					if ((current.left).right.compareTo(current) > 0)
						System.out.println("R: " + (current.left).right.element);
					if ((current.left).right.compareTo(current) < 0)
						System.out.println("L: " + (current.left).right.element);
				}				
			}
			*/
			return true;
		}
		else
		{
			System.out.println(e + " is not in the tree");
			return false;
		}
	}
	
	public Node find(Comparable e)
	{
		Node current = root;
		while (current.element != e)
		{

			//e < current
			if (current.element.compareTo(e) > 0)
			{
				if (current.left == null)
					break;
				else if ((current.left).compareTo(current) < 0)
					current = current.left;
				else
					break;
			} 
			else //e > current
			{
				if (current.left == null)
					break;
				else if ((current.left).compareTo(current) > 0)
					current = current.left;
				else if (((current).left).right != current)
					current = (current.left).right;
				else
					break;
			}
		}
			
		
		
		if (current.element == e)
			return current;
		else
			return null;
	}
	
	public Node find(Double e)
	{
		Node current = root;
		while (current.element != e)
		{

			//e < current
			if (e < (Double) current.element)
			{
				if (current.left == null)
					break;
				else if ((current.left).compareTo(current) < 0)
					current = current.left;
				else
					break;
			} 
			else if (e > (Double) current.element)
			{
				if (current.left == null)
					break;
				else if ((current.left).compareTo(current) > 0)
					current = current.left;
				else if (((current).left).right != current)
					current = (current.left).right;
				else
					break;
			}
			else
				break;
		}		
		
		if (((Double) current.element).compareTo(e) == 0)
			return current;
		else
			return null;
	}

	void delete(Comparable element) throws FileNotFoundException
	{
		Node current;
		Scanner scanner;
		if (type == "i")
		{
			current = find(element);
			scanner = new Scanner(getChildren(current));
		}
		else
		{
			current = find((Double) element);
			scanner = new Scanner(getChildrenD(current));
		}
		
		//move to parent and delete
		//if no child
		if (current.right == null)
		{
			//delete root
			current = null;
			root = null;
		}
		//If only child
		else if ((current.right).left == current)
		{
			current = current.right;
			current.left = null;
		
		} 
		//if left child or right child
		else if (current.right != null)
		{
				
			if (((current.right).left).right == current)
			{
				current = current.right;
				(current.left).right = current;
			}
			else if (((current.right).right).left == current)
			{
				current = (current.right).right;
				current.left = (current.left).right;
			}
			else if (((current.right).left).right == current)
			{
				current = (current.right).left;
				current.right = (current.right).right;
			}
		}
		
		//contains(2);
		//contains(1);
		//contains(3);
		//contains(4);
		
		
		while (scanner.hasNext())
		{
			if (type == "i")
				insert(Integer.parseInt((scanner.next())));
			if (type == "d")
				insert(Double.parseDouble(scanner.next()));
		}
		
		System.out.println(element + " has been removed");
		
		
	}
	
	public String getChildren(Node root) throws FileNotFoundException 
	{ 
		Stack stack = new Stack();
		Node current = root;
		Comparable element = current.element;
		String children = printTree(current);

		Scanner scanner = new Scanner(children);
		String traverse = "";
		Comparable tmp;

	//	if (traverse.contains((String) current.element))
	//		traverse.replace((String) current.element, "");
		
		while (scanner.hasNext())
		{
			tmp = scanner.nextInt();
			
			if (tmp != element)
				traverse += tmp + " ";
		}
		return traverse;
	}
	
	public String getChildrenD(Node root) throws FileNotFoundException 
	{ 
		Stack stack = new Stack();
		Node current = root;
		Double element = (Double) current.element;
		String children = printTree(current);

		Scanner scanner = new Scanner(children);
		String traverse = "";
		Double tmp;

	//	if (traverse.contains((String) current.element))
	//		traverse.replace((String) current.element, "");
		
		while (scanner.hasNext())
		{
			tmp = scanner.nextDouble();
			if (tmp.compareTo(element) != 0)
				traverse += tmp + " ";
		}
		return traverse;
	}
	
	int count = 0;
	
	void insert(Comparable element)
	{
		if (this.isEmpty())
		{
			this.root = new Node(element, null, null);
		}
		else
		{
			current = root;
			
			while(current != null) 
			{
			  	if (current.left == null)
			  	{
			  		current.left = new Node(element, null, current);
			  		current = null;
			  	}
				  	
				//One child
				//Child is right child (or will be) [current.left > current]
				//New element is less than current
				//New element -> current.left, current.left -> (current.left).right
				else if ((current.left).right == current && current.compareTo(new Node(element, null, null)) > 0 && current.compareTo(current.left) < 0)
				{
					Node tmp = current.left;
					current.left = new Node(element, null, tmp);
				//	(current.left).right = new Node((current.left).element, null, current);
				//	(current.left).element = element;
					current = null;
				}
				
				
				//One child
				//Child is left child [current.left < current]
				//New element is more than current and more than current.left
				//New node -> (current.left).right
				else if ((current.left).right == current && current.compareTo(new Node(element, null, null)) < 0 && current.compareTo(current.left) > 0)
				{
					(current.left).right = new Node(element, null, current);
					current = null;
				}
				
				//One child
				//Child is right child (or will be) [current.left > current]
				//New element is greater than current and greater than current.left(to be right child)
				//Current -> current.left(to be right)
				else if ((current.left).right == current && current.compareTo(new Node(element, null, null)) < 0 && current.compareTo(current.left) < 0)
				{
					current = current.left;
				}
				
				//One child
				//Child is left child [current.left < current]
				//New element is less than current and less than current.left
				//Current -> current.left
				else if ((current.left).right == current && current.compareTo(new Node(element, null, null)) > 0 && (current.left).compareTo(new Node(element, null, null)) > 0)
				{
					current = current.left;
				}
				
				//One child
				//Child is left child [current.left < current]
				//New element is less than current and more than current.left
				//Current -> current.left
				else if ((current.left).right == current && current.compareTo(new Node(element, null, null)) > 0 && (current.left).compareTo(new Node(element, null, null)) < 0)
				{
					current = current.left;
				}
				
				//Two children
				//New element is greater than current
				//Current -> right child
				else if ((current.left).right != current && current.compareTo(new Node(element, null, null)) < 0)
				{
					current = (current.left).right;
				}
				
				//Two children
				//New element is less than current
				//Current -> left child
				else if ((current.left).right != current && current.compareTo(new Node(element, null, null)) > 0)
				{
					current = current.left;
				}
			  }
		}
	}
	
	void findMax()
	{
		Node current = root;
		
		while (current.left != null)
		{
			if ((((current.left).element.compareTo(current.element)) > 0))
			{
				current = current.left;
			}
			else if (((current.left).right).element.compareTo(current.element) > 0)
			{
				current = (current.left).right;
			}
			else
				break;
		}
		
		System.out.println(" Maximum: " + current.element);
	}
	
	void findMin()
	{
		Node current = root;
		
		while (current.left != null)
		{
			if ((current.left != null && ((current.left).element.compareTo(current.element)) < 0))
			{
				current = current.left;
			}
			else 
				break;
		}
		
		System.out.println(" Minimum: " + current.element);
	}
	
	void makeEmpty()
	{	
		//Rest of the data in memory is now unreachable, thus java gets it
		root.left = null;
		root = null;
		
		/* I forgot this was java for a moment.. I prefer c... so I would rather write the garbage collector...	
		while (root != null)
		{
			Node current = root;
			
			while (current != null)
			{			
				//if there is a child, resolve child first
				if (current.left != null)
				{
					current = current.left;
				}
				//If no child, go to parent and then attempt to resolve
				else
				{
					current = current.right;
				}
				
				//One child
				//Delete child if no sub children
				if ((current.left).left == null && (current.left).right == current)
				{
					(current.left).element = null;
					(current.left).right = null;
					current.left = null;
				}
				
				//Two child
				//Delete left child if no sub children
				if ((current.left).left == null && (current.left).right != current)
				{
					Node tmp = current.left;
					current.left = (current.left).right;
					tmp.element = null;
					tmp.right = null;
				}
			}
		} */
	}
	
	boolean isEmpty()
	{
		if (this.root == null)
			return true;
		else
			return false;
	}
}
