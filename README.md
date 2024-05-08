# Caso_Final_de_los_Finales


https://github.com/ZoeAcero/Caso_Final_de_los_Finales.git




###EJERCICIO 1:


1) La correcta es la opción b

2) La correcta es la opción b

3) La correcta es la opción b

4) La correcta es la opción a

5) La opción correcta es la b




###EJERCICIO 2 (APARTADOS 2, 3, 4, 5):



2) El hash funciona como una especie de armario lleno de cajas. Cada caja tiene una etiqueta única, y cuando necesitas guardar algo, lo pones en la caja que le corresponde según su etiqueta. Así, incluso si tienes muchos datos, siempre sabes dónde buscarlos rápidamente. 
   Por otro lado, un árbol organiza los datos como si fueran ramas de un árbol. Cada dato está en un lugar específico, y puedes ir navegando desde la raíz hasta las hojas para encontrar lo que buscas.

   Entonces, si necesitas encontrar datos de manera rápida y eficiente, especialmente cuando tienes un montón de ellos, un hash es ideal porque te permite ir directamente a donde está guardado cada dato gracias a su etiqueta única. Pero si también necesitas organizar 
   tus datos de una manera ordenada, como si estuvieran dispuestos en un árbol, y además quieres poder añadir y quitar datos fácilmente, entonces un árbol es más conveniente.

  

3) La pila y la cola son dos estructuras de datos que operan bajo diferentes principios: LIFO (Last In, First Out) y FIFO (First In, First Out), respectivamente. Bajo el principio LIFO, el último elemento que se añade a la pila será el primero en ser retirado, mientras 
   que bajo el principio FIFO, el primer elemento que se añade a la cola será el primero en ser retirado.

  Se aconseja emplear la cola cuando se necesite manejar elementos en el mismo orden en que llegaron, como una fila en un supermercado. Por otro lado, la pila es útil cuando se requiere procesar elementos en el orden inverso al que fueron insertados, similar a apilar 
  platos donde el último en ser colocado es el primero en ser retirado.

  Ambas estructuras de datos tienen una complejidad de tiempo de O(1), lo que significa que las operaciones de inserción y eliminación tienen un tiempo constante, sin embargo, en determinadas circunstancias pueden alcanzar una complejidad de O(n) debido a ciertas 
  operaciones o restricciones.



4) El metodo de ordenación de insercción considera que el array se divide en dos partes: la parte ordenada, situada en la izquierda, y la parte desordenada, situada a la derecha.
  continuación explicaré el método sobre el conjunto de datos proporcionado 50 20 84 13 22 16 89 85:
    - Buscamos la primera parte, la cuál se considera la parte inicial ordenada:
          Lista ordenada: 50
    - Tomamos e siguiente elemento de la denominada parte desordenada, en este caso 20, y lo insertamos delante del primer elemento, ya que este es menor:
          Lista ordenada: [ 20 , 50 ]
    - Repetimos este proceso con el resto de elementos, tomando cada elemento de la parte desordenada y colocandolo en la posición idonea en la llamada parte ordenada:
          Lista ordenada: [ 20, 50 , 84 ]
          Lista ordenada: [ 13 , 20 , 50 , 84 ]
          Lista ordenada: [ 13 , 20 , 22 , 50 , 84 ]
          Lista ordenada: [ 13 , 16, 20 , 22 , 50 , 84 ]
          Lista ordenada: [ 13 , 16, 20 , 22 , 50 , 84 , 89 ]
          Lista ordenada: [ 13 , 16, 20 , 22 , 50 , 84 , 85 , 89]



5)  Teniendo en cuenta que tenemos que 
      A < B -> 1024n < 16n^3
  Diviendo ambos lados entre n:
      1024n(/n) < 16n^3(/n) -> 1024 < 16n^2
  Podemos simplificar de la siguiente manera para que sea más sencillo:
      1024(/16) < 16n^2(/16) -> 16n < n^2
  Tomamos la raíz cuadrada y haciendo ese cálculo nos da como resultado lo siguiente:
      8 < n
  Esto significa que los valores de n mayores de 8, la función A llega a ser más eficiente que la B.







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






