package com.maggioni.Entities;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;


/*
 *
 * @author magang
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = Stock.FIND_ALL, query = "select p from Stock p order by p.symbol"),
    @NamedQuery(name = Stock.FIND_BY_SYMBOL, query = "select p from Stock p where p.symbol=:sy")
})
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public static final String FIND_ALL = "Stock.findAll";
    public static final String FIND_BY_SYMBOL = "Stock.findBySymbol";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String symbol;
    private String name;
    
    @OneToMany(mappedBy = "stock", cascade= CascadeType.ALL, orphanRemoval = true)
    @MapKeyColumn(name="INTERVAL_TYPE_ID")
    private Map<String,Barsize> barsize = new HashMap();;

    public Stock()
    {
    }

    public Stock(String symbol, String name)
    {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
       
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Map<String, Barsize> getBarSize() {
        return barsize;
    }

    public Barsize getOneBarSize(String intervaltype){
        
        return this.barsize.get(intervaltype);
    }
    
    public void setBarSize(Map<String, Barsize> quotes) {
        this.barsize = quotes;
    }
    
    public void addIntervalType(String intervaltype){
        Barsize bz = new Barsize();
        bz.setStock(this);
        this.barsize.put(intervaltype, bz);
    }

    public List<Quote> getQuotes(String intervaltype)
    {
        return this.barsize.get(intervaltype).getQuotes();
    }
    
    
    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.symbol);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.barsize);
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
        final Stock other = (Stock) obj;
        if (!Objects.equals(this.id, other.id))
        {
            return false;
        }
        if (!Objects.equals(this.symbol, other.symbol))
        {
            return false;
        }
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.barsize, other.barsize))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return " Symbol[ id=" + id + " ] "
                + " Symbol : " + this.symbol
                + " Name : " + this.name;
    }
    
    public String intervalToString(){
        
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Barsize> entry : barsize.entrySet()) {
            String intervaltype = entry.getKey();
            Barsize barsize = entry.getValue();
            sb.append(" IntervalType : ");
            sb.append(intervaltype);
            sb.append(barsize.quotesToString());
            sb.append("\n"); 
            sb.append("Last Quote"); 
            sb.append(barsize.getLastQuote().toString());
            sb.append("\n");
                                 
        } 
        
        
        return sb.toString();
    }

}
