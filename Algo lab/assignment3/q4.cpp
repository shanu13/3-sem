#include<bits/stdc++.h>
    using namespace std;

    struct point {
   int x, y;
};

int cmpX(point p1, point p2) {
   return (p1.x < p2.x);
}

int cmpY(point p1, point p2) {
   return (p1.y < p2.y);
}

float dist(point p1, point p2) {
   return sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
}

float findMinDist(point pts[], int n) {
   float min = 9999;
   for (int i = 0; i < n; ++i)
      for (int j = i+1; j < n; ++j)
         if (dist(pts[i], pts[j]) < min)
            min = dist(pts[i], pts[j]);
   return min;
}

float min(float a, float b) {
   return (a < b)? a : b;
}

float stripClose(point strip[], int size, float d) {
   float min = d;
   for (int i = 0; i < size; ++i)
      for (int j = i+1; j < size && (strip[j].y - strip[i].y) < min; ++j)
         if (dist(strip[i],strip[j]) < min)
            min = dist(strip[i], strip[j]);
   return min;
}

float findClosest(point xSorted[], point ySorted[], int n){
   if (n <= 3)
      return findMinDist(xSorted, n);
   int mid = n/2;

   point midPoint = xSorted[mid];
   point ySortedLeft[mid+1];
   point ySortedRight[n-mid-1];
   int leftIndex = 0, rightIndex = 0;

   for (int i = 0; i < n; i++) {
      if (ySorted[i].x <= midPoint.x)
         ySortedLeft[leftIndex++] = ySorted[i];
      else
         ySortedRight[rightIndex++] = ySorted[i];
   }

   float leftDist = findClosest(xSorted, ySortedLeft, mid);
   float rightDist = findClosest(ySorted + mid, ySortedRight, n-mid);
   float dist = min(leftDist, rightDist);

   point strip[n];
   int j = 0;

   for (int i = 0; i < n; i++)
      if (abs(ySorted[i].x - midPoint.x) <dist) {
         strip[j] = ySorted[i];
         j++;
      }
   return min(dist, stripClose(strip, j, dist));
}

    float closestPair(point pts[], int n) {
   point xSorted[n];
   point ySorted[n];

   for (int i = 0; i < n; i++) {
      xSorted[i] = pts[i];
      ySorted[i] = pts[i];
   }

   sort(xSorted, xSorted+n, cmpX);
   sort(ySorted, ySorted+n, cmpY);
   return findClosest(xSorted, ySorted, n);
}

int main()
{

   cout<<"Enter the number of points"<<endl;
   int n;
   cin>>n;
   point *p = new point[n];
   for(int i=0; i<n; i++){
    cin>>p[i].x>>p[i].y;
   }
   cout<< " minimum distance  " <<closestPair(p, n);
}
