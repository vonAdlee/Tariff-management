package tariff_management_system;


public interface TariffPolicy {
	
	String evaluateTrade(double proposedTariff , double minimumTariff);

}
