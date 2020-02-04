package code.code_201_250.code_210;

import java.util.*;

public class CourseScheduleII {

    /*
    * todo bug free
    * */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return new int[0];
        }
        int[] res = new int[numCourses];
        // 没有前置条件的处理
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        // 建立有向图
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            List<Integer> list = cache.get(prerequisites[i][0]);
            if (list == null) {
                list = new ArrayList<>();
                cache.put(prerequisites[i][0], list);
            }
            list.add(prerequisites[i][1]);
        }
        // 缓存已经学过的课程
        Set<Integer> finishedCourse = new HashSet<>();
        Set<Integer> circleCourse = new HashSet<>();
        // 一个一个课程进行处理
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(cache, finishedCourse, res, i, circleCourse)) {
                return new int[0];
            }
        }
        return res;
    }

    private boolean dfs(Map<Integer, List<Integer>> cache, Set<Integer> finishedCourse, int[] res, int cur, Set<Integer> curCourse) {
        // 已处理过直接结束
        if (finishedCourse.contains(cur)) {
            return true;
        }
        // 成环直接返回false
        if (curCourse.contains(cur)) {
            return false;
        }
        List<Integer> list = cache.get(cur);
        if (list != null) {
            curCourse.add(cur);
            // 处理当前课程的所有前置课程
            for (Integer prev : list) {
                if (!dfs(cache, finishedCourse, res, prev, curCourse)) {
                    return false;
                }
            }
            curCourse.remove(cur);
        }
        // 前置课程皆处理完成且可完成 则本课程可完成  加入到结果中 并返回true
        res[finishedCourse.size()] = cur;
        finishedCourse.add(cur);
        return true;
    }

    public static void main(String[] args) {
        int[] order = new CourseScheduleII().findOrder(3, new int[][]{{1, 0}, {2, 1}});
        System.out.println(order);
    }

}
