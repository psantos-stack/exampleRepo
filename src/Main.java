/*
CSS143B homework 2, problem 1
by [Pedro Henrique Santos]

Solution explanation:
We stack zeroes in the front of the array and twos in the back. The procedure goes as follows:
Initialize a "head" for the zeroes stack at i = 0 and initialize a "head" for the twos stack
at i = (last index of array). The key is to process ALL 0s and 2s while ignoring 1s.

PSEUDO-CODE:
headOfZeroes <- 0
headOfTwos <- lengthOfArray(data)
IF (x at i = 0),
    THEN (headOfZeroes <- headOfZeroes+1 AND switchValues(x at i, x at headOfZeroes).
i <- "head of zeroes" //we do this to account for cases where (x at i) = (x at headOfZeroes) = 0
IF(x at i = 2 AND headOfTwos >= i)
    //the second part of this conjunction is designed to prevent cases where
    //the program accidentally switches members in the stack with non-stack members
    //(when x at i = 2 AND x at headOfTwos != 2)
    THEN IF(x at headOfTwos = 2)
        THEN headOfTwos <- headOfTwos - 1
             i <- i - 1
             //we want to decrement headOfTwos without decrementing i. If we don't do so, we ignore
             //a potential 2 at position i. So we decrement i here knowing the next iteration
             //will increment i by 1.
        ELSE
            switchValues(x at i, x at headOfTwos)
            headOfTwos <- headOfTwos - 1
            i <- i - 1
            //we do this in case we switch a 2 with a 0. If we don't decrement i by 1 here,
            //we risk not processing that 0, leaving it out of order
 */
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        System.out.println("testColorSort " + (Tests.testColorSort() ? "PASSED" : "FAILED"));
    }
    public static int[] colorSort(int[] dataToSort) {
        // we will use two stacks to solve this problem: one containing zeroes, the other containing twos
        int headOfZeroesStackIndex = 0;
        //head of zeroes stack
        int headOfTwosStackIndex = dataToSort.length-1;
        //head of twos stack
        Swapper swapDevice = new Swapper();
        for(int currentIndex = 0; currentIndex < dataToSort.length; currentIndex++){
            //I have written pseudo-code in the top to explain my logic in detail
            //since there's plenty to explain about this one
            if(dataToSort[currentIndex] == 0){
                swapDevice.set(dataToSort[headOfZeroesStackIndex], dataToSort[currentIndex]);
                dataToSort[headOfZeroesStackIndex] = swapDevice.getItemTwo();
                dataToSort[currentIndex] = swapDevice.getItemOne();
                currentIndex = headOfZeroesStackIndex;
                headOfZeroesStackIndex++;
            }
            if(dataToSort[currentIndex] == 2 && headOfTwosStackIndex >= currentIndex){
                if(dataToSort[headOfTwosStackIndex] == 2){
                    headOfTwosStackIndex--;
                    currentIndex--;
                }
                else{
                    swapDevice.set(dataToSort[currentIndex], dataToSort[headOfTwosStackIndex]);
                    dataToSort[currentIndex] = swapDevice.getItemTwo();
                    dataToSort[headOfTwosStackIndex] = swapDevice.getItemOne();
                    headOfTwosStackIndex--;
                    currentIndex--;
                }
            }
        }
        return dataToSort;
    }
}