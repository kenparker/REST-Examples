package com.maggioni.jersey.client.example_2;

/**
 *
 * @author magang
 */
public class HelloClientMain2
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        HelloClient helloObj = new HelloClient();
        
        System.out.println(helloObj.sayHtmlHello());
        System.out.println(helloObj.sayPlainTextHello());
        System.out.println(helloObj.sayXMLHello());
        helloObj.close();

    }

}
