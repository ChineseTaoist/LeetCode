
public class NumIslands {
    void walkIsland(char[][] grid, boolean[][] isVisited, int posX, int posY){
        isVisited[posX][posY] = true;
        if (posY - 1 >= 0 && !isVisited[posX][posY - 1] && grid[posX][posY - 1] == '1'){
            walkIsland(grid, isVisited, posX, posY - 1);
        }
        if (posX - 1 >= 0 && !isVisited[posX - 1][posY] && grid[posX - 1][posY] == '1'){
            walkIsland(grid, isVisited, posX - 1, posY);
        }
        if (posY + 1 < grid[0].length && !isVisited[posX][posY + 1] && grid[posX][posY + 1] == '1'){
            walkIsland(grid, isVisited, posX, posY + 1);
        }
        if (posX + 1 < grid.length && !isVisited[posX + 1][posY] && grid[posX + 1][posY] == '1'){
            walkIsland(grid, isVisited, posX + 1, posY);
        }
    }
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        // 初始化默认false
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        int currentX = 0;
        int currentY = 0;
        int numIsland = 0;
        while (true){
            // 当前位置未走过
            if (!isVisited[currentX][currentY]) {
                // 当前位置为陆地
                if (grid[currentX][currentY] == '1') {
                    // 把周围相连的陆地都走一遍
                    walkIsland(grid, isVisited, currentX, currentY);
                    numIsland += 1;
                }
            }
            currentX += 1;
            if (currentX >= grid.length){
                currentX = 0;
                currentY += 1;
            }
            if (currentY >= grid[0].length){
                break;
            }
        }
        return numIsland;
    }

}
