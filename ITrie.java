/*
Aim: Implement a trie (prefix tree) with insert, search, and startsWith methods. 
*/

public interface ITrie
{
	/*
		Inserts a word into the trie
	*/
	public void insert(String word);
	
	/*
		Checks if the given word is in the trie.
		Returns true if it exists, false otherwise.
	*/
	public boolean search(String word);
	
	/*
		Checks if the trie contains a word with the given prefix.
		Returns a list of all words in the trie with the given prefix
	*/
	public Iterable<String> startsWith(String prefix);
	
	/*
		Returns the size of the trie
	*/
	public int size();
	
	/*
		Checks if the trie is empty
	*/
	public boolean isEmpty();
	
	/*
		Deletes the word specified by the input param from the trie
	*/
	public void delete(String word);
	
	
}