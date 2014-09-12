package com.maggioni.service;

import com.maggioni.Entities.Stock;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author angelomaggioni
 */
@Path("/stocks")
public class StocksREST
{

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello There";
    }
    
    @POST
    @Consumes("application/xml")
    public Response createStock(InputStream is)
    {
        Stock stock = readStock(is);

        System.out.println("created stock. " + stock.getSymbol());
        return Response.created(URI.create("/resources/stocks/" + stock.getSymbol())).build();

    }

    @GET
    @Produces("application/xml")
    public StreamingOutput getStock(@PathParam("symbol") String symbol)
    {

        Stock stock = findStock(symbol);
        if (stock == null)
        {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return new StreamingOutput()
        {
            @Override
            public void write(OutputStream outputStream) throws IOException, WebApplicationException
            {
                outputStock(outputStream, stock);
            }
        };
    }

    protected Stock readStock(InputStream is)
    {
        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            Element root = doc.getDocumentElement();

            Stock stock = new Stock();

            if (root.getAttribute("symbol") != null && !root.getAttribute("symbol").trim().equals(""))
            {
                stock.setSymbol(root.getAttribute("symbol"));
                NodeList nodes = root.getChildNodes();
                for (int i = 0; i < nodes.getLength(); i++)
                {
                    Element element = (Element) nodes.item(i);
                    if (element.getTagName().equals("name"))
                    {
                        stock.setName(element.getTextContent());
                    }
                }
            }
            return stock;
        } catch (Exception ex)
        {
            throw new WebApplicationException(ex, Response.Status.BAD_REQUEST);
        }
    }

    private Stock findStock(String symbol)
    {

        Stock stock = new Stock();
        return stock;
    }

    protected void outputStock(OutputStream os, Stock stock)
    {

    }

}
