import java.util.*;
import java.io.*;

class Solution {
    int[] visited;
    ArrayList<String> allRoute;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        
        int cnt = 0;
        visited = new int[tickets.length];
        allRoute = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, cnt);
        
        //System.out.println(allRoute);
        Collections.sort(allRoute);
        
        answer = allRoute.get(0).split(" ");
        
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt) {
        
        if (cnt == tickets.length) {
            allRoute.add(route);
            return;
        }
        
        for (int i=0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && visited[i] == 0) {
                visited[i] = 1;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = 0;
            }
        }
    }
}