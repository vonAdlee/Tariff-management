package tariff_management_system;

public class Tariff {

// Tariff attributes.
	
	String destinationCountry;
	String originCountry;
	String productCategory;
	double minimumTariff;
	
// Constructors
	
	public Tariff(String destinationCountry , String originCountry , String productCategory , double minimumTariff)
	{
		this.destinationCountry = destinationCountry;
		this.originCountry = originCountry;
		this.productCategory = productCategory;
		this.minimumTariff = minimumTariff;
	}
	
	public Tariff()
	{
		this("unknown", "unknown", "unknown", 0.0);
	}
	
	public Tariff(Tariff otherTariff)
	{
		this.destinationCountry = otherTariff.destinationCountry;
		this.originCountry = otherTariff.originCountry;
		this.productCategory = otherTariff.productCategory;
		this.minimumTariff = otherTariff.minimumTariff;
	}
	
	
// Accessors and mutators
	
	public String getDestinationCountry()
	{
		return this.destinationCountry;
	}
	
	public String getOriginCountry()
	{
		return this.originCountry;
	}
	
	public String getProductCategory()
	{
		return this.productCategory;
	}
	
	public double getMinimumTariff()
	{
		return this.minimumTariff;
	}
	
	
	public void setDestinationCountry(String destinationCountry)
	{
		this.destinationCountry = destinationCountry;
	}
	
	public void setOriginCountry(String originCountry)
	{
		this.originCountry = originCountry;
	}
	
	public void setProductCategory(String productCategory)
	{
		this.productCategory = productCategory;
	}
	
	public void setMinimumTariff(double minimumTariff)
	{
		this.minimumTariff = minimumTariff;
	}
	
	
// clone method
	
	public Tariff clone()
	{
		return new Tariff(this);
	}
	
// toString() and equals() methods
	
	@Override
	public String toString()
	{
		return("Destination country: " + this.destinationCountry +"\nOrigin country: " + this.originCountry + "\nProduct category: " + this.productCategory + "\nMinimum tariff: " + this.minimumTariff + "\n");
	}
	
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
				Tariff otherTariff = (Tariff) obj;
				
				return(this.destinationCountry.equals(otherTariff.getDestinationCountry()) && this.originCountry.equals(otherTariff.getOriginCountry()) && this.productCategory.equals(otherTariff.getProductCategory()) && this.minimumTariff == otherTariff.getMinimumTariff());
			}
	}
	
	
	
}
