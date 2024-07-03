package CourseWork;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ReadAccounts{
	String url;
	public ReadAccounts(String URL) {
		url=URL;
	}
	public LinkedList<String> getFirstNames() throws IOException{
		LinkedList<String> fnames=new LinkedList<>();
		BufferedReader reader=new BufferedReader(new FileReader(url));
		String line;
		String[] words;
		while((line=reader.readLine())!=null) {
			words=line.split(",");
			fnames.add(words[0]);
		}
		reader.close();
		return fnames;
	}
	public LinkedList<String> getLastNames() throws IOException{
		LinkedList<String> lnames=new LinkedList<>();
		BufferedReader reader=new BufferedReader(new FileReader(url));
		String line;
		String[] words;
		while((line=reader.readLine())!=null) {
			words=line.split(",");
			lnames.add(words[1]);
		}
		reader.close();
		return lnames;
	}
	public LinkedList<Integer> getAccounts() throws IOException{
		LinkedList<Integer> acc=new LinkedList<>();
		BufferedReader reader=new BufferedReader(new FileReader(url));
		String line;
		String[] words;
		while((line=reader.readLine())!=null) {
			words=line.split(",");
			acc.add(Integer.parseInt(words[2]));
		}
		reader.close();
		return acc;
	}
	public LinkedList<Integer> getBalances() throws IOException{
		LinkedList<Integer> bal=new LinkedList<>();
		BufferedReader reader=new BufferedReader(new FileReader(url));
		String line;
		String[] words;
		while((line=reader.readLine())!=null) {
			words=line.split(",");
			bal.add(Integer.parseInt(words[3]));
		}
		reader.close();
		return bal;
	}
}
