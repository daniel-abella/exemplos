function ehBranco(s)
{
    for (var i = 0; i < s.length; i++) {
	var c = s.charAt(i);
	if ((c != ' ') && (c != '\n') && (c != '\t')) return false;
    }
    return true;
}

function verifica(f)
{
    var msg;
    var empty_fields = "";
    var erros = "";
    for (var i = 0; i < f.length; i++) {
	var e = f.elements[i];
	if ((e.type == "text") || (e.type == "textarea")) {
	    if (!e.opcional && ((e.value == null) || (e.value == "") || ehBranco(e.value))) {
		empty_fields += "\n        " + e.name;
		continue;
	    }
	    if (e.numerico && ((e.min != null) || (e.max != null))) {
		var v = parseFloat(e.value);
		if (isNaN(v) || 
		    ((e.min != null) && (v < e.min)) ||
		    ((e.max != null) && (v > e.max))) {
		    erros += "- 0 campo " + e.name + " deve ser um número";
		    if (e.min != null) erros += " maior que " + e.min;
		    if (e.max != null && e.min != null)
			erros += " e menor que " + e.max;
		    else 
			if (e.max != null) erros += " que é menor que " + e.max;
		    erros += ".\n";
		}
	    }
	}
    }
    if (!empty_fields && !erros) return true;
    msg = "0 formulário não foi submetido.\n";
    if (empty_fields) {
	msg += "São campos vazios:" +  empty_fields + "\n";
	if (erros) msg += "\n";
    }
    msg += erros;
    alert(msg);
    return false;
}