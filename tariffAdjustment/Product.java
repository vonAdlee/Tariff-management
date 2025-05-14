package tariffAdjustment;

//-------------------------------------------------------------------------------------------
//Assignment 3 COMP 249
//Question: part 1
//Written by: Anis Alouache 
//Student ID: 40273373
//-------------------------------------------------------------------------------------------
public class Product {

// Product object attribute.
	
	private String productName;
	private String country;
	private String category;
	private double initialPrice;
	
	
	
// Constructors
	
	public Product(String productName , String country , String category , double intialPrice)
	{
		this.productName = productName;
		this.country = country;
		this.category = category;
		this.initialPrice = intialPrice;
	}
	
	
	public Product()
	{
		this("unknown" , "unknown" , "unknown" , 00.00);
	}
	

// Assessors and mutators.
	
	public String getProductName()
	{
		return productName;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getCategory()
	{
		return category;
	}
	
	public double getInitialPrice()
	{
		return initialPrice;
	}
	
	
	
	public void setProductName(String productName)
	{
		this.productName = productName;
	}
	
	public void setCountry(String country)
	{
		this.country = country;
	}
	
	public void setCategory(String category)
	{
		this.category = category;
	}
	
	public void setInitialPrice(double initialPrice)
	{
		this.initialPrice = initialPrice;
	}
	
	
// toString() method.
	
	@Override
	public String toString()
	{
		return( productName + "," + country + "," + category + "," + initialPrice);
	}
	
	
// equals() method.
	
	@Override
	public boolean equals(Object otherObj)
	{
		if(otherObj == null)
		{
			return false;
		}
		
		else
			if(this.getClass() != otherObj.getClass())
			{
				return false;
			}
		
			else
			{
				Product product = (Product) otherObj;
				
				return(this.getProductName().equals(product.getProductName()) && this.getCountry().equals(product.getCountry()) && this.getCategory().equals(product.getCategory()) && this.getInitialPrice() == product.getInitialPrice());
			}
	}
	
	
// Method for applying tariffs.
	
	public void applyTariffs()
	{
		final double TARIFF_25 = 0.25;
		final double TARIFF_15 = 0.15;
		final double TARIFF_12 = 0.12;
		final double TARIFF_10 = 0.10;
		final double TARIFF_9 = 0.09;
		final double TARIFF_8 = 0.08;
		final double TARIFF_6 = 0.06;
		final double TARIFF_5 = 0.05;
		final double TARIFF_4 = 0.04;
		
		String compare = this.country.toLowerCase();
		
		switch(compare)
		{
			case "china":
				this.initialPrice += this.initialPrice * TARIFF_25;
				break;
				
			case "usa" :
				if(this.category.equalsIgnoreCase("Electronics"))
				{
					this.initialPrice += this.initialPrice * TARIFF_10;
				}
				break;
				
			case "japan" :
				if(this.category.equalsIgnoreCase("Automobile"))
				{
					this.initialPrice += this.initialPrice * TARIFF_15;
					
				}
				break;
				
			case "india" :
				if(this.category.equalsIgnoreCase("Agriculture"))
				{
					this.initialPrice += this.initialPrice * TARIFF_5;
				}
				break;
				
			case "south korea" :
				if(this.category.equalsIgnoreCase("Electronics"))
				{
					this.initialPrice += this.initialPrice * TARIFF_8;
				}
				
			case "saudi arabia" :
				if(this.category.equalsIgnoreCase("Energy"))
				{
					this.initialPrice += this.initialPrice * TARIFF_12;
				}
				break;
				
			case "germany" :
				if(this.category.equalsIgnoreCase("Manufacturing"))
				{
					this.initialPrice += this.initialPrice * TARIFF_6;
				}
				break;
				
			case "bangledesh" :
				if(this.category.equalsIgnoreCase("Textile"))
				{
					this.initialPrice += this.initialPrice * TARIFF_4;
				}
				break;
				
			case "Brazil" :
				if(this.category.equalsIgnoreCase("Agriculture"))
				{
					this.initialPrice += this.initialPrice * TARIFF_9;
				}
				break;	
		}
	}
	
	
	
	
}
