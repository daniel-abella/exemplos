package jfx3;

// Não há 'public static void main...'
// JavaFX é declarativa. Todo o arquivo é lido.

// Tipos são iniciados em maiúsculas.
def constBoolean: Boolean = true;
def constByte: Byte = 127;
def constShort: Short = 32767;
def constInt: Integer = 3000000;
def constLong: Long = 2333;
def constFloat: Float = 3.4;
def constDouble: Double = 3.4;

println("constBoolean: {constBoolean}");
println("constByte: {constByte}");

// Acrescente sentenças para as demais constantes definidas acima.
// ACRESCENTE AQUI!!!!

// Observe que o tipo pode ser inferido, conforme ilustrado abaixo.
def constInt2 = 2;
def constString = "Um teste";

println("constInt2: {constInt2}");
println("constString: {constString}");