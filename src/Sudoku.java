import java.lang.reflect.Array;
import java.util.*;

public class Sudoku {

    private static boolean isvalid(List<List<String>> sudoku){
        int row,col;

        for(row=0;row<9;row++){
            for(col=0;col<9;col++){
                if(sudoku.get(row).get(col).equals(" ")){
                    continue;
                }
                else if( (Integer.parseInt(sudoku.get(row).get(col)) > 9 && Integer.parseInt(sudoku.get(row).get(col)) < 1)) {
                    return false;
                }
            }

        }
        for(row=0;row<9;row++){
            Set<String> set = new HashSet<>();
            int blank_count = 0;
            for(col=0;col<9;col++){
                if(sudoku.get(row).get(col).equals(" ")){
                    blank_count++;
                }
                else{
                    set.add(sudoku.get(row).get(col));
                }

            }
            if(set.size()+blank_count != 9){
                 return false;
            }
        }


        for(row=0;row<9;row++){
            Set<String> set = new HashSet<>();
            int blank_count = 0;
            for(col=0;col<9;col++){
                if(sudoku.get(col).get(row).equals(" ")){
                    blank_count++;
                }
                else{
                    set.add(sudoku.get(col).get(row));
                }

            }
            if(set.size()+ blank_count != 9){
                System.out.println("2");
                return false;
            }

        }

        //cell
        int size_sudoku = 9;

        for(row=0;row<size_sudoku;row+=3){
            for(col=0;col<size_sudoku;col+=3){
                int cell_row,cell_col;
                Set<String> set = new HashSet<>();
                int blank_count = 0;

                for(cell_row=0;cell_row<3;cell_row++){
                    for(cell_col=0;cell_col<3;cell_col++){
                        if(sudoku.get(row+cell_row).get(col+cell_col).equals(" ")){
                            blank_count++;
                        }
                        else{
                            set.add(sudoku.get(row+cell_row).get(col+cell_col));
                        }

                    }
                }
                if(set.size()+ blank_count != 9){
                    return false;
                }

            }

        }
        return true;
    }


    public static void main(String[] args) {

/*
        String sudoku[][]={
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"},
                {"1","2","3","4","5","6","7","8","9"}

        };

         String sudoku[][]={
                {"5","3"," "," ","7"," "," "," "," "},
                {"6"," "," ","1","9","5"," "," "," "},
                {" ","9","8"," "," "," "," ","6"," "},
                {"8"," "," "," ","6"," "," "," ","3"},
                {"4"," "," ","8"," ","3"," "," ","1"},
                {"7"," "," "," ","2"," "," "," ","6"},
                {" ","6"," "," "," "," "," ","8"," "},
                {" "," "," ","4","1","9"," "," ","5"},
                {" "," "," "," ","8"," "," ","7","9"}

        };

*/
        
        
        Scanner s = new Scanner(System.in);
        List<List<String>> sudoku = new ArrayList<>();
        System.out.println("Enter 9*9 sudoku :: ");
        /* input
53  7    
6  195   
 98    6 
8   6   3
4  8 3  1
7   2   6
 6     8 
   419  5
    8  79
    
*/
            for (int i=0;i<9;i++){
            String temp = s.nextLine();

            List<String> row = Arrays.asList(temp.split(""));
            sudoku.add(row);
        }
           if(isvalid(sudoku)){
            System.out.println("Sudoku is Valid!");
        }
        else{
            System.out.println("Sudoku is not valid!");
        }

    }
}
