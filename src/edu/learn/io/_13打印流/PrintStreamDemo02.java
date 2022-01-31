package edu.learn.io._13打印流;

import java.io.PrintStream;

/**
    目标：打印流改变输出的流向。重定向。

    System:
        public static void setOut(PrintStream out) :让系统的输出流向打印流。
 */
public class PrintStreamDemo02 {
    public static void main(String[] args) throws Exception {
        //正常输出到控制台！
        System.out.println("==0==");
        PrintStream ps = new PrintStream("src/edu/learn/io/log.txt");
        System.setOut(ps); // 让系统的输出流向打印流。

        //重定向后输出到流关联的目的文件
        System.out.println("==Beyond==");
        System.out.println("==Beyond2==");
        System.out.println("==Beyond3==");
        System.out.println("==Beyond4==");
        System.out.println("==Beyond5==");
    }
}
