package code.code_51_100.code_0070;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath {

    /*
     * Given an absolute path for a file (Unix-style), simplify it.
     * Or in other words, convert it to the canonical path.
     * In a UNIX-style file system, a period . refers to the current directory.
     * '.' 表示 当前路径
     * Furthermore, a double period .. moves the directory up a level. For more information,
     * ".."则 转入上层 文件夹路径
     * see: Absolute path vs relative path in Linux/Unix
     *
     * Note that the returned canonical path must always begin with a slash /,
     * 路径 必然以 '/' 开始
     * and there must be only a single slash / between two directory names.
     * 在两个文件夹名字之间 只可以存在一个 '/'
     * The last directory name (if it exists) must not end with a trailing /.
     * 最后一个文件夹名字后 不可再跟一个 '/'
     * Also, the canonical path must be the shortest string representing the absolute path.
     * 路径必须简化为 最短的全路径
     *
     * Example 1:
     * Input: "/home/"
     * Output: "/home"
     * Explanation: Note that there is no trailing slash after the last directory name.
     *
     * 关键点： 去除尾部多余的 '/'
     *
     * Example 2:
     * Input: "/../"
     * Output: "/"
     * Explanation: Going one level up from the root directory is a no-op, as the root level is the highest level you can go.
     *
     * 无上层路径了  转为 '/' 也就是最上层路径
     *
     * Example 3:
     * Input: "/home//foo/"
     * Output: "/home/foo"
     * Explanation: In the canonical path, multiple consecutive slashes are replaced by a single one.
     *
     * 关键点： 两个文件夹名字 之间 仅可有一个'/' 去除尾巴处的 '/'
     *
     * Example 4:
     * Input: "/a/./b/../../c/"
     * Output: "/c"
     *
     * 关键点： ".." 使 上层文件夹路径出栈  去除尾巴处的 '/'
     *
     * Example 5:
     * Input: "/a/../../b/../c//.//"
     * Output: "/c"
     *
     * Example 6:
     * Input: "/a//b////c/d//././/.."
     * Output: "/a/b/c"
     *
     * 总结：
     * 1 '.' 忽略不处理
     * 2 ".." 路径出栈
     * 3 处理完毕后 拼各个路径间的'/'
     *
     * 没过的用例：
     * "/..." 期望输出 "/..."
     *
     * 思考：
     * /与/ 之间是一个有效地命令
     *
     * */
    public static String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean dictionaryBegin = false;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            // 字典
            if (c != '/') {
                sb.append(c);
                continue;
            }
            // 第一个'/'
            if (!dictionaryBegin) {
                dictionaryBegin = true;
                continue;
            }
            // 第二个'/'
            doEvent(sb, stack);

        }
        if (sb.length() != 0) {
            doEvent(sb, stack);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append('/');
            res.append(stack.pollLast());
        }
        if (res.length() == 0) {
            res.append('/');
        }
        return res.toString();
    }

    private static void addDictionary(StringBuilder cur, Deque<String> stack) {
        stack.push(cur.toString());
        cur.delete(0, cur.length());
    }

    private static void doEvent(StringBuilder sb, Deque<String> stack) {
        if (sb.length()==0){
            return;
        }
        if (sb.toString().equals("..")) {
            if (!stack.isEmpty()) {
                stack.pop();
            }
            sb.delete(0, sb.length());
            return;
        }
        if (sb.toString().equals(".")) {
            sb.delete(0, sb.length());
            return;
        }
        addDictionary(sb, stack);
    }

    public static void main(String[] args) {
        simplifyPath("/../");
    }
}
