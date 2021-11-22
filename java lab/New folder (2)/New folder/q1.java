import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class q1{

	public static void main(String[] args) {

		if(args.length != 2) {
			System.out.println("File Name must be passed as argument");
			return;
		}

		BufferedReader read1,read2;
		read1 = read2 = null;

		try{
			File file1 = new File(args[0]);
			read1 = new BufferedReader(new FileReader(file1));
			File file2 = new File(args[1]);			
			read2 = new BufferedReader(new FileReader(file2));
			read2.mark(10000);

			String word1, word2;

			int line1[] = new int[10];
			int line2[] = new int[10];
			int k = 0;
			boolean same = false;

			for (int i = 0; (word1 = read1.readLine()) != null; i++)
			{

				read2.reset();
				k = 0;
				line1[0] = i + 1;
				same = false;


				for (int j = 0; (word2 = read2.readLine()) != null; j++)
				{
					boolean sameword = word2.equalsIgnoreCase(word1);

					if (sameword)
					{
						line2[k++] = j + 1;
						same = true;
					}
				}

				if (same)
				{
					System.out.print(word1 + " : Length - " + word1.length() + ", appeared in the line " + line1[0] + " of " + args[0] + " and ");
					for (int j = 0; j < k; j++)
						System.out.print(line2[j] + ", ");
					System.out.println("line of the " + args[1]);
				}



			}
		}


		catch(FileNotFoundException e) {
			System.out.println("File does not Exist");
		}
		catch(IOException e) {
			System.out.println("Error occured...");
			System.out.println(e);
		}finally

		{

			try
			{
				if (read1 != null)
					read1.close();
			} catch (IOException e) {
				System.out.println("Error closing text file 1 : " + e);
			}
			try
			{
				if (read2 != null)
					read2.close();
			} catch (IOException e) {
				System.out.println("Error closing text file 2 : " + e);
			}
		}


	}    

}
