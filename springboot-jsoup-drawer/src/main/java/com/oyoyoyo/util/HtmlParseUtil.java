package com.oyoyoyo.util;

import com.oyoyoyo.entity.Content;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Date:2021/1/24
 * Decription:<网页爬取工具类>
 *
 * @Author:oyoyoyoyoyoyo
 */
public class HtmlParseUtil {
    public static void main(String[] args) throws Exception {
    }

    /**
     * 解析京东商品界面内容
     *
     * @param keyword
     * @return
     * @throws Exception
     */
    public static List<Content> parseJD(String keyword) throws Exception {
        // 获取请求，需要联网，不能获取ajax请求
        String url = "https://search.jd.com/Search?keyword=" + keyword;
        // 返回DOM对象，后续使用DOM或者js代码编写即可
        Document document = Jsoup.parse(new URL(url), 30000);
        Element jdgoodsList = document.getElementById("J_goodsList");
        //    获取所有的li元素
        Elements lis = jdgoodsList.getElementsByTag("li");
        ArrayList<Content> goodsList = new ArrayList<>();
        //    获取元素中的图片，标题，价格等内容
        for (Element el : lis) {
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();
            System.out.println("=======================");
            Content content = new Content();
            content.setPrice(price);
            content.setTitle(title);
            System.out.println("content = " + content);
            goodsList.add(content);
        }
        return goodsList;
    }

    /**
     * 动态获取接口数据
     *
     * @param url https://www.frontendjs.com/api/s_rmd，"https://geo.datav.aliyun.com/areas_v2/bound/510000.json"
     * @return
     */
    public static JSONObject parseAjax(String url) {
        JSONObject bodyJson = null;
        try {
            final Connection.Response execute = Jsoup.connect(url)
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate")
                    .header("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
                    .timeout(10000).ignoreContentType(true).execute();
            bodyJson = new JSONObject(execute.parse().text());
            System.out.println("bodyJson = " + bodyJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bodyJson;

    }
}
