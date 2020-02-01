package code.code_201_250.code_207;

import java.util.*;

public class CourseSchedule {

    /*
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
     * which is expressed as a pair: [0,1]
     *
     * Given the total number of courses and a list of prerequisite pairs,
     * is it possible for you to finish all courses?
     *
     * Example 1:
     *
     * Input: 2, [[1,0]]
     * Output: true
     *
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     *
     * Example 2:
     *
     * Input: 2, [[1,0],[0,1]]
     *
     * Output: false
     *
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should
     * also have finished course 1. So it is impossible.
     *
     * Note:
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
     * Read more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     *
     * 算法：
     * 等价于判断有向图是否成环了
     * map存储 课程A->课程B 的映射
     * 1 结束 return true
     * 2 相撞 return false
     *
     * 存在一门课程对应多个课程作为前置条件的情况
     * 需要一个一个进行判断
     * 使用map进行缓存当前课程是否可以完成 减少重复计算
     *
     * todo 成环的判断方法再思考   有机会看看图的邻接矩阵
     * */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 1 || prerequisites == null || prerequisites.length == 0 || prerequisites[0].length != 2) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> integers = map.get(prerequisites[i][0]);
            if (integers == null) {
                integers = new ArrayList<>();
                map.put(prerequisites[i][0], integers);
            }
            integers.add(prerequisites[i][1]);
        }
        Set<Integer> finish = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!doCanFinish(finish, map, prerequisites[i][0], visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean doCanFinish(Set<Integer> finish, Map<Integer, List<Integer>> map, int course, Set<Integer> visited) {
        if (finish.contains(course) || !map.containsKey(course)) {
            return true;
        }
        if (visited.contains(course)) {
            return false;
        }
        visited.add(course);
        List<Integer> list = map.get(course);
        for (Integer cur : list) {
            if (finish.contains(cur)) {
                continue;
            }
            if (doCanFinish(finish, map, cur, visited)) {
                finish.add(cur);
                continue;
            }
            return false;
        }
        finish.add(course);
        visited.remove(course);
        return true;
    }

    public static void main(String[] args) {
        boolean b = new CourseSchedule().canFinish(2, new int[][]{{1, 0}, {0, 1}});
        System.out.println(b);
    }
}
