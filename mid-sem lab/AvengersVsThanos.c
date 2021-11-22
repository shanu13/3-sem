
#include<stdio.h>
#include<stdlib.h>

int FightGoing(int *spaceshipCondition, int *spaceshipInLine, int noOfShips)
{
	for (int i = 0; i < noOfShips; i++, spaceshipCondition++, spaceshipInLine++)
	{
		if ((*spaceshipCondition != 1) || (*spaceshipInLine != 1))
			return 0;
	}

	return 1;
}


int main(int argc, char *argv[])
{
	int noOfMissile = 0;

	//Reading values of Thanos Army
	FILE *fp = NULL;

	if (argc != 2)
	{
		printf("You did not enter the filename eith lengths of Thanos shpaceship.\n");
		exit(1);
	}

	if ((fp = fopen(argv[1], "r+")) == NULL)
	{
		printf("Could not open the file.\n");
		exit(1);
	}

	int noOfShips = 0;

	fscanf(fp, "%d", &noOfShips);

	double *spaceshipLength = (double *)calloc(noOfShips, sizeof(double));
	int spaceshipCondition[noOfShips];
	int spaceshipInLine[noOfShips];

	//reading the length of ships and setting the condition
	for (int i = 0; i < noOfShips; i++)
	{
		fscanf(fp, "%f", spaceshipLength[i]);
		spaceshipCondition[i] = 1;
		spaceshipInLine[i] = 1;
	}


	return 0;
}
