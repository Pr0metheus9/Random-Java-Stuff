/**
 * Maman 12 Q1 
 *
 * @author Pr0metheus 
 * @version 12.12.2019
 */
public class Date
{
    //Instance Variables
    private int int_day,int_month,int_year;
    
    /**
    * Return true if the year is a leap year
    * @param year  given year
    * @return true if both objects are equal, otherwise false
    */
    //Private Method to check if year is a leap year.
    //There is a leap year every year that is divisible by 4, except for years that are divisible by 100, but not divisible by 400.
    private static boolean isLeap(int year)
    {
        boolean leap = false;
        
        if(year % 4 == 0)
        {
            if( year % 100 == 0)
            {
                // year is divisible by 400, hence the year is a leap year
                if ( year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;
            
        return leap;
    }
        
    /**
    * Return true if the date is a valid date
    * @param day the dates day
    * @param month the dates month
    * @param year the dates year
    * @return true if date is valid
    */
    //Private Method that checks if a date is valid
    private static boolean dateValid(int day, int month, int year)
    {
        boolean valid = true;
        
        if(day<=0 || month<=0 || year<1000 || year != (int)year || month != (int)month || day != (int)day)
        {
            valid = false;
        }
        
        if(month > 12 || month < 1)
        {
            valid = false;
        }
        
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
        {
            if(day > 31) //The Months listed above have 31 days 
            {
                valid = false;
            }
        }
        
        else if(month == 4 || month == 6 || month == 9 || month == 11)
        {
            if(day > 30) //The months listed above have 30 days
            {
                valid = false;
            }
        }
        
        else //Month == 2 \ Is Feb
        {
            if(isLeap(year))
            {
                if(day > 29) //In a leap year Feb has 29 days 
                {
                    valid = false;
                }
            }
          
            if(day > 28) //Normal year 28 days
            {
                valid = false;
            }
                
        }
   return valid;
   }
    
    /**
    * Initialize an instance of a Date with the given parameters
    * @param day the dates day
    * @param month the dates month
    * @param year the dates year
    */
    //Constructor
    public Date(int day, int month, int year)
    {
        final int dday = 1, dmonth = 1, dyear = 2000;
        if(dateValid(day,month,year)) //Checks if input is valid
        {
            int_day = day;
            int_month = month;
            int_year = year;
        }
        else //If not set date to 1.1.2000
        {
            int_day = dday;
            int_month = dmonth;
            int_year = dyear;
        }
    }
    
    /**
    * Copy Constructer 
    * @param Date a given Date object
    */
    //Copy constructor.
    public Date(Date date) 
    {
    this(date.getDay(), date.getMonth(), date.getYear());
    }
    
    /**
    * Return the day of a given Date
    * @return Dates day
    */
    //The following methods allow the user to "get" the day,month or year of a certain date
    public int getDay() 
    {
        return int_day;
    }
    
    /**
    * Return the month of a given Date
    * @return Dates month
    */
    public int getMonth()
    {
        return int_month;
    }
    
    /**
    * Return the year of a given Date
    * @return Dates year
    */
    public int getYear()
    {
        return int_year;
    }
    
    //Methods to change day, month or year 
    /**
    * Update the Dates day with the given parameter
    * @param day new Dates day
    */
    public void setDay(int dayToset)
    {
        if(dateValid(dayToset,int_month,int_year)) //Check if new day is a valid  
        {
            int_day = dayToset;
        }
    }
    
       /**
    * Update the Dates month with the given parameter
    * @param month new Dates month
    */
    public void setMonth(int monthToset)
    {
        if(dateValid(int_day,monthToset,int_year)) //Check if new month if valid 
        {
            int_month = monthToset;
        }
    }
    
       /**
    * Update the Dates year with the given parameter
    * @param year new Dates year
    */
    public void setYear(int yearToset)
    {
        if(dateValid(int_day,int_month,yearToset)) //Check if new year is valid
        {
            int_year = yearToset;
        }
    }
    
    /**
     * Return true if this object and other object are equal     
     * @param other the other Date
     * @return true if both objects are equal, otherwise false
    */
    //Check if two dates are equal 
    public boolean equals(Date other)
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
        
        if(this.int_day == other.int_day && this.int_month == other.int_month && this.int_year == other.int_year)//Check if equal
        {
            equal = true;
        }
        return equal; 
    }
    
     /**
     * Return true if this Date came before other Date   
     * @param other the other Date
     * @return true if object Date came before other Date, if not, return false
    */
    //Check if date came before
    public boolean before(Date other)
    {
        boolean is = true;
        
        if(other.int_year < this.int_year) //Check if year is smaller (Example: 1999 is smaller than 2000 and thus occured before)
        {
            is = false;
        }
        
        else if (other.int_year == this.int_year)
        {
            if(other.int_month < this.int_month) //If years are the same check if month is smaller (Example: Jan is smaller than Feb) 
            {
                is = false;
            }
            
            else if (other.int_month == this.int_month) 
            {
                if(other.int_day < this.int_day) //If months and years are the same check if day is smaller
                {
                    is = false;
                }
            }
        }
        return is;
    }
    
       /**
     * Return true if this Date came after other Date    
     * @param other the other Date
     * @return true if object Date came after other Date, if not, return false
    */
    public boolean after(Date other)
    {
        if(this.before(other)) //If this date came before than other date came after
        {
            return false;
        }
        
        else
        {
            return true;
        }
    }
       /**
     * Return the integer value of the difference between the Dates using JDN    
     * @param other the other Date
     * @return the difference between two Date according to the Julian Calendar
    */
    //Computes day number (Julian Calendar)
    private int differenceJDN(Date other)
    {
        //Formula to calculate Julian Day Number
        //Each increment to int_day increments the number of days since a fixed day.
        //The integer division (153*int_month + 2)/5 is a expression to calculate the number of days in the previous months.
        //The expression 365*int_year is there because each non-leap-year has 365 days.
        //The expression int_year/4 - int_year/100 + int_year/400 (all integer divisions) calculates the number of leap years since the int_year. 
        int days = this.int_day + ((this.int_month*153+2)/5) + 365*this.int_year + this.int_year/4 - this.int_year/100 + this.int_year/400 - 32045;
        int days2 = other.int_day + ((other.int_month*153+2)/5) + 365*other.int_year + other.int_year/4 - other.int_year/100 + other.int_year/400 - 32045;
        int diff = days-days2;
        
        if(diff>0)
        {
            return diff;
        }
        
        else
        {
            return -1*diff;
        }
    }
    
       /**
     * Return the value of Date in days according to the Gregorian Calender  
     * @param day the Dates day
     * @param month the Dates month 
     * @param year the Dates year 
     * @return the value of Date in days
    */
    //Computes the day number (Gregorian Calendar)
    private int calculateDay (int day, int month, int year) 
    {
        if (month < 3) 
        {
          year--;
          month = month + 12;
        }
         
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    } 
    
       /**
     * Return the difference between two dates according to the Gregorian Calender   
     * @param other the other Date
     * @return the integer value of the difference between the Dates
    */
    public int difference (Date other)
    {
        int day1 = calculateDay(this.int_day,this.int_month,this.int_year); //Number of days (Object Date)
        int day2 = calculateDay(other.int_day,other.int_month,other.int_year); //Number of days in (Other date)
        int diff = day1 - day2; 
        if(diff>0)
        {
            return diff;
        }
        
        else
        {
            return -1*diff;
        }
    }
    
       /**
     * Return string to be printed 
     * @return the String to be printed (String will be of the sort day/month/year)
    */
    public String toString()
    {
         
        if(int_month>=10)
        {
            if(int_day>=10)
            {
                return int_day + "/" + int_month + "/" + int_year;
            }
            
            else
            {
                return "0" + int_day + "/" + int_month + "/" + int_year;
            }
        }
        
        else
        {
            if(int_day>=10)
            {
                return int_day + "/" + 0+ int_month + "/" + int_year;
            }
            
            else
            {
                return "0" + int_day + "/" + 0 + int_month + "/" + int_year;
            }
        }
    }
    
       /**
     * Return next Date (Tomorrow)   
     * @return the new Date (Tomorrow)
    */
    public Date tomorrow()
    {
        Date copycat = new Date(this);
        int nday = copycat.int_day + 1,nmonth;
        if(dateValid(nday,copycat.int_month,copycat.int_year) == false)
        {
            nday = 1;
            nmonth = copycat.int_month + 1;
            if(dateValid(nday,nmonth,copycat.int_year) == false)
            {
                copycat.int_day = 1;
                copycat.int_month = 1;
                copycat.int_year++;
            }
            
            else
            {
                copycat.int_month = nmonth;
                copycat.int_day = nday;
            }
        }
        
        else
        {
            copycat.int_day = nday;
        }
          
        return copycat;
    }
    
       /**
     * Return the day in week of a certain Date (0-6)
     * @return the day in week of a certain Date (0 is Sat, 6 is Friday)
    */
    public int dayInWeek()
    {
        int D = int_day, M = int_month, year = int_year,Y,C; //D = day, M = month,Y first 2 digits of year, C = last two digits of year
        float num;
        
        if(M == 1)
        {
            year--;
            M = 13;
        }
        
        else if(M == 2)
        {
            year--;
            M = 14;
        }
        
        C = Integer.parseInt((""+year).substring(0, 2)); //First two digits of year
        Y = Integer.parseInt((""+year).substring(2)); //Last two digits of year
        num = (D + (26*(M+1))/10 + Y + Y/4 + C/4 - 2*C) % 7;
        
        if(num>0)
        {
            return (int)num;
        }
        
        else
        {
            return Math.floorMod((int)num,7);
        }
    }
}
