/**
 * Maman 12 Q2 
 *
 * @author Pr0metheus 
 * @version 12.12.2019
 */
public class FoodItem
{
    private final String name;
    private long catalogueNumber;
    private int quantity,price,temp;
    private Date productionDate,expiryDate; 
    private final int minTemperature,maxTemperature;
    final int four = 4, zero = 0, defultNum = 9999, defultP = 1; 
    final String defultName = "item";
    
      /**
    * Initialize an instance of a FoodItem with the given parameters
    * @param name the FoodItems name
    * @param catalogueNumber the FoodItems catalogue number
    * @param quantity the FoodItems quantity
    * @param productionDate the FoodItems production date
    * @param expiryDate the FoodItems expiry date
    * @param minTemperature the FoodItems minimum storage temperature
    * @param maxTemperature the FoodItems maximum storage temperature
    * @param price the FoodItems unit price
    */
    FoodItem (String names, long catalogueNumbers,
    int quantitys, Date productionDates, Date
    expiryDates, int minTemperatures, int
    maxTemperatures, int prices)
    {
        //Check if name is empty 
        if(names == "")
        {
            name = defultName;
        }
        
        else
        {
            name = names;
        }
        
        //Check if catalogueNumber is not a natural number with 4 digits 
        if(catalogueNumbers>9999 || catalogueNumbers<1000)
        {
            catalogueNumber = defultNum;
        }
        
        else
        {
            catalogueNumber = catalogueNumbers;
        }
        
        //Check if quantity is a negaitve number 
        if(quantitys<0)
        {
            quantity = zero; 
        }
        
        else
        {
            quantity = quantitys;
        }
        
        //Check if price is a negative number
        if(prices<0)
        {
            price  = defultP;
        }
        
        else
        {
            price = prices;
        }
        
        //Check if expiryDate is before ProductionDate
        if(productionDates.after(expiryDates))
        {
            expiryDate = productionDates.tomorrow();
        }
        
        else
        {
            productionDate = productionDates;
            expiryDate = expiryDates;
        }
        
        //Check if minTemperature is greater than maxTemperature
        if(minTemperatures>maxTemperatures)
        {
            temp = minTemperatures;
            minTemperature = maxTemperatures;
            maxTemperature = temp;
        }
        
        else
        {
            maxTemperature = maxTemperatures;
            minTemperature = minTemperatures;
        }
    }
    
     /**
    * Copy Constructer 
    * @param Date a given Date object
    */
    //Copy constructor.
    public FoodItem(FoodItem food) 
    {
    this(food.getName(),food.getCatalogueNumber(),food.getQuantity(),
    food.getProductionDate(),food.getExpiryDate(),food.getMinTemperature(),
    food.getMaxTemperature(),food.getPrice());
    }
    
    //FoodItem get methods 
    /**
    * Return the catalogueNumber of a given FoodItem
    * @return FoodItems catalogueNumber
    */
    public long getCatalogueNumber()
    {
        return catalogueNumber;
    }
    
    /**
    * Return the name of a given FoodItem
    * @return FoodItems name
    */
    public String getName()
    {
        return name;
    }
    
    /**
    * Return the quantity of a given FoodItem
    * @return FoodItems quantity
    */
    public int getQuantity()
    {
        return quantity;
    }
    
    /**
    * Return the production date of a given FoodItem
    * @return FoodItems production date
    */
    public Date getProductionDate()
    {
        return productionDate;
    }
    
    /**
    * Return the expiry date of a given FoodItem
    * @return FoodItems expiry date
    */
    public Date getExpiryDate()
    {
        return expiryDate;
    }
    
    /**
    * Return the minimum storage temperature of a given FoodItem
    * @return FoodItems minimum storage temperature
    */
    public int getMinTemperature()
    {
        return minTemperature;
    }
    
    /**
    * Return the maximum storage temperature of a given FoodItem
    * @return FoodItems maximum storage temperature
    */
    public int getMaxTemperature()
    {
        return maxTemperature;
    }
    
    /**
    * Return the unit price of a given FoodItem
    * @return FoodItems unit price
    */
    public int getPrice()
    {
        return price;
    }
    
    //FoodItem set methods 
    /**
    * Update the FoodItem quantity with the given parameter if positive 
    * @param n new FoodItems quantity
    */
    public void setQuantity(int n)
    {
         if(n<0)
         {
             ;
         }
         
         else
         {
             quantity = n;
         }
    }
    
    /**
    * Update the FoodItem production date with the given parameter if not after expiry date 
    * @param d new FoodItems production date
    */
    public void setProductionDate(Date d)
    {
        if(d.after(expiryDate))
        {
            ;
        }
        
        else
        {
            productionDate = d;
        }
    }
    
    /**
    * Update the FoodItem expiry date with the given parameter if not before production date 
    * @param d new FoodItems expiry date
    */
    public void setExpiryDate(Date d)
    {
        if(d.before(productionDate))
        {
            ;
        }
        
        else
        {
            expiryDate = d;
        }
    }
    
     /**
    * Update the FoodItem unit price with the given parameter if positive
    * @param n new FoodItems unit price
    */
    public void setPrice(int n)
    {
        if(n<zero)
        {
            ;
        }
        
        else
        {
            price = n;
        }
    }
    
    /**
    * Return true if this object and other object are equal  
    * @param other the other FoodItem
    * @return true if both objects are equal, otherwise false
    */
    //equals method 
    public boolean equals(FoodItem other)
    {
        boolean equal = false; 
        
        if (this == other) //Check if they point ot the same place in memory 
         {
            equal = true;
         }
         
        else if (other == null) //Check if second date is "alive" :)
         {
            equal = false;
         }
       
        //Check if equal
        if(this.name.equals(other.name) && this.catalogueNumber == 
        other.catalogueNumber && this.productionDate.equals(other.productionDate)
        && this.expiryDate.equals(other.expiryDate) && this.minTemperature ==
        other.minTemperature && this.maxTemperature == other.maxTemperature &&
        this.price == other.price)
        {
            equal = true;
        }
        
        return equal; 
    }
    
     /**
    * Return true the FoodItem is fresh  
    * @param d some Date 
    * @return true if the Date is before the expiry date and after the production date
    */
    public boolean isFresh(Date d)
    {
        boolean fresh = false;
        
        if(expiryDate.after(d) && productionDate.before(d))
        {
            fresh = true;
        }
        
        return fresh;
    }
    
    /**
    * Return string to be printed 
    * @return the String to be printed (String will be of the sort FoodItem: string CatalogueNumber: int ProductionDate: Date 
    * ExpiryDate: Date Quantity: int)

    */
    //To string method 
    public String toString()
    {
        return "FoodItem: " + name + "\t" + "CatalogueNumber: " + 
        catalogueNumber + "\t" + "ProductionDate: " + productionDate + 
        "\t" + "ExpiryDate: " + expiryDate + "\t" + "Quantity: " + quantity;
    }
    
     /**
    * Return true if this FoodItem was created before other FoodItem
    * @param other the other FoodItem
    * @return true if this FoodItem was created before other FoodItem

    */
    //Method to check if FoodItem was created before other FoodItem
    public boolean olderFoodItem(FoodItem other)
    {
        boolean older = false;
        
        if(this.productionDate.before(other.productionDate))
        {
            older = true;
        }
        
        return older;
    }
    
     /**
    * Return true if this FoodItem is cheaper than other FoodItem
    * @param other the other FoodItem
    * @return true if this FoodItem is cheaper than other FoodItem

    */
    //Method to check if FoodItem is cheaper than other FoodItem
    public boolean isCheaper(FoodItem other)
    {
        boolean cheaper = false;
        
        if(this.price < other.price)
        {
            cheaper = true; 
        }
        
        return cheaper;
    }
    
    /**
    * Return the number of units of products that can be purchased for a given amount
    * @param amount amount to purchase
    * @return the number of units that can be purchased

    */
    //Method to check how many units of product you can buy with given amount 
    public int howManyItems(int amount)
    {
        int num = amount/price;
        
        if(num>quantity)
        {
            return quantity;
        }
        
        else
        {
            return num;
        }
    }
            
}
