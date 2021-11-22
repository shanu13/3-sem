public class q2 {

	public static void main(String[] args) {

		int n = args.length;
		if(n == 0)
			System.out.println("Error: No numbers to perform division");
		else if(n == 1)
			System.out.println("Error: Divide requires  two numbers");

		int num_1 = Integer.parseInt(args[0]);
		int num_2 = Integer.parseInt(args[1]);

        if(num_2 == 0)
            System.out.println("Error: Division by zero is not possible");
        else if(num_1%num_2 != 0)
            System.out.println("Not divisible");
		else
		{
			int result;
			result = num_1/num_2;
			System.out.println(result);
		}
	}
}
