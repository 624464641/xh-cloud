package com.xh.common;

import com.xh.common.spring.proxy.CglibProxy;
import com.xh.common.spring.proxy.Hello;
import com.xh.common.spring.proxy.HelloImpl;
import com.xh.common.spring.proxy.InterfaceProxy;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import javax.xml.soap.Node;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * @author xt
 * @date 2020/8/17
 */
public class MyList {


    private Node node;

    int hash;
    char value[];

    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;

            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }
    public MyList(){}
    public MyList(Node node, int hash, char[] value) {
        this.node = node;
        this.hash = hash;
        this.value = value;
    }

    public static void main(String[] args) {
        // F:\my\xh-cloud\common\src\main\java\com\xh\common\MyList.java

        // System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // Hello helloImpl = new HelloImpl();
        // InterfaceProxy interfaceProxy = new InterfaceProxy(helloImpl);
        // Hello hello = interfaceProxy.getProxy();
        // hello.say("dada");

        // CglibProxy cglibProxy = new CglibProxy();
        // Hello hello =  cglibProxy.getProxy(HelloImpl.class);
        // hello.say("123");
        // System.out.println(cglibProxy.getClass().getSimpleName());
        // System.out.println(cglibProxy.getClass().getName());

        // JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();

        try {
            RandomAccessFile file = new RandomAccessFile("F:\\my\\test.txt" , "rw");
            FileChannel fileChannel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            int bytesRead = fileChannel.read(byteBuffer);
            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
                bytesRead = fileChannel.read(byteBuffer);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
