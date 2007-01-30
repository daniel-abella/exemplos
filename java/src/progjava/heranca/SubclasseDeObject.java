package progjava.heranca;

public class SubclasseDeObject extends Object {
    public static void main(String[] args) {
        SubclasseDeObject subObject = new SubclasseDeObject();
        Class c = subObject.getClass();
        int i = subObject.hashCode();
        String s = subObject.toString();

        System.out.println(c.getName() + " " + i + " " + s);
    }
}

// N�o h� erro na linha 3, mesmo com a heran�a expl�cita de Object.
// O nome da classe na linha 3 � v�lido.
// M�todo est�tico de uma classe pode criar inst�ncias desta classe (linha 5)