/* Name: Mohamed Ameen Omar
   Student Number: u16055323
 */




//Self-Organizing List
public class SOList<T extends Comparable<T>> extends DLList<T> {
	
	public void access(T value) 
	{

		if(isEmpty())
		{
			addToTail(value);
		}
		//if only one element
		else if(getCount() == 1)
		{
			if(head.value == value)
			{
				return;//already in the first element
			}

			//add it in if not in the list
			else
			{
				addToTail(value);
			}

		}

		//if in the middle 
		else
		{

			DLNode temp = head;

			boolean found = false;

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
				//temp points to the node we need to move

				//check if the last element
				if(temp == tail)
				{
					temp = temp.prev;
					temp.next = null;
					tail.prev = null;
					tail.next = head;
					head.prev = tail;
					tail = temp;
					head = tail;
					tail = temp;
				}
				
				else if(temp == head)
				{
					return;
				}
				
				//Any other element
				else
				{
					DLNode next = temp.next;
					DLNode previous = temp.prev;

					previous.next = next;
					next.prev = previous;

					temp.next = head;
					head.prev = temp;
					temp.prev = null;
					head = temp;

					//make null so only refernce is the nodes and fields within the class or object
					next = null;
					prev = null;
					temp = null;
				}
			}	

			//not found in the list
			else
			{
				addToTail(value);
			}	


		}



	}
}