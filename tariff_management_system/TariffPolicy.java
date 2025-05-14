package tariff_management_system;
//-------------------------------------------------------------------------------------------
//Assignment 3 COMP 249
//Question: part 2
//Written by: Anis Alouache 
//Student ID: 40273373
//-------------------------------------------------------------------------------------------

public interface TariffPolicy {
	
	String evaluateTrade(double proposedTariff , double minimumTariff);

}
