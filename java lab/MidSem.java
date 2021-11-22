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
	}

	Admin(String dateStr, int sal, int per)
	{
		dateOfJoining = new Date(dateStr);



class MidSem
{
	public static void main(String[] args)
	{


	}
}
