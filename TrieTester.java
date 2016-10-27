import java.util.*;

public class TrieTester
{
	public static void main(String[] args)
	{
		List<String> words =  new ArrayList<String>();
		words.add("tree");
		words.add("trie");
		words.add("assoc");
		words.add("all");
		words.add("also");
		words.add("algo");
		
		Trie trie = new Trie();
		
		Iterator<String> it = words.iterator();
		while(it.hasNext())
		{
			trie.insert(it.next());
		}
		
		System.out.println("Trie contains: " + trie.size() + " elements");
		System.out.println(trie.search("all"));
		
		List<String> res = trie.startsWith("al");
		System.out.println("Words in the trie that start with al are...");
		for(int i = 0; i < res.size(); ++i)
		{
			System.out.println(res.get(i));
		}
		
		trie.delete("all");
		System.out.println("Trie contains: " + trie.size() + " elements");
		List<String> res1 = trie.startsWith("al");
		System.out.println("Words in the trie that start with al are...");
		for(int i = 0; i < res1.size(); ++i)
		{
			System.out.println(res1.get(i));
		}
	}
}