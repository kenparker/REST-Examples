package com.maggioni.ClientREST;

/**
 *
 * @author angelomaggioni
 */
public class StocksRESTClientCall
{

    public static void main(String[] args)
    {
        StocksRESTClient helloObj = new StocksRESTClient();

        String location = helloObj.createStock();
        helloObj.getStock(location);
        helloObj.close();

    }
}
