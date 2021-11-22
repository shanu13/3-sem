import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CommonWords {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Two file names must be passed as argument to find the common words.");
			return ;
		}
		
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		
		try {
			

			//initializing the buffer
			File file1 = new File(args[0]);
			br1 = new BufferedReader(new FileReader(file1));
			File file2 = new File(args[1]);
			br2 = new BufferedReader(new FileReader(file2));
			br2.mark(10000);

			String word1, word2;
			
			int line1[] = new int[10];
			int line2[] = new int[10];
			int k = 0;
			boolean sameFlag = false;


			for (int i = 0; (word1 = br1.readLine()) != null; i++)
			{
				//resetting file 2 to beginning
				br2.reset();
				k = 0;
				line1[0] = i + 1;
				sameFlag = false;

				//checking in second file word by word
				for (int j = 0; (word2 = br2.readLine()) != null; j++)
				{
					boolean sameWord = word2.equalsIgnoreCase(word1);

					if (sameWord)
					{
						line2[k++] = j + 1;
						sameFlag = true;
					}
				}

				if (sameFlag)
				{
					System.out.print(word1 + " : Length - " + word1.length() + ", appeared in the line " + line1[0] + " of " + args[0] + " and line ");
					for (int j = 0; j < k; j++)
						System.out.print(line2[j] + ", ");
					System.out.println(" of the " + args[1]);
				}
			}
		} catch(FileNotFoundException e)
		{
			System.out.println("File does not exist in the given location");
		} catch(IOException e)
		{
			System.out.println("Some Error occured...");
			System.out.println(e);
		} finally
		{
			//closing the buffer
			try
			{
				if (br1 != null)
					br1.close();
			} catch (IOException e) {
				System.out.println("Error closing text file 1 : " + e);
			}
			try
			{
				if (br2 != null)
					br2.close();
			} catch (IOException e) {
				System.out.println("Error closing text file 2 : " + e);
			}
		}
	}

}