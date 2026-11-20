# INVESTIGACIÓN DEL ALGORITMO QUICK SORT

## 1. Identificación del algoritmo

El algoritmo seleccionado para la variante V2 del proyecto es QuickSort, un método de ordenamiento basado en la estrategia de dividir el arreglo. Su finalidad es organizar los elementos de un arreglo de números enteros en orden ascendente o descendente. 

La implementación se encuentra en el archivo `src/MetodosOrd.java`, dentro de la clase `MetodosOrd`.

Los métodos utilizados son:

- `sortQuick(int[] arreglo)`: método público que inicia el proceso de ordenamiento.
- `quickSort(int[] arreglo, int inicio, int fin)`: método privado que realiza las divisiones y continúa el ordenamiento.

La implementación utiliza un pivote ubicado en la posición central del segmento que se está procesando y dos índices para realizar los intercambios.

## 2. Funcionamiento paso a paso

El proceso comienza cuando se invoca el método `sortQuick()`, que recibe un arreglo de tipo `int[]`.

Primero se comprueba que el arreglo no sea nulo. Si recibe un valor `null`, se lanza una excepción `IllegalArgumentException`.

Después se llama al método privado `quickSort()`, enviando el arreglo y los límites iniciales: desde el índice cero hasta la última posición.

El método `quickSort()` utiliza un ciclo `while` que continúa mientras el índice inicial sea menor que el índice final.

En cada iteración se realizan las siguientes operaciones:

1. Se inicializan los índices izquierdo y derecho.
2. Se selecciona el elemento central como pivote.
3. El índice izquierdo avanza mientras encuentre elementos menores que el pivote.
4. El índice derecho retrocede mientras encuentre elementos mayores que el pivote.
5. Cuando los índices no se han cruzado, se intercambian los elementos encontrados.
6. Los índices se actualizan para continuar con la partición.
7. Se ordena recursivamente la partición más pequeña y se continúa iterativamente con la más grande.

El proceso termina cuando los segmentos restantes tienen cero o un elemento.

## 3. Selección del pivote y proceso de partición

La selección del pivote se realiza mediante la expresión:

`int pivote = arreglo[inicio + (fin - inicio) / 2];`

Esta operación selecciona el elemento ubicado en la posición central del segmento actual.

La implementación utiliza dos índices:

- `izquierda`: recorre el arreglo desde el límite inicial hacia la derecha.
- `derecha`: recorre el arreglo desde el límite final hacia la izquierda.

El índice izquierdo avanza mientras encuentre valores menores que el pivote. Por otro lado, el índice derecho retrocede mientras encuentre valores mayores que el pivote.

Cuando ambos índices todavía no se han cruzado, se intercambian los elementos correspondientes. Después, el índice izquierdo aumenta y el derecho disminuye.

Este procedimiento permite colocar los valores en posiciones que favorecen el orden ascendente.

Los elementos repetidos también participan en los intercambios, ya que las condiciones de comparación utilizan los operadores menor que y mayor que. Cuando los valores son iguales al pivote, no se omiten: pueden ser intercambiados y los índices avanzan.

Una característica particular de esta implementación es que realiza una llamada recursiva para la partición más pequeña y continúa con la partición más grande mediante el ciclo `while`.

## 4. Traza manual del algoritmo

Arreglo inicial:

`[7, 2, 7, 0, 4, 2]`

**Primera partición**

- Inicio: 0.
- Fin: 5.
- Pivote: 7.
- Se intercambian los elementos de las posiciones 0 y 5.
- Después se intercambian los elementos de las posiciones 2 y 4.

Resultado:

`[2, 2, 4, 0, 7, 7]`

**Segunda partición**

Se procesa el segmento comprendido entre los índices 0 y 3.

- Pivote: 2.
- Se intercambian los elementos de las posiciones 0 y 3.
- Los índices continúan avanzando hasta cruzarse.

Resultado:

`[0, 2, 4, 2, 7, 7]`

**Tercera partición**

Se procesa el segmento comprendido entre los índices 2 y 3.

- Pivote: 4.
- Se intercambian los elementos de las posiciones 2 y 3.

Resultado final:

`[0, 2, 2, 4, 7, 7]`

El arreglo queda ordenado de menor a mayor y conserva todos los elementos, incluidas las repeticiones.

## 5. Análisis de complejidad

El rendimiento de QuickSort depende de cómo se distribuyen las particiones después de seleccionar el pivote.

| Caso | Complejidad temporal | Descripción |
|---|---|---|
| Mejor | O(n log n) | Las particiones tienen tamaños equilibrados. |
| Promedio | O(n log n) | Se consideran particiones suficientemente equilibradas en promedio. |
| Peor | O(n²) | Las particiones quedan muy desequilibradas repetidamente. |

**Complejidad espacial**

La implementación no utiliza un arreglo auxiliar para almacenar los elementos ordenados. Los intercambios se realizan directamente sobre el arreglo original.

El espacio adicional se utiliza principalmente en la pila de llamadas recursivas.

Una característica de esta implementación es que procesa recursivamente la partición más pequeña y continúa iterativamente con la más grande. Esta estrategia limita la profundidad de la recursividad a O(log n) para la implementación descrita.

## 6. Caso desfavorable de la implementación

En QuickSort, el peor caso temporal se produce cuando las particiones resultan muy desequilibradas de forma repetida. Esto puede provocar que el algoritmo realice una cantidad elevada de comparaciones.

En esta implementación el pivote se selecciona utilizando la posición central del segmento, por lo que el comportamiento desfavorable depende de los valores presentes en esa posición y de cómo se desarrollen las particiones.

## 7. Relación con los resultados del benchmark

En las mediciones realizadas se obtuvieron los siguientes tiempos para QuickSort:

Tiempo

10.000

1,9463 ms

50.000

4,4746 ms

100.000

8,1174 ms

Los resultados permiten observar que el tiempo registrado aumentó conforme se incrementó la cantidad de elementos.

## 8. Referencias bibliográficas

1. Coddy Tech. (2026, 1 de julio). *Quick Sort (ordenamiento rápido): algoritmo explicado*. https://coddy.tech/visualize/es/sorting/quick-sort

2. TecnoDigital. (2026, 6 de marzo). *Método de Quicksort en C y Java: Una Guía Completa*. Informatec Digital. https://informatecdigital.com/metodo-de-quicksort-en-c-y-java-una-guia-completa/

3. Sekin Team. (2026, 12 de septiembre). *Método de Quicksort en C y Java: guía completa con ejemplos*. Sekin. https://sekin.in/metodo-de-quicksort-en-c-y-java-guia-completa-con-ejemplos/

4. LabEx. (s. f.). *Algoritmo de clasificación Divide y Vencerás QuickSort eficiente*. https://labex.io/es/tutorials/java-efficient-quicksort-divide-and-conquer-algorithm-117980

