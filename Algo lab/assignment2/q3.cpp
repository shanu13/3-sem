    #include<bits/stdc++.h>
    using namespace std;



    int max_heightavl(int n, int height){
    static int nodes[height+1];
     nodes[1] = 1;
     nodes[2] = 2;
    if(height==0){
       return 1;
    }
    if(height==1){
        return 2;
    }
    int ans = max_heightavl(n,height-1) +  max_heightavl(n,height-2) +1 ;

    nodes[height] = ans;
    if(pow(2,height-1)<n<=ans)
        return height;
    else
        return height-1;
}


    int main(){
    int n;
    cout<<"Enter the number of nodes n"<<endl;
    cin>>n;

    int minheight = (log(n)/log(2));
    cout<<minheight<<endl;
    int maxheight;
    maxheight = max_heightavl(n,minheight+1);
    cout<<maxheight<<endl;
    }

