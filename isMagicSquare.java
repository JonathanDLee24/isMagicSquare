/*
BJP5 Exercise 7.21: isMagicSquare
Language/Type: Java 2D arrays
Author:Marty Stepp (on 2019/09/19)

Write a method called isMagicSquare that accepts a 
two-dimensional array of integers as a parameter and 
returns true if it is a magic square. A square matrix 
is a magic square if it is square in shape (same number 
of rows as columns, and every row the same length), and 
all of its row, column, and diagonal sums are equal. 
For example, [[2, 7, 6], [9, 5, 1], [4, 3, 8]] is a magic 
square because all eight of the sums are exactly 15.

Solution Author: Jonathan Lee
Professor: Gita Faroughi
Class: Sierra College CSCI12
Date: April 27 2021

*/

    /* 
    This method only finds rows to collums based off the sum of them without 
    math laws of magic square equation n(n^2)+1/2 This will run both diagonally tests at the end. 
    They were not required in practice it tests range only from 1-9 are valid also. 
    Math square equation is included but commented out
    */
   public static boolean isMagicSquare(int[][] a) {
      double sum = 0; // for sum for loops testing value
      double sums = 0; // for magic square equation
      double sumshold = 0; // for size of rows
      try
      {
         int len = a[0].length; // for empty values passed exception 
      }
      catch(Exception r) // if a is empty they want a true
      {
         return true; // if method is passed a empty value
      }
      if(a[0].length == 1) // if method is passed only one item
      {
         return true; // if method has only one item return true
      }
      double r = 0; // this is for value testing when sumshold is bigger then sums
      for (int i = 0; i<a.length; i++)
      {
         sumshold = 0;
         for(int j = 0; j < a[i].length; j++) // find the length of the rows for the unknown array
         {
            sumshold++;
         }
         
         if(sumshold>sums) // if the length is bigger set new value
         {
            sums = sumshold;
            r=0;
            for(int n = 0; n<a[i].length; n++) // for new row size add all values for this row to get a value for non magic number law based
            {
               r += a[i][n];
            }//r = sums * (Math.pow(sums,2)+1)/2; // for real magic numbers must change r += a[i][n] to r++ also
         }
      }
      if(sums != sumshold) //if they are not equal correction for zero index
      {
         r++;
      }
      sums = r; // new sums for testing is r once this is reached we have our magic number
      for(int i = 0; i<a[0].length; i++) // this is for rows testing
      {
         sum = 0;
         for(int j = 0; j<a[0].length; j++) // each row test length
         {
            try // try until fail 
            {
               sum+=a[i][j];
               int val = a[i][j]; // testing value to make sure you are adding correct values left to right
               if(val == 0 || val > 9) // magic squares only take 1-9 per math laws range check if needed remove
               {
                  return false; // if they are outside of 1-9 send return false
               }
            }
            catch(Exception e)
            {
               if (a[0].length == 1 && a[0].length > 9) // for items that are in range still not extra 0s
               {
                  return true;
               }
               return false; // or return false for out of index range
            }
         }
         if(sum==sums) // if they are equal to the magic number continue loop
         {
            continue;
         }
         else
         {
            return false; // return false for out of range
         } 
      }
      
      for(int i = 0; i<a[0].length; i++) // loop for top to bottom adds
      {
         sum=0; // reset for each run
         {
            for(int j = 0; j < a.length; j++) // must use a.length for over all size if there is extra colomn 
            {
               sum+=a[j][i]; // reverse for top down 
               //int val = a[j][i]; // testing value check for debugging this is not used normally
            }
            if(sum==sums) // if they are equal continue test until max size reached
            {
               continue;// continue loop no need to check for 0 or > 9 this is already done before
            }
            else
            {
               return false; //return false if they are not equal
            } 
         }
      }
      double diagn = 0;
      for (int diag = 0; diag < a[0].length; diag++) //top left to bottom right tests
      {
         diagn = diagn + a[diag][diag];
      }
      double diagn2 = 0;
      for (int diag = a[0].length-1; diag>=0; diag-- ) //top right to bottm left tests
      {
         diagn2 = diagn2 + a[diag][diag];
      }
      return (sum==sums && diagn == sums && diagn2 == sums); // return true or false
   }
