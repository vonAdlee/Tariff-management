package tariff_management_system;


public class TradeRequested {

// Trade requested class attributes
	
	String request;
	String destinationCountry;
	String originCountry;
	String productCategory;
	double tradeValue;
	double proposedTariff;
	
//Constructors
	
	public TradeRequested(String request , String destinationCountry , String originCountry , String productCategory, double tradeValue , double minimumTariff)
	{
		this.request = request;
		this.destinationCountry = destinationCountry;
		this.originCountry = originCountry;
		this.productCategory = productCategory;
		this.tradeValue = tradeValue;
		this.proposedTariff = minimumTariff;
	}
	
	public TradeRequested()
	{
		this("unknown" , "unknown" , "unknown" , "unknown" , 00 , 00);
	}
	
	public TradeRequested(TradeRequested tradeRequested)
	{
		this.request = tradeRequested.request;
		this.destinationCountry = tradeRequested.destinationCountry;
		this.originCountry = tradeRequested.originCountry;
		this.productCategory = tradeRequested.productCategory;
		this.tradeValue = tradeRequested.tradeValue;
		this.proposedTariff = tradeRequested.proposedTariff;	
	}
	
// Accessors and mutators.
	
	public String getRequest()
	{
		return this.request;
	}
	
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
	
	public double getTradeValue()
	{
		return this.tradeValue;
	}
	
	public double getProposedTariff()
	{
		return this.proposedTariff;
	}
	
	
// clone method.
	
	public TradeRequested clone()
	{
		return new TradeRequested(this);
	}
	
	
// toString() method .
	
	@Override
	public String toString()
	{
		return("Request: " + this.request + "\nDestination country: " + this.destinationCountry + "\nOrigin country: " + this.originCountry + "\nProduct category: " + this.productCategory + "\nTrade value: " + this.tradeValue + "\nProposed tariff: " + this.proposedTariff);
	}
	
	
}
