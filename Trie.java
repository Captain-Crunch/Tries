import java.util.*;

public class Trie implements ITrie
{
	private static final int N = 128;
	
	private Node root; // Root of the trie
	private int n; // Number of keys in trie
	private static int valCtr;
	
	public Trie()
	{
		valCtr = 0;
	}
	
	private void incrCtr()
	{
		++valCtr;
	}
	
	private int getCtr()
	{
		return valCtr;
	}
	
	public void insert(String word)
	{
		root = insert(root, word, getCtr(), 0);
		incrCtr();
	}
	
	private Node insert(Node node, String word, int val, int d)
	{
		if(node == null)
		{
			node = new Node();
		}
		if(d == word.length()) // Reached EOW!
		{
			if(node.val == null)
			{
				++n;
			}
			node.val = val;
			return node;
		}
		char ch = word.charAt(d);
		node.next[ch] = insert(node.next[ch], word, val, d+1);
		return node;
	}
	
	public int size()
	{
		return n;
	}
	
	public boolean isEmpty()
	{
		return this.size() == 0;
	}
	
	private Node get(Node node, String word, int d)
	{
		if(node == null)
		{
			return null;
		}
		if(d == word.length())
		{
			return node;
		}
		char ch = word.charAt(d);
		return get(node.next[ch], word, d+1);
	}
	
	private void populateResult(Node node, StringBuilder prefix, List<String> result)
	{
		if(node == null)
			return;
		
		if(node.val != null)
			result.add(prefix.toString());
		
		for(char ch = 0; ch < N; ++ch)
		{
			prefix.append(ch);
			populateResult(node.next[ch], prefix, result);
			prefix.deleteCharAt(prefix.length()-1);
		}
	}
	
	public List<String> startsWith(String prefix)
	{
		List<String> result = new ArrayList<String>();
		Node node = get(root, prefix, 0);
		populateResult(node, new StringBuilder(prefix), result);
		return result;
	}
	
	private boolean search(Node node, StringBuilder prefix, String word)
	{
		if(node == null)
			return false;
		
		int d = prefix.length();
		if(d == word.length())
		{
			if(node.val != null)
			{
				return true;
			}
		}
		char ch = word.charAt(d);
		prefix.append(ch);
		return search(node.next[ch], prefix, word);
	}
	
	public boolean search(String word)
	{
		return search(root, new StringBuilder(), word);
	}
	
	private Node delete(Node node, String key, int d)
	{
		if(node == null)
			return null;
		
		if(d == key.length())
		{
			if(node.val != null)
			{
				n--;
			}
			node.val = null;
		}
		else
		{
			char ch = key.charAt(d);
			node.next[ch] = delete(node.next[ch], key, d+1);
		}
		
		if(node.val != null)
			return node;
		
		for(int c = 0; c < N; ++c)
		{
			if(node.next[c] != null)
				return node;
		}
		return null;
	}
	
	public void delete(String key)
	{
		root = delete(root, key, 0);
	}

}

class Node
{
	private static final int N = 128; // ASCII chars
	
	Integer val;
	Node[] next = new Node[N];
}