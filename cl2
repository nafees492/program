#include <stdio.h>
typedef struct s
{
    //char name[20];
int day;
int month;
int year;
}s;

int valid_date(int date, int mon, int year);int valid_date(int day, int mon, int year)    
{
    int is_valid = 1, is_leap = 0;

    if (year >= 1800 && year <= 9999) 
    {

        //  check whether year is a leap year
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) 
        {
            is_leap = 1;
        }

        // check whether mon is between 1 and 12
        if(mon >= 1 && mon <= 12)
        {
            // check for days in feb
            if (mon == 2)
            {
                if (is_leap && day == 29) 
                {
                    is_valid = 1;
                }
                else if(day > 28) 
                {
                    is_valid = 0;
                }
            }

            // check for days in April, June, September and November
            else if (mon == 4 || mon == 6 || mon == 9 || mon == 11) 
            {
                if (day > 30)
                {
                    is_valid = 0;
                }
            }

            // check for days in rest of the months 
            // i.e Jan, Mar, May, July, Aug, Oct, Dec
            else if(day > 31)
            {            
                is_valid = 0;
            }        
        }

        else
        {
            is_valid = 0;
        }

    }
    else
    {
        is_valid = 0;
    }

    return is_valid;

}
int compare(s d1, s d2)
{

    if (d1.year < d2.year)
        return 1;
    if (d1.year == d2.year && d1.month < d2.month)
        return 1;
    if (d1.year == d2.year && d1.month == d2.month &&
                              d1.day < d2.day)
        return 1;
      return 0;
}
int main()
{
    s k[20];
    s s1[20];
    s temp;
    int n=3;
    char a[n];
    for(int i=0;i<n;i++)
    scanf("%d %d %d ",&k[i].day,&k[i].month,&k[i].year);
for(int i=0;i<n;i++)
    printf("%d %d %d \n",k[i].day,k[i].month,k[i].year);
 int i, j;
    for (i = 0; i < n ; i++)
  
{      for (j = i+1; j < n-1; j++)
        {
    if(compare(k[i],k[j]))
    { temp = k[i];
  k[j] = k[i];
   k[i] = temp;
    }
}
}
for(int i=0;i<n;i++)
    printf("%d %d %d \n",k[i].day,k[i].month,k[i].year);
for(int i=0;i<n;i++)
{
int day1=k[i].day;
int mon1=k[i].month;
int year1=k[i].year;
int day2=k[i+1].day;
int mon2=k[i+1].month;
int year2=k[i+1].year;
for(int i=0;i<n-1;i++)
    printf("%d %d %d \n",s1[i].day,s1[i].month,s1[i].year);
if(!valid_date(day1, mon1, year1))
    {
        printf("First date is invalid.\n");        
    }

    if(!valid_date(day2, mon2, year2))
    {
        printf("Second date is invalid.\n");
       
    }       

    if(day2 < day1)
    {      
       
        if (mon2 == 3)
        {
        
            if ((year2 % 4 == 0 && year2 % 100 != 0) || (year2 % 400 == 0)) 
            {
                day2 += 29;
            }

            else
            {
                day2 += 28;
            }                        
        }

        else if (mon2 == 5 || mon2 == 7 || mon2 == 10 || mon2 == 12) 
        {
           day2 += 30; 
        }

      
        else
        {
           day2 += 31;
        }

        mon2 = mon2 - 1;
    }

    if (mon2 < mon1)
    {
        mon2 += 12;
        year2 -= 1;
    }       
        int day_diff, mon_diff, year_diff; 

    day_diff = day2 - day1;
    mon_diff = mon2 - mon1;
    year_diff = year2 - year1;
s1[i].day=day_diff;
s1[i].month=mon_diff;
s1[i].year=year_diff;
   

    
}
for(int i=0;i<n-1;i++)
    printf("%d %d %d \n",s1[i].day,s1[i].month,s1[i].year);
    return 0;
}
