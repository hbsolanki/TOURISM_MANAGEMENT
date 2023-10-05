import java.util.*;
import Db.DB;

class Travel2 {

    Scanner sc=new Scanner (System.in);
	int sd;
	int month;
	boolean c=true;
	boolean ad=true;
	int destination;
	int days ;
	int tp;
	int high,food;
	int rooms,maxb,minb,maxt,mint,maxf,minf,hr,min;
	int year=2023;
	String PL,modes;
	
    void date(){
        boolean a=true;
        boolean b=true;
        boolean d=true;

        System.out.println(" Enter departure Month");//calculating month
        System.out.println();
        while(c){
            month=sc.nextInt();
            if(month>12 || month<1){
                System.out.println("Enter valid month");
            }
            else if(month <=12 && month>=1){
                c=false;
            }
        }		
        System.out.println("Enter a starting date for Journey");
        
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
            //departure date
            while(a){
                sd=sc.nextInt();
                if(sd>31||sd<1){
                    System.out.println("Enter valid date");
                }else if(sd<=31&&sd>=1) {
                    a=false;	
                }
            }		
        }else if(month==4||month==6||month==9||month==11){
            while(b){ 
                sd=sc.nextInt();
                if(sd>30||sd<1){
                    System.out.println("Enter valid date");
                }else if(sd<=30&&sd>=1) {
                    b=false;
                }
            }
        }else if(month==2){
            while(d){
                sd=sc.nextInt();
                if(sd>28||sd<1){
                    System.out.println("Enter valid date");
                }else if(sd<=28&&sd>=1){
                    d=false;
                } 
	        }
        }

    }
    
    
    int end_date;//claculating returning date
	int end_month;
		


	void enddate(){
		if(month==1||month==3||month==5||month==7||month==8||month==10){
			if(days+sd<=31){
				end_date=days+sd;
				end_month=month;
			}else if(days+sd>31){
				end_month=month+1;
				end_date=days+sd-31;	
			}
		}
		if(month==4||month==6||month==9||month==11){
			if(days+sd<=30){
				end_date=days+sd;
				end_month=month;
			}else if(days+sd>30){
				end_month=month+1;
				end_date=days+sd-30;	
			}
		}
		if(month==12){
			if(days+sd<=31){
				end_date=days+sd;
				end_month=month;
			}else if(days+sd>31){
				end_month=1;
				end_date=days+sd-31;
				year=2024;	
			}
		}
		if(month==2){
			if(days+sd<=28){
				end_date=days+sd;
				end_month=month;
			}else if(days+sd>28){
				end_month=month+1;
				end_date=days+sd-28;	
			}
		}
	}
		void display(String pl)//DIPLAYING FINAL INFORMATION
		{
			boolean c=true;
			System.out.println();
			System.out.println("Your journey to " +pl+" starts at "+sd+"/"+month+"/"+2023);
			System.out.println();
			System.out.println("Your journey for " +pl+" ends at "+end_date+"/"+end_month+"/"+year);
			System.out.println();
			System.out.println("Your borading time is "+ hr +":"+ min);
			System.out.println();
			System.out.println( "Your "	+ modes +" ticket price : "+ tp + " INR");
			System.out.println();
			if (food==0)
			{
			System.out.println("Your cost for stay for "+ days +" days is "+(days*rooms*high));
			System.out.println();
			}
			else if(food!=0)
			{
				System.out.println("Your cost for stay for "+ days +" days including food is "+((days*rooms*high)+(food*days))+" INR");
				System.out.println();
			}
			    	
			System.out.println("And Thats What we call a perfect Trip!!!");
			System.out.println();
			
		}

    void ticket()//BOOKING TICKETS FOR TRANSPORTATION
    {
        boolean b1=false;
        boolean c1=false;
        do
        {
        System.out.println("how will you go?");
        System.out.println();
        System.out.println("1. By Bus");
        System.out.println("2. By Train");
        System.out.println("3. By Flight");
        System.out.println();
        System.out.print("Enter :");
        int p=sc.nextInt();
        switch(p){
            case 1:{
                System.out.println();
                System.out.println("Cost of Bus ticket would be between 250 to 1200 INR" );
                System.out.println();
                this.tp= (int)((Math.random())*(1200-500))+500;
                this.modes="BUS";
                b1=true;
                break;
            }
            case 2:{
                System.out.println();
                System.out.println("Cost of Train ticket would be between 400 to 1500 INR" );
                System.out.println();
                this.tp= (int)((Math.random())*(1500-400))+400;
                b1=true;
                this.modes="TRAIN";
                break;
            }
            case 3:{
                System.out.println();
                System.out.println("Cost of Flight ticket would be between !200 to 12,0000 INR" );
                System.out.println();
                this.tp= (int)((Math.random())*(12000-1200))+1200;
                this.modes="FLIGHT";
                b1=true;
                break;
            }
            default :{
                System.out.println("Enter valid choice" );
                continue;
            }
        }
        System.out.println("Choose nearest boarding time slot(24 hours format) which is comfortable to you ");
        System.out.println("Enter hour");
                do
                {
                this.hr=sc.nextInt();
                if (hr<1||hr>24)
                {
                    System.out.println("Enter valid hour. ");
                }
                else if(hr>=1&&hr<=24)
                {
                    c1=false;
                }
                }
                while(c1);
                this.min=(int)(Math.random()*(30-10))+10;
        }
        while(!b1);
        
    }

    void stay(){
        
            System.out.println();
            System.out.println("Enter no. of days for which you are planning your trip");
            days=sc.nextInt();
            System.out.println();
            System.out.println("As per your convinience select your stay now");
            System.out.println(" Press 1 for Luxurious ");
            System.out.println(" Press 2 for Delight ");
            System.out.println(" Press 3 for Standard ");
            boolean z=true;
            do
            {
            int x=sc.nextInt();
            switch (x){
                case 1:{
                    high=9000;
                    System.out.println(" Cost for just room for 24 houurs : 9000 INR" );
                    System.out.println(" How many rooms do you want please ?");
                    rooms =sc.nextInt();
                    System.out.println("Do you want to include breakfast lunch and dinner that cost 2000 per day?");
                    System.out.println("Press 1 for Yes and press any number for No ");
                    food = sc.nextInt();
                    if (food==1)
                        food=2000;	
                    else if(food!=1)
                        
                        {
                            food=0;
                        }
                    z=false;
                    break;
                }
                case 2:{
                    high =5000;
                    System.out.println(" Cost for just room for 24 houurs : 5000 INR" );
                    System.out.println(" How many rooms do you want please ?");
                    rooms =sc.nextInt();
                    System.out.println("Do you want to include breakfast lunch and dinner that cost 1000 per day?");
                    System.out.println("Press 1 for Yes and press any number for No ");
                    food = sc.nextInt();
                    if (food==1)
                        food=1000;	
                    else if(food!=1)
                        
                        {food=0;}
                    z=false;
                    break;
                }
                case 3:{
                    high=800;
                    System.out.println(" Cost for just room for 24 houurs : 800 INR" );
                    System.out.println(" How many rooms do you want please ?");
                    rooms =sc.nextInt();
                    System.out.println("Do you want to include breakfast lunch and dinner that cost 300 per day?");
                    System.out.println("Press 1 for Yes and press any number for No ");
                    food = sc.nextInt();
                    if (food==1)
                        food=300;	
                    else if(food!=1)
                    {
                        food=0;
                    }
                    z=false;
                    break;
                }
                default :{
                    System.out.println("Disturbing relatives is not good...we are just saying it doesn't mean anything");
                    System.out.println("so select your stay ");
                }
            }
            }
            while(z);
    }
}

class Trip2 extends Travel2{
    static Scanner sc=new Scanner(System.in);
    static HashMap<String,String> map=new HashMap<>();
    public static void main(String[] args)throws Exception {
        int ch;
        do{
            System.out.println("Choice Option \n(1)Add Place (2)View Place");
            ch=sc.nextInt();
            switch(ch){
                case 1: addPlace();
                        break;
                case 2 : showPlace(DB.getPlaceFromDB());
                         break;
                case 3 : System.exit(0);
                         break;
                default : System.out.println("Invalid Option");
            }
        }while(true);

    }

    public static void showPlace(HashMap<String,String> allplace){
        if(allplace.isEmpty()){
            System.out.println("NO ANY PLACE AVAILBLE");
            return;
        }
        System.out.println();
        System.out.println("======================================================================================================================");
	    System.out.println("                                     * WELCOME TO THE TOURISM MANAGEMENT  *                                              ");
	    System.out.println("======================================================================================================================");
        System.out.println();
        System.out.println();

        ArrayList<String> placelist=new ArrayList<>();
        System.out.println("Choose among the following Destinations EXIT 0");
        System.out.println();
        int cnt=1;
        for(Map.Entry m : allplace.entrySet()){
            placelist.add((String)m.getKey());
            System.out.println(cnt+" "+m.getKey());
            System.out.println();
            System.out.println("     SOME OF FAMOUS PLACES TO VISIT IN "+m.getKey());
            System.out.println();
            String arr[]=m.getValue().toString().split(";");
            System.out.println("     ->"+arr[0]+"\n"+"     ->"+arr[1]+"\n"+"     ->"+arr[2]+"\n");
            cnt++;
        }
        int ch=sc.nextInt();
        if(ch==0){
            return;
        }
        if(ch<0 && ch>placelist.size()){
            System.out.println("Enter valid Option");
            return;
        }

        System.out.println();
        System.out.println();
        Travel2 t=new Travel2();
        t.date();
        t.ticket();
        t.stay();
        t.enddate();
        t.display(placelist.get(ch-1));

    }

    public static void addPlace(){
        sc.nextLine();
        System.out.println("Enter Main Place Name : ");
        String place=sc.nextLine();
        System.out.println("Enter three FAMOUS place in "+place);
        String s1=sc.nextLine();
        String s2=sc.nextLine();
        String s3=sc.nextLine();
        System.out.println("Place Added Successuly");
        try {
            DB.placeStoreInDB(place, s1, s2, s3);
        } catch (Exception e) {
            System.out.println();
        }
    }
}