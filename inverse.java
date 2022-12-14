import java.io.*;
import java.util.*;
import java.text.*;


public class inverse {

    public static void main(String[] args) throws Exception {
        double[][] x = {{3, 2, 5},
                        {1,4,7},
                        {9,2,5}};

        double[][] inv = INVERSE(x);
        PRINT(MultiplyMatrix(x, inv));
    }

    public static double[][] INVERSE(double[][] z){
        double[][] X = Transfer(z);
        double[][] I = new double[X.length][X[0].length];
        double A, B, C, D;
        for(int i = 0; i < X.length; i++){
            I[i][i] = 1.0;
        }
        for(int i = 1; i < X.length; i++){
            for(int j = 0; j < i; j++){
                A = X[i][j];
                B = X[j][j];
                for(int k = 0; k < X.length; k++){
                    X[i][k] = X[i][k] - (A/B)*X[j][k];
                    I[i][k] = I[i][k] - (A/B)*I[j][k];
                }
            }
        }
        for(int i = 1; i < X.length; i++){
            for(int j = 0; j < i; j++){
                C = X[j][i];
                D = X[i][i];
                
                for(int k = 0; k < X.length; k++){
                    X[j][k] = X[j][k] - (C/D)*X[i][k];
                    I[j][k] = I[j][k] - (C/D)*I[i][k];
                }
            }
        }
        for(int i = 0; i < X.length; i++){
            for(int j = 0; j < X[0].length; j++){
                I[i][j] = I[i][j] / X[i][i];
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


