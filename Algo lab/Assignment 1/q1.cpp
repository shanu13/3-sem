    #include <iostream>
    #include <windows.h>
    #include <cstdlib>
    using namespace std;

    #define dead ' '
    #define alive '#'
    #define rows 10
    #define cols 10

    void display(char** world){
    for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            cout<<world[i][j];
        }
        cout<<"\n";

    }
    }

  void Generation(char **world){
        char **world_before = new char*[rows];
        for(int i=0; i<rows; i++){
            world_before[i] = new char[cols];
        }
        world_before = world;

        for(int i=1; i<rows-1; i++){
            for(int j=1; j<cols-1; j++){

                int alive_count = 0;
                    for(int k=-1; k<=1; k++){
                       for(int p=-1; p<=1; p++){
                          if(world[i+k][j+p] == alive){
                            alive_count++;
                          }
                      }
                  }

            if (world_before[i][j] ==alive && (alive_count == 0 || alive_count == 1))
            {
                  world_before[i][j] = world[i][j];
                      world[i][j] = dead;
            }

             else if(world_before[i][j] == alive && (alive_count == 2 || alive_count == 3))
            {
               world_before[i][j] = world[i][j];
                world[i][j] == alive;
            }
            else if (world_before[i][j] == alive && alive_count > 3)
            {
                world_before[i][j] = world[i][j];
                world[i][j] == dead;
            }

             else if (world_before[i][j] == alive && alive_count ==3)
            {
                world_before[i][j] = world[i][j];
                world[i][j] == alive;
            }
        }

    }
  }

    int main(){
     char **world = new char*[rows];
      for(int i=0; i<rows; i++){
        world[i] = new char[cols];
    }


     for(int i=0 ; i<rows; i++){
        for(int j=0; j<cols; j++){
            world[i][j] = dead;
        }
     }

     // initialization

     while(true){
        system("cls");
        display(world);

        Sleep(4000);

        Generation(world);
     }
    }
