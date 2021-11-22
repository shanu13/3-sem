//import java.util.;
import java.util.*;

abstract class User
{
	int userID;
	String name;
	String address;
	String PAN;
	Date date;

	//Constructors
	User()
	{
		userID = -1;
		name = null;
		address = null;
		PAN = null;
		date = new Date(0,0,0);
	}

	User (int ID, String nam, String add, String pan, String dateStr)
	{
		userID = ID;
		name = nam;
		address = add;
		PAN = pan;
		date = new Date(dateStr);
	}
}

class Admin extends User
{
	Date dateOfJoining;
	int salary;
	int permissibleOperations;

	//Constructors
	Admin()
	{
		dateOfJoining = new Date(0, 0, 0);
		salary = 0;
		permissibleOperations = -1;
	}

	Admin(int ID, String nam, String add, String pan, String dat, String dateStr, int sal, int per)
	{
		super(ID, nam, add, pan, dat);
		dateOfJoining = new Date(dateStr);
		salary = sal;
		permissibleOperations = per;
	}

	//methods
}

class General extends User
{
	Date dateOfJoining;
	int salary;
	int dutyHourPerDay;

	//COnstructor
	General()
	{
		dateOfJoining = new Date(0, 0, 0);
		salary = 0;
		dutyHourPerDay = 0;
	}

	General(int ID, String nam,String add, String pan, String dat, String dateStr, int sal, int duty)
	{
		super(ID, nam, add, pan, dat);
		dateOfJoining = new Date(dateStr);
		salary = sal;
		dutyHourPerDay = duty;
	}

	//Methods
	
}

abstract class Item
{
	String itemCode;
	float price;
	int availableQty;

	//Constructors
	Item()
	{
		itemCode = null;
		price = 0;
		availableQty = 0;
	}

	Item(String code, float cost, int qty)
	{
		itemCode = code;
		price = cost;
		availableQty = qty;
	}

	//Methods
	
}

class FoodItem extends Item
{
	Date dateOfExpiry;

	//Constructor
	FoodItem()
	{
		super();
		dateOfExpiry = new Date(0, 0, 0);
	}

	FoodItem(String code, float cost, int qty, String dateStr)
	{
		super(code, cost, qty);
		dateOfExpiry = new Date(dateStr);
	}

	//Methods
	
}

class NonFoodItem extends Item
{
	int returnCount;

	//Constructor
	NonFoodItem()
	{
		super();
		returnCount = 0;
	}

	NonFoodItem(String code, float cost, int qty, int count)
	{
		super(code, cost, qty);
		returnCount = count;
	}

	//Methods
	
}

class Sell
{
	Date dateOfSell;
	String itemCode;
	int quantity;
	float totalAmount;

	//Constructors
	Sell()
	{
		dateOfSell = new Date(0, 0, 0);
		itemCode = null;
		quantity = 0;
		totalAmount = 0;
	}

	Sell(String dateStr, String code, int qty, float total)
	{
		dateOfSell = new Date(dateStr);
		itemCode = code;
		quantity = qty;
		totalAmount = total;
	}

	//Methods
	
}

class Return
{
	Date dateOfReturn;
	String itemCode;
	int quantity;
	float totalAmount;

	//Constructors
	Return()
	{
		dateOfReturn = new Date(0, 0, 0);
		itemCode = null;
		quantity = 0;
		totalAmount = 0;
	}

	Return(String dateStr, String code, int qty, float total)
	{
		dateOfReturn = new Date(dateStr);
		itemCode = code;
		quantity = qty;
		totalAmount = total;
	}

	//Methods
	
}


class MidSem
{
	public static void main(String[] args)
	{
		//Adding Admin
		ArrayList<User> USER = new ArrayList<User>();

		USER.add(new Admin(1, "Manojit", "IIITG", "1", "01/01/1990", "01/01/2020", 1, 1));

		Scanner scan = new Scanner(System.in);

		ArrayList<Item> ITEM = new ArrayList<Item>();

		int flag = 0;//for braking loop
		int choiceLoop = 0, choiceAdmin = 0;
		int isAddmin = 0;


		do
		{
			System.out.println("Enter 1 for Admin option : ");
			System.out.println("Enter 2 to for Non-Admin options : ");
			System.out.println("Enter 3 to Exit");
			choiceLoop = scan.nextInt();

			switch(choiceLoop)
			{
				case 1 : System.out.println("Enter the admin credentials : ");
					 String adSc = scan.nextLine();

					 for (int i = 0; i < USER.size(); i++)
					 {
						 if (adSc.equals(USER.get(i).name))
							 isAdmin = 1;
					 }

					 if (isAdmin == 1)
					 {
						 System.out.println("Enter 1 for adding new item : ");
						 System.out.println("Enter 2 for deleting an item : ");
						 System.out.println("Enter 3 for modifying an item : ");
						 choiceAdmin = scan.nextInt();

						 switch(choiceAdmin)
						 {
							 case 1 : System.out.print("Enter item code : ");
								  String IC = scan.nextLine();

								  System.out.print("Enter the price of item : ");
								  float pr = scan.nextFLoat();

								  System.out.print("Enter the total quantity available : ");
								  int qt = scan.nextInt();

								  if (IC[0] == 'F' || IC[0] == 'f')
								  {
									  System.out.print("Enter the date of expiry : ");
									  String d = scan.nextLine();

									  ITEM.add(new FoodItem(IC, pr, qt, d));
								  } else {
									  System.out.print("Enter the return count of item : ");
									  int co = scan.nextInt();

									  ITEM.add(new NonFoodItem(IC, pr, qt, co));
								  }
								  break;

							case 2 : System.out.print("Enter the item code of item to be removed : ");
								 String cod = scan.nextLine();

								 for (int i = 0; i < ITEM.size(); i++)
								 {
									 if (cod.equals(ITEM.get(i).itemCode))
									 {
										 if (ITEM.get(i).availableQty == 0)
											 ITEM.remove(i);
									 }
								 }
								 break;

							case 3 : System.out.print("Enter the item code for an item to be modified : ");
								 String cod = scan.nextLine();

								 for (int i = 0; i < ITEM.size(); i++)
								 {
									 if (cod.equals(ITEM.get(i).itemCode))
									 {
										 System.out.println("Enter 1 to modify price : ");
										 System.out.println("Enter 2 to modify the quantity : ");
										 int ch = sacn.nextInt();

										 if (ch == 1)
										 {
											 System.out.print("Enter the price : ");
											 float pr = scan.nextFLoat();
											 ITEM.get(i).changePrice(pr);
										 } else {
											 System.out.print("Enter the quantity : ");
											 int qty1 = scan.nextInt();

											 ITEM.get(i).changeQty(qty1);
										 }
									 }
								 }
								 break;
						 }
					 }

					 break;

				case 2 : break;
			}



		} while (flag != 1);


	}
}