#include<stdio.h>
#include<stddef.h>
#include<string.h>
#include<ctype.h>
#include<stdlib.h>
//#include <sys/cdefs.h>

//to convert command into upper case
void cmdToUpper(char *input)
{
	for( ; *input; input++)
	{
		if (isalpha(*input))
			*input = (*input > 90) ? *input - 32 : *input;
	}
}

//to check if the value lies within the content length
int inContent(int strlength, int value)
{
	return (value >= 0) && (value <= strlength);
}

//use for decompsing the command provided
//return the command option
int cmdBreaking(char input[], int *num1, int *num2)
{
	char cmdGiven[16] = "\0";
	int flag = 0, minusSign = 1;

	for (int i = 0; i < strlen(input); i++)
	{
		if (input[i] != ' ')
		{
			if (flag == 0)
			{
				cmdGiven[i] = input[i];
			} else if (flag == 1) {
				if (input[i] == '-')
					minusSign = -1;
				else
					*num1 = (*num1 * 10) + (input[i] - '0');
			} else if (flag == 2) {
                                *num2 = (*num2 * 10) + (input[i] - '0');
			}
		} else {
			if (flag == 0)
				cmdGiven[i] = '\0';

			flag++;
		}
	}

	*num1 *= minusSign;

	/*
	printf("Command after decoding\n");
	printf("Command given : %s--\nnum1 : %d\nnum2 : %d\n",cmdGiven, *num1, *num2);
	*/

	if (strcmp(cmdGiven, "EXIT") == 0)
		return 1;
	else if (strcmp(cmdGiven, "PRINT") == 0)
		return 2;
	else if (strcmp(cmdGiven, "PRINT_CURSOR") == 0)
		return 3;
	else if (strcmp(cmdGiven, "INSERT") == 0)
		return 4;
	else if (strcmp(cmdGiven, "SEEK") == 0)
		return 5;
	else if (strcmp(cmdGiven, "DELETE") == 0)
		return 6;
	else if (strcmp(cmdGiven, "COPY") == 0)
		return 7;
	else if (strcmp(cmdGiven, "PRINT_CLIPBOARD") == 0)
		return 8;
	else if (strcmp(cmdGiven, "CUT") == 0)
		return 9;
	else if (strcmp(cmdGiven, "PASTE") == 0)
		return 10;
	else if (strcmp(cmdGiven, "UNDO") == 0)
		return 11;
}

//to make the copy of content fron index X-Y into clipboard
void makeCopy(char *content, const int *num1, const int *num2, char *clipboard, int *indexClipboard)
{
	int maxIndex = 0, minIndex = 0;

	minIndex = *num1 < *num2 ? *num1 : *num2;
	maxIndex = *num1 < *num2 ? *num2 : *num1;

	for (int i = minIndex; i <= maxIndex; i++)
	{
		if (content[i])
		{
			clipboard[*indexClipboard] = content[i];
			*indexClipboard += 1;
		}
	}
}

//defining queue for redo and undo
typedef struct
{
	int capacity;
	char **arrContent;
	int front;
	int rear;
} Queue;

Queue *newQueue(int size)
{
	Queue *temp = (Queue *)calloc(1, sizeof(Queue));

	temp->capacity = size;
	temp->front = 0;
	temp->rear = 0;
	temp->arrContent = (char **)calloc(size, sizeof(char *));
	for (int i = 0; i < size; i++)
		temp->arrContent[i] = (char *)calloc(100, sizeof(char));

	return temp;
}

int isFull(Queue *pBox)
{
	if (pBox->rear == (pBox->front + 1) % pBox->capacity)
		return 1;
	else
		return 0;
}

int isEmpty(Queue *pBox)
{
	if (pBox->front == pBox->rear)
		return 1;
	else
		return 0;
}

void Enqueue(Queue **ppBox, char content[])
{
	if (isFull(*ppBox))
	{
		strcpy((*ppBox)->arrContent[(*ppBox)->front],content);
		(*ppBox)->front = ((*ppBox)->front + 1) % (*ppBox)->capacity;
		(*ppBox)->rear = ((*ppBox)->rear + 1) % (*ppBox)->capacity;
	} else {
		strcpy((*ppBox)->arrContent[(*ppBox)->front], content);
		(*ppBox)->front = ((*ppBox)->front + 1) % (*ppBox)->capacity;
	}
}

void Dequeue(Queue **ppBox, char *content)
{
	if (isEmpty(*ppBox))
	{
		printf("No more operations left.\n");
	} else {
//		int length = strlen((*ppBox)->arrContent[(*ppBox)->front]);

//		for (int i = 0; i <= length; i++)
		strcpy(content,(*ppBox)->arrContent[(*ppBox)->front]);

		(*ppBox)->front = ((*ppBox)->front - 1) % (*ppBox)->capacity;
	}
}


int main()
{
	int exitFlag = 0, cmd = 0;
	char input[50];
	int num1 = 0, num2 = 0;

	int cursor = 0, indexClipboard = 0, contentLength = 0;
//	char *content = (char *)calloc(100, sizeof(char));
	char content[100] = "HELLO";
	char clipboard[100] = "\0";

	//Making Undo and Redo queue
	Queue *pUndo = newQueue(8), *pRedo = newQueue(8);

	for ( ; ; )
	{
		//for beginning of loop sets
		contentLength = strlen(content);
		printf("Current content length : %d\n", contentLength);
		printf("$");
		gets(input);

		cmdToUpper(input);

		cmd = cmdBreaking(input, &num1, &num2);

		switch (cmd)
		{
			case 1 : exitFlag = 1;
				 break;
			case 2 : printf("%s\n", content);
				 break;
			case 3 : printf("Current cusor position : %d\n", cursor);
				 break;
			case 4 : if (cursor <= contentLength)
				 {
					 Enqueue(&pUndo, content);

					 num1 += '0';
					 content[contentLength + 1] = '\0';

					 for (int i = contentLength; i > cursor; i--)
						 content[i] = content[i - 1];

					 content[cursor++] = (char)num1;
				 }
				 break;
			case 5 : if (inContent(contentLength, num1))
				 {
					 Enqueue(&pUndo, content);

					 if (num1 == -1)
						 cursor = contentLength;
					 else
						 cursor = num1;
				 }
				 break;
			case 6 : if (inContent(contentLength, cursor + num1))
				 {
					 Enqueue(&pUndo, content);

					 if (num1 == 1)
					 {
						 for (int i = cursor; i < contentLength; i++)
						 	content[i] = content[i + i];
					 } else if (num1 == -1) {
						 for (int i = cursor + num1; i < contentLength; i++)
							 content[i] = content[i + 1];
					 	cursor--;
					 }
				 }
				 break;
			case 7 : if (inContent(contentLength, num1) && inContent(contentLength, num2))
				 {
					 Enqueue(&pUndo, content);
					 makeCopy(content, &num1, &num2, clipboard, &indexClipboard);
				 }
				 break;
			case 8 : printf("Clipboard : %s\n", clipboard);
				 break;
			case 9 : if (inContent(contentLength, num1) && inContent(contentLength, num2))
				 {
					 Enqueue(&pUndo, content);

					 makeCopy(content, &num1, &num2, clipboard, &indexClipboard);
					 for (int i = num1, j = num2 + 1; j <= contentLength; i++, j++)
						 content[i] = content[j];

					 cursor = strlen(content);
				 }
				 break;
			case 10 : if (inContent(contentLength, num1))
				  {
					  int lenClipboard = strlen(clipboard);
					  makeCopy(content, &num1, &contentLength, clipboard, &indexClipboard);

					  int zero = 0, num = strlen(clipboard);
					  cursor = lenClipboard + num1;
					  makeCopy(clipboard, &zero, &num, content, &num1);

				  }
				  break;
			case 11 : //char temp[100];

				  Dequeue(&pUndo, content);

				  //strcpy(temp, content);
				  Enqueue(&pRedo,content);

				  break;

			default : printf("Invalid command. Try to enter the correct command\n");
				  break;
		}

		if (exitFlag == 1)
			break;

		//restting for next loop
		num1 = 0;
		num2 = 0;
		printf("\n");

		printf("Content : %s\nClipBoard : %s\n", content, clipboard);
	}

	return 0;
}
