class Operation
{
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.out.println("Error : No user input to perform division.");
		} else if (args.length == 1) {
			if (!(args[0].toLowerCase() == "divide"))
				System.out.println("Error : No numbers to perform division.");
			else
				System.out.println("Error : No operation mentioned and only one number provided.");
		} else if (args.length == 2) {
			if (!(args[0].toLowerCase() == "divide"))
				System.out.println("Error : Division requires two numbers.");
			else
				System.out.println("Error : No operation mentioned to be performed.");
		} else {
			int num1 = Integer.parseInt(args[1]);
			int num2 = Integer.parseInt(args[2]);

			if (!(args[0].toLowerCase() == "divide"))
			{
				if (num2 != 0)
				{
					int output = num1 / num2;

					if (num1%num2 == 0)
						System.out.println(output);
					else
						System.out.println("Not divisible.");
				} else {
					System.out.println("Error : Division by zero not possible.");
				}
			}
		}
	}
}
