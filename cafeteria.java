package  Cafeteria;
import java.util.*;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

class Customer {// class customer
    String name;                  
    String address;
    long phoneNo;
    Customer next;
    String ID;
    ArrayList<String> a;

    Customer(String name, String address, long phoneNo, ArrayList<String> a, String ID) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.a = a;
        this.next = null;
        this.ID = ID;
    }
}

class Queue {// class queue
    InputStreamReader ir = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(ir);
    Scanner sc = new Scanner(System.in);
    int id = 100;
    int count = 0;
    double TOTAL=0;
    Customer head;
    String id3;
    Customer tail;
    ArrayList<String> A = new ArrayList<>();//creation of array list

    HashMap<String, Integer> All = new HashMap<String, Integer>();// creation of hash map for menu
    Queue() {
        head = null;
        tail = null;
    }

    boolean IsEmpty() {
        return head == null && tail == null;
    }

    void placeorder(Queue CID, Queue CORDER, Queue ALLORDER,Queue all) throws IOException {// places customer order - passing objects of array list
        id++;
        String ID1 = "SB";                                 //ID initializing for SNACK BAR CAFE
        String ID2 = String.valueOf(id);
        String ID = ID1 + ID2;
        CID.A.add(ID);
        int flag;
        System.out.println("Enter the name of the Customer: ");
        String CName = br.readLine();
        System.out.println("Enter the Address of the customer: ");
        String Address = br.readLine();
        System.out.println("Enter the phone number of the customer: ");
        long PhoneNo = sc.nextLong();
        System.out.println("Enter numbers of order: ");
        int OD = sc.nextInt();
        for (int i = 0; i < OD; i++) {
        	flag=0;
            System.out.println("Enter your order: ");
            String order2 = br.readLine();
            for (String key : all.All.keySet()) {
            	if(!Objects.equals(order2,key))
            	 {
            		flag++;
            	}
            }
          
            if(flag==all.All.size()) {
            	System.out.println("Dish is not present in the menu");
            	System.out.println("Please Order something from the menu");
            	i=i-1;
            }
            else {
            	   CORDER.A.add(order2);                   //array_list contains order of one customer
            	  
            }       
        }
        ALLORDER.A.addAll(CORDER.A);                       //this array_list contains orders of all customers
 	   Customer temp = new Customer(CName, Address, PhoneNo, CORDER.A, ID);
        if (head == null) {
            head = temp;
            tail=temp;
        } else {
            tail.next = temp;
        }
        tail = temp;
        tail.next = head;
    }                                                       // end of place order

    void displayorder() {                                   // displays customer order
        Customer ptr = head;
        if (IsEmpty()) {
            System.out.println("queue is empty");
        }
        else if (head == tail) {
            System.out.println("ID:" + ptr.ID);
            System.out.println("Name of customer: " + ptr.name + "\ncontact no of the customer: " + ptr.phoneNo
                    + "\nAddress of the customer: " + ptr.address);
            System.out.println("ORDER: ");
            System.out.println(ptr.a.toString().replace("[", "").replace("]", ""));
            ptr = ptr.next;

        }
        else {

            while (ptr.next != head) {
                System.out.println("\nID:" + ptr.ID);
                System.out.println("Name of customer: " + ptr.name + "\ncontact no of the customer: " + ptr.phoneNo
                        + "\nAddress of the customer: " + ptr.address);
                System.out.println("ORDER: ");
                System.out.println(ptr.a.toString().replace("[", " ").replace("]", " "));// print hash map without brackets
                ptr = ptr.next;

            }
            System.out.println("\nID:" + ptr.ID);
            System.out.println("Name of customer: " + ptr.name + "\ncontact no of the customer: " + ptr.phoneNo
                    + "\nAddress of the customer: " + ptr.address);
            System.out.println("ORDER: ");
            System.out.println(ptr.a.toString().replace("[", " ").replace("]", " "));// print hash map without brackets
        }

    }// end of display order

    void MENU(Queue all, Queue beverage, Queue snacks, Queue sandwich, Queue pastry, Queue icecream, Queue Combo) {//adding dishes and rates in hash map

        beverage.All.put("Cappuccinos", 40);
        beverage.All.put("Latte", 30);
        beverage.All.put("Mochaccino", 70);
        beverage.All.put("Cold Coffee", 70);
        beverage.All.put("Cold Brew coffee", 40);
        beverage.All.put("Iced coffee", 50);
        beverage.All.put("Iced Americano", 70);
        beverage.All.put("Coca-Cola", 30);
        beverage.All.put("Sprite", 30);
        beverage.All.put("Fanta", 30);

        snacks.All.put("Croissant", 20);
        snacks.All.put("Muffins", 15);
        snacks.All.put("Cookies", 30);

        sandwich.All.put("Cheese Sandwich", 30);
        sandwich.All.put("Veg Sandwich", 40);
        sandwich.All.put("Veg Grilled Sandwich", 60);
        sandwich.All.put("Veg cheese Grilled Sandwich", 80);
        sandwich.All.put("Corn Cheese Sandwich", 80);

        pastry.All.put("Black Forest pastry", 20);
        pastry.All.put("Pineapple pastry ", 30);
        pastry.All.put("Oreo-Chocolate pastry", 50);
        pastry.All.put("Rasmalai Cake", 60);
        pastry.All.put("Cheese Cake", 50);
        pastry.All.put("Pineapple Cake", 40);
        pastry.All.put("Red Velvet Cake", 40);

        icecream.All.put("Vanilla ice-cream", 20);
        icecream.All.put("Butterscotch ice-cream", 30);
        icecream.All.put("Strawberry ice-cream", 30);
        icecream.All.put("Chocolate ice-cream", 40);
        icecream.All.put("Mango ice-cream", 40);

        Combo.All.put("coldCoffee+CheeseSandwich+BlackForestPastry", 110);
        Combo.All.put("Latte+VegGrilledSandwich+PinepalPestry", 120);

        all.All.put("coldCoffee+CheeseSandwich+BlackForestPastry", 110);
        all.All.put("Latte+VegGrilledSandwich+PinepalPestry", 120);
        all.All.put("Cappuccinos", 40);
        all.All.put("Latte", 30);
        all.All.put("Mochaccino", 70);
        all.All.put("Cold Coffee", 70);
        all.All.put("Cold Brew coffee", 40);
        all.All.put("Iced coffee", 50);
        all.All.put("Iced Americano", 70);
        all.All.put("Coca-Cola", 30);
        all.All.put("Sprite", 30);
        all.All.put("Fanta", 30);
        all.All.put("Croissant", 20);
        all.All.put("Muffins", 15);
        all.All.put("Cookies", 30);
        all.All.put("Cheese Sandwich", 30);
        all.All.put("Veg Sandwich", 40);
        all.All.put("Veg Grilled Sandwich", 60);
        all.All.put("Veg cheese Grilled Sandwich", 80);
        all.All.put("Corn Cheese Sandwich", 80);
        all.All.put("Rasmalai Cake", 60);
        all.All.put("Cheese Cake", 50);
        all.All.put("Pineapple Cake", 40);
        all.All.put("Red Velvet Cake", 40);
        all.All.put("Black Forest pastry", 20);
        all.All.put("Pineapple pastry", 30);
        all.All.put("Oreo-Chocolate pastry", 50);
        all.All.put("Vanilla ice-cream", 20);
        all.All.put("Butterscotch ice-cream", 30);
        all.All.put("Strawberry ice-cream", 30);
        all.All.put("Chocolate ice-cream", 40);
        all.All.put("Mango ice-cream", 40);
       
    }

    void DisplayMenu(Queue all, Queue beverage, Queue snacks, Queue sandwich, Queue pastry, Queue icecream,
                     Queue Combo) {// displays the menu to the customer
        System.out.println();
        System.out.println("\t\t\t\tBEVERAGES\t\t\t\t");
        System.out.println();

        for (String key : beverage.All.keySet()) {
            System.out.println(" \t" + key + " : " + beverage.All.get(key));
        }
        System.out.println();
        System.out.println("\t\t\t\tSNACKS\t\t\t\t");
        System.out.println();
        for (String key : snacks.All.keySet()) {
            System.out.println(" \t" + key + " : " + snacks.All.get(key));
        }
        System.out.println();
        System.out.println("\t\t\t\tSANDWICH\t\t\t\t");
        System.out.println();
        for (String key : sandwich.All.keySet()) {
            System.out.println(" \t" + key + " : " + sandwich.All.get(key));
        }
        System.out.println();
        System.out.println("\t\t\t\tCAKES & PASTRIES\t\t\t\t");
        System.out.println();
        for (String key : pastry.All.keySet()) {
            System.out.println(" \t" + key + " : " + pastry.All.get(key));
        }
        System.out.println();
        System.out.println("\t\t\tICE-CREAM\t\t\t\t");
        System.out.println();
        for (String key : icecream.All.keySet()) {
            System.out.println(" \t" + key + " : " + icecream.All.get(key));
        }
        System.out.println();
        System.out.println("\t\t\t\tCombo pack\t\t\t\t");
        System.out.println();
        for (String key : Combo.All.keySet()) {
            System.out.println(" \t" + key + " : " + Combo.All.get(key));
        }
    }
                                                                     // end of display menu

    void deque(Queue CID, Queue RZ, Queue GZ, Queue MZ, Queue FeedBack, Queue all) throws IOException {// delivers orders and dequeues the order 
        int flag = 0;
        double total = 0;
        count=0;
        if (IsEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Customer ptr = head;
        System.out.println("WE HAVE EXTRA FEATURES LIKE :\n1.READING ZONE\n2.GAMING ZONE\n3.MUSICAL ZONE");
        System.out.println("DO YOU WANT TO ENJOY EXTRA FEATURES ?");
        String answer = sc.next();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("ENTER WHICH FEATURE YOU WANT TO ENJOY :");
            String feature = br.readLine();
            if (feature.equalsIgnoreCase("READING ZONE")) {
                count = 1;
            } else if (feature.equalsIgnoreCase("GAMING ZONE")) {
                count = 2;
            } else if (feature.equalsIgnoreCase("MUSICAL ZONE")) {
                count = 3;
            }
        }
        int g= ExtraFeature(RZ, GZ, MZ);
        if(g==0&&count ==1) {
        	  System.out.println("SORRY FOR INCONVENIENCE !! READING ZONE IS FULL");
        }
        else if(g==0&&count ==2) {
      	  System.out.println("SORRY FOR INCONVENIENCE !! GAMING ZONE IS FULL");
      }
        else if(g==0&&count ==3) {
        	  System.out.println("SORRY FOR INCONVENIENCE !! MUSICAL ZONE IS FULL");
        }
        
        System.out.println("Are you revisiting our cafe?");
        String s = br.readLine();

        if (s.equalsIgnoreCase("yes")) {
            System.out.println("Enter your previous ID :");
            String id1 = sc.next();
            for (int i = 0; i < CID.A.size(); i++) {
                if (Objects.equals(CID.A.get(i), id1)) {
                    flag = 1;
                    break;
                }
               
            }
            if(flag==0) {
            System.out.println("Your ID is not present in our record!!");}
        }
                                                                                       // Bill generation begins
        System.out.println("--------------------------------SNACKBAR CAFE-----------------------------------");
        System.out.println("\t\t\t\t\tBILL\t\t\t\t");
        System.out.println("ID:  :"+head.ID);
        System.out.println("Name : "+head.name);
        System.out.format("%-10s %15s"," MENU","PRICE");
        System.out.println();
        for (int j = 0; j < head.a.size(); j++) {
            String key = head.a.get(j);
            int value = all.All.get(key);
            total += value;
            System.out.format("%-10s %15s",key,value);
            System.out.println();
        }
        
        
        if (count == 1&&g!=0) {
            System.out.format("%-10s %15s","READING ZONE","200");
            System.out.println();
            total = total + 200;

        } else if (count == 2&&g!=0) {
            System.out.format("%-10s %15s","GAMING ZONE","400");
            System.out.println();
            total = total + 400;
        } else if (count == 3&&g!=0) {
            System.out.format("%-10s %15s","MUSICAL ZONE","300");
            System.out.println();
            total = total + 300;
        }
        System.out.println("~~~~~~~~~");
        System.out.format("%-10s %15s","Total :",total);
        System.out.println();
    
        System.out.println("-------------------------------------------------------------------------------");
        if (total >= 1000) {
            System.out.format("%-10s %15s","Discount :",(total*0.1));
            System.out.println();
           
            total = total - (total * 0.1);
        }

        if (total >= 500) {
            System.out.format("%-10s %15s","Discount :",(total*0.05));
            System.out.println();
         
            total = total - (total * 0.05);
        }

        if (flag == 1) {
            System.out.format("%-10s %15s","Revisit Discount:",(total*0.1));
            System.out.println();
         
            total = total - (total * 0.1);
        }

        double tax = total * 0.05;

        System.out.println("Tax   :" + tax);
        System.out.println("Final amount: " + (total + tax));
        double FINAL_AMOUNT=total + tax;
        TOTAL=TOTAL+FINAL_AMOUNT;
        id3 = head.ID;
        head.a.clear();
    
        if (head == tail) {
            head = null;
            tail = null;
        }
         else {
            head = head.next;
            tail.next = head;
        }

       
         System.out.println("--------------------------------THANK YOU FOR VISITING!!------------------------");
       
        feedback(FeedBack);
    }     													 // end of dequeue

    int ExtraFeature(Queue RZ, Queue GZ, Queue MZ) {        //checks if the zone is vacant
        if (count == 1) {
            if (RZ.A.size() == 10) {
                return 0;
            } else {
                RZ.A.add(id3);
            }
        } else if (count == 2) {
            if (GZ.A.size() == 10) {
                return 0;
            } else {
                GZ.A.add(id3);
            }
        } else {
            if (MZ.A.size() == 10) {
                return 0;
            } else {
                MZ.A.add(id3);
            }
        }
        return 1;
    }//end of extra feature

    void RemoveFromZone(Queue RZ, Queue GZ, Queue MZ) {// removes from zone
    	System.out.println("Enter in word in the zone you are in right now");
    	System.out.println("1.ReadingZone");
    	System.out.println("2.MusicalZone");
    	System.out.println("3.GamingZone");
    	String zone1=sc.next();
    	if(zone1.equalsIgnoreCase("ReadingZone")) {
    		 System.out.println("Enter the customer Id:");
    	        String id4 = sc.next();
    	        if (RZ.A.contains(id4)) {
    	            RZ.A.remove(id4);
    	        }
    	        else if(!RZ.A.contains(id4)) {
    	        	System.out.println("Enter correct ID");
    	        }
    	}
    	else if(zone1.equalsIgnoreCase("MusicalZone")) {
    		 System.out.println("Enter the customer Id:");
 	        String id4 = sc.next();
 	      if(MZ.A.contains(id4)){
 	            MZ.A.remove(id4);
 	        }
 	      else if(!MZ.A.contains(id4)) {
 	    	 System.out.println("Enter correct ID");
 	      }
    	}
    	else if(zone1.equalsIgnoreCase("GamingZone")) {
    		 System.out.println("Enter the customer Id:");
  	        String id4 = sc.next();
  	        if(GZ.A.contains(id4)) {
  	        	GZ.A.remove(id4);
  	        }
  	        else if(!GZ.A.contains(id4)) {
  	        	 System.out.println("Enter correct ID");
  	        }
    	}

    }                                                        // end of RemoveFromZone

    void CancelOrder() {
        System.out.println("Enter the customer Id:");
        String id2 = sc.next();
        int flag = 0;
        if (head == null) {
            return;
        }
        Customer pre;
        Customer ptr;
        ptr = head;
        pre = null;
        do {
            if (Objects.equals(ptr.ID, id2)) {
                flag = 1;
                break;
            }
            pre = ptr;
            ptr = ptr.next;

        } while (ptr != head);

        if (flag == 1 && ptr == head && ptr.next != head) {
            System.out.println("SORRY !! YOU CANNOT CANCEL YOUR ORDER NOW !");
        } else if (flag == 1 && ptr != head) {
            pre.next = ptr.next;
        }

        if (flag == 1 && ptr == head && ptr.next == head) {
            System.out.println("SORRY !! YOU CANNOT CANCEL YOUR ORDER NOW !");

        }
        if (flag == 0) {
            System.out.println("order is not placed");
        }
    }                                                              // end of cancel order

    void feedback(Queue FeedBack) {                                // feedback is the object of array list
        System.out.println("Please give us feedback in stars out of 5");
        String feedback = sc.next();
        FeedBack.A.add(feedback);
    }                                                              //end of feedback

    void review(Queue FeedBack) {
        int flag = 0;
        int count = 0;
        for (int i = 0; i < FeedBack.A.size(); i++) {
            String fe = FeedBack.A.get(i);
            int l = fe.length();
            if (l >= 3) {
                flag++;
            } else {
                count++;
            }
        }
        if (flag > count) {
            System.out.println("CAFE IS SUPERB!!!");
        } else {
            System.out.println("CAFE NEED IMPROVEMENT");
        }
    }                                                                // end of review

    void UpdateRate(Queue all, Queue beverage, Queue snacks, Queue sandwich, Queue pastry, Queue icecream, Queue Combo)
            throws IOException {
        int a = 1;
        int flag=0;
        do {
            System.out.println("Where you want to update rate of items: ");
            System.out.println("1.Beverages");
            System.out.println("2.Snacks");
            System.out.println("3.Sandwich");
            System.out.println("4.Pastry");
            System.out.println("5.Ice-cream");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            System.out.println("ENTER THE NAME OF ITEM:");
            String item = br.readLine();
            
            for (String key : all.All.keySet()) {
            	if(!Objects.equals(item,key))
            	 {
            		flag++;
            	}
            }
            if(flag==all.All.size()) {
            	System.out.println("Dish is not present");
            	return;
            }
            System.out.println("Enter new price:");
            int price = sc.nextInt();
            switch (choice) {
                case 1:
                    beverage.All.replace(item, price);
                    all.All.replace(item, price);
                    break;
                case 2:
                    snacks.All.put(item, price);
                    all.All.put(item, price);
                    break;
                case 3:
                    sandwich.All.put(item, price);
                    all.All.put(item, price);
                    break;
                case 4:
                    pastry.All.put(item, price);
                    all.All.put(item, price);
                    break;
                case 5:
                    icecream.All.put(item, price);
                    all.All.put(item, price);
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
            System.out.println("If you want to update the rate then enter 1:");
            a = sc.nextInt();
        } while (a == 1);

    }                                                                         // end of updateRate

    void ADD_NEWDISH(Queue all, Queue beverage, Queue snacks, Queue sandwich, Queue pastry, Queue icecream, Queue Combo)
            throws IOException {
        int a = 1;
        do {
            System.out.println("WHICH TYPE OF DISH YOU WANT TO ADD ");
            System.out.println("1.Beverages");
            System.out.println("2.Snacks");
            System.out.println("3.Sandwich");
            System.out.println("4.Pastry");
            System.out.println("5.Ice-cream");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            System.out.println("ENTER THE NAME OF DISH:");
            String item = br.readLine();
            System.out.println("ENTER PRICE OF DISH:");
            int price = sc.nextInt();

            switch (choice) {
                case 1:
                    beverage.All.put(item, price);
                    all.All.put(item, price);

                    break;
                case 2:
                    snacks.All.put(item, price);
                    all.All.put(item, price);
                    break;
                case 3:
                    sandwich.All.put(item, price);
                    all.All.put(item, price);
                    break;
                case 4:
                    pastry.All.put(item, price);
                    all.All.put(item, price);
                    break;
                case 5:
                    icecream.All.put(item, price);
                    all.All.put(item, price);
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
            System.out.println("If you want to add more dishes then enter 1:");
            a = sc.nextInt();
        } while (a == 1);

    }                                                                 // end ADD_NEWDISH

    void UpdateMenu(Queue ALLORDER, Queue all, Queue beverage, Queue snacks, Queue sandwich, Queue pastry,
                    Queue icecream, Queue Combo) {
        String k = null;
        String k1 = null;
        String k2 = null;
        int n = 0, n2 = 0, n3 = 0;
        int r = 0, r1 = 0, r2 = 0;
        for (String key : beverage.All.keySet()) {
            int n1 = Collections.frequency(ALLORDER.A, key);
            if (n1 > n) {
                n = n1;
                k = key;
                r = beverage.All.get(k);
            }
        }

        for (String key : sandwich.All.keySet()) {

            int n1 = Collections.frequency(ALLORDER.A, key);
            if (n1 > n2) {
                n2 = n1;
                k1 = key;
                r1 = sandwich.All.get(k1);
            }
        }

        for (String key : pastry.All.keySet()) {

            int n1 = Collections.frequency(ALLORDER.A, key);
            if (n1 > n3) {
                n3 = n1;
                k2 = key;
                r2 = pastry.All.get(k2);
            }
        }
        if (n >= 4 && n2 >= 4 && n3 >= 4) {
            System.out.println(" New Combo Pack =" + k + "+" + k1 + "+" + k2);
            System.out.println("If you want to make this customer favourite combo then enter yes ");
            String ans = sc.next();
            if (ans.equalsIgnoreCase("yes")) {
                int Rate = r + r1 + r2 - 10;
                String cp = k + "+" + k1 + "+" + k2;
                Combo.All.put(cp, Rate);
                all.All.put(cp, Rate);
            }
        }
        else {
        	System.out.println("THERE ARE NO ENOGH REPETATIVE ORDRES PRESENT TO FORM COMBO PACK!!");
        }
    }
    
    void Record(Queue CID) {
    	int noOfCustomer=CID.A.size();
    	System.out.println("Total customer"+noOfCustomer);
    	System.out.println("Total Earned Amount"+TOTAL);
    	
    }
}

public class Cafeteria {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = 1;
        int b=0;
        Queue q = new Queue();
     // objects of array list
        Queue CID = new Queue();
        Queue ALLORDER = new Queue();
        Queue FeedBack = new Queue();
        Queue RZ = new Queue();
        Queue MZ = new Queue();
        Queue GZ = new Queue();
        Queue all = new Queue();
        Queue beverage = new Queue();
        Queue snacks = new Queue();
        Queue sandwich = new Queue();
        Queue pastry = new Queue();
        Queue icecream = new Queue();
        Queue Combo = new Queue();
        System.out.println("\t\t\t\t*******WELCOME TO SNACKBAR CAFE*******\t\t\t\t\n");

        do {

            System.out.println("Who is handling this system??");
            System.out.println("1.CUSTOMER");
            System.out.println("2.MANAGER");
            System.out.println("Enter your choice:");
            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    do {
                        
                        // COMPULSORY RUN MENU METHOD FIRST
                        System.out.println("\t1.SNACK BAR MENU");
                        System.out.println("\t2.PLACE ORDER");
                        System.out.println("\t3.DISPLAY ORDER");
                        System.out.println("\t4.CANCEL ORDER");
                        System.out.println("\t5.DELIVER ORDER");
                        System.out.println("\t6.CAFE REVIEW");
                        System.out.println("\t7.EXIT FROM ZONE");
                        System.out.println("\tKindly make a choice--->");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                q.MENU(all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                q.DisplayMenu(all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                break;
                            case 2:
                            do {	Queue CORDER = new Queue();
                                q.placeorder(CID, CORDER, ALLORDER,all);
                                System.out.println("for more customer enter 1 otherwise enter any number");
                                b=sc.nextInt();
                            }while(b==1);
                                break;
                            case 3:
                                q.displayorder();
                                break;

                            case 4:
                                q.CancelOrder();
                                break;
                            case 5:
                                q.deque(CID, RZ, GZ, MZ, FeedBack, all);
                                break;
                            case 6:
                                q.review(FeedBack);
                                break;
                            case 7:
                                q.RemoveFromZone(RZ, GZ, MZ);
                                break;
                            default:
                            	System.out.println("Enter Valid Input");

                        }
                        System.out.println("If you want to continue  then Enter 1: ");
                        a = sc.nextInt();
                    } while (a == 1);
                       break;
                case 2:
                    do {
                        System.out.println("1.UPDATE RATES OF ITEMS:");
                        System.out.println("2.Add new ITEM IN MENU");
                        System.out.println("3.Add new Combo pack");
                        System.out.println("4.Check Record");
                        System.out.println("Enter your choice");
                        int choice = sc.nextInt();
                        switch (choice) {
                            case 1:
                                q.UpdateRate(all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                q.DisplayMenu(all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                break;
                            case 2:
                                q.ADD_NEWDISH(all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                q.DisplayMenu(all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                break;
                            case 3:
                                q.UpdateMenu(ALLORDER, all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                q.DisplayMenu(all, beverage, snacks, sandwich, pastry, icecream, Combo);
                                break;
                            case 4:
                            	q.Record(CID);
                            	break;
                            default:
                            	System.out.println("Enter Valid input");
                        }
                        System.out.println("If you want to continue then Enter 1: ");
                        a = sc.nextInt();
                    } while (a == 1);
                    break;

            }                                                                    // end of switch

            System.out.println(
                    "If you want to continue handling this system as CUSTOMER/MANAGER then enter 5 else enter any number");
            a = sc.nextInt();
        } while (a == 5);                                                        // end of do while
    }                                                                            // end of main
}                                                                                // end of class cafeteria





//*******WELCOME TO SNACKBAR CAFE*******
//
//Who is handling this system??
//1.CUSTOMER
//2.MANAGER
//Enter your choice:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//1
//
//BEVERAGES
//
//Cappuccinos : 40
//Iced Americano : 70
//Coca-Cola : 30
//Cold Brew coffee : 40
//Sprite : 30
//Iced coffee : 50
//Mochaccino : 70
//Cold Coffee : 70
//Fanta : 30
//Latte : 30
//
//SNACKS
//
//Muffins : 15
//Cookies : 30
//Croissant : 20
//
//SANDWICH
//
//Veg Grilled Sandwich : 60
//Corn Cheese Sandwich : 80
//Cheese Sandwich : 30
//Veg Sandwich : 40
//Veg cheese Grilled Sandwich : 80
//
//CAKES & PASTRIES
//
//Cheese Cake : 50
//Pineapple pastry  : 30
//Black Forest pastry : 20
//Red Velvet Cake : 40
//Oreo-Chocolate pastry : 50
//Rasmalai Cake : 60
//Pineapple Cake : 40
//
//ICE-CREAM
//
//Chocolate ice-cream : 40
//Mango ice-cream : 40
//Strawberry ice-cream : 30
//Vanilla ice-cream : 20
//Butterscotch ice-cream : 30
//
//Combo pack
//
//coldCoffee+CheeseSandwich+BlackForestPastry : 110
//Latte+VegGrilledSandwich+PinepalPestry : 120
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//2
//Enter the name of the Customer:
//neeta patil
//Enter the Address of the customer:
//new road
//Enter the phone number of the customer:
//8908908909
//Enter numbers of order:
//4
//Enter your order:
//Muffins
//Enter your order:
//Latte
//Enter your order:
//Cheese Cake
//Enter your order:
//Corn Cheese Sandwich
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//yash kesare
//Enter the Address of the customer:
//new building
//Enter the phone number of the customer:
//8908908908
//Enter numbers of order:
//2
//Enter your order:
//Latte
//Enter your order:
//Corn Cheese Sandwich
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//riya kumar
//Enter the Address of the customer:
//main mall
//Enter the phone number of the customer:
//7890789079
//Enter numbers of order:
//3
//Enter your order:
//hot chocolate
//Dish is not present in the menu
//Please Order something from the menu
//Enter your order:
//Latte
//Enter your order:
//Corn Cheese Sandwich
//Enter your order:
//Cheese Cake
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//jyoti
//Enter the Address of the customer:
//new city
//Enter the phone number of the customer:
//8908907678
//Enter numbers of order:
//1
//Enter your order:
//Fanta
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//eesha deore
//Enter the Address of the customer:
//new city mall
//Enter the phone number of the customer:
//9887788888
//Enter numbers of order:
//4
//Enter your order:
//Sprite
//Enter your order:
//Latte
//Enter your order:
//Corn Cheese Sandwich
//Enter your order:
//Cheese Cake
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//nitya desai
//Enter the Address of the customer:
//new mall
//Enter the phone number of the customer:
//9999999999
//Enter numbers of order:
//2
//Enter your order:
//Cheese Cake
//Enter your order:
//Oreo-Chocolate pastry
//for more customer enter 1 otherwise enter any number
//0
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//3
//
//ID:SB101
//Name of customer: neeta patil
//contact no of the customer: 8908908909
//Address of the customer: new road
//ORDER:
//Muffins, Latte, Cheese Cake, Corn Cheese Sandwich
//
//ID:SB102
//Name of customer: yash kesare
//contact no of the customer: 8908908908
//Address of the customer: new building
//ORDER:
//Latte, Corn Cheese Sandwich
//
//ID:SB103
//Name of customer: riya kumar
//contact no of the customer: 7890789079
//Address of the customer: main mall
//ORDER:
//Latte, Corn Cheese Sandwich, Cheese Cake
//
//ID:SB104
//Name of customer: jyoti
//contact no of the customer: 8908907678
//Address of the customer: new city
//ORDER:
//Fanta
//
//ID:SB105
//Name of customer: eesha deore
//contact no of the customer: 9887788888
//Address of the customer: new city mall
//ORDER:
//Sprite, Latte, Corn Cheese Sandwich, Cheese Cake
//
//ID:SB106
//Name of customer: nitya desai
//contact no of the customer: 9999999999
//Address of the customer: new mall
//ORDER:
//Cheese Cake, Oreo-Chocolate pastry
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//4
//Enter the customer Id:
//SB104
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//3
//
//ID:SB101
//Name of customer: neeta patil
//contact no of the customer: 8908908909
//Address of the customer: new road
//ORDER:
//Muffins, Latte, Cheese Cake, Corn Cheese Sandwich
//
//ID:SB102
//Name of customer: yash kesare
//contact no of the customer: 8908908908
//Address of the customer: new building
//ORDER:
//Latte, Corn Cheese Sandwich
//
//ID:SB103
//Name of customer: riya kumar
//contact no of the customer: 7890789079
//Address of the customer: main mall
//ORDER:
//Latte, Corn Cheese Sandwich, Cheese Cake
//
//ID:SB105
//Name of customer: eesha deore
//contact no of the customer: 9887788888
//Address of the customer: new city mall
//ORDER:
//Sprite, Latte, Corn Cheese Sandwich, Cheese Cake
//
//ID:SB106
//Name of customer: nitya desai
//contact no of the customer: 9999999999
//Address of the customer: new mall
//ORDER:
//Cheese Cake, Oreo-Chocolate pastry
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//4
//Enter the customer Id:
//SB101
//SORRY !! YOU CANNOT CANCEL YOUR ORDER NOW !
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//4
//Enter the customer Id:
//SB112
//order is not placed
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB101
//Name : neeta patil
//MENU                PRICE
//Muffins                 15
//Latte                   30
//Cheese Cake              50
//Corn Cheese Sandwich              80
//READING ZONE             200
//~~~~~~~~~
//Total :              375.0
//-------------------------------------------------------------------------------
//Tax   :18.75
//Final amount: 393.75
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//*****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB102
//Name : yash kesare
//MENU                PRICE
//Latte                   30
//Corn Cheese Sandwich              80
//READING ZONE             200
//~~~~~~~~~
//Total :              310.0
//-------------------------------------------------------------------------------
//Tax   :15.5
//Final amount: 325.5
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//GAMING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB103
//Name : riya kumar
//MENU                PRICE
//Latte                   30
//Corn Cheese Sandwich              80
//Cheese Cake              50
//GAMING ZONE             400
//~~~~~~~~~
//Total :              560.0
//-------------------------------------------------------------------------------
//Discount :            28.0
//Tax   :26.6
//Final amount: 558.6
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//2
//Enter the name of the Customer:
//neeta patil
//Enter the Address of the customer:
//new road
//Enter the phone number of the customer:
//9898989099
//Enter numbers of order:
//2
//Enter your order:
//Sprite
//Enter your order:
//Corn Cheese Sandwich
//for more customer enter 1 otherwise enter any number
//0
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB105
//Name : eesha deore
//MENU                PRICE
//Sprite                  30
//Latte                   30
//Corn Cheese Sandwich              80
//Cheese Cake              50
//READING ZONE             200
//~~~~~~~~~
//Total :              390.0
//-------------------------------------------------------------------------------
//Tax   :19.5
//Final amount: 409.5
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//*****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//yes
//Enter your previous ID :
//SB112
//Your ID is not present in our record!!
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB106
//Name : nitya desai
//MENU                PRICE
//Cheese Cake              50
//Oreo-Chocolate pastry              50
//READING ZONE             200
//~~~~~~~~~
//Total :              300.0
//-------------------------------------------------------------------------------
//Tax   :15.0
//Final amount: 315.0
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//***
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//yes
//Enter your previous ID :
//SB101
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB107
//Name : neeta patil
//MENU                PRICE
//Sprite                  30
//Corn Cheese Sandwich              80
//READING ZONE             200
//~~~~~~~~~
//Total :              310.0
//-------------------------------------------------------------------------------
//Revisit Discount:            31.0
//Tax   :13.950000000000001
//Final amount: 292.95
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//*****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//Queue is empty
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//3
//queue is empty
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//7
//Enter in word in the zone you are in right now
//1.ReadingZone
//2.MusicalZone
//3.GamingZone
//GamingZone
//Enter the customer Id:
//SB101
//Enter correct ID
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//7
//Enter in word in the zone you are in right now
//1.ReadingZone
//2.MusicalZone
//3.GamingZone
//GamingZone
//Enter the customer Id:
//SB103
//Enter correct ID
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//2
//Enter the name of the Customer:
//eesha
//Enter the Address of the customer:
//main vity
//Enter the phone number of the customer:
//8899999999
//Enter numbers of order:
//1
//Enter your order:
//Latte
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//yogita
//Enter the Address of the customer:
//new city
//Enter the phone number of the customer:
//8989898988
//Enter numbers of order:
//1
//Enter your order:
//Fanta
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//riya
//Enter the Address of the customer:
//main city road
//Enter the phone number of the customer:
//8789878989
//Enter numbers of order:
//1
//Enter your order:
//Sprite
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//disha kumar
//Enter the Address of the customer:
//new mall
//Enter the phone number of the customer:
//7899877890
//Enter numbers of order:
//1
//Enter your order:
//Corn Cheese Sandwich
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//isha
//Enter the Address of the customer:
//fc road
//Enter the phone number of the customer:
//7890678909
//Enter numbers of order:
//1
//Enter your order:
//Latte
//for more customer enter 1 otherwise enter any number
//1
//Enter the name of the Customer:
//veena
//Enter the Address of the customer:
//ring side
//Enter the phone number of the customer:
//9898989890
//Enter numbers of order:
//1
//Enter your order:
//Fanta
//for more customer enter 1 otherwise enter any number
//0
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB108
//Name : eesha
//MENU                PRICE
//Latte                   30
//READING ZONE             200
//~~~~~~~~~
//Total :              230.0
//-------------------------------------------------------------------------------
//Tax   :11.5
//Final amount: 241.5
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB109
//Name : yogita
//MENU                PRICE
//Fanta                   30
//READING ZONE             200
//~~~~~~~~~
//Total :              230.0
//-------------------------------------------------------------------------------
//Tax   :11.5
//Final amount: 241.5
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//***
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB110
//Name : riya
//MENU                PRICE
//Sprite                  30
//READING ZONE             200
//~~~~~~~~~
//Total :              230.0
//-------------------------------------------------------------------------------
//Tax   :11.5
//Final amount: 241.5
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//***
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB111
//Name : disha kumar
//MENU                PRICE
//Corn Cheese Sandwich              80
//READING ZONE             200
//~~~~~~~~~
//Total :              280.0
//-------------------------------------------------------------------------------
//Tax   :14.0
//Final amount: 294.0
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB112
//Name : isha
//MENU                PRICE
//Latte                   30
//READING ZONE             200
//~~~~~~~~~
//Total :              230.0
//-------------------------------------------------------------------------------
//Tax   :11.5
//Final amount: 241.5
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//WE HAVE EXTRA FEATURES LIKE :
//1.READING ZONE
//2.GAMING ZONE
//3.MUSICAL ZONE
//DO YOU WANT TO ENJOY EXTRA FEATURES ?
//yes
//ENTER WHICH FEATURE YOU WANT TO ENJOY :
//READING ZONE
//SORRY FOR INCONVENIENCE !! READING ZONE IS FULL
//Are you revisiting our cafe?
//no
//--------------------------------SNACKBAR CAFE-----------------------------------
//	BILL
//ID:  :SB113
//Name : veena
//MENU                PRICE
//Fanta                   30
//~~~~~~~~~
//Total :               30.0
//-------------------------------------------------------------------------------
//Tax   :1.5
//Final amount: 31.5
//--------------------------------THANK YOU FOR VISITING!!------------------------
//Please give us feedback in stars out of 5
//****
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//5
//Queue is empty
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//6
//CAFE IS SUPERB!!!
//If you want to continue  then Enter 1:
//0
//If you want to continue handling this system as CUSTOMER/MANAGER then enter 5 else enter any number
//5
//Who is handling this system??
//1.CUSTOMER
//2.MANAGER
//Enter your choice:
//2
//1.UPDATE RATES OF ITEMS:
//2.Add new ITEM IN MENU
//3.Add new Combo pack
//4.Check Record
//Enter your choice
//1
//Where you want to update rate of items:
//1.Beverages
//2.Snacks
//3.Sandwich
//4.Pastry
//5.Ice-cream
//Enter your choice
//1
//ENTER THE NAME OF ITEM:
//Fanta
//Enter new price:
//500
//If you want to update the rate then enter 1:
//0
//
//BEVERAGES
//
//Cappuccinos : 40
//Iced Americano : 70
//Coca-Cola : 30
//Cold Brew coffee : 40
//Sprite : 30
//Iced coffee : 50
//Mochaccino : 70
//Cold Coffee : 70
//Fanta : 500
//Latte : 30
//
//SNACKS
//
//Muffins : 15
//Cookies : 30
//Croissant : 20
//
//SANDWICH
//
//Veg Grilled Sandwich : 60
//Corn Cheese Sandwich : 80
//Cheese Sandwich : 30
//Veg Sandwich : 40
//Veg cheese Grilled Sandwich : 80
//
//CAKES & PASTRIES
//
//Cheese Cake : 50
//Pineapple pastry  : 30
//Black Forest pastry : 20
//Red Velvet Cake : 40
//Oreo-Chocolate pastry : 50
//Rasmalai Cake : 60
//Pineapple Cake : 40
//
//ICE-CREAM
//
//Chocolate ice-cream : 40
//Mango ice-cream : 40
//Strawberry ice-cream : 30
//Vanilla ice-cream : 20
//Butterscotch ice-cream : 30
//
//Combo pack
//
//coldCoffee+CheeseSandwich+BlackForestPastry : 110
//Latte+VegGrilledSandwich+PinepalPestry : 120
//If you want to continue then Enter 1:
//1
//1.UPDATE RATES OF ITEMS:
//2.Add new ITEM IN MENU
//3.Add new Combo pack
//4.Check Record
//Enter your choice
//1
//Where you want to update rate of items:
//1.Beverages
//2.Snacks
//3.Sandwich
//4.Pastry
//5.Ice-cream
//Enter your choice
//1
//ENTER THE NAME OF ITEM:
//tea
//Dish is not present
//
//BEVERAGES
//
//Cappuccinos : 40
//Iced Americano : 70
//Coca-Cola : 30
//Cold Brew coffee : 40
//Sprite : 30
//Iced coffee : 50
//Mochaccino : 70
//Cold Coffee : 70
//Fanta : 500
//Latte : 30
//
//SNACKS
//
//Muffins : 15
//Cookies : 30
//Croissant : 20
//
//SANDWICH
//
//Veg Grilled Sandwich : 60
//Corn Cheese Sandwich : 80
//Cheese Sandwich : 30
//Veg Sandwich : 40
//Veg cheese Grilled Sandwich : 80
//
//CAKES & PASTRIES
//
//Cheese Cake : 50
//Pineapple pastry  : 30
//Black Forest pastry : 20
//Red Velvet Cake : 40
//Oreo-Chocolate pastry : 50
//Rasmalai Cake : 60
//Pineapple Cake : 40
//
//ICE-CREAM
//
//Chocolate ice-cream : 40
//Mango ice-cream : 40
//Strawberry ice-cream : 30
//Vanilla ice-cream : 20
//Butterscotch ice-cream : 30
//
//Combo pack
//
//coldCoffee+CheeseSandwich+BlackForestPastry : 110
//Latte+VegGrilledSandwich+PinepalPestry : 120
//If you want to continue then Enter 1:
//1
//1.UPDATE RATES OF ITEMS:
//2.Add new ITEM IN MENU
//3.Add new Combo pack
//4.Check Record
//Enter your choice
//2
//WHICH TYPE OF DISH YOU WANT TO ADD
//1.Beverages
//2.Snacks
//3.Sandwich
//4.Pastry
//5.Ice-cream
//Enter your choice
//2
//ENTER THE NAME OF DISH:
//buiscuits
//ENTER PRICE OF DISH:
//40
//If you want to add more dishes then enter 1:
//0
//
//BEVERAGES
//
//Cappuccinos : 40
//Iced Americano : 70
//Coca-Cola : 30
//Cold Brew coffee : 40
//Sprite : 30
//Iced coffee : 50
//Mochaccino : 70
//Cold Coffee : 70
//Fanta : 500
//Latte : 30
//
//SNACKS
//
//Muffins : 15
//Cookies : 30
//Croissant : 20
//buiscuits : 40
//
//SANDWICH
//
//Veg Grilled Sandwich : 60
//Corn Cheese Sandwich : 80
//Cheese Sandwich : 30
//Veg Sandwich : 40
//Veg cheese Grilled Sandwich : 80
//
//CAKES & PASTRIES
//
//Cheese Cake : 50
//Pineapple pastry  : 30
//Black Forest pastry : 20
//Red Velvet Cake : 40
//Oreo-Chocolate pastry : 50
//Rasmalai Cake : 60
//Pineapple Cake : 40
//
//ICE-CREAM
//
//Chocolate ice-cream : 40
//Mango ice-cream : 40
//Strawberry ice-cream : 30
//Vanilla ice-cream : 20
//Butterscotch ice-cream : 30
//
//Combo pack
//
//coldCoffee+CheeseSandwich+BlackForestPastry : 110
//Latte+VegGrilledSandwich+PinepalPestry : 120
//If you want to continue then Enter 1:
//1
//1.UPDATE RATES OF ITEMS:
//2.Add new ITEM IN MENU
//3.Add new Combo pack
//4.Check Record
//Enter your choice
//3
//New Combo Pack =Latte+Corn Cheese Sandwich+Cheese Cake
//If you want to make this customer favourite combo then enter yes
//yes
//
//BEVERAGES
//
//Cappuccinos : 40
//Iced Americano : 70
//Coca-Cola : 30
//Cold Brew coffee : 40
//Sprite : 30
//Iced coffee : 50
//Mochaccino : 70
//Cold Coffee : 70
//Fanta : 500
//Latte : 30
//
//SNACKS
//
//Muffins : 15
//Cookies : 30
//Croissant : 20
//buiscuits : 40
//
//SANDWICH
//
//Veg Grilled Sandwich : 60
//Corn Cheese Sandwich : 80
//Cheese Sandwich : 30
//Veg Sandwich : 40
//Veg cheese Grilled Sandwich : 80
//
//CAKES & PASTRIES
//
//Cheese Cake : 50
//Pineapple pastry  : 30
//Black Forest pastry : 20
//Red Velvet Cake : 40
//Oreo-Chocolate pastry : 50
//Rasmalai Cake : 60
//Pineapple Cake : 40
//
//ICE-CREAM
//
//Chocolate ice-cream : 40
//Mango ice-cream : 40
//Strawberry ice-cream : 30
//Vanilla ice-cream : 20
//Butterscotch ice-cream : 30
//
//Combo pack
//
//coldCoffee+CheeseSandwich+BlackForestPastry : 110
//Latte+VegGrilledSandwich+PinepalPestry : 120
//Latte+Corn Cheese Sandwich+Cheese Cake : 150
//If you want to continue then Enter 1:
//1
//1.UPDATE RATES OF ITEMS:
//2.Add new ITEM IN MENU
//3.Add new Combo pack
//4.Check Record
//Enter your choice
//4
//Total customer13
//Total Earned Amount3586.7999999999997
//If you want to continue then Enter 1:
//0
//If you want to continue handling this system as CUSTOMER/MANAGER then enter 5 else enter any number
//5
//Who is handling this system??
//1.CUSTOMER
//2.MANAGER
//Enter your choice:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//7
//Enter in word in the zone you are in right now
//1.ReadingZone
//2.MusicalZone
//3.GamingZone
//ReadingZone
//Enter the customer Id:
//sb454
//Enter correct ID
//If you want to continue  then Enter 1:
//1
//1.SNACK BAR MENU
//2.PLACE ORDER
//3.DISPLAY ORDER
//4.CANCEL ORDER
//5.DELIVER ORDER
//6.CAFE REVIEW
//7.EXIT FROM ZONE
//Kindly make a choice--->
//7
//Enter in word in the zone you are in right now
//1.ReadingZone
//2.MusicalZone
//3.GamingZone
//ReadingZone
//Enter the customer Id:
//SB109
//If you want to continue  then Enter 1:
//0
//If you want to continue handling this system as CUSTOMER/MANAGER then enter 5 else enter any number
//0

