package com.visa.prj.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.visa.prj.entity.Article;

public class ArticleClient {

	public static void main(String[] args) {
		List<Article> articles = new ArrayList<>();
		articles.add(new Article("NoDBA",561,"bliki",Arrays.asList("nosql","people","orm")));
		articles.add(new Article("Infodesk",1145,"bliki",Arrays.asList("nosql","writing")));
		articles.add(new Article("OrmHate",1718,"bliki",Arrays.asList("nosql","orm")));
		articles.add(new Article("ruby",1313,"article",Arrays.asList("ruby")));
		articles.add(new Article("DDD_Aggregate",482,"bliki",Arrays.asList("nosql","ddd")));
		
		printTotalWordCount(articles); // 5219
		printArticlesByType(articles); //{bliki:4, article: 1}
		
		// use flatMap, Function.identity and groupingby and Collectors.counting to solve this
		printTagCount(articles); // nosql: 4, ruby : 1, 
	}

	private static void printTagCount(List<Article> articles) {
		List<List<String>> tags = articles.stream().map(a->a.getTags()).collect(Collectors.toList());
		List<String> listall = new ArrayList<>();
		for (List<String> list : tags) {
			listall.addAll(list);
		}
		Map<String, Long> counts =
			    listall.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		System.out.println(counts);
	}
		

	private static void printArticlesByType(List<Article> articles) {
		Map<String, List<Article>> catMap = articles.stream().collect(Collectors.groupingBy(a->a.getType()));
		Set<String> keys = catMap.keySet();
		for (String s : keys)
			System.out.println(s + ": " + catMap.get(s).size());
	}

	private static void printTotalWordCount(List<Article> articles) {
		List<Integer> words = articles.stream().map(a->a.getWords()).collect(Collectors.toList());
		int sum = 0;
		for (Integer a : words) {
			sum += a;
		}
		System.out.println(sum);
	}

}
