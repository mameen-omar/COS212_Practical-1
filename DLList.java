/* Name: Mohamed Ameen Omar
   Student Number: u16055323
 */

public class DLList<T extends Comparable<T>> {
	
	protected DLNode head = null;
	protected DLNode tail = null;
	
	/*
	This method should create a new node with storing "value" and add it to the end of the list.
	*/
	public void addToHead(T value)
	{
		if(isEmpty())
		{
			DLNode temp = new DLNode(value);
			
			temp.next = null;
			temp.prev = null;
			head = temp;
			tail = temp;

			temp = null;
		}

		else
		{
			DLNode temp = new DLNode(value);
			
			temp.next = head;
			head.prev = temp;
			head = temp;

			temp = null;
		}

	}
	
	/*
	Inserts an element to the tail of the list.
	*/
	public void addToTail(T value)
	{
		//Will be the first node
		if(isEmpty())
		{
			DLNode temp = new DLNode(value);
			
			temp.next = null;
			temp.prev = null;
			head = temp;
			tail = temp;

			temp = null;
		}

		else
		{
			DLNode temp = new DLNode(value);

			temp.next = null;
			temp.prev = tail;
			tail.next = temp;
			tail = temp;

			temp = null;
		}
	}

	
	public void removeHead() throws EmptyListException
	{
		if(isEmpty())
		{
			throw new EmptyListException();
		}

		else if(getCount() == 1)
		{
			head = null;
			tail = null;
		}
		else
		{
			head = head.next;

			head.prev = null;
		}
	}
	
	public void removeTail() throws EmptyListException
	{
		if( isEmpty() )
		{
			throw new EmptyListException();
		}

		else if(getCount() == 1)
		{
			head = null;
			tail = null;
		}

		else
		{
			DLNode counter = tail.prev;

			//counter points to the second last element

			counter.next = null;
			tail = counter;

			counter = null;

		}


	}
	
	public void remove(T value) throws EmptyListException
	{
		if(isEmpty())
		{
			throw new EmptyListException();
		}

		else
		{
			if(getCount() == 1)
			{
				if(head.value == value)
				{
					removeHead();
				}
			}

			else
			{
				boolean found = false;

				DLNode temp = head;

				while(temp != null)
				{
					if(temp.value == value)
					{
						found = true;
						break;
					}

					else
					{
						temp = temp.next;
					}
				}

				if(found)
				{
					//if last element
					if(temp == tail)
					{
						removeTail();
					}

					else
					{
						DLNode before = temp.prev;
						DLNode after = temp.next;
						temp = null;
						before.next = after;
						after.prev = before;
					}
				}

				else
				{
					temp = null;
					return;
				}
			}


		}
	}
	
	public boolean isEmpty()
	{
		if ( head == null )
		{
			return true;
		}

		else
		{
			return false;
		}
	}
	
	public int getCount()
	{
		if(isEmpty())
		{
			return 0;
		}

		else
		{
			if(head == tail)
			{
				return 1;
			}

			else
			{
				DLNode temp;

				temp = head;

				int counter = 0;

				while(temp != null)
				{
					temp = temp.next;
					counter++;
				}

				return counter;
			}

		}
	}
	
	public int getPosition(T value)
	{
		if(isEmpty())
		{
			return -1;
		}

		else
		{
			if(head.value == value)
			{
				return 0;
			}

			else if(tail.value == value)
			{
				return getCount()-1;
			}

			//will be in the middle somwhere
			else
			{
				boolean found = false;

				DLNode temp = head;

				int count = 0;

				while(temp != null)
				{
					if(temp.value == value)
					{
						found = true;
						break;
					}

					else
					{
						temp = temp.next;
						count++;
					}
				}//end of while

				if(found)
				{
					return count;
				}

				else
				{
					return -1;
				}
			}
		}
	}
	
	public void printList(boolean verbose) {
		DLNode iter = head;
		String out = "";
		if (verbose) {
			out += " H ="+ (head == null ? " null"  : head.getString()) + "\n";
			out += " T =" +(tail == null ? " null"  : tail.getString()) + "\n";
		}		
		 else {
			 out += "[";
		 }
		while (iter != null) {
			if (verbose) {
				out += iter.getStringVerbose() + (iter == tail ? "" : "\n");
			} else {
				out += iter.getString();
			}
			iter = iter.next;
		}
		if (!verbose) {
			out += "]";	
		}
		System.out.println(out);
	}
	
	protected class DLNode {
		T value;
		DLNode next = null; 
		DLNode prev = null;
		
		DLNode(T _value) {
			value = _value;
		}
		
		String getStringVerbose() {
			return " ("+value+", next = "+(next == null ? "null" : next.value)+", prev = "+(prev == null ? "null" : prev.value)+") ";
		}
		
		String getString() {
			return " ("+value+") ";
		}
	}
}