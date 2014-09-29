package com.maggioni.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.xml.bind.annotation.XmlRootElement;

/*
* @author magang 
*/
@Entity
@XmlRootElement
public class Barsize implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "BZ_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Stock stock;
    @OneToMany(mappedBy = "barsizeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("datequote ASC")
    private List<Quote> quotes = new ArrayList();

    public Barsize()
    {
    }

    public Stock getStock()
    {
        return stock;
    }

    public void setStock(Stock stock)
    {
        this.stock = stock;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<Quote> getQuotes()
    {
        return quotes;
    }

    public void setQuotes(ArrayList<Quote> quotes)
    {
        this.quotes = quotes;
    }

    public void addQuote(String datequote,
            double openquote,
            double highquote,
            double lowquote,
            double closequote,
            double volume,
            int count,
            double WAP,
            double valueext)
    {
        Quote qo = new Quote();
        qo.setDatequote(datequote);
        qo.setHighquote(highquote);
        qo.setLowquote(lowquote);
        qo.setOpenquote(openquote);
        qo.setVolume(volume);
        qo.setValueext(valueext);
        qo.setWAP(WAP);
        qo.setCount(count);
        qo.setClosequote(closequote);

        qo.setBarsizeowner(this);
        this.quotes.add(qo);
    }

    public void removeQuote(int index){
        this.quotes.remove(index);
    }
    
    public void addCollectionQuote(List<Quote> collectionquotes)
    {
        this.quotes.addAll(collectionquotes);
    }

    public Quote getLastQuote()
    {
        if (this.quotes != null && this.quotes.size() != 0) {
            return this.quotes.get(this.quotes.size() - 1);
        }
        return null;
    }

    public Quote getFirstQuote()
    {
        return this.quotes.get(0);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.stock);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Barsize other = (Barsize) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        if (!Objects.equals(this.stock, other.stock))
        {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString()
    {
        return "Interval[ id=" + id + " ]";
    }

    public String quotesToString()
    {

        StringBuilder sb = new StringBuilder();
        sb.append(" Quotes: ");
        sb.append("\n");
        for (Quote quote : quotes) {
            sb.append(quote.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
