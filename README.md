# Caso_Final_de_los_Finales


https://github.com/ZoeAcero/Caso_Final_de_los_Finales.git




###EJERCICIO 1:


1) La correcta es la opción b

2) La correcta es la opción b

3) La correcta es la opción b

4) La correcta es la opción a

5) La opción correcta es la b



###EJERCICIO 3:


a) El código si se ejecutaría pero no imprimiría nada, pasa que el código se atasca en un ciclo que nunca termina porque el segundo número que le pasamos, llamado b, siempre es negativo y nunca llega a ser cero. Por eso, el código sigue llamando a la función recursiva con b disminuyendo en uno, pero como b es negativo, disminuirlo en uno lo hace aún más negativo, no lo acerca a cero. Y como la función recursiva solo se detiene cuando b es cero, nunca deja de llamarse a sí misma.

   Por lo que para solucionar este error habría que añadir una condición de terminación adicional para el caso en el que b sea negativo, quedaría así:  [if (b == 0 || b < 0)]
   Y ahora la consola imprimiría el número 1.



b) Este código está tratando de calcular el resultado de elevar a a la potencia b utilizando recursión. Se está utilizando la recursividad de cola, donde la llamada recursiva es la última operación antes de que la función devuelva un valor.

   En el caso base, si b es igual a cero o negativo, la función devuelve 1, lo que corresponde a cualquier número elevado a la potencia 0 (que es 1 según las reglas de la aritmética). Si a es igual a cero, la función devuelve 0, ya que cualquier número elevado a la 
   potencia 0 es 1 excepto el 0.

   En el caso recursivo, si b es positivo, la función realiza una llamada recursiva disminuyendo gradualmente el valor de b hasta que alcance cero o un número negativo. En cada llamada recursiva, se multiplica a por el resultado de la llamada recursiva con b 
   decrementado en 1.




###EJERCICIO 4 (SEGUNDA PREGUNTA DESPÉS DEL CÓDIGO):



b) El tipo de recursividad que se está empleando en este código es la recursividad de cola, también conocida como recursión de cola. Esto se debe a que la llamada recursiva (en la línea return n % 10 + sumOfDigits(n / 10)) es la última operación realizada en la función antes de devolver un valor.

  La función sumOfDigits recorre los dígitos del número n y suma cada uno de ellos. La cantidad de llamadas recursivas que realiza está determinada por el número de dígitos en n. Por lo tanto, la complejidad computacional de este algoritmo es lineal en función del 
  número de dígitos de n, lo que se denota como O(d), donde "d" es la cantidad de dígitos de n. Esto significa que la complejidad crece de manera proporcional al número de dígitos de n.






