/*
 * @lc app=leetcode id=787 lang=java
 *
 * [787] Cheapest Flights Within K Stops
 */

// @lc code=start
class Solution {
    int[][] memo;
    Map<Integer, List<int[]>> graph;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Dynamic Programming
        // 自顶向下 记忆化递归
        // 创建一个in degree的 adjacency list
        graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int cur = flight[1];
            int cost = flight[2];
            if (graph.containsKey(cur)) {
                List<int[]> list = graph.get(cur);
                list.add(new int[]{from, cost});
                graph.put(cur, list);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{from, cost});
                graph.put(cur, list);
            }
        }

        // 记忆化递归
        // 某个节点同时指向两个其他节点，
        // 那么这两个节点就有相同的一个入度节点，就会产生重复的递归计算。
        memo = new int[n][k + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }

        return dp(src, dst, 0, k);
    }

    
    // 从起点 src 出发，经停stop个中转点 到达节点 cur 的最小路径权重为 dp(cur, stop)。
    int dp(int src, int cur, int stop, int k) {
        // 计算距离
        // base case
        if (src == cur) {
            return 0;
        }
        if (stop > k) {
            return -1;
        }
        // 查表解决重复子问题
        // 如果memo[cur][stop]不是初始值 直接调用结果
        if (memo[cur][stop] != -1) {
            return memo[cur][stop];
        }

        // 记录当前最优结果
        int res = Integer.MAX_VALUE;

        // 拿到当前节点的所有in degree
        if (graph.containsKey(cur)) {
            List<int[]> list = graph.get(cur);
            for (int[] v : list) {
                int from = v[0];
                int cost = v[1];

                int prevRes = dp(src, from, stop + 1, k);
                // 跳过无解的情况
                // 要不是 无in degree
                // 要不就是 步数超过k 无法从src到达此点
                if (prevRes == -1) {
                    continue;
                }
                res = Math.min(prevRes + cost, res);
            }
        }
        // 记录结果存入memo
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        memo[cur][stop] = res;
        return res;

        // BFS + Priority Queue (Dijkstra)
        // 创建 adjacency list
        // 根据out degree 创建的adjacency list
        // Map<Integer, List<int[]>> graph = new HashMap<>();
        // for (int[] flight : flights) {
        //     if (graph.containsKey(flight[0])) {
        //         List<int[]> list = graph.get(flight[0]);
        //         list.add(new int[]{flight[1], flight[2]});
        //         graph.put(flight[0], list);
        //     } else {
        //         List<int[]> list = new ArrayList<>();
        //         list.add(new int[]{flight[1], flight[2]});
        //         graph.put(flight[0], list);
        //     }
        // }

        // int ans = Integer.MAX_VALUE;
        // PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // queue.add(new int[]{src, 0, 0});

        // // 需要一个数组来记录到达每个点的最小花费
        // int[] distTo = new int[n];
        // Arrays.fill(distTo, Integer.MAX_VALUE);
        // distTo[src] = 0;
        // // 需要一个数组来记录到达每个点点最小步数
        // int[] nodeNumTo = new int[n];
        // Arrays.fill(nodeNumTo, Integer.MAX_VALUE);
        // nodeNumTo[src] = 0;

        // while (!queue.isEmpty()) {

        //     int[] curNode = queue.poll();
        //     int curCity = curNode[0];
        //     int cost = curNode[1];
        //     int stop = curNode[2];

        //     // 优先队列队首总是距离最短的点
        //     if (curCity == dst) {
        //         return cost;
        //     }

        //     // 如果到达当前节点换乘数大于stop数量k
        //     // 就不再继续搜索该节点的neigbour了
        //     if (stop > k) {
        //         continue;
        //     }

        //     // 搜索该节点的neighbor
        //     List<int[]> neighbors = graph.getOrDefault(curCity, new ArrayList<int[]>());
        //     for (int[] neighbor : neighbors) {
        //         int nextNodeID = neighbor[0];
        //         int costToNextNode = cost + neighbor[1];
        //         int stopToNextNode = stop + 1;

        //         // 更新最小距离
        //         if (distTo[nextNodeID] > costToNextNode) {
        //             distTo[nextNodeID] = costToNextNode;
        //             nodeNumTo[nextNodeID] = stopToNextNode;
        //         }

        //         // 剪枝
        //         // 如果中转次数更多，花费还更大，那必然不会是最短路径!
        //         if (costToNextNode > distTo[nextNodeID] && stopToNextNode > nodeNumTo[nextNodeID]) {
        //             continue;
        //         }
        //         queue.add(new int[]{neighbor[0], cost + neighbor[1], stop + 1});
        //     }
                
        // }
        
        // if (ans == Integer.MAX_VALUE){
        //     return -1;
        // }
        // return ans;
    }
}


// @lc code=end

