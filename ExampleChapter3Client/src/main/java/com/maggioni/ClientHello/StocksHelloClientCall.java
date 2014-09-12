package com.maggioni.ClientHello;

/**
 *
 * @author angelomaggioni
 */
public class StocksHelloClientCall
{
public static void main(String[] args)
    {
        StocksHelloClient helloObj = new StocksHelloClient();
        
        System.out.println(helloObj.sayHello());
        helloObj.close();

    }    
}
