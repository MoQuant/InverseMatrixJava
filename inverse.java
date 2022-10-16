import java.io.*;
import java.util.*;
import java.text.*;


public class inverse {

    public static void main(String[] args) throws Exception {
        double[][] x = {{3, 2, 5},
                        {1,4,7},
                        {9,2,5}};

        double[][] inv = Inverse(x);

        PRINT(MultiplyMatrix(x, inv));
    }

    public static double[][] Inverse(double[][] K){
        double[][] Z = Transfer(K);
        int m = Z.length, n = Z[0].length;
        double[][] I = new double[m][n];
        double A, B, C, D;

        for(int i = 0; i < m; i++){
            I[i][i] = 1.0;
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < i; j++){
                A = Z[i][j];
                B = Z[j][j];
                for(int k = 0; k < n; k++){
                    Z[i][k] -= (A/B)*Z[j][k];
                    I[i][k] -= (A/B)*I[j][k];
                }
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < i; j++){
                C = Z[j][i];
                D = Z[i][i];
                for(int k = 0; k < n; k++){
                    Z[j][k] -= (C/D)*Z[i][k];
                    I[j][k] -= (C/D)*I[i][k];
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                I[i][j] /= Z[i][i];
            }
        }

        return I;
    }

    public static double[][] Transfer(double[][] matrix){
        int m = matrix.length, n = matrix[0].length;
        double[][] T = new double[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                T[i][j] = matrix[i][j];
            }
        }
        return T;
    }

    public static double[][] MultiplyMatrix(double[][] X, double[][] Y){
        double[][] Z = new double[X.length][Y[0].length];
        for(int i = 0; i < X.length; i++){
          for(int j = 0; j < Y[0].length; j++){
            Z[i][j] = 0.0;
            for(int k = 0; k < X[0].length; k++){
              Z[i][j] += X[i][k] * Y[k][j];
            }
          }
        }
        return Z;
      }

    public static void PRINT(double[][] x){
        int m = x.length, n = x[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(x[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }


}


