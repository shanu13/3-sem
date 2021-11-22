#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct node
{
    char data;
    int *next;
};

void addatend(struct node **headref, char c,int *cursorref)
{
    struct node *newnode = (struct node *)(malloc(sizeof(struct node)));
    struct node *temp=*headref;
    newnode->next=NULL;
    newnode->data=c;
    if(*headref == NULL)
    {
        *headref=newnode;
        *cursorref=*cursorref+1;
        return;
    }
    while(temp->next != NULL)
    {
        temp=temp->next;
    }


    temp->next=newnode;
    *cursorref=*cursorref+1;
}




void printlist(struct node *head)
{
    struct node *temp=head;
    while(temp!=NULL)
    {
        printf("%c",temp->data);
        temp=temp->next;
    }
}
void Exitp()
{
    exit(0);
}

void insert(struct node **headref,char ch,int position,int *cursor)
{
    struct node *newnode=(struct node *)(malloc(sizeof(struct node)));
    newnode->data=ch;

    struct node *temp=*headref;
    int count=0;
    if(position == 0)
    {
        newnode->next=temp;
        *headref=newnode;
        *cursor=0;
        return;
    }
    while(count!=position)
    {
        temp=temp->next;
        count++;
    }
    newnode->next=temp->next;
    temp->next=newnode;
    *cursor=position+1;

}
void seek(struct node *head,int position,int *cursorref)
{
    *cursorref=position;
    int count=0;
    while(count!=position)
    {
        head=head->next;
        count++;
    }
    printf("%c",head->data);

}

void Delete(struct node **headref,int *cursorref)
{
    struct node *temp=*headref;
    struct node *prev=*headref;

    int count=0;
    if(*cursorref==0)
    {
        return;
    }
    else if(*cursorref==1)
    {
        *headref=temp->next;
        free(temp);
        *cursorref=0;
    }
    else if(*cursorref==2)
    {
        prev=temp;
        temp=temp->next;
        temp=temp->next;
        prev->next=temp;
        *cursorref=1;
    }
    else if(*cursorref>2)
    {
        while(count!=(*cursorref-2))
        {
            temp=temp->next;

            count++;
        }
        prev=temp;
        temp=temp->next;
        temp=temp->next;
        prev->next=temp;
        *cursorref=*cursorref-1;
    }

}
void copy(struct node **headref,int x,int y,char clipboard[])
{
    struct node *temp=*headref;
    int count=0;
    int i=0;
    for(count=0;count<=y;count++)
    {


        if(count>=x)
        {
            clipboard[i]=temp->data;
            i++;
        }
         temp=temp->next;
    }
    clipboard[i]='\0';
    printf("\n");

}





int main()
{
    int x=0;
    int *cursor=&x;
    char a='a';
    char b='b';
    char c='c';
    int copyx=0,copyy=1;
    char clipboard[copyy - copyx +1];



    struct node *head;
    head = NULL;


    addatend(&head,a,cursor);
    addatend(&head,b,cursor);
    addatend(&head,c,cursor);
    printlist(head);
    printf("%d",*cursor);
    insert(&head,a,2,cursor);
    printf("\n");
    printlist(head);
    printf("%d",*cursor);
    printf("\n");
    seek(head,1,cursor);
    printf("\n%d",*cursor);
    printf("\n");
    *cursor=3;
    Delete(&head,cursor);
    printlist(head);
    printf("%d",*cursor);

    copy(&head,copyx,copyy,&clipboard);
    printf("%s",clipboard);


    return 0;
}
