import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

class Return
{
	String word;
	int[] line;
	int[] position;

	Return()
	{
		word = null;
		line = new int[10];
		position = new int[10];
	}

	void Print(String file1, String file2)
	{
		System.out.print(word + " : Length - " + word.length() + ", appeared in the line " + line[0] + " and position " + position[0] + " of " + file1 + " and line ");
		for (int j = 1; line[j] != 0; j++)
			System.out.print(line[j] + ": position " + position[j] + ", ");
		System.out.println(" of the " + file2);

	}
}

class FileThread extends Thread
{
	Thread th;
	BufferedReader br;

	FileThread(String fileName) throws IOException
	{
		try 
		{
			File file = new File(fileName);
			br = new BufferedReader(new FileReader(file));
			br.mark(10000);
		} catch (FileNotFoundException e)
		{
			System.out.println("File does not exist in the given location");
		}
	}

	public Return runFile(FileThread file2) throws IOException
	{
		Return returnValue = new Return();

		String word1, word2;
		int k = 0;

		word1 = br.readLine();

		//checking in second file word by word
		for (int i = 0, j = 0; (word2 = file2.br.readLine()) != null; i++, j += word1.length())
		{
			boolean sameWord = word2.equalsIgnoreCase(word1);

			if (sameWord)
			{
				returnValue.word = word1;
				returnValue.line[k] = i;
				returnValue.position[k] = j;
				k++;
			}
		}

		file2.br.reset();
		return returnValue;
	} 
}

public class WordThread
{
	public static void main(String[] args)
	{
		if (args.length != 2)
		{
			System.out.println("Two file names must be passed as argument to find the common words.");
			return ;
		}
		try{

			FileThread file1 = new FileThread(args[0]);
			FileThread file2 = new FileThread(args[1]);

			Return data = new Return();

			try
			{
				ArrayList<Return> Value = new ArrayList<Return> ();

				while (file1.br != null){
					data = file1.runFile(file2);
					Value.add(data);
				}

				for (int i = 0; i < Value.size() ; i++)
					Value.get(i).Print(args[0], args[1]);

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
					if (file1.br != null)
						file1.br.close();
				} catch (IOException e) {
					System.out.println("Error closing text file 1 : " + e);
				}
				try
				{
					if (file2.br != null)
						file2.br.close();
				} catch (IOException e) {
					System.out.println("Error closing text file 2 : " + e);
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("Error closing text file 1 : " + e);

		}
	}
}
