package tariff_management_system;
import java.util.NoSuchElementException;

//-------------------------------------------------------------------------------------------
//Assignment 3 COMP 249
//Question: part 2
//Written by: Anis Alouache 
//Student ID: 40273373
//-------------------------------------------------------------------------------------------

public class TariffList implements TariffPolicy {
	
// Attributes
	
	private TariffNode head;
	private int size;
	
// Constructors
	
	public TariffList()
	{
		head = null;
		size = 0;
	}
	
	public TariffList(TariffList tariffList)  // No privacy leak because we are making a deep copy by creating a new TariffNode object
	{
		if(tariffList.head == null)
		{
			new TariffList();
		}
		else
		{
			this.head = new TariffNode(tariffList.head);
			this.size = tariffList.size;
		}
		
	}
	
// Clone method
	
	public TariffList clone()
	{
		return new TariffList(this);
	}
	
	
	
// Method that evaluates the proposed tariff.
	
	public String evaluateTrade(double proposedTariff , double minimumTariff)
	{
		if(proposedTariff > minimumTariff)
		{
			return ("Accepted");
		}
		
		double within20minimum = (minimumTariff - proposedTariff)/100;
				
		
			if(proposedTariff < minimumTariff && within20minimum < 20 )
			{
				return ("Conditionally Accepted");
			}
		
			else
			{
				return ("Rejected");
			}
	}

	
	
	
// An add to start method that add a tariff node at the beginning of the list.
	
	public void addToStart(Tariff tariff)
	{
		if(size == 0)
		{
			head = new TariffNode(tariff , null);				// If the list is empty, the first element is by default the head.
		}
		
		else
		{
			TariffNode newTariff = new TariffNode(tariff , head);
			head = newTariff;
		}
		
		size++;
	}
	

// A method that insert a node at a specific index. NOTE: index count starts from 0 !!!
	
	public void insertAtIndex(Tariff tariff , int index) throws NoSuchElementException
	{
		if(index == 0 || size == 0)						// Use add to start method if the list is empty (there should be always a beginning for the journey) or the index is 0 
		{
			this.addToStart(tariff);						
		}
		
		
		else
			if(index < 0 || index > size -1 )
			{
				throw new NoSuchElementException("Invalid index");								// An exception is thrown is the index is out of boundary.
			}
		
		else
		{
			TariffNode position = head; 								
			int stop = 0;
			
			while(stop != index - 1)
			{
				position = position.next;			// position changes its position till it reaches the element before the index
				stop++;
			}
			
			TariffNode tariffNode = new TariffNode(tariff , position.next);
			position.setNext(tariffNode);
			size++;
		}
		
		
	}
	
	
	
// A delete by index method that deletes a node from the specified index.
	
	public void deleteFromIndex(int index)
	{
			
			
			if(size == 0)
			{
				System.out.println("Cannot delete. The list is empty");
			}
			
			else
				if(index == 0)
				{
					this.deleteFromStart();
				}
			
				else
					if(index < 0 || index > size -1 )
					{
						throw new NoSuchElementException("Invalid index");
					}
			
					else
					{
						TariffNode position = head;
						int stop = 0 ;
						
						while(stop != index - 1)
						{
							position = position.next;
							stop++;
						}
						
						TariffNode deletedNode = position.next;
						position.setNext(deletedNode.next);
						deletedNode.setNext(null);
						
						size--;
					}

			
			
	}
	
	
	

	
// A delete from start method that deletes the first node in the list
	
	public void deleteFromStart()
	{
		if(size == 0)
		{
			System.out.println("Cannot delete. The list is empty");
		}
		
		else
			if(size == 1)
		{
			head = null;
			size--;
		}
		
		else
		{
			TariffNode position = head;
			head = head.next;
			
			position.setNext(null);
			
			size--;
		}
	}
	
	
// Method that replace a node at the specified index with the provided node.
	
	public void replaceAtIndex(Tariff tariff , int index) throws NoSuchElementException
	{
		if(size == 0)
		{
			System.out.println("Cannot replace a tariff regulation from an empty list");
		}
		
		else
			if(index < 0 || index > size -1 )
			{
				throw new NoSuchElementException("Invalid index");
			}
		
			else
				if(index == 0)
				{
					TariffNode ReplacementNode = new TariffNode(tariff , head.next);
					head.setNext(null);
					head = ReplacementNode;
				}
		
			else
			{
				TariffNode position = head;
				int stop = 0;
				
				while(stop != index - 1)
				{
					position = position.next;
					stop++;
				}
				
				TariffNode ReplacementTariff = new TariffNode(tariff , position.next.next);
				TariffNode ReplacedTariff = position.next;
				
				ReplacedTariff.setNext(null);
				position.setNext(ReplacementTariff);
				
			}
	}
	
// Find method that searches a node that contains a tariff with similar passed attribute except minimum tariff.
// Privacy Leak!! this method allows privacy leak because we are return a reference of the Tariff not a copy of it.
	
	public Tariff find(String destination , String origin  , String category)
	{
		if(size == 0)
		{
			System.out.println("List is empty, tariff regulation not found");
			return null;
		}
		
		else
		{
			
			boolean found = false;
		
			TariffNode position = head;
			Tariff foundTariff = null;
		
			int iterations = 0;
	
			while(position != null && !found)
			{
				if(position.tariff.getDestinationCountry().equals(destination) && position.tariff.getOriginCountry().equals(origin) && position.tariff.getProductCategory().equals(category))
				{
					
					foundTariff = position.tariff;
					found = true;
				}
			
			else
			{
				position = position.next;
				iterations++;
			}
		}
		
		if(foundTariff == null)
		{
			System.out.println("No such tariff Regulation found");
		}
		return foundTariff;
		}
	}
	
	
// Method that searches a node that contains a tariff with similar passed attributes except minimum tariff
	
	public boolean contains(String destination , String origin  , String category)
	{
		if(size == 0)
		{
			return false;
		}
		
		else
		{
			boolean contain = false;
			
			TariffNode position = head;
			
			boolean exist = false;
					
			while(position != null && !contain)
			{
				if(position.tariff.getDestinationCountry().equals(destination) && position.tariff.getOriginCountry().equals(origin) && position.tariff.getProductCategory().equals(category))
				{
					contain = true;
					exist = true;
				
				}
				
				else
				{
					position = position.next;
				}
			}
			
			return exist;
		}
	}
	
	
// equals method that compare is node has the exact tariff regulation passed as parameter.
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null)
		{
			return false;
		}
		
		else
			if(this.getClass() != obj.getClass())
			{
				return false;
			}
		
			else
			{
				TariffList tariffList = (TariffList) obj;
				
				boolean exit = false;
				boolean equals = true;
				
				TariffNode position = head;
				TariffNode otherPosition = tariffList.head;
				
				while(position != null && otherPosition != null && !exit)
				{
					if(position.tariff.equals(otherPosition.tariff))
					{
						position = position.next;
						otherPosition = otherPosition.next;
						
					}
					
					else
					{
						equals = false;
						exit = false;
					}
				}
				
				return equals;
			}
	}
	
// Method that returns the size of the list
	
	public int getSize()
	{
		return size;
	}
	
// Display method which displays the all the nodes of the list.
	
	public void display()
	{
		if(size == 0)
		{
			System.out.println("This list contains 0 tariff regulations");
		}
		
		else
		{
			System.out.println(head.tariff.toString());
			
			TariffNode position = head;
			
			while(position.next != null)
			{
				position = position.next;
				System.out.println(position.tariff);
			}
		}
		
	}
	

	
	
	
	
	
	

	

	
	
	
	
	
	
	
	
// Private class 
	
	private class TariffNode{
		
		private Tariff tariff;
		private TariffNode next;
		
		public TariffNode()
		{
			this(null , null);
		}
		
		public TariffNode(Tariff tariff , TariffNode tariffNode)
		{
			this.tariff = tariff;
			this.next = tariffNode;
		}
		
		
		public TariffNode(TariffNode tariffNode)
		{
			Tariff tariff = tariffNode.tariff.clone();
			
			this.tariff = tariff;
			this.next = tariffNode.next;	
		}
		
		
		
		
// Accessors and mutators.
		
		public Tariff getTariff()
		{
			Tariff tariff = new Tariff(this.tariff);
			return tariff;
		}
		
		public TariffNode getNext()
		{
			return this.next;
		}
		
		public void setTariff(Tariff tariff)
		{
			this.tariff = tariff;
		}
		
		public void setNext(TariffNode tariffNode)
		{
			this.next = tariffNode;
		}
		
		
// equals() method that compare a Tariff node with passed one.
		
		@Override
		public boolean equals(Object obj)
		{
			if(obj == null)
			{
				return false;
			}
			
			else
				if(this.getClass() != obj.getClass())
				{
					return false;
				}
			
				else
				{
					TariffNode tariffNode = (TariffNode) obj;
					
					return this.tariff.equals(tariffNode.tariff);
				}
		}

		
		
	}

}
