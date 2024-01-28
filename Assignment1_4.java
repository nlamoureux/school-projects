package Assignment1;
//Nathan Lamoureux
public class Assignment1_4 {
    public static void main(String[] args) {
        int rows, columns; //Creating the array
        rows = 5;
        columns = 3;
        String[][] table = { //Populating the array
                {" a", " a^2", " a^3"},
                {" 1", " 1", " 1" },
                {" 2", " 4", " 8" },
                {" 3", " 9", " 27" },
                {" 4", " 16", " 64" }
        };
        //Printing the array
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                System.out.print(table[i][j]+" ");



            }
            System.out.println();
        }
    }
}
