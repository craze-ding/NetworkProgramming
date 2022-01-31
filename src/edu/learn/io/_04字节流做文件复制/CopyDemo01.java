package edu.learn.io._04字节流做文件复制;

import java.io.*;

/**
    目标：字节流做文件复制。

    字节流复制的思想：
        字节是计算机中一切文件的组成，所以
        字节流适合做一切文件的复制。
        复制是把源文件的全部字节一字不漏的转移到目标文件，只要文件前后的格式一样，绝对不会有问题。

    需求：
        原文件：C:\Users\leet_\OneDrive\图片\IU\cc9c98848b6064915a335180d395a7fa.jpeg
        目标文件：D:\约吧图片服务器\cc9c98848b6064915a335180d395a7fa.jpeg
    分析步骤：
        （1）创建一个字节输入流管道与源文件接通。
        （2）创建一个字节输出流与目标文件接通。
        （3）创建一个字节数组作为桶
        （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。
        （5）关闭资源！
    小结:
        字节流非常适合做文件数据的复制
 */
public class CopyDemo01 {
    public static void main(String[] args) {
        InputStream is = null ;
        OutputStream os = null ;
        try{
            /** （1）创建一个字节输入流管道与源文件接通。 */
            is = new FileInputStream("C:\\Users\\leet_\\OneDrive\\图片\\IU\\cc9c98848b6064915a335180d395a7fa.jpeg");
            /** （2）创建一个字节输出流与目标文件接通。*/
            os = new FileOutputStream("D:\\约吧图片服务器\\cc9c98848b6064915a335180d395a7fa.jpeg");
            /** （3）创建一个字节数组作为桶*/
            byte[] buffer = new byte[1024];
            /** （4）从字节输入流管道中读取数据，写出到字节输出流管道即可。*/
            int len = 0;
            while((len = is.read(buffer)) != -1){
                // 读取多少就倒出多少
                os.write(buffer, 0 , len);
            }
            System.out.println("复制完成！");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            /**（5）关闭资源！ */
            if(os!=null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is!=null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
