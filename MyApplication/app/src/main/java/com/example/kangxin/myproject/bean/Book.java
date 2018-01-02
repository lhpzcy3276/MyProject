package com.example.kangxin.myproject.bean;

import java.util.List;

/**
 * Created by kangxin on 2017/12/25.
 */

public class Book {

    /**
     * count : 1
     * start : 0
     * total : 570
     * books : [{"rating":{"max":10,"numRaters":4454,"average":"8.6","min":0},"subtitle":"张竹坡批评第一奇书","author":["兰陵笑笑生"],"pubdate":"1991","tags":[{"count":2182,"name":"金瓶梅","title":"金瓶梅"},{"count":1244,"name":"古典文学","title":"古典文学"},{"count":912,"name":"兰陵笑笑生","title":"兰陵笑笑生"},{"count":803,"name":"小说","title":"小说"},{"count":688,"name":"中国古典文学","title":"中国古典文学"},{"count":464,"name":"中国文学","title":"中国文学"},{"count":393,"name":"古典","title":"古典"},{"count":377,"name":"中国","title":"中国"}],"origin_title":"（明）兰陵笑笑生","image":"https://img1.doubanio.com/mpic/s10069398.jpg","binding":"","translator":[],"catalog":"\n      ","pages":"","images":{"small":"https://img1.doubanio.com/spic/s10069398.jpg","large":"https://img1.doubanio.com/lpic/s10069398.jpg","medium":"https://img1.doubanio.com/mpic/s10069398.jpg"},"alt":"https://book.douban.com/subject/1456692/","id":"1456692","publisher":"齐鲁出版社","isbn10":"7533300815","isbn13":"9787533300814","title":"金瓶梅","url":"https://api.douban.com/v2/book/1456692","alt_title":"（明）兰陵笑笑生","author_intro":"","summary":"本书由王汝梅与李昭恂、于凤树校点。","series":{"id":"4279","title":"明代四大奇书"},"price":"268.00元"}]
     */

    public int count;
    public int start;
    public int total;
    public List<BooksEntity> books;

    public static class BooksEntity {
        /**
         * rating : {"max":10,"numRaters":4454,"average":"8.6","min":0}
         * subtitle : 张竹坡批评第一奇书
         * author : ["兰陵笑笑生"]
         * pubdate : 1991
         * tags : [{"count":2182,"name":"金瓶梅","title":"金瓶梅"},{"count":1244,"name":"古典文学","title":"古典文学"},{"count":912,"name":"兰陵笑笑生","title":"兰陵笑笑生"},{"count":803,"name":"小说","title":"小说"},{"count":688,"name":"中国古典文学","title":"中国古典文学"},{"count":464,"name":"中国文学","title":"中国文学"},{"count":393,"name":"古典","title":"古典"},{"count":377,"name":"中国","title":"中国"}]
         * origin_title : （明）兰陵笑笑生
         * image : https://img1.doubanio.com/mpic/s10069398.jpg
         * binding :
         * translator : []
         * catalog :

         * pages :
         * images : {"small":"https://img1.doubanio.com/spic/s10069398.jpg","large":"https://img1.doubanio.com/lpic/s10069398.jpg","medium":"https://img1.doubanio.com/mpic/s10069398.jpg"}
         * alt : https://book.douban.com/subject/1456692/
         * id : 1456692
         * publisher : 齐鲁出版社
         * isbn10 : 7533300815
         * isbn13 : 9787533300814
         * title : 金瓶梅
         * url : https://api.douban.com/v2/book/1456692
         * alt_title : （明）兰陵笑笑生
         * author_intro :
         * summary : 本书由王汝梅与李昭恂、于凤树校点。
         * series : {"id":"4279","title":"明代四大奇书"}
         * price : 268.00元
         */

        public RatingEntity rating;
        public String subtitle;
        public String pubdate;
        public String origin_title;
        public String image;
        public String binding;
        public String catalog;
        public String pages;
        public ImagesEntity images;
        public String alt;
        public String id;
        public String publisher;
        public String isbn10;
        public String isbn13;
        public String title;
        public String url;
        public String alt_title;
        public String author_intro;
        public String summary;
        public SeriesEntity series;
        public String price;
        public List<String> author;
        public List<TagsEntity> tags;
        public List<?> translator;

        public static class RatingEntity {
            /**
             * max : 10
             * numRaters : 4454
             * average : 8.6
             * min : 0
             */

            public int max;
            public int numRaters;
            public String average;
            public int min;

            @Override
            public String toString() {
                return "RatingEntity{" +
                        "max=" + max +
                        ", numRaters=" + numRaters +
                        ", average='" + average + '\'' +
                        ", min=" + min +
                        '}';
            }
        }

        public static class ImagesEntity {
            /**
             * small : https://img1.doubanio.com/spic/s10069398.jpg
             * large : https://img1.doubanio.com/lpic/s10069398.jpg
             * medium : https://img1.doubanio.com/mpic/s10069398.jpg
             */

            public String small;
            public String large;
            public String medium;

            @Override
            public String toString() {
                return "ImagesEntity{" +
                        "small='" + small + '\'' +
                        ", large='" + large + '\'' +
                        ", medium='" + medium + '\'' +
                        '}';
            }
        }

        public static class SeriesEntity {
            /**
             * id : 4279
             * title : 明代四大奇书
             */

            public String id;
            public String title;

            @Override
            public String toString() {
                return "SeriesEntity{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }

        public static class TagsEntity {
            /**
             * count : 2182
             * name : 金瓶梅
             * title : 金瓶梅
             */

            public int count;
            public String name;
            public String title;

            @Override
            public String toString() {
                return "TagsEntity{" +
                        "count=" + count +
                        ", name='" + name + '\'' +
                        ", title='" + title + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "BooksEntity{" +
                    "rating=" + rating +
                    ", subtitle='" + subtitle + '\'' +
                    ", pubdate='" + pubdate + '\'' +
                    ", origin_title='" + origin_title + '\'' +
                    ", image='" + image + '\'' +
                    ", binding='" + binding + '\'' +
                    ", catalog='" + catalog + '\'' +
                    ", pages='" + pages + '\'' +
                    ", images=" + images +
                    ", alt='" + alt + '\'' +
                    ", id='" + id + '\'' +
                    ", publisher='" + publisher + '\'' +
                    ", isbn10='" + isbn10 + '\'' +
                    ", isbn13='" + isbn13 + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", alt_title='" + alt_title + '\'' +
                    ", author_intro='" + author_intro + '\'' +
                    ", summary='" + summary + '\'' +
                    ", series=" + series +
                    ", price='" + price + '\'' +
                    ", author=" + author +
                    ", tags=" + tags +
                    ", translator=" + translator +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", books=" + books +
                '}';
    }
}
