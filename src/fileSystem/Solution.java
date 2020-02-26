package fileSystem;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/goowmfn");
        List<String> list = fileSystem.ls("/goowmfn");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        list = fileSystem.ls("/");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        fileSystem.mkdir("/z");

        list = fileSystem.ls("/");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        list = fileSystem.ls("/");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        fileSystem.addContentToFile("/goowmfn/c","shetopcy");

        list = fileSystem.ls("/z");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));


        list = fileSystem.ls("/goowmfn/c");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        list = fileSystem.ls("/goowmfn");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        /*List<String> list = fileSystem.ls("/");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");

        list = fileSystem.ls("/");
        System.out.println("-------------");
        list.forEach(e -> System.out.println(e));

        String contents = fileSystem.readContentFromFile("/a/b/c/d");
        System.out.println("-------------");
        System.out.println(contents);*/
    }
}
