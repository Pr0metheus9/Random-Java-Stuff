/**
 * Maman 13 Q1 
 *
 * @author Pr0metheus
 * @version 26.12.2019
 */
public class Stock
{
    /////Instance Variables
    FoodItem[] _stock; 
    private int _noOfItems;
    final int maxStock = 100;
    
    //Method to sort arrray of longs (Using Bubble sort)
    //It goes over every to objects and switches their index if larger number is behind a smaller number 
    //It is slow but easy to write 
    private static long[] sortAlgo(long[] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++) 
            {
                long mp = 0;
                if (arr[i] > arr[j]) 
                {
                    mp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = mp;
                }
            }
        }
        
        return arr;
    }
    
    //Method to sort arrray of ints (Using Bubble sort)
    //It goes over every to objects and switches their index if larger number is behind a smaller number 
    //It is slow but easy to write 
    private static int[] sortInt(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++) 
            {
                int mp = 0;
                if (arr[i] > arr[j]) 
                {
                    mp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = mp;
                }
            }
        }
        
        return arr;
    }
    
    //Order Stock by food items catalogue number in ascending order
    private static FoodItem[] orderStock(FoodItem[] stonks)
    {
        FoodItem[] stonks2 = new FoodItem [stonks.length];
        long [] catanums = new long [stonks.length]; //array of catalogue numbers
        long num; //current object catalogue number 
        
        //Make array of catalogue numbers 
        for (int i = 0; i < stonks.length; i++) 
        {
            if(stonks[i] != null)
            {
                num = stonks[i].getCatalogueNumber();
                catanums[i] = num;
            }
        }
        
        //Sort catalogue numbers
        catanums = sortAlgo(catanums);
        
        for (int k = 0; k < catanums.length; k++)
        {
            for(int j = 0; j < stonks.length; j++)
            {
                if(stonks[j] != null && catanums[k] == stonks[j].getCatalogueNumber())
                {
                    stonks2[k] = stonks[j];
                }
                
                else
                {
                    stonks2[k] = null;
                }
            }
        }                   
        
        return stonks2;
    }
    
    
    /**
    * Initialize an instance of a Stock with the given Stock Object
    */
    //Constructor
    public Stock()
    {
        _stock = new FoodItem[maxStock];

    }
    
    /**
     * Return the number of different items in stock   
     * @return the integer number of different FoodItems in stock
    */
    //Return number of types of items in stock
    public int getNumOfItems()
    {
        orderStock(_stock);
        
        int num = 0;
        
        for (int i = 0; i < _stock.length; i++) 
        {
            if(_stock[i] != null)
            {
                num++;
            }
        }
        
        return num;
    }
    
    /**
     * Return true if the item given as a parameter was added to stock, else return false  
     * @param newItem a given FoodItem
     * @return true if method has completed its task, otherwise false
    */
    //Method to add item to stock, if is not possible to do so, return false
    public boolean addItem(FoodItem newItem)
    {
        orderStock(_stock);
        
        int q; //Quantity of items 
        boolean iseq = false; //boolean to check if item in in array
        boolean has = false; //boolean to check if item has been added to stock
        
        for(int i = 0; i < _stock.length; i++)
        {
            if(_stock[i] != null && newItem.equals(_stock[i]))
            {
                q = _stock[i].getQuantity();
                _stock[i].setQuantity(q+newItem.getQuantity());
                iseq = true;
                has = true;
            }
        }
        
        if(iseq == false)
        {
            for(int j = 0; j < _stock.length; j++)
            {
                if(_stock[j] == null)
                {
                    _stock[j] = new FoodItem(newItem);
                    has = true;
                    break;
                }
            }
        }
        
        orderStock(_stock);
        
        return has;
    }
    
    /**
     * Return string of type FoodItem1 name, FoodItem2 name, FoodItem3 name,...,FoodItem_n name   
     * @param amount the minimum amount of "items" that a FoodItem needs to have in order to be added to the string/basket
     * @return String of "ordered" items
    */
    public String order(int amount)
    {
        String [] names = new String [_stock.length]; //array of object names
        String name; //current object name
        String returnVal = ""; //Return value (String to be printed) 
        
        //Make array of names 
        for (int i = 0; i < _stock.length; i++) 
        {
            if(_stock[i] != null && _stock[i].getQuantity() < amount)
            {
                name = _stock[i].getName();
                names[i] = name;
            }
        }
        
        //Create value to be returned
        for (int j = 0; j < names.length; j++)
        {
            if(names[j] != null)
            {
                returnVal = returnVal + ", " + names[j];
            }
        }
        
        return returnVal;
    }
    
     /**
     * Return number of items that can be moved to a place/fridge with a certain given temperature 
     * @param temp the temperature in new fridge
     * @return integer containing the value of the number of items that can be moved to a new fridge with such a temperature
    */
    //Method to find the number of items that can be moved to a certain fridge
    public int howMany(int temp)
    {
        int quantity = 0; //number of items that can be moved (Total)
        
        for(int i = 0; i < _stock.length; i++)
        {
            if(_stock[i] != null && _stock[i].getMaxTemperature() > temp && 
            _stock[i].getMinTemperature() < temp)
            {
                quantity += _stock[i].getQuantity();
            }
        }
        
        return quantity;
    }
    
    /**
     * Remove all expired food from stock/remove al FoodItems after their expiry date has passed  
     * @param d a given Date
    */
    //Method to remove all expired food from stock
    public void removeAfterDate(Date d)
    {
        orderStock(_stock);
        for(int i = 0; i < _stock.length; i++)
        {
            //For every item in stock, if expiry date is after given date, "delete" item from stock
            if(_stock[i] != null && _stock[i].getExpiryDate().before(d))
            {
                _stock[i] = null;
            }
        }
        orderStock(_stock);
    }
    
    /**
     * Return the most expensive FoodItem in stock   
     * @return the most expensive FoodItem in stock if such an item exists, otherwise return null
    */
    //Method to find most expensive food item in stock
    public FoodItem mostExpensive()
    {
        FoodItem most = null; //most expensive food item 
        double price = 0; //Current Price
        
        for(int i = 0; i < _stock.length; i++)
        {
            if(_stock[i] != null && _stock[i].getPrice() > price)
            {
                price = _stock[i].getPrice();
                most = new FoodItem(_stock[i]);
            }
        }
        
        return most; 
    }
    
     /**
     * Return the total number of items in stock (Including Quantities)
     * @return int containing number of items in stock
    */
    //Return number of items in stock
    public int howManyPieces()
    {
        orderStock(_stock);
        
        int num = 0;
        
        for (int i = 0; i < _stock.length; i++) 
        {
            if(_stock[i] != null)
            {
                num += _stock[i].getQuantity();
            }
        }
        
        return num;
    }
    
       /**
     * Return string to be printed 
     * @return the String to be printed (String will be of the sort String will be of the sort FoodItem1: string CatalogueNumber: int ProductionDate: Date 
    *   ExpiryDate: Date Quantity: int (newline) FoodItem2: string CatalogueNumber2: int ProductionDate2: Date 
    *   ExpiryDate2: Date Quantity2: int etc...)
    */
    //toString method 
    public String toString()
    {
        String returnVal = ""; //Return value (String to be printed) 
        
        //Make array of names 
        for (int i = 0; i < _stock.length; i++) 
        {
            if(_stock[i] != null)
            {
                returnVal =  returnVal + _stock[i].toString() + '\n';
            }
        }
        
        return returnVal;
    }
    
    
     /**
     * Update the stock (remove certain items from stock)
     * @param itemsList an array that contains the names of the items that are to be removed
    */
    //Method to update the stock (removes certain items from stock)
    public void updateStock(String[] itemsList)
    {
        for (int i = 0; i < itemsList.length; i++)
        {
            for(int j = 0; j < _stock.length; j++)
            {       
                if(_stock[j].getName() == itemsList[i])
                {
                    _stock[j].setQuantity(_stock[j].getQuantity() - 1);
                    
                    if(_stock[j].getQuantity() == 0)
                    {
                        _stock[i] = null;
                        orderStock(_stock);
                    }
                    
                    break;
                }
            }
        }
    }
    
    
     /**
     * Return the best temperature to keep the food at
     * @return temp int of best temperature to keep the all the FoodItems at
    */
    //Get best temp to keep stock at
    public int getTempOfStock()
    {
        int min,max,temp = 0;
        int [] minValues = new int [_stock.length];
        int [] maxValues = new int [_stock.length];
        
        for(int j = 0; j < _stock.length; j++)
        {
            if(_stock[j] != null)
            {
                minValues[j] = _stock[j].getMinTemperature();
                maxValues[j] = _stock[j].getMaxTemperature();
            }
        }
        
        //Sort arrays 
        minValues = sortInt(minValues);
        maxValues = sortInt(maxValues);
        
        //Get max and min values for temp
        max = maxValues[0]; //get lowest max value 
        min = minValues[minValues.length-1]; //get highest min value 
        
        if(min < max)
        {
            temp = Integer.MAX_VALUE;
        }
        
        else if(min > max)
        {
            temp = min;
        }
        
        return temp;
    }
}
