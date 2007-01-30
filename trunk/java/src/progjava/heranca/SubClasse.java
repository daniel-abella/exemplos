package progjava.heranca;

public class SubClasse extends SuperClasse {

    public static void fazAlgo(SuperClasse refSuperClasse) {
        refSuperClasse.fazAlgumaCoisa();
    }

    public static void main(String[] args) {
        SubClasse refSubClasse = new SubClasse();
        fazAlgo(refSubClasse);
    }
}