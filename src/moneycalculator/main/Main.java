package moneycalculator.main;

import moneycalculator.control.CalculateCommand;
import moneycalculator.persistence.CurrencyListLoader;
import moneycalculator.persistence.ExchangeRateLoader;
import moneycalculator.persistence.rest.RestExchangeRateLoader;
import moneycalculator.persistence.file.FileCurrencyListLoader;

public class Main {

    public static void main (String [] args) {
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies.txt");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDisplay(), mainFrame.getMoneyDialog(), exchangeRateLoader));
    }

}