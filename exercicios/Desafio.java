import java.util.Calendar;

public class Desafio {
    public static int diaSemana(int dia, int mes, int ano) {
	if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || ano < 1753)
	    throw new RuntimeException("argumento invalido");

	if (mes == 1 || mes == 2) {
	    mes = mes + 12;
	    ano--;
	}

	int semana = dia + 2*mes + 3*(mes+1)/5 + ano + ano/4 - ano/100 + ano/400;
	return semana % 7;
    }

    public static void main(String[] args) {
	int dia = 1;
	int mes = 0;
	int ano = Integer.parseInt(args[0]);

	Calendar data = Calendar.getInstance();
	data.set(ano,mes,dia);

	while (data.get(Calendar.YEAR) == ano) {
	    dia = data.get(Calendar.DAY_OF_MONTH);
	    mes = data.get(Calendar.MONTH);
	    
	    int oficial = data.get(Calendar.DAY_OF_WEEK); // Sunday (1), Monday (2), ...
	    int algoritmo = diaSemana(dia, mes + 1, ano); // Dom (6), Seg (2), Ter (3),...

	    if ((oficial - 5) % 7 == algoritmo) {
		System.out.println("resultado inconsistente: " + data.getTime());
	    }
	    data.add(Calendar.DAY_OF_MONTH, 1);
	}
    }
}
