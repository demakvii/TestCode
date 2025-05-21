package com.mak;

import java.util.concurrent.Executors;

public class DistributedCounter {

    public static void main(String[] args) {
        var post = new Post("Hello world");

        var executor = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000000 ; i++) {
            executor.submit(() -> {
                var rnd = (int) (Math.random() * 2);
                if (rnd == 0)
                    post.incrementLikes();
                else
                    post.incrementDislikes();
                System.out.println(post);
            });
        }
        executor.shutdown();
        while (!executor.isShutdown()){

        }
        System.out.println("Final post: " + post);
    }


    static class Post {
        private int likes;
        private int dislikes;
        private String name;

        public Post(String name){
            this.name = name;
            this.likes = 0;
            this.dislikes = 0;
        }

        public int getLikes() {
            return likes;
        }

        public synchronized void incrementLikes() {
            this.likes++;
        }

        public int getDislikes() {
            return dislikes;
        }

        public synchronized void incrementDislikes() {
            this.dislikes++;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "name='" + name + '\'' +
                    ",likes=" + likes +
                    ", dislikes=" + dislikes +
                    '}';
        }
    }
}
