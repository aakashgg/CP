class Node {
    Node[] link;
    boolean flag;
    int endWith;
    int countPrefix;

    public Node() {
        link = new Node[26];
        flag = false;
        endWith = 0;
        countPrefix = 0;
    }
}

public class CustomTrie {
    private Node root;

    public CustomTrie() {
        root = new Node();
    }

    void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.link[index] == null) {
                curr.link[index] = new Node();
            }
            curr = curr.link[index];
            curr.countPrefix += 1;
        }
        curr.flag = true;
        curr.endWith += 1;
    }

    boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.link[index] == null)
                return false;
            curr = curr.link[index];

        }
        // At last check if last one is true and last guy is not null
        return curr != null && curr.flag;
    }

    int searchCount(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.link[index] == null)
                return 0;
            curr = curr.link[index];

        }
        if (curr.flag)
            return curr.endWith;
        else
            return 0;

    }

    boolean startsWith(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.link[index] == null)
                return false;
            curr = curr.link[index];
        }
        return true;
    }

    int startswithCount(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (curr.link[index] == null)
                return 0;
            curr = curr.link[index];
        }
        return curr.countPrefix;
    }

    void erase(String word) {
        if (search(word)) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int index = ch - 'a';
                curr = curr.link[index];
                curr.countPrefix -= 1;
            }
            curr.endWith -= 1;
            if (curr.endWith == 0)
                removeNode(word);
            curr.flag = false;
        }
    }

    // remove is hard
    void removeNode(String word) {

    }
}