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

void ThanosGettingReady(double *spaceshipLength, int *spaceshipCondition, int *spaceshipInLine, int *noOfShips, int *TIME)
{
	//checking for inline destroyed ships
	for (int i = 0; i < *noOfShips; i++)
	{
		if (spaceshipInLine[i] == 0)
		{
			*TIME += spaceshipLength[i];
			//checking for damage
			if (i == 0 && i == (*noOfShips - 1))
			{
				//only one ship is there so it goy destroyed
			} else if (i == 0 && i != (*noOfShips - 1))
			{
				*TIME += spaceshipLength[i + 1]/2;
				spaceshipCondition[i + 1] = 1;
			} else if ( i == (noOfShips - 1)) {
				*TIME += spaceshipLength[i - 1]/2;
				spaceshipCondition[i - 1] = 1;
			} else {
				*TIME += spaceshipLength[i - 1]/2;
				*TIME += spaceshipLength[i + 1]/2;

				spaceshipCondition[i - 1] = 1;
				spaceshipCondition[i + 1] = 1;
			}

			//changing the length of destroyed ship to zero
			for (int j = i; j < *noOfShips - 1; j++)
			{
				spaceshipLength[j] = spaceshipLength[j + 1];
				spaceshipCondition[j] = spaceshipCondition[j + 1];
				spaceshipInLine[j] = spaceshipInLine[j + 1];

			}
		}
	}

	*noOfShips -= 1;
}

void DestroySpaceship(int *spaceshipCondition, int *spaceshipInLine, int noOfShips, int index)
{
	if (index == 0 && index == (noOfShips - 1))
	{
		spaceshipCondition[index] = -1;
		spaceshipInLine[index] = 0;
	} else if (index == 0 && index != (noOfShips - 1))
	{
		spaceshipCondition[index + 1] = -1;
		spaceshipInLine[index + 1] = 0;
	} else if ( index == (noOfShips - 1)) {
		spaceshipCondition[index - 1] = -1;
		spaceshipInLine[index - 1] = 0;
	} else {
		spaceshipCondition[index - 1] = -1;
		spaceshipInLine[index - 1] = 0;

		spaceshipCondition[index + 1] = 1;
		spaceshipInLine[index + 1] = 0;
	}

}

//using top down approach to find which spaceship to destroy
int SpaceshipToDestroyHelp(double *spaceshipLength, int noOfShips, int *indexArr)
{
	if (indexArr[noOfShips] >= 0)
		return indexArr[noOfShips];

	int shipIndex = 0;

	if (noOfShips == 0)
		shipIndex = 0;
	else
		for (int i = 0; i < noS; ++i)
		{
			shipIndex = min(shipIndex, )
		}

}

int SpaceshipToDestroy(double *spaceshipLength, int noOfShips)
{
	int indexArr[noOfShips];

	for (int i = 0; i < nS; ++i)
		indexArr[i] = -1;

	return SpaceshipToDestroyHelp(spaceshipLength, noOfShips, indexArr);

}






int main(int argc, char *argv[])
{
	int noOfMissile = 0;

	float TIME = 0.0;

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
		fscanf(fp, "%lf", &spaceshipLength[i]);
		spaceshipCondition[i] = 1;
		spaceshipInLine[i] = 1;
	}


	return 0;
}
