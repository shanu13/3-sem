 #include<bits/stdc++.h>
    using namespace std;

    #define rows 4
    #define cols 4


    void Matrix_Multiplication(int **A, int **B, int **C){

        for(int i = 0; i <rows; ++i){
          for(int j = 0; j <cols ; ++j){
                C[i][j] = 0;
            for( int k = 0; k <cols ; ++k)
            {
                C[i][j] += A[i][k] * B[k][j];
            }
          }
        }

            for(int i=0; i<rows; i++){
              for(int j=0; j<cols; j++){
                    cout<<C[i][j];
              }
            }
    }



   void matrix_sum(int **a,int **b, int **c,int n){
	for (int i = 0; i < n;i++)
	for (int j = 0; j < n; j++){
		c[i][j] = a[i][j] + b[i][j];
	}
}
void  DivideandConquerer(int **a, int **b,int **c,int n){
	if (n == 1){
		c[0][0] = a[0][0] * b[0][0];
	}
	else{
		int **a11 = new int*[(n/2)];
		int **a12 = new int*[(n/2)];
		int **a21 = new int*[(n/2)];
		int **a22 = new int*[(n/2)];

		int **b11 = new int*[(n/2)];
		int **b12 = new int*[(n/2)];
		int **b21 = new int*[(n/2)];
		int **b22 = new int*[(n/2)];

		int **c11 = new int*[(n/2)];
		int **c12 = new int*[(n/2)];
		int **c21 = new int*[(n/2)];
		int **c22 = new int*[(n/2)];

		int **temp1 = new int*[(n/2)];
		int **temp2 = new int*[(n/2)];

		for (int i = 0; i < (n/2); i++){
			a11[i] = new int[(n/2)];
			a12[i] = new int[(n/2)];
			a21[i] = new int[(n/2)];
			a22[i] = new int[(n/2)];

			b11[i] = new int[(n/2)];
			b12[i] = new int[(n/2)];
			b21[i] = new int[(n/2)];
			b22[i] = new int[(n/2)];

			c11[i] = new int[(n/2)];
			c12[i] = new int[(n/2)];
			c21[i] = new int[(n/2)];
			c22[i] = new int[(n/2)];

			temp1[i] = new int[(n/2)];
			temp2[i] = new int[(n/2)];
		}

		for (int i = 0; i < (n/2); i++)
		for (int j = 0; j < (n/2); j++){
			a11[i][j] = a[i][j];
			a12[i][j] = a[i][j + (n/2)];
			a21[i][j] = a[i + (n/2)][j];
			a22[i][j] = a[i + (n/2)][j + (n/2)];

			b11[i][j] = b[i][j];
			b12[i][j] = b[i][j + (n/2)];
			b21[i][j] = b[i + (n/2)][j];
			b22[i][j] = b[i + (n/2)][j + (n/2)];
		}

		DivideandConquerer(a11, b11, temp1, (n/2));
		DivideandConquerer(a12, b21, temp2, (n/2));
		matrix_sum(temp1, temp2, c11, (n/2));

		DivideandConquerer(a11, b12, temp1, (n/2));
		DivideandConquerer(a12, b22, temp2, (n/2));
		matrix_sum(temp1, temp2, c12, (n/2));

		DivideandConquerer(a21, b11, temp1, (n/2));
		DivideandConquerer(a22, b21, temp2, (n/2));
		matrix_sum(temp1, temp2, c21, (n/2));

		DivideandConquerer(a21, b12, temp1, (n/2));
		DivideandConquerer(a22, b22, temp2, (n/2));
		matrix_sum(temp1, temp2, c22, (n/2));


		for (int i = 0; i < n / 2; i++)
			for (int j = 0; j < n / 2; j++){
				c[i][j] = c11[i][j];
				c[i][j + (n / 2)] = c12[i][j];
				c[i + (n / 2)][j] = c21[i][j];
				c[i + (n / 2)][j + (n / 2)] = c22[i][j];
			}
   }
}



void sub(int **a, int **b, int **c, int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            c[i][j] = a[i][j] - b[i][j];
        }



  void Strassen_multiplication( int **a, int **b, int **c, int n) {

    // recursive base case
    if (n == 1) {
        c[0][0] = a0][0] * b[0][0];
        return;
    }
    else {
        int newN= n/ 2;
        int * innerC  = new int[newN];


        int **a11 = new int*[(n/2)];
		int **a12 = new int*[(n/2)];
		int **a21 = new int*[(n/2)];
		int **a22 = new int*[(n/2)];

		int **b11 = new int*[(n/2)];
		int **b12 = new int*[(n/2)];
		int **b21 = new int*[(n/2)];
		int **b22 = new int*[(n/2)];

		int **c11 = new int*[(n/2)];
		int **c12 = new int*[(n/2)];
		int **c21 = new int*[(n/2)];
		int **c22 = new int*[(n/2)];

		int **temp1 = new int*[(n/2)];
		int **temp2 = new int*[(n/2)];

		for (int i = 0; i < (n/2); i++){
			a11[i] = new int[(n/2)];
			a12[i] = new int[(n/2)];
			a21[i] = new int[(n/2)];
			a22[i] = new int[(n/2)];

			b11[i] = new int[(n/2)];
			b12[i] = new int[(n/2)];
			b21[i] = new int[(n/2)];
			b22[i] = new int[(n/2)];

			c11[i] = new int[(n/2)];
			c12[i] = new int[(n/2)];
			c21[i] = new int[(n/2)];
			c22[i] = new int[(n/2)];

			temp1[i] = new int[(n/2)];
			temp2[i] = new int[(n/2)];


        // divide matrices into 4 submatrices
        for (int i = 0; i < newN; i++) {
            for (int j = 0; j < newN; j++) {
                a11[i][j] = a[i][j];
                a12[i][j] = a[i][j + newN];
                a21[i][j] = a[i + newN][j];
                a22[i][j] = a[i + newN][j + newN];

                b11[i][j] = b[i][j];
                b12[i][j] = b[i][j + newN];
                b21[i][j] = b[i + newN][j];
                b22[i][j] = b[i + newN][j + newN];
            }
        }

        // s1 = b12 - b22
        sub(b12, b22, s1, newN);

        // s2 = a11 + a12
        add(a11, a12, s2, newN);

        // s3 = a21 + a22
        add(a21, a22, s3, newN);

        // s4 = b21 - b11
        sub(b21, b11, s4, newN);

        // s5 = a11 + a22
        add(a11, a22, s5, newN);

        // s6 = b11 + b22
        add(b11, b22, s6, newN);

        // s7 = a12 - a22
        sub(a12, a22, s7, newN);

        // s8 = b21 + b22
        add(b21, b22, s8, newN);

        // s9 = a11 - a21
        sub(a11, a21, s9, newN);

        // s10 = b11 + b12
        add(b11, b12, s10, newN);

        // p1 = a11 * s1
        strassenR(a11, s1, p1, newN);

        // p2 = s2 * b22
        strassenR(s2, b22, p2, newN);

        // p3 = s3 * b11
        strassenR(s3, b11, p3, newN);

        // p4 = a22 * s4
        strassenR(a22, s4, p4, newN);

        // p5 = s5 * s6
        strassenR(s5, s6, p5, newN);

        // p6 = s7 * s8
        strassenR(s7, s8, p6, newN);

        // p7 = s9 * s10
        strassenR(s9, s10, p7, newN);

        // c11 = p5 + p4 - p2 + p6
        add(p5, p4, tempMatrixA, newN); // p5 + p4
        add(temp1, p6, tempMatrixB, newN); // (p5 + p4) + p6
        sub(temp2, p2, c11, newN); // (p5 + p4 + p6) - p2

        // c12 = p1 + p2
        add(p1, p2, c12, newN);

        // c21 = p3 + p4
        add(p3, p4, c21, newN);

        // c22 = p5 + p1 - p3 + p7
        add(p5, p1, temp1, newN); // p5 + p1
        sub(temp1, p3, temp2, newN); // (p5 + p1) - p3
        sub(temp2, p7, c22, newN); // (p5 + p1 - p3) - p7

        // group into c
        for (int i = 0; i < newN ; i++) {
            for (int j = 0 ; j < newN ; j++) {
                c[i][j] = c11[i][j];
                c[i][j + newN] = c12[i][j];
                c[i + newN][j] = c21[i][j];
                c[i + newN][j + newN] = c22[i][j];
            }
        }

        // print s values to console for matrices of n = 2
        if (n == 2) {
            cout << endl;
            cout << "S1: " << s1[0][0] << endl;
            cout << "S2: " << s2[0][0] << endl;
            cout << "S3: " << s3[0][0] << endl;
            cout << "S4: " << s4[0][0] << endl;
            cout << "S5: " << s5[0][0] << endl;
            cout << "S6: " << s6[0][0] << endl;
            cout << "S7: " << s7[0][0] << endl;
            cout << "S8: " << s8[0][0] << endl;
            cout << "S9: " << s9[0][0] << endl;
            cout << "S10: " << s10[0][0] << endl;
        }
    }
}



  }



    int main(){
    int **A,**B,**C;
    A = new int*[rows];
    B = new int*[rows];
    C = new int*[rows];
    for(int i=0; i<rows; i++){
        A[i] = new int[cols];
        B[i] = new int[cols];
        C[i] = new int[cols];
    }
    cout<<"enter elements of matrix A"<<endl;
    for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            cin>>A[i][j];
        }
    }
    cout<<"enter elements of matrix B"<<endl;
    for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
            cin>>B[i][j];
        }
    }

    Matrix_Multiplication(A,B,C);
    DivideandConquerer(A,B,C,rows);
    Strassen_multiplication(A,B,C,rows);
  }
