package util2;

public class TreePrinter {
    public static void main(String[] args) {
        BCABinaryTree<String> t = new BCABinaryTree<>();
        String[] skrt;
        skrt = " fg fdgfd sgfbgfsbgb gb   h ynbydf byyn byeb yn ny by benyt bnb ng n N RNGRVHRH  h bVH hiK h IHVBF Fb  rbi RHJb hB riSH IRb hrb iH hb ih BRHI F Vcj N  hH HK HKHK hf hgigj GHJLK DJKHF HJV hf  K Kfhjk jhf hf H h    H F h fh fh fhjd df vafh JFH VlFJ LJFH vjhf   Lh h h HF hf lf a a a a a a a a aa a a aaa aaaa aaaaa aaaaaaaa aaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaa a a a a a a a ".split(" ");

        t.insert("Lion");
        t.insert("Frog");
        t.insert("Dog");
        t.insert("Monkey");
        t.insert("Horse");
        t.insert("Fish");
        t.insert("Zebra");
        t.insert("Aphid");
        t.insert("Cow");
        t.insert("Wolf");
        for (String i:
             skrt) {
            t.insert(i);

        }

        t.printTree();

    }
}
