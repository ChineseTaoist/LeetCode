import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return null;
        }
        boolean[][] isVisited = new boolean[matrix.length][matrix[0].length];
        int[] direction = {0, 1};
        int[] pos = {0, 0};
        ArrayList<Integer> list = new ArrayList<>(matrix.length * matrix[0].length);
        while (true){
            if (pos[0] >= 0 && pos[0] < matrix.length
                    && pos[1] >= 0 && pos[1] < matrix[0].length
                    && !isVisited[pos[0]][pos[1]]) {
                list.add(matrix[pos[0]][pos[1]]);
                isVisited[pos[0]][pos[1]] = true;
            }else {
                break;
            }
            int[] newPos = {pos[0] + direction[0], pos[1] + direction[1]};
            if (newPos[0] >= 0 && newPos[0] < matrix.length
                    && newPos[1] >= 0 && newPos[1] < matrix[0].length
                    && !isVisited[newPos[0]][newPos[1]]){
                pos = newPos;
            }else {
                changeDirection(direction);
                pos[0] += direction[0];
                pos[1] += direction[1];
            }
        }
        return list;
    }

    private void changeDirection(int[] direction){
        if (direction[0] == 0){
            direction[0] = direction[1];
            direction[1] = 0;
        }else {
            direction[1] = -(direction[0]);
            direction[0] = 0;

        }
    }

    public static void main(String[]args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder spiralOrder = new SpiralOrder();
        spiralOrder.spiralOrder(matrix);
    }
}
/*
* {0,1}
* {1,0}
* {0,-1}
* {-1,0}
* */