import javax.swing.table.TableColumn
data class Board(val pos: Array<IntArray>)
const val GRID_SIZE = 9



fun isNumberInRow(number : Int, row: Int, board : Array<IntArray>): Boolean{

    for (x in 0 until GRID_SIZE){
        if (board[row][x] == number) return true
    }
    return false
}
fun isNumberInColumn(number: Int, column: Int,board : Array<IntArray>): Boolean{

    for (x in 0 until GRID_SIZE){
        if (board[x][column] == number) return true
    }
    return false
}
fun isNumberInBox(number : Int, column: Int,row: Int,board : Array<IntArray>): Boolean{
    val localRowBox = row - row % 3
    val localColumnBox = column - column % 3

    for (i in localRowBox until localRowBox+3){
        for (j in localColumnBox until localColumnBox+3){
            if (board[i][j] == number) return true
        }
    }
return false
}

fun isValid(number: Int,row: Int,column: Int,board : Array<IntArray>): Boolean{
    return !isNumberInRow(number,row,board) && !isNumberInColumn(number,column,board) && !isNumberInBox(number,column,row,board)

}

fun solveSudoku(board: Array<IntArray>):Boolean{
    for (x in 0 until GRID_SIZE){
        for(j in 0 until GRID_SIZE){
            if (board[x][j] == 0){
                for (n in 1..GRID_SIZE){
                    if (isValid(n,x,j,board)) {
                        board[x][j] = n

                        if (solveSudoku(board)){
                            return true
                        }else{
                            board[x][j] = 0
                        }
                    }
                }
                return false
            }
        }
    }
 return true
}

fun printSudoku(board: Array<IntArray>){
    for (i in 0 until GRID_SIZE){
        if (i % 3 == 0 && i!=0){
            println("-----------")
        }
        for(j in 0 until GRID_SIZE){
            if (j % 3 == 0 && j != 0){
                print("|")
            }
            print(board[i][j])
        }
        println()
    }
    println()


}