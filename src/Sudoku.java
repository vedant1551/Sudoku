import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    private static boolean isvalid(String[][] sudoku){
        int i,j;

        for(i=0;i<9;i++){
            for(j=0;j<9;j++){
                if(sudoku[i][j].equals(" ")){
                    continue;
                }
                else if( (Integer.parseInt(sudoku[i][j]) > 9 && Integer.parseInt(sudoku[i][j]) < 1)) {
                    return false;
                }
            }

        }
        for(i=0;i<9;i++){
            Set<String> set = new HashSet<>();
            int blank_count = 0;
            for(j=0;j<9;j++){
                if(sudoku[i][j].equals(" ")){
                    blank_count++;
                }
                else{
                    set.add(sudoku[i][j]);
                }

            }
            if(set.size()+blank_count != 9){
                 return false;
            }
        }


        for(i=0;i<9;i++){
            Set<String> set = new HashSet<>();
            int blank_count = 0;
            for(j=0;j<9;j++){
                if(sudoku[j][i].equals(" ")){
                    blank_count++;
                }
                else{
                    set.add(sudoku[j][i]);
                }

            }
            if(set.size()+ blank_count != 9){
                System.out.println("2");
                return false;
            }

        }

        //cell
        int size_sudoku = 9;

        for(i=0;i<size_sudoku;i+=3){
            for(j=0;j<size_sudoku;j+=3){
                int cell_row,cell_col;
                Set<String> set = new HashSet<>();
                int blank_count = 0;

                for(cell_row=0;cell_row<3;cell_row++){
                    for(cell_col=0;cell_col<3;cell_col++){
                        if(sudoku[i+cell_row][j+cell_col].equals(" ")){
                            blank_count++;
                        }
                        else{
                            set.add(sudoku[i+cell_row][j+cell_col]);
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
*/
        String sudoku[][]={
                {"5","3"," "," ","7"," "," "," "," "},
                {"6"," "," ","1","9","5"," "," "," "},
                {" ","9","8"," "," "," "," ","6"," "},
                {"8"," "," "," ","6"," "," "," ","3"},
                {"4"," "," ","8"," ","3"," "," ","1"},
                {"7"," "," "," ","2"," "," "," ","6"},
                {" ","6"," "," "," "," ","2","8"," "},
                {" "," "," ","4","1","9"," "," ","5"},
                {" "," "," "," ","8"," "," ","7","9"}

        };
        if(isvalid(sudoku)){
            System.out.println("Sudoku is Valid!");
        }
        else{
            System.out.println("Sudoku is not valid!");
        }

    }
}
