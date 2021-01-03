package com.dq.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/substring-with-concatenation-of-all-words/

//Problem to remember: when words have same words twice, we may end up with 2 same index, so need to use Set to store the permutations of words; not List.

public class StringSubstringWithAllWords {
	static Set<String> results = new HashSet<String>();

	static void swap(String[] words, int i, int j) {
		String tmp = words[i];
		words[i] = words[j];
		words[j] = tmp;
	}

	static void allCombinations(String[] words, int start, int end) {
		int N = words.length;
		if (start == end) {
			String s = words[0];
			for (int i = 1; i < N; i++)
				s += words[i];
			System.out.println(s);
			results.add(s);
			return;
		} else {
			for (int i = start; i <= end; i++) {
				swap(words, start, i);
				allCombinations(words, start + 1, end);
				swap(words, start, i);
			}
		}

	}

	// public List<Integer> findSubstring(String s, String[] words) { }
	//time complexity: O (N * M * L) where N is the string length, M is the words array size and L is the word length
    //space complexity: O(N + M) where N is the string length (worst case all letters will be stored as result) and M is the words array size (hash maps storing all the found words)
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();

        int wordsQty = words.length,
        wordSize = words[0].length(),
        windowLength = wordSize * wordsQty;

        Map<String, Integer> wordsCountMap = new HashMap<>();
        for(String word : words) {
            wordsCountMap.put(word, wordsCountMap.getOrDefault(word, 0) + 1);
        }

        for(int i = 0; i <= s.length() - windowLength; i++) { //char by char, moving from s[0] to length-windowLength
            Map<String, Integer> wordsSeenMap = new HashMap<>();
            windowLoop: {
                for(int j = 0; j < wordsQty; j++) {
                    int start = i + j * wordSize;
                    int end = start + wordSize;
                    String word = s.substring(start, end);

                    if(!wordsCountMap.containsKey(word)) {
                        break windowLoop;
                    } 
                    
                    wordsSeenMap.put(word, wordsSeenMap.getOrDefault(word, 0) + 1);

                    if(wordsSeenMap.get(word) > wordsCountMap.get(word)) {
                        break windowLoop;
                    }
                }
                result.add(i);
            }//end of windowLoop
        }

        return result;
    }

	public static void main(String[] args) {
//		String[] data = { "a", "b", "c" };
//		allCombinations(data, 0, data.length - 1);
//		for (String one : results) {
//			System.out.println(one);
//		}

		// String s = "barfoothefoobarman";
		// String[] words = {"foo","bar"};

		// String s = "barfoofoobarthefoobarman";
		// String[] words = {"bar","foo","the"};

		//String s = "wordgoodgoodgoodbestword";
		//String[] words = { "word", "good", "best", "good" };
		
		//String s="foobarfoobar";
		//String[] words= {"foo","bar"};   //expectred [0,3,6]
		
		String s="abcba";
		String[] words= {"bc","ba"};   //expectred [0,3,6]
		
		//This is the case that permutation of the words will take long time!!!
		//String s="pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
		//String[] words= {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
		

		List<Integer> indexList = new ArrayList<Integer>();
		indexList = findSubstring(s, words);
		/*
		allCombinations(words, 0, words.length - 1);
		System.out.println(results);
		
		List<Integer> indexList = new ArrayList<Integer>();
		for (String one : results) {
			// Note: string may contain multiple copies, so get all of them
			int index = -1;
	        do {		
	        	index++;
				index = s.indexOf(one, index);   //foobarfoobar, 'foo' 'bar'
				if (index != -1)
					indexList.add(index);
			} while(index>=0);

		}
		*/

		System.out.println(indexList);

	}
}
