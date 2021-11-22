import java.util.Scanner;
import java.util.Date;

abstract class User
{
	private int userID;
	private String name;
	private String address;
	private String PAN;
	private Date date;

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
	private Date dateOfJoining;
	private int salary;
	private int permissibleOperations;

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
	private Date dateOfJoining;
	private int salary;
	private int dutyHourPerDay;

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
	private String itemCode;
	private float price;
	private int availableQty;

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
	private Date dateOfExpiry;

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
	private int returnCount;

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
	private Date dateOfSell;
	private String itemCode;
	private int quantity;
	private float totalAmount;

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
	private Date dateOfReturn;
	private String itemCode;
	private int quantity;
	private float totalAmount;

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


	}
}
